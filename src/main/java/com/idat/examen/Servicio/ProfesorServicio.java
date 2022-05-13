package com.idat.examen.Servicio;

import java.util.List;

import com.idat.examen.model.Profesores;

public interface ProfesorServicio {

	public void guardarProfesor(Profesores profesor);
	public void editarProfesor( Profesores profesor);
	public void eliminarProfesor(Integer id);
	public List<Profesores> listarProfesores();
	public Profesores obtenerProfesorId(Integer id);
}
