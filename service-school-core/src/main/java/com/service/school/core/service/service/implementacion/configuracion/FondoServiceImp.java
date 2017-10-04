package com.service.school.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.configuracion.FondoBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.configuracion.FondoDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.FondoService;


@Service("fondoService")
@Transactional (readOnly = true)
public class FondoServiceImp implements FondoService {
	
	@Autowired
	private FondoDAO fondoDAO; 

	@Override
	public boolean insertar(FondoBean fondoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  fondoDAO.insertar(fondoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(FondoBean fondoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  fondoDAO.actualizar(fondoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(FondoBean fondoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  fondoDAO.eliminar(fondoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public FondoBean getBuscarPorObjecto(FondoBean fondoBean) throws ServiceException {
		FondoBean oFondoBean = null;
		try {
			oFondoBean = fondoDAO.getBuscarPorObjecto(fondoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oFondoBean;
	}
	@Override
	public List<FondoBean> getBuscarPorFiltros(FondoBean fondoBean)
			throws ServiceException {
		List<FondoBean> lstFondoBean=null;
		try {
			System.out.println("en listado fondo service imp");
			lstFondoBean=(List<FondoBean>) fondoDAO.getBuscarPorFiltros(fondoBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstFondoBean;
	}
	@Override
	public boolean existe(FondoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
