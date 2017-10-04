package com.service.school.core.service.service.interfaces.academico;

import java.util.List;

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.InscripcionDocenteBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface DocenteService extends BaseService<DocenteBean> {
	
	public List<DocenteBean> getBuscarxCodigoInstitucion(DocenteBean docenteBean) throws ServiceException;

	public DocenteBean getBuscarxdni(DocenteBean docenteBean) throws ServiceException;
	
	public List<DocenteBean> getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(InscripcionDocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> listarDocenteXCodigoInstitucionYCodigoLengua(MatriculaBean matriculaBean) throws ServiceException;
	
	public List<DocenteBean> getBuscarPorNumeroDocumento(DocenteBean docenteBean) throws ServiceException;
	
	public List<DocenteBean> getBuscarxCodigoInstitucionDetalleNombreDocum(DocenteBean docenteBean) throws ServiceException;
}

 