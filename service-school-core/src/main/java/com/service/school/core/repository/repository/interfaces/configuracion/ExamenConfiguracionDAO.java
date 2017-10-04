package com.service.school.core.repository.repository.interfaces.configuracion;

import java.util.List;

import com.service.school.core.bean.bean.configuracion.ExamenConfiguracionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface ExamenConfiguracionDAO extends BaseDAO<ExamenConfiguracionBean> {
	public List<ExamenConfiguracionBean> listarTodos() throws DAOException;
}
