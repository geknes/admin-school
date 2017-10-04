package com.service.school.core.bean.bean;

import java.util.Date;

public class BaseBean {
	
	protected long codigo;

	protected String estado;
		
	protected String audTipo;
	
	protected String audSession; 
	
	protected long audCodigoUsuario; 
//
//	protected String audFechaHora; 
	protected String audHostIP;

	
	protected Date 	    fechaCreacion;
	protected long 		codigoUsuarioCreacion;
	protected String 	ipCreacion;
	
	protected Date 	fechaModificacion;
	protected long 		codigoUsuarioModificacion;
	protected String 	ipModificacion; 

	public BaseBean(){
		super();
	}
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAudTipo() {
		return audTipo;
	}

	public void setAudTipo(String audTipo) {
		this.audTipo = audTipo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
 
	public String getIpCreacion() {
		return ipCreacion;
	}
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	public String getIpModificacion() {
		return ipModificacion;
	}
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}
	
	public String getAudSession() {
		return audSession;
	}
	public void setAudSession(String audSession) {
		this.audSession = audSession;
	}
	
	public long getCodigoUsuarioCreacion() {
		return codigoUsuarioCreacion;
	}
	public void setCodigoUsuarioCreacion(long codigoUsuarioCreacion) {
		this.codigoUsuarioCreacion = codigoUsuarioCreacion;
	}
	public long getCodigoUsuarioModificacion() {
		return codigoUsuarioModificacion;
	}
	public void setCodigoUsuarioModificacion(long codigoUsuarioModificacion) {
		this.codigoUsuarioModificacion = codigoUsuarioModificacion;
	}
	
	public long getAudCodigoUsuario() {
		return audCodigoUsuario;
	}
	public void setAudCodigoUsuario(long audCodigoUsuario) {
		this.audCodigoUsuario = audCodigoUsuario;
	}
	/*public String getAudFechaHora() {
		return audFechaHora;
	}
	public void setAudFechaHora(String audFechaHora) {
		this.audFechaHora = audFechaHora;
	}*/
	public String getAudHostIP() {
		return audHostIP;
	}
	public void setAudHostIP(String audHostIP) {
		this.audHostIP = audHostIP;
	}
	@Override
	public String toString() {
		return "BaseBean [codigo=" + codigo + ", estado=" + estado + ", audTipo=" + audTipo + ", audSession="
				+ audSession + ", fechaCreacion=" + fechaCreacion + ", codigoUsuarioCreacion=" + codigoUsuarioCreacion
				+ ", ipCreacion=" + ipCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", codigoUsuarioModificacion=" + codigoUsuarioModificacion + ", ipModificacion=" + ipModificacion
				+ "]";
	}
	
	
}
