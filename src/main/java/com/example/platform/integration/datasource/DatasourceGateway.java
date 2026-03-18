/**
 * 封裝外部資料來源連線的整合入口。
 */
package com.example.platform.integration.datasource;

import org.springframework.stereotype.Component;

@Component
public class DatasourceGateway {

    /**
     * 回傳目前示範使用的 provider 名稱。
     *
     * @return provider 名稱
     */
    public String provider() {
        return "postgres-or-oracle-placeholder";
    }
}
