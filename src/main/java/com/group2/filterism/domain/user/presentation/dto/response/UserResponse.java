package com.group2.filterism.domain.user.presentation.dto.response;

import com.group2.filterism.domain.user.domain.User;
import com.group2.filterism.domain.user.domain.vo.Role;

public record UserResponse(
        Long id,
        String email,
        String name,
        Role role
) {
    public UserResponse(User user) {
        this(user.getId(), user.getEmail(), user.getName(), user.getRole());
    }
}
