package com.group2.filterism.hashtag.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashtagJpaRepository extends JpaRepository<HashtagEntity, Long> {
    boolean existsByName(String name);
    Optional<HashtagEntity> findByName(String name);
}
