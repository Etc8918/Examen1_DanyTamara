package com.idat.examen.Servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen.Repositorio.UniversidadRepositorio;
import com.idat.examen.model.Universidades;
@Service
public class UniversidadServicioImpl implements UniversidadServicio {
	
	@Autowired
	public UniversidadRepositorio repositorio;

	@Override
	public void guardarUniversidad(Universidades universidad) {
		repositorio.save(universidad);

	}

	@Override
	public void editarUniversidad(Universidades universidad) {
		repositorio.saveAndFlush(universidad);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Universidades> listarUniversidades() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Universidades obtenerUniversidadId(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
