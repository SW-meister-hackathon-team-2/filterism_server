package com.group2.filterism.hashtag.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
public class HashtagEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
}
