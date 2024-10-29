package com.group2.filterism.hashtag.application;

import com.group2.filterism.hashtag.domain.HashtagJpaRepository;
import com.group2.filterism.hashtag.presentation.HashtagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReadHashtagUseCase {
    List<HashtagResponse> readAll();
}

@Service
@RequiredArgsConstructor
class ReadHashtagUseCaseImpl implements ReadHashtagUseCase {
    private final HashtagJpaRepository repository;

    @Override
    public List<HashtagResponse> readAll() {
        return repository.findAll().stream()
                .map(HashtagResponse::create)
                .toList();
    }
}
