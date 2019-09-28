package com.t1708m.student.controller;

import com.t1708m.student.config.MyUserDetailService;
import com.t1708m.student.entity.Student;
import com.t1708m.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping(value = "/student")
public class StudentController {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/create")
    public String create(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentService.save(student);
        return "redirect:/student";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String detail(Model model, Principal principal){
        String email = principal.getName();
        System.out.println("email : " + email);
        Student student = studentService.findByEmail(email);
        model.addAttribute("student", student);
        return "form";
    }
}
