package com.enigmacamp;

import com.enigmacamp.constant.Gender;
import com.enigmacamp.entity.Student;
import com.enigmacamp.entity.UserCredential;
import com.enigmacamp.repository.AuthenticationRepository;
import com.enigmacamp.repository.AuthenticationRepositoryImpl;
import com.enigmacamp.repository.StudentRepository;
import com.enigmacamp.repository.StudentRepositoryImpl;
import com.enigmacamp.util.GenerateDateUtil;
import com.enigmacamp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);
        AuthenticationRepository authenticationRepository = new AuthenticationRepositoryImpl(entityManager);
        UserCredential userCredential = new UserCredential();
        Student student = new Student();

//        // 1. Register student, register cred
//        // REGISTER STUDENT
//        student.setFirstName("Boba");
//        student.setLastName("Bob");
//        student.setGender(Gender.M);
//        student.setMajor("Informatics");
//        student.setBirthDate(GenerateDateUtil.generateDate("2022-08-16"));
//        student.setUserCredential(userCredential);
//        studentRepository.create(student);
//
//        // REGISTER CRED
//        userCredential.setUsername("BOBOB");
//        userCredential.setPassword("12345");
//        authenticationRepository.create(userCredential);


        // 2. Register student + cred
        // REGISTER CRED
        userCredential.setUsername("BOBOB");
        userCredential.setPassword("12345");

        // REGISTER STUDENT
        student.setFirstName("Boba");
        student.setLastName("Bob");
        student.setGender(Gender.M);
        student.setMajor("Informatics");
        student.setBirthDate(GenerateDateUtil.generateDate("2022-08-16"));
        student.setUserCredential(userCredential);
        userCredential.setStudent(student);
        studentRepository.create(student);

//        student = studentRepository.getById(2);
//        System.out.println(student);
//        entityManager.detach(student);
//        Thread.sleep(5000);
//        System.out.println("==========================");
//        System.out.println(student.getUserCredential());

        UserCredential userCredential2 = authenticationRepository.getById("BOBOB");
        System.out.println(userCredential2);
        System.out.println(userCredential2.getStudent());
    }
}