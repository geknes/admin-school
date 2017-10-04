package com.service.school.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.TextoPalabraCorrectaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.TextoPalabraCorrectaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.TextoPalabraCorrectaService;

@Service("textoPalabraCorrectaService")
@Transactional (readOnly = true)
public class TextoPalabraCorrectaServiceImpl implements TextoPalabraCorrectaService {

	@Autowired
	private TextoPalabraCorrectaDAO textoPalabraCorrectaDAO;

	@Override
	public boolean insertar(TextoPalabraCorrectaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = textoPalabraCorrectaDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TextoPalabraCorrectaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = textoPalabraCorrectaDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TextoPalabraCorrectaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = textoPalabraCorrectaDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TextoPalabraCorrectaBean getBuscarPorObjecto(TextoPalabraCorrectaBean t) throws ServiceException {
		TextoPalabraCorrectaBean bean = null;
		try {
			bean = textoPalabraCorrectaDAO.getBuscarPorObjecto(t);
		}catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<TextoPalabraCorrectaBean> getBuscarPorFiltros(TextoPalabraCorrectaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(TextoPalabraCorrectaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TextoPalabraCorrectaBean getBuscarPorTEM(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws ServiceException {
		TextoPalabraCorrectaBean bean = null;
		try {
			bean = textoPalabraCorrectaDAO.getBuscarPorTEM(textoPalabraCorrectaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
}
