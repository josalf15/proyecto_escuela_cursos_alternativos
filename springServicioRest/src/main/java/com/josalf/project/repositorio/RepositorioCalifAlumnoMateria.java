package com.josalf.project.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.josalf.project.modelo.EntityCalificacionesJoin;

@Repository
public interface RepositorioCalifAlumnoMateria extends JpaRepository<EntityCalificacionesJoin, Integer>{

	@Query (value = "SELECT TC.id_t_calificaciones,TC.id_t_usuarios, TA.nombre, TA.ap_paterno, TM.nombre AS nombrem, TC.calificacion,TC.fecha_registro\n"
			+ "FROM t_calificaciones TC \n"
			+ "INNER JOIN t_alumnos TA \n"
			+ "ON TC.id_t_usuarios = TA.id_t_usuarios\n"
			+ "INNER JOIN t_materias TM \n"
			+ "ON TC.id_t_materias = TM.id_t_materias\n"
			+ "WHERE TC.id_t_usuarios = ?1", nativeQuery = true)
	List<EntityCalificacionesJoin> obtenerCalifAlumnoMateria(Integer id_t_usuarios);
}
