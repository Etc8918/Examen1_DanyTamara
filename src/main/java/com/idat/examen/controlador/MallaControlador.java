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

import com.idat.examen.Servicio.MallaServicio;
import com.idat.examen.model.Mallas;



@RestController
@RequestMapping("/malla/v1")
public class MallaControlador {
	
	@Autowired
	private MallaServicio servicio;
	
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Mallas>>  listarMallas(){
		return new ResponseEntity<List<Mallas>> (servicio.listarMallas(),HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)	
	public ResponseEntity<Void>guardar(@RequestBody Mallas malla){
		servicio.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	
	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mallas> listarPorId(@PathVariable Integer id) {
		
		Mallas m = servicio.obtenerMallaId(id);
		if(m!= null)
			return new ResponseEntity<Mallas>(m, HttpStatus.OK);
		return new ResponseEntity<Mallas>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void>editar(@RequestBody Mallas malla){
		Mallas m = servicio.obtenerMallaId(malla.getIdMalla());
		
		if(m !=null ) {
			servicio.editarMallas(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		Mallas m =  servicio.obtenerMallaId(id);
		if (m!= null ) {
			servicio.eliminarMallas(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
			 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
			
	}

}
