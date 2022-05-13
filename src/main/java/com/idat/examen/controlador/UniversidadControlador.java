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

import com.idat.examen.Servicio.UniversidadServicio;
import com.idat.examen.model.Universidades;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadControlador {
	@Autowired
	private UniversidadServicio servicio;
	
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidades>>  listarUniversidad(){
		return new ResponseEntity<List<Universidades>> (servicio.listarUniversidades(),HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)	
	public ResponseEntity<Void>guardar(@RequestBody Universidades universidad){
		servicio.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	
	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidades> listarPorId(@PathVariable Integer id) {
		
		Universidades u = servicio.obtenerUniversidadId(id);
		if(u!= null)
			return new ResponseEntity<Universidades>(u, HttpStatus.OK);
		return new ResponseEntity<Universidades>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void>editar(@RequestBody Universidades universidad){
		Universidades u = servicio.obtenerUniversidadId(universidad.getIdUniversidad());
		
		if(u !=null ) {
			servicio.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		Universidades u =  servicio.obtenerUniversidadId(id);
		if (u!= null ) {
			servicio.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
			 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
			
	}

}
