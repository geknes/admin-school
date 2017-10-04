package com.service.school.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.MaestraBean;

@SuppressWarnings("serial")
public class MascotaBean extends BaseBean{
	
	//Atributos
	 
	private String   nombre;
	private String   descripcion;
	private String   imagen;
//	private Integer   region;
	private Integer   valormoneda;
	private MaestraBean situacion = new MaestraBean();
	private MaestraBean region = new MaestraBean();
	private Integer   predeterminado;
	 
	private String imagenAlegre;
	private String imagenTriste;
	private String imagenExclamativa;
	private String imagenNormal;
	private Integer 	 retorno;
	private MultipartFile 	file;
	
	//constructor	
	public MascotaBean() {
		super();
	}

	//Getters and Setters
	
	
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


	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	 

	public MaestraBean getRegion() {
		return region;
	}

	public void setRegion(MaestraBean region) {
		this.region = region;
	}

 
	public MaestraBean getSituacion() {
		return situacion;
	}




	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}
	
	
 
	public Integer getValormoneda() {
		return valormoneda;
	}


	public void setValormoneda(Integer valormoneda) {
		this.valormoneda = valormoneda;
	}



	public Integer getPredeterminado() {
		return predeterminado;
	}

	

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}

	public void setPredeterminado(Integer predeterminado) {
		this.predeterminado = predeterminado;
	}

	//toString 
	@Override
	public String toString() {
		return "MascotaBean [nombre=" + nombre + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", valormoneda=" + valormoneda
				+ ", situacion=" + situacion + ", region=" + region
				+ ", predeterminado=" + predeterminado + "]" +super.toString();
	}

	public String getImagenAlegre() {
		return imagenAlegre;
	}

	public void setImagenAlegre(String imagenAlegre) {
		this.imagenAlegre = imagenAlegre;
	}

	public String getImagenTriste() {
		return imagenTriste;
	}

	public void setImagenTriste(String imagenTriste) {
		this.imagenTriste = imagenTriste;
	}

	public String getImagenExclamativa() {
		return imagenExclamativa;
	}

	public void setImagenExclamativa(String imagenExclamativa) {
		this.imagenExclamativa = imagenExclamativa;
	}

	public String getImagenNormal() {
		return imagenNormal;
	}

	public void setImagenNormal(String imagenNormal) {
		this.imagenNormal = imagenNormal;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	} 
	
//	@Override
//	public String toString() {
//		return "MascotaBean [nombre=" + nombre + ", descripcion=" + descripcion
//				+ ", imagen=" + imagen + ", region=" + region + ", situacion="
//				+ situacion + "]" +super.toString();
//	} 
  
 	

}
