package com.t1708m.student.service;

import com.t1708m.student.entity.Student;
import com.t1708m.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(String rollNumber){
        Optional<Student> studentOptional = studentRepository.findByRollNumber(rollNumber);
        if (!studentOptional.isPresent()){
            return null;
        }
        Student student = studentOptional.get();
        return student;
    }

    public Student save(Student student){

        studentRepository.save(student);
        return student;
    }

    public Student findByEmail(String email){
        Optional<Student> studentOption = studentRepository.findByEmail(email);
        if (!studentOption.isPresent()){
            return null;
        }
        Student student = studentOption.get();
        return student;
    }
}
