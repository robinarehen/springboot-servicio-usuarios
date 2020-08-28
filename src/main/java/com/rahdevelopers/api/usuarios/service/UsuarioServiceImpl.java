package com.rahdevelopers.api.usuarios.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahdevelopers.api.usuarios.dto.UsuarioDto;
import com.rahdevelopers.api.usuarios.repository.UsuarioRepository;
import com.rahdevelopers.api.usuarios.util.ObjectMapperUtil;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;
	private ObjectMapperUtil mapperUtil;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ObjectMapperUtil mapperUtil) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.mapperUtil = mapperUtil;
	}

	@Override
	public UsuarioDto findByUserName(String userName) {
		return this.usuarioRepository.findByUserName(userName).map( entity ->{
			return this.mapperUtil.entityToDto(UsuarioDto.class, entity);
		}).orElseThrow(() -> new IllegalArgumentException());
	}
}
