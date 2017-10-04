package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class TextoPalabraCorrectaBean extends BaseBean{

	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	private String titulo;
	private String texto;
 
	
	public TextoPalabraCorrectaBean() {
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



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	@Override
	public String toString() {
		return "TextoPalabraCorrectaBean [materialTipoEjercicioBean=" + materialTipoEjercicioBean + ", titulo=" + titulo
				+ ", texto=" + texto + "]";
	}


	 
	
}
