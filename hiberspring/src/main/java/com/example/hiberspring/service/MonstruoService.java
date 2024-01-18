package com.example.hiberspring.service;

import java.util.List;

import com.example.hiberspring.dto.MonstruoDTO;

public interface MonstruoService {
	MonstruoDTO saveM(MonstruoDTO MDTO);
	MonstruoDTO getMonstruoById(int id);
	List<MonstruoDTO> listAllM();
	void deleteMonstruo(int id);

}
