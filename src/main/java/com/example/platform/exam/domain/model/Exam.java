/**
 * 表示考試主體資料。
 *
 * @param examId 考試 ID
 * @param title 考試名稱
 * @param description 考試描述
 */
package com.example.platform.exam.domain.model;

import java.util.UUID;

public record Exam(
        UUID examId,
        String title,
        String description
) {
}
