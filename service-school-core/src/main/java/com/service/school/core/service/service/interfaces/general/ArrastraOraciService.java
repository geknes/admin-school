package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.ArrastraOraciBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface ArrastraOraciService extends BaseService<ArrastraOraciBean>{

	ArrastraOraciBean getBuscarPorTEM(
			ArrastraOraciBean arrastraOraciBean) throws ServiceException;

 
}
