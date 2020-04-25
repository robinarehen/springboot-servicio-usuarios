package com.rahdevelopers.api.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rahdevelopers.api.usuarios.entity.UsuarioEntity;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long> {

	public UsuarioEntity findByUserName(String userName);

}
