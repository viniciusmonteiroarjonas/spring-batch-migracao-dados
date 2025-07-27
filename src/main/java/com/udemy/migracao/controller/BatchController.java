package com.udemy.migracao.controller;

import com.udemy.migracao.controller.dto.MigracaoJobRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class BatchController {

//    private final JobLauncher jobLauncher;
//    private final Job imprimeOlaJob;
//
//    @PostMapping("/start")
//    @Operation(summary = "Executa o job imprimeOlaJob", description = "Dispara o job de exemplo com o nome informado via corpo da requisição")
//    public ResponseEntity<String> startJob(@Valid @RequestBody MigracaoJobRequest request) {
//        try {
//            String nome = request.getNome();
//
//            JobParameters jobParameters = new JobParametersBuilder()
//                    .addString("nome", nome)
//                    .addLong("startAt", System.currentTimeMillis())
//                    .toJobParameters();
//
//            JobExecution jobExecution = jobLauncher.run(imprimeOlaJob, jobParameters);
//
//            return ResponseEntity.ok("Job iniciado com status: " + jobExecution.getStatus());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Erro ao iniciar o Job: " + e.getMessage());
//        }
//    }

}
