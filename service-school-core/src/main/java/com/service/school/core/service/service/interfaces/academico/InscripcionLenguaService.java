package com.service.school.core.service.service.interfaces.academico;
 
import java.rmi.ServerException;
import java.util.List;

import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface InscripcionLenguaService extends BaseService<InscripcionLenguaBean> {
	  
	public List<InscripcionLenguaBean> listarInscripcionLengua(InscripcionLenguaBean inscripcionLenguaBean)throws ServerException;
	
	public InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException;

//	public boolean actualizarNumCuposDisp(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException;
}

 