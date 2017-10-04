package com.service.school.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.configuracion.MascotaBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.entity.entity.configuracion.LeotbcMascota;
import com.service.school.core.entity.entity.general.LeotbcLengua;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.configuracion.MascotaDAO;
 
@Transactional
@Repository("mascotaDAO")
public class MascotaDAOImp implements MascotaDAO {
	@PersistenceContext
	private EntityManager em; 
	
	public MascotaBean getMascotaBean(Object object){
		return (MascotaBean)object;
	}

	private List<MascotaBean> deListaMascotaAListaMascotaBean(List<LeotbcMascota> lstMascota) {
		
		List<MascotaBean> lstMascotaBean = null;
		
		if (lstMascota != null && lstMascota.size() > 0) {
			
			lstMascotaBean = new ArrayList<MascotaBean>();
			
			for (int i = 0; i < lstMascota.size(); i++) { 
				LeotbcMascota entity = lstMascota.get(i);
				MascotaBean bean = deMascotaAMascotaBean(entity);
				
				lstMascotaBean.add(bean);
			}
		}
		
		return lstMascotaBean;
	}
	
		private MascotaBean deMascotaAMascotaBean(LeotbcMascota entity) {
		
		 MascotaBean bean = null;
		
		if (entity != null) {
			
			bean = new MascotaBean();
			
			bean.setCodigo(entity.getnCodmasco()); 
			bean.setNombre(entity.getvNommasco());
			bean.setDescripcion(entity.getvDesmasco());
			bean.getRegion().setCodigoRegistro(entity.getnCodregion());
			bean.setEstado(entity.getvFlgest());
//			bean.setValormoneda(entity.getiValmoneda());
			bean.setValormoneda(entity.getiValmoneda());
			bean.getRegion().setNombreCorto(entity.getV_nomcortoRegion()); 
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitmas());
			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion()); 
			bean.setDescripcion(entity.getvDesmasco());
			bean.setPredeterminado(entity.getnPremasco());
			bean.setImagenAlegre(entity.getvImagale());
			bean.setImagenTriste(entity.getvImagtri());
			bean.setImagenNormal(entity.getvImagneu());
			bean.setImagenExclamativa(entity.getvImagsor());
		}
		
		return  bean;
	}
	
		
		
	@Override
	public boolean insertar(MascotaBean mascotaBean) throws DAOException {   
		Object idMascota= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMascota.insertar");
			spq.setParameter("p_nommasco", mascotaBean.getNombre());
			spq.setParameter("p_desmasco", mascotaBean.getDescripcion());
			spq.setParameter("p_codregion", mascotaBean.getRegion().getCodigoRegistro());
			spq.setParameter("p_valmoneda", mascotaBean.getValormoneda());
			spq.setParameter("p_hostreg", ""); 
			spq.setParameter("p_premasco", mascotaBean.getPredeterminado());
			spq.setParameter("p_imagale", mascotaBean.getImagenAlegre());
			spq.setParameter("p_imagtri", mascotaBean.getImagenTriste());
			spq.setParameter("p_imagneu", mascotaBean.getImagenNormal());
			spq.setParameter("p_imagsor", mascotaBean.getImagenExclamativa());
			
			spq.execute();
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idMascota = spq.getOutputParameterValue(1);
			if (idMascota != null) {
				mascotaBean.setCodigo(Integer.valueOf(idMascota.toString()));
				if (mascotaBean.getCodigo()==0) {
					sw=false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}


//	@Override
//	public boolean actualizar(LenguaBean lenguaBean) throws DAOException {
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.actualizar");
//			spq.setParameter("p_nomlengua", lenguaBean.getNombre());
//			spq.setParameter("p_tm1sitlen", lenguaBean.getSituacion().getCodigoRegistro());
//			spq.setParameter("p_codusumod", 1);
//			spq.setParameter("p_hostmod", ""); 
//			
//			spq.execute();   
//			sw=true;
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw=false; 
//		}finally{
//			em.close();
//		}
//		return sw;
//	}


	@Override
	public boolean eliminar(MascotaBean mascotaBean) throws DAOException { 
		Object idMascota= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMascota.eliminar");
			spq.setParameter("p_codmasco", mascotaBean.getCodigo()); 
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", "");
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMascota = spq.getOutputParameterValue(1);
			if (idMascota != null) {
				mascotaBean.setRetorno(Integer.valueOf(idMascota.toString()));
				if (mascotaBean.getRetorno()==0) {
					sw=false;
				}
			}  
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}


//	@SuppressWarnings("unchecked")
//	@Override
//	public MascotaBean getBuscarPorObjecto(MascotaBean mascotaBean) throws DAOException {
//		MascotaBean oLenguaBean = null;
//		List<LeotbcMascota> lstLeotbcMascota = null;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.buscar_por_codigo");
//			
//			spq.setParameter("p_codlengua", mascotaBean.getCodigo()); 
//			
//		
//			if (spq.execute()) {
//				lstLeotbcLengua = spq.getResultList();			
//			}
//			
//			if (	lstLeotbcLengua != null
//				&&	lstLeotbcLengua.size() > 0) {
//				
//				oLenguaBean = deLenguaALenguaBean(lstLeotbcLengua.get(0));
//			} 
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DAOException(e);
//		}finally{
//			em.close();
//		}
//		return oLenguaBean;
//	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<MascotaBean> getBuscarPorFiltros(MascotaBean mascotabean) throws DAOException { 
		System.out.println("em " + em);
		List<LeotbcMascota> lstMascota = null;	
		List<MascotaBean> lstMascotaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_mascota.listar");
			spq.setParameter("p_nommasco", mascotabean.getNombre());  
			spq.setParameter("p_codregion", mascotabean.getRegion().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitmas", mascotabean.getSituacion().getCodigoRegistro()); 
			
			 
				lstMascota =  spq.getResultList(); 
			 
			if (lstMascota != null && lstMascota.size() > 0) {
				
				lstMascotaBean = deListaMascotaAListaMascotaBean(lstMascota);
			}
//			em.close();
			
		   
		return lstMascotaBean;
	}


	@Override
	public boolean existe(MascotaBean t) throws DAOException { 
		return false;
	}
	 

 



	@Override
	public boolean actualizar(MascotaBean mascotaBean) throws DAOException {
		Object idMascota= null;
		boolean sw=false;
		System.out.println("mascotaBean actualizar " + mascotaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMascota.actualizar");
			spq.setParameter("p_codmasco", mascotaBean.getCodigo()); 
			spq.setParameter("p_nommasco", mascotaBean.getNombre());
			spq.setParameter("p_desmasco", mascotaBean.getDescripcion());
			spq.setParameter("p_tm1sitmas", mascotaBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codregion", mascotaBean.getRegion().getCodigoRegistro());
			spq.setParameter("p_valmoneda", mascotaBean.getValormoneda());
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", ""); 
			spq.setParameter("p_premasco", mascotaBean.getPredeterminado());
			spq.setParameter("p_imagale", mascotaBean.getImagenAlegre());
			spq.setParameter("p_imagtri", mascotaBean.getImagenTriste());
			spq.setParameter("p_imagneu", mascotaBean.getImagenNormal());
			spq.setParameter("p_imagsor", mascotaBean.getImagenExclamativa());
			
			spq.execute();   
			sw=true;
			 
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMascota = spq.getOutputParameterValue(1);
			if (idMascota != null) {
				mascotaBean.setRetorno(Integer.valueOf(idMascota.toString()));
				if (mascotaBean.getRetorno()==0) {
					sw=false;
				}
			}  
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}



	 


	@SuppressWarnings("unchecked")
	@Override
	public MascotaBean getBuscarPorObjecto(MascotaBean mascotaBean) throws DAOException {
		MascotaBean oMascotaBean = null;
		List<LeotbcMascota> lstLeotbcMascota = null;
		System.out.println("mascotaBean getBuscarPorObjecto " + mascotaBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMascota.buscar_por_codigo");			
			spq.setParameter("p_codmasco", mascotaBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcMascota = spq.getResultList();			
			}
			
			if (	lstLeotbcMascota != null
				&&	lstLeotbcMascota.size() > 0) {
				
				oMascotaBean = deMascotaAMascotaBean(lstLeotbcMascota.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMascotaBean;
	}


}
