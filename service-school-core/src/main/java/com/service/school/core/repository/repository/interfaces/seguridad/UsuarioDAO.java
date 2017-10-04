package com.service.school.core.repository.repository.interfaces.seguridad;

import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface UsuarioDAO extends BaseDAO<UsuarioBean> {

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws DAOException;
	
}
