/**
 * 定義答卷聚合的持久化介面。
 */
package com.example.platform.exam.domain.repository;

import com.example.platform.exam.domain.model.ExamResponse;

import java.util.Optional;
import java.util.UUID;

public interface ExamRepository {

    /**
     * 儲存答卷資料。
     *
     * @param examResponse 答卷聚合
     * @return 儲存後的答卷
     */
    ExamResponse save(ExamResponse examResponse);

    /**
     * 依答卷 ID 查詢資料。
     *
     * @param responseId 答卷 ID
     * @return 查詢結果
     */
    Optional<ExamResponse> findByResponseId(UUID responseId);
}
