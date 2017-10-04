package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.OracionAlterBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface OracionAlterDAO extends BaseDAO<OracionAlterBean>
{
 
	List<OracionAlterBean> getBuscarPorOracion(
			OracionAlterBean materialTipoEjercicioBean) throws DAOException;

	public List<OracionAlterBean> buscarEspacioOracion(
			OracionAlterBean oracionAlterBean)throws DAOException;
	
}
