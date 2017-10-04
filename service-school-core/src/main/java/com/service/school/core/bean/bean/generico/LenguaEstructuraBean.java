package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;
 
 
public class LenguaEstructuraBean extends BaseBean{
	 
	private LenguaBean lenguaBean = new LenguaBean(); 
	
	private MaestraBean nivel = new MaestraBean(); 
	
	private MaestraBean subNivel = new MaestraBean(); 
	
	private MaestraBean situacion = new MaestraBean(); 
	
	private String swActivo;
	
	/*** temporales ***/
	
	private String basico;
	private String intermedio;
	private String avanzado;
	private int    cantidadUnidad;
	private int    cantidadLeccion;
	
	public LenguaEstructuraBean(){
		super();
	}

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public MaestraBean getNivel() {
		return nivel;
	}

	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}

	public MaestraBean getSubNivel() {
		return subNivel;
	}

	public void setSubNivel(MaestraBean subNivel) {
		this.subNivel = subNivel;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public String getSwActivo() {
		return swActivo;
	}

	public void setSwActivo(String swActivo) {
		this.swActivo = swActivo;
	}

	public String getBasico() {
		return basico;
	}

	public void setBasico(String basico) {
		this.basico = basico;
	}

	public String getIntermedio() {
		return intermedio;
	}

	public void setIntermedio(String intermedio) {
		this.intermedio = intermedio;
	}

	public String getAvanzado() {
		return avanzado;
	}

	public void setAvanzado(String avanzado) {
		this.avanzado = avanzado;
	}

	public int getCantidadUnidad() {
		return cantidadUnidad;
	}

	public void setCantidadUnidad(int cantidadUnidad) {
		this.cantidadUnidad = cantidadUnidad;
	}

	
	public int getCantidadLeccion() {
		return cantidadLeccion;
	}

	public void setCantidadLeccion(int cantidadLeccion) {
		this.cantidadLeccion = cantidadLeccion;
	}

	@Override
	public String toString() {
		return "LenguaEstructuraBean [lenguaBean=" + lenguaBean + ", nivel=" + nivel + ", subNivel=" + subNivel
				+ ", situacion=" + situacion + ", swActivo=" + swActivo + "]";
	}
	
 
}
