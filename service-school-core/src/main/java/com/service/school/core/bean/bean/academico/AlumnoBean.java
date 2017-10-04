package com.service.school.core.bean.bean.academico;

import java.util.List;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.generico.PersonaLenguaBean;
import com.service.school.core.bean.bean.generico.PersonaNacionalidadBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;

@SuppressWarnings("serial")
public class AlumnoBean extends BaseBean{
	
	private String usuario;
	private MaestraBean tm2Programa;//String
	private MaestraBean tm2Nivel;//Integer
	private MaestraBean tm2Grado;//Integer
	private MaestraBean tm1Situacion;//Integer tm1SituacionAlumno

	private PersonaBean personaBean;
	private InstitucionBean institucionBean;
	private UbigeoBean ubigeoBean;
    private InscripcionLenguaBean inscripcionLenguaBean;
	private List<PersonaNacionalidadBean> lstPersonaNacionalidadBean;
	private List<PersonaLenguaBean> lstPersonaLenguaBean;
		
	public AlumnoBean() {
		super();
	}
	
	public PersonaBean getPersonaBean() {
		if(personaBean == null){
			personaBean = new PersonaBean();
		}
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public MaestraBean getTm2Programa() {
		
		if(tm2Programa == null){
			tm2Programa = new MaestraBean();
		}
		return tm2Programa;
	}

	public void setTm2Programa(MaestraBean tm2Programa) {
		this.tm2Programa = tm2Programa;
	}

	public MaestraBean getTm2Nivel() {
		
		if(tm2Nivel == null){
			tm2Nivel = new MaestraBean();
		}
		return tm2Nivel;
	}

	public void setTm2Nivel(MaestraBean tm2Nivel) {
		this.tm2Nivel = tm2Nivel;
	}

	public MaestraBean getTm2Grado() {
		
		if(tm2Grado == null){
			tm2Grado = new MaestraBean();
		}
		return tm2Grado;
	}

	public void setTm2Grado(MaestraBean tm2Grado) {
		this.tm2Grado = tm2Grado;
	}

	public MaestraBean getTm1Situacion() {
		
		if(tm1Situacion == null){
			tm1Situacion = new MaestraBean();
		}
		return tm1Situacion;
	}

	public void setTm1Situacion(MaestraBean tm1Situacion) {
		this.tm1Situacion = tm1Situacion;
	}

	public InstitucionBean getInstitucionBean() {
		
		if(institucionBean == null){
			institucionBean = new InstitucionBean();
		}
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	public List<PersonaNacionalidadBean> getLstPersonaNacionalidadBean() {
		return lstPersonaNacionalidadBean;
	}

	public void setLstPersonaNacionalidadBean(
			List<PersonaNacionalidadBean> lstPersonaNacionalidadBean) {
		this.lstPersonaNacionalidadBean = lstPersonaNacionalidadBean;
	}

	public List<PersonaLenguaBean> getLstPersonaLenguaBean() {
		return lstPersonaLenguaBean;
	}

	public void setLstPersonaLenguaBean(List<PersonaLenguaBean> lstPersonaLenguaBean) {
		this.lstPersonaLenguaBean = lstPersonaLenguaBean;
	}
	
	

	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "AlumnoBean [tm2Programa=" + tm2Programa + ", tm2Nivel="
				+ tm2Nivel + ", tm2Grado=" + tm2Grado + ", tm1Situacion="
				+ tm1Situacion + ", personaBean=" + personaBean
				+ ", institucionBean=" + institucionBean + "]";
	}


	
	
}
