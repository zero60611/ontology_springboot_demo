package com.example.platform.workflow.application;

import com.example.platform.shared.util.IdGenerator;
import com.example.platform.workflow.domain.WorkflowRun;
import com.example.platform.workflow.domain.WorkflowRunStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 負責執行平台中的業務動作與工作流。
 */
@Service
public class WorkflowActionService {

    private final List<WorkflowRun> runs = new CopyOnWriteArrayList<>();

    /**
     * 執行一個 workflow action。
     *
     * @param command 執行命令
     * @return 工作流執行紀錄
     */
    public WorkflowRun execute(ExecuteWorkflowActionCommand command) {
        WorkflowRun run = new WorkflowRun(
                IdGenerator.newUuid(),
                command.workflowKey(),
                command.actionKey(),
                command.targetObjectId(),
                WorkflowRunStatus.EXECUTED,
                LocalDateTime.now()
        );
        runs.add(run);
        return run;
    }

    /**
     * 取得全部工作流執行紀錄。
     *
     * @return 執行紀錄清單
     */
    public List<WorkflowRun> getAll() {
        return List.copyOf(runs);
    }
}
