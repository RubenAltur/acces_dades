package com.example.hiberspring.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "armadura")
public class Armadura implements Serializable {
    static final long serialVersionUID=137L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarma")  
    private int idarma;
    
    @Column(name = "nom")
    private String nom;
    
    

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
    name="monstruo",
    referencedColumnName = "idmon",
    unique=true,
    foreignKey = @ForeignKey(name = "FK_GRP_TEACH"))
    private Monstruo monstruo;

    @Override
    public String toString() {
        return "armadura " + "idarma=" + idarma + ", nom=" + nom + ", monstruo=" + monstruo + "\n";
    }

    public Armadura() {
    }

    public int getIdarma() {
        return idarma;
    }

    public void setIdarma(int idarma) {
        this.idarma = idarma;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Monstruo getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }
    
    
    
    
}
