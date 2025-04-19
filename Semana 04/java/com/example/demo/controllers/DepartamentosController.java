package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Departamentos;
import com.example.demo.models.Paises;
import com.example.demo.models.Roles;
import com.example.demo.services.DepartamentosService;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/departamentos")
@AllArgsConstructor
public class DepartamentosController {

	@Autowired
	private DepartamentosService departamentosService;

	@Autowired
	private PaisesService paisesServiceImpl;
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("departamentos", departamentosService.getAllDepartamentos());
		return "departamentos/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		List<Paises> paises = paisesServiceImpl.getAllPaises();
		model.addAttribute("departamento", new Departamentos());
		model.addAttribute("listadoPaises", paises);
		return "departamentos/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Departamentos departamento) {
		departamentosService.saveDepartamento(departamento);
		return "redirect:/departamentos";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {

		Optional<Departamentos> departamento = departamentosService.getDepartamentoById(id);

		if (departamento.isPresent()) {
			List<Paises> paises = paisesServiceImpl.getAllPaises();
			model.addAttribute("departamento", departamento.get());
			model.addAttribute("listadoPaises", paises);
			return "departamentos/formulario";
		}

		return "redirect:/departamentos";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		departamentosService.deleteDepartamento(id);
		return "redirect:/departamentos";
	}
}
