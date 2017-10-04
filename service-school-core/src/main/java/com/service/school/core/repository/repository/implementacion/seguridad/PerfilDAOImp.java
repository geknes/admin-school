package com.service.school.core.repository.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.seguridad.PerfilBean;
import com.service.school.core.entity.entity.general.LeotbcLengua;
import com.service.school.core.entity.entity.seguridad.LeotbcPerfil;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.seguridad.PerfilDAO;

@Transactional
@Repository("perfilDAO")
public class PerfilDAOImp implements PerfilDAO{

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.insertar");
	       // spq.setParameter("p_codperfil", t.getnCodperfil());
	        spq.setParameter("p_nomperfil", t.getNombrePerfil());
	        spq.setParameter("p_tm1sitprf", t.getSituacion()!=null? t.getSituacion().getCodigoRegistro() : null);
	        spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
	        spq.setParameter("p_hostreg", t.getIpCreacion());
	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				t.setCodigo(Integer.valueOf(id.toString()));
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.actualizar");
	        spq.setParameter("p_codperfil", t.getCodigoPerfil());
	        spq.setParameter("p_nomperfil", t.getNombrePerfil());
	        spq.setParameter("p_tm1sitprf", t.getSituacion()!=null? t.getSituacion().getCodigoRegistro() : null);
	        spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
	        spq.setParameter("p_hostmod", t.getIpModificacion());
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.eliminar");
	        spq.setParameter("p_codperfil", t.getCodigoPerfil());
	        spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
	        spq.setParameter("p_hostmod", t.getIpModificacion());
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public PerfilBean getBuscarPorObjecto(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PerfilBean> getBuscarPorFiltros(PerfilBean t)
			throws DAOException {
		List<PerfilBean> lstBean = new ArrayList<PerfilBean>();
		List<LeotbcPerfil> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.listar");
			
			spq.setParameter("p_nomperfil", t.getNombrePerfil());
	        spq.setParameter("p_codperfil", t.getCodigoPerfil());
	        spq.setParameter("p_tm1sitprf", t.getSituacion()!=null? t.getSituacion().getCodigoRegistro() : null); 
			
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbcPerfil leotbcPerfil : lstEntity) {
					lstBean.add(dePerfilToPerfilBean(leotbcPerfil));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstBean;
	}

	@Override
	public boolean existe(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private PerfilBean dePerfilToPerfilBean(LeotbcPerfil entity){
		PerfilBean bean = new PerfilBean();
		if(entity != null){
			bean.setCodigoPerfil(entity.getnCodperfil());
			bean.setEstado(entity.getvFlgest());
			if(entity.getnTm1sitprf()!=null){
				bean.setSituacion(new MaestraBean());
				bean.getSituacion().setCodigoRegistro(entity.getnTm1sitprf().intValue());
				bean.getSituacion().setNombreCorto(entity.getNombreSituacion());
			}
			bean.setNombrePerfil(entity.getvNomperfil());
			
		}
		return bean;
	}

}
