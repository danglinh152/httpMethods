package com.phom.thuchanhtonghop.DAO;

import com.phom.thuchanhtonghop.entity.Student;

import java.util.List;


public interface StudentDAO {
    public void save(Student student);
    public void deleteById(int id);
    public void update(Student student);
    public Student findById(int id);
    public List<Student> findAll();
}
