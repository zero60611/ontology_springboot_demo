package com.example.platform.pipeline.api;

import com.example.platform.pipeline.application.PipelineOrchestratorService;
import com.example.platform.pipeline.application.StartPipelineRunCommand;
import com.example.platform.pipeline.domain.PipelineRun;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供 pipeline 管理 API。
 */
@RestController
@RequestMapping("/api/pipelines")
public class PipelineController {

    private final PipelineOrchestratorService pipelineOrchestratorService;

    public PipelineController(PipelineOrchestratorService pipelineOrchestratorService) {
        this.pipelineOrchestratorService = pipelineOrchestratorService;
    }

    /**
     * 啟動新的 pipeline run。
     *
     * @param request 請求內容
     * @return 執行紀錄
     */
    @PostMapping("/runs")
    public PipelineRun start(@RequestBody StartPipelineRunRequest request) {
        return pipelineOrchestratorService.start(new StartPipelineRunCommand(
                request.pipelineKey(),
                request.datasetKey()
        ));
    }

    /**
     * 取得全部 pipeline 執行紀錄。
     *
     * @return pipeline run 清單
     */
    @GetMapping("/runs")
    public List<PipelineRun> getAll() {
        return pipelineOrchestratorService.getAll();
    }

    /**
     * 啟動 pipeline 的請求模型。
     *
     * @param pipelineKey pipeline 鍵值
     * @param datasetKey dataset 鍵值
     */
    public record StartPipelineRunRequest(
            @NotBlank String pipelineKey,
            @NotBlank String datasetKey
    ) {
    }
}
