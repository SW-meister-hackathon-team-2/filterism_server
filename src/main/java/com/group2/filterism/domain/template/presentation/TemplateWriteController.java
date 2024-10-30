package com.group2.filterism.domain.template.presentation;

import com.group2.filterism.domain.template.application.TemplateWriteUseCase;
import com.group2.filterism.domain.template.presentation.dto.TemplateCreateForm;
import com.group2.filterism.domain.template.presentation.dto.TemplateUpdateForm;
import com.group2.filterism.http.ListResponse;
import com.group2.filterism.swagger.template.TemplateWriteDocumentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/template")
public class TemplateWriteController implements TemplateWriteDocumentation {
    private final TemplateWriteUseCase useCase;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ListResponse<String> create(
            @RequestPart("form") TemplateCreateForm form,
            @RequestPart("files") List<MultipartFile> files
    ) {
        return new ListResponse(useCase.create(form, files));
    }

    @PutMapping("/{templateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @RequestBody TemplateUpdateForm form,
            @PathVariable Long templateId
    ) {
        useCase.update(form, templateId);
    }

    @PatchMapping("/{templateId}/use")
    public void use(@PathVariable Long templateId) {
        useCase.use(templateId);
    }

    @DeleteMapping("/{templateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long templateId) {
        useCase.delete(templateId);
    }
}
