package com.enigmacamp;

import com.enigmacamp.constant.Gender;
import com.enigmacamp.entity.GroupProject;
import com.enigmacamp.entity.Major;
import com.enigmacamp.entity.Student;
import com.enigmacamp.entity.UserCredential;
import com.enigmacamp.repository.*;
import com.enigmacamp.util.GenerateDateUtil;
import com.enigmacamp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        MajorRepository majorRepository = new MajorRepositoryImpl(entityManager);
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);
        AuthenticationRepository authenticationRepository = new AuthenticationRepositoryImpl(entityManager);
        GroupProjectRepository groupProjectRepository = new GroupProjectRepositoryImpl(entityManager);
        Major major = new Major();
        UserCredential userCredential = new UserCredential();
        Student student = new Student();
        GroupProject groupProject = new GroupProject();

        // Major, register student + cred
        // CREATED MAJOR
        major.setMajorName("Informatics");
        majorRepository.create(major);

        // REGISTER CRED
        userCredential.setUsername("BOBOB");
        userCredential.setPassword("12345");

        // CREATE GROUP PROJECT
        groupProject.setProjectName("React Native Framework Documentation");
        groupProjectRepository.create(groupProject);


        // REGISTER STUDENT
        student.setFirstName("Boba");
        student.setLastName("Bob");
        student.setGender(Gender.M);
        student.setMajor(major);
        student.setBirthDate(GenerateDateUtil.generateDate("2022-08-16"));
        student.setUserCredential(userCredential);
        userCredential.setStudent(student);
        student.getGroupProjectList().add(groupProject);
        groupProject.getStudentList().add(student);
        studentRepository.create(student);
    }
}