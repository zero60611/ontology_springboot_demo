/**
 * 所有領域事件的共同介面。
 */
package com.example.platform.shared.event;

import java.time.LocalDateTime;

public interface DomainEvent {

    /**
     * 回傳事件發生時間。
     *
     * @return 事件時間
     */
    LocalDateTime occurredAt();
}
