/**
 * 建立答卷的應用服務。
 */
package com.example.platform.exam.application.command;

import com.example.platform.exam.application.projection.ExamProjectionUpdater;
import com.example.platform.exam.domain.model.ExamResponse;
import com.example.platform.exam.domain.repository.ExamRepository;
import com.example.platform.exam.domain.service.ExamDomainService;
import org.springframework.stereotype.Service;

@Service
public class CreateExamResponseUseCase {

    private final ExamDomainService examDomainService;
    private final ExamRepository examRepository;
    private final ExamProjectionUpdater examProjectionUpdater;

    public CreateExamResponseUseCase(
            ExamDomainService examDomainService,
            ExamRepository examRepository,
            ExamProjectionUpdater examProjectionUpdater
    ) {
        this.examDomainService = examDomainService;
        this.examRepository = examRepository;
        this.examProjectionUpdater = examProjectionUpdater;
    }

    /**
     * 建立答卷並同步更新 projection 計數。
     *
     * @param command 建立答卷命令
     * @return 建立後的答卷
     */
    public ExamResponse execute(CreateExamResponseCommand command) {
        ExamResponse response = examDomainService.startResponse(command.examId(), command.candidateId());
        ExamResponse saved = examRepository.save(response);
        // 目前以記憶體 projection 紀錄建立筆數，後續可替換為 read model table。
        examProjectionUpdater.registerResponseCreated();
        return saved;
    }
}
