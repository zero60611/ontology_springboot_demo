/**
 * 封裝訊息中介軟體的整合入口。
 */
package com.example.platform.integration.pubsub;

import org.springframework.stereotype.Component;

@Component
public class PubSubGateway {

    /**
     * 回傳目前示範使用的 provider 名稱。
     *
     * @return provider 名稱
     */
    public String provider() {
        return "application-event-placeholder";
    }
}
