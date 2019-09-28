package com.t1708m.student.controller;

import com.t1708m.student.entity.Student;
import com.t1708m.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/testcheckbox")
public class TestCheckBoxController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(method = RequestMethod.GET)
    public String checkBox(Model model){
        model.addAttribute("students",studentService.findAll());

        return "check";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String ok(@RequestParam(value = "listid",required = false) int[] listid){
        if (listid != null){
            for (int i = 0; i < listid.length; i++) {
                System.out.println(listid[i]);
            }
        }
        return "home";
    }
}
