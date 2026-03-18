/**
 * 提供 exam 模組的命令型 API。
 */
package com.example.platform.exam.api;

import com.example.platform.exam.application.command.CreateExamResponseCommand;
import com.example.platform.exam.application.command.CreateExamResponseUseCase;
import com.example.platform.exam.application.command.SubmitExamCommand;
import com.example.platform.exam.application.command.SubmitExamUseCase;
import com.example.platform.exam.domain.model.ExamResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/exams")
public class ExamCommandController {

    private final CreateExamResponseUseCase createExamResponseUseCase;
    private final SubmitExamUseCase submitExamUseCase;

    public ExamCommandController(
            CreateExamResponseUseCase createExamResponseUseCase,
            SubmitExamUseCase submitExamUseCase
    ) {
        this.createExamResponseUseCase = createExamResponseUseCase;
        this.submitExamUseCase = submitExamUseCase;
    }

    /**
     * 建立一筆新的答卷。
     *
     * @param examId 考試 ID
     * @param body 請求內容
     * @return 建立後的答卷
     */
    @PostMapping("/{examId}/responses")
    public ExamResponse createResponse(@PathVariable UUID examId, @RequestBody Map<String, String> body) {
        return createExamResponseUseCase.execute(new CreateExamResponseCommand(examId, body.getOrDefault("candidateId", "candidate-001")));
    }

    /**
     * 提交指定答卷。
     *
     * @param responseId 答卷 ID
     * @param request 提交請求內容
     * @return 提交後的答卷
     */
    @PostMapping("/responses/{responseId}/submit")
    public ExamResponse submit(@PathVariable UUID responseId, @Valid @RequestBody SubmitExamRequest request) {
        return submitExamUseCase.execute(new SubmitExamCommand(responseId, request.actorId()));
    }

    /**
     * 提交答卷所需的請求內容。
     *
     * @param actorId 執行者 ID
     */
    public record SubmitExamRequest(@NotBlank String actorId) {
    }
}
