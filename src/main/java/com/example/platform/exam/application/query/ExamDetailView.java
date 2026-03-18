/**
 * 提供查詢層使用的答卷明細視圖。
 *
 * @param responseId 答卷 ID
 * @param examId 考試 ID
 * @param candidateId 考生 ID
 * @param status 答卷狀態
 * @param submittedTime 提交時間
 */
package com.example.platform.exam.application.query;

import com.example.platform.exam.domain.model.ExamStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ExamDetailView(
        UUID responseId,
        UUID examId,
        String candidateId,
        ExamStatus status,
        LocalDateTime submittedTime
) {
}
