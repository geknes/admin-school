package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.RelacionCabeceraBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface RelacionCabeceraDAO extends BaseDAO<RelacionCabeceraBean>
{
	public List<RelacionCabeceraBean> buscarPorEjercicio(RelacionCabeceraBean relacionCabeceraBean) throws DAOException;
	public List<RelacionCabeceraBean> buscarPorMatTEjerRelacionCab(RelacionCabeceraBean relacionCabeceraBean) throws DAOException;
	
}
