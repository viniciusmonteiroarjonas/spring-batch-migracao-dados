package com.udemy.migracao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosBancario {
    private int id;
    private String nome;
    private int pessoaId;
    private int agencia;
    private int conta;
    private int banco;
}
