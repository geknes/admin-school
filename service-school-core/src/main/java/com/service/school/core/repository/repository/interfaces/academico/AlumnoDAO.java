 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface AlumnoDAO  extends BaseDAO<AlumnoBean>  {
	 

	public List<AlumnoBean> getBuscarxCodigoInstitucion(AlumnoBean alumnoBean) throws DAOException;
	
}
