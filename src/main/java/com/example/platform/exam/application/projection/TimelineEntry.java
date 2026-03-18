/**
 * 表示查詢層可展示的一筆時間軸資料。
 *
 * @param objectType 物件型別
 * @param objectId 物件 ID
 * @param action 執行動作
 * @param occurredAt 發生時間
 */
package com.example.platform.exam.application.projection;

import java.time.LocalDateTime;

public record TimelineEntry(
        String objectType,
        String objectId,
        String action,
        LocalDateTime occurredAt
) {
}
