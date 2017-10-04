package com.service.school.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.bean.bean.seguridad.UsuarioPerfilBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.seguridad.UsuarioPerfilDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioPerfilService;

@Service("usuarioPerfilService")
@Transactional (readOnly = true)
public class UsuarioPerfilServiceImp implements UsuarioPerfilService{

	@Autowired
	UsuarioPerfilDAO usuarioPerfilDAO;
	
	@Override
	public boolean insertar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioPerfilBean getBuscarPorObjecto(UsuarioPerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioPerfilBean> getBuscarPorFiltros(UsuarioPerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioPerfilBean> lstBean = null;
		try {
			lstBean =  usuarioPerfilDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
