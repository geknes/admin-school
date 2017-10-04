package com.service.school.core.service.service.interfaces.general;
 
import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface InstitucionService extends BaseService<InstitucionBean> {

	
	public List<InstitucionBean> getListarCombo(InstitucionBean InstitucionBean) throws ServiceException;
	public boolean actulizarUbicacion(InstitucionBean institucionBean)throws ServiceException;
	public boolean actulizarDirector(InstitucionBean institucionBean) throws ServiceException;
	public List<InstitucionBean> lsitarDirectores() throws ServiceException;
	//public List<InstitucionBean> listarInstitucionxCodigoPersona(int codigoPerson) throws ServiceException;
	public List<InstitucionBean> listarInstitucionxTipoUsuario(UsuarioBean usuarioBean) throws ServiceException;
}
 
