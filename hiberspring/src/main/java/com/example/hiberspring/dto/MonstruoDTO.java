package com.example.hiberspring.dto;

import com.example.hiberspring.model.Monstruo;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class MonstruoDTO {
	  @Id
	    @Column(name = "idmon")
	    private int idmon;

	    @Column(name = "nom")
	    private String nom;

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
	    
	    public static MonstruoDTO convertToDTO(Monstruo monstruo) {
	    	MonstruoDTO monDTO = new MonstruoDTO();
	    	monDTO.setIdmon(monstruo.getIdmon());
	    	monDTO.setNom(monstruo.getNom());
			return monDTO;   	
	    }
	    public static Monstruo convertToEntity(MonstruoDTO monstruoDTO) {
	    	Monstruo mon = new Monstruo();
	    	mon.setIdmon(monstruoDTO.getIdmon());
	    	mon.setNom(monstruoDTO.getNom());
			return mon;   	
	    }
}
