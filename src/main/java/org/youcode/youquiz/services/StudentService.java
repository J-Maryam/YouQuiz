package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.student.StudentRequestDTO;
import org.youcode.youquiz.dtos.student.StudentResponseDTO;
import org.youcode.youquiz.entities.Student;

public interface StudentService extends GenericService<Student, Long, StudentRequestDTO, StudentResponseDTO> {
}
