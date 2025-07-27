package com.udemy.migracao.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DadosBancario {
    private int id;
    private int nome;
    private int pessoaId;
    private int agencia;
    private int conta;
    private int banco;
}
