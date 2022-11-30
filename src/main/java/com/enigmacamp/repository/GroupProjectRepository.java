package com.enigmacamp.repository;

import com.enigmacamp.entity.GroupProject;

public interface GroupProjectRepository {
    void create(GroupProject groupProject);
    GroupProject findOne(long id);
}
