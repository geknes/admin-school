package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.RelacionBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface RelacionDAO extends BaseDAO<RelacionBean>
{
	public List<RelacionBean> buscarPorRelacionCabecera(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarTextoTexto(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarCrucigrama(RelacionBean relacionBean) throws DAOException;
}
