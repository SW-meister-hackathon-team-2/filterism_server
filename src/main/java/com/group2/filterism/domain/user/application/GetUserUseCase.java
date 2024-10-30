package com.group2.filterism.domain.user.application;

import com.group2.filterism.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface GetUserUseCase {
    User execute();
}

@RequiredArgsConstructor
@Service
class GetUserUseCaseImpl implements GetUserUseCase {

    private final CurrentUser currentUser;

    @Override
    public User execute() {
        return currentUser.get();
    }
}
