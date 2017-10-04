package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface UnidadService extends BaseService<UnidadBean>{

	public UnidadBean buscarLengua(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException;
	
	public List<UnidadBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException;
	
}
