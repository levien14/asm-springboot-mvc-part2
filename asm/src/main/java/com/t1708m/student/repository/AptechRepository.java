package com.t1708m.student.repository;

import com.t1708m.student.entity.Aptech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptechRepository extends JpaRepository<Aptech, Integer> {
}
