package com.service.school.core.repository.repository.interfaces.configuracion;

import java.util.List;

import com.service.school.core.bean.bean.configuracion.PremioConfiguracionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface PremioConfiguracionDAO extends BaseDAO<PremioConfiguracionBean> {
	
	public List<PremioConfiguracionBean> listarTodos() throws DAOException;

}
