package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sys_user_credential")
@ToString
public class UserCredential {
    @Id
    @Setter @Getter
    private String username;

    @Setter @Getter
    private String password;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    @OneToOne
//    @JoinColumn(name = "student_id")
//    @Setter @Getter
//    private Student student;

    @OneToOne(mappedBy = "userCredential")
    @Setter @Getter
    private Student student;
}
