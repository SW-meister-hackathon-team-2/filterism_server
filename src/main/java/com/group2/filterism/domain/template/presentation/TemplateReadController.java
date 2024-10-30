package com.group2.filterism.domain.template.presentation;

import com.group2.filterism.domain.template.application.TemplateReadUseCase;
import com.group2.filterism.domain.template.presentation.dto.TemplateDetailResponse;
import com.group2.filterism.domain.template.presentation.dto.TemplateResponse;
import com.group2.filterism.global.http.ListResponse;
import com.group2.filterism.swagger.template.TemplateReadDocumentation;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/template")
@CrossOrigin(origins = "*")
class TemplateReadController implements TemplateReadDocumentation {
    private final TemplateReadUseCase useCase;

    @GetMapping
    public ListResponse<TemplateResponse> getAllPublicTemplate() {
        return new ListResponse<>(useCase.getAllPublicTemplate());
    }

    @GetMapping("/{templateId}")
    public TemplateDetailResponse getDetailTemplateByToken(@PathVariable String templateId) {
        return useCase.getDetailTemplateByToken(templateId);
    }


    @GetMapping("/search")
    public ListResponse<TemplateResponse> search(
            @RequestParam @Nullable String text,
            @RequestParam @Nullable String hashtags
    ) {
        final var fixedText = text != null
                ? text.replace('_', ' ')
                : "";

        final Set<Long> hashtagIds = hashtags != null
                ? Arrays.stream(hashtags.split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toUnmodifiableSet())
                : Collections.emptySet();

        return new ListResponse<>(useCase.search(fixedText, hashtagIds));
    }

    @GetMapping("/my")
    public ListResponse<TemplateResponse> getMyTemplate() {
        return new ListResponse<>(useCase.getMyTemplate());
    }
}
