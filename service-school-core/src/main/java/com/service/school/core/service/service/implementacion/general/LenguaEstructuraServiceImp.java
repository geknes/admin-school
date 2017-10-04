package com.service.school.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.LenguaEstructuraDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.LenguaEstructuraService; 

 
@Service("lenguaEstructuraService")
@Transactional (readOnly = true)
public class LenguaEstructuraServiceImp implements LenguaEstructuraService {
	
	@Autowired
	private LenguaEstructuraDAO lenguaEstructuraDAO; 
	

	@Override
	public boolean insertar(LenguaEstructuraBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.insertar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LenguaEstructuraBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.actualizar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LenguaEstructuraBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.eliminar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LenguaEstructuraBean getBuscarPorObjecto(LenguaEstructuraBean lenguaBean) throws ServiceException {
		LenguaEstructuraBean oLenguaEstructuraBean = null;
		try {
			oLenguaEstructuraBean = lenguaEstructuraDAO.getBuscarPorObjecto(lenguaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oLenguaEstructuraBean;
	}

	@Override
	public List<LenguaEstructuraBean> getBuscarPorFiltros(LenguaEstructuraBean lengua)
			throws ServiceException {
		List<LenguaEstructuraBean> lstAlmacen=null;
		try {
			System.out.println("en listado lengua service imp");
			lstAlmacen=(List<LenguaEstructuraBean>) lenguaEstructuraDAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		} 
		 
		return lstAlmacen;
	}

	@Override
	public boolean existe(LenguaEstructuraBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<LenguaEstructuraBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException {
		List<LenguaEstructuraBean> lstAlmacen=null;
		try {
			System.out.println("en listado lengua listarPorCodigoLengua imp");
			lstAlmacen=(List<LenguaEstructuraBean>) lenguaEstructuraDAO.listarPorCodigoLengua(lenguaBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstAlmacen;
	}

	@Override
	public boolean insertarLenguaEstrucTemporal(LenguaBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.insertarLenguaEstrucTemporal(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public List<LenguaEstructuraBean> listarNiveles(LenguaBean lenguaBean) throws ServiceException {
		List<LenguaEstructuraBean> lstLenguaEstructuraBean=null;
		try { 
			lstLenguaEstructuraBean=(List<LenguaEstructuraBean>) lenguaEstructuraDAO.listarNiveles(lenguaBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstLenguaEstructuraBean;
	}

	@Override
	public List<LenguaEstructuraBean> listarSubNiveles(LenguaEstructuraBean lenguaEstructuraBean)
			throws ServiceException {
		List<LenguaEstructuraBean> lstLenguaEstructuraBean=null;
		try { 
			lstLenguaEstructuraBean=(List<LenguaEstructuraBean>) lenguaEstructuraDAO.listarSubNiveles(lenguaEstructuraBean);
		} catch (Exception e) {
			 
		}  
		return lstLenguaEstructuraBean;
	}

	@Override
	public List<LenguaEstructuraBean> listarMaterial(LenguaEstructuraBean lenguaEstructuraBean)
			throws ServiceException {
		List<LenguaEstructuraBean> lstLenguaEstructuraBean=null;
		try { 
			lstLenguaEstructuraBean=(List<LenguaEstructuraBean>) lenguaEstructuraDAO.listarMaterial(lenguaEstructuraBean);
		} catch (Exception e) {
			 
		}  
		return lstLenguaEstructuraBean;
	}

	@Override
	public List<LenguaEstructuraBean> listarNivelesxLenguaAll(LenguaBean lenguaBean) throws ServiceException {
		List<LenguaEstructuraBean> lstLenguaEstructuraBean=null;
		try { 
			lstLenguaEstructuraBean=(List<LenguaEstructuraBean>) lenguaEstructuraDAO.listarNivelesxLenguaAll(lenguaBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstLenguaEstructuraBean;
	} 
}
	
	 
