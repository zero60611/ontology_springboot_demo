/**
 * 監聽答卷提交事件並建立評分任務。
 */
package com.example.platform.scoring.application;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ScoringTaskService {

    /**
     * 以記憶體方式保存待處理評分任務。
     */
    private final List<String> scoringTasks = new CopyOnWriteArrayList<>();

    /**
     * 收到答卷提交事件後建立評分任務。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void onExamSubmitted(ExamSubmittedEvent event) {
        scoringTasks.add("score:" + event.responseId());
    }

    /**
     * 取得目前評分任務列表。
     *
     * @return 評分任務清單
     */
    public List<String> getScoringTasks() {
        return List.copyOf(scoringTasks);
    }
}
