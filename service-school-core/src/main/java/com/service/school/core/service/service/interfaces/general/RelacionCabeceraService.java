package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.RelacionBean;
import com.service.school.core.bean.bean.generico.RelacionCabeceraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface RelacionCabeceraService extends BaseService<RelacionCabeceraBean>{
	public List<RelacionCabeceraBean> buscarPorEjercicio(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException;
	public List<RelacionCabeceraBean> busccarPorMatTEjerRelacionCab(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException;
}
