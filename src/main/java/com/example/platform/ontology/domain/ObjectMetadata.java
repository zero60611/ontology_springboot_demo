/**
 * 描述某個業務物件的展示、操作與權限語意。
 *
 * @param objectType 物件型別
 * @param displayName 顯示名稱
 * @param allowedActions 允許動作
 * @param supportedLinks 支援關聯
 * @param searchableFields 可搜尋欄位
 * @param permissionPolicy 權限策略名稱
 */
package com.example.platform.ontology.domain;

import java.util.Set;

public record ObjectMetadata(
        ObjectType objectType,
        String displayName,
        Set<ActionType> allowedActions,
        Set<LinkType> supportedLinks,
        Set<String> searchableFields,
        String permissionPolicy
) {
}
