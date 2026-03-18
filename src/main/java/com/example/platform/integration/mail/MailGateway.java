/**
 * 封裝郵件服務的整合入口。
 */
package com.example.platform.integration.mail;

import org.springframework.stereotype.Component;

@Component
public class MailGateway {

    /**
     * 回傳目前示範使用的 provider 名稱。
     *
     * @return provider 名稱
     */
    public String provider() {
        return "mail-placeholder";
    }
}
