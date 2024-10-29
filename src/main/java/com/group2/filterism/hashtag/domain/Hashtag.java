package com.group2.filterism.hashtag.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hashtag {

    @Id
    private String id;

    private String hashtag;
}
