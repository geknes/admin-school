package com.service.school.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.school.core.bean.bean.generico.OrdenarParrafoBean;
import com.service.school.core.entity.entity.general.LeotbcOrdenarParrafo;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.repository.repository.interfaces.general.OrdenarParrafoDAO;
@Transactional (readOnly = true)
@Repository("ordenarParrafoDAO")
public class OrdenarParrafoDAOImpl implements OrdenarParrafoDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(OrdenarParrafoBean ordenarParrafoBean) throws DAOException {
		
		System.out.println("---- Insertar OrdenarParrado ----");
		System.out.println("ordenarParrafoBean DAO "+ordenarParrafoBean);
		Object codigoOrdenarParrafo= null; 
		boolean sw =  false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafo.insertar");
			
			spq.setParameter("p_codmatpej", ordenarParrafoBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", ordenarParrafoBean.getTitulo());
			spq.setParameter("p_parrafo", ordenarParrafoBean.getParrafo());
			spq.setParameter("p_numorden", ordenarParrafoBean.getNumeroOrden());
			spq.setParameter("p_codusureg", 1);
			spq.setParameter("p_hostreg", "");
			spq.setParameter("p_codordenarparrafocab", ordenarParrafoBean.getOrdenarParrafoCabeceraBean().getCodigo());
			
			spq.execute();
			
			codigoOrdenarParrafo = spq.getOutputParameterValue(1);
			
			if (codigoOrdenarParrafo != null ) {
				ordenarParrafoBean.setCodigo(Long.valueOf(codigoOrdenarParrafo.toString()));
				System.out.println("ordenarParrafoBean.getCodigo() ::" +ordenarParrafoBean.getCodigo());
				sw =  true;
			}else{
				System.out.println("codigo ordenarParrafo llego  null");
				sw =  false;
			}
				
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public boolean actualizar(OrdenarParrafoBean ordenarParrafoBean) throws DAOException {
		System.out.println("---- Actulizar OrdenarParrado ----");
		System.out.println("ordenarParrafoBean DAO "+ordenarParrafoBean);
		
		boolean sw =  false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafo.actulizar");
			
			spq.setParameter("p_codordenarparrafo", ordenarParrafoBean.getCodigo());
			spq.setParameter("p_codmatpej", ordenarParrafoBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", ordenarParrafoBean.getTitulo());
			spq.setParameter("p_parrafo", ordenarParrafoBean.getParrafo());
			spq.setParameter("p_numorden", ordenarParrafoBean.getNumeroOrden());
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", "");
			spq.setParameter("p_codordenarparrafocab", ordenarParrafoBean.getOrdenarParrafoCabeceraBean().getCodigo());
			
			spq.execute();
			
			sw = true;
			
				
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public boolean eliminar(OrdenarParrafoBean ordenarParrafoBean) throws DAOException {
		System.out.println("---- Eliminar OrdenarParrado ----");
		System.out.println("ordenarParrafoBean DAO "+ordenarParrafoBean);
		
		boolean sw =  false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafo.eliminar");
			
			spq.setParameter("p_codordenarparrafo", ordenarParrafoBean.getCodigo());
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", "");
			
			spq.execute();
			
			sw = true;
			
				
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public OrdenarParrafoBean getBuscarPorObjecto(OrdenarParrafoBean ordenarParrafoBean)
			throws DAOException {
		System.out.println("----Ingreso a  listar buscarPorObjecto ----");
		OrdenarParrafoBean ordenarParrafo = null;
		List<LeotbcOrdenarParrafo> lstLeotbcOrdenarParrafos = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafo.buscarPorCodigo");
			spq.setParameter("p_codordenarparrafo", ordenarParrafoBean.getCodigo());
			
			if (spq.execute()) {
				lstLeotbcOrdenarParrafos = spq.getResultList();
				
			}
			if (lstLeotbcOrdenarParrafos != null && lstLeotbcOrdenarParrafos.size() > 0) {
				ordenarParrafo = deOrdenarParrafoAOrdenarParrafoBean(lstLeotbcOrdenarParrafos.get(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return ordenarParrafo;
	}

	@Override
	public List<OrdenarParrafoBean> getBuscarPorFiltros(OrdenarParrafoBean ordenarParrafoBean) throws DAOException {
		System.out.println("---- Listar por Filtros OrdenarParrafos ----");
		
		List<LeotbcOrdenarParrafo> lstLeotbcOrdenarParrafos = null;
		List<OrdenarParrafoBean> lstOrdenarParrafoBeans = null;

			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafo.buscarPorFiltros");
			spq.setParameter("p_codordenarparrafocab", ordenarParrafoBean.getOrdenarParrafoCabeceraBean().getCodigo());
			
			if (spq.execute()) {				
				lstLeotbcOrdenarParrafos = spq.getResultList();
			}
			if (lstLeotbcOrdenarParrafos != null && lstLeotbcOrdenarParrafos.size() > 0) {
				
				lstOrdenarParrafoBeans = deListaOrdenarParrafoAListaOrdenarParrafoBean(lstLeotbcOrdenarParrafos);
				
			}
		return lstOrdenarParrafoBeans;
	}
	
	private List<OrdenarParrafoBean> deListaOrdenarParrafoAListaOrdenarParrafoBean(List<LeotbcOrdenarParrafo> lstLeotbcOrdenarParrafos) {
		
		List<OrdenarParrafoBean> lstOrdenarParrafoBean = null;
		
		if (lstLeotbcOrdenarParrafos != null && lstLeotbcOrdenarParrafos.size() > 0) {
			
			lstOrdenarParrafoBean = new ArrayList<OrdenarParrafoBean>();
			
			for (int i = 0; i < lstLeotbcOrdenarParrafos.size(); i++) { 
				LeotbcOrdenarParrafo entity = lstLeotbcOrdenarParrafos.get(i);
				OrdenarParrafoBean bean = deOrdenarParrafoAOrdenarParrafoBean(entity);
				
				lstOrdenarParrafoBean.add(bean);
			}
		}
		
		return lstOrdenarParrafoBean;
	}
	
	private OrdenarParrafoBean deOrdenarParrafoAOrdenarParrafoBean(LeotbcOrdenarParrafo entity) {
		
		OrdenarParrafoBean bean = null;
		
		if (entity != null) {
			
			bean = new OrdenarParrafoBean();
			bean.setCodigo(entity.getnCodordenarparrafo());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setParrafo(entity.getvParrafo());
			bean.setNumeroOrden(entity.getnNumorden());
			bean.getOrdenarParrafoCabeceraBean().setCodigo(entity.getnCodordenarparrafocab());
			
		}
		
		return bean;
	}

	@Override
	public boolean existe(OrdenarParrafoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
