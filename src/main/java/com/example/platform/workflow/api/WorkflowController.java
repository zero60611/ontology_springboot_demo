package com.example.platform.workflow.api;

import com.example.platform.workflow.application.ExecuteWorkflowActionCommand;
import com.example.platform.workflow.application.WorkflowActionService;
import com.example.platform.workflow.domain.WorkflowRun;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供 workflow action API。
 */
@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowActionService workflowActionService;

    public WorkflowController(WorkflowActionService workflowActionService) {
        this.workflowActionService = workflowActionService;
    }

    /**
     * 執行指定的 workflow action。
     *
     * @param request 執行請求
     * @return 工作流執行紀錄
     */
    @PostMapping("/actions/execute")
    public WorkflowRun execute(@RequestBody ExecuteWorkflowActionRequest request) {
        return workflowActionService.execute(new ExecuteWorkflowActionCommand(
                request.workflowKey(),
                request.actionKey(),
                request.targetObjectId()
        ));
    }

    /**
     * 取得全部 workflow 執行紀錄。
     *
     * @return 執行紀錄清單
     */
    @GetMapping("/runs")
    public List<WorkflowRun> getAll() {
        return workflowActionService.getAll();
    }

    /**
     * workflow action 請求模型。
     *
     * @param workflowKey 工作流鍵值
     * @param actionKey 動作鍵值
     * @param targetObjectId 目標物件 ID
     */
    public record ExecuteWorkflowActionRequest(
            @NotBlank String workflowKey,
            @NotBlank String actionKey,
            @NotBlank String targetObjectId
    ) {
    }
}
