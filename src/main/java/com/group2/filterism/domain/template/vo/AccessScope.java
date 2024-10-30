package com.group2.filterism.domain.template.vo;

public enum AccessScope {
    /**
     * 심사를 거친 상태
     */
    PUBLIC,
    /**
     * 심사 대기 중
     */
    PENDING,
    /**
     * 비동개
     */
    PRIVATE,
    REJECTED
}