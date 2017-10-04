package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.MaterialEjercicioBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface OracionCompletarDAO extends BaseDAO<OracionCompletarBean>
{
	public List<OracionCompletarBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean) throws DAOException;

	OracionCompletarBean getBuscarPorTEM(
			OracionCompletarBean oracionCompletarBean) throws DAOException;

 
	
}
