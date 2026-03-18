package com.example.platform.workflow.application;

/**
 * 執行 workflow action 的命令。
 *
 * @param workflowKey 工作流鍵值
 * @param actionKey 動作鍵值
 * @param targetObjectId 目標物件 ID
 */
public record ExecuteWorkflowActionCommand(
        String workflowKey,
        String actionKey,
        String targetObjectId
) {
}
