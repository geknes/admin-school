package com.service.school.core.service.service.interfaces.general;
 
import java.util.List;

import com.service.school.core.bean.bean.generico.PersonaNacionalidadBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface PersonaNacionalidadService extends BaseService<PersonaNacionalidadBean> {
	public List<PersonaNacionalidadBean> getBuscarPorCodigoPersona(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException;
}
 
