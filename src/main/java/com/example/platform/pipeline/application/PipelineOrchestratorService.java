package com.example.platform.pipeline.application;

import com.example.platform.pipeline.domain.PipelineRun;
import com.example.platform.pipeline.domain.PipelineRunStatus;
import com.example.platform.shared.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 負責管理 pipeline 啟動與執行紀錄。
 */
@Service
public class PipelineOrchestratorService {

    private final List<PipelineRun> runs = new CopyOnWriteArrayList<>();

    /**
     * 啟動一筆新的 pipeline run。
     *
     * @param command 啟動命令
     * @return 執行紀錄
     */
    public PipelineRun start(StartPipelineRunCommand command) {
        PipelineRun run = new PipelineRun(
                IdGenerator.newUuid(),
                command.pipelineKey(),
                command.datasetKey(),
                PipelineRunStatus.RUNNING,
                LocalDateTime.now()
        );
        runs.add(run);
        return run;
    }

    /**
     * 取得全部 pipeline run。
     *
     * @return 執行紀錄清單
     */
    public List<PipelineRun> getAll() {
        return List.copyOf(runs);
    }
}
