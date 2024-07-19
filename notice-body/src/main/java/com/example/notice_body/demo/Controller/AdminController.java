package com.example.notice_body.demo.Controller;

import com.example.notice_body.demo.Model.Admin;
import com.example.notice_body.demo.Service.AdminServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @PostMapping("/add")
    public Admin createAdmin(
            @RequestParam String empNumber,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int phone,
            @RequestParam(required = false) MultipartFile file
    ) throws IOException {
        return adminServices.createAdmin(empNumber, name, email, phone, file);
    }

    @GetMapping("/all")
    public List<Admin> getAdmin() {
        return adminServices.getAdmin();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getById(@PathVariable Integer id) {
        return adminServices.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        adminServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdmin(@PathVariable int id, @RequestBody Admin adminDetails) {
        Admin updateAdmin = adminServices.updateAdmin(id, adminDetails);
        if (updateAdmin != null) {
            return ResponseEntity.ok(updateAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
