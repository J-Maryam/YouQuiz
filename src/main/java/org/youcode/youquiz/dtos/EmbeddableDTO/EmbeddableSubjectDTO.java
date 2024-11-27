package org.youcode.youquiz.dtos.EmbeddableDTO;

import org.youcode.youquiz.entities.Subject;

public record EmbeddableSubjectDTO(
        Long id,
        String title,
        Subject parentSubject
) {
}
