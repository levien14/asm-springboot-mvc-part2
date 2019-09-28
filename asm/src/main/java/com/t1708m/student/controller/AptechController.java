package com.t1708m.student.controller;

import com.t1708m.student.entity.Aptech;
import com.t1708m.student.entity.Student;
import com.t1708m.student.service.AptechService;
import com.t1708m.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping(value = "/aptech")
public class AptechController {

    @Autowired
    private AptechService aptechService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("aptechs",aptechService.findAll());
        return "list-aptech";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model){
        Aptech aptech = aptechService.details(id);
        model.addAttribute("aptech",aptech);

        Set<Student> studentSet =  aptech.getStudentSet();
        ArrayList<Student> studentList = (ArrayList<Student>) studentService.findAll();
        ArrayList<Student> studentAptechActive = new ArrayList<>();
        if (studentList == null){
            studentList = new ArrayList<>();
        }
        if (studentList.size() > 0){
            for (Student studentAptech : studentSet
            ) {
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println(i);
                    Student student = studentList.get(i);
                        if (studentAptech.getId() == student.getId()){
                            studentAptechActive.add(student);
                            studentList.remove(student);
                        }
                    }
                }
        }
        model.addAttribute("studentsaptech",studentAptechActive);
        model.addAttribute("students",studentList);
        return "details";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String details(
            Aptech currentAptech,
            @RequestParam(value = "studentid",required = false) String[] listStudentId){
        System.out.println(currentAptech.getId());

        for (int i = 0; i < listStudentId.length; i++) {
            System.out.println("Studentid" + listStudentId[i]);

            Student student = studentService.findById(listStudentId[i]);
            if (student != null){
                System.out.println("Studentid" + student.getId());
                System.out.println("Aptech id" + currentAptech.getId());

                currentAptech.setStudents(student);
                aptechService.save(currentAptech);
            }
        }
        return "home";
    }
}
