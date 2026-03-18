/**
 * 表示答卷已提交的領域事件。
 *
 * @param examId 考試 ID
 * @param responseId 答卷 ID
 * @param candidateId 考生 ID
 * @param occurredAt 事件發生時間
 */
package com.example.platform.exam.domain.event;

import com.example.platform.shared.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public record ExamSubmittedEvent(
        UUID examId,
        UUID responseId,
        String candidateId,
        LocalDateTime occurredAt
) implements DomainEvent {
}
