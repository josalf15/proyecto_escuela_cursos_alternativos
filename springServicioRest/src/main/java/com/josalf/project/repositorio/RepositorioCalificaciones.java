package com.josalf.project.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.josalf.project.modelo.t_calificaciones;


@Repository
public interface RepositorioCalificaciones extends JpaRepository<t_calificaciones, Integer>{
	
	@Query(value = "SELECT * FROM t_calificaciones WHERE t_calificaciones.id_t_usuarios = ?1", nativeQuery = true)
	List<t_calificaciones> obtenerCalififcacionId(Integer id_t_usuarios);
	
	@Query(value = "SELECT SUM(calificacion)/ (SELECT COUNT(*) FROM t_calificaciones t_calificaciones WHERE t_calificaciones.id_t_usuarios = ?1)\n"
			+ " FROM t_calificaciones WHERE t_calificaciones.id_t_usuarios = ?1", nativeQuery = true)
	double obtenerPromedioAlumno(Integer id_t_usuarios);

	
	

}
