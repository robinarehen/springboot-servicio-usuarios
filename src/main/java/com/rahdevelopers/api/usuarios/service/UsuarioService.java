package com.rahdevelopers.api.usuarios.service;

import com.rahdevelopers.api.usuarios.dto.UsuarioDto;

public interface UsuarioService {

	public UsuarioDto findByUserName(String userName);
}
