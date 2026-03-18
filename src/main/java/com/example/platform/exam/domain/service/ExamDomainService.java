/**
 * 封裝 exam 模組的核心領域規則。
 */
package com.example.platform.exam.domain.service;

import com.example.platform.exam.domain.model.ExamResponse;
import com.example.platform.exam.domain.model.ExamStatus;
import com.example.platform.shared.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExamDomainService {

    /**
     * 建立一筆新的作答回應。
     *
     * @param examId 考試 ID
     * @param candidateId 考生 ID
     * @return 新建立的答卷
     */
    public ExamResponse startResponse(UUID examId, String candidateId) {
        return new ExamResponse(IdGenerator.newUuid(), examId, candidateId, ExamStatus.IN_PROGRESS);
    }
}
