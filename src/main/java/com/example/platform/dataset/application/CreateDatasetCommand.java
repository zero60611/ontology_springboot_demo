package com.example.platform.dataset.application;

/**
 * 建立資料集命令。
 *
 * @param datasetKey 資料集鍵值
 * @param name 顯示名稱
 * @param sourceSystem 來源系統
 */
public record CreateDatasetCommand(
        String datasetKey,
        String name,
        String sourceSystem
) {
}
