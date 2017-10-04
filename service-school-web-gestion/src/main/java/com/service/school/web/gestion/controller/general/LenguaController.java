package com.service.school.web.gestion.controller.general;
  
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
import org.springframework.web.bind.annotation.ResponseBody; 
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.bean.bean.generico.UnidadLeccionBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.LenguaEstructuraService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.core.service.service.interfaces.general.UnidadLeccionService;
import com.service.school.core.service.service.interfaces.general.UnidadService;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioService;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.controller.general.view.LenguaForm;
import com.service.school.web.gestion.utilitarios.ResourceUtil; 
 
@Controller
@RequestMapping(value = "lenguaController")
@Scope(value="session")
public class LenguaController extends BaseController {
	
	private LenguaForm 			lenguaForm;

	private LenguaBean 			lenguaBean;
	
	private LenguaEstructuraBean lenguaEstructuraBean;
	
	private List<LenguaBean> 	lstLenguaBean;
	
	private List<LenguaEstructuraBean> 	lstLenguaEstructuraBean;
	
	private List<UnidadLeccionBean>	lstUnidadLeccionBean;
	
	private List<UnidadBean>	lstUnidadBean;
	
	private List<MaestraBean> 	lstUnidad;
	
	private UnidadBean unidadBean;
	
	private UnidadLeccionBean unidadLeccionBean;
	
	private List<MaestraBean>	lstSituacion;
	
	private List<MaestraBean>	lstSituacionLeccion;
	
	private List<MaestraBean>	lstNivel;
	
	private List<MaestraBean>	lstSubNivel;

	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private LenguaEstructuraService	lenguaEstructuraService;
	
	@Autowired
	private UnidadService			unidadService;
	
	@Autowired
	private UnidadLeccionService	unidadLeccionService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	private String				tmpUrlImagen;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*temporalmente*/
	List<MaestraBean>	lstSubNivel1 = new ArrayList<MaestraBean>();
	List<MaestraBean>	lstSubNivel2 = new ArrayList<MaestraBean>();
	List<MaestraBean>	lstSubNivel3 = new ArrayList<MaestraBean>();
	
