package com.service.school.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbc_textopalabracorrecta.buscar_por_codigo", 
			procedureName = "gene.fun_leotbctextopalabracorrecta_buscar_x_codigo", 
			resultClasses = LeotbcTextopalabracorrecta.class, 
			parameters = {
			   @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = long.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabracorrecta.buscar_por_Matejercicio", 
			procedureName = "gene.fun_leotbctextopalabracorrecta_buscar_x_matejer", 
			resultClasses = LeotbcTextopalabracorrecta.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabracorrecta.buscar_por_Filtros", 
			procedureName = "gene.fun_leotbctextopalabracorrecta_buscar_x_filtro",
			resultClasses = LeotbcTextopalabracorrecta.class, 
			parameters = {
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabracorrecta.insertar", 
			procedureName = "gene.fun_leotbctextopalabracorrecta_insertar", 		
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codtextopalabracorrec", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabracorrecta.eliminar", 
			procedureName = "gene.fun_leotbctextopalabracorrecta_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabracorrecta.actualizar", 
			procedureName = "gene.fun_leotbctextopalabracorrectar_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
})

@Entity
@Table(name="leotbc_textopalabracorrecta")
public class LeotbcTextopalabracorrecta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codtextopalabracorrec")
	private long nCodtextopalabracorrec;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codmatpej")
	private long nCodmatpej;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_texto")
	private String vTexto;

	@Column(name="v_titulo")
	private String vTitulo;

	public LeotbcTextopalabracorrecta() {
	}

	public long getnCodtextopalabracorrec() {
		return nCodtextopalabracorrec;
	}

	public void setnCodtextopalabracorrec(long nCodtextopalabracorrec) {
		this.nCodtextopalabracorrec = nCodtextopalabracorrec;
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
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

	public String getvTexto() {
		return vTexto;
	}

	public void setvTexto(String vTexto) {
		this.vTexto = vTexto;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	
	

}