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

	 @NamedStoredProcedureQuery(name = "leotbdlematxtipoej.insertar", 
			procedureName = "gene.fun_leotbdlematxtipoej_insertar", 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmatpej", type= int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sittip", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class)

		}),
	  @NamedStoredProcedureQuery(name = "leotbdlematxtipoej.actualizar", 
			procedureName = "gene.fun_leotbdlematxtipoej_actualizar", 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sittip", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod",   type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class)

		}),
	  @NamedStoredProcedureQuery(name = "leotbdlematxtipoej.eliminar", 
				procedureName = "gene.fun_leotbdlematxtipoej_eliminar", 
		 		parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),  
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod",   type = String.class)

			}),
	  @NamedStoredProcedureQuery(name = "leotbdlematxtipoej.buscarPorCodigo", 
				procedureName = "gene.fun_leotbdlematxtipoej_buscar_x_codigo",
				resultClasses = LeotbcMaterialTipoEje.class,
		 		parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class)

			}),
	  @NamedStoredProcedureQuery(name = "leotbdlematxtipoej.buscarPorFiltros", 
				procedureName = "gene.fun_leotbdlematxtipoej_buscar_x_filtros",
				resultClasses = LeotbcMaterialTipoEje.class,
		 		parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = long.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = int.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sittip", type = int.class)

			})
})

@Entity
@Table(name = "leotbd_lematxtipoej",schema="gene")
public class LeotbcMaterialTipoEje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codmatpej")
	private Long nCodmatpej;
	
	@Column(name = "n_codlesmat")
	private Long nCodlesmat;
	
	@Column(name = "n_tm2tpejer")
	private int nTm2tpejer;
	
	@Column(name = "n_tm1sittip")
	private int nTm1sittip;
		
	@Column(name = "n_codusureg")
	private int nCodUsuRegistro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecRegistro;
	
	@Column(name = "v_hostreg")
	private String vHostRegistro;
	
	@Column(name = "n_codusumod")
	private int nCodUsuModificado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dfecModificado;
	
	@Column(name = "v_hostmod")
	private String vHostModificado;
	
	@Column(name = "v_titulo")
	private String vTitulo;
	
	//Constructor
	
	public LeotbcMaterialTipoEje() {
		super();
	}
	
	//Getters and Setters
	
	public Long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(Long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public Long getnCodlesmat() {
		return nCodlesmat;
	}

	public void setnCodlesmat(Long nCodlesmat) {
		this.nCodlesmat = nCodlesmat;
	}

	public int getnTm2tpejer() {
		return nTm2tpejer;
	}

	public void setnTm2tpejer(int nTm2tpejer) {
		this.nTm2tpejer = nTm2tpejer;
	}

	public int getnTm1sittip() {
		return nTm1sittip;
	}

	public void setnTm1sittip(int nTm1sittip) {
		this.nTm1sittip = nTm1sittip;
	}

	public int getnCodUsuRegistro() {
		return nCodUsuRegistro;
	}

	public void setnCodUsuRegistro(int nCodUsuRegistro) {
		this.nCodUsuRegistro = nCodUsuRegistro;
	}

	public Date getdFecRegistro() {
		return dFecRegistro;
	}

	public void setdFecRegistro(Date dFecRegistro) {
		this.dFecRegistro = dFecRegistro;
	}

	public String getvHostRegistro() {
		return vHostRegistro;
	}

	public void setvHostRegistro(String vHostRegistro) {
		this.vHostRegistro = vHostRegistro;
	}

	public int getnCodUsuModificado() {
		return nCodUsuModificado;
	}

	public void setnCodUsuModificado(int nCodUsuModificado) {
		this.nCodUsuModificado = nCodUsuModificado;
	}

	public Date getDfecModificado() {
		return dfecModificado;
	}

	public void setDfecModificado(Date dfecModificado) {
		this.dfecModificado = dfecModificado;
	}

	public String getvHostModificado() {
		return vHostModificado;
	}

	public void setvHostModificado(String vHostModificado) {
		this.vHostModificado = vHostModificado;
	}
	
	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}	
		

	//toString

	@Override
	public String toString() {
		return "LeotbcLenguaMaterialTipoEje [nCodmatpej=" + nCodmatpej
				+ ", nCodlesmat=" + nCodlesmat + ", nTm2tpejer=" + nTm2tpejer
				+ ", nTm1sittip=" + nTm1sittip + ", nCodUsuRegistro="
				+ nCodUsuRegistro + ", dFecRegistro=" + dFecRegistro
				+ ", vHostRegistro=" + vHostRegistro + ", nCodUsuModificado="
				+ nCodUsuModificado + ", dfecModificado=" + dfecModificado
				+ ", vHostModificado=" + vHostModificado + "]";
	}

}