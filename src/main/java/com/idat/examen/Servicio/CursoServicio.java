package com.idat.examen.Servicio;

import java.util.List;

import com.idat.examen.dto.CursoDTORequest;
import com.idat.examen.dto.CursoDTOResponse;


public interface CursoServicio {

	public void guardarCurso(CursoDTORequest curso);
	public void editarCursos(CursoDTORequest curso);
	
	
	public void eliminarCursos(Integer id);
	public List<CursoDTOResponse> listarCursos();
	public CursoDTOResponse obtenerCursoId(Integer id);
}
