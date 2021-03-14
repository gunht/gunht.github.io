package com.example.moneyconveter;

import com.example.moneyconveter.model.CurrencyCode;
import com.example.moneyconveter.service.MoneyConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class MoneyconveterApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(MoneyconveterApplication.class, args);
    }

}
