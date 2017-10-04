package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionLenguaBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface InstitucionLenguaService extends BaseService<InstitucionLenguaBean> {
	public List<InstitucionLenguaBean> existeLengua(InstitucionLenguaBean institucionLenguaBean) throws ServiceException;
}
