package com.service.school.web.gestion.controller.general.view;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.bean.bean.generico.UnidadLeccionBean;

public class LenguaForm {

 private LenguaBean  lenguaBean = new LenguaBean();
 
 private LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
 
 private UnidadBean unidadBean = new UnidadBean();
 
 private UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();

public LenguaBean getLenguaBean() {
	return lenguaBean;
}

public void setLenguaBean(LenguaBean lenguaBean) {
	this.lenguaBean = lenguaBean;
}

public LenguaEstructuraBean getLenguaEstructuraBean() {
	return lenguaEstructuraBean;
}

public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
	this.lenguaEstructuraBean = lenguaEstructuraBean;
}

public UnidadBean getUnidadBean() {
	return unidadBean;
}

public void setUnidadBean(UnidadBean unidadBean) {
	this.unidadBean = unidadBean;
}

public UnidadLeccionBean getUnidadLeccionBean() {
	return unidadLeccionBean;
}

public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
	this.unidadLeccionBean = unidadLeccionBean;
}

@Override
public String toString() {
	return "LenguaForm [lenguaBean=" + lenguaBean + ", lenguaEstructuraBean=" + lenguaEstructuraBean + ", unidadBean="
			+ unidadBean + ", unidadLeccionBean=" + unidadLeccionBean + "]";
}
  	 
}
