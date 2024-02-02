package com.example.hiberspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hiberspring.model.User;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	static Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	Boolean existsByUsername(String username);
}
