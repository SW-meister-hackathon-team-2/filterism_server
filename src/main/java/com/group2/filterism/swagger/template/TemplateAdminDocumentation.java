package com.group2.filterism.swagger.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "", description = "")
public interface TemplateAdminDocumentation {
    @ApiResponse(
            responseCode = "204",
            description = "템플릿 추가 요청 거절이 완료되었습니다!"
    )
    @Operation(summary = "템플릿 추가 요청 거절 API")
    void reject(Long id);

    @ApiResponse(
            responseCode = "204",
            description = " 템플릿 추가 요청 수락이 완료되었습니다!"
    )
    @Operation(summary = "템플릿 추가 요청 수락 API")
    void accept(Long id);
}
