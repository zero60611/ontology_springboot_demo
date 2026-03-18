package com.example.platform.dataset.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 表示平台中的資料集定義。
 *
 * @param datasetId 資料集 ID
 * @param datasetKey 業務鍵值
 * @param name 顯示名稱
 * @param sourceSystem 來源系統
 * @param version 版本號
 * @param status 狀態
 * @param createdAt 建立時間
 */
public record Dataset(
        UUID datasetId,
        String datasetKey,
        String name,
        String sourceSystem,
        int version,
        DatasetStatus status,
        LocalDateTime createdAt
) {
}
