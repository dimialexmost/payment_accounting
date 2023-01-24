package com.example.payment_accounting.configuration;


import com.example.payment_accounting.db.MysqlDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;


@Configuration
public class Config {
    @Bean
    public MysqlDatabase mysqlDatabase (){
        return MysqlDatabase.getInstance();

    }
    @Bean
    public Connection connection(MysqlDatabase mysqlDatabase){
        return mysqlDatabase.getConnection();
    }
}
