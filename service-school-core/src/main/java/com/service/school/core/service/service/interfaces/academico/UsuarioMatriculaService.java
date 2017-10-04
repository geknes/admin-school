 package com.service.school.core.service.service.interfaces.academico;

import java.util.List;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface UsuarioMatriculaService  extends BaseService<UsuarioMatriculaBean>  {
	 
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws ServiceException;
	
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws ServiceException;
	
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)throws ServiceException;
	


}
