package com.example.hiberspring.service;

import java.util.List;

import com.example.hiberspring.dto.ArmaduraDTO;


public interface ArmaduraService {
	ArmaduraDTO saveA(ArmaduraDTO ADTO);
	ArmaduraDTO getArmaduraById(int id);
	List<ArmaduraDTO> listAllA();
	void deleteArmadura(int id);

}
