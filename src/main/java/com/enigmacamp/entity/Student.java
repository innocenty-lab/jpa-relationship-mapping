package com.enigmacamp.entity;

import com.enigmacamp.constant.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@DynamicUpdate
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @Setter @Getter
    private long studentId;

    @Column(name = "first_name", nullable = false, length = 50)
    @Setter @Getter
    private String firstName;

    @Column(name = "last_name", length = 50)
    @Setter @Getter
    private String lastName;

    @Column(columnDefinition = "varchar(1)")
    @Enumerated(EnumType.STRING)
    @Setter @Getter
    private Gender gender;

    @Setter @Getter
    private String major;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    @Setter @Getter
    private Date birthDate;
}
