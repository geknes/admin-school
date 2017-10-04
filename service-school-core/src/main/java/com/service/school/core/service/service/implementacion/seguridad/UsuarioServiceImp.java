package com.service.school.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.seguridad.PerfilBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.seguridad.PerfilDAO;
import com.service.school.core.repository.repository.interfaces.seguridad.UsuarioDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioService;

@Service("usuarioService")
@Transactional (readOnly = true)
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public boolean insertar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioBean getBuscarPorObjecto(UsuarioBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioBean> getBuscarPorFiltros(UsuarioBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioBean> lstBean = null;
		try {
			lstBean =  usuarioDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws ServiceException {
		UsuarioBean oUsuarioBean = null;
		try {
			oUsuarioBean =  usuarioDAO.autenticar(prmUsuarioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return oUsuarioBean;
	}

	@Override
	public Integer cambiarPassword(UsuarioBean t)
			throws ServiceException {
		Integer sw = -1;
		try {
			sw =  usuarioDAO.cambiarPassword(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

}