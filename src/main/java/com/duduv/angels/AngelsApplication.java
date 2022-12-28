package com.duduv.angels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngelsApplication implements CommandLineRunner {

    @Autowired
    private DrawService drawService;

    public static void main(String[] args) {
        SpringApplication.run(AngelsApplication.class, args);
    }


    @Override
    public void run(String... args) {
        if (args.length > 0) {
            drawService.draw(args[0]);
        } else {
            drawService.draw("adults");
        }
    }
}
