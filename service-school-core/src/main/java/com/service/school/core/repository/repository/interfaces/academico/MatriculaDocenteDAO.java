 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.bean.bean.academico.MatriculaDocenteBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface MatriculaDocenteDAO  extends BaseDAO<MatriculaDocenteBean>  {
	

	public List<MatriculaDocenteBean> listarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws DAOException;
	
	public MatriculaDocenteBean       validarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws DAOException;
}
