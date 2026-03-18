/**
 * 表示平台中的使用者身份資訊。
 *
 * @param userId 使用者 ID
 * @param displayName 顯示名稱
 * @param roleCode 角色代碼
 * @param departmentCode 部門代碼
 * @param tenantId 租戶 ID
 */
package com.example.platform.identity.domain;

public record UserProfile(
        String userId,
        String displayName,
        String roleCode,
        String departmentCode,
        String tenantId
) {
}
