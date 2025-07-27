package com.udemy.migracao.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

//@EnableBatchProcessing
//@Configuration
//public class MigracaoJobSpringBatchConfig {
//
//    @Bean
//    public Job imprimeOlaJob(JobRepository jobRepository, Step imprimeOlaStep) {
//        return new JobBuilder("imprimeOlaJob", jobRepository)
//                .start(imprimeOlaStep)
//                .build();
//    }
//
//
//    @Bean
//    public Step imprimeOlaStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("imprimeOlaStep", jobRepository)
//                .tasklet((contribution, chunkContext) -> {
//                    String nome = (String) chunkContext.getStepContext()
//                            .getJobParameters()
//                            .get("nome");
//
//                    return RepeatStatus.FINISHED;
//                }, transactionManager)
//                .build();
//    }
//}
