package com.group2.filterism.template.presentation.dto;

import java.util.List;

public record TemplateUpdateForm(
        String title,
        String description,
        List<Long> hashtags
) {
}
