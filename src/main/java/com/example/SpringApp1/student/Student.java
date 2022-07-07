package com.example.SpringApp1.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity //for hibernate
@Table //for table in db
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate db;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate db) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.db = db;
    }

    public Student(String name,
                   String email,
                   LocalDate db) {
        this.name = name;
        this.email = email;
        this.db = db;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDb() {
        return db;
    }

    public void setDb(LocalDate db) {
        this.db = db;
    }

    public Integer getAge() {
        return Period.between(this.db, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", db=" + db +
                ", age=" + age +
                '}';
    }
}
