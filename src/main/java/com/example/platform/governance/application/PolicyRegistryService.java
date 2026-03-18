package com.example.platform.governance.application;

import com.example.platform.governance.domain.Policy;
import com.example.platform.shared.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 維護平台治理政策與資料範圍規則。
 */
@Service
public class PolicyRegistryService {

    private final List<Policy> policies = new CopyOnWriteArrayList<>();

    /**
     * 建立新的治理政策。
     *
     * @param command 建立命令
     * @return 新建政策
     */
    public Policy register(RegisterPolicyCommand command) {
        Policy policy = new Policy(
                IdGenerator.newUuid(),
                command.policyKey(),
                command.objectType(),
                command.scope(),
                command.effect(),
                LocalDateTime.now()
        );
        policies.add(policy);
        return policy;
    }

    /**
     * 取得全部政策。
     *
     * @return 政策清單
     */
    public List<Policy> getAll() {
        return List.copyOf(policies);
    }
}
