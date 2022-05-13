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

import com.idat.examen.Servicio.CursoServicio;
import com.idat.examen.dto.CursoDTORequest;
import com.idat.examen.dto.CursoDTOResponse;
import com.idat.examen.model.Cursos;


@RestController
@RequestMapping("/curso/v1")
public class CursoControlador {
	
	@Autowired
	private CursoServicio servicio;
	
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>>  listarCursos(){
		return new ResponseEntity<List<CursoDTOResponse>> (servicio.listarCursos(),HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)	
	public ResponseEntity<Void>guardar(@RequestBody CursoDTORequest curso){
		servicio.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	
	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<CursoDTOResponse> listarPorId(@PathVariable Integer id) {
		
		CursoDTOResponse c = servicio.obtenerCursoId(id);
		if(c!= null)
			return new ResponseEntity<CursoDTOResponse>(c, HttpStatus.OK);
		return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void>editar(@RequestBody CursoDTORequest curso){
		CursoDTOResponse c = servicio.obtenerCursoId(curso.getIdCursoDTO());
		
		if(c !=null ) {
			servicio.editarCursos(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		CursoDTOResponse c =  servicio.obtenerCursoId(id);
		if (c!= null ) {
			servicio.eliminarCursos(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
			 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
			
	}

}
