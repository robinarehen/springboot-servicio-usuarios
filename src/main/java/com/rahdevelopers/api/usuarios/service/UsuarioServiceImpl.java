package com.rahdevelopers.api.usuarios.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahdevelopers.api.usuarios.dto.UsuarioDto;
import com.rahdevelopers.api.usuarios.entity.UsuarioEntity;
import com.rahdevelopers.api.usuarios.entity.UsuarioRoleEntity;
import com.rahdevelopers.api.usuarios.repository.UsuarioRepository;
import com.rahdevelopers.api.usuarios.repository.UsuarioRoleRepository;
import com.rahdevelopers.api.usuarios.util.ObjectMapperUtil;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;
	private UsuarioRoleRepository usuarioRoleRepository;
	private ObjectMapperUtil mapperUtil;

	@Value("${minimum-age}")
	private Integer minimumAge;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioRoleRepository usuarioRoleRepository,
			ObjectMapperUtil mapperUtil) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.usuarioRoleRepository = usuarioRoleRepository;
		this.mapperUtil = mapperUtil;
	}

	@Override
	public UsuarioDto findByUserName(String userName) {
		return this.usuarioRepository.findByUserName(userName).map(entity -> {
			return this.mapperUtil.entityToDto(UsuarioDto.class, entity);
		}).orElseThrow(() -> new IllegalArgumentException("Usuario Invalido"));
	}

	@Override
	public List<UsuarioDto> getAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll().stream().filter(value -> value.getEnabled()).map(entity -> {
			return this.mapperUtil.entityToDto(UsuarioDto.class, entity);
		}).collect(Collectors.toList());
	}

	@Override
	public UsuarioDto create(UsuarioDto usuarioDto) {
		// TODO Auto-generated method stub
		if (!this.isValidBirthDate(usuarioDto)) {
			throw new IllegalArgumentException("El usuario debe ser mayor de edad.");
		}

		if (this.usuarioRepository.findByUserName(usuarioDto.getUserName()).isPresent()) {
			throw new IllegalArgumentException("El usuario ya existe.");
		}

		UsuarioEntity usuarioEntity = this.mapperUtil.dtoToEntity(UsuarioEntity.class, usuarioDto);

		usuarioEntity = this.usuarioRepository.save(usuarioEntity);

		this.createUsersRoles(usuarioEntity);

		return this.mapperUtil.entityToDto(UsuarioDto.class, usuarioEntity);
	}

	private void createUsersRoles(UsuarioEntity usuarioEntity) {
		usuarioEntity.getRoles().stream().forEach(valueEntity -> {
			UsuarioRoleEntity entity = new UsuarioRoleEntity();
			entity.setUsuario(usuarioEntity.getID());
			entity.setRole(valueEntity.getID());
			this.usuarioRoleRepository.save(entity);
		});
	}

	/**
	 * The age must be greater than fourteen years
	 * 
	 * @return
	 */
	private Boolean isValidBirthDate(UsuarioDto usuarioDto) {
		LocalDate currentDate = LocalDate.now();

		Period period = Period.between(usuarioDto.getBirthDate(), currentDate);

		if (period.getYears() < this.minimumAge) {
			return false;
		}

		return true;
	}

}
