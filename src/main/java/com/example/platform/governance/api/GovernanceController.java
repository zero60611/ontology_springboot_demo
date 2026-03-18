package com.example.platform.governance.api;

import com.example.platform.governance.application.PolicyRegistryService;
import com.example.platform.governance.application.RegisterPolicyCommand;
import com.example.platform.governance.domain.Policy;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供治理政策管理 API。
 */
@RestController
@RequestMapping("/api/governance/policies")
public class GovernanceController {

    private final PolicyRegistryService policyRegistryService;

    public GovernanceController(PolicyRegistryService policyRegistryService) {
        this.policyRegistryService = policyRegistryService;
    }

    /**
     * 建立治理政策。
     *
     * @param request 建立請求
     * @return 新建政策
     */
    @PostMapping
    public Policy register(@RequestBody RegisterPolicyRequest request) {
        return policyRegistryService.register(new RegisterPolicyCommand(
                request.policyKey(),
                request.objectType(),
                request.scope(),
                request.effect()
        ));
    }

    /**
     * 取得全部治理政策。
     *
     * @return 政策清單
     */
    @GetMapping
    public List<Policy> getAll() {
        return policyRegistryService.getAll();
    }

    /**
     * 建立治理政策的請求模型。
     *
     * @param policyKey 政策鍵值
     * @param objectType 適用物件型別
     * @param scope 範圍
     * @param effect 效果
     */
    public record RegisterPolicyRequest(
            @NotBlank String policyKey,
            @NotBlank String objectType,
            @NotBlank String scope,
            @NotBlank String effect
    ) {
    }
}
