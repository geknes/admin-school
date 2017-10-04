package com.service.school.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.academico.UsuarioMatriculaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.UsuarioMatriculaService;


@Service("usuarioMatriculaService")
@Transactional (readOnly = true)
public class UsuarioMatriculaServiceImp implements UsuarioMatriculaService {

	@Autowired
	private UsuarioMatriculaDAO usuarioMatriculaDAO;
	
	@Override
	public boolean insertar(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioMatriculaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioMatriculaBean getBuscarPorObjecto(UsuarioMatriculaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioMatriculaBean> getBuscarPorFiltros(UsuarioMatriculaBean t)
			throws ServiceException {
		List<UsuarioMatriculaBean> lstUsuarioMatriculaBean=null;
		try {
			System.out.println("en listado UsuarioMatriculaBean service imp");
			lstUsuarioMatriculaBean=(List<UsuarioMatriculaBean>) usuarioMatriculaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstUsuarioMatriculaBean;
	}

	@Override
	public boolean existe(UsuarioMatriculaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.asignarUsuario(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.darBajaUsuarioMatricula(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)
			throws ServiceException {
		List<UsuarioMatriculaBean> lstUsuarioMatriculaBean=null;
		try {
			System.out.println("en listado UsuarioMatriculaBean service imp");
			lstUsuarioMatriculaBean=(List<UsuarioMatriculaBean>) usuarioMatriculaDAO.buscarXTipoCuposXinscrLengua(usuarioMatriculaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstUsuarioMatriculaBean;
	}

}
