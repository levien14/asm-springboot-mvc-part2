package com.t1708m.student.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aptech {
    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,  CascadeType.REFRESH})
    @JoinTable(name = "Aptech_Student",
            joinColumns = @JoinColumn(name = "Aptech_id"),
            inverseJoinColumns = @JoinColumn(name = "Student_id"))
    private Set<Student> studentSet;

    public Aptech() {
        this.studentSet = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudentSet() {
        if (this.studentSet == null){
            studentSet = new HashSet<>();
        }
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public void setStudents(Student student) {
        this.studentSet.add(student);
    }
}
