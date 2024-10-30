package com.group2.filterism;

import com.group2.filterism.http.ListResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;

@SpringBootApplication
public class FilterismApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterismApplication.class, args);
    }

}

@Controller
class HealthController {
    @GetMapping("/health")
    String healthCheck() {
        return "stil; alive!";
    }
}

@RestController
class ExampleFilterController {
    @GetMapping("/api/filter/examples")
    ListResponse<String> getExamples() {
        final var files = new File("/Users/seungwon1/Downloads/filterexamples");

        files.list();

        // /Users/seungwon1/Downloads/filterexamples
        return null;
    }
}
