package com.userapp.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userapp.java.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
