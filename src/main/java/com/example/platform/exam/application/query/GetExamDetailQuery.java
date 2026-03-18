/**
 * 查詢答卷明細的 query model。
 *
 * @param responseId 答卷 ID
 */
package com.example.platform.exam.application.query;

import java.util.UUID;

public record GetExamDetailQuery(UUID responseId) {
}
