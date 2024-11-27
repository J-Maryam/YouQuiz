package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.subject.SubjectRequestDTO;
import org.youcode.youquiz.dtos.subject.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericMapper<Subject, SubjectRequestDTO, SubjectResponseDTO> {
}
