package com.example.project.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.jwt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

Optional<User> findByEmail(String email);

}
