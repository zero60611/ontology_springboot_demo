/**
 * 提供 dashboard 使用的彙總視圖。
 *
 * @param totalResponses 全部答卷數
 * @param submittedResponses 已提交答卷數
 * @param timelineEntries 時間軸筆數
 */
package com.example.platform.exam.application.projection;

public record ExamDashboardView(
        long totalResponses,
        long submittedResponses,
        long timelineEntries
) {
}
