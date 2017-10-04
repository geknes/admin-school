package com.service.school.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.academico.MatriculaAlumnoDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.MatriculaAlumnoService;

@Service("matriculaAlumnoService")
@Transactional (readOnly = true)
public class MatriculaAlumnoServiceImp implements MatriculaAlumnoService {

	@Autowired
	private MatriculaAlumnoDAO matriculaAlumnoDAO;
	
	@Override
	public boolean insertar(MatriculaAlumnoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaAlumnoDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MatriculaAlumnoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaAlumnoDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MatriculaAlumnoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaAlumnoDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MatriculaAlumnoBean getBuscarPorObjecto(MatriculaAlumnoBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatriculaAlumnoBean> getBuscarPorFiltros(MatriculaAlumnoBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(MatriculaAlumnoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MatriculaAlumnoBean> listarAlumnosxMatricula(
			MatriculaAlumnoBean t) throws ServiceException {
		List<MatriculaAlumnoBean> lstMatriculaAlumnoBean=null;
		try {
			System.out.println("en listado matriculaDAO service imp");
			lstMatriculaAlumnoBean= (List<MatriculaAlumnoBean>) matriculaAlumnoDAO.listarAlumnosxMatricula(t);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaAlumnoBean;

	}

	@Override
	public List<MatriculaAlumnoBean> getBuscarMatriculaXAlumno(MatriculaAlumnoBean matriculaAlumnoBean) throws ServiceException {
		List<MatriculaAlumnoBean> lstMatriculaAlumnoBean=null;
		try {
			System.out.println("en listado MatriculaAlumnoBean service imp");
			lstMatriculaAlumnoBean= (List<MatriculaAlumnoBean>) matriculaAlumnoDAO.getBuscarMatriculaXAlumno(matriculaAlumnoBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaAlumnoBean;
	}

	@Override
	public List<MatriculaAlumnoBean> validarMatriculaAlumnoXInscrLengua(InscripcionLenguaBean inscripcionLenguaBean)
			throws DAOException {
		List<MatriculaAlumnoBean> lstMatriculaAlumnoBean=null;
		try {
			System.out.println("en listado MatriculaAlumnoBean service imp");
			lstMatriculaAlumnoBean= (List<MatriculaAlumnoBean>) matriculaAlumnoDAO.validarMatriculaAlumnoXInscrLengua(inscripcionLenguaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaAlumnoBean;
	}

}
