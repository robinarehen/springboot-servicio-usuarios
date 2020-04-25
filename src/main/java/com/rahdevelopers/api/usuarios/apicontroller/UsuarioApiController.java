package com.rahdevelopers.api.usuarios.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahdevelopers.api.usuarios.entity.UsuarioEntity;
import com.rahdevelopers.api.usuarios.service.UsuarioServiceImpl;

@RestController
public class UsuarioApiController {
	
	@Autowired
	private UsuarioServiceImpl serviceImpl;

	@GetMapping("/findbyusername")
	public UsuarioEntity getByUserName(@RequestParam("username") String userName) {
		return this.serviceImpl.findByUserName(userName);
	}
}
