package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.request.SubjectRequestDTO;
import org.youcode.youquiz.dtos.response.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.mappers.SubjectMapper;
import org.youcode.youquiz.repositories.SubjectRepository;
import org.youcode.youquiz.services.SubjectService;

@Service
@Transactional
@Validated
public class SubjectServiceImpl extends GenericServiceImpl<Subject, Long, SubjectRequestDTO, SubjectResponseDTO> implements  SubjectService{
    public SubjectServiceImpl(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
    }

}
