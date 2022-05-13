package com.idat.examen.Servicio;

import java.util.List;

import com.idat.examen.model.Universidades;

public interface UniversidadServicio {
	public void guardarUniversidad(Universidades universidad);
	public void editarUniversidad( Universidades universidad);
	public void eliminarUniversidad(Integer id);
	public List<Universidades> listarUniversidades();
	public Universidades obtenerUniversidadId(Integer id);

}
