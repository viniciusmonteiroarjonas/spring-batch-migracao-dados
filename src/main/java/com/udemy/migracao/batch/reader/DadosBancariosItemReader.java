package com.udemy.migracao.batch.reader;

import com.udemy.migracao.domain.DadosBancario;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class DadosBancariosItemReader {

    @Bean
    public FlatFileItemReader<DadosBancario> arquivoDadosBancariosReader() {
        return new FlatFileItemReaderBuilder<DadosBancario>()
                .name("arquivoDadosBancariosReader")
                .resource(new FileSystemResource("files/dados_bancarios.csv"))
                .delimited()
                .names("pessoaId", "agencia", "conta", "banco", "id")
                .addComment("--")
                .fieldSetMapper(fieldSetMapper())
                .build();
    }

    private FieldSetMapper<DadosBancario> fieldSetMapper() {
        return new FieldSetMapper<DadosBancario>() {
            @Override
            public DadosBancario mapFieldSet(FieldSet fieldSet) {
                DadosBancario dados = new DadosBancario();
                dados.setPessoaId(fieldSet.readInt("pessoaId"));
                dados.setAgencia(fieldSet.readInt("agencia"));
                dados.setConta(fieldSet.readInt("conta"));
                dados.setBanco(fieldSet.readInt("banco"));
                dados.setId(fieldSet.readInt("id"));
                return dados;
            }
        };
    }
}