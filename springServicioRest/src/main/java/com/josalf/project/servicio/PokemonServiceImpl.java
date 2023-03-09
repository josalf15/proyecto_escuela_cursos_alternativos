package com.josalf.project.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josalf.project.modelo.t_alumnos;
import com.josalf.project.modelo.t_calificaciones;
import com.josalf.project.modelo.EntityCalificacionesJoin;
import com.josalf.project.modelo.PokemonResponse;
import com.josalf.project.modelo.RequestActualizarCalificacion;
import com.josalf.project.modelo.RespuestaActualizaCalificacion;
import com.josalf.project.modelo.RespuestaEliminarCalificacion;
import com.josalf.project.modelo.ResultadoQueryCalifAlumnoMateria;
import com.josalf.project.modelo.requestCalificacion;
import com.josalf.project.modelo.responseInsertarCalificacion;
import com.josalf.project.modelo.respuestaCalificacionesPromedio;
import com.josalf.project.repositorio.RepositorioAlumno;
import com.josalf.project.repositorio.RepositorioCalifAlumnoMateria;
import com.josalf.project.repositorio.RepositorioCalificaciones;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService{
	
	@Override
	public PokemonResponse getApi() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);
		String uri =  "https://pokeapi.co/api/v2/pokemon";
		ResponseEntity<PokemonResponse> response = restTemplate.getForEntity(uri, PokemonResponse.class);
		if (response.getStatusCode().is2xxSuccessful()) {
            
            return response.getBody();
        }
        throw new RuntimeException("Error");
	}

	@Override
	public String gestApiUniRest() {
		// TODO Auto-generated method stub
		return "otro metodo";
	}
	
	@Autowired
	RepositorioAlumno repoalum;

	@Override
	public List<t_alumnos> obtenerTodosalumnos() {
		
		return repoalum.findAll();
	}
	
	@Autowired
	RepositorioCalificaciones repoCalif;

	@Override
	public responseInsertarCalificacion insertaCalif(requestCalificacion reqCalif) {
		
		t_calificaciones tCalif = new t_calificaciones();
		tCalif.id_t_calificaciones = reqCalif.id_t_calificaciones;
		tCalif.id_t_materias = reqCalif.id_t_materias;
		tCalif.id_t_usuarios = reqCalif.id_t_usuarios;
		tCalif.calificacion = reqCalif.calificacion;
		tCalif.fecha_registro = reqCalif.fecha_registro;
		
		repoCalif.save(tCalif);
		
		responseInsertarCalificacion respCalif = new responseInsertarCalificacion(); 
		
		respCalif.success = "OK";
		
		respCalif.msg = "Insertado correctamente";
		
		return respCalif;
	}
	
	@Autowired
	RepositorioCalifAlumnoMateria repoCalifAlumMate;

	@Override
	public respuestaCalificacionesPromedio obtenerCalif(Integer idAlumno) {
		
		respuestaCalificacionesPromedio respJsonCalifPromedio = new respuestaCalificacionesPromedio();
		respJsonCalifPromedio.listaCalificacionesAlumno = repoCalifAlumMate.obtenerCalifAlumnoMateria(idAlumno);
		respJsonCalifPromedio.promedio = repoCalif.obtenerPromedioAlumno(idAlumno);
		System.out.println("se consulta correctamente bd y asigna la clase de respuesta join" + respJsonCalifPromedio.listaCalificacionesAlumno.toString());
		System.out.println("se consulta correctamente bd y asigna promedio a la clase: " + respJsonCalifPromedio.promedio);

		return respJsonCalifPromedio;
	}

	@Override
	public RespuestaActualizaCalificacion actualizaCalif(RequestActualizarCalificacion reqActualizaCalif) {
		
		RespuestaActualizaCalificacion respJsonActualizaCalif = new RespuestaActualizaCalificacion();
		
		Optional<t_calificaciones> tCalif = repoCalif.findById(reqActualizaCalif.idCalificacion);
		
		t_calificaciones tablaCalif = new t_calificaciones();
		
		tablaCalif.id_t_calificaciones = tCalif.get().id_t_calificaciones;
		tablaCalif.id_t_materias = tCalif.get().id_t_materias;
		tablaCalif.id_t_usuarios = tCalif.get().id_t_usuarios;
		tablaCalif.calificacion = reqActualizaCalif.calificacionActualiza;
		tablaCalif.fecha_registro = tCalif.get().fecha_registro;
		
		repoCalif.save(tablaCalif);
		
		respJsonActualizaCalif.msg = "ok";
		respJsonActualizaCalif.success = "calificacion actualizada";
		
		
		return respJsonActualizaCalif;
	}

	@Override
	public RespuestaEliminarCalificacion eliminaCalif(Integer idCalif) {
		
		repoCalif.deleteById(idCalif);
		
		RespuestaEliminarCalificacion respElimCal = new RespuestaEliminarCalificacion();
		respElimCal.msg = "calificacion eliminada";
		respElimCal.success = "ok";
		
		return respElimCal;
	}


}
