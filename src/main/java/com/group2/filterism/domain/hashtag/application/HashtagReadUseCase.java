package com.group2.filterism.domain.hashtag.application;

import com.group2.filterism.domain.hashtag.domain.HashtagJpaRepository;
import com.group2.filterism.domain.hashtag.presentation.HashtagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HashtagReadUseCase {
    List<HashtagResponse> readAll();
}

@Service
@RequiredArgsConstructor
class HashtagReadUseCaseImpl implements HashtagReadUseCase {
    private final HashtagJpaRepository repository;

    @Override
    public List<HashtagResponse> readAll() {
        return repository.findAll().stream()
                .map(HashtagResponse::create)
                .toList();
    }
}
