package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class UnidadLeccionBean extends BaseBean{
 
	private UnidadBean unidadBean =new UnidadBean();
	  
	private String nombre ;
	  
	private String descripcion ;
	  
	private MaestraBean situacion = new MaestraBean();

	
	public UnidadLeccionBean() {
		super(); 
	}

	public UnidadBean getUnidadBean() {
		return unidadBean;
	} 
	
	public void setUnidadBean(UnidadBean unidadBean) {
		this.unidadBean = unidadBean;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	@Override
	public String toString() {
		return "UnidadLeccionBean [lenguaUnidadBean=" + unidadBean + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", situacion=" + situacion + "]";
	}

}
