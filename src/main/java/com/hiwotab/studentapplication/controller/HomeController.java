package com.hiwotab.studentapplication.controller;

import com.hiwotab.studentapplication.model.Student;
import com.hiwotab.studentapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String home(){
        return "homePage";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/addStudent")
    public String InputForm(Model model){
        model.addAttribute("student", new Student());
        return "addStudent";
    }
    @PostMapping("/addStudent")
    public String saveForm(@Valid Student student, BindingResult result){
        if (result.hasErrors()){
            return "addStudent";
        }
        studentRepository.save(student);
        return "dispStudent";
    }
    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("student", studentRepository.findOne(id));
        return "addStudent";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        studentRepository.delete(id);
        return "redirect:/listStudent";
    }
    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("student", studentRepository.findOne(id));
        return "show";
    }
    @RequestMapping("/listStudent")
    public String listCourses(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "listStudent";
    }


}
