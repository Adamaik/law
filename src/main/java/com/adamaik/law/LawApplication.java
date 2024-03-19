package com.adamaik.law;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Adamaik
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class LawApplication {

    public static void main(String[] args) {
        SpringApplication.run(LawApplication.class, args);
    }

}
