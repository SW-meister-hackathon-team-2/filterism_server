package com.group2.filterism.domain.file.presentation;

import com.group2.filterism.domain.file.application.FileReadUseCase;
import com.group2.filterism.swagger.file.FileReadDocumentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
class FileReadController implements FileReadDocumentation {
    private final FileReadUseCase useCase;

    @GetMapping("/template/{fileId}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileId) {
        final var fileDto = useCase.read(fileId);
        final var file = new File("/Users/seungwon1/Downloads/imgs/" + fileDto.fileName());

        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf("image/" + fileDto.extension()))
                    .body(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("파일이 존재하지 않습니다.");
        }
    }
}
