package com.josalf.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class t_alumnos {
	
	 @Id 
	 public Integer id_t_usuarios;
	
	@Column(name="nombre",
            table="t_alumnos")
	public String nombre;
	
	@Column(name="ap_paterno",
            table="t_alumnos")
	public String ap_paterno;
	
	@Column(name="ap_materno",
            table="t_alumnos")
	public String ap_materno;
	
	@Column(name="activo",
            table="t_alumnos")
	public int activo;

}
