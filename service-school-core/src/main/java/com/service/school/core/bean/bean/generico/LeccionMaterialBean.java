package com.service.school.core.bean.bean.generico;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.service.school.core.bean.bean.BaseBean;

public class LeccionMaterialBean extends BaseBean{
	

/*********** jorge ************/
	private UnidadLeccionBean unidadLeccionBean  = new UnidadLeccionBean();

	private MaestraBean situacionLeccionMaterial = new MaestraBean();

	private String contexto;

	private String descripcionMaterial;

	private String extencionImagen;

	private String nombreImagen;

	private String rutaAudio;

	private String swEditable;

	private String ubicacionImagen;

	public MaestraBean getSituacionLeccionMaterial() {
		return situacionLeccionMaterial;
	}

	public void setSituacionLeccionMaterial(MaestraBean situacionLeccionMaterial) {
		this.situacionLeccionMaterial = situacionLeccionMaterial;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public String getExtencionImagen() {
		return extencionImagen;
	}

	public void setExtencionImagen(String extencionImagen) {
		this.extencionImagen = extencionImagen;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getRutaAudio() {
		return rutaAudio;
	}

	public void setRutaAudio(String rutaAudio) {
		this.rutaAudio = rutaAudio;
	}

	public String getSwEditable() {
		return swEditable;
	}

	public void setSwEditable(String swEditable) {
		this.swEditable = swEditable;
	}

	public String getUbicacionImagen() {
		return ubicacionImagen;
	}

	public void setUbicacionImagen(String ubicacionImagen) {
		this.ubicacionImagen = ubicacionImagen;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	@Override
	public String toString() {
		return "LeccionMaterialBean [unidadLeccionBean=" + unidadLeccionBean + ", situacionLeccionMaterial="
				+ situacionLeccionMaterial + ", contexto=" + contexto + ", descripcionMaterial=" + descripcionMaterial
				+ ", extencionImagen=" + extencionImagen + ", nombreImagen=" + nombreImagen + ", rutaAudio=" + rutaAudio
				+ ", swEditable=" + swEditable + ", ubicacionImagen=" + ubicacionImagen + "]";
	}
	
	

}
