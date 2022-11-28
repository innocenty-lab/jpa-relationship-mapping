package com.enigmacamp.repository;

import com.enigmacamp.entity.Major;

public interface MajorRepository {
    void create(Major major);
    Major findOne(long id);
}
