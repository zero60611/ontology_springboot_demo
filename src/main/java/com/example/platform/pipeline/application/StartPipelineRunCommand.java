package com.example.platform.pipeline.application;

/**
 * 啟動 pipeline run 的命令。
 *
 * @param pipelineKey pipeline 鍵值
 * @param datasetKey dataset 鍵值
 */
public record StartPipelineRunCommand(
        String pipelineKey,
        String datasetKey
) {
}
