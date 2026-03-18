package com.example.platform.pipeline.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 表示一次資料轉換流程的執行紀錄。
 *
 * @param runId 執行 ID
 * @param pipelineKey pipeline 鍵值
 * @param datasetKey 輸入資料集鍵值
 * @param status 執行狀態
 * @param startedAt 啟動時間
 */
public record PipelineRun(
        UUID runId,
        String pipelineKey,
        String datasetKey,
        PipelineRunStatus status,
        LocalDateTime startedAt
) {
}
