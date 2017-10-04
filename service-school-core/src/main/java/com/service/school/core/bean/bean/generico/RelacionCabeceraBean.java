package com.service.school.core.bean.bean.generico;

import java.util.List;

import com.service.school.core.bean.bean.BaseBean;

public class RelacionCabeceraBean extends BaseBean{

	private MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
	private String titulo;
	
	private List<RelacionBean> listaRelacion;
	
	public RelacionCabeceraBean() {
		super();
	}

	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<RelacionBean> getListaRelacion() {
		return listaRelacion;
	}

	public void setListaRelacion(List<RelacionBean> listaRelacion) {
		this.listaRelacion = listaRelacion;
	}

	@Override
	public String toString() {
		return "RelacionCabeceraBean [materialTipoEjercicioBean=" + materialTipoEjercicioBean + ", titulo=" + titulo
				+ "]";
	}

}
