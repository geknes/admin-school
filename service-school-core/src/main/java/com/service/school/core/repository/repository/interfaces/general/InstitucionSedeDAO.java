package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionSedeBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface InstitucionSedeDAO extends BaseDAO<InstitucionSedeBean> {
	public List<InstitucionSedeBean> listaInsticionSedes() throws DAOException;
}
