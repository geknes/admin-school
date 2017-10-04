 package com.service.school.core.repository.repository.interfaces.academico;


import java.util.List;

import com.service.school.core.bean.bean.academico.MatriculaDocenteBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface UsuarioMatriculaDAO  extends BaseDAO<UsuarioMatriculaBean>  {
	 
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws DAOException;
	
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws DAOException;
	
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)throws DAOException;
	


}
