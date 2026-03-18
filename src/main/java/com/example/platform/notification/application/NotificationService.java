/**
 * 監聽流程事件並建立通知任務。
 */
package com.example.platform.notification.application;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class NotificationService {

    /**
     * 以記憶體方式保存通知工作。
     */
    private final List<String> notifications = new CopyOnWriteArrayList<>();

    /**
     * 收到答卷提交事件後建立通知紀錄。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void onExamSubmitted(ExamSubmittedEvent event) {
        notifications.add("notify:" + event.candidateId());
    }

    /**
     * 取得通知任務列表。
     *
     * @return 通知任務清單
     */
    public List<String> getNotifications() {
        return List.copyOf(notifications);
    }
}
