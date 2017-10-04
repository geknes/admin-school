package com.service.school.core.repository.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.InstitucionOperadorBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.entity.entity.general.LeotbdInstOperador;
import com.service.school.core.entity.entity.seguridad.LeotbcUsuario;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.seguridad.UsuarioDAO;

@Transactional
@Repository("usuarioDAO")
public class UsuarioDAOImp implements UsuarioDAO {

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(UsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.insertar");
	       // spq.setParameter("p_codusuari", t.getp_codusuari());
            spq.setParameter("p_nomusuari", t.getNombreUsuario());
            spq.setParameter("p_passusuar", t.getPasswordUsuario());
            spq.setParameter("p_codperso", t.getPersona()!=null? t.getPersona().getCodigo():null);
            spq.setParameter("p_tm1situsu", t.getSituacion()!=null?t.getSituacion().getCodigoRegistro():null);
            spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
            spq.setParameter("p_hostreg", t.getIpCreacion());
            spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
            spq.setParameter("p_fecmod", null);
            spq.setParameter("p_hostmod", t.getIpModificacion());
	        
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
	public boolean actualizar(UsuarioBean t) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.actualizar");
			spq.setParameter("p_codusuari", t.getCodigoUsuario());
			spq.setParameter("p_nomusuari", t.getNombreUsuario());
            spq.setParameter("p_passusuar", t.getPasswordUsuario());
            spq.setParameter("p_tm1situsu", t.getSituacion()!=null?t.getSituacion().getCodigoRegistro():null);
            spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
            spq.setParameter("p_hostreg", t.getIpCreacion());
            spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
            spq.setParameter("p_fecmod", null);
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
	public boolean eliminar(UsuarioBean t) throws DAOException {
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.actualizar");
			spq.setParameter("p_codusuari", t.getCodigoUsuario());
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
	public UsuarioBean getBuscarPorObjecto(UsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioBean> getBuscarPorFiltros(UsuarioBean t)
			throws DAOException {
		List<UsuarioBean> lstBean = new ArrayList<UsuarioBean>();
		List<LeotbcUsuario> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.listar");
			
			spq.setParameter("p_codusuari", t.getCodigoUsuario());
			spq.setParameter("p_nomusuari", t.getNombreUsuario());
			spq.setParameter("p_codperso", t.getPersona()!=null? t.getPersona().getCodigo():null);
			spq.setParameter("p_codperfil", t.getCodigoPerfil());
            spq.setParameter("p_tm1situsu", t.getSituacion()!=null?t.getSituacion().getCodigoRegistro():null);
	        
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbcUsuario leotbcUsuario : lstEntity) {
					lstBean.add(deUsuarioToUsuarioBean(leotbcUsuario));
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
	public boolean existe(UsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException {
		UsuarioBean objUsuarioBean = null;
		List<LeotbcUsuario> lstLeotbcUsuario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.autenticar");
			spq.setParameter("p_nomusuari", prmUsuarioBean.getNombreUsuario());
			spq.setParameter("p_passusuar", prmUsuarioBean.getPasswordUsuario());
		
			if (spq.execute()) {
				lstLeotbcUsuario = spq.getResultList();			
			}
			
			if (	lstLeotbcUsuario != null
				&&	lstLeotbcUsuario.size() > 0) {
				
				objUsuarioBean = deUsuarioToUsuarioBean(lstLeotbcUsuario.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return objUsuarioBean;
	}
	
	private UsuarioBean deUsuarioToUsuarioBean(LeotbcUsuario entity){
		UsuarioBean bean = new UsuarioBean();
		if(entity!=null){
			bean.setCodigoPerfil(entity.getNCodperfil());
			bean.setCodigoUsuario(entity.getNCodusuari());
			bean.setEstado(entity.getVFlgest());
			bean.setNombreUsuario(entity.getVNomusuari());
			bean.setPasswordUsuario(entity.getVPassusuar());
			bean.setPersona(new PersonaBean());
			bean.getPersona().setCodigo(entity.getNCodperso()!=null ? entity.getNCodperso() : 0);
			bean.getPersona().setNombreCompleto(entity.getvNomperson());
			bean.getPersona().setNumeroDocumento(entity.getvNumdocum());
			bean.getPersona().setTipoDocumento(new MaestraBean());
			bean.getPersona().getTipoDocumento().setCodigoRegistro(entity.getnTm1tpdope()!=null?entity.getnTm1tpdope().intValue():0);
			if(entity.getNTm1situsu()!=null && entity.getNTm1situsu()>0){
				bean.setSituacion(new MaestraBean());
				bean.getSituacion().setCodigoRegistro(entity.getNTm1situsu().intValue());
				bean.getSituacion().setNombreCorto(entity.getvNomsitusu());
			}
			bean.setNombrePerfiles(entity.getvNomperfil());
			bean.setFlgRestPass(entity.getvFlgrestpas());
		}
		return bean;
	}

	@Override
	public Integer cambiarPassword(UsuarioBean t)
			throws DAOException {
		Object obj;
		Integer result = -1;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.resetpass");
			spq.setParameter("p_codusuari", t.getCodigoUsuario());
            spq.setParameter("p_passusuar", t.getPasswordUsuario());
            spq.setParameter("p_newpass", t.getNewPassword());
            spq.setParameter("p_flgrestpas", t.getFlgRestPass());
            spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
            spq.setParameter("p_hostmod", t.getIpModificacion());
	        
	        spq.execute();
	        obj = spq.getOutputParameterValue(1);
	        if(obj!=null){
	        	result = Integer.valueOf(obj.toString());
	        }
				
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}finally{
			em.close();
		}
		return result;
	}

}