package com.example.jwtpracticeapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtpracticeapp.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{

    User findByUsername(String username);

}
