package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class OracionCompletarBean extends BaseBean{

	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	private String titulo;
	private String oracion;
 
	
	public OracionCompletarBean() {
		super();
	}

	 

	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}



	public void setMaterialTipoEjercicioBean(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getOracion() {
		return oracion;
	}



	public void setOracion(String oracion) {
		this.oracion = oracion;
	}



	@Override
	public String toString() {
		return "OracionCompletarBean [materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", titulo=" + titulo
				+ ", oracion=" + oracion + "]";
	}



	 
	
}
