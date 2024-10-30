package com.group2.filterism.domain.influencer.domain.repository;

import com.group2.filterism.domain.influencer.domain.InfluencerVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfluencerVerificationRepository extends JpaRepository<InfluencerVerification, Long> {
}
