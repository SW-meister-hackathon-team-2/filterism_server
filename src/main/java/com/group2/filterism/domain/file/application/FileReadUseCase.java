package com.group2.filterism.domain.file.application;

import com.group2.filterism.domain.file.domain.FileJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface FileReadUseCase {
    FileReadApplicationDto read(String id);
}

@Service
@RequiredArgsConstructor
class FileReadUseCaseImpl implements FileReadUseCase {
    private final FileJpaRepository fileJpaRepository;

    @Override
    public FileReadApplicationDto read(final String id) {
        final var fileEntity = fileJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("파일 못 찾음 ㅋ"));

        return new FileReadApplicationDto(fileEntity.getFileName(), fileEntity.getExtension());
    }
}
