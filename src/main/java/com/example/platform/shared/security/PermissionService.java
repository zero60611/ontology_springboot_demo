/**
 * 提供簡化版的權限判斷服務。
 */
package com.example.platform.shared.security;

import com.example.platform.ontology.domain.ActionType;
import com.example.platform.ontology.domain.ObjectType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    /**
     * 內建示範規則，後續可替換成資料庫或規則引擎。
     */
    private final List<PermissionRule> rules = List.of(
            new PermissionRule(ObjectType.EXAM, ActionType.CREATE, "ADMIN", "ALL"),
            new PermissionRule(ObjectType.EXAM_RESPONSE, ActionType.SUBMIT, "CANDIDATE", "SELF"),
            new PermissionRule(ObjectType.REPORT, ActionType.PUBLISH, "REVIEWER", "DEPARTMENT")
    );

    /**
     * 判斷指定角色是否可對物件執行某個動作。
     *
     * @param roleCode 角色代碼
     * @param objectType 物件型別
     * @param actionType 動作型別
     * @return 是否允許
     */
    public boolean isAllowed(String roleCode, ObjectType objectType, ActionType actionType) {
        return rules.stream().anyMatch(rule ->
                rule.roleCode().equalsIgnoreCase(roleCode)
                        && rule.objectType() == objectType
                        && rule.actionType() == actionType
        );
    }

    /**
     * 取得目前系統載入的權限規則。
     *
     * @return 權限規則清單
     */
    public List<PermissionRule> getRules() {
        return rules;
    }
}
