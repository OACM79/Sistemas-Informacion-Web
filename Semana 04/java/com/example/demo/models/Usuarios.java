package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@NotNull
	@Column(unique = true)
	private String username;

	@ManyToOne
	@JoinColumn(name = "id_rol")
	@NotNull
	private Roles rol;

	@Size(max = 50)
	@NotNull
	private String descripcion;

	@Size(max = 255)
	@NotNull
	private String contrasena;

	@NotNull
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private Sucursales sucursal;
	
	public Roles getRol() {
		return rol;
	}
	 
	public boolean isEstado() {
		return estado;
	}
	 
	public String getUsername() {
		return username;
	}
 
	public String getContrasena() {
		return contrasena;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public Long getId() {
		return id;
	}
	
	public Sucursales getSucursal() {
		return sucursal;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	
	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
