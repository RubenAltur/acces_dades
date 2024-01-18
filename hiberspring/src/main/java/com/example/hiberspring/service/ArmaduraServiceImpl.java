package com.example.hiberspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hiberspring.dto.ArmaduraDTO;
import com.example.hiberspring.model.Armadura;
import com.example.hiberspring.repository.ArmaduraRepository;



public class ArmaduraServiceImpl implements ArmaduraService {
	@Autowired
	private ArmaduraRepository aR;
	@Override
	public ArmaduraDTO saveA(ArmaduraDTO aDTO) {
		Armadura a = ArmaduraDTO.convertToEntity(aDTO);
		aR.save(a);
		return aDTO;
	}

	@Override
	public void deleteArmadura(int id) {
		aR.deleteById(id);
	}

	@Override
	public ArmaduraDTO getArmaduraById(int id) {
		Optional<Armadura> a= aR.findById(id);
		if(a.isPresent()) {
			return ArmaduraDTO.convertToDTO(a.get());
		}else {return null;}
	}

	@Override
	public List<ArmaduraDTO> listAllA() {
		List<Armadura> llista=aR.findAll();
		List<ArmaduraDTO> llistaEnviar=new ArrayList<ArmaduraDTO>();
		for(int i = 0; i < llista.size(); ++i) {
			llistaEnviar.add(ArmaduraDTO.convertToDTO(llista.get(i)));
		}
		return llistaEnviar;
	}

}
