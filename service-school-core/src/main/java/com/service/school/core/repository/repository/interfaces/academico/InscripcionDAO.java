 package com.service.school.core.repository.repository.interfaces.academico;

import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface InscripcionDAO  extends BaseDAO<InscripcionBean>  {
	 
	public InscripcionBean getNumcuposXcodInstiCodLengua(InscripcionBean inscripcionBean) throws DAOException;
}
