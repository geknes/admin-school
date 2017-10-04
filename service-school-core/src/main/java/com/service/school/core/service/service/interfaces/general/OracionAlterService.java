package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.OracionAlterBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface OracionAlterService extends BaseService<OracionAlterBean>{

	List<OracionAlterBean> buscarPorCodigoOracion(
			OracionCompletarBean oracionCompletarBean) throws ServiceException;

	List<OracionAlterBean> getBuscarPorOracion(OracionAlterBean Bean)
			throws ServiceException;

	List<OracionAlterBean> buscarPorEspacioOracion(
			OracionAlterBean oracionAterBean) throws ServiceException;

}
