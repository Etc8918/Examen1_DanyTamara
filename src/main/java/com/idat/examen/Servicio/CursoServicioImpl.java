package com.idat.examen.Servicio;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Service;

import com.idat.examen.Repositorio.CursoRepositorio;
import com.idat.examen.dto.CursoDTORequest;
import com.idat.examen.dto.CursoDTOResponse;
import com.idat.examen.model.Cursos;


@Service
public class CursoServicioImpl implements CursoServicio {
	
	@Autowired
	public CursoRepositorio repositorio;


	@Override
	public void guardarCurso(CursoDTORequest curso) {
		Cursos c = new Cursos();
		c.setIdCurso(curso.getIdCursoDTO());
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		
		repositorio.save(c);

	}

	@Override
	public void editarCursos(CursoDTORequest  curso) {
		Cursos c = new Cursos();
		c.setIdCurso(curso.getIdCursoDTO());
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		
		repositorio.save(c);
	}

	@Override
	public void eliminarCursos(Integer id) {
		repositorio.deleteById(id);;

	}

	@Override
	public List<CursoDTOResponse> listarCursos() {
		List<CursoDTOResponse> lista= new ArrayList<CursoDTOResponse>();
		CursoDTOResponse c =null;
		for (Cursos curso : repositorio.findAll()) {
			c = new CursoDTOResponse();
			
			c.setIdCursoDTO(curso.getIdCurso());
			c.setCursoDTO(curso.getCurso());
			c.setCursoDTO(curso.getDescripcion());
			lista.add(c);
			
			
		}
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCursoId(Integer id) {
		
		Cursos curso= repositorio.findById(id).orElse(null);
		CursoDTOResponse c = new CursoDTOResponse();
		c.setIdCursoDTO(curso.getIdCurso());
		c.setCursoDTO(curso.getCurso());
		c.setCursoDTO(curso.getDescripcion());
		
		return c;
	}

}
