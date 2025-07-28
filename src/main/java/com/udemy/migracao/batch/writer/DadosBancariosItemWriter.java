package com.udemy.migracao.batch.writer;

import com.udemy.migracao.domain.DadosBancario;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DadosBancariosItemWriter  {

    @Bean
    public JdbcBatchItemWriter<DadosBancario> dadosBancarioWriter(
            @Qualifier("appDataSource")DataSource dataSource
            ) {
        return new JdbcBatchItemWriterBuilder()
                .dataSource(dataSource)
                .sql("INSERT INTO dados_bancarios (id, pessoa_id, agencia, conta,banco) VALUES (:id, :pessoaId, :agencia, :conta, :banco)")
                .beanMapped()
                .build();
    }

}
