package com.udemy.migracao.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;


@EnableBatchProcessing
@Configuration
public class MigracaoDadosJobConfig {

    @Bean
    public Job migracaoDadosJob(
            JobRepository jobRepository,
            Step migrarPessoasStep,
            Step migrarDadosBancariosStep
    ) {
        return new JobBuilder("migracaoDadosJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(migrarPessoasStep)
                .next(migrarDadosBancariosStep)
                .build();
    }


    @Bean
    public Job migracaoDadosParaleloJob(
            JobRepository jobRepository,
            Step migrarPessoasStep,
            Step migrarDadosBancariosStep
    ) {
        return new JobBuilder("migracaoDadosParaleloJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(stepsParalelos(migrarPessoasStep, migrarDadosBancariosStep))
                .end()
                .incrementer(new RunIdIncrementer())
                .build();
    }

    private Flow stepsParalelos(Step migrarPessoasStep, Step migrarDadosBancariosStep) {
        Flow migrarDadosBancariosFlow = new FlowBuilder<Flow>("migrarDadosBancariosFlow")
                .start(migrarDadosBancariosStep)
                .build();

        return new FlowBuilder<Flow>("stepsParalelosFlow")
                .start(migrarPessoasStep)
                .split(new SimpleAsyncTaskExecutor())
                .add(migrarDadosBancariosFlow)
                .build();
    }

}
