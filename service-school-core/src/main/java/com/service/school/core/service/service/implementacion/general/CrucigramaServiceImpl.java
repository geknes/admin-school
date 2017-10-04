package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.CrucigramaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.CrucigramaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.CrucigramaService;

@Service("crucigramaService")
@Transactional (readOnly = true)
public class CrucigramaServiceImpl implements CrucigramaService{

	@Autowired
	private CrucigramaDAO crucigramadao;
	
	public CrucigramaDAO getCrucigramadao() {
		return crucigramadao;
	}

	@Override
	public boolean insertar(CrucigramaBean crucigramaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getCrucigramadao().insertar(crucigramaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CrucigramaBean crucigramaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getCrucigramadao().actualizar(crucigramaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(CrucigramaBean crucigramaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getCrucigramadao().eliminar(crucigramaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public CrucigramaBean getBuscarPorObjecto(CrucigramaBean crucigramaBean) throws ServiceException {
		CrucigramaBean bean = null;
		try {
			bean = getCrucigramadao().getBuscarPorObjecto(crucigramaBean);
		}catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<CrucigramaBean> getBuscarPorFiltros(CrucigramaBean crucigramaBean) throws ServiceException {
		List<CrucigramaBean> lstCrucigramaBean = null;
		try {
			lstCrucigramaBean = getCrucigramadao().getBuscarPorFiltros(crucigramaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstCrucigramaBean;
	}

	@Override
	public boolean existe(CrucigramaBean crucigramaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
