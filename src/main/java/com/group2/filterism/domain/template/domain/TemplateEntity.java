package com.group2.filterism.domain.template.domain;

import com.group2.filterism.domain.template.vo.AccessScope;
import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.template.vo.TemplateType;
import com.group2.filterism.domain.user.domain.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;

import java.util.List;
import java.util.UUID;

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

    @Setter
    private Long ownerId;
    @Setter
    private String ownerName;

    @ElementCollection
    @CollectionTable(
            name = "file_url",
            joinColumns = @JoinColumn(name = "template_id")
    )
    private List<String> fileUrls;

    private String templateId;

    @Version
    private Long version;

    public void reject() {
        accessScope = AccessScope.REJECTED;
    }

    public void accept() {
        accessScope = AccessScope.PUBLIC;
    }

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
    public TemplateEntity(String title, List<HashtagEntity> hashtags, TemplateType type, List<String> fileUrls) {
        this.title = title;
        this.description = "";
        this.hashtags = hashtags;
        this.accessScope = AccessScope.PRIVATE;
        this.type = type;
        this.usedCount = 0L;
        this.ownerId = -1L;
        this.ownerName = "";
        this.fileUrls = fileUrls;
        this.version = 0L;
        this.templateId = UUID.randomUUID().toString().substring(1,6);
    }
}
