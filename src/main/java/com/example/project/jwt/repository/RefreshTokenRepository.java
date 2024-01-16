package com.example.project.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.jwt.model.RefreshToken;
@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

}
