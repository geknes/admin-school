package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.ArrastraOraciBean;
import com.service.school.core.bean.bean.generico.MaterialEjercicioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface ArrastraOraciDAO extends BaseDAO<ArrastraOraciBean>
{ 
	ArrastraOraciBean getBuscarPorTEM(
			ArrastraOraciBean arrastraOraciBean) throws DAOException;

 
	
}
