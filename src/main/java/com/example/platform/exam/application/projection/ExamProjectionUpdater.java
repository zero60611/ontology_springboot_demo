/**
 * 負責維護 exam 模組的簡化讀模型。
 */
package com.example.platform.exam.application.projection;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class ExamProjectionUpdater {

    /**
     * 以記憶體方式保存 timeline，實際專案可改成 projection table 或 search index。
     */
    private final List<TimelineEntry> timeline = new CopyOnWriteArrayList<>();
    private volatile long totalResponses;
    private volatile long submittedResponses;

    /**
     * 在建立答卷時更新統計值。
     */
    public void registerResponseCreated() {
        totalResponses++;
    }

    /**
     * 監聽提交事件並更新 dashboard / timeline。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void onExamSubmitted(ExamSubmittedEvent event) {
        submittedResponses++;
        timeline.add(new TimelineEntry(
                "EXAM_RESPONSE",
                event.responseId().toString(),
                "SUBMIT",
                event.occurredAt()
        ));
    }

    /**
     * 取得 dashboard 視圖資料。
     *
     * @return dashboard 統計資訊
     */
    public ExamDashboardView getDashboard() {
        return new ExamDashboardView(totalResponses, submittedResponses, timeline.size());
    }

    /**
     * 取得 timeline 列表。
     *
     * @return 不可變 timeline 清單
     */
    public List<TimelineEntry> getTimeline() {
        return List.copyOf(timeline);
    }
}
