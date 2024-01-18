package com.example.hiberspring.dto;

import com.example.hiberspring.model.Armadura;
import com.example.hiberspring.model.Monstruo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class ArmaduraDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarma")  
    private int idarma;
    
    @Column(name = "nom")
    private String nom;
    
    @Column
    private Monstruo monstruo;

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
    
	public static ArmaduraDTO convertToDTO(Armadura armadura) {
    	ArmaduraDTO armad = new ArmaduraDTO();
    	armad.setIdarma(armadura.getIdarma());
    	armad.setMonstruo(armadura.getMonstruo());
    	armad.setNom(armadura.getNom());
		return armad;   	
    }
    public static Armadura convertToEntity(ArmaduraDTO armaduraDTO) {
    	Armadura arma = new Armadura();
    	arma.setIdarma(armaduraDTO.getIdarma());
    	arma.setMonstruo(armaduraDTO.getMonstruo());
    	arma.setNom(armaduraDTO.getNom());
		return arma;   	
    }
	
}
