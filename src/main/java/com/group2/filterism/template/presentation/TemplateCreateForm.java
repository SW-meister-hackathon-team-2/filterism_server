package com.group2.filterism.template.presentation;

import com.group2.filterism.template.vo.AccessScope;
import com.group2.filterism.template.vo.TemplateType;

import java.util.List;

public record TemplateCreateForm(
        String title,
        String description,
        AccessScope accessScope,
        TemplateType type,
        List<Long> hashtags
) {
}
