package com.group2.filterism.template.domain;

import com.group2.filterism.template.vo.AccessScope;
import com.group2.filterism.hashtag.domain.HashtagEntity;
import com.group2.filterism.template.vo.TemplateType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "filter")
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @JoinTable(name = "hashtag")
    @ManyToMany(targetEntity = HashtagEntity.class)
    private List<HashtagEntity> hashTags;

    private AccessScope accessScope;

    private TemplateType type;

    private Long usedCount;

    private String fileName;

    @Version
    private Long version;

    @Builder
    public TemplateEntity(String title, String description, List<HashtagEntity> hashTags, AccessScope accessScope, TemplateType type, Long usedCount, String fileName) {
        this.title = title;
        this.description = description;
        this.hashTags = hashTags;
        this.accessScope = accessScope;
        this.type = type;
        this.usedCount = usedCount;
        this.fileName = fileName;
    }
}
