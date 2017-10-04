 package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.PersonaLenguaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 


public interface PersonaLenguaDAO  extends BaseDAO<PersonaLenguaBean>  {
	public List<PersonaLenguaBean> getBuscarPorCodigoPersona(PersonaLenguaBean personaLenguaBean) throws DAOException;
}
