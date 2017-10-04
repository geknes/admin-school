 package com.service.school.core.repository.repository.interfaces.general;

import java.util.List;

import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;


public interface Maestra2DAO  extends BaseDAO<MaestraBean>  {
	 
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException;
	
	public List<MaestraBean> listarPorValor1(MaestraBean maestraBean) throws DAOException;
	
}
