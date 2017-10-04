package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.RelacionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface RelacionService extends BaseService<RelacionBean>{
	public List<RelacionBean> buscarPorRelacionCabecera(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarTextoTexto(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarCrucigrama(RelacionBean relacionBean) throws ServiceException;
	
}
