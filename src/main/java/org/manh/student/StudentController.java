package org.manh.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/age/{age}")
    public List<Student> findStudentsByAgeGreaterThan(@PathVariable Integer age){
        return studentService.findStudentsByAgeGreaterThan(age);
    }

    @PostMapping("/student/all")
    public String addStudent(@ModelAttribute Student student, Model model){
        studentService.addStudent(student);

        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "result";
    }

}
