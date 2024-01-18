package com.example.hiberspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.hiberspring.dto.MonstruoDTO;
import com.example.hiberspring.model.Monstruo;
import com.example.hiberspring.repository.MonstruoRepository;

public class MonstruoServiceImpl implements MonstruoService {
	@Autowired
	private MonstruoRepository mR;
	
	@Override
	public MonstruoDTO saveM(MonstruoDTO MDTO) {
		Monstruo m =MonstruoDTO.convertToEntity(MDTO);
		mR.save(m);
		return MDTO;
	}

	@Override
	public MonstruoDTO getMonstruoById(int id) {
		Optional<Monstruo> a= mR.findById(id);
		if(a.isPresent()) {
			return MonstruoDTO.convertToDTO(a.get());
		}else {return null;}
	}

	@Override
	public List<MonstruoDTO> listAllM() {
		List<Monstruo> llista=mR.findAll();
		List<MonstruoDTO> llistaEnviar=new ArrayList<MonstruoDTO>();
		for(int i = 0; i < llista.size(); ++i) {
			llistaEnviar.add(MonstruoDTO.convertToDTO(llista.get(i)));
		}
		return llistaEnviar;
	}

	@Override
	public void deleteMonstruo(int id) {
		mR.deleteById(id);
		
	}

	
	
	
}
