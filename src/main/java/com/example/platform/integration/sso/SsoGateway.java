/**
 * 封裝 SSO 或外部身份系統的整合入口。
 */
package com.example.platform.integration.sso;

import org.springframework.stereotype.Component;

@Component
public class SsoGateway {

    /**
     * 回傳目前示範使用的 provider 名稱。
     *
     * @return provider 名稱
     */
    public String provider() {
        return "sso-placeholder";
    }
}
