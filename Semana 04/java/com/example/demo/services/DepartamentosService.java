package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import com.example.demo.models.Departamentos;

public interface DepartamentosService {

	List<Departamentos> getAllDepartamentos();

	Optional<Departamentos> getDepartamentoById(Long id);

	void saveDepartamento(Departamentos departamento);

	void deleteDepartamento(Long id);
}
