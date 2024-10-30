package com.group2.filterism.domain.template.presentation.dto;

import com.group2.filterism.domain.template.vo.AccessScope;

import java.util.List;

public record TemplateUpdateForm(
        String title,
        String description,
        AccessScope accessScope,
        List<Long> hashtagIds
) {
}
