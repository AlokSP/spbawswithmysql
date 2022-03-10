package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentServices;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServices service;
    
    @GetMapping("/")
    public String home() {
        return "Welcome to AWS SPB with MySQl Deployment";
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return service.saveStudents(students);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return service.getStudents();
    }

    @GetMapping("/studentById/{id}")
    public Student findStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping("/student/{name}")
    public Student findProductByName(@PathVariable String name) {
        return service.getStudentByName(name);
    }
}