package com.group2.filterism.domain.influencer.presentation.dto.response;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;
import com.group2.filterism.domain.influencer.domain.vo.VerificationStatus;

public record InfluencerVerificationResponse(
        Long id,
        VerificationStatus status,
        Long userId
) {
    public InfluencerVerificationResponse(InfluencerVerification verification) {
        this(verification.getId(), verification.getStatus(), verification.getUser().getId());
    }
}
