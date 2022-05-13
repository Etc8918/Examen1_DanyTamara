package com.idat.examen.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.examen.model.Cursos;




@Repository
public interface CursoRepositorio extends JpaRepository<Cursos, Integer>{
	

}
