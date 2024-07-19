package com.example.notice_body.demo.Service;

import com.example.notice_body.demo.Model.Student;
import com.example.notice_body.demo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentServices {
    @Autowired
    public  StudentRepo studentRepo;
    //post

    public Student post(Student student){
        return studentRepo.save(student);
    }
    //getAll
    public List<Student> getStudent(){

        return studentRepo.findAll();
    }
public Optional<Student> getById(Integer id){
        return studentRepo.findById(id);
    }
    public void  deleteById(Integer id){

        studentRepo.deleteById(id);
    }

    public Student updateStudent(int id, Student studentDetails){
        Student student= studentRepo.findById(id).orElse(null);
        if (student != null){
            student.setRegNumber(studentDetails.getRegNumber());
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setPhone(studentDetails.getPhone());
            student.setProgram(studentDetails.getProgram());
            student.setPassword(studentDetails.getPassword());
            return studentRepo.save(student);
        }
        return null;
    }


}
