/**
 * 提交答卷的命令模型。
 *
 * @param responseId 答卷 ID
 * @param actorId 執行提交的人員 ID
 */
package com.example.platform.exam.application.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SubmitExamCommand(
        @NotNull UUID responseId,
        @NotBlank String actorId
) {
}
