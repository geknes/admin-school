package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import com.service.school.core.bean.bean.generico.TextoPalabraCorrectaBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface AlterTextoPalabraCorrectaService extends BaseService<AlterTextoPalabraCorrectaBean>{

	List<AlterTextoPalabraCorrectaBean> buscarPorCodigoOracion(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws ServiceException;

	List<AlterTextoPalabraCorrectaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException;

	List<AlterTextoPalabraCorrectaBean> buscarxPalabraxTexto(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException;

}
