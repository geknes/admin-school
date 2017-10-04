package com.service.school.core.service.service.interfaces.configuracion;

import java.util.List;

import com.service.school.core.bean.bean.configuracion.PremioConfiguracionBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface PremioConfiguracionService extends BaseService<PremioConfiguracionBean> {
	
	public List<PremioConfiguracionBean> listarTodos() throws ServiceException;

}
