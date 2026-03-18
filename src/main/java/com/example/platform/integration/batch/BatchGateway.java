/**
 * 封裝批次作業整合的入口。
 */
package com.example.platform.integration.batch;

import org.springframework.stereotype.Component;

@Component
public class BatchGateway {

    /**
     * 回傳目前示範使用的 provider 名稱。
     *
     * @return provider 名稱
     */
    public String provider() {
        return "batch-placeholder";
    }
}
