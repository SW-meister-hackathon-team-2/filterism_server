package com.group2.filterism.swagger.hashtag;

import com.group2.filterism.domain.hashtag.presentation.CreateForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "해시 태그 쓰기 작업 API", description = "hashtag")
public interface HashtagWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "해시 태그 생성 완료!"
    )
    @Operation(summary = "해시 태그 생성 API")
    void create(CreateForm form);
}
