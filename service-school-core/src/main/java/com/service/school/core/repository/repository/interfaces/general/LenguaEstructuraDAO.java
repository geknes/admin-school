 package com.service.school.core.repository.repository.interfaces.general;
 
import java.util.List;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
 


public interface LenguaEstructuraDAO  extends BaseDAO<LenguaEstructuraBean>  {
	 
	public List<LenguaEstructuraBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarNiveles(LenguaBean lenguaBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarMaterial(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarSubNiveles(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException;
	
	public boolean insertarLenguaEstrucTemporal(LenguaBean lenguaBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarNivelesxLenguaAll(LenguaBean lenguaBean) throws DAOException;
	
}
