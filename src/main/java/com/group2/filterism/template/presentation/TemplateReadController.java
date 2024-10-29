package com.group2.filterism.template.presentation;

import com.group2.filterism.http.ListResponse;
import com.group2.filterism.template.application.TemplateReadUseCase;
import com.group2.filterism.template.presentation.dto.TemplateDetailResponse;
import com.group2.filterism.template.presentation.dto.TemplateResponse;
import com.group2.filterism.template.vo.AccessScope;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
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
class TemplateReadController {
    private final TemplateReadUseCase useCase;

    @GetMapping
    ListResponse<TemplateResponse> getAllPublicTemplate() {
        return new ListResponse<>(useCase.getAllPublicTemplate());
    }

    @GetMapping("/{templateId}")
    TemplateDetailResponse getDetailTemplate(@PathVariable Long templateId) {
        return useCase.getDetailTemplate(templateId);
    }

    @GetMapping("/search")
    ListResponse<TemplateResponse> search(
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
}
