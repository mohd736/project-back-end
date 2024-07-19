package com.example.notice_body.demo.Model;



import jakarta.persistence.*;
import lombok. *;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String regNumber;
    private String name;
    private String email;
    private int phone;
    private String program;
    private String password;

}
