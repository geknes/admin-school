package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.MaterialEjercicioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.MaterialEjercicioDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.MaterialEjercicioService;

@Service("materialEjercicioService")
@Transactional (readOnly = true)
public class MaterialEjercicioServiceImpl implements MaterialEjercicioService{

	@Autowired
	private MaterialEjercicioDAO materialEjercicioDAO;

	public MaterialEjercicioDAO getMaterialEjercicioDAO() {
		return materialEjercicioDAO;
	}

	@Override
	public boolean insertar(MaterialEjercicioBean materialEjercicioBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getMaterialEjercicioDAO().insertar(materialEjercicioBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MaterialEjercicioBean materialEjercicioBean) throws ServiceException {
		boolean sw =  false;
		try { 
			sw =getMaterialEjercicioDAO().actualizar(materialEjercicioBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(MaterialEjercicioBean materialEjercicioBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = getMaterialEjercicioDAO().eliminar(materialEjercicioBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public MaterialEjercicioBean getBuscarPorObjecto(MaterialEjercicioBean materialEjercicioBean) throws ServiceException {
		MaterialEjercicioBean bean = null;
		try 
		{
			bean = getMaterialEjercicioDAO().getBuscarPorObjecto(materialEjercicioBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<MaterialEjercicioBean> getBuscarPorFiltros(MaterialEjercicioBean materialEjercicioBean) throws ServiceException {
		List<MaterialEjercicioBean> lstMaterialEjercicio = null;
		try {
			lstMaterialEjercicio = getMaterialEjercicioDAO().getBuscarPorFiltros(materialEjercicioBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstMaterialEjercicio;
	}

	@Override
	public boolean existe(MaterialEjercicioBean materialEjercicioBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}


}
