package com.group2.filterism.hashtag.presentation;

import com.group2.filterism.hashtag.domain.HashtagEntity;

public record HashtagResponse(
        Long id,
        String name
) {
    public static HashtagResponse create(HashtagEntity entity) {
        return new HashtagResponse(entity.getId(), entity.getName());
    }

}
