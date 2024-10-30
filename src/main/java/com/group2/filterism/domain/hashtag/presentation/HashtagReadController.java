package com.group2.filterism.domain.hashtag.presentation;

import com.group2.filterism.domain.hashtag.application.HashtagReadUseCase;
import com.group2.filterism.global.http.ListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hashtag")
class HashtagReadController {
    private final HashtagReadUseCase useCase;

    @GetMapping
    ListResponse<HashtagResponse> getAll() {
        return new ListResponse<>(useCase.readAll());
    }
}
