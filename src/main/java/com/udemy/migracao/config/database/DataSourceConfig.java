package com.udemy.migracao.config.database;

import com.udemy.migracao.config.app.ApplicationPropetiesConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class DataSourceConfig {

    private final ApplicationPropetiesConfig applicationPropetiesConfig;

    @Bean(name = "appDataSource")
    public DataSource appDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(applicationPropetiesConfig.getAppDatasourceUrl());
        config.setUsername(applicationPropetiesConfig.getAppDatasourceUsername());
        config.setPassword(applicationPropetiesConfig.getAppDatasourcePassword());
        config.setDriverClassName(applicationPropetiesConfig.getAppDatasourceDriverClassName());

        return new HikariDataSource(config);
    }

    @Bean(name = {"batchDataSource", "dataSource"})
    public DataSource batchDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(applicationPropetiesConfig.getBatchDatasourceUrl());
        config.setUsername(applicationPropetiesConfig.getBatchDatasourceUsername());
        config.setPassword(applicationPropetiesConfig.getBatchDatasourcePassword());
        config.setDriverClassName(applicationPropetiesConfig.getBatchDatasourceDriverClassName());
        return new HikariDataSource(config);
    }

}
