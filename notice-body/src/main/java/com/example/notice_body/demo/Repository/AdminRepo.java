package com.example.notice_body.demo.Repository;

import com.example.notice_body.demo.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
