package com.josalf.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.josalf.project.modelo.t_alumnos;
import com.josalf.project.modelo.t_calificaciones;
import com.josalf.project.modelo.EntityCalificacionesJoin;
import com.josalf.project.modelo.PokemonResponse;
import com.josalf.project.modelo.RequestActualizarCalificacion;
import com.josalf.project.modelo.RespuestaActualizaCalificacion;
import com.josalf.project.modelo.RespuestaEliminarCalificacion;
import com.josalf.project.modelo.requestCalificacion;
import com.josalf.project.modelo.responseInsertarCalificacion;
import com.josalf.project.modelo.respuestaCalificacionesPromedio;
import com.josalf.project.servicio.PokemonService;

@RestController
@RequestMapping("/API")
public class ServicioRestcontroller {
	
	@Autowired
	private PokemonService pokeServ;

	@RequestMapping(value = "/obtener/pokemon", method = RequestMethod.GET)
	public PokemonResponse obtener() {

		return pokeServ.getApi();
	}
	
	@RequestMapping(value = "/hola", method = RequestMethod.GET)
	public String helloWorld(@RequestParam(defaultValue = "World") String name) {

		return "Hello "+name+"!!";
	}
	
	@RequestMapping(value = "/obtenerPoke", method = RequestMethod.GET)
	public String obtenerPoke(@RequestParam(defaultValue = "Pokemons") String name) {

		return "Hello "+name+"!!";
	}
	
	@RequestMapping(value = "/obtenerAlumnos", method = RequestMethod.GET)
	public List<t_alumnos> obtenerAlumnos() {
		
		return pokeServ.obtenerTodosalumnos();
	}
	
	@RequestMapping(value = "/InsertarCalificacion", method = RequestMethod.POST)
	public @ResponseBody responseInsertarCalificacion insertar(@RequestBody requestCalificacion reqCalif )
	{
		 return pokeServ.insertaCalif(reqCalif);
	}
	
	@RequestMapping(value = "/ConsultarCalificacionAlumno/{id}", method = RequestMethod.GET)
	public @ResponseBody respuestaCalificacionesPromedio obtenerCalificaciones(@PathVariable("id") Integer idAlumno)
	{
		return pokeServ.obtenerCalif(idAlumno);
	}
	
	@RequestMapping(value = "/ActualizarCalificacion", method = RequestMethod.PUT)
	public @ResponseBody RespuestaActualizaCalificacion actualizaCalif(@RequestBody RequestActualizarCalificacion reqActualizaCalif)
	{
		return pokeServ.actualizaCalif(reqActualizaCalif);
	}
	
	@RequestMapping(value = "/EliminarCalificacion/{id}", method = RequestMethod.DELETE)
	public @ResponseBody RespuestaEliminarCalificacion eliminaCalif(@PathVariable("id") Integer idCalif)
	{
		return pokeServ.eliminaCalif(idCalif);
	}

}
