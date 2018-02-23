package com.reservasdevuelos.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;	

	@Column(name="fecha_hora_salida")
	private Date fechaHoraSalida;
	
	@Column(name="fecha_hora_llegada")
	private Date fechaHoraLlegada;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona")
   	private Persona persona;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origen")
   	private Ciudades origen;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destino")
   	private Ciudades destino;
	
	@Column(name="precio")
	private int precio;

	public Reserva() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}

	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Ciudades getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudades origen) {
		this.origen = origen;
	}

	public Ciudades getDestino() {
		return destino;
	}

	public void setDestino(Ciudades destino) {
		this.destino = destino;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}	
	
}
