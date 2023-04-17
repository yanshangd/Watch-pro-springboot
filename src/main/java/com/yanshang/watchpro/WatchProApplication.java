package com.yanshang.watchpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WatchProApplication {

    public static void main(String[] args) {

        SpringApplication.run(WatchProApplication.class, args);
    }

}
