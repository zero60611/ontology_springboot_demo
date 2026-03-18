/**
 * 監聽答卷提交事件並建立報表產生任務。
 */
package com.example.platform.report.application;

import com.example.platform.exam.domain.event.ExamSubmittedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ReportGenerationService {

    /**
     * 以記憶體方式保存產生中的報表任務。
     */
    private final List<String> reports = new CopyOnWriteArrayList<>();

    /**
     * 收到答卷提交事件後建立報表產出工作。
     *
     * @param event 答卷提交事件
     */
    @EventListener
    public void onExamSubmitted(ExamSubmittedEvent event) {
        reports.add("report:" + event.responseId());
    }

    /**
     * 取得報表任務列表。
     *
     * @return 報表任務清單
     */
    public List<String> getReports() {
        return List.copyOf(reports);
    }
}
