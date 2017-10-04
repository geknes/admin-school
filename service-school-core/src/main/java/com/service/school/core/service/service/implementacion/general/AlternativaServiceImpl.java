package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.AlternativaBean;
import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.AlternativaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.AlternativaService;

@Service("alternativaService")
@Transactional (readOnly = true)
public class AlternativaServiceImpl implements AlternativaService{

	@Autowired
	private AlternativaDAO alternativaDAO;
	
	@Override
	public boolean insertar(AlternativaBean alternativaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = alternativaDAO.insertar(alternativaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlternativaBean alternativaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = alternativaDAO.actualizar(alternativaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlternativaBean alternativaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = alternativaDAO.eliminar(alternativaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AlternativaBean getBuscarPorObjecto(AlternativaBean alternativaBean) throws ServiceException {
		AlternativaBean bean = null;
		try 
		{
			bean = alternativaDAO.getBuscarPorObjecto(alternativaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<AlternativaBean> getBuscarPorFiltros(AlternativaBean alternativaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlternativaBean alternativaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlternativaBean> buscarPorCodigoPregunta(PreguntaBean preguntaBean) throws ServiceException 
	{
		List<AlternativaBean> lst = null;
		try {
			lst = alternativaDAO.buscarPorCodigoPregunta(preguntaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lst;
	}

}
