package com.phom.thuchanhtonghop.rest;

import com.phom.thuchanhtonghop.service.StudentService;
import com.phom.thuchanhtonghop.entity.Student;
import com.phom.thuchanhtonghop.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private StudentService StudentService;

    public Controller(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }


    @GetMapping("/students")
    public List<Student> all() {
        List<Student> students = StudentService.findAll();
        if (students.size() > 0) {
           return students;
        }else{
            try {
                throw new Exception("Khong co sinh vien nao");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        Student student = StudentService.findById(id);
        if(student != null) {
            return ResponseEntity.ok(student);
        }
        else{
            try {
                throw new Exception("Khong co sinh vien nao co id = " + id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping("/test")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId(0);
        StudentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(student);
    }
}
