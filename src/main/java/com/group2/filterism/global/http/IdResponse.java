package com.group2.filterism.global.http;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;

public record IdResponse(
        Long id
) {
    public IdResponse(InfluencerVerification verification) {
        this(verification.getId());
    }
}
