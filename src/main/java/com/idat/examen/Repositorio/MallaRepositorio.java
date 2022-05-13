package com.idat.examen.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.examen.model.Mallas;


@Repository
public interface MallaRepositorio extends JpaRepository<Mallas, Integer>{


}
