package com.service.school.web.gestion.controller.configuracion.view;

import com.service.school.core.bean.bean.configuracion.SliderBean;
import com.service.school.core.bean.bean.configuracion.SliderDetalleBean;

public class SliderForm {
	private SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
	private SliderBean sliderBean = new SliderBean();
	
	public SliderForm() {
		super();
	}

	public SliderDetalleBean getSliderDetalleBean() {
		return sliderDetalleBean;
	}

	public void setSliderDetalleBean(SliderDetalleBean sliderDetalleBean) {
		this.sliderDetalleBean = sliderDetalleBean;
	}

	public SliderBean getSliderBean() {
		return sliderBean;
	}

	public void setSliderBean(SliderBean sliderBean) {
		this.sliderBean = sliderBean;
	}
	
	
	
	
}
