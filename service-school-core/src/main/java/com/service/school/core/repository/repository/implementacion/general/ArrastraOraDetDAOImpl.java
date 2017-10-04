package com.service.school.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.ArrastraOraDetBean;
import com.service.school.core.bean.bean.generico.ArrastraOraciBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.MaterialTipoEjercicioBean;
import com.service.school.core.bean.bean.generico.OracionAlterBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.entity.entity.general.LeotbcArrastraOraci;
import com.service.school.core.entity.entity.general.LeotbcMaterialTipoEje;
import com.service.school.core.entity.entity.general.LeotbcPregunta;
import com.service.school.core.entity.entity.general.LeotbdArrastraOraDet;
import com.service.school.core.entity.entity.general.LeotbdOracionAlter;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.ArrastraOraDetDAO;
import com.service.school.core.repository.repository.interfaces.general.OracionAlterDAO;;

@Transactional
@Repository("arrastraOraDetDAO")
public class ArrastraOraDetDAOImpl implements ArrastraOraDetDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(ArrastraOraDetBean Bean) throws DAOException 
	{
		Object idArrasDet = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdArrastrarDet.insertar");
			spq.setParameter("p_codarrastraora", Bean.getArrastraOraciBean().getCodigo());
			spq.setParameter("p_numorden", Bean.getOrden());
			spq.setParameter("p_oraciondet", Bean.getDescripcion()); 
			spq.setParameter("p_codusureg", 1); 
			spq.setParameter("p_hostreg", ""); 
			
			spq.execute();
			
			idArrasDet = spq.getOutputParameterValue(1);
			if(idArrasDet != null)
			{
				Bean.setCodigo(Integer.valueOf(idArrasDet.toString()));
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
	public boolean actualizar(ArrastraOraDetBean Bean) throws DAOException {
		boolean sw = false;
		System.out.println("arrastrar det actualizar " + Bean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdArrastrarDet.actualizar");
			spq.setParameter("p_codoraxArrastrar", Bean.getCodigo());
			spq.setParameter("p_numorden", Bean.getOrden());
			spq.setParameter("p_oraciondet", Bean.getDescripcion()); 
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", "");

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArrastraOraDetBean  Bean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdArrastrarDet.eliminar");
			spq.setParameter("p_codoraxArrastrar", Bean.getCodigo());
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", "192.168.1.137");
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}
	 
	 
	
	@Override
	public List<ArrastraOraDetBean> getBuscarPorOracion(
			ArrastraOraDetBean  Bean) throws DAOException {
		List<LeotbdArrastraOraDet> lstLeotbc = null;
		List<ArrastraOraDetBean> lstBean = null;
		
		System.out.println("---- getBuscarPorFiltros ---");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdArrastrarDet.buscar_x_Oracion");
		
		spq.setParameter("p_codarrastraora", 	Bean.getArrastraOraciBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		System.out.println("DAO LISTADO ES " + lstBean + "");
		return lstBean;
		
	}
	
	 
 
	@Override
	public ArrastraOraDetBean getBuscarPorObjecto(ArrastraOraDetBean Bean) throws DAOException {
		ArrastraOraDetBean 	bean = null;
		List<LeotbdArrastraOraDet> 	lstOracion 	= null;
		System.out.println("premioBean getBuscarPorObjecto " + Bean.getCodigo() );
		try{
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdArrastrarDet.buscar_x_codigo");
		spq.setParameter("p_codoraxarrastrar",  Bean.getCodigo());
		
		if (spq.execute()) 
		{
			lstOracion =  spq.getResultList(); 
		} 
		if (lstOracion != null && lstOracion.size() > 0) 
		{
			bean = deAlternativaAAlternativaBean(lstOracion.get(0));
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		} 
		return bean;

	}
	
	 
	
	private List<ArrastraOraDetBean> deListaAlternativaAListaAlternativaBean(List<LeotbdArrastraOraDet> lstAlternativa) {
		
		List<ArrastraOraDetBean> lstAlternativaBean = null; 
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			lstAlternativaBean = new ArrayList<ArrastraOraDetBean>(); 
			for (int i = 0; i < lstAlternativa.size(); i++) 
			{ 
				LeotbdArrastraOraDet entity = lstAlternativa.get(i);
				ArrastraOraDetBean bean = deAlternativaAAlternativaBean(entity);
				
				lstAlternativaBean.add(bean);
			}
		}
		return lstAlternativaBean;
	}
	
	private ArrastraOraDetBean deAlternativaAAlternativaBean(LeotbdArrastraOraDet entity) 
	{
		ArrastraOraDetBean bean = null;
		
		if (entity != null) 
		{
			bean = new ArrastraOraDetBean(); 
			bean.setArrastraOraciBean(new  ArrastraOraciBean()); 
			
			bean.setCodigo(entity.getnCodoraxArrastrar());
			bean.setEstado(entity.getvFlgest());
			bean.setOrden(entity.getvNumorden());
			bean.setDescripcion(entity.getvOraciondet()); 
			bean.getArrastraOraciBean().setCodigo(entity.getnCodarrastraora());
		 
			
		}
		return bean;
	}

 

	@Override
	public List<ArrastraOraDetBean> getBuscarPorFiltros(ArrastraOraDetBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(ArrastraOraDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	} 
  

}
