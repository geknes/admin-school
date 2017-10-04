package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.bean.bean.generico.UnidadLeccionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface UnidadLeccionDAO extends BaseDAO<UnidadLeccionBean>{
	
	public List<UnidadLeccionBean> listarPorLengua(LenguaBean lenguaBean) throws DAOException;
	
	public List<UnidadLeccionBean> listarPorUnidad(UnidadBean unidadBean) throws DAOException;
	

}
