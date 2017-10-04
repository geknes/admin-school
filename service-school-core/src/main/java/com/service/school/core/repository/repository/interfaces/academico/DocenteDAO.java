 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.InscripcionDocenteBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface DocenteDAO  extends BaseDAO<DocenteBean>  {
	 
	
	public List<DocenteBean> getBuscarxCodigoInstitucion(DocenteBean docenteBean) throws DAOException;
	
	public DocenteBean getBuscarxdni(DocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(InscripcionDocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> listarDocenteXCodigoInstitucionYCodigoLengua(MatriculaBean matriculaBean) throws DAOException;
	
	public List<DocenteBean> getBuscarPorNumeroDocumento(DocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> getBuscarxCodigoInstitucionDetalleNombreDocum(DocenteBean docenteBean) throws DAOException;
}
