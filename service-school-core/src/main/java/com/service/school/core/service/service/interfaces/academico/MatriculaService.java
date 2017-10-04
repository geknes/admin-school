package com.service.school.core.service.service.interfaces.academico;
 
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

@Transactional(readOnly = true)
public interface MatriculaService extends BaseService<MatriculaBean> {
	
	public List<MatriculaBean> listarCuposXAsignar(MatriculaBean matriculaBean) throws ServiceException;  
	
	public List<MatriculaBean> listarSeguimientoAlumno(MatriculaBean matriculaBean) throws ServiceException;  
	
	public boolean actualizarNumCuposRest(MatriculaBean matriculaBean) throws ServiceException;
}

 