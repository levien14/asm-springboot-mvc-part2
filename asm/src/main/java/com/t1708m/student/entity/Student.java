package com.t1708m.student.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Size(min = 7,max = 7, message = "RollNumber must be 7 characters.")
    private String rollNumber;
    @NotNull(message = "Name cannot be null.")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull
    private String password;


    @ManyToMany(mappedBy = "studentSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<Aptech> aptechSet;

    public Student() {
    }


    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Aptech> getAptechSet() {
        return aptechSet;
    }

    public void setAptechSet(Set<Aptech> aptechSet) {
        this.aptechSet = aptechSet;
    }

    public void setAptechSet(Aptech aptech) {
        this.aptechSet.add(aptech);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
