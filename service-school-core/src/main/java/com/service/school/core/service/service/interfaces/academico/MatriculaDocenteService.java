 package com.service.school.core.service.service.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.bean.bean.academico.MatriculaDocenteBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;
 

@Transactional(readOnly = true)
public interface MatriculaDocenteService  extends BaseService<MatriculaDocenteBean>  {
	

	public List<MatriculaDocenteBean> listarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws ServiceException;
	
	public MatriculaDocenteBean       validarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws DAOException;

}
