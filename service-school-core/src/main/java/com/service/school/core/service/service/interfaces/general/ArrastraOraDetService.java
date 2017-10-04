package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.ArrastraOraDetBean;
import com.service.school.core.bean.bean.generico.ArrastraOraciBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface ArrastraOraDetService extends BaseService<ArrastraOraDetBean>{

	List<ArrastraOraDetBean> buscarPorCodigoOracion(
			ArrastraOraDetBean  Bean) throws ServiceException;

 

}
