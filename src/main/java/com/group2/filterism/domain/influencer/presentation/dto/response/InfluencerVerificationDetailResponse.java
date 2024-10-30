package com.group2.filterism.domain.influencer.presentation.dto.response;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;
import com.group2.filterism.domain.influencer.domain.vo.VerificationStatus;
import com.group2.filterism.domain.user.presentation.dto.response.UserResponse;

public record InfluencerVerificationDetailResponse(
        Long id,
        String message,
        VerificationStatus status,
        UserResponse user
) {
    public InfluencerVerificationDetailResponse(InfluencerVerification verification) {
        this(verification.getId(), verification.getContent(), verification.getStatus(), new UserResponse(verification.getUser()));
    }
}
