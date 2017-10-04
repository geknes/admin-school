package com.service.school.core.bean.bean.generico;

import com.service.school.core.bean.bean.BaseBean;

public class OrdenarParrafoBean extends BaseBean{

	//Atributos
	private MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
	private String titulo;
	private String parrafo;
	private int    numeroOrden;
	private OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean = new OrdenarParrafoCabeceraBean();
	
	//Constructor
	
	public OrdenarParrafoBean() {
		super();
	}
	
	//Getters and Setters
	
	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getParrafo() {
		return parrafo;
	}

	public void setParrafo(String parrafo) {
		this.parrafo = parrafo;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public OrdenarParrafoCabeceraBean getOrdenarParrafoCabeceraBean() {
		return ordenarParrafoCabeceraBean;
	}

	public void setOrdenarParrafoCabeceraBean(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) {
		this.ordenarParrafoCabeceraBean = ordenarParrafoCabeceraBean;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "OrdenarParrafoBean [materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", titulo=" + titulo
				+ ", parrafo=" + parrafo + ", numeroOrden=" + numeroOrden + "]";
	}




}
