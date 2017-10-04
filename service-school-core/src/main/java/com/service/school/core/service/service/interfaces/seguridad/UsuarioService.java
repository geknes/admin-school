package com.service.school.core.service.service.interfaces.seguridad;

import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface UsuarioService extends BaseService<UsuarioBean>{

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws ServiceException;
	
}
