package com.service.school.web.gestion.controller.academico;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.EspecialidadBean;
import com.service.school.core.bean.bean.academico.InscripcionDocenteBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.DocenteService;
import com.service.school.core.service.service.interfaces.academico.EspecialidadService;
import com.service.school.core.service.service.interfaces.academico.InscripcionDocenteService;
import com.service.school.core.service.service.interfaces.general.InstitucionService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.core.service.service.interfaces.general.PersonaService;
import com.service.school.core.service.service.interfaces.general.UbigeoService;
import com.service.school.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "docenteController")
public class DocenteController extends BaseController {

	private DocenteBean 			docenteBean;
	private EspecialidadBean 		especialidadBean;
	
	private List<DocenteBean> 	lstDocenteBean;

	private UbigeoBean ubigeoBean;
	
	private List<MaestraBean>	lstSituacion;
	private List<MaestraBean> lstTipoDocumento;
	private List<MaestraBean> lstNacionalidad;
	private List<MaestraBean> lstGrado;
	private List<MaestraBean> lstCargo;
	private List<MaestraBean> lstSexo;
	private List<MaestraBean> lstCarrera;
	private List<LenguaBean> 	lstLengua;
	private List<MaestraBean> 	lstNivel;
	private List<InstitucionBean> lstInstitucion;
	private List<EspecialidadBean> lstEspecialidad;
	

	private List<UbigeoBean> lstRegion;
	private List<UbigeoBean> lstProvincia;
	private List<UbigeoBean> lstDistrito;

	@Autowired
	private InstitucionService 		institucionService;
	@Autowired
	private EspecialidadService 	especialidadService;
	
	@Autowired
	private InscripcionDocenteService inscripcionDocenteService;
	
	@Autowired
	private Maestra1Service maestra1Service;
	
	@Autowired 
	private PersonaService personaService;
//	
	@Autowired
	private Maestra2Service maestra2Service;

	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private LenguaService 	lenguaService;

	@Autowired
	private UbigeoService ubigeoService;
	
	public DocenteController(){
		
	}
	
