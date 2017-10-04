package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.bean.bean.generico.RelacionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.RelacionDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.RelacionService;

@Service("relacionService")
@Transactional (readOnly = true)
public class RelacionServiceImpl implements RelacionService{

	@Autowired
	private RelacionDAO relacionDAO;
	
	@Override
	public boolean insertar(RelacionBean relacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionDAO.insertar(relacionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(RelacionBean relacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionDAO.actualizar(relacionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(RelacionBean relacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionDAO.eliminar(relacionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public RelacionBean getBuscarPorObjecto(RelacionBean relacionBean) throws ServiceException {
		RelacionBean oRelacionBean = null;
		try {
			oRelacionBean = this.getRelacionDAO().getBuscarPorObjecto(relacionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return oRelacionBean;
	}

	@Override
	public List<RelacionBean> getBuscarPorFiltros(RelacionBean relacionBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(RelacionBean relacionBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RelacionBean> buscarPorRelacionCabecera(RelacionBean relacionBean) throws ServiceException {
		List<RelacionBean> lstPreguntas = null;
		try 
		{
			lstPreguntas = relacionDAO.buscarPorRelacionCabecera(relacionBean);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstPreguntas;
	}

	@Override
	public List<RelacionBean> listarTextoTexto(RelacionBean relacionBean)
			throws ServiceException {
		List<RelacionBean> lstRelacionBeans = null;
		try {
			lstRelacionBeans = this.getRelacionDAO().listarTextoTexto(relacionBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstRelacionBeans;
	}
	
	@Override
	public List<RelacionBean> listarCrucigrama(RelacionBean relacionBean)
			throws ServiceException {
		List<RelacionBean> lstRelacionBeans = null;
		try {
			lstRelacionBeans = this.getRelacionDAO().listarCrucigrama(relacionBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstRelacionBeans;
	}

	public RelacionDAO getRelacionDAO() {
		return relacionDAO;
	}

	public void setRelacionDAO(RelacionDAO relacionDAO) {
		this.relacionDAO = relacionDAO;
	}
	
	
	
	
}
