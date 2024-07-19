package com.example.notice_body.demo.Service;

import com.example.notice_body.demo.Model.Admin;
import com.example.notice_body.demo.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {

    @Autowired
    private AdminRepo adminRepo;

    public Admin createAdmin(String empNumber, String name, String email, int phone, MultipartFile file) throws IOException {
        Admin admin = new Admin();
        admin.setEmpNumber(empNumber);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPhone(phone);

        if (file != null && !file.isEmpty()) {
            admin.setFileContent(file.getBytes());
        }

        return adminRepo.save(admin);
    }
    public List<Admin> getAdmin() {
        return adminRepo.findAll();
    }

    public Optional<Admin> getById(Integer id) {
        return adminRepo.findById(id);
    }

    public void deleteById(Integer id) {
        adminRepo.deleteById(id);
    }

    public Admin updateAdmin(int id, Admin adminDetails) {
        Admin admin = adminRepo.findById(id).orElse(null);
        if (admin != null) {
            admin.setEmpNumber(adminDetails.getEmpNumber());
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            admin.setPhone(adminDetails.getPhone());
            return adminRepo.save(admin);
        }
        return null;
    }
}
