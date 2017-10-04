package com.service.school.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the leotbd_lecmaterial database table.
 * 
 */
@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbdlecmaterial.buscar_por_leccion", 
			procedureName = "gene.fun_leotbdlecmaterial_listar_x_leccion", 
			resultClasses = LeotbdLecmaterial.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codleslec", type = Long.class) 
			}),

	@NamedStoredProcedureQuery(name = "leotbdlecmaterial.buscar_por_codigo", 
		procedureName = "gene.fun_leotbdlecmaterial_buscar_x_codigo", 
		resultClasses = LeotbdLecmaterial.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = Long.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbdlecmaterial.buscar_por_filtros", 
		procedureName = "gene.fun_leotbdlecmaterial_buscar_x_filtros", 
		resultClasses = LeotbdLecmaterial.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codleslec", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = Integer.class)
		}),
	
	@NamedStoredProcedureQuery(name = "leotbdlecmaterial.insertar", 
		procedureName = "gene.fun_leotbdlecmaterial_insertar", 
		resultClasses = LeotbdLecmaterial.class, 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlesmat", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codleslec", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descmater", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contexto", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_sweditable", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rutaaudio", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ubiimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_extimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}),
	@NamedStoredProcedureQuery(name = "leotbdlecmaterial.eliminar", 
		procedureName = "gene.fun_leotbdlecmaterial_eliminar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbdlecmaterial.actualizar", 
		procedureName = "gene.fun_leotbdlecmaterial_update", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codleslec", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descmater", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contexto", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_sweditable", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rutaaudio", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ubiimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_extimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
}) 


@Entity
@Table(name="leotbd_lecmaterial")
public class LeotbdLecmaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codlesmat")
	private long nCodlesmat;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Column(name="n_codleslec")
	private long nCodleslec;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="n_tm1sitmat")
	private int nTm1sitmat;

	@Column(name="v_contexto")
	private String vContexto;

	@Column(name="v_descmater")
	private String vDescmater;

	@Column(name="v_extimag")
	private String vExtimag;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomimag")
	private String vNomimag;

	@Column(name="v_rutaaudio")
	private String vRutaaudio;

	@Column(name="v_sweditable")
	private String vSweditable;

	@Column(name="v_ubiimag")
	private String vUbiimag;

	public LeotbdLecmaterial() {
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public long getnCodleslec() {
		return nCodleslec;
	}

	public void setnCodleslec(long nCodleslec) {
		this.nCodleslec = nCodleslec;
	}

	public long getnCodlesmat() {
		return nCodlesmat;
	}

	public void setnCodlesmat(long nCodlesmat) {
		this.nCodlesmat = nCodlesmat;
	}

	public long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public int getnTm1sitmat() {
		return nTm1sitmat;
	}

	public void setnTm1sitmat(int nTm1sitmat) {
		this.nTm1sitmat = nTm1sitmat;
	}

	public String getvContexto() {
		return vContexto;
	}

	public void setvContexto(String vContexto) {
		this.vContexto = vContexto;
	}

	public String getvDescmater() {
		return vDescmater;
	}

	public void setvDescmater(String vDescmater) {
		this.vDescmater = vDescmater;
	}

	public String getvExtimag() {
		return vExtimag;
	}

	public void setvExtimag(String vExtimag) {
		this.vExtimag = vExtimag;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public String getvHostmod() {
		return vHostmod;
	}

	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public String getvNomimag() {
		return vNomimag;
	}

	public void setvNomimag(String vNomimag) {
		this.vNomimag = vNomimag;
	}

	public String getvRutaaudio() {
		return vRutaaudio;
	}

	public void setvRutaaudio(String vRutaaudio) {
		this.vRutaaudio = vRutaaudio;
	}

	public String getvSweditable() {
		return vSweditable;
	}

	public void setvSweditable(String vSweditable) {
		this.vSweditable = vSweditable;
	}

	public String getvUbiimag() {
		return vUbiimag;
	}

	public void setvUbiimag(String vUbiimag) {
		this.vUbiimag = vUbiimag;
	}

	

}