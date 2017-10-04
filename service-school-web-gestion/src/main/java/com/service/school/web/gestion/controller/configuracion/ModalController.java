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

import com.service.school.core.bean.bean.configuracion.ModalBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.configuracion.ModalService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.ResourceUtil;






@Controller
@Scope(value="session")
@RequestMapping(value = "modalController")
public class ModalController extends BaseController{
	
	
	private ModalBean 		modalBean;
	private List<ModalBean> 	lstModalBeans;
	private List<MaestraBean>	lstSituacion;
	
	@Autowired
	private ModalService 		modalService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	private String				tmpUrlImagen;
	
	
	
	
	public String getTmpUrlImagen() {
		return tmpUrlImagen;
	}

	public void setTmpUrlImagen(String tmpUrlImagen) {
		this.tmpUrlImagen = tmpUrlImagen;
	}

	public ModalBean getModalBean() {
		return modalBean;
	}
	
	@PostConstruct
	public void init(){
		this.setModalBean(new ModalBean());
		this.setLstModalBeans(new ArrayList<ModalBean>());
	//	this.setLstSituacion(new ArrayList<MaestraBean>());
	}
	
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("modalBean") ModalBean modalBean)throws Exception {
		
		ModalBean prmModalBean = new ModalBean(); 
		prmModalBean.setNombre("");  
		prmModalBean.setSituacion(new MaestraBean());
		prmModalBean.getSituacion().setCodigoRegistro(0);
		
		ModelAndView mav = new ModelAndView("configuracion/listado-modal", "command",modalBean);
		mav.addObject("lstModalBeans", new ArrayList<ModalBean>());
		mav.addObject("modalBean", new ModalBean());
//		List<ModalBean> lstModalBean = new ArrayList<ModalBean>();
//		
//		try { 
//			lstModalBean = (List<ModalBean>) this.getModalService().getBuscarPorFiltros(prmModalBean); 
//			System.out.println("tamaño lst modal bean "+lstModalBean.size());
//		} catch (Exception e) {
//			System.out.println("getLista falló" + e.getMessage());
//		}
		
		
		this.cargarCombos(mav);
		return mav;
	}
	
	
	
	
	
	
private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionModal",0);
				System.out.println("lstSituacion.size() "+ lstSituacion.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
	
		
//		if (lstTipo==null) {
//			try {
//				lstTipo = maestra1Service.listarPorCodigoTabla("tipomodal");
//				System.out.println("lstTipo.size() "+ lstTipo.size());
//			} catch (ServiceException e) {
//				System.out.println("printStackTrace");
//				e.printStackTrace();
//			}		
//		}
  
		mav.addObject("lstSituacion",lstSituacion); 
//		mav.addObject("lstTipo",lstTipo);
	}

private ModelAndView getListado(ModalBean modalBean) {
	
	List<ModalBean> lstModalBean = new ArrayList<ModalBean>();
	
	try {
		System.out.println("----Entro  lista  modal--");
		lstModalBean = (List<ModalBean>) this.getModalService().getBuscarPorFiltros(modalBean);
		System.out.println("tamaño lst modal bean "+lstModalBean.size());
		

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("getLista " + e.getMessage());
	}

	ModelAndView mav = new ModelAndView("configuracion/listado-modal", "command",modalBean);
	
	mav.addObject("lstModalBean", lstModalBean);
	mav.addObject("modalBean", modalBean);
	this.cargarCombos(mav);
	return mav;
}


@RequestMapping(value = "/buscar", method = RequestMethod.POST)
public ModelAndView doBuscar(@ModelAttribute("modalBean") ModalBean modalBean)
		throws Exception {
	System.out.println("buscar modal " + modalBean);
	return this.getListado(modalBean);
}



@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
	boolean sw=false;
	modalBean= new ModalBean();
	modalBean.setCodigo(codigo);
