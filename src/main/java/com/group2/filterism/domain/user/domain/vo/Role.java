package com.group2.filterism.domain.user.domain.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    INFLUENCER("ROLE_INFLUENCER", "인플루언서"),
    USER("ROLE_USER", "유저"),
    ADMIN("ROLE_ADMIN", "어드민");

    private final String key;
    private final String description;
}
