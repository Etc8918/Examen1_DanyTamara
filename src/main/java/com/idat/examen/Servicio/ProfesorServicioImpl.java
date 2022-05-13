package com.idat.examen.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen.Repositorio.ProfesorRepositorio;

import com.idat.examen.model.Profesores;

@Service
public class ProfesorServicioImpl implements ProfesorServicio {
	
	@Autowired
	public ProfesorRepositorio repositorio;


	@Override
	public void guardarProfesor(Profesores profesor) {
		repositorio.save(profesor);

	}

	@Override
	public void editarProfesor(Profesores profesor) {
		repositorio.saveAndFlush(profesor);

	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Profesores> listarProfesores() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Profesores obtenerProfesorId(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
