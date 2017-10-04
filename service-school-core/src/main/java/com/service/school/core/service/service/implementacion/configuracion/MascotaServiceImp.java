package com.service.school.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.configuracion.MascotaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.configuracion.MascotaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.MascotaService;
 

 
@Service("mascotaService")
@Transactional (readOnly = true)
public class MascotaServiceImp implements MascotaService {
	
	@Autowired
	private MascotaDAO mascotaDAO; 
	

	@Override
	public boolean insertar(MascotaBean mascotaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  mascotaDAO.insertar(mascotaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MascotaBean mascotaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  mascotaDAO.actualizar(mascotaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MascotaBean mascotaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  mascotaDAO.eliminar(mascotaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MascotaBean getBuscarPorObjecto(MascotaBean mascotaBean) throws ServiceException {
		MascotaBean oMascotaBean = null;
		try {
			oMascotaBean = mascotaDAO.getBuscarPorObjecto(mascotaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMascotaBean;
	}

	@Override
	public List<MascotaBean> getBuscarPorFiltros(MascotaBean mascotaBean)
			throws ServiceException {
		List<MascotaBean> lstMascotaBean=null;
		try {
			System.out.println("en listado mascota service imp");
			lstMascotaBean=(List<MascotaBean>) mascotaDAO.getBuscarPorFiltros(mascotaBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstMascotaBean;
	}

	@Override
	public boolean existe(MascotaBean t) throws ServiceException {
		
		return false;
	}
	 
	
}
	
	 
