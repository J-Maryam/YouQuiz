package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.request.SubjectRequestDTO;
import org.youcode.youquiz.dtos.response.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.services.SubjectService;

@Service
public class SubjectServiceImpl extends GenericServiceImpl<Subject, Long, SubjectRequestDTO, SubjectResponseDTO> implements SubjectService {
}
