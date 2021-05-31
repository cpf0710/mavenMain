package com.cpf.h2service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author cpf07
 */
@SpringBootApplication
public class H2serviceApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(H2serviceApplication.class, args);
    }
    private final JdbcTemplate template;

    public H2serviceApplication(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public void run(String... args) throws Exception {
        String sql="SELECT count(*)  FROM USER_INFO";
        int count = template.queryForObject(sql, Integer.class);
        System.out.println("user count is " + count);
    }
}
