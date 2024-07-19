package com.example.notice_body.demo.Controller;

import com.example.notice_body.demo.Model.Student;
import com.example.notice_body.demo.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    public StudentServices studentServices;

    @PostMapping
    public Student post(@RequestBody Student student){
        return  studentServices.post(student);
    }
    @GetMapping
    public List<Student> getStudent(){

        return studentServices.getStudent();
    }
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable("id") Integer id){

        return studentServices.getById(id);
    }
    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable("id") Integer id){

        studentServices.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") int id, @RequestBody Student studentDetails){
        Student updateStudent = studentServices.updateStudent(id, studentDetails);
        if (updateStudent != null){
            return ResponseEntity.ok(updateStudent);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
