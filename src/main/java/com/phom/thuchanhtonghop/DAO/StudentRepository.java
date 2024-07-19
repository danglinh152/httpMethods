//package com.phom.thuchanhtonghop.DAO;
//
//
//import com.phom.thuchanhtonghop.entity.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//@RepositoryRestResource(path = "students")
//public interface StudentRepository extends JpaRepository<Student, Integer> {
//
//}

package com.phom.thuchanhtonghop.DAO;


import com.phom.thuchanhtonghop.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByName(String name);

    public List<Student> findByAge(int age);

    public List<Student> findByNameNot(String name);

}
