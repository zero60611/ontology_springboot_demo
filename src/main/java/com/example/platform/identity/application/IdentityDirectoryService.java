/**
 * 提供簡化版的身份目錄查詢服務。
 */
package com.example.platform.identity.application;

import com.example.platform.identity.domain.UserProfile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IdentityDirectoryService {

    /**
     * 以記憶體方式模擬使用者資料來源。
     */
    private final Map<String, UserProfile> users = Map.of(
            "candidate-001", new UserProfile("candidate-001", "Candidate One", "CANDIDATE", "SALES", "tenant-a"),
            "reviewer-001", new UserProfile("reviewer-001", "Reviewer One", "REVIEWER", "QA", "tenant-a")
    );

    /**
     * 依使用者 ID 查詢身份資訊。
     *
     * @param userId 使用者 ID
     * @return 使用者資料，查無時回傳 null
     */
    public UserProfile findById(String userId) {
        return users.get(userId);
    }
}
