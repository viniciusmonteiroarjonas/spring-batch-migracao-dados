package com.udemy.migracao.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MigracaoDadosJobRequest {

    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

}