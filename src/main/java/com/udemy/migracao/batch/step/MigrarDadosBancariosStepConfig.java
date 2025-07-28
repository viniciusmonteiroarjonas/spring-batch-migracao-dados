package com.udemy.migracao.batch.step;

import com.udemy.migracao.domain.DadosBancario;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MigrarDadosBancariosStepConfig {

    @Bean(name = "migrarDadosBancariosStep")
    public Step migrarDadosBancariosStep(JobRepository jobRepository,
                                         PlatformTransactionManager transactionManager,
                                         FlatFileItemReader<DadosBancario> arquivoDadosBancariosReader,
                                         ItemWriter<DadosBancario> dadosBancarioItemWriter) {

        return new StepBuilder("migrarDadosBancariosStep", jobRepository)
                .<DadosBancario, DadosBancario>chunk(10, transactionManager)
                .reader(arquivoDadosBancariosReader)
                .writer(dadosBancarioItemWriter)
                .build();
    }
}