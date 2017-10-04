package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.repository.repository.interfaces.BaseDAO;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface UbigeoService extends BaseService<UbigeoBean>{
	public List<UbigeoBean> listarRegion() throws ServiceException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws ServiceException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws ServiceException;
}
