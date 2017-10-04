package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionLenguaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface InstitucionLenguaDAO extends BaseDAO<InstitucionLenguaBean>{
	
	public List<InstitucionLenguaBean> existeLengua(InstitucionLenguaBean institucionLenguaBean)throws DAOException;
}
