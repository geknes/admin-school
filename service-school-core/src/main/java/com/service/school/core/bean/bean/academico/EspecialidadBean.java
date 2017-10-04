package com.service.school.core.bean.bean.academico;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;

@SuppressWarnings("serial")
public class EspecialidadBean extends BaseBean{
	
	private DocenteBean docenteBean;//Integer
	private LenguaBean lenguaBean;//Integer
	private MaestraBean tm2Nivel;//Integer
	private String 	numeroDocumento;
	private String 	rutaDocumento;

		
	public EspecialidadBean() {
		super();
	}

	public DocenteBean getDocenteBean() {
		
		return docenteBean;
	}


	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}


	public LenguaBean getLenguaBean() {
		
		return lenguaBean;
	}


	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}


	public MaestraBean getTm2Nivel() {
		
		return tm2Nivel;
	}


	public void setTm2Nivel(MaestraBean tm2Nivel) {
		this.tm2Nivel = tm2Nivel;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getRutaDocumento() {
		return rutaDocumento;
	}

	public void setRutaDocumento(String rutaDocumento) {
		this.rutaDocumento = rutaDocumento;
	}
	
		
}
