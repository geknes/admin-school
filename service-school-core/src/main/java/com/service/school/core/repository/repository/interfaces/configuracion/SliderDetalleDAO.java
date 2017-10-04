package com.service.school.core.repository.repository.interfaces.configuracion;


import java.util.List;

import com.service.school.core.bean.bean.configuracion.SliderDetalleBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.BaseDAO;

public interface SliderDetalleDAO extends BaseDAO<SliderDetalleBean>{
	
	public List<SliderDetalleBean> getlistarSliderDetalleXCodigoSlider(SliderDetalleBean sliderDetalleBean)  throws DAOException;
}
