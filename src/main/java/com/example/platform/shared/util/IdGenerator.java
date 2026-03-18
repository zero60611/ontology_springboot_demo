/**
 * 產生系統內通用識別碼的工具類別。
 */
package com.example.platform.shared.util;

import java.util.UUID;

public final class IdGenerator {

    /**
     * 工具類別不允許建立實例。
     */
    private IdGenerator() {
    }

    /**
     * 產生新的 UUID。
     *
     * @return 新的 UUID
     */
    public static UUID newUuid() {
        return UUID.randomUUID();
    }
}
