package com.josalf.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class t_calificaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id_t_calificaciones;
	
	@Column(name="id_t_materias",
            table="t_calificaciones")
	public Integer id_t_materias;
	
	@Column(name="id_t_usuarios",
    table="t_calificaciones")
	public Integer id_t_usuarios;
	
	@Column(name="calificacion",
    table="t_calificaciones")
	public double calificacion;
	
	
	@Column(name="fecha_registro",
    table="t_calificaciones")
	public String fecha_registro;

}
