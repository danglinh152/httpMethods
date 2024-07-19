package com.phom.thuchanhtonghop.service;

import com.phom.thuchanhtonghop.entity.Student;

import java.util.List;

public interface StudentService {
    public void save(Student student);
    public void deleteById(int id);
    public void update(Student student);
    public Student getById(int id);
    public List<Student> getByAge(int age);
    public List<Student> getByName(String name);
    public List<Student> getByNotName(String name);
    public List<Student> findAll();
}
