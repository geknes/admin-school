package com.service.school.core.service.service.interfaces.general;
 
import java.util.List;

import com.service.school.core.bean.bean.generico.PersonaLenguaBean;
import com.service.school.core.bean.bean.generico.PersonaNacionalidadBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface PersonaLenguaService extends BaseService<PersonaLenguaBean> {
	public List<PersonaLenguaBean> getBuscarPorCodigoPersona(PersonaLenguaBean personaLenguaBean) throws ServiceException;
}
 
