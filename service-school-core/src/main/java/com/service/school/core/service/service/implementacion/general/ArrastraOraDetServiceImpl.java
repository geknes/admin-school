package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.ArrastraOraDetBean;
import com.service.school.core.bean.bean.generico.ArrastraOraciBean;
import com.service.school.core.bean.bean.generico.MaterialTipoEjercicioBean;
import com.service.school.core.bean.bean.generico.OracionAlterBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.ArrastraOraDetDAO;
import com.service.school.core.repository.repository.interfaces.general.OracionAlterDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.ArrastraOraDetService;
import com.service.school.core.service.service.interfaces.general.OracionAlterService;

@Service("arrastraOraDetService")
@Transactional (readOnly = true)
public class ArrastraOraDetServiceImpl implements ArrastraOraDetService{

	@Autowired
	private ArrastraOraDetDAO arrastraOraDetDAO;
	
	
	public ArrastraOraDetDAO getArrastraOraDetDAO() {
		return arrastraOraDetDAO;
	}
	
 
	

	@Override
	public boolean insertar(ArrastraOraDetBean oracionAlterBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getArrastraOraDetDAO().insertar(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ArrastraOraDetBean oracionAlterBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getArrastraOraDetDAO().actualizar(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArrastraOraDetBean oracionAlterBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getArrastraOraDetDAO().eliminar(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ArrastraOraDetBean getBuscarPorObjecto(ArrastraOraDetBean Bean) throws ServiceException {
		ArrastraOraDetBean bean = null;
		try 
		{
			bean = this.getArrastraOraDetDAO().getBuscarPorObjecto(Bean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return bean;
	}
	
	@Override
	public List<ArrastraOraDetBean>  buscarPorCodigoOracion(
			ArrastraOraDetBean  Bean) throws ServiceException {
		List<ArrastraOraDetBean> lstBean = null;
		try {
			lstBean = this.getArrastraOraDetDAO().getBuscarPorOracion(Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	} 
	 
 

	@Override
	public List<ArrastraOraDetBean> getBuscarPorFiltros(ArrastraOraDetBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(ArrastraOraDetBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}
 

}
