package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.MaterialEjercicioBean;
import com.service.school.core.bean.bean.generico.TextoPalabraCorrectaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface TextoPalabraCorrectaDAO extends BaseDAO<TextoPalabraCorrectaBean>
{
	public List<TextoPalabraCorrectaBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean) throws DAOException;

	TextoPalabraCorrectaBean getBuscarPorTEM(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws DAOException;

 
	
}
