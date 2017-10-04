package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.PersonaLenguaBean;
import com.service.school.core.bean.bean.generico.PersonaNacionalidadBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.LenguaDAO;
import com.service.school.core.repository.repository.interfaces.general.PersonaLenguaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.PersonaLenguaService;

 
@Service("personaLenguaService")
@Transactional (readOnly = true)
public class PersonaLenguaServiceImp implements PersonaLenguaService {
	
	@Autowired
	private PersonaLenguaDAO personaLenguaDAO; 
	

	@Override
	public boolean insertar(PersonaLenguaBean personaLenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  getPersonaLenguaDAO().insertar(personaLenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonaLenguaBean personaLenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  getPersonaLenguaDAO().actualizar(personaLenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonaLenguaBean personaLenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  getPersonaLenguaDAO().eliminar(personaLenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PersonaLenguaBean getBuscarPorObjecto(PersonaLenguaBean personaLenguaBean) throws ServiceException {
		PersonaLenguaBean oPersonaLenguaBean = null;
		try {
			oPersonaLenguaBean = getPersonaLenguaDAO().getBuscarPorObjecto(personaLenguaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPersonaLenguaBean;
	}

	@Override
	public List<PersonaLenguaBean> getBuscarPorFiltros(PersonaLenguaBean personaLenguaBean) throws ServiceException {
		List<PersonaLenguaBean> lstAlmacen=null;
		try {
			lstAlmacen=(List<PersonaLenguaBean>) getPersonaLenguaDAO().getBuscarPorFiltros(personaLenguaBean);
		} catch (Exception e) {
			 
		}
		return lstAlmacen;
	}

	@Override
	public boolean existe(PersonaLenguaBean personaLenguaBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  getPersonaLenguaDAO().existe(personaLenguaBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	@Override
	public List<PersonaLenguaBean> getBuscarPorCodigoPersona(PersonaLenguaBean personaNacionalidadBean) throws ServiceException {
		List<PersonaLenguaBean> lstAlmacen=null;
		try {
			lstAlmacen=(List<PersonaLenguaBean>) getPersonaLenguaDAO().getBuscarPorCodigoPersona(personaNacionalidadBean);
		} catch (Exception e) {
			 
		}
		return lstAlmacen;
	}
	
	public PersonaLenguaDAO getPersonaLenguaDAO() {
		return personaLenguaDAO;
	}
	
	

}
	
	 
