package com.service.school.core.service.service.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.OrdenarParrafoBean;
import com.service.school.core.repository.repository.interfaces.general.OrdenarParrafoDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.OrdenarParrafoService;

@Service("ordenarParrafoService")
@Transactional (readOnly = true)
public class OrdenarParrafoServiceImpl implements OrdenarParrafoService{
	
	@Autowired
	private OrdenarParrafoDAO ordenarParrafoDAO;

	@Override
	public boolean insertar(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().insertar(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().actualizar(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().eliminar(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public OrdenarParrafoBean getBuscarPorObjecto(OrdenarParrafoBean ordenarParrafoBean)
			throws ServiceException {
		OrdenarParrafoBean ordenarParrafoBean2 = null;
		try {
			ordenarParrafoBean2 =this.getOrdenarParrafoDAO().getBuscarPorObjecto(ordenarParrafoBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ordenarParrafoBean2;
	}

	@Override
	public List<OrdenarParrafoBean> getBuscarPorFiltros(OrdenarParrafoBean ordenarParrafoBean)throws ServiceException {
		List<OrdenarParrafoBean> lstOrdenarParrafoBeans = null;
		try {
			lstOrdenarParrafoBeans = ordenarParrafoDAO.getBuscarPorFiltros(ordenarParrafoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstOrdenarParrafoBeans;
	}

	@Override
	public boolean existe(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public OrdenarParrafoDAO getOrdenarParrafoDAO() {
		return ordenarParrafoDAO;
	}

	public void setOrdenarParrafoDAO(OrdenarParrafoDAO ordenarParrafoDAO) {
		this.ordenarParrafoDAO = ordenarParrafoDAO;
	}
	
	

}
