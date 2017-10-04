 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.EspecialidadBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface EspecialidadDAO  extends BaseDAO<EspecialidadBean>  {
	 
	public List<EspecialidadBean> listarPorCodigoDocente(DocenteBean docenteBean) throws DAOException;
}
