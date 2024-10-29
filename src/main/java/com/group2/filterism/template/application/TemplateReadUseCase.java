package com.group2.filterism.template.application;

import com.group2.filterism.template.domain.TemplateJpaRepository;
import com.group2.filterism.template.presentation.dto.TemplateDetailResponse;
import com.group2.filterism.template.presentation.dto.TemplateResponse;
import com.group2.filterism.template.vo.AccessScope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface TemplateReadUseCase {
    List<TemplateResponse> getAllPublicTemplate();
    TemplateDetailResponse getDetailTemplate(Long id);
    List<TemplateResponse> search(String text, Set<Long> hashtags);
}

@Service
@RequiredArgsConstructor
class TemplateReadUseCaseImpl implements TemplateReadUseCase {
    private final TemplateJpaRepository repository;

    @Override
    public List<TemplateResponse> getAllPublicTemplate() {
        final var entities = repository.findAllPublicTemplate();

        return entities.stream()
                .map(TemplateResponse::create)
                .toList();
    }

    @Override
    public TemplateDetailResponse getDetailTemplate(final Long id) {
        final var entity = repository.findById(id)
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
}
