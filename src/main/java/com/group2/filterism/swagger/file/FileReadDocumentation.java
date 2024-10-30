package com.group2.filterism.swagger.file;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "파일 조회 API", description = "file")
public interface FileReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "파일 조회를 완료했습니다."
    )
    @Operation(summary = "파일 조회 API")
    ResponseEntity<byte[]> getFile(String fileId);
}
