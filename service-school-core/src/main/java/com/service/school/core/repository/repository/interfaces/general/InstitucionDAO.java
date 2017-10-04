 package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface InstitucionDAO  extends BaseDAO<InstitucionBean>  {
	 
	public List<InstitucionBean> getListarCombo(InstitucionBean InstitucionBean) throws DAOException;
	public boolean actulizarUbicacion(InstitucionBean institucionBean)throws DAOException;
	public boolean actulizarDirector(InstitucionBean institucionBean) throws DAOException;
	public List<InstitucionBean> lsitarDirectores() throws DAOException;
	public List<InstitucionBean> listarInstitucionxTipoUsuario(UsuarioBean usuarioBean) throws DAOException;
}
