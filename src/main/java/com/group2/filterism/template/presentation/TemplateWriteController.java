package com.group2.filterism.template.presentation;

import com.group2.filterism.template.application.TemplateWriteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/template")
public class TemplateWriteController {
    private final TemplateWriteUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(
            @RequestPart("body") TemplateCreateForm form,
            @RequestPart("file") MultipartFile file
    ) {
        useCase.create(form, file);
    }

    @PutMapping("/{templateId}")
    void update(
            @RequestBody TemplateUpdateForm form,
            @PathVariable Long templateId
    ) {
        useCase.update(form, templateId);
    }
}
