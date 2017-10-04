package com.service.school.core.bean.bean.seguridad;


import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.MaestraBean;

public class PerfilBean extends BaseBean {
	

	private Long codigoPerfil;



	//private Long nTm1sitprf;
	private MaestraBean situacion;



	private String nombrePerfil;

	
	
	public PerfilBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getCodigoPerfil() {
		return codigoPerfil;
	}



	public void setCodigoPerfil(Long codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}



	public MaestraBean getSituacion() {
		return situacion;
	}



	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}



	public String getNombrePerfil() {
		return nombrePerfil;
	}



	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	
	
	
}
