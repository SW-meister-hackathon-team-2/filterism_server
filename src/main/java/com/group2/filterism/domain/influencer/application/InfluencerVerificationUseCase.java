package com.group2.filterism.domain.influencer.application;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;
import com.group2.filterism.domain.influencer.domain.repository.InfluencerVerificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface InfluencerVerificationUseCase {
    void accept(Long id);
    void reject(Long id);
}

@RequiredArgsConstructor
@Service
class InfluencerVerificationUseCaseImpl implements InfluencerVerificationUseCase {

    private final InfluencerVerificationRepository influencerVerificationRepository;

    @Override
    @Transactional
    public void accept(Long id) {
        InfluencerVerification verification = influencerVerificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Verification not found"));
        verification.accept();
        verification.getUser().changeToInfluencer();
    }

    @Override
    @Transactional
    public void reject(Long id) {
        InfluencerVerification verification = influencerVerificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Verification not found"));
        verification.reject();
    }
}