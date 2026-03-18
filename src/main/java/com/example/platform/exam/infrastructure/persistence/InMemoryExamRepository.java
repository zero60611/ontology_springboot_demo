/**
 * 以記憶體實作的答卷儲存庫，方便專案骨架快速驗證流程。
 */
package com.example.platform.exam.infrastructure.persistence;

import com.example.platform.exam.domain.model.ExamResponse;
import com.example.platform.exam.domain.repository.ExamRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryExamRepository implements ExamRepository {

    /**
     * 使用 concurrent map 模擬持久化儲存。
     */
    private final Map<UUID, ExamResponse> store = new ConcurrentHashMap<>();

    /**
     * 儲存或覆寫答卷資料。
     *
     * @param examResponse 答卷聚合
     * @return 儲存後的答卷
     */
    @Override
    public ExamResponse save(ExamResponse examResponse) {
        store.put(examResponse.getResponseId(), examResponse);
        return examResponse;
    }

    /**
     * 依答卷 ID 查詢資料。
     *
     * @param responseId 答卷 ID
     * @return 查詢結果
     */
    @Override
    public Optional<ExamResponse> findByResponseId(UUID responseId) {
        return Optional.ofNullable(store.get(responseId));
    }
}
