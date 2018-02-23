package com.reservasdevuelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservasdevuelos.daos.DocumentosIdentificacionDAO;
import com.reservasdevuelos.dtos.DocumentosIdentidad;

@RestController
@RequestMapping("/documentosIdentificacion")
public class DocumentosIdentificacionRest {
	
	@Autowired
	@Qualifier("documentosIdentificacionDAOImpl")
	private DocumentosIdentificacionDAO documentosIdentificacionDAOImpl;
	
	@RequestMapping(method = RequestMethod.GET, path = "/obtenerDocumentosIdentidad",
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DocumentosIdentidad> obtenerDocumentosIdentidad() {
		return documentosIdentificacionDAOImpl.obtenerDocumentosIdentidad();
	}

}
