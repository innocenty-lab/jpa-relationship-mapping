package com.enigmacamp.repository;

import com.enigmacamp.entity.UserCredential;

public interface AuthenticationRepository {
    void create(UserCredential userCredential);
    UserCredential getById(String id);
}
