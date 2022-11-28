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

    @Column(nullable = false)
    @Setter @Getter
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "userCredential")
    @Setter @Getter
    private Student student;
}
