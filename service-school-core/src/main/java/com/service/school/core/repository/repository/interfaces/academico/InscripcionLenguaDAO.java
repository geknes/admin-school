 package com.service.school.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface InscripcionLenguaDAO  extends BaseDAO<InscripcionLenguaBean>  {
	
	public List<InscripcionLenguaBean> listarInscripcionLengua(InscripcionLenguaBean inscripcionLenguaBean)throws DAOException;

	public InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;
	
//	public boolean actualizarNumCuposDisp(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;
}
