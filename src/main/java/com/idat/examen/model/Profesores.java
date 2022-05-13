package com.idat.examen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Table(name="Profesores")
@Entity
public class Profesores implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4831019760976515982L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String profesor;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="profesor_curso",
	joinColumns = 
		@JoinColumn(
				name="id_curso",
				nullable = false, 
				unique = true, 
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) reference cursos(id_curso)")),
		inverseJoinColumns = 
		@JoinColumn(
				name="id_profesor",
				nullable = false, 
				unique = true, 
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) reference profesores(id_profesor)"))
		
	
		)
		private List<Cursos>curso = new ArrayList<Cursos>();
	
	
	
	
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Profesores(Integer idProfesor, String profesor) {
		super();
		this.idProfesor = idProfesor;
		this.profesor = profesor;
	}
	

}
