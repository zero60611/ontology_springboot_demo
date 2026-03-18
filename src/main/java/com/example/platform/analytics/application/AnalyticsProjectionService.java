/**
 * 監聽流程事件並更新分析投影資料。
 */
package com.example.platform.analytics.application;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AnalyticsProjectionService {

    /**
     * 以記憶體方式保存分析投影紀錄。
     */
    private final List<String> analyticsEntries = new CopyOnWriteArrayList<>();

    /**
     * 收到答卷提交事件後建立分析投影更新。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void onExamSubmitted(ExamSubmittedEvent event) {
        analyticsEntries.add("dashboard:" + event.responseId());
    }

    /**
     * 取得分析投影紀錄。
     *
     * @return 分析投影清單
     */
    public List<String> getAnalyticsEntries() {
        return List.copyOf(analyticsEntries);
    }
}
