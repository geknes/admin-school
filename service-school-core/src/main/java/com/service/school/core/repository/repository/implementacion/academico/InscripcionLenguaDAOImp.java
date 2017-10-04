package com.service.school.core.repository.repository.implementacion.academico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.entity.entity.academico.LeomvcMatricula;
import com.service.school.core.entity.entity.academico.LeomvdMatriculaAlumno;
import com.service.school.core.entity.entity.academico.LeotbcInscripcion;
import com.service.school.core.entity.entity.academico.LeotbdInsclengua;
import com.service.school.core.entity.entity.academico.LeotbdUsuMatricula;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.academico.InscripcionLenguaDAO;
import com.service.school.core.repository.repository.interfaces.academico.MatriculaAlumnoDAO;

@Transactional
@Repository("inscripcionLenguaDAO")
public class InscripcionLenguaDAOImp implements InscripcionLenguaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
		Object idInstitucion= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.insertar");
			spq.setParameter("p_codinscr", inscripcionLenguaBean.getInscripcionBean().getCodigo());
			spq.setParameter("p_codlengua", inscripcionLenguaBean.getLenguainscr().getCodigo());
			spq.setParameter("p_numcupos", inscripcionLenguaBean.getNumeroCuposInsc());			
			
			spq.setParameter("p_codusureg", inscripcionLenguaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", inscripcionLenguaBean.getIpCreacion()); 
			spq.setParameter("p_tm2nivel", inscripcionLenguaBean.getNivel().getCodigoRegistro());
			
			spq.execute();
			
			idInstitucion = spq.getOutputParameterValue(1);
			if (idInstitucion != null) {
				inscripcionLenguaBean.setCodigo(Integer.valueOf(idInstitucion.toString()));
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
	public boolean actualizar(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
		boolean sw=false;
		System.out.println("lenguaBean actualizar " + inscripcionLenguaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.actualizar");
			spq.setParameter("p_codinsclen", inscripcionLenguaBean.getCodigo());
			spq.setParameter("p_codlengua", inscripcionLenguaBean.getLenguainscr().getCodigo());
			spq.setParameter("p_numcupos", inscripcionLenguaBean.getNumeroCuposInsc());
			
			spq.setParameter("p_codusumod", inscripcionLenguaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", inscripcionLenguaBean.getIpModificacion()); 
			spq.setParameter("p_tm2nivel", inscripcionLenguaBean.getNivel().getCodigoRegistro());
			
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
	public boolean eliminar(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.eliminar");
			spq.setParameter("p_codinsclen", inscripcionLenguaBean.getCodigo()); 
			spq.setParameter("p_codusumod", inscripcionLenguaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", inscripcionLenguaBean.getIpModificacion());
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
	public InscripcionLenguaBean getBuscarPorObjecto(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
		InscripcionLenguaBean oInscripcionLenguaBean = null;
		List<LeotbdInsclengua> lstLeotbcInscripcion = null;
		System.out.println("InscripcionLenguaBean getBuscarPorObjecto " + inscripcionLenguaBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.buscar_por_codigo");			
			spq.setParameter("p_codinsclen", inscripcionLenguaBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcInscripcion = spq.getResultList();			
			}
			
			if (	lstLeotbcInscripcion != null
				&&	lstLeotbcInscripcion.size() > 0) {
				System.out.println("lstLeotbcInscripcion.size() " + lstLeotbcInscripcion.size());
				oInscripcionLenguaBean = deInscripcionAInscripcionBean(lstLeotbcInscripcion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oInscripcionLenguaBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InscripcionLenguaBean> getBuscarPorFiltros(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
		List<LeotbdInsclengua> lstInscripcion= null;	
		List<InscripcionLenguaBean> lstInscripcionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.buscar_por_codigoInscripcion");
			spq.setParameter("p_codinscr", inscripcionLenguaBean.getInscripcionBean().getCodigo());  

			if (spq.execute()) {
				lstInscripcion =  spq.getResultList(); 
			} 
			if (lstInscripcion != null && lstInscripcion.size() > 0) {
				System.out.println("lstInscripcion.size() getBuscarPorFiltros "+ lstInscripcion.size());
				lstInscripcionBean = deListaInscripcionAListaInscripcionBean(lstInscripcion);
			}
			//em.close();
		   
		return lstInscripcionBean;
	}

	@Override
	public boolean existe(InscripcionLenguaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
private List<InscripcionLenguaBean> deListaInscripcionAListaInscripcionBean(List<LeotbdInsclengua> lstInscripcion) {
		
		List<InscripcionLenguaBean> lstInscripcionBean = null;
		
		if (lstInscripcion != null && lstInscripcion.size() > 0) {
			
			lstInscripcionBean = new ArrayList<InscripcionLenguaBean>();
			
			for (int i = 0; i < lstInscripcion.size(); i++) { 
				LeotbdInsclengua entity = lstInscripcion.get(i);
				InscripcionLenguaBean bean = deInscripcionAInscripcionBean(entity);
				
				lstInscripcionBean.add(bean);
			}
		}
		
		return lstInscripcionBean;
	}
	
	private InscripcionLenguaBean deInscripcionAInscripcionBean(LeotbdInsclengua entity) {
		
		InscripcionLenguaBean bean = null;
		
		if (entity != null) {
			
			bean = new InscripcionLenguaBean();
			
			bean.setCodigo(entity.getNCodinsclen()); 
			bean.setNumeroCuposInsc(entity.getVNumcupos()); 
			bean.setNumeroCuposDisp(entity.getvNumcuposdisp());
			System.out.println("entity.getnCodisnti() " + entity.getnCodisnti());
			bean.getInstitucion().setCodigo(entity.getnCodisnti());
			bean.getInstitucion().setNombreInstitucion(entity.getvNominsti());
			bean.getLenguainscr().setCodigo(entity.getNCodlengua());
			bean.getLenguainscr().setNombre(entity.getvNomlengua());
			bean.getSituacion().setCodigoRegistro((int)entity.getNTm1sitinsclen());
			bean.getInscripcionBean().setCodigo(entity.getNCodinscr());
			bean.getInscripcionBean().getPeriodo().setCodigoRegistro(entity.getvPeriodo()!= null ? Integer.valueOf(entity.getvPeriodo()): 0);
			bean.getInscripcionBean().getCiclo().setCodigoRegistro(entity.getnTm2ciclo());
			bean.getInscripcionBean().getCiclo().setNombreCorto(entity.getvNomcortoCiclo());
			bean.getNivel().setCodigoRegistro(entity.getnTm2nivel());
			bean.getNivel().setNombreCorto(entity.getvNomcortonivel());
		
			
		}
		
		return bean;
	}

	@Override
	public List<InscripcionLenguaBean> listarInscripcionLengua(InscripcionLenguaBean inscripcionLenguaBean)
			throws DAOException {
		List<LeotbdInsclengua> lstInscripcion= null;	
		List<InscripcionLenguaBean> lstInscripcionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.listadoDetalle");
			
			if (spq.execute()) {
				lstInscripcion =  spq.getResultList(); 
			} 
			if (lstInscripcion != null && lstInscripcion.size() > 0) {
				System.out.println("lstInscripcion.size() listarInscripcionLengua "+ lstInscripcion.size());
				lstInscripcionBean = deListaInscripcionAListaInscripcionBean(lstInscripcion);
			}
			//em.close();
		   
		return lstInscripcionBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
		InscripcionLenguaBean oInscripcionLenguaBean = null;
		List<LeotbdInsclengua> lstLeotbcInscripcion = null;
		System.out.println("InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula " + inscripcionLenguaBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.matriculBuscarXCodigoDetalle");			
			spq.setParameter("p_codinsclen", inscripcionLenguaBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcInscripcion = spq.getResultList();			
			}
			
			if (	lstLeotbcInscripcion != null	&&	lstLeotbcInscripcion.size() > 0) {
				System.out.println("lstLeotbcInscripcion.size() " + lstLeotbcInscripcion.size());
				oInscripcionLenguaBean = deInscripcionAInscripcionBean(lstLeotbcInscripcion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oInscripcionLenguaBean;
	}

//	@Override
//	public boolean actualizarNumCuposDisp(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException {
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_insclengua.actualizarNumCuposDisp");
//			spq.setParameter("p_codinsclen", inscripcionLenguaBean.getCodigo()); 
//			spq.setParameter("p_codusumod", inscripcionLenguaBean.getCodigoUsuarioModificacion());
//			spq.setParameter("p_hostmod", inscripcionLenguaBean.getIpModificacion());
//			spq.setParameter("p_numcuposdisp",	inscripcionLenguaBean.getNumeroCuposDisp());
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

}
