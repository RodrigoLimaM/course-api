package com.courses.services.impl;

import com.courses.entities.Student;
import com.courses.entities.dto.StudentDTO;
import com.courses.entities.mapper.StudentMapper;
import com.courses.repositories.StudentRepository;
import com.courses.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student save(StudentDTO dto, Integer courseId) {
        dto.setId(null);
        return studentRepository.save(studentMapper.mapStudentDTOToStudent(dto, courseId));
    }

    @Override
    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        return studentMapper.mapStudentToStudentDTO(student);
    }

    @Override
    public Student deleteById(Integer id) {
        Student deletedStudent = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(id);
        return deletedStudent;
    }

    @Override
    public Student update(StudentDTO newStudentDTO, Integer id) {
        Student actual = studentRepository.findById(id).orElse(null);
        actual.setName(newStudentDTO.getName());
        return studentRepository.save(actual);
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> responseList = studentRepository.findAll();

        return responseList
                .stream()
                .map(student -> studentMapper.mapStudentToStudentDTO(student))
                .collect(Collectors.toList());
    }
}