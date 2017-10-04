package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.InstitucionSedeBean;
import com.service.school.core.bean.bean.generico.LeccionMaterialBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.LeccionMaterialDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.LeccionMaterialService;

@Service("leccionMaterialService")
@Transactional (readOnly = true)
public class LeccionMaterialServiceImpl implements LeccionMaterialService {

	@Autowired
	private LeccionMaterialDAO leccionMaterialDAO;
	
	@Override
	public boolean insertar(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LeccionMaterialBean getBuscarPorObjecto(LeccionMaterialBean t) throws ServiceException {
		LeccionMaterialBean oLeccionMaterialBean = null;
		try {
			oLeccionMaterialBean = this.leccionMaterialDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return oLeccionMaterialBean;
	}

	@Override
	public List<LeccionMaterialBean> getBuscarPorFiltros(LeccionMaterialBean t) throws ServiceException {
		List<LeccionMaterialBean> lstLeccionMaterialBean = null;
		try 
		{
			lstLeccionMaterialBean = leccionMaterialDAO.getBuscarPorFiltros(t);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstLeccionMaterialBean;
	}

	@Override
	public boolean existe(LeccionMaterialBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws ServiceException {
		List<LeccionMaterialBean> lstLeccionMaterialBean = null;
		try 
		{
			lstLeccionMaterialBean = leccionMaterialDAO.buscarPorLeccion(materialBean);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstLeccionMaterialBean;
	}

}
