package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.student.StudentRequestDTO;
import org.youcode.youquiz.dtos.student.StudentResponseDTO;
import org.youcode.youquiz.entities.Student;
import org.youcode.youquiz.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController extends GenericControllerImpl<Student, Long, StudentRequestDTO, StudentResponseDTO> {
    public StudentController(StudentService service) {
        super(service);
    }
}
