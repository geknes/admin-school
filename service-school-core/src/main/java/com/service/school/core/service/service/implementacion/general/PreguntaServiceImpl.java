package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.PreguntaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.PreguntaService;

@Service("preguntaService")
@Transactional (readOnly = true)
public class PreguntaServiceImpl implements PreguntaService{

	@Autowired
	private PreguntaDAO preguntaDAO;
	
	@Override
	public boolean insertar(PreguntaBean preguntaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = preguntaDAO.insertar(preguntaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PreguntaBean preguntaBean) throws ServiceException {
		boolean sw =  false;
		try { 
			sw =preguntaDAO.actualizar(preguntaBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(PreguntaBean preguntaBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = preguntaDAO.eliminar(preguntaBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public PreguntaBean getBuscarPorObjecto(PreguntaBean preguntaBean) throws ServiceException {
		PreguntaBean bean = null;
		try 
		{
			bean = preguntaDAO.getBuscarPorObjecto(preguntaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<PreguntaBean> getBuscarPorFiltros(PreguntaBean preguntaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PreguntaBean preguntaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PreguntaBean> buscarPorMatTEjerPregunta(PreguntaBean preguntaBean) throws ServiceException {
		List<PreguntaBean> bean = null;
		try 
		{
			bean = preguntaDAO.buscarPorMatTEjerPregunta(preguntaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

//	@Override
//	public List<PreguntaBean> buscarPorEjercicio(EjercicioBean ejercicioBean) throws ServiceException {
//		List<PreguntaBean> lstPreguntas = null;
//		
//		try {
//			lstPreguntas = preguntaDAO.buscarPorEjercicio(ejercicioBean);
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//		
//		return lstPreguntas;
//	}

}
