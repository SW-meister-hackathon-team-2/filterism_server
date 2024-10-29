package com.group2.filterism.template.application;

import com.group2.filterism.hashtag.domain.HashtagJpaRepository;
import com.group2.filterism.template.domain.TemplateEntity;
import com.group2.filterism.template.domain.TemplateJpaRepository;
import com.group2.filterism.template.presentation.TemplateCreateForm;
import com.group2.filterism.template.presentation.TemplateUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface TemplateWriteUseCase {
    void create(TemplateCreateForm form, MultipartFile file);
    void update(TemplateUpdateForm form, final Long id);
}

@Service
@RequiredArgsConstructor
class TemplateWriteUseCaseImpl implements TemplateWriteUseCase {
    private final TemplateJpaRepository templateJpaRepository;
    private final HashtagJpaRepository hashtagJpaRepository;

    private static final Path rootPath = Paths.get("C:\\");

    private static final List<String> extensions = List.of(
            "jpg", "jpeg", "png"
    );

    @Override
    public void create(TemplateCreateForm form, MultipartFile file) {
        final var hashtags = hashtagJpaRepository.findAllById(form.hashtags());
        final var originalFileName = Objects.requireNonNull(file.getOriginalFilename());
        final var extension = file.getOriginalFilename().split("\\.")[1].toLowerCase();

        if (!extensions.contains(extension)) {
            throw new IllegalArgumentException("\"jpg\", \"jpeg\", \"png\"가 아닌 파일 확장자입니다.");
        }

        final var fileName = StringUtils.cleanPath(originalFileName);

        if (!fileName.contains("..")) {
            throw new IllegalArgumentException("파일 명에 ..이 들어갈 수 없습니다.");
        }

        final var template = TemplateEntity.builder()
                .title(form.title())
                .description(form.description())
                .hashTags(hashtags)
                .accessScope(form.accessScope())
                .type(form.type())
                .fileName(fileName)
                .build();

        try {
            file.transferTo(new File(rootPath + fileName + ":" + UUID.randomUUID().toString().substring(1, 10)));
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 실패");
        }

        templateJpaRepository.save(template);
    }

    @Override
    @Transactional
    public void update(final TemplateUpdateForm form, final Long id) {
        final var template = templateJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        final var hashtags = hashtagJpaRepository.findAllById(form.hashtags());

        template.update(form.title(), form.description(), hashtags, form.accessScope());
    }
}
