package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class InstitucionOperadorBean extends BaseBean{

	private int  codigoPersona;
	private int  codigoInstitucion;
	private int  situacionOperador;
	
	private PersonaBean personaBean =  new PersonaBean();
	
	private String nombreSituacion;
	private String strFecha;
	
	private MaestraBean cargo  = new MaestraBean();
	
	public InstitucionOperadorBean() {
		super();
	}

	public int getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(int codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public int getCodigoInstitucion() {
		return codigoInstitucion;
	}

	public void setCodigoInstitucion(int codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}

	public int getSituacionOperador() {
		return situacionOperador;
	}

	public void setSituacionOperador(int situacionOperador) {
		this.situacionOperador = situacionOperador;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public String getNombreSituacion() {
		return nombreSituacion;
	}

	public void setNombreSituacion(String nombreSituacion) {
		this.nombreSituacion = nombreSituacion;
	}

	public String getStrFecha() {
		return strFecha;
	}

	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}

	public MaestraBean getCargo() {
		return cargo;
	}

	public void setCargo(MaestraBean cargo) {
		this.cargo = cargo;
	}
	
}
