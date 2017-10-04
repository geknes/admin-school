package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;


public class InstitucionLenguaBean extends BaseBean{
	
	//atributos
	private LenguaBean lenguaBean =  new LenguaBean();
	private InstitucionBean institucionBean =  new InstitucionBean();
	private String strFechaRegistro;
	
	//Constructor
	
	public InstitucionLenguaBean() {
		super();
	}

	//Getters and Setter
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	//toString
	
	public String getStrFechaRegistro() {
		return strFechaRegistro;
	}

	public void setStrFechaRegistro(String strFechaRegistro) {
		this.strFechaRegistro = strFechaRegistro;
	}

	@Override
	public String toString() {
		return "InstitucionLenguaBean [lenguaBean=" + lenguaBean
				+ ", institucionBean=" + institucionBean + "]";
	}
}
