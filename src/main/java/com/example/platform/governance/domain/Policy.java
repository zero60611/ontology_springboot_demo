package com.example.platform.governance.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 表示平台治理或資料存取政策。
 *
 * @param policyId 政策 ID
 * @param policyKey 政策鍵值
 * @param objectType 適用物件型別
 * @param scope 套用範圍
 * @param effect 效果
 * @param createdAt 建立時間
 */
public record Policy(
        UUID policyId,
        String policyKey,
        String objectType,
        String scope,
        String effect,
        LocalDateTime createdAt
) {
}
