package com.reservasdevuelos.daos;

import java.util.List;

import com.reservasdevuelos.dtos.Reserva;

public interface ReservaDAO {
	
	public List<Reserva> obtenerReservasDePersona(int id, int tipoDI);

}
