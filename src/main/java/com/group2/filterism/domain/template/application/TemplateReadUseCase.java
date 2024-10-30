package com.group2.filterism.domain.template.application;

import com.group2.filterism.domain.template.domain.TemplateJpaRepository;
import com.group2.filterism.domain.template.presentation.dto.TemplateDetailResponse;
import com.group2.filterism.domain.template.presentation.dto.TemplateResponse;
import com.group2.filterism.domain.user.application.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface TemplateReadUseCase {
    List<TemplateResponse> getAllPublicTemplate();
    TemplateDetailResponse getDetailPublicTemplate(Long id);
    TemplateDetailResponse getDetailTemplateByToken(String key);
    List<TemplateResponse> search(String text, Set<Long> hashtags);
    List<TemplateResponse> getMyTemplate();
}

@Service
@RequiredArgsConstructor
class TemplateReadUseCaseImpl implements TemplateReadUseCase {
    private final TemplateJpaRepository repository;
    private final CurrentUser currentUser;

    @Override
    public List<TemplateResponse> getAllPublicTemplate() {
        final var entities = repository.findAllPublicTemplate();

        return entities.stream()
                .map(TemplateResponse::create)
                .toList();
    }

    @Override
    public TemplateDetailResponse getDetailPublicTemplate(final Long id) {
        final var entity = repository.findPublicTemplateById(id)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        return TemplateDetailResponse.create(entity);
    }

    @Override
    public TemplateDetailResponse getDetailTemplateByToken(final String key) {
        final var entity = repository.findByTemplateId(key)
                .orElseThrow(() -> new IllegalArgumentException("템플릿을 찾지 못했습니다."));

        return TemplateDetailResponse.create(entity);
    }

    @Override
    public List<TemplateResponse> search(final String text, final Set<Long> hashtags) {
        final var entities = repository.search(text, hashtags);

        return entities.stream()
                .map(TemplateResponse::create)
                .toList();
    }

    @Override
    public List<TemplateResponse> getMyTemplate() {
        final var user = currentUser.get();
        final var entities = repository.findAllByOwnerId(user.getId());

        return entities.stream()
                .map(TemplateResponse::create)
                .toList();
    }
}
