package com.group2.filterism.template.application;

import com.group2.filterism.hashtag.domain.HashtagJpaRepository;
import com.group2.filterism.template.domain.TemplateEntity;
import com.group2.filterism.template.domain.TemplateJpaRepository;
import com.group2.filterism.template.presentation.dto.TemplateCreateForm;
import com.group2.filterism.template.presentation.dto.TemplateUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public interface TemplateWriteUseCase {
    void create(TemplateCreateForm form);
    void update(TemplateUpdateForm form, Long id);
    void delete(Long id);
    void use(Long id);
}

@Service
@RequiredArgsConstructor
class TemplateWriteUseCaseImpl implements TemplateWriteUseCase {
    private final TemplateJpaRepository templateJpaRepository;
    private final HashtagJpaRepository hashtagJpaRepository;

    private static final Path rootPath = Paths.get("/Users/seungwon1/Downloads/imgs");

    private static final List<String> extensions = List.of(
            "jpg", "jpeg", "png"
    );

    @Override
    @Transactional
    public void create(TemplateCreateForm form) {
        final var hashtags = hashtagJpaRepository.findAllById(form.hashtags());

        final var base64Image = form.base64Image();
        final var parts = base64Image.split(",");

        final var extension = parts[0].split("/")[1].replaceAll(";base64", "");

        if (!extensions.contains(extension.toLowerCase())) {
            throw new IllegalArgumentException("확장자를 확인해주세요.");
        }

        final var bytes = base64Image.getBytes();

        final var uuid = UUID.randomUUID().toString();
        final var filePath = rootPath + "/" + uuid + ".txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException("파일 생성 또는 저장 실패", e);
        }

        final var template = TemplateEntity.builder()
                .title(form.title())
                .description(form.description())
                .hashTags(hashtags)
                .type(form.type())
                .fileId(uuid)
                .build();

        templateJpaRepository.save(template);
    }

    @Override
    @Transactional
    public void update(final TemplateUpdateForm form, final Long id) {
        final var template = templateJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        final var hashtags = hashtagJpaRepository.findAllById(form.hashtags());

        template.update(form.title(), form.description(), hashtags);
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        // TODO: 10/29/24 유저 검증 로직 추가해야함.
        templateJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void use(final Long id) {
        final var template = templateJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        template.use();
    }
}
