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
import com.example.hiberspring.dto.ArmaduraDTO;
import com.example.hiberspring.service.ArmaduraServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ArmaduraController {

	@Autowired
	private ArmaduraServiceImpl armaservice;
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

	@GetMapping("/armadura")
	public List<ArmaduraDTO> listArma() {
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		List<ArmaduraDTO> LasArmaduras = armaservice.listAllA();
		return LasArmaduras;

	}

	@GetMapping("/armadura/{idarma}")
	public ArmaduraDTO showArmaduraId(@PathVariable int idarma) {
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		ArmaduraDTO arma = armaservice.getArmaduraById(idarma);
		return arma;

	}

	@PostMapping("/armadura")
	public ResponseEntity<ArmaduraDTO> addArmadura(@RequestBody ArmaduraDTO newArma) {
		myLog.info(context.getMethod() + context.getRequestURI());
		ArmaduraDTO armadura = armaservice.saveA(newArma);
		if (armadura == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(armadura, HttpStatus.OK);
	}

@PutMapping("/armadura")
public ResponseEntity<ArmaduraDTO> updateArmadura(@RequestBody ArmaduraDTO
updArma) {

 myLog.info(context.getMethod() + context.getRequestURI());
 ArmaduraDTO elarma= armaservice.getArmaduraById(updArma.getIdarma());
 if (elarma==null)
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 else {

	 ArmaduraDTO armaUPD= armaservice.saveA(elarma);
;
 return new ResponseEntity<>(armaUPD,HttpStatus.OK);
 }
}
 
 @DeleteMapping("/armadura/{idarma}")
  public ResponseEntity<String> deleteArmadura(@PathVariable int idarma){
	 armaservice.deleteArmadura(idarma);
	 return new ResponseEntity<>("Armadura borrada",HttpStatus.OK);
 }

 }

