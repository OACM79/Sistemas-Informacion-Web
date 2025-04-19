package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Departamentos;
import com.example.demo.repositories.DepartamentosRepository;
import com.example.demo.services.DepartamentosService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartamentosServiceImpl implements DepartamentosService {
	
	@Autowired
	private DepartamentosRepository departamentosRepository;

	@Override
	public List<Departamentos> getAllDepartamentos() {
		return this.departamentosRepository.findByAll();
	}

	@Override
	public Optional<Departamentos> getDepartamentoById(Long id) {
		return this.departamentosRepository.findById(id);
	}

	@Override
	public void saveDepartamento(Departamentos departamento) {
		if (Objects.nonNull(departamento)) {
			this.departamentosRepository.save(departamento);
		}
	}

	@Override
	public void deleteDepartamento(Long id) {
		if(Objects.nonNull(id)) {
			this.departamentosRepository.findById(id).ifPresent(pais -> this.departamentosRepository.delete(pais));
		}
	}

}
