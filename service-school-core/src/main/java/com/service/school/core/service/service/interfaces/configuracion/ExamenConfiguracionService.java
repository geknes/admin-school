package com.service.school.core.service.service.interfaces.configuracion;

import java.util.List;

import com.service.school.core.bean.bean.configuracion.ExamenConfiguracionBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface ExamenConfiguracionService extends BaseService<ExamenConfiguracionBean>{
	public List<ExamenConfiguracionBean> listarTodos() throws ServiceException;

}
