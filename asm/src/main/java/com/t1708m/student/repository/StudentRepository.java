package com.t1708m.student.repository;

import com.t1708m.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findByEmail(String email);
    Optional<Student> findByRollNumber(String ro);
}
