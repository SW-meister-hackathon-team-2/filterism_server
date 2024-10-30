package com.group2.filterism.domain.influencer.presentation;

import com.group2.filterism.domain.influencer.application.InfluencerVerificationReadUseCase;
import com.group2.filterism.domain.influencer.application.InfluencerVerificationWriteUseCase;
import com.group2.filterism.domain.influencer.application.InfluencerVerificationUseCase;
import com.group2.filterism.domain.influencer.presentation.dto.request.CreateInfluencerVerificationRequest;
import com.group2.filterism.domain.influencer.presentation.dto.response.InfluencerVerificationDetailResponse;
import com.group2.filterism.domain.influencer.presentation.dto.response.InfluencerVerificationResponse;
import com.group2.filterism.global.http.IdResponse;
import com.group2.filterism.global.http.ListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/influencer-verification")
@RestController
@CrossOrigin(origins = "*")
public class InfluencerVerificationController {

    private final InfluencerVerificationWriteUseCase influencerVerificationWriteUseCase;
    private final InfluencerVerificationUseCase influencerVerificationUseCase;
    private final InfluencerVerificationReadUseCase influencerVerificationReadUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public IdResponse createInfluencerVerification(
            @RequestBody CreateInfluencerVerificationRequest request
    ) {
        return influencerVerificationWriteUseCase.execute(request);
    }

    @GetMapping
    public ListResponse<InfluencerVerificationResponse> getAllInfluencerVerifications() {
        return new ListResponse<>(influencerVerificationReadUseCase.getAllInfluencerVerifications());
    }

    @GetMapping("/{id}")
    public InfluencerVerificationDetailResponse getDetailInfluencerVerification(
            @PathVariable(name = "id") Long id
    ) {
        return influencerVerificationReadUseCase.getDetailInfluencerVerification(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/accept/{id}")
    public void acceptInfluencerVerification(
            @PathVariable(name = "id") Long id
    ) {
        influencerVerificationUseCase.accept(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/reject/{id}")
    public void rejectInfluencerVerification(
            @PathVariable(name = "id") Long id
    ) {
        influencerVerificationUseCase.reject(id);
    }
}
