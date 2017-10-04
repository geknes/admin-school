package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface UnidadDAO extends BaseDAO<UnidadBean>
{
	public UnidadBean buscarLengua(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException;
	
	public List<UnidadBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException;
}
