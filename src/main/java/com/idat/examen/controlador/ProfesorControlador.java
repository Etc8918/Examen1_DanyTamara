package com.idat.examen.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.examen.Servicio.ProfesorServicio;
import com.idat.examen.model.Profesores;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorControlador {
	@Autowired
	private ProfesorServicio servicio;
	
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesores>>  listarProfesor(){
		return new ResponseEntity<List<Profesores>> (servicio.listarProfesores(),HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)	
	public ResponseEntity<Void>guardar(@RequestBody Profesores profesor){
		servicio.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	
	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesores> listarPorId(@PathVariable Integer id) {
		
		Profesores p = servicio.obtenerProfesorId(id);
		if(p!= null)
			return new ResponseEntity<Profesores>(p, HttpStatus.OK);
		return new ResponseEntity<Profesores>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void>editar(@RequestBody Profesores profesor){
		Profesores p = servicio.obtenerProfesorId(profesor.getIdProfesor());
		
		if(p !=null ) {
			servicio.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		Profesores p =  servicio.obtenerProfesorId(id);
		if (p!= null ) {
			servicio.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
			 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
			
	}
	
	

}
