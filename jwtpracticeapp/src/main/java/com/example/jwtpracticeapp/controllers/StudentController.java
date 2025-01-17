package com.example.jwtpracticeapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtpracticeapp.models.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    
    //Mientras SpringSecurity esté desactivado, puedo acceder a estos endpoints.

    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Navin", 60),
        new Student(2, "Kevin", 70)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    //una vez activo SpringSecurity tengo que acceder usando el token de la página
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
