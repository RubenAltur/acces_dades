package com.example.hiberspring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hiberspring.HiberspringApplication;
import com.example.hiberspring.dto.*;

import com.example.hiberspring.service.MonstruoServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class monstruoController {

	@Autowired
	private MonstruoServiceImpl monservice;
	private static final Logger myLog = LoggerFactory.getLogger(HiberspringApplication.class);

	@Autowired
	private HttpServletRequest context;

	@Value("$app.name")
	private String appName;

	@Value("${developer.name}")
	private String devName;

	@GetMapping("/")
	public String index() {
		String res = "Hello from Spring\n";
		res += "You are running " + appName + "\n";
		res += "Developed by " + devName;
		return res;

	}

	@GetMapping("/monstruo")
	public List<MonstruoDTO> listMon() {
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		List<MonstruoDTO> LosMon = monservice.listAllM();
		return LosMon;

	}

	@GetMapping("/monstruo/{idmon}")
	public MonstruoDTO showArmaduraId(@PathVariable int idarma) {
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		MonstruoDTO arma = monservice.getMonstruoById(idarma);
		return arma;

	}

	@PostMapping("/monstruo")
	public ResponseEntity<MonstruoDTO> addArmadura(@RequestBody MonstruoDTO newArma) {
		myLog.info(context.getMethod() + context.getRequestURI());
		MonstruoDTO mon = monservice.saveM(newArma);
		if (mon == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(mon, HttpStatus.OK);
	}

@PutMapping("/monstruo")
public ResponseEntity<MonstruoDTO> updateArmadura(@RequestBody MonstruoDTO
updArma) {

 myLog.info(context.getMethod() + context.getRequestURI());
 MonstruoDTO mon= monservice.getMonstruoById(updArma.getIdmon());
 if (mon==null)
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 else {

	 MonstruoDTO monUPD= monservice.saveM(mon);
;
 return new ResponseEntity<>(monUPD,HttpStatus.OK);
 }
}
 
 @DeleteMapping("/monstruo/{idmon}")
  public ResponseEntity<String> deleteMonstruo(@PathVariable int idmon){
	 monservice.deleteMonstruo(idmon);
	 return new ResponseEntity<>("Monstruos borrada",HttpStatus.OK);
 }

 }

