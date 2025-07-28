package com.udemy.migracao.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class BatchController {

    private final JobLauncher jobLauncher;
    private final Job migracaodados;

    @GetMapping("/migracaodados")
    @Operation(summary = "Executa o job migracaoDadosJob", description = "Dispara o job migracaoDadosJob")
    public ResponseEntity<String> startMigracaoDadosJob() {
        try {

            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(migracaodados, jobParameters);
            return ResponseEntity.ok("Job iniciado com status: " + jobExecution.getStatus());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao iniciar o Job: " + e.getMessage());
        }
    }

}
