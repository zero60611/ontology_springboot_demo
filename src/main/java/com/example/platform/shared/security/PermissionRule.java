/**
 * 定義某個角色對特定物件與動作的授權規則。
 *
 * @param objectType 物件型別
 * @param actionType 動作型別
 * @param roleCode 角色代碼
 * @param dataScope 資料範圍
 */
package com.example.platform.shared.security;

import com.example.platform.ontology.domain.ActionType;
import com.example.platform.ontology.domain.ObjectType;

public record PermissionRule(
        ObjectType objectType,
        ActionType actionType,
        String roleCode,
        String dataScope
) {
}
