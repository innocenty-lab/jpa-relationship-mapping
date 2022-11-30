package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "M_GROUP_PROJECT")
public class GroupProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    @Setter @Getter
    private long projectId;

    @Column(name = "project_name", nullable = false, length = 50)
    @Setter @Getter
    private String projectName;

    @ManyToMany(mappedBy = "groupProjectList")
    @Setter @Getter
    private List<Student> studentList = new ArrayList<>();
}
