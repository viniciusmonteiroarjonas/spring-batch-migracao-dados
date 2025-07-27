package com.udemy.migracao.config.app;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationPropetiesConfig {

    @Value("${batch.datasource.url}")
    private String batchDatasourceUrl;

    @Value("${batch.datasource.username}")
    private String batchDatasourceUsername;

    @Value("${batch.datasource.password}")
    private String batchDatasourcePassword;

    @Value("${batch.datasource.driver-class-name}")
    private String batchDatasourceDriverClassName;

    @Value("${app.datasource.url}")
    private String appDatasourceUrl;

    @Value("${app.datasource.username}")
    private String appDatasourceUsername;

    @Value("${app.datasource.password}")
    private String appDatasourcePassword;

    @Value("${app.datasource.driver-class-name}")
    private String appDatasourceDriverClassName;


}