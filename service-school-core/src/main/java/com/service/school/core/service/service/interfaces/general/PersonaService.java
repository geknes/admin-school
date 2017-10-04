package com.service.school.core.service.service.interfaces.general;
 
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface PersonaService extends BaseService<PersonaBean> {
	  
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(PersonaBean personaBean)throws ServiceException;
	
	
}
 
