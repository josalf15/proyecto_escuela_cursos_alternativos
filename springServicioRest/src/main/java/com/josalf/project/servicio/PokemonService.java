package com.josalf.project.servicio;

import com.josalf.project.modelo.t_alumnos;

import java.util.List;

import com.josalf.project.modelo.PokemonResponse;
import com.josalf.project.modelo.RequestActualizarCalificacion;
import com.josalf.project.modelo.RespuestaActualizaCalificacion;
import com.josalf.project.modelo.RespuestaEliminarCalificacion;
import com.josalf.project.modelo.requestCalificacion;
import com.josalf.project.modelo.responseInsertarCalificacion;
import com.josalf.project.modelo.respuestaCalificacionesPromedio;

public interface PokemonService {
	PokemonResponse getApi();
	String gestApiUniRest();
	List<t_alumnos> obtenerTodosalumnos();
	responseInsertarCalificacion insertaCalif(requestCalificacion reqCalif);
	respuestaCalificacionesPromedio obtenerCalif(Integer idAlum);
	RespuestaActualizaCalificacion actualizaCalif(RequestActualizarCalificacion requestActCalif);
	RespuestaEliminarCalificacion eliminaCalif(Integer idCalif);
}
