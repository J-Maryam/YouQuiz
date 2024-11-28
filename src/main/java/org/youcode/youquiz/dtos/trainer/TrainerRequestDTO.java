package org.youcode.youquiz.dtos.trainer;

import org.youcode.youquiz.dtos.user.UserRequestDTO;

public record TrainerRequestDTO(
        UserRequestDTO user,
        String specialty
) {
}
