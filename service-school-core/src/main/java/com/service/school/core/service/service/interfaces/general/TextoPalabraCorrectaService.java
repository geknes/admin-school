package com.service.school.core.service.service.interfaces.general;


import com.service.school.core.bean.bean.generico.TextoPalabraCorrectaBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface TextoPalabraCorrectaService extends BaseService<TextoPalabraCorrectaBean>{

	TextoPalabraCorrectaBean getBuscarPorTEM(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws ServiceException;

 
}
