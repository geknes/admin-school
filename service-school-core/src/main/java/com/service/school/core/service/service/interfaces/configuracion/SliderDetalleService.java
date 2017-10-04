package com.service.school.core.service.service.interfaces.configuracion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.configuracion.SliderDetalleBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.BaseService;

@Transactional(readOnly = true)
public interface SliderDetalleService extends BaseService<SliderDetalleBean>{

	public List<SliderDetalleBean> getlistarSliderDetalleXCodigoSlider(SliderDetalleBean sliderDetalleBean)  throws ServiceException;

}
