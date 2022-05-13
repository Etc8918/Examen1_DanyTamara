package com.idat.examen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="Universidades")
@Entity
public class Universidades implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5028336360337061558L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	private String universidad;
	
	@OneToOne(mappedBy = "universidad")
	private Mallas malla;
	
	
	
	public Integer getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	public Universidades(Integer idUniversidad, String universidad) {
		super();
		this.idUniversidad = idUniversidad;
		this.universidad = universidad;
	}
	

}
