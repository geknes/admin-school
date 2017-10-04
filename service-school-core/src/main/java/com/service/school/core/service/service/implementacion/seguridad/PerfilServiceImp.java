package com.service.school.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.seguridad.PerfilBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.seguridad.PerfilDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.seguridad.PerfilService;

@Service("perfilService")
@Transactional (readOnly = true)
public class PerfilServiceImp implements PerfilService{
	
	@Autowired
	PerfilDAO perfilDAO;
	
	@Override
	public boolean insertar(PerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  perfilDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  perfilDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  perfilDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PerfilBean getBuscarPorObjecto(PerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PerfilBean> getBuscarPorFiltros(PerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<PerfilBean> lstBean = null;
		try {
			lstBean =  perfilDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(PerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
