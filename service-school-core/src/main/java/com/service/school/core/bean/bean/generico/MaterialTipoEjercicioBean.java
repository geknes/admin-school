package com.service.school.core.bean.bean.generico;


import com.service.school.core.bean.bean.BaseBean;

public class MaterialTipoEjercicioBean extends BaseBean{
	
	/*

	@Column(name = "n_codlesmat")
	private Long nCodlesmat;
	

	 */
	
	//Atributo 
	private LeccionMaterialBean leccionMaterialBean =  new LeccionMaterialBean();
	private MaestraBean 	    tipoEjercicio 		= new MaestraBean();
	private MaestraBean 		situacionTipo 		= new MaestraBean();
	private String 				titulo;

	
	//Constructor
	
	public MaterialTipoEjercicioBean() {
		super();
	}

	//Getters and Setters
	
	public MaestraBean getTipoEjercicio() {
		return tipoEjercicio;
	}


	public void setTipoEjercicio(MaestraBean tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}


	public MaestraBean getSituacionTipo() {
		return situacionTipo;
	}


	public void setSituacionTipo(MaestraBean situacionTipo) {
		this.situacionTipo = situacionTipo;
	}
	
	public LeccionMaterialBean getLeccionMaterialBean() {
		return leccionMaterialBean;
	}

	public void setLeccionMaterialBean(LeccionMaterialBean leccionMaterialBean) {
		this.leccionMaterialBean = leccionMaterialBean;
	}
		
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	//toString

	@Override
	public String toString() {
		return "LenguaMaterialTipoEjercicioBean [tipoEjercicio="
				+ tipoEjercicio + ", situacionTipo=" + situacionTipo + "]";
	}


}
