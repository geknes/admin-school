package com.service.school.core.service.service.interfaces.general;
 
import java.util.List;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;


public interface LenguaEstructuraService extends BaseService<LenguaEstructuraBean> {
	
	public List<LenguaEstructuraBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException; 
	
	public List<LenguaEstructuraBean> listarNiveles(LenguaBean lenguaBean) throws ServiceException;
	
	public List<LenguaEstructuraBean> listarMaterial(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException;  
	
	public List<LenguaEstructuraBean> listarSubNiveles(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException;
	
	public boolean insertarLenguaEstrucTemporal(LenguaBean lenguaBean)  throws ServiceException; 
	
	public List<LenguaEstructuraBean> listarNivelesxLenguaAll(LenguaBean lenguaBean) throws ServiceException;
	 
}
 
