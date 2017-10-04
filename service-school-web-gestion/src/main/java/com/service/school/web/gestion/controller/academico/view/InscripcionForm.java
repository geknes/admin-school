package com.service.school.web.gestion.controller.academico.view;

import com.service.school.core.bean.bean.academico.DocumentoInscripcionBean;
import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;

public class InscripcionForm {

	private InscripcionBean inscripcionBean = new InscripcionBean();
	
	private InscripcionLenguaBean inscripcionLenguaBean = new InscripcionLenguaBean();
	
	private DocumentoInscripcionBean documentoInscripcionBean = new DocumentoInscripcionBean();
	
	
	public InscripcionForm() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InscripcionBean getInscripcionBean() {
		return inscripcionBean;
	}


	public void setInscripcionBean(InscripcionBean inscripcionBean) {
		this.inscripcionBean = inscripcionBean;
	}


	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}


	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}


	public DocumentoInscripcionBean getDocumentoInscripcionBean() {
		return documentoInscripcionBean;
	}


	public void setDocumentoInscripcionBean(DocumentoInscripcionBean documentoInscripcionBean) {
		this.documentoInscripcionBean = documentoInscripcionBean;
	}

	
}
