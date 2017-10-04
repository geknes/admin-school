package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.Maestra2DAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;

 
@Service("maestra2Service")
@Transactional (readOnly = true)
public class Maestra2ServiceImp implements Maestra2Service {
	
	@Autowired
	private Maestra2DAO maestra2DAO; 
	

	@Override
	public boolean insertar(MaestraBean maestraBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.insertar(maestraBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MaestraBean maestraBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.actualizar(maestraBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MaestraBean maestraBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.eliminar(maestraBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MaestraBean getBuscarPorObjecto(MaestraBean maestraBean) throws ServiceException {
		MaestraBean oMaestraBean = null;
		try {
			oMaestraBean = maestra2DAO.getBuscarPorObjecto(maestraBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMaestraBean;
	}

	@Override
	public List<MaestraBean> getBuscarPorFiltros(MaestraBean lengua)
			throws ServiceException {
		List<MaestraBean> lstMaestraBean=null;
		try { 
			lstMaestraBean=(List<MaestraBean>) maestra2DAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		}  
		return lstMaestraBean;
	}

	@Override
	public boolean existe(MaestraBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo)
			throws  ServiceException { 
		List<MaestraBean> lstMaestraBean=null;
		try { 
			lstMaestraBean=(List<MaestraBean>) maestra2DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstMaestraBean;
	}

	@Override
	public List<MaestraBean> listarPorValor1(MaestraBean maestraBean) throws ServiceException {
		List<MaestraBean> lstMaestraBean=null;
		try { 
			lstMaestraBean=(List<MaestraBean>) maestra2DAO.listarPorValor1(maestraBean);
		} catch (Exception e) {
			 
		}  
		return lstMaestraBean;
	}
	 
	
}
	
	 
