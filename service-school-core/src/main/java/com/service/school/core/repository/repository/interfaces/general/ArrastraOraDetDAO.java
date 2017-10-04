package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.ArrastraOraDetBean;
import com.service.school.core.bean.bean.generico.OracionAlterBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface ArrastraOraDetDAO extends BaseDAO<ArrastraOraDetBean>
{
 
	List<ArrastraOraDetBean> getBuscarPorOracion(
			ArrastraOraDetBean arrastraOraDetBean) throws DAOException;

 
	
}
