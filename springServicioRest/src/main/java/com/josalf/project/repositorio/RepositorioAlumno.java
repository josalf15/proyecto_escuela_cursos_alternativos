package com.josalf.project.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josalf.project.modelo.t_alumnos;

@Repository
public interface RepositorioAlumno extends JpaRepository<t_alumnos, Integer>{

	
}
