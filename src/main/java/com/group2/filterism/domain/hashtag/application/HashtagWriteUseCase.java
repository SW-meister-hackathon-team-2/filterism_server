package com.group2.filterism.domain.hashtag.application;

import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.hashtag.domain.HashtagJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface HashtagWriteUseCase {
    void create(String tagName);
}

@Service
@RequiredArgsConstructor
class HashtagWriteUseCaseImpl implements HashtagWriteUseCase {
    private final HashtagJpaRepository repository;

    @Override
    public void create(final String tagName) {
        repository.save(new HashtagEntity(tagName));
    }
}
