package com.phom.thuchanhtonghop.service;

import com.phom.thuchanhtonghop.DAO.StudentRepository;
import com.phom.thuchanhtonghop.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository StudentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    @Override
    @Transactional
    public void save(Student student) {
        StudentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        StudentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Student student) {
        StudentRepository.saveAndFlush(student);
    }

    @Override
    public Student getById(int id) {
        return StudentRepository.getById(id);
    }

    @Override
    public List<Student> getByAge(int age) {
        return StudentRepository.findByAge(age);
    }

    @Override
    public List<Student> getByName(String name) {
        return StudentRepository.findByName(name);
    }

    @Override
    public List<Student> getByNotName(String name) {
        return StudentRepository.findByNameNot(name);
    }

    @Override
    public List<Student> findAll() {
        return StudentRepository.findAll();
    }
}
