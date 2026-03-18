/**
 * 表示可供稽核追蹤的操作紀錄。
 *
 * @param actorId 執行者 ID
 * @param action 動作名稱
 * @param targetId 目標物件 ID
 * @param occurredAt 發生時間
 */
package com.example.platform.shared.model;

import java.time.LocalDateTime;

public record AuditableAction(
        String actorId,
        String action,
        String targetId,
        LocalDateTime occurredAt
) {
}
