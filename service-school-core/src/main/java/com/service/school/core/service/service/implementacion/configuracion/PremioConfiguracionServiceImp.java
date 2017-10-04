package com.service.school.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.configuracion.PremioBean;
import com.service.school.core.bean.bean.configuracion.PremioConfiguracionBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.configuracion.PremioConfiguracionDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.PremioConfiguracionService;

@Service("premioConfiguracionService")
@Transactional (readOnly = true)
public class PremioConfiguracionServiceImp implements PremioConfiguracionService{
	
	@Autowired
	private PremioConfiguracionDAO premioConfiguracionDAO;

	@Override
	public boolean insertar(PremioConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioConfiguracionDAO.insertar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PremioConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioConfiguracionDAO.actualizar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PremioConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioConfiguracionDAO.eliminar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PremioConfiguracionBean getBuscarPorObjecto(PremioConfiguracionBean preConfigBean) throws ServiceException {
		PremioConfiguracionBean oPremioConfigBean = null;
		try {
			oPremioConfigBean = premioConfiguracionDAO.getBuscarPorObjecto(preConfigBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPremioConfigBean;
	}


	@Override
	public boolean existe(PremioConfiguracionBean preConfigBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PremioConfiguracionBean> listarTodos() throws ServiceException {
		List<PremioConfiguracionBean> lstPremioConfigBean=null;
		try {
			System.out.println("en listado premio configuracion");
			lstPremioConfigBean= premioConfiguracionDAO.listarTodos();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstPremioConfigBean;
	}

	@Override
	public List<PremioConfiguracionBean> getBuscarPorFiltros(PremioConfiguracionBean t) throws ServiceException {
		/*public List<PremioConfiguracionBean> getBuscarPorFiltros(PremioConfiguracionBean preConfigBean) throws ServiceException {
		List<PremioConfiguracionBean> lstPremioConfigBean=null;
		try {
			System.out.println("en listado premio service imp");
			lstPremioConfigBean=(List<PremioConfiguracionBean>) premioConfiguracionDAO.getBuscarPorFiltros(preConfigBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstPremioConfigBean;
	} */
		return null;
	}

}
