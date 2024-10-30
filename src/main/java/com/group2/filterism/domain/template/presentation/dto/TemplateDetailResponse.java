package com.group2.filterism.domain.template.presentation.dto;

import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.template.domain.TemplateEntity;
import com.group2.filterism.domain.template.vo.AccessScope;
import com.group2.filterism.domain.template.vo.TemplateType;

import java.util.List;

public record TemplateDetailResponse(
        Long id,
        String title,
        String description,
        List<HashtagEntity> hashTags,
        AccessScope accessScope,
        TemplateType type,
        List<String> images,
        Long usedCount,
        String ownerName
) {
    public static TemplateDetailResponse create(TemplateEntity entity) {
        return new TemplateDetailResponse(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getHashtags(), entity.getAccessScope(), entity.getType(), entity.getFileUrls(), entity.getUsedCount(), entity.getOwnerName());
    }
}
