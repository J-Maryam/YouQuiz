package org.youcode.youquiz.dtos.trainer;

import org.youcode.youquiz.dtos.user.UserResponseDTO;

public record EmbeddableTrainerDTO(
        UserResponseDTO user,
        String specialty
) {
}
