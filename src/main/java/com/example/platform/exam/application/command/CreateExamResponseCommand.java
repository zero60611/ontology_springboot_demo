/**
 * 建立答卷的命令模型。
 *
 * @param examId 考試 ID
 * @param candidateId 考生 ID
 */
package com.example.platform.exam.application.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateExamResponseCommand(
        @NotNull UUID examId,
        @NotBlank String candidateId
) {
}
