package com.josalf.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class t_materias {
	
	@Id
	public Integer id_t_materias;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="activo")
	public Integer activo;

}
