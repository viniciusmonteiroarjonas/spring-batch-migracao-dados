package com.udemy.migracao.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int idade;
}
