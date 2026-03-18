/**
 * 負責提交答卷並發布後續流程事件的應用服務。
 */
package com.example.platform.exam.application.command;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import com.example.platform.exam.domain.model.ExamResponse;
import com.example.platform.exam.domain.repository.ExamRepository;
import com.example.platform.shared.exception.ResourceNotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubmitExamUseCase {

    private final ExamRepository examRepository;
    private final ApplicationEventPublisher eventPublisher;

    public SubmitExamUseCase(ExamRepository examRepository, ApplicationEventPublisher eventPublisher) {
        this.examRepository = examRepository;
        this.eventPublisher = eventPublisher;
    }

    /**
     * 執行提交答卷流程。
     *
     * @param command 提交命令
     * @return 更新後的答卷
     */
    public ExamResponse execute(SubmitExamCommand command) {
        ExamResponse examResponse = examRepository.findByResponseId(command.responseId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam response not found: " + command.responseId()));

        // 先更新交易資料，再發布領域事件給其他模組接手。
        examResponse.submit(LocalDateTime.now());
        examRepository.save(examResponse);

        eventPublisher.publishEvent(new ExamSubmittedEvent(
                examResponse.getExamId(),
                examResponse.getResponseId(),
                examResponse.getCandidateId(),
                LocalDateTime.now()
        ));

        return examResponse;
    }
}
