package com.rahdevelopers.api.usuarios.service;

import java.util.List;

import com.rahdevelopers.api.usuarios.dto.UsuarioDto;

public interface UsuarioService {

	public UsuarioDto findByUserName(String userName);

	public List<UsuarioDto> getAll();

	public UsuarioDto create(UsuarioDto usuarioDto);
}
