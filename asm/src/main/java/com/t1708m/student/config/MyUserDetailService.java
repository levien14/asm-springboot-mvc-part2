package com.t1708m.student.config;

import com.t1708m.student.entity.Student;
import com.t1708m.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = studentService.findByEmail(s);
        if (student == null){
            throw  new UsernameNotFoundException("Email Not found");
        }
        UserDetails userDetails =
                User.builder()
                    .username(student.getEmail())
                    .password(student.getPassword())
                     .roles("")
                     .build();
        return  userDetails;
    }
}
