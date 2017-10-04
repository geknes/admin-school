package com.service.school.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.configuracion.MascotaBean;
import com.service.school.core.bean.bean.configuracion.PremioBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.MascotaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service; 
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value ="tmaestraController")
public class TmaestraController extends BaseController { 
	
	private MaestraBean maestraBean;
	private List<MaestraBean> 	lstMaestraBean;
	private List<MaestraBean>	lstGeneral;
 
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private Maestra2Service 	maestra2Service;
	 
	@PostConstruct
	public void init(){
		this.setMaestraBean(new MaestraBean());
		this.setLstMaestraBean(new ArrayList<MaestraBean>()); 
	}  
	public TmaestraController (){
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("maestraBean") MaestraBean maestraBean)throws Exception {
		
		MaestraBean prmMaestraBean = new MaestraBean(); 
		prmMaestraBean.setNombreCorto(""); 
		prmMaestraBean.setCodigoTabla("");   
//		return this.getLista(prmMaestraBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-maestra", "command",maestraBean);
	
		mav.addObject("lstMaestraBean", new ArrayList<MaestraBean>());
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("maestraBean") MaestraBean maestraBean)
			throws Exception {
		System.out.println("buscar maestraBean " + maestraBean);
		return this.getLista(maestraBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar1(@ModelAttribute("maestraBean") MaestraBean maestraBean)
			throws Exception {
		System.out.println("buscar maestraBean " + maestraBean);
		return doListado(maestraBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() { 
		MaestraBean  prmMaestraBean = new MaestraBean ();
		prmMaestraBean.setCodigoRegistro(0);
		ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command",prmMaestraBean);
		mav.addObject("maestraBean",prmMaestraBean);
		this.cargarCombos(mav);
		return mav;
	}  
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("p_codtabla") String p_codtabla,@RequestParam("p_codregis") Integer p_codregis,HttpServletRequest request){
		boolean sw=false;
		maestraBean  = new MaestraBean();
		maestraBean.setCodigoTabla(p_codtabla); 
		maestraBean.setCodigoRegistro(p_codregis);
	//	this.setAuditoria(tmaestraBean, request, false);
		try { 
				sw =  (this.getMaestra1Service().eliminar(maestraBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		maestraBean.setCodigoRegistro(0);
		maestraBean.setId(0);
		maestraBean.setCodigoTabla("");
		this.setValoresPredeterminados(maestraBean);
		ModelAndView mav = this.getLista(maestraBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("p_codtabla") String p_codtabla,@RequestParam("p_codregis") Integer p_codregis){
		 
		MaestraBean prmMaestraBean = new MaestraBean();
		prmMaestraBean.setCodigoTabla(p_codtabla); 
		prmMaestraBean.setCodigoRegistro(p_codregis); 
		prmMaestraBean.setId(0);   
		try {
			maestraBean = this.getMaestra1Service().getBuscarPorTablaYRegistro(prmMaestraBean);
//			maestraBean.getEstado()!='0';
		} catch (ServiceException e) { 
			e.printStackTrace();
		} 
		
		
//		ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", maestraBean); 
//		this.cargarCombos(mav);	
//		mav.addObject("maestraBean", maestraBean);  
//		return mav;
		if (maestraBean != null ) {
			if ((maestraBean.getEstado() != null) && (maestraBean.getEditable()!= null )) {  
			if (maestraBean.getEstado().equals("1") && (maestraBean.getEditable().equals("1"))){
				 
				ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", maestraBean);  
				this.cargarCombos(mav);
				mav.addObject("maestraBean", maestraBean);
				return mav;
		}else{
			ModelAndView mav = this.getLista(new MaestraBean());
			mav.addObject("swMensaje","0");
			mav.addObject("maestraBean",new MaestraBean());  
			return mav;
			
		} }
			else{
				ModelAndView mav = this.getLista(new MaestraBean());
				mav.addObject("swMensaje","0");
				mav.addObject("maestraBean",new MaestraBean());  
				return mav;
		} 
		
		} 
		else { 
			ModelAndView mav = this.getLista(new MaestraBean());
			mav.addObject("swMensaje","0");
			mav.addObject("maestraBean",new MaestraBean());  
			return mav;
		} 
	} 
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("maestraBean") MaestraBean maestraBean) {
		
		 System.out.println(" Bean Grabar"+maestraBean);
		System.out.println(" Bean Grabar"+maestraBean.getCodigoRegistro());
		System.out.println(" Bean Grabar"+maestraBean.getCodigoTabla());
		boolean sw = true;
		try {
			if (maestraBean.getCodigoRegistro()==0) {
				sw =  (this.getMaestra1Service().insertar(maestraBean)); 
			
			} else {
				sw = (this.getMaestra1Service().actualizar(maestraBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		if (sw) {
			maestraBean = new MaestraBean() ; 
			ModelAndView mav = this.getLista(maestraBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command",maestraBean);
			mav.addObject("swMensaje",sw?"1":"0");
			mav.addObject("maestraBean",maestraBean);
			this.cargarCombos(mav);
			return mav;
		}

	} 
		private ModelAndView getLista(MaestraBean maestraBean) {
				
		List<MaestraBean> lstMaestraBean = new ArrayList<MaestraBean>();
		try { 
			lstMaestraBean = (List<MaestraBean>) this.getMaestra1Service().getBuscarPorFiltros(maestraBean); 
			System.out.println("tamaño lst mascota bean "+lstMaestraBean.size());
		} catch (Exception e) {
			System.out.println("getLista falló" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-maestra", "command",maestraBean);
		System.out.println("lstMaestraBean "+lstMaestraBean);
		mav.addObject("lstMaestraBean", lstMaestraBean);
		this.cargarCombos(mav);
		return mav;
	}
	

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}  
 
	
private void cargarCombos(ModelAndView mav){
		
		if (lstGeneral==null) {
			try {
				lstGeneral = maestra1Service.listarComboGeneral("7");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		} 
		mav.addObject("lstGeneral",lstGeneral);
	}



	public MaestraBean getMaestraBean() {
		return maestraBean;
	}
	
	public void setMaestraBean(MaestraBean maestraBean) {
		this.maestraBean = maestraBean;
	}




	public List<MaestraBean> getLstMaestraBean() {
		return lstMaestraBean;
	}




	public void setLstMaestraBean(List<MaestraBean> lstMaestraBean) {
		this.lstMaestraBean = lstMaestraBean;
	}




	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}




	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
	}




	public List<MaestraBean> getLstGeneral() {
		return lstGeneral;
	}




	public void setLstGeneral(List<MaestraBean> lstGeneral) {
		this.lstGeneral = lstGeneral;
	}
	public void setValoresPredeterminados(MaestraBean maestraBean){
		maestraBean.setCodigoTabla(""); 
		maestraBean.setCodigoRegistro(0);
	    }  

}
