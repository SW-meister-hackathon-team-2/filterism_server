package com.group2.filterism.domain.file.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
class FileReadController {

    @GetMapping("/template/{fileId}")
    String getFile(@PathVariable String fileId) {
        final var file = new File("/Users/seungwon1/Downloads/imgs/" + fileId + ".txt");

        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("파일이 존재하지 않습니다.");
        }
    }
}
