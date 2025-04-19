package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "sucursales")
@Data
public class Sucursales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sucursal")
	private Long id;

	@Size(max = 100)
	private String descripcion;

	@Size(max = 100)
	private String direccion;

	@Size(max = 100)
	private String telefono;
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
