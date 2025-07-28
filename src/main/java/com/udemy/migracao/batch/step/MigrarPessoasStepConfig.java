package com.udemy.migracao.batch.step;

import com.udemy.migracao.domain.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MigrarPessoasStepConfig {

    @Bean(name = "migrarPessoasStep")
    public Step migrarPessoasStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<Pessoa> arquivoPessoaReader,
            ClassifierCompositeItemWriter<Pessoa> pessoaClassifierCompositeItemWriter,
            FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter
    ) {

        return new StepBuilder("migrarPessoasStep", jobRepository)
                .<Pessoa, Pessoa>chunk(100, transactionManager)
                .reader(arquivoPessoaReader)
                .writer(pessoaClassifierCompositeItemWriter)
                .stream(arquivoPessoasInvalidasWriter)
                .build();
    }
}

