/**
 * 表示答卷審核完成的領域事件。
 *
 * @param responseId 答卷 ID
 * @param reviewerId 審核者 ID
 * @param occurredAt 事件發生時間
 */
package com.example.platform.exam.domain.event;

import com.example.platform.shared.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public record ExamReviewedEvent(
        UUID responseId,
        String reviewerId,
        LocalDateTime occurredAt
) implements DomainEvent {
}
