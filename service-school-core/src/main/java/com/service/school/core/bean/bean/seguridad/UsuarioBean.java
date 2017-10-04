package com.service.school.core.bean.bean.seguridad;

import java.util.List;

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;



public class UsuarioBean extends BaseBean{
	
	private Long codigoUsuario;
	
	private Long codigoPerfil;

	private MaestraBean situacion;

	private String nombreUsuario;

	private String passwordUsuario;
	
	private PersonaBean persona;

	private String nombrePerfiles;
	
	private List<UsuarioPerfilBean> lstUsuarioPerfil;
	
	private List<AccesoBean> lstAcceso;
	
	private Long codPerfilUsuSelec;
	
	private String newPassword;
	
	private String flgRestPass;
	
	public UsuarioBean() {
		super();
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}



	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}



	public Long getCodigoPerfil() {
		return codigoPerfil;
	}



	public void setCodigoPerfil(Long codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}






	public MaestraBean getSituacion() {
		return situacion;
	}



	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getPasswordUsuario() {
		return passwordUsuario;
	}



	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}



	public PersonaBean getPersona() {
		return persona;
	}



	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}



	public String getNombrePerfiles() {
		return nombrePerfiles;
	}



	public void setNombrePerfiles(String nombrePerfiles) {
		this.nombrePerfiles = nombrePerfiles;
	}



	public List<UsuarioPerfilBean> getLstUsuarioPerfil() {
		return lstUsuarioPerfil;
	}



	public void setLstUsuarioPerfil(List<UsuarioPerfilBean> lstUsuarioPerfil) {
		this.lstUsuarioPerfil = lstUsuarioPerfil;
	}



	public List<AccesoBean> getLstAcceso() {
		return lstAcceso;
	}



	public void setLstAcceso(List<AccesoBean> lstAcceso) {
		this.lstAcceso = lstAcceso;
	}

	public boolean verificarAcceso(String opc){
		
		if (lstAcceso!=null) {
			for (AccesoBean acceso : lstAcceso) {
				if(acceso.getComponente()!=null){
					if (acceso.getComponente().getNombreComponente().equals(opc)) {
						return true;	
					}
				}
			}			
		}
		return false;
	}

	public Long getCodPerfilUsuSelec() {
		return codPerfilUsuSelec;
	}

	public void setCodPerfilUsuSelec(Long codPerfilUsuSelec) {
		this.codPerfilUsuSelec = codPerfilUsuSelec;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getFlgRestPass() {
		return flgRestPass;
	}

	public void setFlgRestPass(String flgRestPass) {
		this.flgRestPass = flgRestPass;
	}

	@Override
	public String toString() {
		return "UsuarioBean [codigoUsuario=" + codigoUsuario
				+ ", codigoPerfil=" + codigoPerfil + ", situacion=" + situacion
				+ ", nombreUsuario=" + nombreUsuario + ", passwordUsuario="
				+ passwordUsuario + ", persona=" + persona
				+ ", nombrePerfiles=" + nombrePerfiles + ", lstUsuarioPerfil="
				+ lstUsuarioPerfil + ", lstAcceso=" + lstAcceso
				+ ", codPerfilUsuSelec=" + codPerfilUsuSelec + ", newPassword="
				+ newPassword + ", flgRestPass=" + flgRestPass + "]";
	}
	
	
}
