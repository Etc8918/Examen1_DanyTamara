package com.idat.examen.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen.Repositorio.MallaRepositorio;

import com.idat.examen.model.Mallas;

@Service
public class MallaServicioImpl implements MallaServicio {
	
	@Autowired
	public MallaRepositorio repositorio;


	@Override
	public void guardarMalla(Mallas malla) {
		repositorio.save(malla);
		;

	}

	@Override
	public void editarMallas(Mallas malla) {
		repositorio.saveAndFlush(malla);

	}

	@Override
	public void eliminarMallas(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Mallas> listarMallas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Mallas obtenerMallaId(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
