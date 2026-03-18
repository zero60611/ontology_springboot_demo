/**
 * 負責處理答卷明細查詢。
 */
package com.example.platform.exam.application.query;

import com.example.platform.exam.domain.model.ExamResponse;
import com.example.platform.exam.domain.repository.ExamRepository;
import com.example.platform.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetExamDetailHandler {

    private final ExamRepository examRepository;

    public GetExamDetailHandler(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    /**
     * 依答卷 ID 回傳查詢用視圖。
     *
     * @param query 查詢條件
     * @return 答卷明細
     */
    public ExamDetailView handle(GetExamDetailQuery query) {
        ExamResponse response = examRepository.findByResponseId(query.responseId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam response not found: " + query.responseId()));

        return new ExamDetailView(
                response.getResponseId(),
                response.getExamId(),
                response.getCandidateId(),
                response.getStatus(),
                response.getSubmittedTime()
        );
    }
}
