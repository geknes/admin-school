package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.generico.PersonalBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.PersonaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.PersonaService;

@Service("personaService")
@Transactional (readOnly = true)
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;
	
	
	
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	@Override
	public boolean insertar(PersonaBean personaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.insertar(personaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonaBean getBuscarPorObjecto(PersonaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaBean> getBuscarPorFiltros(PersonaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PersonaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(
			PersonaBean personaBean) throws ServiceException {
		PersonaBean oPersonaBean = null;
		try {
		
			oPersonaBean= personaDAO.buscarxTipoDocumentoNumeroDocumento(personaBean);
		} catch (Exception e) {
			 
		} 
		 
		return oPersonaBean;
	}

}
