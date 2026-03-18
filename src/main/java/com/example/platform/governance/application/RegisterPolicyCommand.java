package com.example.platform.governance.application;

/**
 * 建立治理政策命令。
 *
 * @param policyKey 政策鍵值
 * @param objectType 適用物件型別
 * @param scope 套用範圍
 * @param effect 效果
 */
public record RegisterPolicyCommand(
        String policyKey,
        String objectType,
        String scope,
        String effect
) {
}
