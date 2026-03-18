/**
 * 提供 exam 模組的查詢型 API。
 */
package com.example.platform.exam.api;

import com.example.platform.exam.application.projection.ExamDashboardView;
import com.example.platform.exam.application.projection.ExamProjectionUpdater;
import com.example.platform.exam.application.projection.TimelineEntry;
import com.example.platform.exam.application.query.ExamDetailView;
import com.example.platform.exam.application.query.GetExamDetailHandler;
import com.example.platform.exam.application.query.GetExamDetailQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exams")
public class ExamQueryController {

    private final GetExamDetailHandler getExamDetailHandler;
    private final ExamProjectionUpdater examProjectionUpdater;

    public ExamQueryController(GetExamDetailHandler getExamDetailHandler, ExamProjectionUpdater examProjectionUpdater) {
        this.getExamDetailHandler = getExamDetailHandler;
        this.examProjectionUpdater = examProjectionUpdater;
    }

    /**
     * 取得單一答卷明細。
     *
     * @param responseId 答卷 ID
     * @return 答卷明細
     */
    @GetMapping("/responses/{responseId}")
    public ExamDetailView getResponseDetail(@PathVariable UUID responseId) {
        return getExamDetailHandler.handle(new GetExamDetailQuery(responseId));
    }

    /**
     * 取得 dashboard 統計資料。
     *
     * @return dashboard 視圖
     */
    @GetMapping("/dashboard")
    public ExamDashboardView getDashboard() {
        return examProjectionUpdater.getDashboard();
    }

    /**
     * 取得 timeline 資料。
     *
     * @return timeline 清單
     */
    @GetMapping("/timeline")
    public List<TimelineEntry> getTimeline() {
        return examProjectionUpdater.getTimeline();
    }
}
