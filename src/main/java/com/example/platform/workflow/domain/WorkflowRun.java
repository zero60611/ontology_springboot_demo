package com.example.platform.workflow.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 表示一次業務工作流執行紀錄。
 *
 * @param runId 執行 ID
 * @param workflowKey 工作流鍵值
 * @param actionKey 動作鍵值
 * @param targetObjectId 目標物件 ID
 * @param status 執行狀態
 * @param executedAt 執行時間
 */
public record WorkflowRun(
        UUID runId,
        String workflowKey,
        String actionKey,
        String targetObjectId,
        WorkflowRunStatus status,
        LocalDateTime executedAt
) {
}
