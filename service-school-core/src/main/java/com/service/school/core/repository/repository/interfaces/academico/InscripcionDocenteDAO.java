 package com.service.school.core.repository.repository.interfaces.academico;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.academico.InscripcionDocenteBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface InscripcionDocenteDAO  extends BaseDAO<InscripcionDocenteBean>  {
	 
public boolean dar_baja_docente_x_InscripcionDocente(InscripcionDocenteBean inscripcionDocenteBean) throws DAOException;

	
	
}
