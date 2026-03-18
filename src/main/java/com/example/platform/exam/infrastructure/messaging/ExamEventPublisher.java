/**
 * 示範答卷事件可往外部訊息系統發布的位置。
 */
package com.example.platform.exam.infrastructure.messaging;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ExamEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(ExamEventPublisher.class);

    /**
     * 監聽答卷提交事件並記錄對外發布行為。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void handle(ExamSubmittedEvent event) {
        log.info("Publishing integration event for response {}", event.responseId());
    }
}
