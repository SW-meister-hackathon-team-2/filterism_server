package com.group2.filterism.domain.hashtag.presentation;

import com.group2.filterism.domain.hashtag.application.HashtagWriteUseCase;
import com.group2.filterism.swagger.hashtag.HashtagWriteDocumentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hashtag")
@CrossOrigin(origins = "*")
class HashtagWriteController implements HashtagWriteDocumentation {
    private final HashtagWriteUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateForm form) {
        useCase.create(form.tag());
    }
}
