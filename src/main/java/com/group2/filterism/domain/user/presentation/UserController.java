package com.group2.filterism.domain.user.presentation;

import com.group2.filterism.domain.user.application.GetUserUseCase;
import com.group2.filterism.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final GetUserUseCase getUserUseCaseImpl;

    @GetMapping
    public UserResponse getUser() {
        return new UserResponse(getUserUseCaseImpl.execute());
    }
}
