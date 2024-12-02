package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.subject.SubjectRequestDTO;
import org.youcode.youquiz.dtos.subject.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.mappers.SubjectMapper;
import org.youcode.youquiz.repositories.SubjectRepository;
import org.youcode.youquiz.services.SubjectService;

@Service
@Transactional
@Validated
public class SubjectServiceImpl extends GenericServiceImpl<Subject, Long, SubjectRequestDTO, SubjectResponseDTO> implements SubjectService {
    public SubjectServiceImpl(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public SubjectResponseDTO create(SubjectRequestDTO requestDTO) {
        Subject subject = mapper.toEntity(requestDTO);

        if(requestDTO.parentSubjectId() != null){
            Subject parentSubject = repository.findById(requestDTO.parentSubjectId())
                .orElseThrow(() -> new EntityNotFoundException("Parent subject with Id " + requestDTO.parentSubjectId() + " not found"));

            subject.setParentSubject(parentSubject);
        }

        Subject saved = repository.save(subject);
        return mapper.toDto(saved);
    }

}
