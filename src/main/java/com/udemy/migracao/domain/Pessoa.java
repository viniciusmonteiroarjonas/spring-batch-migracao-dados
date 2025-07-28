package com.udemy.migracao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int idade;
}
