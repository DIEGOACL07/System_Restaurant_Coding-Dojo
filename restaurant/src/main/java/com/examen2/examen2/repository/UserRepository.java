package com.examen2.examen2.repository;

import com.examen2.examen2.models.User;

public interface UserRepository extends BaseRepository<User> {
    User findByEmail(String email);
}