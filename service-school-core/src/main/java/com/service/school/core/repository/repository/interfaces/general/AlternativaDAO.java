package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.AlternativaBean;
import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface AlternativaDAO extends BaseDAO<AlternativaBean>{

	public List<AlternativaBean> buscarPorCodigoPregunta(PreguntaBean preguntaBean) throws DAOException;
	
}
