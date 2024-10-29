package com.group2.filterism.template.presentation.dto;

import com.group2.filterism.hashtag.domain.HashtagEntity;
import com.group2.filterism.template.domain.TemplateEntity;
import com.group2.filterism.template.vo.AccessScope;
import com.group2.filterism.template.vo.TemplateType;

import java.util.List;

public record TemplateDetailResponse(
        Long id,
        String title,
        String description,
        List<HashtagEntity> hashTags,
        AccessScope accessScope,
        TemplateType type,
        Long usedCount
) {
    public static TemplateDetailResponse create(TemplateEntity entity) {
        return new TemplateDetailResponse(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getHashTags(), entity.getAccessScope(), entity.getType(), entity.getUsedCount());
    }
}
