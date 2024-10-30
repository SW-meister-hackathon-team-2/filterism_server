package com.group2.filterism.swagger.hashtag;

import com.group2.filterism.domain.hashtag.presentation.HashtagResponse;
import com.group2.filterism.http.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "해시태그 읽기 작업 API", description = "hashtag")
public interface HashtagReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            useReturnTypeSchema = true
    )
    @Operation(summary = "해시 태그 전체 조회 API")
    ListResponse<HashtagResponse> getAll();
}
