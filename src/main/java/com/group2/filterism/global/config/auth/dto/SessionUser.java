package com.group2.filterism.global.config.auth.dto;

import com.group2.filterism.user.domain.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private final String name;
    private final String email;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
