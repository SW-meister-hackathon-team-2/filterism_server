package com.group2.filterism.domain.template.presentation.dto;

import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.template.domain.TemplateEntity;
import com.group2.filterism.domain.template.vo.TemplateType;
import com.group2.filterism.domain.template.vo.AccessScope;

import java.util.List;

public record TemplateResponse(
        Long id,
        String title,
        List<HashtagEntity> hashTags,
        AccessScope accessScope,
        TemplateType type,
        Long usedCount,
        String ownerName,
        List<String> fileUrls
) {
    public static TemplateResponse create(TemplateEntity entity) {
        return new TemplateResponse(entity.getId(), entity.getTitle(), entity.getHashtags(), entity.getAccessScope(), entity.getType(), entity.getUsedCount(), entity.getOwnerName(), entity.getFileUrls());
    }
}
