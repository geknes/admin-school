package com.service.school.core.bean.bean.academico;

import javax.persistence.Column;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.MaestraBean;

public class MatriculaAlumnoBean extends BaseBean{


	

	private MatriculaBean matriculaBean;
				
	private AlumnoBean alumnoBean;
		
	private MaestraBean situacionMatriculaAlumno;

	public MatriculaBean getMatriculaBean() {
		if(matriculaBean == null){
			matriculaBean = new MatriculaBean();
		}
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	public AlumnoBean getAlumnoBean() {
		
		if(alumnoBean == null){
			alumnoBean = new AlumnoBean();
		}
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public MaestraBean getSituacionMatriculaAlumno() {
		if(situacionMatriculaAlumno == null){
			situacionMatriculaAlumno = new MaestraBean();
		}
		return situacionMatriculaAlumno;
	}

	public void setSituacionMatriculaAlumno(MaestraBean situacionMatriculaAlumno) {
		this.situacionMatriculaAlumno = situacionMatriculaAlumno;
	}

	@Override
	public String toString() {
		return "MatriculaAlumnoBean [matriculaBean=" + matriculaBean + ", alumnoBean=" + alumnoBean
				+ ", situacionMatriculaAlumno=" + situacionMatriculaAlumno + "]";
	}

	
	
	
}
