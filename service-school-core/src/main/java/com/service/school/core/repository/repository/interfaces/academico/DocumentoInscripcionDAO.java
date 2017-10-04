 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import com.service.school.core.bean.bean.academico.DocumentoInscripcionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface DocumentoInscripcionDAO  extends BaseDAO<DocumentoInscripcionBean>  {
	 
	public List<DocumentoInscripcionBean> listarDocumentoInscripcionBeanxCodInsc(DocumentoInscripcionBean documentoInscripcionBean) throws DAOException;
}
