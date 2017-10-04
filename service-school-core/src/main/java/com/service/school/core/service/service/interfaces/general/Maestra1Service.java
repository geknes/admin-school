package com.service.school.core.service.service.interfaces.general;
  
import java.util.List;

import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface Maestra1Service extends BaseService<MaestraBean> {
	
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<MaestraBean> listarComboGeneral(String codTabla) throws ServiceException;

	public MaestraBean getBuscarPorTablaYRegistro(MaestraBean maestraBean) throws ServiceException; 
}
 
