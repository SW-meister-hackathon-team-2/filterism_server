package com.group2.filterism.filter.domain;

import com.group2.filterism.filter.vo.AccessScope;
import com.group2.filterism.hashtag.domain.Hashtag;

import java.util.List;

public record FilterDomainDto(
        String id,
        String title,
        String description,
        List<Hashtag>hashTags,
        AccessScope accessScope,
        Long usedCount,
        String fileName
) {
}
