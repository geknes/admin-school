package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class AlterTextoPalabraCorrectaBean extends BaseBean{

	private TextoPalabraCorrectaBean 	textoPalabraCorrectaBean ;
	private String						palabraCorrecta;
	private String						descripcion;
	private String 						respuestaEstado;
	
	public AlterTextoPalabraCorrectaBean() {
		super();
	}

	public TextoPalabraCorrectaBean getTextoPalabraCorrectaBean() {
		if (textoPalabraCorrectaBean == null) {
			textoPalabraCorrectaBean = 	new TextoPalabraCorrectaBean();
		}
		return textoPalabraCorrectaBean;
	}

	public void setTextoPalabraCorrectaBean(TextoPalabraCorrectaBean textoPalabraCorrectaBean) {
		this.textoPalabraCorrectaBean = textoPalabraCorrectaBean;
	}

	public String getPalabraCorrecta() {
		return palabraCorrecta;
	}

	public void setPalabraCorrecta(String palabraCorrecta) {
		this.palabraCorrecta = palabraCorrecta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRespuestaEstado() {
		return respuestaEstado;
	}

	public void setRespuestaEstado(String respuestaEstado) {
		this.respuestaEstado = respuestaEstado;
	}

	@Override
	public String toString() {
		return "AlterTextoPalabraCorrectaBean [textoPalabraCorrectaBean=" + textoPalabraCorrectaBean
				+ ", palabraCorrecta=" + palabraCorrecta + ", descripcion=" + descripcion + ", respuestaEstado="
				+ respuestaEstado + "]";
	}

	
	
}