	@PostConstruct
	public void init(){
//		this.usuarioBean = null;
		
		this.setDocenteBean(new DocenteBean());
		this.setLstDocenteBean(new ArrayList<DocenteBean>());
//		this.setLstSituacion(new ArrayList<MaestraBean>());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		ModelAndView mav = new ModelAndView("academico/listado-docente", "command",docenteBean);
		System.out.println("lstDocenteBean "+lstDocenteBean);
		mav.addObject("lstDocenteBean", new ArrayList<DocenteBean>());
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request) throws Exception {
		return this.doListado(docenteBean, request);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
//		DocenteBean prmDocenteBean = new DocenteBean();
//		prmDocenteBean= docenteBean;
		if (docenteBean.getLenguaBean().getNombre().length() == 0) {
			docenteBean.getLenguaBean().setNombre(null);
		}
		return this.getLista(docenteBean);
	}

	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		boolean sw=false;
		docenteBean = new DocenteBean();
		docenteBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				this.setAuditoria(docenteBean, request, false);
				sw =  (this.getDocenteService().eliminar(docenteBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		docenteBean.setCodigo(0);
		/* UsuarioBean */
		docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
//		this.setValoresPredeterminados(docenteBean);
		ModelAndView mav = this.getLista(docenteBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	
	@RequestMapping(value = "/refrescarEspecialidad", method = RequestMethod.GET)
	public @ResponseBody List<EspecialidadBean> refrescarEspecialidad(@RequestParam("codigo") Integer codigo) {
		System.out.println("listarPorCodigoDocente");
		System.out.println("codigo -------------- " + codigo);
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(codigo);
		lstEspecialidad = null;
		try {
			docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
			lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		
		
		return lstEspecialidad;
	}
	
	
	
	@RequestMapping(value ="/eliminarEspecialidad", method = RequestMethod.GET)
	public @ResponseBody String eliminarEspecialidad(@RequestParam("codigo") Integer codigo,@RequestParam("codigoEspecialidad") Integer codigoEspecialidad,HttpServletRequest request){
		boolean sw=false;
		especialidadBean= new EspecialidadBean();
		especialidadBean.setDocenteBean(new DocenteBean());
		especialidadBean.getDocenteBean().setCodigo(codigo);
		especialidadBean.setLenguaBean(new LenguaBean());
		especialidadBean.getLenguaBean().setCodigo(codigoEspecialidad);
		
		
		try { 
			this.setAuditoria(docenteBean, request, false);
			sw =  (this.getEspecialidadService().eliminar(especialidadBean));
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 	
		System.out.println("sale asi "+sw);
		return sw?"1":"0";
	}
	
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		// request.getRemoteAddr();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",new DocenteBean());
//		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("docenteBean", new DocenteBean());
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo,HttpServletRequest request) {

		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(codigo);
		try {
			docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
			lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		ModelAndView mav = new ModelAndView();
		if (docenteBean != null) {
			if(docenteBean.getPersonaBean().getFechaNac()!=null){
				String fechaConFormato = sdf.format(docenteBean.getPersonaBean().getFechaNac()); 
				System.out.println("fechaConFormato");
//				Date nuevaFecha=null;
//					nuevaFecha = sdf.parse(fechaConFormato);
				docenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
				System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+docenteBean.getPersonaBean().getStrFechaNac());
			}
			mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
			mav.addObject("docenteBean", docenteBean);
			mav.addObject("lstEspecialidad", lstEspecialidad);
			this.cargarUbigeo(mav, docenteBean);
			this.cargarCombos(mav);	
		
		}else{//Encaso quieran ingresar por la url se redireciona a listado.
			/* UsuarioBean */
			prmDocenteBean.setCodigo(0);
			prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			mav = this.getLista(prmDocenteBean);
			mav.addObject("swMensaje","0");
		}
		return mav;
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("docenteBean") DocenteBean docenteBean, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		PersonaBean prmPersona = new PersonaBean();
		
		boolean sw = false;
		try {
			if (docenteBean.getCodigo()==0) {
				
				prmPersona=docenteBean.getPersonaBean();
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				

				if(prmPersona==null){
					prmPersona=docenteBean.getPersonaBean();
					
					prmPersona.setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
						Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
						prmPersona.setFechaNac(fechaConFormato);
						
					}
					this.setAuditoria(prmPersona, request, true);
					sw = (this.getPersonaService().insertar(prmPersona));
					
				}
				
				docenteBean.setPersonaBean(prmPersona);

				this.setAuditoria(docenteBean, request, true);				
				sw =  (this.getDocenteService().insertar(docenteBean)); 
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
					Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
					
					prmPersona.setFechaNac(fechaConFormato);
					docenteBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
					
				}
				docenteBean.getPersonaBean().setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());

				this.setAuditoria(docenteBean, request, false);
				sw = (this.getDocenteService().actualizar(docenteBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			docenteBean = new DocenteBean() ;

			/* UsuarioBean */
			docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			
			//return this.getLista(docenteBean);
			ModelAndView mav = this.getLista(docenteBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
			
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}
	
	@RequestMapping(value = "/grabarEspecialidad", method = RequestMethod.POST)
	public @ResponseBody String doGrabarEspecialidad(
			@RequestParam("codlengua") Integer codlengua,
			@RequestParam("codnivel") Integer codnivel,
			@RequestParam("codnumdoc") String codnumdoc,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		
		especialidadBean = new EspecialidadBean();

		especialidadBean = docenteBean.getEspecialidadBean();

		especialidadBean.setLenguaBean(new LenguaBean());
		especialidadBean.getLenguaBean().setCodigo(codlengua);
		
		especialidadBean.setTm2Nivel(new MaestraBean());
		especialidadBean.getTm2Nivel().setCodigoRegistro(codnivel);
		
		especialidadBean.setNumeroDocumento(codnumdoc);
		
	    especialidadBean.setDocenteBean(docenteBean);
		
	    DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		
		String ruta="";
		String nombreDoc="";
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				System.out.println("file.getName() "+ file.getName());
				System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
				// Creating the directory to store file
				String rootPath = "C:/ruta/";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

//				logger.info("Server File Location="
//						+ serverFile.getAbsolutePath());
				ruta=String.valueOf(serverFile);
				nombreDoc=file.getOriginalFilename();
				System.out.println("serverFile " +serverFile);
				System.out.println("file.getName() "+ file.getName());
				System.out.println("You successfully uploaded file=" +file.getOriginalFilename()); 
			} catch (Exception e) {
				 e.getMessage();
			}
			
			especialidadBean.setRutaDocumento(ruta);
			
		}

		
		try {
			
			
			
			//if (especialidadBean.getCodigo()==0) {
			


				this.setAuditoria(especialidadBean, request, true);
				
				sw =  (this.getEspecialidadService().insertar(especialidadBean));
				
				prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
					
					String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
					System.out.println("fechaConFormato");
//					Date nuevaFecha=null;
//						nuevaFecha = sdf.parse(fechaConFormato);
					prmDocenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
					System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmDocenteBean.getPersonaBean().getStrFechaNac());
				}
				
				
				lstEspecialidad = new ArrayList<EspecialidadBean>();
				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
			//} else {
			//	sw = (this.getDocenteService().actualizar(docenteBean));
			//}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		return sw?"1":"0";
	}
	
//	@RequestMapping(value = "/validaDocente", method = RequestMethod.POST)
//	public @ResponseBody DocenteBean validaDocente(@RequestParam("numerodni") String numerodni)
//			throws Exception {
//		DocenteBean prmDocenteBean = new DocenteBean();
//		
//		prmDocenteBean.getPersonaBean().setNumeroDocumento(numerodni);
//		prmDocenteBean= docenteBean;
//		if (docenteBean.getLenguaBean().getNombre().length() == 0) {
//			docenteBean.getLenguaBean().setNombre(null);
//		}
//		return this.getLista(docenteBean);
//	}
	
	/*
	@RequestMapping(value = "/insertarEspecialidad", method = RequestMethod.GET)
	public String doInsertarEspecialidad(@ModelAttribute("docenteBean") DocenteBean docenteBean) {

		System.out.println("grabarEspecialidad codigo de docente "+docenteBean.getCodigo());
	    especialidadBean = docenteBean.getEspecialidadBean();
	    especialidadBean.setDocenteBean(docenteBean);
		
	    //DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		try {
			//if (especialidadBean.getCodigo()==0) {
			
				especialidadBean.setAudCodigoUsuario(1);
				especialidadBean.setAudHostIP("192.168.1.1");
				
				sw =  (this.getEspecialidadService().insertar(especialidadBean));
			
				
				lstEspecialidad = new ArrayList<EspecialidadBean>();
				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
			//} else {
			//	sw = (this.getDocenteService().actualizar(docenteBean));
			//}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		if(sw){
			return "1";
		}else{
			return "0";
		}
	
	}*/

	
	

	private ModelAndView getLista(DocenteBean docenteBean) {

		//List<DocenteBean> lstDocenteBean =null;
		lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
			this.especialidadBean = new EspecialidadBean();
			this.especialidadBean.setDocenteBean(docenteBean);
			this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
			//System.out.println("lstLenguaBean "+lstDocenteBean.size());
		
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("academico/listado-docente", "command",docenteBean);
		System.out.println("lstDocenteBean "+lstDocenteBean);
		mav.addObject("lstDocenteBean", lstDocenteBean);
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}
	//this.cargarUbigeo(mav, null);
	private void cargarUbigeo(ModelAndView mav,DocenteBean docenteBean){

		ubigeoBean = new UbigeoBean();
		if(docenteBean!=null){
			ubigeoBean = docenteBean.getUbigeoBean();
		}
		
		try {
			lstRegion = this.getUbigeoService().listarRegion();
			lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
			lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}		
	
		
		mav.addObject("lstRegion",lstRegion); 
		mav.addObject("lstProvincia",lstProvincia);
		mav.addObject("lstDistrito",lstDistrito); 
	}
          
	private void cargarCombos(ModelAndView mav)	{
		
		LenguaBean lenguaBean = new LenguaBean();
		
		if (usuarioBean != null) {
			try {
				//lstInstitucion = (List<InstitucionBean>) this.getInstitucionService().getBuscarPorFiltros(institucionBean);
				this.lstInstitucion = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
				
				lstLengua = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo",0);
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo",0);
						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera",0);
						lstNivel = maestra2Service.listarPorCodigoTabla("nivel",1);
//				lstRegion = this.getUbigeoService().listarRegion();
//				lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
//				lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCargo",lstCargo); 
		mav.addObject("lstSexo",lstSexo);
		mav.addObject("lstCarrera",lstCarrera); 
		mav.addObject("lstLengua",lstLengua); 
		mav.addObject("lstInstitucion",lstInstitucion); 
		mav.addObject("lstNivel",lstNivel); 
		mav.addObject("lstEspecialidad",lstEspecialidad);
	}
	
	
	/***********************************************************************/
	
	
	
	
	/***********************************************************************/
	
	
	@RequestMapping(value = "/listadodocente", method = RequestMethod.GET)
	public ModelAndView doListadoDocente(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request)throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean= docenteBean;
		
		return this.getListaDocente(prmDocenteBean);
	}
	
	
	

	@RequestMapping(value = "/buscardocente", method = RequestMethod.GET)
	public @ResponseBody List<DocenteBean> doBuscarDocente(@RequestParam("codigoInst") int codigoInst, @RequestParam("nombreDocente") String nombreDocente, @RequestParam("numeroDocumento") String numeroDocumento,@RequestParam("codigoinsclengua") int codigoinsclengua)throws Exception {
		List<DocenteBean> lstDocente = new ArrayList<DocenteBean>();
		
		InscripcionDocenteBean prmDocenteBean = new InscripcionDocenteBean();
		prmDocenteBean.getDocenteBean().getInstitucionBean().setCodigo(codigoInst);
		prmDocenteBean.getDocenteBean().getPersonaBean().setNombrePersona(nombreDocente);
		prmDocenteBean.getDocenteBean().getPersonaBean().setNumeroDocumento(numeroDocumento);
		prmDocenteBean.getInscripcionLenguaBean().setCodigo(codigoinsclengua);
		lstDocente = docenteService.getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(prmDocenteBean);
//		prmDocenteBean.setNombre("");
		if(lstDocente==null){
			lstDocente=new ArrayList<DocenteBean>();
		}
		return lstDocente;
	}
	
	
	private ModelAndView getListaDocente(DocenteBean docenteBean) {

		//lstDocenteBean = new ArrayList<DocenteBean>();

		if (usuarioBean != null) {
			try {
				this.lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
				this.especialidadBean = new EspecialidadBean();
				this.especialidadBean.setDocenteBean(docenteBean);
				this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
		}
		
		ModelAndView mav = new ModelAndView("../layout/docente-registro-modal-view", "command",docenteBean);
		mav.addObject("lstDocenteBean", lstDocenteBean);
		this.cargarCombos(mav);
		this.cargarUbigeo(mav, new DocenteBean());
		return mav;
	}
	
	
	@RequestMapping(value = "/grabardocente", method = RequestMethod.POST)
	@ResponseBody
	public  String doGrabarDocente(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		String n ="";
		boolean sw = false;
		
		try {
			if (docenteBean.getCodigo()==0) {
				
				
				prmPersona=docenteBean.getPersonaBean();
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				if(prmPersona==null){
					prmPersona=docenteBean.getPersonaBean();
					
//					if(docenteBean.getUbigeoBean()==null || docenteBean.getUbigeoBean().equals("") ){
//						docenteBean.getUbigeoBean().setCodigoRegion("00");
//						docenteBean.getUbigeoBean().setCodigoProvincia("00");
//						docenteBean.getUbigeoBean().setCodigoDistrito("00");
//						
//					}
//					docenteBean.getUbigeoBean().setCodigoRegion("00");
//					docenteBean.getUbigeoBean().setCodigoProvincia("00");
//					docenteBean.getUbigeoBean().setCodigoDistrito("00");
//					
//					
//					prmPersona.setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
					
					this.setAuditoria(docenteBean, request, true);
					sw = (this.getPersonaService().insertar(prmPersona));
					docenteBean.setAudCodigoUsuario(1);
					docenteBean.setAudHostIP("192.168.1.1");
				}
				docenteBean.setPersonaBean(prmPersona);
				
				this.setAuditoria(docenteBean, request, true);
				sw =  (this.getDocenteService().insertar(docenteBean)); 
			} else {
				this.setAuditoria(docenteBean, request, false);
				sw = (this.getDocenteService().actualizar(docenteBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if(sw){
			n=String.valueOf(docenteBean.getCodigo());
		}else{
			n="0";
		}
//		if (sw) {
//			docenteBean = new DocenteBean() ;
//			return this.getListaDocente(docenteBean);
//		} else {
//			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
//			return mav;
//		}
		return n;

	}
	
	
	/*************************************************************************************/
	
	
	@RequestMapping(value = "/asignardocente", method = RequestMethod.POST)
	public @ResponseBody String doAsignarDocente(@RequestParam("codigoinsclen") int codigoinsclen, @RequestParam("coddocente") int coddocente )throws Exception {
		
		boolean sw = false;
		String data="";
		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
		inscripcionDocenteBean.getInscripcionLenguaBean().setCodigo(codigoinsclen);
		inscripcionDocenteBean.getDocenteBean().setCodigo(coddocente);
		inscripcionDocenteBean.getSituacionInscripcionDocente().setCodigoRegistro(1);
	    sw = inscripcionDocenteService.insertar(inscripcionDocenteBean);
		//prmDocenteBean.setNombre("");
		
	    if(sw){
	    	sw=true;
	    	data="Exito";
	    }else{
	    	data="Error";
	    }
		return data;
	}
	
	
	
	@RequestMapping(value = "/listadocentesasignados", method = RequestMethod.POST)
	public @ResponseBody List<InscripcionDocenteBean> doListaDocentesAsignados(@RequestParam("codigoInst") int codigoInst, @RequestParam("codigoinsclen") int codigoInscLen, @RequestParam("codigoinsc") int codigoInsc, @RequestParam("situacion") int situ)throws Exception {
		List<InscripcionDocenteBean> lstInscripcionDocenteBean= new ArrayList<InscripcionDocenteBean>();
		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
		inscripcionDocenteBean.getInscripcionLenguaBean().getInstitucion().setCodigo(codigoInst);
		inscripcionDocenteBean.getInscripcionLenguaBean().setCodigo(codigoInscLen);
		inscripcionDocenteBean.getInscripcionLenguaBean().getInscripcionBean().setCodigo(codigoInsc);
		inscripcionDocenteBean.getSituacionInscripcionDocente().setCodigoRegistro(situ);
		lstInscripcionDocenteBean = inscripcionDocenteService.getBuscarPorFiltros(inscripcionDocenteBean);
		//prmDocenteBean.setNombre("");
		if(lstInscripcionDocenteBean==null){
			lstInscripcionDocenteBean= new ArrayList<InscripcionDocenteBean>();
		}
		
		return lstInscripcionDocenteBean;
	}
	
	
	
	
	@RequestMapping(value = "/grabarEspecialidadDocente", method = RequestMethod.POST)
	public @ResponseBody String doGrabarEspecialidadDocente(@RequestParam("codigodocente") int codigoDocente,@RequestParam("codigolengua") int codigoLengua,@RequestParam("codigonivel") int codigoNivel,HttpServletRequest request) {
		
		especialidadBean=new EspecialidadBean();
	    especialidadBean.setDocenteBean(new DocenteBean());
	    especialidadBean.getDocenteBean().setCodigo(codigoDocente);
	    especialidadBean.setLenguaBean(new LenguaBean());
	    especialidadBean.getLenguaBean().setCodigo(codigoLengua);
	    especialidadBean.setTm2Nivel(new MaestraBean());
		especialidadBean.getTm2Nivel().setCodigoRegistro(codigoNivel);
		
	    DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		try {
			//if (especialidadBean.getCodigo()==0) {
			
				//especialidadBean.setAudCodigoUsuario(1);
				//especialidadBean.setAudHostIP("192.168.1.1");
				this.setAuditoria(especialidadBean, request, false);
				sw =  (this.getEspecialidadService().insertar(especialidadBean));
				docenteBean=especialidadBean.getDocenteBean();
				prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
					String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
					System.out.println("fechaConFormato");
//					Date nuevaFecha=null;
//						nuevaFecha = sdf.parse(fechaConFormato);
					prmDocenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
					System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmDocenteBean.getPersonaBean().getStrFechaNac());
				}
				
				
				lstEspecialidad = new ArrayList<EspecialidadBean>();
				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
			//} else {
			//	sw = (this.getDocenteService().actualizar(docenteBean));
			//}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		/*
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",prmDocenteBean);
		mav.addObject("docenteBean", prmDocenteBean);
		mav.addObject("lstEspecialidad", lstEspecialidad);
		mav.addObject("swMensaje",sw?"1":"0");
		this.cargarUbigeo(mav, docenteBean);
		this.cargarCombos(mav);	
		return mav;
		*/
		return sw?"1":"0";
	}

	@RequestMapping(value = "/darbajadocenteasignado", method = RequestMethod.POST)
	public @ResponseBody String doDarBajaDocenteAsignado(@RequestParam("codinscdocente") int codinscdocente)throws Exception {
		
		boolean sw=false;
		String data="";
		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
		inscripcionDocenteBean.setCodigo(codinscdocente);

		
		sw = inscripcionDocenteService.dar_baja_docente_x_InscripcionDocente(inscripcionDocenteBean);
		//prmDocenteBean.setNombre("");
		if(sw){
			data ="Docente Se dio de Baja";
		}else{
			data ="Error al dar De Baja Docente";
		}
		
		return data;
	}
	
		
	
	
	@RequestMapping(value = "/validarDocente", method = RequestMethod.POST)
	public @ResponseBody DocenteBean validarDocente(@RequestParam("numerodocumento") String numeroDocumento) {
	
	
		DocenteBean prmDocenteBean = new DocenteBean();

		/* UsuarioBean */
		prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		prmDocenteBean.getPersonaBean().setNumeroDocumento(numeroDocumento);
		

		DocenteBean docente = new DocenteBean();
		lstDocenteBean = new ArrayList<DocenteBean>();
		
		try {
			lstDocenteBean = (List<DocenteBean>) this.getDocenteService().getBuscarPorNumeroDocumento(prmDocenteBean);
			
			if(lstDocenteBean!=null){
				lstDocenteBean.get(0).setAudTipo("0");
				lstDocenteBean.get(0).setAudCodigoUsuario(0);
				
				docente = this.getDocenteService().getBuscarPorObjecto(lstDocenteBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		ubigeoBean=new UbigeoBean();
		List<UbigeoBean>  lstubigeo;
		try {
			docenteBean = this.getDocenteService().getBuscarxdni(prmDocenteBean);
			
			if(docenteBean!=null){
				if(docenteBean.getPersonaBean().getCodigoUbigeo()!="" && docenteBean.getPersonaBean().getCodigoUbigeo()!=null){
					ubigeoBean.setCodigoUbigeo(docenteBean.getPersonaBean().getCodigoUbigeo());
					lstubigeo =(List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
					if(lstubigeo!=null){
						docenteBean.getPersonaBean().setUbigeoBean(lstubigeo.get(0));
					}
					
				}
				
			}
			
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 if(docenteBean==null){
			 docenteBean=new DocenteBean();
		 }
		return docenteBean;
		*/
		return docente;
	}
	
	
	
	
	@RequestMapping(value = "/validarDocenteinscr", method = RequestMethod.POST)
	public @ResponseBody DocenteBean validarDocenteinscr(@RequestParam("numerodocumento") String numeroDocumento) {
	

		DocenteBean prmDocenteBean = new DocenteBean();
		/*
		prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		prmDocenteBean.getPersonaBean().setNumeroDocumento(numeroDocumento);
		

		DocenteBean docente = new DocenteBean();
		lstDocenteBean = new ArrayList<DocenteBean>();
		
		try {
			lstDocenteBean = (List<DocenteBean>) this.getDocenteService().getBuscarPorNumeroDocumento(prmDocenteBean);
			
			if(lstDocenteBean!=null){
				lstDocenteBean.get(0).setAudTipo("0");
				lstDocenteBean.get(0).setAudCodigoUsuario(0);
				
				docente = this.getDocenteService().getBuscarPorObjecto(lstDocenteBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		ubigeoBean=new UbigeoBean();
		List<UbigeoBean>  lstubigeo;
		try {
			docenteBean = this.getDocenteService().getBuscarxdni(prmDocenteBean);
			
			if(docenteBean!=null){
				if(docenteBean.getPersonaBean().getCodigoUbigeo()!="" && docenteBean.getPersonaBean().getCodigoUbigeo()!=null){
					ubigeoBean.setCodigoUbigeo(docenteBean.getPersonaBean().getCodigoUbigeo());
					lstubigeo =(List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
					if(lstubigeo!=null){
						docenteBean.getPersonaBean().setUbigeoBean(lstubigeo.get(0));
					}
					
				}
				
			}
			
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 if(docenteBean==null){
			 docenteBean=new DocenteBean();
		 }
		return docenteBean;
	
	}
	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}

	public List<DocenteBean> getLstDocenteBean() {
		return lstDocenteBean;
	}

	public void setLstDocenteBean(List<DocenteBean> lstDocenteBean) {
		this.lstDocenteBean = lstDocenteBean;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public DocenteService getDocenteService() {
		return docenteService;
	}

	public void setDocenteService(DocenteService docenteService) {
		this.docenteService = docenteService;
	}

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}

	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
	}

	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}

	public InstitucionService getInstitucionService() {
		return institucionService;
	}

	public void setInstitucionService(InstitucionService institucionService) {
		this.institucionService = institucionService;
	}

	public EspecialidadService getEspecialidadService() {
		return especialidadService;
	}

	public void setEspecialidadService(EspecialidadService especialidadService) {
		this.especialidadService = especialidadService;
	}

	public EspecialidadBean getEspecialidadBean() {
		return especialidadBean;
	}

	public void setEspecialidadBean(EspecialidadBean especialidadBean) {
		this.especialidadBean = especialidadBean;
	}
	
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}


}
