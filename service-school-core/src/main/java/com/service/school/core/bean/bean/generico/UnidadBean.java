package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class UnidadBean extends BaseBean{
	
	private LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
	
	private MaestraBean unidad = new MaestraBean();
	
	private String nombre;
	
	private String traduccion;
	
	private String descripcion;
	
	private MaestraBean situacion = new MaestraBean();
	
	private String nombreLecciones;

	public LenguaEstructuraBean getLenguaEstructuraBean() {
		return lenguaEstructuraBean;
	}

	public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
		this.lenguaEstructuraBean = lenguaEstructuraBean;
	}
	
	public MaestraBean getUnidad() {
		return unidad;
	}

	public void setUnidad(MaestraBean unidad) {
		this.unidad = unidad;
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

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public String getNombreLecciones() {
		return nombreLecciones;
	}

	public void setNombreLecciones(String nombreLecciones) {
		this.nombreLecciones = nombreLecciones;
	}

	@Override
	public String toString() {
		return "UnidadBean [lenguaEstructuraBean=" + lenguaEstructuraBean + ", unidad=" + unidad + ", nombre=" + nombre
				+ ", traduccion=" + traduccion + ", descripcion=" + descripcion + ", situacion=" + situacion
				+ ", nombreLecciones=" + nombreLecciones + "]";
	}

	
}
