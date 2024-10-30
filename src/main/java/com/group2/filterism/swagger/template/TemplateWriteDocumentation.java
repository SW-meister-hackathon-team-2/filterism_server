package com.group2.filterism.swagger.template;

import com.group2.filterism.domain.template.presentation.dto.TemplateCreateForm;
import com.group2.filterism.domain.template.presentation.dto.TemplateUpdateForm;
import com.group2.filterism.http.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "템플릿 쓰기 작업 API", description = "template")
public interface TemplateWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "새 템플릿 생성 완료!"
    )
    @Operation(summary = "새 템플릿 생성 API")
    ListResponse<String> create(TemplateCreateForm form, List<MultipartFile> files);

    @ApiResponse(
            responseCode = "204",
            description = "템플릿 수정 완료!"
    )
    @Operation(summary = "템플릿 수정 API")
    void update(TemplateUpdateForm form, Long templateId);

    @ApiResponse(
            responseCode = "204",
            description = "템플릿 사용 완료!"
    )
    @Operation(summary = "템플릿 사용 API")
    void use(Long templateId);

    @ApiResponse(
            responseCode = "204",
            description = "템플릿 삭제 완료!"
    )
    @Operation(summary = "템플릿 삭제 API")
    void delete(Long templateId);
}
