package com.group2.filterism.swagger.template;

import com.group2.filterism.http.ListResponse;
import com.group2.filterism.domain.template.presentation.dto.TemplateDetailResponse;
import com.group2.filterism.domain.template.presentation.dto.TemplateResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;

@Tag(name = "템플릿 읽기 작업 API", description = "template")
public interface TemplateReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ListResponse.class,
                            oneOf = {TemplateResponse.class}
                    )
            )
    )
    ListResponse<TemplateResponse> getAllPublicTemplate();

    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = TemplateDetailResponse.class
                    )
            )
    )
    TemplateDetailResponse getDetailPublicTemplate(Long templateId);

    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 템플릿을 불러왔습니다.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ListResponse.class,
                            oneOf = {TemplateResponse.class}
                    )
            )
    )
    ListResponse<TemplateResponse> search(String text, String hashtags);
}
