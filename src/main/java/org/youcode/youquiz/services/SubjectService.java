package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.request.SubjectRequestDTO;
import org.youcode.youquiz.dtos.response.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;

public interface SubjectService extends GenericService<Subject, Long, SubjectRequestDTO, SubjectResponseDTO> {
}
