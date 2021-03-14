package com.example.spring_02.config;

import com.example.spring_02.respository.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {
    @Bean
    public BookDao bookDao() {
        return new BookDao("store.csv");
    }
}
