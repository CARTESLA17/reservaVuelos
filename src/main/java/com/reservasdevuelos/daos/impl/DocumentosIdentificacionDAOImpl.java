package com.reservasdevuelos.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservasdevuelos.daos.DocumentosIdentificacionDAO;
import com.reservasdevuelos.dtos.DocumentosIdentidad;

@Transactional
@Repository
@Component("documentosIdentificacionDAOImpl")
public class DocumentosIdentificacionDAOImpl implements DocumentosIdentificacionDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	public List<DocumentosIdentidad> obtenerDocumentosIdentidad() {
		String hql = "FROM DocumentosIdentidad";
		return (List<DocumentosIdentidad>) entityManager.createQuery(hql).getResultList();
	}

}
