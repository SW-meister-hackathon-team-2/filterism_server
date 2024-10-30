package com.group2.filterism.domain.influencer.domain;

import com.group2.filterism.domain.influencer.domain.vo.VerificationStatus;
import com.group2.filterism.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class InfluencerVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VerificationStatus status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    private User user;

    @Builder
    public InfluencerVerification(String message, User user) {
        this.message = message;
        this.status = VerificationStatus.PENDING;
        this.user = user;
    }

    public void accept() {
        this.status = VerificationStatus.ACCEPTED;
    }

    public void reject() {
        this.status = VerificationStatus.REJECTED;
    }
}
