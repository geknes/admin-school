package com.service.school.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.LenguaDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.LenguaService;

 
@Service("lenguaService")
@Transactional (readOnly = true)
public class LenguaServiceImp implements LenguaService {
	
	@Autowired
	private LenguaDAO lenguaDAO; 
	

	@Override
	public boolean insertar(LenguaBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaDAO.insertar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LenguaBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaDAO.actualizar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LenguaBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaDAO.eliminar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LenguaBean getBuscarPorObjecto(LenguaBean lenguaBean) throws ServiceException {
		LenguaBean oLenguaBean = null;
		try {
			oLenguaBean = lenguaDAO.getBuscarPorObjecto(lenguaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oLenguaBean;
	}

	@Override
	public List<LenguaBean> getBuscarPorFiltros(LenguaBean lengua)
			throws ServiceException {
		List<LenguaBean> lstAlmacen=null;
		try {
			System.out.println("en listado lengua service imp");
			lstAlmacen=(List<LenguaBean>) lenguaDAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		} 
		 
		return lstAlmacen;
	}

	@Override
	public boolean existe(LenguaBean t) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  lenguaDAO.existe(t) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	@Override
	public List<LenguaBean> cargarCombo() throws ServiceException 
	{
		List<LenguaBean> lstLengua=null;
		try 
		{
			lstLengua=(List<LenguaBean>) lenguaDAO.listarCombo();
		} 
		catch (Exception e) 
		{
			 throw new ServiceException(e);
		} 
		return lstLengua;
	}

	@Override
	public List<LenguaBean> listarComboxInstitucion(InstitucionBean institucionBean) throws ServiceException {
		List<LenguaBean> lstLengua=null;
		try 
		{
			lstLengua=(List<LenguaBean>) lenguaDAO.listarComboxInstitucion(institucionBean);
		} 
		catch (Exception e) 
		{
			 throw new ServiceException(e);
		} 
		return lstLengua;
	}

	@Override
	public List<LenguaBean> listarInstitucionxCodigoInstitucion(InstitucionBean institucionBean) throws ServiceException {
		List<LenguaBean> lstLengua=null;
		try 
		{
			lstLengua=(List<LenguaBean>) lenguaDAO.listarInstitucionxCodigoInstitucion(institucionBean);
		} 
		catch (Exception e) 
		{
			 throw new ServiceException(e);
		} 
		return lstLengua;
	}
	
	@Override
	public List<LenguaBean> listarValidaLenguasxMatricula(UsuarioBean usuarioBean) throws ServiceException {
		List<LenguaBean> lstLengua=null;
		try 
		{
			lstLengua=(List<LenguaBean>) lenguaDAO.listarValidaLenguasxMatricula(usuarioBean);
		} 
		catch (Exception e) 
		{
			 throw new ServiceException(e);
		} 
		return lstLengua;
	}
	 
	
}
	
	 
