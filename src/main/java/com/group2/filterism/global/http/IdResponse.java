package com.group2.filterism.global.http;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;

public record IdResponse(
        Object id
) {
    public static IdResponse fromInfluencer(InfluencerVerification verification) {
        return new IdResponse(verification.getId());
    }
}
