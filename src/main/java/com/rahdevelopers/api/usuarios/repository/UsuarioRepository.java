package com.rahdevelopers.api.usuarios.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rahdevelopers.api.usuarios.entity.UsuarioEntity;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long> {

	public Optional<UsuarioEntity> findByUserName(String userName);

}
