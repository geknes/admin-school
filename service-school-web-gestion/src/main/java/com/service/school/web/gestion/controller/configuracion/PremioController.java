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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.configuracion.PremioBean; 
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.PremioService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.ResourceUtil;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "premioController")
public class PremioController extends BaseController {

	private PremioBean 		premioBean;
	private List<PremioBean> 	lstPremioBean;
	
	private List<MaestraBean>	lstSituacion;
	private List<MaestraBean>	lstRegion;
	private List<MaestraBean>	lstTipo;

	@Autowired
	private PremioService 		premioService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	private String				tmpUrlImagen;
	
	@PostConstruct
	public void init(){
		this.setPremioBean(new PremioBean());
		this.setLstPremioBean(new ArrayList<PremioBean>());
	//	this.setLstSituacion(new ArrayList<MaestraBean>());
	} 
	
	public PremioController (){  
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("premioBean") PremioBean premioBean)throws Exception {
		
		PremioBean prmPremioBean = new PremioBean(); 
		prmPremioBean.setNombre(""); 
		prmPremioBean.setRegion(new MaestraBean());
		prmPremioBean.getRegion().setCodigoRegistro(0);
		prmPremioBean.setSituacion(new MaestraBean());
		prmPremioBean.getSituacion().setCodigoRegistro(0);
		prmPremioBean.setTipo(new MaestraBean());
		prmPremioBean.getTipo().setCodigoRegistro(0);
		
//		return this.getLista(prmPremioBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-premio", "command",premioBean);
	
//		mav.addObject("lstPremioBean", new ArrayList<PremioBeans>());
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("premioBean") PremioBean premioBean)
			throws Exception {
		System.out.println("buscar premio " + premioBean);
		return this.getLista(premioBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar1(@ModelAttribute("premioBean") PremioBean premioBean)
			throws Exception {
		System.out.println("buscar premio " + premioBean);
		return doListado(premioBean);
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		premioBean= new PremioBean();
		premioBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getPremioService().eliminar(premioBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		premioBean.setCodigo(0);
		this.setValoresPredeterminados(premioBean);
		ModelAndView mav = this.getLista(premioBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("configuracion/registro-premio", "command",new PremioBean());
		mav.addObject("PremioBean", new PremioBean());
		this.cargarCombos(mav);
		return mav;
	} 
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);

		PremioBean prmPremioBean = new PremioBean();
		prmPremioBean.setCodigo(codigo); 
		try {
			premioBean = this.getPremioService().getBuscarPorObjecto(prmPremioBean);
//			tmpUrlImagen = premioBean.getImagenNombre();
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
 
		if (premioBean != null ) {
			if ( premioBean.getEstado() != null)   {  
			if (premioBean.getEstado().equals("1") ){
				 
				ModelAndView mav = new ModelAndView("configuracion/registro-premio", "command", premioBean);  
				this.cargarCombos(mav);
				mav.addObject("premioBean", premioBean);
				return mav;
		}else{
			ModelAndView mav = this.getLista(new PremioBean());
			mav.addObject("swMensaje","0");
			mav.addObject("premioBean",new PremioBean());  
			return mav;
			
		} }
			else{
				ModelAndView mav = this.getLista(new PremioBean());
				mav.addObject("swMensaje","0");
				mav.addObject("premioBean",new PremioBean());  
				return mav;
		} 
		
		} 
		else { 
			ModelAndView mav = this.getLista(new PremioBean());
			mav.addObject("swMensaje","0");
			mav.addObject("premioBean",new PremioBean());  
			return mav;
		} 
	} 
		
		
		
		
		
		
	

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("premioBean") PremioBean premioBean,
		@RequestParam("file") MultipartFile[] files,HttpServletRequest request) {
			
		 System.out.println("premioBean Grabar"+premioBean);
		System.out.println("premioBean Grabar"+premioBean.getCodigo());
		boolean sw = true;
		boolean swNuevaUrlImagen = false;
		try {
			
			if (files.length>0) {
				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
			}
			
			if (swNuevaUrlImagen) {
				premioBean.setFileImagen(files[0]);
		    	if (files[0].getOriginalFilename()!=null) {
		    		premioBean.setImagenNombre(files[0].getOriginalFilename());
		    	}	    					
			}else {				
				premioBean.setImagenNombre(tmpUrlImagen);
			}
			
			
			if (premioBean.getCodigo()==0) {
				sw =  (this.getPremioService().insertar(premioBean)); 
			} else {
				sw = (this.getPremioService().actualizar(premioBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), premioBean.getImagenNombre(), premioBean.getFileImagen());    			    	
				tmpUrlImagen = premioBean.getImagenNombre();
			}
			
			
			premioBean = new PremioBean() ;
			ModelAndView mav = this.getLista(premioBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-premio", "command",premioBean);
			mav.addObject("swMensaje",sw?"1":"0");
			mav.addObject("premioBean",premioBean);
			this.cargarCombos(mav);
			return mav;
		}

	}

	private ModelAndView getLista(PremioBean premioBean) {
		
		List<PremioBean> lstPremioBean = new ArrayList<PremioBean>();
		try { 
			lstPremioBean = (List<PremioBean>) this.getPremioService().getBuscarPorFiltros(premioBean); 
			System.out.println("tama�o lst premio bean "+lstPremioBean.size());
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-premio", "command",premioBean);
		System.out.println("lstPremioBean "+lstPremioBean);
		mav.addObject("lstPremioBean", lstPremioBean);
		this.cargarCombos(mav);
		return mav;
	}
		private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionPremio",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstRegion==null) {
			try {
				lstRegion = maestra2Service.listarPorCodigoTabla("region",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstTipo==null) {
			try {
				lstTipo = maestra1Service.listarPorCodigoTabla("tipoPremio",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstRegion",lstRegion);
		mav.addObject("lstTipo",lstTipo);
	}
          
	public PremioService getPremioService() {
		return premioService;
	}

	public void setPremioService(PremioService premioService) {
		this.premioService = premioService;
	}

	
	public PremioBean getPremioBean() {
		return premioBean;
	}

	public void setPremioBean(PremioBean premioBean) {
		this.premioBean = premioBean;
	}

	public List<PremioBean> getLstPremioBean() {
		return lstPremioBean;
	}

	public void setLstPremioBean(List<PremioBean> lstPremioBean) {
		this.lstPremioBean = lstPremioBean;
	} 

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	} 
	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
	
	 public List<MaestraBean> getLstRegion() {
		return lstRegion;
	}

	public void setLstRegion(List<MaestraBean> lstRegion) {
		this.lstRegion = lstRegion;
	} 
	 public String getRootPath() {    	
			return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.premio");
	     }

	public List<MaestraBean> getlstTipo() {
		return lstTipo;
	}

	public void setlstTipo(List<MaestraBean> lstlstTipo) {
		this.lstTipo = lstlstTipo;
	}

	public void setValoresPredeterminados(PremioBean premioBean){
		 premioBean.setNombre(""); 
		 premioBean.getSituacion().setCodigoRegistro(0);
	    } 
}
