package com.group2.filterism.filter.domain;

import com.group2.filterism.filter.vo.AccessScope;
import com.group2.filterism.hashtag.domain.HashtagEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@NoArgsConstructor
@Document
public class FilterEntity {

    @Id
    private String id;

    private String title;

    private String description;

    @DBRef
    private List<HashtagEntity> hashTags;

    private AccessScope accessScope;

    private Long usedCount;

    private String fileName;

    @Version
    private Long version;

    @Builder
    public FilterEntity(String title, String description, List<HashtagEntity> hashTags, AccessScope accessScope, Long usedCount, String fileName) {
        this.title = title;
        this.description = description;
        this.hashTags = hashTags;
        this.accessScope = accessScope;
        this.usedCount = usedCount;
        this.fileName = fileName;
    }
}
