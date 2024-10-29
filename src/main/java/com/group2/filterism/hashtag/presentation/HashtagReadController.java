package com.group2.filterism.hashtag.presentation;

import com.group2.filterism.hashtag.application.HashtagReadUseCase;
import com.group2.filterism.http.ListResponse;
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
