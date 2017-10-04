package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.bean.bean.generico.UnidadLeccionBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface UnidadLeccionService extends BaseService<UnidadLeccionBean>{
	
	public List<UnidadLeccionBean> listarPorLengua(LenguaBean lenguaBean) throws ServiceException; 
	
	public List<UnidadLeccionBean> listarPorUnidad(UnidadBean unidadBean) throws ServiceException; 
	
}
