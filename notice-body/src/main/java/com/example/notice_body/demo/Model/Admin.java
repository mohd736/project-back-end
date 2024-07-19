package com.example.notice_body.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String empNumber;
    private String name;
    private String email;
    private int phone;

    @Lob // Use @Lob for fields that should be stored as a Large Object in the database
    @Column(length = 100000)
    private byte[] fileContent;
}
