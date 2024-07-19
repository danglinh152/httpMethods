package com.phom.thuchanhtonghop.DAO;


import com.phom.thuchanhtonghop.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
