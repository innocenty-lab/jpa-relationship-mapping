package com.enigmacamp;

import com.enigmacamp.constant.Gender;
import com.enigmacamp.entity.Student;
import com.enigmacamp.repository.StudentRepository;
import com.enigmacamp.repository.StudentRepositoryImpl;
import com.enigmacamp.util.GenerateDateUtil;
import com.enigmacamp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);

        Student student = new Student();

        // CREATE
        student.setFirstName("Boba");
        student.setLastName("Bob");
        student.setGender(Gender.M);
        student.setMajor("Informatics");
        student.setBirthDate(GenerateDateUtil.generateDate("2022-08-16"));
        studentRepository.create(student);
    }
}