//	this.setAuditoria(lenguaBean, request, false);
	try { 
			sw =  (this.getModalService().eliminar(modalBean));  

	} catch (Exception e) { 
		e.printStackTrace();
	} 		
	modalBean.setCodigo(0);
	this.setValoresPredeterminados(modalBean);
	ModelAndView mav = this.getLista(modalBean);
	mav.addObject("swMensaje",sw?"1":"0");
	return mav;		
}
	

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command",new ModalBean());
		mav.addObject("ModalBean", new ModalBean());
		this.cargarCombos(mav);
		return mav;
	} 
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);

		ModalBean prmModalBean = new ModalBean();
		prmModalBean.setCodigo(codigo); 
		try {
			modalBean = this.getModalService().getBuscarPorObjecto(prmModalBean);
			tmpUrlImagen = modalBean.getImagenNombre();
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
 
		if (modalBean != null ) {
			if ( modalBean.getEstado() != null)   {  
			if (modalBean.getEstado().equals("1") ){
				 System.out.println("entro m");
				ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command", modalBean);  
				this.cargarCombos(mav);
				mav.addObject("modalBean", modalBean);
				return mav;
		}else{
			ModelAndView mav = this.getLista(new ModalBean());
			mav.addObject("swMensaje","0");
			mav.addObject("modalBean",new ModalBean());  
			return mav;
			
		} }
			else{
				ModelAndView mav = this.getLista(new ModalBean());
				mav.addObject("swMensaje","0");
				mav.addObject("modalBean",new ModalBean());  
				return mav;
		} 
		
		} 
		else { 
			ModelAndView mav = this.getLista(new ModalBean());
			mav.addObject("swMensaje","0");
			mav.addObject("modalBean",new ModalBean());  
			return mav;
		} 
	} 
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("modalBean") ModalBean modalBean,
		@RequestParam("file") MultipartFile[] files,HttpServletRequest request) {
			
		 System.out.println("modalBean Grabar"+modalBean);
		System.out.println("modalBean Grabar"+modalBean.getCodigo());
		boolean sw = true;
		boolean swNuevaUrlImagen = false;
		try {
			
			if (files.length>0) {
				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
			}
			
			if (swNuevaUrlImagen) {
				modalBean.setFileImagen(files[0]);
		    	if (files[0].getOriginalFilename()!=null) {
		    		modalBean.setImagenNombre(files[0].getOriginalFilename());
		    	}	    					
			}else {				
				modalBean.setImagenNombre(tmpUrlImagen);
			}
			
			
			if (modalBean.getCodigo()==0) {
				System.out.println("insert ");
				sw = (this.getModalService().insertar(modalBean));
			} else {
				sw = (this.getModalService().actualizar(modalBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), modalBean.getImagenNombre(), modalBean.getFileImagen());    			    	
				tmpUrlImagen = modalBean.getImagenNombre();
			}
			
			
			modalBean = new ModalBean() ;
			ModelAndView mav = this.getLista(modalBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command",modalBean);
			mav.addObject("swMensaje",sw?"1":"0");
			mav.addObject("modalBean",modalBean);
			this.cargarCombos(mav);
			return mav;
		}

	}
	
	
	
	
	
	
	
	
	
	private String getRootPath() {
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.modal");
			}

	private ModelAndView getLista(ModalBean modalBean) {
		List<ModalBean> lstModalBean = new ArrayList<ModalBean>();
		try { 
			lstModalBean = (List<ModalBean>) this.getModalService().getBuscarPorFiltros(modalBean); 
			System.out.println("tamaño lst modal bean "+lstModalBean.size());
		} catch (Exception e) {
			System.out.println("getLista falló" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-modal", "command",modalBean);
		System.out.println("lstModalBean "+lstModalBean);
		mav.addObject("lstModalBean", lstModalBean);
		this.cargarCombos(mav);
		return mav;
}

	private void setValoresPredeterminados(ModalBean modalBean2) {
	// TODO Auto-generated method stub
	
}

	public void setModalBean(ModalBean modalBean) {
		this.modalBean = modalBean;
	}
	public List<ModalBean> getLstModalBeans() {
		return lstModalBeans;
	}
	public void setLstModalBeans(List<ModalBean> lstModalBeans) {
		this.lstModalBeans = lstModalBeans;
	}
	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}
	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
	public ModalService getModalService() {
		return modalService;
	}
	public void setModalService(ModalService modalService) {
		this.modalService = modalService;
	}
	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}
	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}
	


}
