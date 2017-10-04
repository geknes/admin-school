package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.entity.entity.general.LeotbcInstitucion;
import com.service.school.core.entity.entity.general.LeotbcLengua;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.InstitucionDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.InstitucionService;

 
@Service("institucionService")
@Transactional (readOnly = true)
public class InstitucionServiceImp implements InstitucionService {
	
	@Autowired
	private InstitucionDAO institucionDAO; 
	

	@Override
	public boolean insertar(InstitucionBean institucionBean) throws ServiceException {
		Boolean sw = false;
		try {
			System.out.println("Ingreso a  insertar.");
			
			sw =  institucionDAO.insertar(institucionBean);
			
		} catch (DAOException e) { 
			sw = false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(InstitucionBean institucionBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = institucionDAO.actualizar(institucionBean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionBean institucionBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = institucionDAO.eliminar(institucionBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InstitucionBean getBuscarPorObjecto(InstitucionBean institucionBean) throws ServiceException {
		InstitucionBean oInstitucionBean = null;
		try {
			oInstitucionBean = institucionDAO.getBuscarPorObjecto(institucionBean);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return oInstitucionBean;
	}

	@Override
	public List<InstitucionBean> getBuscarPorFiltros(InstitucionBean institucionBean)
			throws ServiceException {
		List<InstitucionBean> lstInstitucionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInstitucionBean= institucionDAO.getBuscarPorFiltros(institucionBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInstitucionBean;
	}

	@Override
	public boolean existe(InstitucionBean institucionBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = institucionDAO.existe(institucionBean);
			
		} catch (Exception e) {
			sw =  false;
		}
		return sw;
	}

	@Override
	public List<InstitucionBean> getListarCombo(InstitucionBean InstitucionBean) throws ServiceException {
		List<InstitucionBean> lstInstitucionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInstitucionBean=(List<InstitucionBean>) institucionDAO.getListarCombo(InstitucionBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInstitucionBean;
	}

	@Override
	public boolean actulizarUbicacion(InstitucionBean institucionBean)
			throws ServiceException {
		boolean sw =  false;
		try {
			sw = institucionDAO.actulizarUbicacion(institucionBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actulizarDirector(InstitucionBean institucionBean)
			throws ServiceException {
		boolean sw =  false;
		try {
			sw = institucionDAO.actulizarDirector(institucionBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public List<InstitucionBean> lsitarDirectores() throws ServiceException {
		List<InstitucionBean> lstInstitucionBean=null;
		try {
			System.out.println("en listado Institucion directores");
			lstInstitucionBean= institucionDAO.lsitarDirectores();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInstitucionBean;
	}
	
	@Override
	public List<InstitucionBean> listarInstitucionxTipoUsuario(UsuarioBean usuarioBean)
			throws ServiceException {
		List<InstitucionBean> lstInstitucionBean=null;
		try {
			lstInstitucionBean= institucionDAO.listarInstitucionxTipoUsuario(usuarioBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInstitucionBean;
	}
	 
	
}
	
	 
