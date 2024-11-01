package com.group2.filterism.domain.user.application;

import com.group2.filterism.domain.user.domain.User;
import com.group2.filterism.domain.user.domain.repository.UserRepository;
import com.group2.filterism.global.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface CurrentUser {
    User get();
}

@RequiredArgsConstructor
@Service
class CurrentUserImpl implements CurrentUser {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public User get() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");

        if (sessionUser != null) {
            return userRepository.findByEmail(sessionUser.getEmail())
                    .orElseThrow(RuntimeException::new);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}