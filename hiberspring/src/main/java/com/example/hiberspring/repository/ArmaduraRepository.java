package com.example.hiberspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hiberspring.model.Armadura;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface ArmaduraRepository extends JpaRepository<Armadura, Integer> {

}
