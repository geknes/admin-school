 package com.service.school.core.repository.repository.interfaces.general;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 


public interface PersonaDAO  extends BaseDAO<PersonaBean>  {
	
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(PersonaBean personaBean)throws DAOException;
	 

}
