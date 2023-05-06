package com.arjuncodes.studentsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "interview")

public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company_name;
    private String role;
    private String seniority;
    @Column(name = "role_description")
    private String role_description;

    private Integer timing;



}