/**
 * 監聽答卷提交事件並建立審核任務。
 */
package com.example.platform.review.application;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ReviewWorkflowService {

    /**
     * 以記憶體方式保存審核任務。
     */
    private final List<String> reviewTasks = new CopyOnWriteArrayList<>();

    /**
     * 收到答卷提交事件後建立審核流程任務。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void onExamSubmitted(ExamSubmittedEvent event) {
        reviewTasks.add("review:" + event.responseId());
    }

    /**
     * 取得目前審核任務列表。
     *
     * @return 審核任務清單
     */
    public List<String> getReviewTasks() {
        return List.copyOf(reviewTasks);
    }
}
