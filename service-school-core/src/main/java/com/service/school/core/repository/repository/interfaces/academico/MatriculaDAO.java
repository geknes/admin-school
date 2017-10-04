 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface MatriculaDAO  extends BaseDAO<MatriculaBean>  {
	
	public List<MatriculaBean> listarCuposXAsignar(MatriculaBean matriculaBean) throws DAOException;
	 
	public List<MatriculaBean> listarSeguimientoAlumno(MatriculaBean matriculaBean) throws DAOException;
	
	public boolean actualizarNumCuposRest(MatriculaBean matriculaBean) throws DAOException;
	 
	
}
