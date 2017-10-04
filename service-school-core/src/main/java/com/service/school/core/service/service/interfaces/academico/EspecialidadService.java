package com.service.school.core.service.service.interfaces.academico;
 
import java.util.List;

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.EspecialidadBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface EspecialidadService extends BaseService<EspecialidadBean> {
	  
	public List<EspecialidadBean> listarPorCodigoDocente(DocenteBean docenteBean) throws ServiceException; 
}

 