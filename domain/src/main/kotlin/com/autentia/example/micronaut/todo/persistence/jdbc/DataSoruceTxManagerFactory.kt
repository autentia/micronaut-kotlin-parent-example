package com.autentia.example.micronaut.todo.persistence.jdbc

import io.micronaut.context.annotation.Factory
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager

import javax.inject.Singleton
import javax.sql.DataSource

@Factory
internal class DataSourceTxManagerFactory {

    @Singleton
    internal fun transactionManager(dataSource: DataSource): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    @Singleton
    internal fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

}
