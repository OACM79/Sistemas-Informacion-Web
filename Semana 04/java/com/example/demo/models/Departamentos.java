package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "departamentos")
@Data
public class Departamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	@NotNull
	private Paises pais;

	@Size(max = 80)
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}
	
	public Long getId() {
		return id;
	}
	
	public Paises getPais() {
		return pais;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPais(Paises pais) {
		this.pais = pais;
	}
}
