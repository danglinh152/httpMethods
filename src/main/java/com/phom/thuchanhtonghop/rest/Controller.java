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
@RequestMapping("/api/students")
public class Controller {
    private StudentService StudentService;

    public Controller(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }


    @GetMapping("")
    public List<Student> all() {
        List<Student> students = StudentService.findAll();
        if (!students.isEmpty()) {
            return students;
        } else {
            try {
                throw new Exception("Khong co sinh vien nao");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        Student student = StudentService.getById(id);
        if (student != null) {
            System.out.println(student);
            return ResponseEntity.ok(student);
        } else {
            try {
                throw new Exception("Khong co sinh vien nao co id = " + id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId(0);
        StudentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student existingStudent = StudentService.getById(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            StudentService.update(student);
            return ResponseEntity.status(HttpStatus.OK.value()).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        try {
            //  Block of code to try
            StudentService.deleteById(id);
        } catch (Exception e) {
            //  Block of code to handle errors
            try {
                throw new Exception("Khong tim thay sv co id = " + id);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }

}
