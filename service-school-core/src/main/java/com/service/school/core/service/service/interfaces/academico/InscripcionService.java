package com.service.school.core.service.service.interfaces.academico;
 
import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface InscripcionService extends BaseService<InscripcionBean> {
	  
	public InscripcionBean getNumcuposXcodInstiCodLengua(InscripcionBean inscripcionBean) throws ServiceException;
}

 