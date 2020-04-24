package com.rahdevelopers.api.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rahdevelopers.api.usuarios.entity.UsuarioEntity;

@RepositoryRestResource(path = "usuario")
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long> {

	public UsuarioEntity findByUserName(String userName);

}
