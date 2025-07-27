package com.udemy.migracao.config.database;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayBatchConfig {

    @Bean(name = "flywayBatch", initMethod = "migrate")
    public Flyway flywayBatch(@Qualifier("batchDataSource") DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration-batch")
                .baselineOnMigrate(true)
                .load();
    }
}