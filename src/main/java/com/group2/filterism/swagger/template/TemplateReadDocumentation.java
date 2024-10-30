package com.group2.filterism.swagger.template;

import com.group2.filterism.http.ListResponse;
import com.group2.filterism.domain.template.presentation.dto.TemplateDetailResponse;
import com.group2.filterism.domain.template.presentation.dto.TemplateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "템플릿 읽기 작업 API", description = "template")
public interface TemplateReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            useReturnTypeSchema = true
    )
    @Operation(summary = "공개된 템플릿 전체 조회 API")
    ListResponse<TemplateResponse> getAllPublicTemplate();

    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            useReturnTypeSchema = true
    )
    @Operation(summary = "공개된 템플릿 상세 조회 API")
    TemplateDetailResponse getDetailPublicTemplate(Long templateId);

    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            useReturnTypeSchema = true
    )
    @Operation(summary = "공개된 템플릿 검색 API")
    ListResponse<TemplateResponse> search(String text, String hashtags);
}
