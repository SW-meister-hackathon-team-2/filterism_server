package com.group2.filterism.domain.template.domain;

import com.group2.filterism.domain.template.vo.AccessScope;
import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.template.vo.TemplateType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "template_id")
    private List<HashtagEntity> hashtags;

    private AccessScope accessScope;

    private TemplateType type;

    private Long usedCount;

    private String fileId;

    @Version
    private Long version;

    public void use() {
        usedCount++;
    }

    public void update(String title, String description, List<HashtagEntity> hashTags, AccessScope accessScope) {
        this.title = title;
        this.description = description;
        this.hashtags = hashTags;
        this.accessScope = accessScope;
    }

    @Builder
    public TemplateEntity(String title, String description, List<HashtagEntity> hashtags, AccessScope accessScope, TemplateType type, String fileId) {
        this.title = title;
        this.description = description;
        this.hashtags = hashtags;
        this.accessScope = accessScope;
        this.type = type;
        this.usedCount = 0L;
        this.fileId = fileId;
        this.version = 0L;
    }
}
