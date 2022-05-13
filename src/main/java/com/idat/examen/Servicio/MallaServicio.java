package com.idat.examen.Servicio;

import java.util.List;

import com.idat.examen.model.Mallas;

public interface MallaServicio {
	public void guardarMalla(Mallas malla);
	public void editarMallas( Mallas malla);
	public void eliminarMallas(Integer id);
	public List<Mallas> listarMallas();
	public Mallas obtenerMallaId(Integer id);

}
