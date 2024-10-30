package com.group2.filterism.domain.template.presentation;

import com.group2.filterism.domain.template.application.TemplateWriteUseCase;
import com.group2.filterism.domain.template.presentation.dto.TemplateCreateForm;
import com.group2.filterism.domain.template.presentation.dto.TemplateUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/template")
public class TemplateWriteController {
    private final TemplateWriteUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody TemplateCreateForm form) {
        useCase.create(form);
    }

    @PutMapping("/{templateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(
            @RequestBody TemplateUpdateForm form,
            @PathVariable Long templateId
    ) {
        useCase.update(form, templateId);
    }

    @PatchMapping("/{templateId}/use")
    void use(@PathVariable Long templateId) {
        useCase.use(templateId);
    }

    @DeleteMapping("/{templateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long templateId) {
        useCase.delete(templateId);
    }
}
