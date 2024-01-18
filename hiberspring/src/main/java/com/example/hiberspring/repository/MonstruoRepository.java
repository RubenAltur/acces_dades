package com.example.hiberspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hiberspring.model.Monstruo;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface MonstruoRepository extends JpaRepository<Monstruo, Integer>{

}
