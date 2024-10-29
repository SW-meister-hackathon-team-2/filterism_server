package com.group2.filterism.template.presentation.dto;

import com.group2.filterism.hashtag.domain.HashtagEntity;
import com.group2.filterism.template.domain.TemplateEntity;
import com.group2.filterism.template.vo.AccessScope;
import com.group2.filterism.template.vo.TemplateType;

import java.util.List;

public record TemplateResponse(
        Long id,
        String title,
        List<HashtagEntity> hashTags,
        AccessScope accessScope,
        TemplateType type,
        Long usedCount,
        String fileId
) {
    public static TemplateResponse create(TemplateEntity entity) {
        return new TemplateResponse(entity.getId(), entity.getTitle(), entity.getHashtags(), entity.getAccessScope(), entity.getType(), entity.getUsedCount(), entity.getFileId());
    }
}
