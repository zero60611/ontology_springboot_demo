/**
 * 表示考生對某場考試的一次作答回應。
 */
package com.example.platform.exam.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ExamResponse {

    private final UUID responseId;
    private final UUID examId;
    private final String candidateId;
    private ExamStatus status;
    private LocalDateTime submittedTime;

    /**
     * 建立新的答卷聚合物件。
     *
     * @param responseId 答卷 ID
     * @param examId 所屬考試 ID
     * @param candidateId 應試者 ID
     * @param status 初始狀態
     */
    public ExamResponse(UUID responseId, UUID examId, String candidateId, ExamStatus status) {
        this.responseId = responseId;
        this.examId = examId;
        this.candidateId = candidateId;
        this.status = status;
    }

    /**
     * 將答卷狀態切換為已提交。
     *
     * @param submittedAt 提交時間
     */
    public void submit(LocalDateTime submittedAt) {
        this.status = ExamStatus.SUBMITTED;
        this.submittedTime = submittedAt;
    }

    /**
     * 取得答卷 ID。
     *
     * @return 答卷 ID
     */
    public UUID getResponseId() {
        return responseId;
    }

    /**
     * 取得所屬考試 ID。
     *
     * @return 考試 ID
     */
    public UUID getExamId() {
        return examId;
    }

    /**
     * 取得考生 ID。
     *
     * @return 考生 ID
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * 取得目前答卷狀態。
     *
     * @return 答卷狀態
     */
    public ExamStatus getStatus() {
        return status;
    }

    /**
     * 取得提交時間。
     *
     * @return 提交時間，未提交時可能為 null
     */
    public LocalDateTime getSubmittedTime() {
        return submittedTime;
    }
}
