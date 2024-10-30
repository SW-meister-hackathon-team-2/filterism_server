package com.group2.filterism.domain.influencer.application;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;
import com.group2.filterism.domain.influencer.domain.repository.InfluencerVerificationRepository;
import com.group2.filterism.domain.influencer.presentation.dto.response.InfluencerVerificationDetailResponse;
import com.group2.filterism.domain.influencer.presentation.dto.response.InfluencerVerificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InfluencerVerificationReadUseCase {
    List<InfluencerVerificationResponse> getAllInfluencerVerifications();
    InfluencerVerificationDetailResponse getDetailInfluencerVerification(Long verificationId);
}

@RequiredArgsConstructor
@Service
class InfluencerVerificationReadUseCaseImpl implements InfluencerVerificationReadUseCase {

    private final InfluencerVerificationRepository influencerVerificationRepository;

    @Override
    public List<InfluencerVerificationResponse> getAllInfluencerVerifications() {
        List<InfluencerVerification> verificationList = influencerVerificationRepository.findAll();

        return verificationList.stream()
                .map(InfluencerVerificationResponse::new)
                .toList();
    }

    @Override
    public InfluencerVerificationDetailResponse getDetailInfluencerVerification(Long verificationId) {
        InfluencerVerification verification = influencerVerificationRepository.findById(verificationId)
                .orElseThrow(() -> new RuntimeException("Influencer verification not found"));

        return new InfluencerVerificationDetailResponse(verification);
    }
}