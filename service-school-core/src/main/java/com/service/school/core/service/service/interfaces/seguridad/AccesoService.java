package com.service.school.core.service.service.interfaces.seguridad;

import com.service.school.core.bean.bean.seguridad.AccesoBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface AccesoService extends BaseService<AccesoBean>{

	public boolean asignar(AccesoBean bean) throws ServiceException;
	
}
