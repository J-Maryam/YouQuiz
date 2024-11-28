package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.student.StudentRequestDTO;
import org.youcode.youquiz.dtos.student.StudentResponseDTO;
import org.youcode.youquiz.entities.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericMapper<Student, StudentRequestDTO, StudentResponseDTO> {
}
