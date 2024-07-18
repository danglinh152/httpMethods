package com.phom.thuchanhtonghop.DAO;

import com.phom.thuchanhtonghop.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;


@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager em;

    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public void deleteById(int id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

    @Override
    public void update(Student student) {
        em.merge(student);
        em.flush();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s FROM Student s";
        Query query = em.createQuery(jpql, Student.class);
       return query.getResultList();
    }
}
