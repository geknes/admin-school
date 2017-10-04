package com.service.school.core.service.service.interfaces.academico;
 
import java.util.List;

import com.service.school.core.bean.bean.academico.DocumentoInscripcionBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface DocumentoInscripcionService extends BaseService<DocumentoInscripcionBean> {
	  
	public List<DocumentoInscripcionBean> listarDocumentoInscripcionBeanxCodInsc(DocumentoInscripcionBean documentoInscripcionBean) throws ServiceException;
}

 