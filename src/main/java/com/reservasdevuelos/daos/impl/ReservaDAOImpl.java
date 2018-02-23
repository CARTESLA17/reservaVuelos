package com.reservasdevuelos.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservasdevuelos.daos.ReservaDAO;
import com.reservasdevuelos.dtos.Reserva;

@Transactional
@Repository
@Component("reservaDAOImpl")
public class ReservaDAOImpl implements ReservaDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	public List<Reserva> obtenerReservasDePersona(int id, int tipoDI) {
		String hql = "FROM Reserva r where r.persona.numeroDocumento="+id+" AND r.persona.documentoIdentidad="+tipoDI;
		return (List<Reserva>) entityManager.createQuery(hql).getResultList();
	}

}
