package com.group2.filterism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FilterismApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterismApplication.class, args);
    }

}
