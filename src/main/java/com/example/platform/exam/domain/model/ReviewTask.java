/**
 * 表示答卷所對應的審核任務。
 *
 * @param taskId 任務 ID
 * @param responseId 答卷 ID
 * @param assigneeId 指派對象 ID
 * @param status 任務狀態
 */
package com.example.platform.exam.domain.model;

import java.util.UUID;

public record ReviewTask(
        UUID taskId,
        UUID responseId,
        String assigneeId,
        String status
) {
}
