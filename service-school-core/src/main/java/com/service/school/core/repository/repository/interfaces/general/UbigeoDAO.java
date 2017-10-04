package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface UbigeoDAO extends BaseDAO<UbigeoBean>{

	public List<UbigeoBean> listarRegion() throws DAOException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws DAOException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws DAOException;
}
