package com.service.school.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.MaestraBean;

public class FondoBean extends BaseBean{
	
	//Atributos
	private Integer codFond;
	private String nombre;
	private String descripcion;
	private Integer monedas;
	private MaestraBean  situacion  = new MaestraBean();
	private MaestraBean  region 	= new MaestraBean();
	private MaestraBean  tipo 		= new MaestraBean();
	private String 		imagenUbicacion;
	private String 		imagenNombre;
	private MultipartFile 	file;
	private MultipartFile 	fileImagen; 
	private Integer 	 retorno;
	
	//Constructor
	public FondoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getters and Setters
	public Integer getCodFond() {
		return codFond;
	}

	public void setCodFond(Integer codFond) {
		this.codFond = codFond;
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

	public Integer getMonedas() {
		return monedas;
	}

	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public MaestraBean getRegion() {
		return region;
	}

	public void setRegion(MaestraBean region) {
		this.region = region;
	}

	public MaestraBean getTipo() {
		return tipo;
	}

	public void setTipo(MaestraBean tipo) {
		this.tipo = tipo;
	}

	public String getImagenUbicacion() {
		return imagenUbicacion;
	}

	public void setImagenUbicacion(String imagenUbicacion) {
		this.imagenUbicacion = imagenUbicacion;
	}

	public String getImagenNombre() {
		return imagenNombre;
	}

	public void setImagenNombre(String imagenNombre) {
		this.imagenNombre = imagenNombre;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(MultipartFile fileImagen) {
		this.fileImagen = fileImagen;
	}

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}
	
	@Override
	public String toString() {
		return "FondoBean [codFond=" + codFond + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", monedas=" + monedas
				+ ", situacion=" + situacion + ", region=" + region + ", tipo="
				+ tipo + ", imagenUbicacion=" + imagenUbicacion
				+ ", imagenNombre=" + imagenNombre + ", file=" + file
				+ ", fileImagen=" + fileImagen + "]";
	}

	




	
	
	

}
