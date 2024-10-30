package com.group2.filterism.domain.template.presentation.dto;

import com.group2.filterism.domain.template.vo.TemplateType;

import java.util.List;

public record TemplateCreateForm(
        String title,
        TemplateType type,
        List<Long> hashtagIds
) {
}
