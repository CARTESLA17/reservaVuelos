package com.reservasdevuelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservasdevuelos.daos.ReservaDAO;
import com.reservasdevuelos.dtos.Reserva;

@RestController
@RequestMapping("/reservas")
public class ReservaRest {
	
	@Autowired
	@Qualifier("reservaDAOImpl")
	private ReservaDAO reservaDAOImpl;
	
	@RequestMapping(method = RequestMethod.POST, path = "/obtenerReserva",
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> obtenerReserva(@RequestParam ("numeroDI") int numeroDI, @RequestParam ("tipoDI") int tipoDI){
		return reservaDAOImpl.obtenerReservasDePersona(numeroDI,tipoDI);
	}

}
