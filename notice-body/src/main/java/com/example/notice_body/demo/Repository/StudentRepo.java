package com.example.notice_body.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.notice_body.demo.Model.Student;

@Repository

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
