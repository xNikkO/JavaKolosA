package com.westeros.data;

import com.westeros.data.repositories.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WesterosDataApplication implements CommandLineRunner {
private final CompanyRepository companyRepo;

    public WesterosDataApplication(CompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(WesterosDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        companyRepo.flush();
    }
}
