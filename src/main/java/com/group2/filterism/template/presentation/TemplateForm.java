package com.group2.filterism.template.presentation;

import com.group2.filterism.template.vo.AccessScope;

public record TemplateForm(
        String title,
        String description,
        // hashtag
        AccessScope accessScope
) {
}
