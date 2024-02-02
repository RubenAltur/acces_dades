package com.example.hiberspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hiberspring.model.ERole;
import com.example.hiberspring.model.Role;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole roleUser);

}
