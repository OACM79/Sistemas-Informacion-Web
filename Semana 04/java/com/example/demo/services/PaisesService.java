package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Paises;
import com.example.demo.models.Roles;

public interface PaisesService {

	List<Paises> getAllPaises();

	Optional<Paises> getPaisById(Long id);

	void savePais(Paises pais);

	void deletePais(Long id);
}
