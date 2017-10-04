package com.service.school.core.bean.bean.academico;

import javax.persistence.Column;
import javax.persistence.Id;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;

public class UsuarioMatriculaBean  extends BaseBean{
	



	private InscripcionLenguaBean inscripcionLenguaBean = new InscripcionLenguaBean();
		
	private MatriculaBean matriculaBean = new MatriculaBean();
	
	private UsuarioBean usuarioBean = new UsuarioBean();			
				
	private AlumnoBean alumnoBean = new AlumnoBean();	
	
	private MaestraBean tipoCupo = new MaestraBean();
	
	private MaestraBean situacion = new MaestraBean();



	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public MatriculaBean getMatriculaBean() {
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public AlumnoBean getAlumnoBean() {
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public MaestraBean getTipoCupo() {
		return tipoCupo;
	}

	public void setTipoCupo(MaestraBean tipoCupo) {
		this.tipoCupo = tipoCupo;
	}


	
	
	

}
