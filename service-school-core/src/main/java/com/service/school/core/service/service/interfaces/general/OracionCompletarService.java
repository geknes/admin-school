package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface OracionCompletarService extends BaseService<OracionCompletarBean>{

	OracionCompletarBean getBuscarPorTEM(
			OracionCompletarBean oracionCompletarBean) throws ServiceException;

 
}
