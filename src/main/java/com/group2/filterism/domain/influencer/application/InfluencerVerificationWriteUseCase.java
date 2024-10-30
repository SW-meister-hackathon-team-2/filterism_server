package com.group2.filterism.domain.influencer.application;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;
import com.group2.filterism.domain.influencer.domain.repository.InfluencerVerificationRepository;
import com.group2.filterism.domain.influencer.presentation.dto.request.CreateInfluencerVerificationRequest;
import com.group2.filterism.domain.user.application.CurrentUser;
import com.group2.filterism.global.http.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface InfluencerVerificationWriteUseCase {
    IdResponse execute(CreateInfluencerVerificationRequest request);
}

@RequiredArgsConstructor
@Service
class InfluencerVerificationWriteUseCaseImpl implements InfluencerVerificationWriteUseCase {
    private final InfluencerVerificationRepository influencerVerificationRepository;
    private final CurrentUser currentUser;

    @Override
    public IdResponse execute(CreateInfluencerVerificationRequest request) {
        InfluencerVerification verification = influencerVerificationRepository.save(
                new InfluencerVerification(request.content(), currentUser.get())
        );
        return new IdResponse(verification);
    }
}
