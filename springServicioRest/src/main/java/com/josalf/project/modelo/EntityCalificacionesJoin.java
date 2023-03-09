package com.josalf.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_calificaciones")
@SecondaryTable(name = "t_alumnos")
@SecondaryTable(name = "t_materias")
public class EntityCalificacionesJoin {
	
	@Id
	public Integer id_t_calificaciones;
	
	@Column(name = "id_t_usuarios")
	public Integer idusuario;
	
	@Column(name = "nombre")
	public String nombre;
	

	@Column(name = "ap_paterno")
	public String ap_paterno;
	
	@Column(name = "nombrem")
	public String nombrem;
	
	@Column(name="calificacion",
    table="t_calificaciones")
	public double calificacion;
	
	
	@Column(name="fecha_registro",
    table="t_calificaciones")
	public String fecha_registro;
	

}
