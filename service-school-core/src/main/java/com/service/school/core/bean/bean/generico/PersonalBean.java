package com.service.school.core.bean.bean.generico;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;

import com.service.school.core.bean.bean.BaseBean;

public class PersonalBean extends BaseBean {

	private PersonaBean personaBean = new PersonaBean();
	
	private MaestraBean  situacionPersonal = new MaestraBean();
	
	private MaestraBean cargoPersonal = new MaestraBean();
	
	private MaestraBean gradoPersonal = new MaestraBean();
	
	private String flgEstado;

	public PersonalBean(){
		super();
	}
	
	
	public MaestraBean getSituacionPersonal() {
		return situacionPersonal;
	}

	public void setSituacionPersonal(MaestraBean situacionPersonal) {
		this.situacionPersonal = situacionPersonal;
	}

	public MaestraBean getCargoPersonal() {
		return cargoPersonal;
	}

	public void setCargoPersonal(MaestraBean cargoPersonal) {
		this.cargoPersonal = cargoPersonal;
	}

	public MaestraBean getGradoPersonal() {
		return gradoPersonal;
	}

	public void setGradoPersonal(MaestraBean gradoPersonal) {
		this.gradoPersonal = gradoPersonal;
	}

	public String getFlgEstado() {
		return flgEstado;
	}

	public void setFlgEstado(String flgEstado) {
		this.flgEstado = flgEstado;
	}

	

	public PersonaBean getPersonaBean() {
		return personaBean;
	}


	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}


	@Override
	public String toString() {
		return "PersonalBean [situacionPersonal=" + situacionPersonal
				+ ", cargoPersonal=" + cargoPersonal + ", gradoPersonal="
				+ gradoPersonal + ", flgEstado=" + flgEstado + "]";
	}
	
	

	
}
