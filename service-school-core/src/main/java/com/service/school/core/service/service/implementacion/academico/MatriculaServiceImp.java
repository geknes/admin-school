package com.service.school.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.academico.InscripcionDAO;
import com.service.school.core.repository.repository.interfaces.academico.MatriculaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.InscripcionService;
import com.service.school.core.service.service.interfaces.academico.MatriculaService;


 
@Service("matriculaService")
@Transactional (readOnly = true)
public class MatriculaServiceImp implements MatriculaService {
	
	@Autowired
	private MatriculaDAO matriculaDAO;

	@Override
	public boolean insertar(MatriculaBean matriculaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDAO.insertar(matriculaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MatriculaBean matriculaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDAO.actualizar(matriculaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MatriculaBean matriculaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDAO.eliminar(matriculaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MatriculaBean getBuscarPorObjecto(MatriculaBean matriculaBean) throws ServiceException {
		MatriculaBean oMatriculaBean = null;
		try {
			oMatriculaBean = matriculaDAO.getBuscarPorObjecto(matriculaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMatriculaBean;
	}

	@Override
	public List<MatriculaBean> getBuscarPorFiltros(MatriculaBean matriculaBean) throws ServiceException {
		List<MatriculaBean> lstMatriculaBean=null;
		try {
			System.out.println("en listado matriculaDAO service imp");
			lstMatriculaBean= (List<MatriculaBean>) matriculaDAO.getBuscarPorFiltros(matriculaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaBean;
	}

	@Override
	public boolean existe(MatriculaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public List<MatriculaBean> listarCuposXAsignar(MatriculaBean matriculaBean)
			throws ServiceException {
		List<MatriculaBean> lstMatriculaBean=null;
		try {
			System.out.println("en listado matriculaDAO service imp");
			lstMatriculaBean= (List<MatriculaBean>) matriculaDAO.listarCuposXAsignar(matriculaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaBean;

	}
	
	@Override
	public List<MatriculaBean> listarSeguimientoAlumno(MatriculaBean matriculaBean)
			throws ServiceException {
		List<MatriculaBean> lstMatriculaBean=null;
		try {
			lstMatriculaBean= (List<MatriculaBean>) matriculaDAO.listarSeguimientoAlumno(matriculaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaBean;

	}

	@Override
	public boolean actualizarNumCuposRest(MatriculaBean matriculaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDAO.actualizarNumCuposRest(matriculaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	
	
	
	
	
	
}
	
	 
