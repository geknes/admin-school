 package com.service.school.core.service.service.interfaces.academico;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.academico.InscripcionDocenteBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface InscripcionDocenteService  extends BaseService<InscripcionDocenteBean>  {
	 

	public boolean dar_baja_docente_x_InscripcionDocente(InscripcionDocenteBean inscripcionDocenteBean) throws ServiceException;

	
	
}
