package com.reservasdevuelos.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_documentos_id")
public class DocumentosIdentidad implements Serializable{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
	public DocumentosIdentidad() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
