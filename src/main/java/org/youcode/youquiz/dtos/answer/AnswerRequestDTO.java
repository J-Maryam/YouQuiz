package org.youcode.youquiz.dtos.answer;

import jakarta.validation.constraints.NotBlank;

public record AnswerRequestDTO(
        @NotBlank(message = "Answer text cannot be blank. Please provide a valid answer.")
        String text
) {
}
