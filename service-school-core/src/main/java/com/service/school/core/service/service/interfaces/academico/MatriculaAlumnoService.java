 package com.service.school.core.service.service.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;
 

@Transactional(readOnly = true)
public interface MatriculaAlumnoService  extends BaseService<MatriculaAlumnoBean>  {
	

	public List<MatriculaAlumnoBean> listarAlumnosxMatricula(MatriculaAlumnoBean t)throws ServiceException;
	
	public List<MatriculaAlumnoBean> getBuscarMatriculaXAlumno(MatriculaAlumnoBean matriculaAlumnoBean) throws ServiceException;

	public List<MatriculaAlumnoBean> validarMatriculaAlumnoXInscrLengua(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;

}
