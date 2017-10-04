package com.service.school.core.service.service.interfaces.academico;
 
import java.util.List;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface AlumnoService extends BaseService<AlumnoBean> {
	
	public List<AlumnoBean> getBuscarxCodigoInstitucion(AlumnoBean alumnoBean) throws ServiceException;

}

 