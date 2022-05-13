package com.idat.examen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Table(name="Productos")
@Entity
public class Cursos  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4477895004063555703L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	
	@OneToMany(mappedBy = "curso")
	private List<Mallas> malla = new ArrayList<Mallas>();
	
	
	@ManyToMany(mappedBy = "curso", cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Profesores>profesor = new ArrayList<Profesores>();
	
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Cursos() {
		super();
		this.idCurso = idCurso;
		this.curso = curso;
		this.descripcion = descripcion;
	}


}
