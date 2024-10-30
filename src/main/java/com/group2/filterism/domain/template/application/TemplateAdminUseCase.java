package com.group2.filterism.domain.template.application;

import com.group2.filterism.domain.template.domain.TemplateEntity;
import com.group2.filterism.domain.template.domain.TemplateJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

public interface TemplateAdminUseCase {
    void reject(Long id);
    void accept(Long id);
}

// TODO: 10/30/24 유저 어드민 role 검증 필요
@Service
@Transactional
@RequiredArgsConstructor
class TemplateAdminUseCaseImpl implements TemplateAdminUseCase {
    private final TemplateJpaRepository repository;

    @Override
    public void reject(final Long id) {
        process(id, TemplateEntity::reject);
    }

    @Override
    public void accept(final Long id) {
        process(id, TemplateEntity::accept);
    }

    private void process(final Long id, final Consumer<TemplateEntity> function) {
        final var entity = repository.findPendingTemplateById(id)
                .orElseThrow();

        function.accept(entity);
    }
}
