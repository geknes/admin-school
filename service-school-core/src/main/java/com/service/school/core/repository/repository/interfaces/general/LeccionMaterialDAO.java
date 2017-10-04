package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.LeccionMaterialBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface LeccionMaterialDAO extends BaseDAO<LeccionMaterialBean>{

	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws DAOException;
}
