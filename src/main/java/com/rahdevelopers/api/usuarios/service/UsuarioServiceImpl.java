package com.rahdevelopers.api.usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahdevelopers.api.usuarios.entity.UsuarioEntity;
import com.rahdevelopers.api.usuarios.repository.UsuarioRepository;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioEntity findByUserName(String userName) {
		return this.usuarioRepository.findByUserName(userName);
	}
}
