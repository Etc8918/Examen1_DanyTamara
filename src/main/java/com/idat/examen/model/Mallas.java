package com.idat.examen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Table(name="Mallas")
@Entity
public class Mallas implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2370139342697160704L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private Integer anio;
	
	@JoinColumn(name = "curso_id", nullable = false, unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (curso_id) references cursos(curso_id)"))
	@ManyToOne
	private Cursos curso;
	
	
	@OneToOne
	@JoinColumn(name="id_univerdidad", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_universidad) references universidades (id_universidad)"))
	private Universidades universidad;
	
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Mallas(Integer idMalla, Integer anio) {
		super();
		this.idMalla = idMalla;
		this.anio = anio;
	}

}
