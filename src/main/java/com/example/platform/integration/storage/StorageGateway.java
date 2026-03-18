/**
 * 封裝檔案儲存服務的整合入口。
 */
package com.example.platform.integration.storage;

import org.springframework.stereotype.Component;

@Component
public class StorageGateway {

    /**
     * 回傳目前示範使用的 provider 名稱。
     *
     * @return provider 名稱
     */
    public String provider() {
        return "s3-or-gcs-placeholder";
    }
}
