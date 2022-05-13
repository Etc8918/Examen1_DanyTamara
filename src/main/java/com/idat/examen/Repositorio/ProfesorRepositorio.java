package com.idat.examen.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.examen.model.Profesores;


public interface ProfesorRepositorio extends JpaRepository<Profesores, Integer> {

}
