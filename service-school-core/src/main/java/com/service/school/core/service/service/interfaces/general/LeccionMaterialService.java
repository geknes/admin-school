package com.service.school.core.service.service.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.LeccionMaterialBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface LeccionMaterialService extends BaseService<LeccionMaterialBean>{

	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws ServiceException;
}
