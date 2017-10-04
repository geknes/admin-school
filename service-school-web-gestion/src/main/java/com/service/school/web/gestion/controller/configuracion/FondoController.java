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

import com.service.school.core.bean.bean.configuracion.FondoBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.FondoService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.ResourceUtil;

@Controller
@Scope(value="session")
@RequestMapping(value = "fondoController")
public class FondoController extends BaseController {
	
	
	private FondoBean 		fondoBean;
	private List<FondoBean> 	lstFondoBeans;
	
	private List<MaestraBean>	lstSituacion;
	private List<MaestraBean>	lstRegion;
//	private List<MaestraBean>	lstTipo;
	
	@Autowired
	private FondoService 		fondoService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	public FondoBean getFondoBean() {
		return fondoBean;
	}
	
	@PostConstruct
	public void init(){
		this.setFondoBean(new FondoBean());
		this.setLstFondoBeans(new ArrayList<FondoBean>());
	//	this.setLstSituacion(new ArrayList<MaestraBean>());
	} 
	
	public FondoController (){  
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("fondoBean") FondoBean fondoBean)throws Exception {
		
		FondoBean prmFondoBean = new FondoBean(); 
		prmFondoBean.setNombre(""); 
		prmFondoBean.setRegion(new MaestraBean());
		prmFondoBean.getRegion().setCodigoRegistro(0);
		prmFondoBean.setSituacion(new MaestraBean());
		prmFondoBean.getSituacion().setCodigoRegistro(0);
//		prmFondoBean.setTipo(new MaestraBean());
//		prmFondoBean.getTipo().setCodigoRegistro(0);
		
		ModelAndView mav = new ModelAndView("configuracion/listado-fondo", "command",fondoBean);
		mav.addObject("lstFondoBeans", new ArrayList<FondoBean>());
		mav.addObject("fondoBean", new FondoBean());
//		List<FondoBean> lstFondoBean = new ArrayList<FondoBean>();
//		
//		try { 
//			lstFondoBean = (List<FondoBean>) this.getFondoService().getBuscarPorFiltros(prmFondoBean); 
//			System.out.println("tamaño lst fondo bean "+lstFondoBean.size());
//		} catch (Exception e) {
//			System.out.println("getLista falló" + e.getMessage());
//		}
		
		
		this.cargarCombos(mav);
		return mav;
	}
	private ModelAndView getListado(FondoBean fondoBean) {
		
		List<FondoBean> lstFondoBean = new ArrayList<FondoBean>();
		
		try {
			System.out.println("----Entro  lista  fondo--");
			lstFondoBean = (List<FondoBean>) this.getFondoService().getBuscarPorFiltros(fondoBean);
			System.out.println("tamaño lst fondo bean "+lstFondoBean.size());
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-fondo", "command",fondoBean);
		
		mav.addObject("lstFondoBean", lstFondoBean);
		mav.addObject("fondoBean", fondoBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("fondoBean") FondoBean fondoBean)
			throws Exception {
		System.out.println("buscar fondo " + fondoBean);
		return this.getListado(fondoBean);
	}
	
	

	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		fondoBean= new FondoBean();
		fondoBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getFondoService().eliminar(fondoBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		fondoBean.setCodigo(0);
		this.setValoresPredeterminados(fondoBean);
		ModelAndView mav = this.getLista(fondoBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("configuracion/registro-fondo", "command",new FondoBean());
		mav.addObject("FondoBean", new FondoBean());
		this.cargarCombos(mav);
		return mav;
	} 
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);

		FondoBean prmFondoBean = new FondoBean();
		prmFondoBean.setCodigo(codigo); 
		try {
			fondoBean = this.getFondoService().getBuscarPorObjecto(prmFondoBean);
			tmpUrlImagen = fondoBean.getImagenNombre();
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
 
		if (fondoBean != null ) {
			if ( fondoBean.getEstado() != null)   {  
			if (fondoBean.getEstado().equals("1") ){
				 System.out.println("entro m");
				ModelAndView mav = new ModelAndView("configuracion/registro-fondo", "command", fondoBean);  
				this.cargarCombos(mav);
				mav.addObject("fondoBean", fondoBean);
				return mav;
		}else{
			ModelAndView mav = this.getLista(new FondoBean());
			mav.addObject("swMensaje","0");
			mav.addObject("fondoBean",new FondoBean());  
			return mav;
			
		} }
			else{
				ModelAndView mav = this.getLista(new FondoBean());
				mav.addObject("swMensaje","0");
				mav.addObject("fondoBean",new FondoBean());  
				return mav;
		} 
		
		} 
		else { 
			ModelAndView mav = this.getLista(new FondoBean());
			mav.addObject("swMensaje","0");
			mav.addObject("fondoBean",new FondoBean());  
			return mav;
		} 
	} 
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("fondoBean") FondoBean fondoBean,
		@RequestParam("file") MultipartFile[] files,HttpServletRequest request) {
			
		 System.out.println("fondoBean Grabar"+fondoBean);
		 System.out.println("fondoBean monedas "+fondoBean.getMonedas());
		System.out.println("fondoBean Grabar"+fondoBean.getCodigo());
		boolean sw = true;
		boolean swNuevaUrlImagen = false;
		try {
			
			if (files.length>0) {
				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
			}
			
			if (swNuevaUrlImagen) {
				fondoBean.setFileImagen(files[0]);
		    	if (files[0].getOriginalFilename()!=null) {
		    		fondoBean.setImagenNombre(files[0].getOriginalFilename());
		    	}	    					
			}else {				
				fondoBean.setImagenNombre(tmpUrlImagen);
			}
			
			
			if (fondoBean.getCodigo()==0) {
				System.out.println("insert ");
				sw = (this.getFondoService().insertar(fondoBean));
			} else {
				sw = (this.getFondoService().actualizar(fondoBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), fondoBean.getImagenNombre(), fondoBean.getFileImagen());    			    	
				tmpUrlImagen = fondoBean.getImagenNombre();
			}
			
			
			fondoBean = new FondoBean() ;
			ModelAndView mav = this.getLista(fondoBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-fondo", "command",fondoBean);
			mav.addObject("swMensaje",sw?"1":"0");
			mav.addObject("fondoBean",fondoBean);
			this.cargarCombos(mav);
			return mav;
		}

	}
	
	private ModelAndView getLista(FondoBean fondoBean) {
		List<FondoBean> lstFondoBean = new ArrayList<FondoBean>();
		try { 
			lstFondoBean = (List<FondoBean>) this.getFondoService().getBuscarPorFiltros(fondoBean); 
			System.out.println("tamaño lst fondo bean "+lstFondoBean.size());
		} catch (Exception e) {
			System.out.println("getLista falló" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-fondo", "command",fondoBean);
		System.out.println("lstFondoBean "+lstFondoBean);
		mav.addObject("lstFondoBean", lstFondoBean);
		this.cargarCombos(mav);
		return mav;
		}
	
	


private String getRootPath() {
	return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.fondo");
	}

private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionFondo",0);
				System.out.println("lstSituacion.size() "+ lstSituacion.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstRegion==null) {
			try {
				lstRegion = maestra2Service.listarPorCodigoTabla("region",0);
				System.out.println("lstRegion.size() "+ lstRegion.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
//		if (lstTipo==null) {
//			try {
//				lstTipo = maestra1Service.listarPorCodigoTabla("tipofondo");
//				System.out.println("lstTipo.size() "+ lstTipo.size());
//			} catch (ServiceException e) {
//				System.out.println("printStackTrace");
//				e.printStackTrace();
//			}		
//		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstRegion",lstRegion);
//		mav.addObject("lstTipo",lstTipo);
	}
	

	public void setFondoBean(FondoBean fondoBean) {
		this.fondoBean = fondoBean;
	}

	public List<FondoBean> getLstFondoBeans() {
		return lstFondoBeans;
	}

	public void setLstFondoBeans(List<FondoBean> lstFondoBeans) {
		this.lstFondoBeans = lstFondoBeans;
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

//	public List<MaestraBean> getLstTipo() {
//		return lstTipo;
//	}
//
//	public void setLstTipo(List<MaestraBean> lstTipo) {
//		this.lstTipo = lstTipo;
//	}

	public FondoService getFondoService() {
		return fondoService;
	}

	public void setFondoService(FondoService fondoService) {
		this.fondoService = fondoService;
	}

	public String getTmpUrlImagen() {
		return tmpUrlImagen;
	}

	public void setTmpUrlImagen(String tmpUrlImagen) {
		this.tmpUrlImagen = tmpUrlImagen;
	}

	@Autowired
	private Maestra2Service 	maestra2Service;
	
	private String				tmpUrlImagen;

	private void setValoresPredeterminados(FondoBean fondoBean2) {
		fondoBean.setNombre(""); 
		fondoBean.getSituacion().setCodigoRegistro(0);
	}
	
	
}
