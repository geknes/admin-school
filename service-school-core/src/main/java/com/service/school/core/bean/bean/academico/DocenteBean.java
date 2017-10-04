package com.service.school.core.bean.bean.academico;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;

@SuppressWarnings("serial")
public class DocenteBean extends BaseBean{

	//private Integer codDocente;
	private PersonaBean personaBean = new PersonaBean();//Integer codPersona
	private InstitucionBean institucionBean = new InstitucionBean();//Integer codInstitucion;
	private LenguaBean lenguaBean = new LenguaBean();//Integer codlenguaje;
	private MaestraBean gradoDocente = new MaestraBean();//int
	private MaestraBean carreraDocente= new MaestraBean();//int 
	private MaestraBean situacion= new MaestraBean();//int tm1SituacionDocente
	private EspecialidadBean especialidadBean = new EspecialidadBean();
	private UbigeoBean  ubigeoBean = new UbigeoBean();
	private InscripcionLenguaBean	inscripcionLenguaBean;
	/* auditoria
	private String 	fechaCreacion;
	private String 	usuarioCreacion;
	private String 	ipCreacion;
	private String 	fechaModificacion;
	private String 	usuarioModificacion;
	private String 	ipModificacion; 
	*/

	public DocenteBean() {
		super();
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	

	public MaestraBean getGradoDocente() {
		return gradoDocente;
	}

	public void setGradoDocente(MaestraBean gradoDocente) {
		this.gradoDocente = gradoDocente;
	}

	public MaestraBean getCarreraDocente() {
		return carreraDocente;
	}

	public void setCarreraDocente(MaestraBean carreraDocente) {
		this.carreraDocente = carreraDocente;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public EspecialidadBean getEspecialidadBean() {
		return especialidadBean;
	}

	public void setEspecialidadBean(EspecialidadBean especialidadBean) {
		this.especialidadBean = especialidadBean;
	}

	
	
	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	@Override
	public String toString() {
		return "DocenteBean [personaBean=" + personaBean + ", institucionBean="
				+ institucionBean + ", lenguaBean=" + lenguaBean
				+ ", gradoDocente=" + gradoDocente + ", carreraDocente="
				+ carreraDocente + ", situacion=" + situacion + "]";
	}

	public InscripcionLenguaBean getInscripcionLenguaBean() {
	
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	

}
