package com.udemy.migracao.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
