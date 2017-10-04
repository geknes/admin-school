package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface AlterTextoPalabraCorrectaDAO extends BaseDAO<AlterTextoPalabraCorrectaBean>
{
 
	List<AlterTextoPalabraCorrectaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws DAOException;

	public List<AlterTextoPalabraCorrectaBean> buscarxPalabraxTexto(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean)throws DAOException;
	
}
