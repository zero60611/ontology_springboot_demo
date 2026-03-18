/**
 * 表示答卷目前所處的流程狀態。
 */
package com.example.platform.exam.domain.model;

public enum ExamStatus {
    DRAFT,
    IN_PROGRESS,
    SUBMITTED,
    SCORED,
    REVIEWED
}
