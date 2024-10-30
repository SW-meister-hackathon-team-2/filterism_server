package com.group2.filterism.domain.hashtag.presentation;

import com.group2.filterism.domain.hashtag.application.HashtagWriteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hashtag")
class HashtagWriteController {
    private final HashtagWriteUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody CreateForm form) {
        useCase.create(form.tag());
    }

    record CreateForm(String tag) {}
}