	@PostConstruct
	public void init(){
		this.setLenguaBean(new LenguaBean());
		this.setLenguaForm(new LenguaForm());
		this.setLstLenguaBean(new ArrayList<LenguaBean>()); 
		this.setLstLenguaEstructuraBean(new ArrayList<LenguaEstructuraBean>());  
		this.setLstUnidadLeccionBean(new ArrayList<UnidadLeccionBean>());
		this.setLstUnidadBean(new ArrayList<UnidadBean>());
		this.setLstNivel(new ArrayList<MaestraBean>());
	}
	 
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("lenguaBean") LenguaBean lenguaBean
			)throws Exception {  
//		return this.getLista(lenguaBean);
		ModelAndView mav = new ModelAndView("general/lengua/listado-lengua", "command",lenguaBean);

		mav.addObject("lstLenguaBean", new ArrayList<LenguaBean>());
		this.cargarCombos(mav);
		return mav;
	} 

	@RequestMapping(value = "/lenguaCargarModal", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView doListadoEstructura(@RequestParam("codigo") Integer codigo) {
		LenguaBean lenguaBean = new LenguaBean();
		lenguaBean.setCodigo(codigo);
		System.out.println("listaEstructura codigo "+ codigo);

		ModelAndView mav = new ModelAndView("general/lengua/ajax/registro-estructura-lengua-modal", "command",lenguaBean);
		 
		System.out.println("lstLenguaEstructuraBean.");
		mav.addObject("lstLenguaEstructuraBean", lstLenguaEstructuraBean);
		this.cargarNivelSubNivel(mav,lenguaBean); 
		return mav; 
	}
	
	@RequestMapping(value = "/lenguaCargarModalUnidadLeccion", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView lenguaCargarModalUnidadLeccion(@RequestParam("codigo") Integer codigo) {
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		lenguaEstructuraBean.setCodigo(codigo);
		
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.getUnidadBean().setCodigo(codigo);
		System.out.println("lenguaCargarModalUnidadLeccion codigo "+ codigo);
		
		ModelAndView mav = new ModelAndView("general/lengua/ajax/registro-unidad-estructura-lengua-modal", "command",unidadLeccionBean);
		 
		try {
			lstSituacionLeccion = maestra1Service.listarPorCodigoTabla("situacionLeccion",0); 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}	 
		try {  
			
			lstUnidadLeccionBean = unidadLeccionService
					.listarPorUnidad(unidadLeccionBean.getUnidadBean());
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstUnidadLeccionBean",lstUnidadLeccionBean); 
		mav.addObject("lstSituacionLeccion",lstSituacionLeccion); 
		mav.addObject("unidadLeccionBean", unidadLeccionBean);  
		return mav; 
	} 
	
	private void cargarNivelSubNivel(ModelAndView mav, LenguaBean lenguaBean ){ 
		MaestraBean prmMaestra = new MaestraBean();
		prmMaestra.setCodigoTabla("subNivel"); 
		lstNivel = new ArrayList<MaestraBean>();
		lstSubNivel = new ArrayList<MaestraBean>();
		lstSubNivel1 = new ArrayList<MaestraBean>();
		lstSubNivel2 = new ArrayList<MaestraBean>();
		lstSubNivel3 = new ArrayList<MaestraBean>();
		mav.addObject("I","none"); 
		mav.addObject("A","none"); 
		 
		if (lstNivel.size() == 0) {
			try {
				lstNivel = maestra2Service.listarPorCodigoTabla("nivel",1);
			} catch (ServiceException e) { 
				 
			} 
		}
			  
			try {
				lstSubNivel = maestra2Service.listarPorCodigoTabla("subNivel",0);
				///for (MaestraBean oNivel :lstNivel ) {
					for (MaestraBean osubNivel :lstSubNivel ) {
						if (osubNivel.getValor1().equals("1")) { 
							lstSubNivel1.add(osubNivel);
						}else if(osubNivel.getValor1().equals("2")){
							lstSubNivel2.add(osubNivel);
						}else if(osubNivel.getValor1().equals("3")){
							lstSubNivel3.add(osubNivel);
						}
				//	}
				}
			} catch (ServiceException e) { 
				 
			}   
		if (lstLenguaEstructuraBean != null) {
			if (lstLenguaEstructuraBean.size() > 0) {
				LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
				prmLenguaEstructuraBean.setLenguaBean(lenguaBean);
				List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = null;
				try {
					lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarNiveles(lenguaBean);
				} catch (ServiceException e1) {
					e1.printStackTrace();
				} 
					try { 
						if (lstLenguaEstructuraBeanNivel != null) {
							for (LenguaEstructuraBean oLenguaEstructuraBean :lstLenguaEstructuraBeanNivel) {
								for(MaestraBean oMaestraBean :lstNivel){
									 if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraBean.getNivel().getCodigoRegistro()){
										 	mav.addObject(oMaestraBean.getNombreLargo(),""); 
										 	oMaestraBean.setValor1("checked");
										}else{
										//	oMaestraBean.setValor1(""); 
										//	mav.addObject(oMaestraBean.getNombreLargo(),"none"); 
										}
									 this.setLstNivel(lstNivel);
								 }
							}
							// GENERAR DINAMICO//
							prmLenguaEstructuraBean.getNivel().setCodigoRegistro(1); 
							List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel = 
										lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
							if (lstLenguaEstructuraBeanSubNivel != null) {
								for (LenguaEstructuraBean oLenguaEstructuraSubNivelBean :lstLenguaEstructuraBeanSubNivel) {
									for(MaestraBean oMaestraBean :lstSubNivel1){
										if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraSubNivelBean.getSubNivel().getCodigoRegistro()){ 
										 	oMaestraBean.setValor1("checked");
										}else{ 
										}
										this.setLstSubNivel1(lstSubNivel1);
									}
								}
							}
							prmLenguaEstructuraBean.getNivel().setCodigoRegistro(2); 
							List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel2 = 
									lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
							if (lstLenguaEstructuraBeanSubNivel2 != null) { 
								for (LenguaEstructuraBean oLenguaEstructuraSubNivelBean :lstLenguaEstructuraBeanSubNivel2) {
									for(MaestraBean oMaestraBean :lstSubNivel2){
										if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraSubNivelBean.getSubNivel().getCodigoRegistro()){ 
										 	oMaestraBean.setValor1("checked");
										}else{
										}
										this.setLstSubNivel2(lstSubNivel2);
									}
								}  
							}
							prmLenguaEstructuraBean.getNivel().setCodigoRegistro(3); 
							List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel3 = 
									lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
							if (lstLenguaEstructuraBeanSubNivel3 != null) { 
								for (LenguaEstructuraBean oLenguaEstructuraSubNivelBean :lstLenguaEstructuraBeanSubNivel3) {
									for(MaestraBean oMaestraBean :lstSubNivel3){
										if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraSubNivelBean.getSubNivel().getCodigoRegistro()){ 
										 	oMaestraBean.setValor1("checked");
										}else{
										}
										this.setLstSubNivel3(lstSubNivel3);
									}
								 }
							 } 
						} 
					} catch (ServiceException e) {
						System.out.println("printStackTrace");
						e.printStackTrace();
					}	  
			} 
		} 
		System.out.println("lstNivel "+ lstNivel.size());
		mav.addObject("lstNivel",lstNivel); 
	//	mav.addObject("lstSubNivel",lstSubNivel);  
		mav.addObject("lstSubNivel1",lstSubNivel1);  
		mav.addObject("lstSubNivel2",lstSubNivel2);  
		mav.addObject("lstSubNivel3",lstSubNivel3);  
		
	
	}   
	
	@RequestMapping(value = "/grabarEstructura", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarEstructura(@RequestParam("codigo") Integer codigo, @RequestParam("subNiveles") String[] subNiveles) {
		String mensage=  "";
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		LenguaBean lenguaBean = new LenguaBean();
		lenguaBean.setCodigo(codigo);
		lenguaEstructuraBean.setLenguaBean(lenguaBean);
		System.out.println("grabarEstructura codigo "+ codigo);
		System.out.println("listaEstructura subNiveles "+ subNiveles.toString());
		 
		List<MaestraBean> lstSubNiveles = null; 
		Boolean sw = true;		
		try {
			lstSubNiveles = maestra2Service.listarPorCodigoTabla("subNivel",0);
			for (MaestraBean oSubNivel : lstSubNiveles) {
				lenguaEstructuraBean.setSubNivel(oSubNivel);
				lenguaEstructuraBean.getSituacion().setCodigoRegistro(1);
				lenguaEstructuraBean.getNivel().setCodigoRegistro(Integer.valueOf(oSubNivel.getValor1()));
				lenguaEstructuraBean.setSwActivo("0");
				for (String data : subNiveles) {
					if (data.equals(oSubNivel.getCodigoRegistro().toString())) {
						lenguaEstructuraBean.setSwActivo("1");
						System.out.println("subNiveles == >" + data);
					} 
		        }
				sw = lenguaEstructuraService.insertar(lenguaEstructuraBean);
			}
			mensage ="1";
		} catch (ServiceException e1) { 
			e1.printStackTrace();
		}
		System.out.println("sw ::: " + sw);  
		System.out.println("modificar lenguaBean: " + lenguaBean); 
		return mensage;
	}
	
	@RequestMapping(value = "/grabarUnidad", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarUnidad(@ModelAttribute("lenguaForm") LenguaForm lenguaForm,
			 HttpServletRequest request) {
		System.out.println("grabarUnidad");
		String mensage=  ""; 
		this.setUnidadBean(lenguaForm.getUnidadBean()); 
		unidadBean.setLenguaEstructuraBean(lenguaForm.getLenguaEstructuraBean());
		System.out.println("lenguaForm.getLenguaEstructuraBean().getCodigo() " + lenguaForm.getLenguaEstructuraBean().getCodigo());
		if (lenguaForm.getLenguaEstructuraBean().getCodigo() == 0
				//&& lenguaForm.getUnidadBean().getUnidad().getCodigoRegistro() == 0 
			//	&& lenguaForm.getUnidadBean().getNombre() !=""
				
				) {
			mensage ="2";
		}else{  
			try {
					
					if (unidadService.existe(unidadBean)) {
						mensage ="3";
					}else{
					if (unidadBean.getCodigo() == 0) {
						System.out.println("insertar unidadBean: " + unidadBean);
						this.setAuditoria(unidadBean, request, true);
						unidadService.insertar(unidadBean);
						 
					}else{
						System.out.println("modificar unidadBean: " + unidadBean);
						this.setAuditoria(unidadBean, request, false);
						unidadService.actualizar(unidadBean);
					} 
					mensage ="1";
					}
				} catch (ServiceException e1) { 
					e1.printStackTrace();
				} 
		}
		 
		return mensage;
		 
	}
	
	  
	@RequestMapping(value = "/eliminarUnidad", method = RequestMethod.GET) 
	@ResponseBody
	public String eliminarUnidad(@RequestParam("codigo") Integer codigo,
			 HttpServletRequest request) {
		System.out.println("eliminarUnidad  " + codigo);
		UnidadBean unidadBean = new UnidadBean();
		unidadBean.setCodigo(codigo);
		String mensage=  "";  	
		try { 
				this.setAuditoria(unidadBean, request, false);
				unidadService.eliminar(unidadBean);
			  
			mensage ="1";
		} catch (ServiceException e1) { 
			mensage ="2";
			e1.printStackTrace();
		} 
		  
		return mensage;
		 
	}
	
	@RequestMapping(value = "/eliminarLeccion", method = RequestMethod.GET) 
	@ResponseBody
	public String eliminarLeccion(@RequestParam("codigo") Integer codigo,
			 HttpServletRequest request) {
		System.out.println("eliminarUnidad  " + codigo);
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.setCodigo(codigo);
		String mensage=  "";  	
		try { 
				this.setAuditoria(unidadLeccionBean, request, false);
				unidadLeccionService.eliminar(unidadLeccionBean);
			  
			mensage ="1";
		} catch (ServiceException e1) { 
			mensage ="2";
			e1.printStackTrace();
		} 
		  
		return mensage;
		 
	}
	
	
	@RequestMapping(value = "/modificarUnidad", method = RequestMethod.GET)
	@ResponseBody
	public  UnidadBean modificarUnidad( @RequestParam("codigo") Integer codUnidad) throws Exception {
		
		System.out.println("modificarUnidad codigo " + codUnidad);
		UnidadBean unidadBean = null;
		UnidadBean prmUnidad = new UnidadBean();
		prmUnidad.setCodigo(codUnidad); 
		if (codUnidad > 0) {
			unidadBean =  unidadService.getBuscarPorObjecto(prmUnidad);
			if (unidadBean != null) {
				System.out.println("unidadBean is not null" + unidadBean);
			}else{
				System.out.println("unidadBean is  null");
			}
		}
		return unidadBean;
	}
	
	@RequestMapping(value = "/grabarLeccion", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarLeccion(@ModelAttribute("unidadLeccionBean") UnidadLeccionBean unidadLeccionBean,
			 HttpServletRequest request) {
		 
		System.out.println("grabarLeccion " + unidadLeccionBean );
		System.out.println("grabarLeccion codigo " + unidadLeccionBean.getCodigo() );
		System.out.println("grabarLeccion nombre " + unidadLeccionBean.getNombre());
		String mensage=  "";  
		if (!unidadLeccionBean.getNombre().equals("") && unidadLeccionBean.getSituacion().getCodigoRegistro() > 0) {
			try {
				if(!unidadLeccionService.existe(unidadLeccionBean)){
					if (unidadLeccionBean.getCodigo() == 0) {
						this.setAuditoria(unidadLeccionBean, request, true);
						unidadLeccionService.insertar(unidadLeccionBean);
						 
					}else{
						this.setAuditoria(unidadLeccionBean, request, false);
						unidadLeccionService.actualizar(unidadLeccionBean);
					} 
					mensage ="1";
				}else{
					mensage ="3";
				}
				
			} catch (ServiceException e1) { 
				e1.printStackTrace();
			} 
			 
		}else{
			mensage ="2";
		}	
	
		System.out.println("modificar lenguaBean: " + lenguaBean); 
		return mensage;
		 
	}
	
	@RequestMapping(value = "/modificarLeccion", method = RequestMethod.GET)
	@ResponseBody
	public  UnidadLeccionBean modificarLeccion( @RequestParam("codigo") Integer codUnidadLeccion) throws Exception {
		
		System.out.println("UnidadLeccionBean codigo " + codUnidadLeccion);
		UnidadLeccionBean unidadLeccionBean = null;
		UnidadLeccionBean prmUnidadLeccion = new UnidadLeccionBean();
		prmUnidadLeccion.setCodigo(codUnidadLeccion); 
		if (codUnidadLeccion > 0) {
			unidadLeccionBean =  unidadLeccionService.getBuscarPorObjecto(prmUnidadLeccion);
			if (unidadBean != null) {
				System.out.println("unidadBean is not null" + unidadBean);
			}else{
				System.out.println("unidadBean is  null");
			}
		}
		return unidadLeccionBean;
	}
	
	@RequestMapping(value = "/recargarListadoxLengua", method = RequestMethod.GET)
	public ModelAndView recargarListadoxLengua(@RequestParam("codigo") Integer codigo) {

		System.out.println("codigo recargarListadoxInscripcion " + codigo);
		
		ModelAndView mav = new ModelAndView("general/lengua/listado-estructura-lengua"); 
	
		cargarEstructuraXLengua(mav,codigo);
		return mav;
	}
	
	private void cargarEstructuraXLengua(ModelAndView mav, int codigo){ 
		System.out.println("cargarInscripcionXLengua codigoMatcodigoMatcodigoMat " + codigo);
		List<LenguaEstructuraBean>	lstLenguaEstructuraBean=null; 
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		try { 
			if (lenguaEstructuraService.insertarLenguaEstrucTemporal(prmLenguaBean)) {
				lstLenguaEstructuraBean = lenguaEstructuraService.listarPorCodigoLengua(prmLenguaBean);
				this.setLstLenguaEstructuraBean(lstLenguaEstructuraBean);
			} 
		} catch (ServiceException e) { 
			e.printStackTrace();
		}

		System.out.println("mav " + mav); 
		mav.addObject("lstLenguaEstructuraBean",lstLenguaEstructuraBean); 
	
	} 
	
	@RequestMapping(value = "/listarLenguas", method = RequestMethod.GET)
	public ModelAndView listarLenguas(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarLenguas");
		ModelAndView mav = new ModelAndView("general/lengua/ajax/listado-tabla-lenguas");
		List<LenguaBean> lstLenguaBean =new ArrayList<LenguaBean>(); 
		try {
			lstLenguaBean = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(new LenguaBean());
			System.out.println("lstLenguaBean actual :: "+lstLenguaBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		} 
		System.out.println("lstLenguaBean "+lstLenguaBean);
		mav.addObject("lstLenguaBean", lstLenguaBean); 
		return mav;
	}
	
	@RequestMapping(value = "/listarUnidades", method = RequestMethod.GET)
	public ModelAndView listarUnidades(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarUnidades");
		ModelAndView mav = new ModelAndView("general/lengua/ajax/listado-lengua-unidades"); 
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		try { 
			lstUnidadBean = unidadService.listarPorCodigoLengua(prmLenguaBean);
 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		System.out.println("lstLenguaBean "+lstLenguaBean);
		mav.addObject("lstUnidadBean", lstUnidadBean);
		return mav;
	}
	
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("lenguaBean") LenguaBean lenguaBean)
			throws Exception { 
		return this.getLista(lenguaBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",new LenguaForm());

		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstNivel",lstNivel);
		mav.addObject("lenguaForm", new LenguaForm());
		tmpUrlImagen = "";
		return mav;
	}
	
	@RequestMapping(value = "/cargarEstructura", method = RequestMethod.GET)
	public ModelAndView cargarEstructura() { 
		ModelAndView mav = new ModelAndView("general/lengua/registro-estructura-lengua", "command",new LenguaBean());
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstNivel",lstNivel);
		mav.addObject("lenguaBean", new LenguaBean());
		return mav;
	}
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>() ;
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		try {
			lenguaBean = this.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			if (lenguaEstructuraService.insertarLenguaEstrucTemporal(prmLenguaBean)) {
				lstLenguaEstructuraBean = lenguaEstructuraService.listarPorCodigoLengua(prmLenguaBean);
			}
			lenguaForm.setLenguaBean(lenguaBean);
			tmpUrlImagen = lenguaBean.getImagenNombre();
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 
			try { 
				lstUnidadBean = unidadService.listarPorCodigoLengua(prmLenguaBean);
				lstLenguaEstructuraBeanNivel = lenguaEstructuraService
						.listarNiveles(lenguaBean);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
			
		System.out.println("modificar lenguaBean: " + lenguaBean);
		ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command", lenguaForm);
		mav.addObject("lenguaForm", lenguaForm);
		mav.addObject("lstLenguaEstructuraBean", lstLenguaEstructuraBean);
		mav.addObject("lstUnidadBean", lstUnidadBean);
		mav.addObject("lstNivel", lstLenguaEstructuraBeanNivel);
	//	mav.addObject("idUsuario",usuarioBean.getCodigo());	
		this.cargarCombos(mav);	
		return mav;
	}
	
	
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public void eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		lenguaBean= new LenguaBean();
		lenguaBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getLenguaService().eliminar(lenguaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		lenguaBean.setCodigo(0);
		//this.setValoresPredeterminados(lenguaBean);
	//	ModelAndView mav = this.getLista(lenguaBean);
		//mav.addObject("swMensaje",sw?"1":"0");
		//return mav;		
	}
	
	
	@RequestMapping(value ="/eliminarEstructura", method = RequestMethod.GET)
	public ModelAndView eliminarEstructura(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		lenguaEstructuraBean= new LenguaEstructuraBean();
		lenguaEstructuraBean.getLenguaBean().setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (lenguaEstructuraService.eliminar(lenguaEstructuraBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		lenguaBean.setCodigo(0);
		this.setValoresPredeterminados(lenguaBean);
		ModelAndView mav = this.getLista(lenguaBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	} 
	
	@RequestMapping(value = "/grabarLengua", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doGrabar(@ModelAttribute("lenguaForm") LenguaForm lenguaForm,  
						 @RequestParam("lenguaBean.file") MultipartFile[] files,
						 HttpServletRequest request
						 ) { 
		System.out.println("lenguaBean Grabar"+lenguaForm);
		this.setLenguaBean(lenguaForm.getLenguaBean());
		System.out.println("lenguaBean Grabar"+lenguaForm.getLenguaBean().getCodigo());
		boolean sw = true;
		boolean swNuevaUrlImagen = false; 
		
		try {
			
			if (files.length>0) {
				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
			}
			
			if (swNuevaUrlImagen) {
				lenguaBean.setFileImagen(files[0]);
		    	if (files[0].getOriginalFilename()!=null) {
		    		lenguaBean.setImagenNombre(files[0].getOriginalFilename());
		    	}	    					
			}else {				
				lenguaBean.setImagenNombre(tmpUrlImagen);
			} 
			
			if (this.getLenguaService().existe(lenguaBean)) {
				ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
				mav.addObject("swMensaje","3");
				mav.addObject("lstSituacion",lstSituacion); 
				return mav; 
			}else{
				if (lenguaBean.getCodigo()==0) {
					System.out.println("insertar "+lenguaBean);
					this.setAuditoria(lenguaBean, request, true);
					sw =  (this.getLenguaService().insertar(lenguaBean)); 
				} else {
					System.out.println("actualizar "+lenguaBean);
					this.setAuditoria(lenguaBean, request, false);
					sw = (this.getLenguaService().actualizar(lenguaBean));
				}	
			}
			

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), lenguaBean.getImagenNombre(), lenguaBean.getFileImagen());    			    	
				tmpUrlImagen = lenguaBean.getImagenNombre();
			} 
			ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
			mav.addObject("swMensaje","1");
			mav.addObject("lstSituacion",lstSituacion); 
			return mav; 
		} else {
			ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
			mav.addObject("swMensaje", "0");
			mav.addObject("lstSituacion",lstSituacion); 
		    return mav;
		} 
		 
	}
	
	private ModelAndView getLista(LenguaBean lenguaBean) {
		
		List<LenguaBean> lstLenguaBean =new ArrayList<LenguaBean>(); 
		try {
			lstLenguaBean = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
			System.out.println("lstLenguaBean "+lstLenguaBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("general/lengua/listado-lengua", "command",lenguaBean);
		System.out.println("lstLenguaBean "+lstLenguaBean);
		mav.addObject("lstLenguaBean", lstLenguaBean);
		this.cargarCombos(mav);
		return mav;
	}
	/*
	@RequestMapping(value = "/cargarNiveles", method = RequestMethod.GET)
	public @ResponseBody List<MaestraBean> cargarNiveles(
			@RequestParam("codigo") Integer codigo) throws Exception {
		System.out.println("cargarNiveles " + lenguaBean.getCodigo());
		List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
		if (codigo > 0) {
			LenguaBean filtro = new LenguaBean();
			filtro.setCodigo(codigo);
			List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService
					.listarNiveles(lenguaBean);

			if (!VO.isEmptyList(lstLenguaEstructuraBeanNivel)) {
				for (LenguaEstructuraBean objLenEstNivel : lstLenguaEstructuraBeanNivel) {
					if (!VO.isEmptyList(lstNivel)) {
						for (MaestraBean objMaestroNivel : lstNivel) {
							if (objMaestroNivel.getCodigoRegistro() == objLenEstNivel
									.getNivel().getCodigoRegistro()) {
								lista_response.add(objMaestroNivel);
								break;
							}
						}
					}
				}
			}
		}
		return lista_response;
	}
*/
	@RequestMapping(value = "/cargarSubNiveles", method = RequestMethod.GET)
	public @ResponseBody List<LenguaEstructuraBean> cargarSubNiveles(
			@RequestParam("codigo") Integer codlengua,
			@RequestParam("codnivel") Integer codnivel) throws Exception {
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel = new ArrayList<LenguaEstructuraBean>();
		lenguaBean.setCodigo(codlengua);
		LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
		prmLenguaEstructuraBean.getNivel().setCodigoRegistro(codnivel); 
		prmLenguaEstructuraBean.setLenguaBean(lenguaBean);
		System.out.println("cargarSubNiveles codlengua " + codlengua);
		System.out.println("cargarSubNiveles codnivel " + codnivel); 
		if (!codlengua.equals("0") && !codnivel.equals("0")) {
			
			lstLenguaEstructuraBeanSubNivel = 
						lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
		}
		return lstLenguaEstructuraBeanSubNivel;
	}
	
	private void cargarCombos(ModelAndView mav){
		 
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua",0);
				lstUnidad = maestra2Service.listarPorCodigoTabla("unidad",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	 

		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstUnidad",lstUnidad); 
	
	}     
	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
 
	 public List<MaestraBean> getLstSituacionLeccion() {
		return lstSituacionLeccion;
	}

	public void setLstSituacionLeccion(List<MaestraBean> lstSituacionLeccion) {
		this.lstSituacionLeccion = lstSituacionLeccion;
	}

	public List<MaestraBean> getLstUnidad() {
		return lstUnidad;
	}

	public void setLstUnidad(List<MaestraBean> lstUnidad) {
		this.lstUnidad = lstUnidad;
	}

	public List<MaestraBean> getLstNivel() {
		return lstNivel;
	}

	public void setLstNivel(List<MaestraBean> lstNivel) {
		this.lstNivel = lstNivel;
	}

	public List<MaestraBean> getLstSubNivel() {
		return lstSubNivel;
	}

	public void setLstSubNivel(List<MaestraBean> lstSubNivel) {
		this.lstSubNivel = lstSubNivel;
	}

	public void setValoresPredeterminados(LenguaBean lenguaBean){
		 lenguaBean.setNombre(""); 
		 lenguaBean.getSituacion().setCodigoRegistro(0);
	 }
	 
	 public String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.general.lengua");
     }

	public List<LenguaEstructuraBean> getLstLenguaEstructuraBean() {
		return lstLenguaEstructuraBean;
	}

	public void setLstLenguaEstructuraBean(List<LenguaEstructuraBean> lstLenguaEstructuraBean) {
		this.lstLenguaEstructuraBean = lstLenguaEstructuraBean;
	}

	public LenguaEstructuraBean getLenguaEstructuraBean() {
		return lenguaEstructuraBean;
	}

	public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
		this.lenguaEstructuraBean = lenguaEstructuraBean;
	}

	public List<MaestraBean> getLstSubNivel1() {
		return lstSubNivel1;
	}

	public void setLstSubNivel1(List<MaestraBean> lstSubNivel1) {
		this.lstSubNivel1 = lstSubNivel1;
	}

	public List<MaestraBean> getLstSubNivel2() {
		return lstSubNivel2;
	}

	public void setLstSubNivel2(List<MaestraBean> lstSubNivel2) {
		this.lstSubNivel2 = lstSubNivel2;
	}

	public List<MaestraBean> getLstSubNivel3() {
		return lstSubNivel3;
	}

	public void setLstSubNivel3(List<MaestraBean> lstSubNivel3) {
		this.lstSubNivel3 = lstSubNivel3;
	}

	public List<UnidadLeccionBean> getLstUnidadLeccionBean() {
		return lstUnidadLeccionBean;
	}

	public void setLstUnidadLeccionBean(List<UnidadLeccionBean> lstUnidadLeccionBean) {
		this.lstUnidadLeccionBean = lstUnidadLeccionBean;
	}

	public LenguaForm getLenguaForm() {
		return lenguaForm;
	}

	public void setLenguaForm(LenguaForm lenguaForm) {
		this.lenguaForm = lenguaForm;
	}

	public UnidadBean getUnidadBean() {
		return unidadBean;
	}

	public void setUnidadBean(UnidadBean unidadBean) {
		this.unidadBean = unidadBean;
	}

	public List<UnidadBean> getLstUnidadBean() {
		return lstUnidadBean;
	}

	public void setLstUnidadBean(List<UnidadBean> lstUnidadBean) {
		this.lstUnidadBean = lstUnidadBean;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	} 
	
}