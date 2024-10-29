package com.group2.filterism.template.presentation;

import com.group2.filterism.template.vo.AccessScope;

import java.util.List;

public record TemplateUpdateForm(
        String title,
        String description,
        AccessScope accessScope,
        List<Long> hashtags
) {
}
