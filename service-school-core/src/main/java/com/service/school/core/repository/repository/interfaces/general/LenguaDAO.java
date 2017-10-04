 package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 


public interface LenguaDAO  extends BaseDAO<LenguaBean>  {
	 
	public List<LenguaBean> listarCombo() throws DAOException;
	
	public List<LenguaBean> listarComboxInstitucion(InstitucionBean institucionBean) throws DAOException;

	public List<LenguaBean> listarInstitucionxCodigoInstitucion(InstitucionBean institucionBean) throws DAOException;
	
	public List<LenguaBean> listarValidaLenguasxMatricula(UsuarioBean usuarioBean) throws DAOException;

}
