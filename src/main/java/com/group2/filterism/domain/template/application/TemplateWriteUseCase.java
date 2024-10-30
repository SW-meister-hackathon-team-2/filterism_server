package com.group2.filterism.domain.template.application;

import com.group2.filterism.domain.file.domain.FileEntity;
import com.group2.filterism.domain.file.domain.FileJpaRepository;
import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.hashtag.domain.HashtagJpaRepository;
import com.group2.filterism.domain.template.domain.TemplateEntity;
import com.group2.filterism.domain.template.domain.TemplateJpaRepository;
import com.group2.filterism.domain.template.presentation.dto.TemplateCreateForm;
import com.group2.filterism.domain.template.presentation.dto.TemplateUpdateForm;
import com.group2.filterism.domain.user.application.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface TemplateWriteUseCase {
    String create(TemplateCreateForm form, List<MultipartFile> files);
    void update(TemplateUpdateForm form, Long id);
    void delete(Long id);
    void use(Long id);
    void setUser(String templateId);
}

@Service
@RequiredArgsConstructor
class TemplateWriteUseCaseImpl implements TemplateWriteUseCase {
    private final TemplateJpaRepository templateJpaRepository;
    private final HashtagJpaRepository hashtagJpaRepository;
    private final FileJpaRepository fileJpaRepository;
    private final CurrentUser currentUser;

    @Value("${base.url}")
    private String baseUrl;

    private static final Path rootPath = Paths.get("/Users/seungwon1/Downloads/imgs");

    private static final List<String> extensions = List.of(
            "jpg", "jpeg", "png"
    );

    @Override
    @Transactional
    public String create(TemplateCreateForm form, List<MultipartFile> files) {
        final var hashtagsResult = hashtagJpaRepository.findAllById(form.hashtagIds());
        final List<HashtagEntity> hashtags = hashtagsResult.isEmpty()
                ? Collections.emptyList()
                : hashtagsResult;

        final var fileUrls = new LinkedList<String>();

        for (MultipartFile file: files) {
            final var originalFilename = file.getOriginalFilename();

            if (originalFilename == null) {
                throw new IllegalArgumentException();
            }

            final var extension = originalFilename.split("\\.")[1].toLowerCase();
            if (!extensions.contains(extension)) {
                throw new IllegalArgumentException("확장자를 확인해주세요.");
            }

            final var uuid = UUID.randomUUID().toString();
            final var path = uuid + "." + extension;
            final var finalPath = rootPath + "/" + path;

            try {
                file.transferTo(new File(finalPath));
                final var savedFile = fileJpaRepository.save(FileEntity.create(path, extension));

                fileUrls.add(baseUrl + "/api/file/template/" + (savedFile.getId()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalArgumentException();
            }
        }


        final var template = TemplateEntity.builder()
                .title(form.title())
                .hashtags(hashtags)
                .type(form.type())
                .fileUrls(fileUrls)
                .build();

        final var savedTemplate = templateJpaRepository.save(template);

        return savedTemplate.getTemplateId();
    }

    @Override
    @Transactional
    public void update(final TemplateUpdateForm form, final Long id) {
        final var template = templateJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        final var hashtags = hashtagJpaRepository.findAllById(form.hashtagIds());

        template.update(form.title(), form.description(), hashtags, form.accessScope());
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        final var user = currentUser.get();
        final var template = templateJpaRepository.findById(id)
                .orElseThrow();

        if (!Objects.equals(user.getId(), template.getOwnerId())) {
            throw new IllegalArgumentException();
        }

        templateJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void use(final Long id) {
        final var template = templateJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        template.use();
    }

    @Override
    @Transactional
    public void setUser(final String templateId) {
        final var user = currentUser.get();
        final var template = templateJpaRepository.findByTemplateId(templateId)
                .orElseThrow();

        if (template.getOwnerId() != -1) {
            throw new IllegalStateException();
        }

        template.setOwnerId(user.getId());
        template.setOwnerName(user.getName());
    }
}
