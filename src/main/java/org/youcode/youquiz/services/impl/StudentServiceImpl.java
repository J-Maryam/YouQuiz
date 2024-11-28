package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.student.StudentRequestDTO;
import org.youcode.youquiz.dtos.student.StudentResponseDTO;
import org.youcode.youquiz.entities.Student;
import org.youcode.youquiz.mappers.StudentMapper;
import org.youcode.youquiz.repositories.StudentRepository;
import org.youcode.youquiz.services.StudentService;

@Service
@Transactional
@Validated
public class StudentServiceImpl extends GenericServiceImpl<Student, Long, StudentRequestDTO, StudentResponseDTO> implements StudentService {
    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
    }
}
