package com.group2.filterism.domain.template.presentation.dto;

import com.group2.filterism.domain.template.vo.AccessScope;
import com.group2.filterism.domain.template.vo.TemplateType;

import java.util.List;

public record TemplateCreateForm(
        String title,
        String description,
        TemplateType type,
        AccessScope accessScope,
        List<Long> hashtags,
        String base64Image
) {
}
