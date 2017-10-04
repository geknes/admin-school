package com.service.school.core.repository.repository.interfaces.seguridad;

import com.service.school.core.bean.bean.seguridad.AccesoBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface AccesoDAO extends BaseDAO<AccesoBean> {

	public boolean asignar(AccesoBean bean) throws DAOException;
	
}
