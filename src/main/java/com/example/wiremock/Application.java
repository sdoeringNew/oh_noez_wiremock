package com.example.wiremock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final FeignApi feignApi;

    public Application(final FeignApi feignApi) {
        this.feignApi = feignApi;
    }

    @Override
    public void run(final String[] args) {
        if (args.length != 0) {
            feignApi.test(Collections.singletonMap("status", false));
        }
    }
}
