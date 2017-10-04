package com.service.school.core.service.service.interfaces.general;
  
import java.util.List;

import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

public interface Maestra2Service extends BaseService<MaestraBean> {
	
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<MaestraBean> listarPorValor1(MaestraBean maestraBean)  throws ServiceException; 
	
}
 
