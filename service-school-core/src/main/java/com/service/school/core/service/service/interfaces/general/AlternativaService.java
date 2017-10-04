package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.AlternativaBean;
import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface AlternativaService extends BaseService<AlternativaBean>{

	public List<AlternativaBean> buscarPorCodigoPregunta(PreguntaBean preguntaBean) throws ServiceException;
	
}
