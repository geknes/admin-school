package com.service.school.core.entity.entity.general;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbdinstlengua.insertar", 
			procedureName = "gene.fun_leotbdinstlengua_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codinleng", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

			})
			,
			@NamedStoredProcedureQuery(name = "leotbdinstlengua.buscarPorCodigoInstitucion", 
			procedureName = "gene.fun_leotbdinstlengua_buscar_x_codigo_institucion", 
			resultClasses = LeotbdInstlengua.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class)

			}),
			@NamedStoredProcedureQuery(name = "leotbdinstlengua.eliminar", 
			procedureName = "gene.fun_leotbdinstlengua_eliminar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinleng", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

			}),
			@NamedStoredProcedureQuery(name = "leotbdinstlengua.existeLenguaInstitucion", 
			procedureName = "gene.fun_leotbdinstlengua_existe_lengua", 
			resultClasses = LeotbdInstlengua.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "n_codlengua", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "n_codisnti", type = long.class)
			})
	
	
})
@Entity
@Table(name = "leotbd_instlengua")
public class LeotbdInstlengua implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "n_codinleng")
	private int nCodinleng;

	@Column(name = "n_codlengua")
	private int nCodlengua;

	@Column(name = "nCodisnti")
	private int nCodisnti;

	@Column(name = "n_codusureg")
	private int nCodusureg;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Column(name = "v_hostreg")
	private String vHostreg;

	@Column(name = "n_codusumod")
	private int nCodusumod;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;
	
	private String nombreLengua;

	public LeotbdInstlengua() {
		super();
	}

	public int getnCodinleng() {
		return nCodinleng;
	}

	public void setnCodinleng(int nCodinleng) {
		this.nCodinleng = nCodinleng;
	}

	public int getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(int nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public int getnCodisnti() {
		return nCodisnti;
	}

	public void setnCodisnti(int nCodisnti) {
		this.nCodisnti = nCodisnti;
	}

	public int getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(int nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public int getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(int nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}
	public String getNombreLengua() {
		return nombreLengua;
	}

	public void setNombreLengua(String nombreLengua) {
		this.nombreLengua = nombreLengua;
	}
	

	@Override
	public String toString() {
		return "LeotbdInstlengua [nCodinleng=" + nCodinleng + ", nCodlengua="
				+ nCodlengua + ", nCodisnti=" + nCodisnti + ", nCodusureg="
				+ nCodusureg + ", dFecreg=" + dFecreg + ", vHostreg="
				+ vHostreg + ", nCodusumod=" + nCodusumod + ", dFecmod="
				+ dFecmod + "]";
	}


	
	

}
