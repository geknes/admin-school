package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.InstitucionSedeBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface InstitucionSedeService extends BaseService<InstitucionSedeBean> {
	public List<InstitucionSedeBean> listaInsticionSedes()throws ServiceException;
}
