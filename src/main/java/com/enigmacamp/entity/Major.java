package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "M_MAJOR")
@ToString
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    @Setter @Getter
    private long majorId;

    @Column(name = "major_name", nullable = false, length = 100)
    @Setter @Getter
    private String majorName;

    @OneToMany(mappedBy = "major")
    @Setter @Getter
    private List<Student> studentList;
}
