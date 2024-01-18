package com.example.hiberspring.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "monstruo")
public class Monstruo implements Serializable{
static final long serialVersionUID=137L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmon")
    private int idmon;

    @Column(name = "nom")
    private String nom;


  
    public Monstruo() {
    }

    @Override
    public String toString() {
        return "Monstruo " + "idmon= " + idmon + ", nom= " + nom  + "\n";
    }

    public int getIdmon() {
        return idmon;
    }

    public void setIdmon(int idmon) {
        this.idmon = idmon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


  
}
