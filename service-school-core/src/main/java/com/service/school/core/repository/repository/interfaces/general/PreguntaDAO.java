package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface PreguntaDAO extends BaseDAO<PreguntaBean>
{

	public List<PreguntaBean> buscarPorMatTEjerPregunta(PreguntaBean preguntaBean) throws DAOException;
	
}
