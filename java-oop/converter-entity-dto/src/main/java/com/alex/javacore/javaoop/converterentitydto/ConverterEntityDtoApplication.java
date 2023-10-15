package com.alex.javacore.javaoop.converterentitydto;

import com.alex.javacore.javaoop.converterentitydto.entity.UserEntity;
import com.alex.javacore.javaoop.converterentitydto.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConverterEntityDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConverterEntityDtoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(UserRepository repo) {
        return args -> {
            repo.save(new UserEntity("user01", "last-user01", "Russian", 10001));
            repo.save(new UserEntity("user02", "last-user02", "Russian", 10002));
            repo.save(new UserEntity("user03", "last-user03", "Germany", 10003));
            repo.save(new UserEntity("user04", "last-user04", "Russian", 10004));
            repo.save(new UserEntity("user05", "last-user05", "Russian", 10005));
        };
    }

}
