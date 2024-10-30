package com.group2.filterism.domain.user.presentation.dto.response;

import com.group2.filterism.domain.user.domain.User;
import com.group2.filterism.domain.user.domain.vo.Role;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String email;
    private final String name;
    private final Role role;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.role = user.getRole();
    }
}
