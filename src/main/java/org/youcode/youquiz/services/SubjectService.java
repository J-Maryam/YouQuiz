package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.subject.SubjectRequestDTO;
import org.youcode.youquiz.dtos.subject.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;

public interface SubjectService extends GenericService<Subject, Long, SubjectRequestDTO, SubjectResponseDTO> {
}
