package com.service.school.core.service.service.interfaces.general;
 
import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface LenguaService extends BaseService<LenguaBean> {
	
	public List<LenguaBean> cargarCombo() throws ServiceException;
	 
	public List<LenguaBean> listarComboxInstitucion(InstitucionBean institucionBean) throws ServiceException;
	 
	public List<LenguaBean> listarInstitucionxCodigoInstitucion(InstitucionBean institucionBean) throws ServiceException;
	
	public List<LenguaBean> listarValidaLenguasxMatricula(UsuarioBean usuarioBean) throws ServiceException;

}
 
