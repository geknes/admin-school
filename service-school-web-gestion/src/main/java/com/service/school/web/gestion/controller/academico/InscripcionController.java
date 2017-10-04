package com.service.school.web.gestion.controller.academico;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import com.service.school.core.bean.bean.BaseBean;
import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.DocumentoInscripcionBean;
import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.DocenteService;
import com.service.school.core.service.service.interfaces.academico.DocumentoInscripcionService;
import com.service.school.core.service.service.interfaces.academico.InscripcionLenguaService;
import com.service.school.core.service.service.interfaces.academico.InscripcionService;
import com.service.school.core.service.service.interfaces.academico.MatriculaAlumnoService;
import com.service.school.core.service.service.interfaces.academico.UsuarioMatriculaService;
import com.service.school.core.service.service.interfaces.general.InstitucionService;
import com.service.school.core.service.service.interfaces.general.LenguaEstructuraService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.core.service.service.interfaces.general.PersonaService;
import com.service.school.web.gestion.controller.academico.view.InscripcionForm;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.NetUtil;
import com.service.school.web.gestion.utilitarios.ResourceUtil;
import com.service.school.web.gestion.utilitarios.VO;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "inscripcionController")
public class InscripcionController extends BaseController {
	
	private InscripcionForm				inscripcionForm;
	private InscripcionBean 			inscripcionaBean;
	private InscripcionLenguaBean		inscripcionLenguaBean;
	private DocumentoInscripcionBean 	documentoInscripcionBean;
	private List<InscripcionBean> 		lstInscripcionBean;
	
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;

	
	private List<InstitucionBean>	lstInstitucionBean;
	
	private List<LenguaBean> 		lstLenguaBean; 
	
	private String 					swcod;
	
	
	@Autowired
	private InscripcionService 		inscripcionService;
	
	@Autowired
	private UsuarioMatriculaService usuarioMatriculaService;
	
	@Autowired
	private Maestra2Service 		maestra2Service;
	
    @Autowired
	private InstitucionService		institucionService;
    
	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private InscripcionLenguaService 		inscripcionLenguaService;
	
	@Autowired
	private MatriculaAlumnoService 			matriculaAlumnoService;
	
	@Autowired
	private LenguaEstructuraService			lenguaEstructuraService;
	
	@Autowired
	private DocumentoInscripcionService 	documentoInscripcionService;
	
	
	/***************************************/

	
	private List<MaestraBean>	lstSituacionDoc;
	private List<MaestraBean> lstTipoDocumento;
	private List<MaestraBean> lstNacionalidad;
	private List<MaestraBean> lstGrado;
	private List<MaestraBean> lstCargo;
	private List<MaestraBean> lstSexo;
	private List<MaestraBean> lstCarrera;
	private List<LenguaBean> 	lstLengua;
	List<InstitucionBean> lstInstitucion;
	
	//private FileFormBean fileFormBean;
	
	
	private DocenteBean 			docenteBean;
	private List<DocenteBean> 		lstDocenteBean;
	
	private List<MaestraBean> 		lstNivel;
	private List<LenguaBean> 		lstlenguaBeanCombo;
	
	
	@Autowired
	private Maestra1Service 		maestra1Service;
	
	@Autowired
	private DocenteService 			docenteService;
	
	@Autowired 
	private PersonaService 			personaService;
	/******************************************/
	
	public InscripcionController (){
		
	}
	
	@PostConstruct
	public void init(){
		this.setInscripcionaBean(new InscripcionBean());
		this.setLstInscripcionBean(new ArrayList<InscripcionBean>());
		this.setInscripcionForm(new InscripcionForm());
		this.setInscripcionLenguaBean(new InscripcionLenguaBean());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean)throws Exception {
		//this.setValoresPredeterminados(new InscripcionBean());
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionBean.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionBean.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionBean.getSituacion().getCodigoRegistro());
//		return this.getLista(prmInscripcionBean);
		
		ModelAndView mav = new ModelAndView("academico/listado-inscripcion", "command",inscripcionBean);

		mav.addObject("lstInscripcionBean", new ArrayList<InscripcionBean>());
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
//		inscripcionForm.getInscripcionBean().getSituacion().setCodigoRegistro(1); 
		
	
		return mav;
	}
	  
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean)
			throws Exception {
		//this.setValoresPredeterminados(new InscripcionBean());
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionBean.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionBean.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionBean.getSituacion().getCodigoRegistro());
		return this.getBuscar(prmInscripcionBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",new InscripcionForm());//new InscripcionBean()
		
		/*****************************************************************/
//		docenteBean = new DocenteBean();
//		try {
//			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
//			System.out.println("lstDocenteBean "+lstDocenteBean.size());
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		/********************************************************************/

		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstInstitucionBean",lstInstitucionBean);
		mav.addObject("lstLenguaBean",lstLenguaBean);
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("inscripcionBean", new InscripcionBean());
		mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean());
		mav.addObject("documentoInscripcionBean", new DocumentoInscripcionBean());
//		mav.addObject("lstDocenteBean", lstDocenteBean);
		
//		mav.addObject("docenteBean", new DocenteBean());
		this.cargarCombosDocente(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("codigo " + codigo);

		InscripcionBean prmInscripcionBean = new InscripcionBean();
		prmInscripcionBean.setCodigo(codigo);
		try {
			inscripcionaBean = this.getInscripcionService().getBuscarPorObjecto(prmInscripcionBean);
			inscripcionForm.setInscripcionBean(inscripcionaBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		if (inscripcionaBean != null  && inscripcionaBean.getSituacion().getCodigoRegistro() != null ) {
			 
				 
				System.out.println("modificar lenguaBean: " + inscripcionaBean);
				ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
				mav.addObject("inscripcionForm", inscripcionForm);
//				mav.addObject("documentoInscripcionBean", new DocumentoInscripcionBean());
				this.cargarCombos(mav);
				this.cargarCombosInstitucion(mav);
				this.cargarCombosLengua(mav);
				System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
				cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
				listarDetalleDocumInscri(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
				return mav;
		}else{ 
			ModelAndView mav = this.getLista(new InscripcionBean());
			mav.addObject("swMensaje","0");
			mav.addObject("inscripcionBean",new InscripcionBean());  
			return mav;
			
		}  
//		System.out.println("modificar lenguaBean: " + inscripcionaBean);
//		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
//		mav.addObject("inscripcionForm", inscripcionForm);
//		this.cargarCombos(mav);
//		this.cargarCombosInstitucion(mav);
//		this.cargarCombosLengua(mav);
//		System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
//		cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
//		return mav;
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		inscripcionaBean= new InscripcionBean();
		inscripcionaBean.setCodigo(codigo);
		System.out.println("codigocodigocodigo eliminar " + codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
					this.setAuditoria(inscripcionaBean, request, false);
				sw =  (this.getInscripcionService().eliminar(inscripcionaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		inscripcionaBean.setCodigo(0);
		this.setValoresPredeterminados(inscripcionaBean);
		ModelAndView mav = this.getLista(inscripcionaBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.academico.inscripcion");
     }
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doGrabar(@ModelAttribute("inscripcionForm") InscripcionForm inscripcionForm,HttpServletRequest request) {
		
		System.out.println("inscripcionBean "+inscripcionForm);
		System.out.println("inscripcionBean.getCodigo() "+inscripcionForm.getInscripcionBean().getCodigo());
		System.out.println("inscripcionForm.getInscripcionBean().getFechaRegistro()1 " + inscripcionForm.getInscripcionBean().getFechaRegistro());
		boolean sw = false;
		try {
			if (inscripcionForm.getInscripcionBean().getCodigo()==0) {
				String ruta="";
				String nombreDoc="";
//				if (!file.isEmpty()) {
//					try {
//						byte[] bytes = file.getBytes();
//						System.out.println("file.getName() "+ file.getName());
//						System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
//						// Creating the directory to store file
//						String rootPath = "C:/ruta/";
//						File dir = new File(rootPath + File.separator + "tmpFiles");
//						if (!dir.exists())
//							dir.mkdirs();
//
//						// Create the file on server
//						File serverFile = new File(dir.getAbsolutePath()
//								+ File.separator + file.getOriginalFilename());
//						BufferedOutputStream stream = new BufferedOutputStream(
//								new FileOutputStream(serverFile));
//						stream.write(bytes);
//						stream.close();
//
////						logger.info("Server File Location="
////								+ serverFile.getAbsolutePath());
//						ruta=String.valueOf(serverFile);
//						nombreDoc=file.getOriginalFilename();
//						System.out.println("serverFile " +serverFile);
//						System.out.println("file.getName() "+ file.getName());
//						System.out.println("You successfully uploaded file=" +file.getOriginalFilename()); 
//					} catch (Exception e) {
//						 e.getMessage();
//					}
//				} else {
//					System.out.println("You failed to upload " + file.getOriginalFilename()+ " because the file was empty.");
//				}
				
				
//				System.out.println("insertar ");
//				System.out.println("inscripcionForm.getInscripcionBean().getFechaRegistro()2 " + inscripcionForm.getInscripcionBean().getFechaRegistro());
//				inscripcionForm.getInscripcionBean().setNombreDocumento(nombreDoc);
//				
//				inscripcionForm.getInscripcionBean().setRutaDocumento(ruta);
						this.setAuditoria(inscripcionForm.getInscripcionBean(), request, true);
				sw =  (this.getInscripcionService().insertar(inscripcionForm.getInscripcionBean())); 
			
		
				
				
				
			} else {
				System.out.println("actualizar ");
//				if (file.isEmpty()) {
//						System.out.println("no paso");
//				}else {
//					System.out.println("inscripcionForm.getInscripcionBean().getRutaDocumento() " + inscripcionForm.getInscripcionBean().getRutaDocumento());
//					inscripcionForm.getInscripcionBean().setRutaDocumento(inscripcionForm.getInscripcionBean().getRutaDocumento());
//				}
						this.setAuditoria(inscripcionForm.getInscripcionBean(), request, false);
				sw = (this.getInscripcionService().actualizar(inscripcionForm.getInscripcionBean()));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
//			inscripcionBean = new InscripcionBean() ;
//			this.setValoresPredeterminados(inscripcionaBean);
//			return this.getLista(inscripcionBean);
			InscripcionBean prmInscripcionBean = new InscripcionBean();
			System.out.println("inscripcionBean.getCodigo() " +inscripcionForm.getInscripcionBean().getCodigo());
			prmInscripcionBean.setCodigo(inscripcionForm.getInscripcionBean().getCodigo());
			try {
				inscripcionaBean = this.getInscripcionService().getBuscarPorObjecto(prmInscripcionBean);
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			System.out.println("modificar lenguaBean: " + inscripcionaBean);
			ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
//			mav.addObject("inscripcionaBean", inscripcionaBean);
			
			this.cargarCombos(mav);
			this.cargarCombosInstitucion(mav);
			this.cargarCombosLengua(mav);
			cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
			listarDetalleDocumInscri(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			inscripcionForm.getInscripcionBean().setRutaDocumento(null);
			ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
//			
			this.cargarCombos(mav);
			this.cargarCombosInstitucion(mav);
			this.cargarCombosLengua(mav);
			cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
			mav.addObject("swMensaje","0");
			mav.addObject("inscripcionaBean",inscripcionForm);  
			return mav;
			
//			ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",new InscripcionForm());//new InscripcionBean()
//  			mav.addObject("lstSituacion",lstSituacion);
//			mav.addObject("lstPeriodo",lstPeriodo); 
//			mav.addObject("lstInstitucionBean",lstInstitucionBean);
//			mav.addObject("lstLenguaBean",lstLenguaBean);
//			mav.addObject("lstCiclo",lstCiclo);
//			mav.addObject("inscripcionBean", new InscripcionBean());
//			mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean()); 
//			mav.addObject("swMensaje",sw?"1":"0");
//			this.cargarCombosDocente(mav);
//			return mav;
		}

	}
	
	@RequestMapping(value = "/grabarDetDocumInscrip", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarDetDocumInscrip(@RequestParam("inscripcionBean.codigo") Integer codigoInscrip,
											@RequestParam("documentoInscripcionBean.numedocu") String numDocum,
											@RequestParam("documentoInscripcionBean.file") MultipartFile file,
											HttpServletRequest request) {

//		Long size = file.getSize();
//	    String contentType = file.getContentType();
	        
		System.out.println("------------------grabarDetDocumInscrip--------------------");
		System.out.println("codigoInscrip "+codigoInscrip);
		System.out.println("numDocum "+numDocum);
		System.out.println("file "+file);
//		System.out.println("file size " + size);
//		System.out.println("file contentType " + contentType);
//	
		boolean sw = false;
		try {
//			if (inscripcionForm.getInscripcionBean().getCodigo()==0) {
				String ruta="";
				String nombreDoc="";
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
						System.out.println("file.getName() "+ file.getName());
						System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
						// Creating the directory to store file
						//String rootPath = "C:/ruta/";
						File dir = new File(this.getRootPath());// + File.separator + "tmpFiles"
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						File serverFile = new File(dir.getAbsolutePath()
								+ File.separator + file.getOriginalFilename());
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();

//						logger.info("Server File Location="
//								+ serverFile.getAbsolutePath());
						ruta=String.valueOf(serverFile);
						nombreDoc=file.getOriginalFilename();
						System.out.println("serverFile " +serverFile);
						System.out.println("file.getName() "+ file.getName());
						System.out.println("You successfully uploaded file=" +file.getOriginalFilename()); 
					} catch (Exception e) {
						 e.getMessage();
					}
				} else {
					System.out.println("You failed to upload " + file.getOriginalFilename()+ " because the file was empty.");
				}
				
				
				System.out.println("insertar ");
				documentoInscripcionBean = new DocumentoInscripcionBean();
				documentoInscripcionBean.getInscripcion().setCodigo(Long.valueOf(codigoInscrip));
				documentoInscripcionBean.setNombdocu(nombreDoc);				
				documentoInscripcionBean.setRutadocu(ruta);
				documentoInscripcionBean.setNumedocu(numDocum);
				
//				documentoInscripcionBean.setCodigoUsuarioCreacion(1);
//				documentoInscripcionBean.setIpCreacion("");
				
				this.setAuditoria(documentoInscripcionBean, request, true);
				sw =  (this.documentoInscripcionService.insertar(documentoInscripcionBean)); 
			
		
				
				
				
//			} else {
//				sw=false;
//				return "0";
//				
//			}

		} catch (Exception e) { 
			
			e.printStackTrace();
			return "0";
		}

		if (sw) {
			return "1";
		}else {
			return "0";
		}
		
	}

	@RequestMapping(value = "/grabarDocente", method = RequestMethod.POST)
	public ModelAndView doGrabarDocente(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean,HttpServletRequest request) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		docenteBean = new DocenteBean();
		docenteBean = inscripcionBean.getDocenteBean();
		boolean sw = false;
		try {
			if (docenteBean.getCodigo()==0) {
				
				
				prmPersona=docenteBean.getPersonaBean();
				prmPersona = this.personaService.buscarxTipoDocumentoNumeroDocumento(prmPersona);
				if(prmPersona==null){
					prmPersona=docenteBean.getPersonaBean();
					sw = (this.personaService.insertar(prmPersona));
					
					docenteBean.setAudCodigoUsuario(1);
					docenteBean.setAudHostIP("192.168.1.1");
				}
				
				docenteBean.setPersonaBean(prmPersona);
					this.setAuditoria(docenteBean, request, true);
				sw =  (this.docenteService.insertar(docenteBean)); 
			} else {
					this.setAuditoria(docenteBean, request, false);
				sw = (this.docenteService.actualizar(docenteBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			docenteBean = new DocenteBean() ;
			inscripcionBean.setDocenteBean(docenteBean);
			return this.getLista(inscripcionBean);
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
			return mav;
		}

	}
	
	private void cargarCombosDocente(ModelAndView mav){
//		lstSituacion = new ArrayList<MaestraBean>();
		
		InstitucionBean institucionBean = new InstitucionBean();
		LenguaBean lenguaBean = new LenguaBean();
		if (lstSituacionDoc==null) {
			try {
				lstInstitucion = (List<InstitucionBean>) this.institucionService.getBuscarPorFiltros(institucionBean);
				lstLengua = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
				lstSituacionDoc = maestra1Service.listarPorCodigoTabla("situacionPersonal",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo",0);
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo",0);
						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacionDoc",lstSituacionDoc); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCargo",lstCargo); 
		mav.addObject("lstSexo",lstSexo);
		mav.addObject("lstCarrera",lstCarrera); 
		mav.addObject("lstLengua",lstLengua); 
		mav.addObject("lstInstitucion",lstInstitucion); 
	}
	
	
	private ModelAndView getLista(InscripcionBean inscripcionBean) {

		List<InscripcionBean> lstInscripcionBean =null;
		inscripcionBean.getSituacion().setCodigoRegistro(1);
//		List<DocenteBean> lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			lstInscripcionBean = this.getInscripcionService().getBuscarPorFiltros(inscripcionBean);
			System.out.println("lstInscripcionBean "+lstInscripcionBean.size());
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
		

		ModelAndView mav = new ModelAndView("academico/listado-inscripcion", "command",inscripcionBean);
		System.out.println("lstInscripcionBean "+lstInscripcionBean);
		mav.addObject("lstInscripcionBean", lstInscripcionBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
//		inscripcionForm.getInscripcionBean().getSituacion().setCodigoRegistro(1); 
	
		return mav;
	}
	
	private ModelAndView getBuscar(InscripcionBean inscripcionBean) {
		
		List<InscripcionBean> lstInscripcionBean =null;
//		List<DocenteBean> lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			lstInscripcionBean = this.getInscripcionService().getBuscarPorFiltros(inscripcionBean);
			System.out.println("lstInscripcionBean "+lstInscripcionBean.size());
			
			
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("academico/listado-inscripcion", "command",inscripcionBean);
		System.out.println("lstInscripcionBean "+lstInscripcionBean);
		mav.addObject("lstInscripcionBean", lstInscripcionBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
//		inscripcionForm.getInscripcionBean().getSituacion().setCodigoRegistro(1); 
	
		return mav;
	}
	
          
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra2Service.listarPorCodigoTabla("situacionInscripcion",0);
				setLstPeriodo(maestra2Service.listarPorCodigoTabla("periodo",0));
				lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstSituacion",lstSituacion); 
	} 
	
	private void cargarCombosInstitucion(ModelAndView mav){
		InstitucionBean inst = new InstitucionBean();
		if (lstInstitucionBean==null) {
			try {
				lstInstitucionBean = institucionService.getListarCombo(inst);
				System.out.println("stInstitucionBean.size() "+ lstInstitucionBean.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}else {
			System.out.println("no listo combo lstInstitucionBean");
		}
  
		mav.addObject("lstInstitucionBean",lstInstitucionBean); 
	} 
	
	private void cargarCombosLengua(ModelAndView mav){

		LenguaBean lenguaBean = new LenguaBean();
		try {
			lstLenguaBean = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
			System.out.println("lstLenguaBean "+lstLenguaBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
  
		mav.addObject("lstLenguaBean",lstLenguaBean); 
	} 
	
	
	private void cargarInscripcionXLengua(ModelAndView mav, int codigoMat){
		InscripcionLenguaBean matAlum = new InscripcionLenguaBean();
		matAlum.getInscripcionBean().setCodigo(codigoMat);
		System.out.println("cargarInscripcionXLengua codigoMatcodigoMatcodigoMat " + codigoMat);
		List<InscripcionLenguaBean>	lstInscripcionLenguaBean=null;
		
		
			try {
				lstInscripcionLenguaBean = inscripcionLenguaService.getBuscarPorFiltros(matAlum);
				if (VO.isNotEmptyList(lstInscripcionLenguaBean)) {
					System.out.println(" lstInscripcionLenguaBean.size "+ lstInscripcionLenguaBean.size());
				}
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		


		
		mav.addObject("lstInscripcionLenguaBean",lstInscripcionLenguaBean); 
	
	} 
	
	private void listarDetalleDocumInscri(ModelAndView mav, int codigoInsc){
		DocumentoInscripcionBean prmDocumentoInscripcionBean = new DocumentoInscripcionBean();
		prmDocumentoInscripcionBean.getInscripcion().setCodigo(codigoInsc);
		System.out.println("codigoInsc " + codigoInsc);
		List<DocumentoInscripcionBean>	lstDocumentoInscripcionBean=null;
		
		
			try {
				lstDocumentoInscripcionBean = documentoInscripcionService.listarDocumentoInscripcionBeanxCodInsc(prmDocumentoInscripcionBean);
				if (VO.isNotEmptyList(lstDocumentoInscripcionBean)) {
					System.out.println(" lstDocumentoInscripcionBean.size "+ lstDocumentoInscripcionBean.size());
				}
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		


		
		mav.addObject("lstDocumentoInscripcionBean",lstDocumentoInscripcionBean); 
	
	} 
	
	
//	protected void setAuditoria(BaseBean baseBean,HttpServletRequest request,boolean swInsert){
//		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioBean");
//		long idUsuario=usuario.getCodigo();	
//		//System.out.println("strIdUsuario "+strIdUsuario);
//		this.setAuditoriaLocal(baseBean, idUsuario, request, swInsert);		
//	}
//	private void setAuditoriaLocal(BaseBean baseBean,long iddUsuario,HttpServletRequest request,boolean swInsert){
//		if (swInsert) {
//			baseBean.setCodigoUsuarioCreacion(iddUsuario);
//			baseBean.setIpCreacion(NetUtil.getClientIpAddr(request));			
//			
//		} else {
//			baseBean.setCodigoUsuarioModificacion(iddUsuario);
//			baseBean.setIpModificacion(NetUtil.getClientIpAddr(request));			
//		}
//
//	}

		
//		private static final Logger logger = LoggerFactory
//				.getLogger(InscripcionController.class);
		
		@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
		@ResponseBody
		public String uploadFileHandler(@RequestParam("name") String name,
				@RequestParam("file") MultipartFile file) {

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = "C:/ruta/";
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

//					logger.info("Server File Location="
//							+ serverFile.getAbsolutePath());

					return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					return "You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + name
						+ " because the file was empty.";
			}
		}
		
		@RequestMapping(value = "/lenguaCargarModal", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doLenguaCargarModal(@RequestParam("codigoinst") Integer codigoinst,@RequestParam("codPerio") String codPerio,@RequestParam("codCiclo") Integer codCiclo) {
			
			System.out.println("codigoinst " + codigoinst);	
			System.out.println("codPerio " + codPerio);	
			System.out.println("codCiclo " + codCiclo);	

			InstitucionBean inscripcionaBean = new InstitucionBean();
			inscripcionaBean.setCodigo(codigoinst);
			inscripcionaBean.getTipoActividad().setValor1(codPerio);
			inscripcionaBean.getTipoActividad().setCodigoRegistro(codCiclo);
			try {
				lstlenguaBeanCombo = lenguaService.listarComboxInstitucion(inscripcionaBean);
				
				lstNivel  = maestra2Service.listarPorCodigoTabla("nivel",1);
				if (VO.isNotEmptyList(lstlenguaBeanCombo)) {
					System.out.println("lstlenguaBeanCombo.size() " +lstlenguaBeanCombo.size());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			swcod="0";
			ModelAndView mav = new ModelAndView("../layout/inscripcion-lengua-registro-modal-view", "command", new InscripcionLenguaBean());
			mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean());
			mav.addObject("lstlenguaBeanCombo", lstlenguaBeanCombo);
			mav.addObject("swcod", swcod);
			//mav.addObject("lstnivelbean",lstNivel);
			return mav;
		}
	

		@RequestMapping(value = "/agregarlengua", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarlengua(@RequestParam("numCupos") String numCupos,@RequestParam("codigolengua") Integer codigolengua,@RequestParam("codigoinscri") Integer codigoinscri,@RequestParam("codigonivel") Integer codigonivel,HttpServletRequest request) {
			
			int cuposnuevos   = 0;
			int cuposantiguos = 0;
			
			if(codigonivel==1){
				cuposnuevos =Integer.valueOf(numCupos);
			}
			if(codigonivel!=1){
				cuposantiguos =Integer.valueOf(numCupos);
			}
			String cant="";
			System.out.println("-------------------------agregarlengua-------------------------");
			System.out.println("numCupos " + numCupos);		
			System.out.println("codigolengua " + codigolengua);
			System.out.println("codigonivel "+ codigonivel);
			System.out.println("inscripcionaBean.getCodigo() agregarlengua " + codigoinscri);

		if (swcod == "0") {
			 inscripcionLenguaBean = new InscripcionLenguaBean();
		}
		InscripcionLenguaBean insLen = new InscripcionLenguaBean();
			
			insLen.setNumeroCuposInsc(numCupos);
			insLen.getLenguainscr().setCodigo(codigolengua);
			insLen.getInscripcionBean().setCodigo(codigoinscri);
			insLen.getNivel().setCodigoRegistro(codigonivel);
		
			System.out.println("inscripcionLenguaBean.getCodigo() ins " + inscripcionLenguaBean.getCodigo());
			boolean sw = false;
			try {
				if (inscripcionLenguaBean.getCodigo()==0) {
							System.out.println("insert agregarlengua");
							this.setAuditoria(insLen, request, true);
					sw =  (this.inscripcionLenguaService.insertar(insLen)); 
					cant="1";
					
					if(sw){
						
						
						
						UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
						usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
						usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
//						usuarioMatriculaBean.setAudCodigoUsuario(1);
//						usuarioMatriculaBean.setAudHostIP("192.168.1.1");
						
						if(codigonivel==1){
							
							if(numCupos!=null && numCupos!="" ){
								
								for(int i=0;i<Integer.valueOf(cuposnuevos);i++){
									usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(1);
									this.setAuditoria(usuarioMatriculaBean, request, true);
									usuarioMatriculaService.insertar(usuarioMatriculaBean);
									
								}
								
									for(int i=0;i<Integer.valueOf(cuposantiguos);i++){
										usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
										this.setAuditoria(usuarioMatriculaBean, request, true);
									usuarioMatriculaService.insertar(usuarioMatriculaBean);
									
								}
							}
							
						}else{
							
							
							if(numCupos!=null && numCupos!="" ){
								
							
								
									for(int i=0;i<Integer.valueOf(cuposantiguos);i++){
										usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
										this.setAuditoria(usuarioMatriculaBean, request, true);
									usuarioMatriculaService.insertar(usuarioMatriculaBean);
									
								}
							}
							
							
						}
					
						
						
					}
					
				} else {
					
					System.out.println("actualizar");
					System.out.println("actualizasar agregarlengua");
					System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
					insLen.setCodigo(inscripcionLenguaBean.getCodigo());
					List<MatriculaAlumnoBean> lstMatriculaAlumnoBean = null;
					lstMatriculaAlumnoBean =  matriculaAlumnoService.validarMatriculaAlumnoXInscrLengua(insLen);
					
					if(lstMatriculaAlumnoBean==null){
					
						
						InscripcionLenguaBean inscripcionLenguaBean =new InscripcionLenguaBean();
						
						inscripcionLenguaBean=inscripcionLenguaService.getBuscarPorObjecto(insLen);
						
						UsuarioMatriculaBean usuAlumnosNuevos = new UsuarioMatriculaBean();
						usuAlumnosNuevos.setInscripcionLenguaBean(inscripcionLenguaBean);
						usuAlumnosNuevos.getTipoCupo().setCodigoRegistro(1);
						List<UsuarioMatriculaBean>lstUsuAlumnosNuevos = null;
						lstUsuAlumnosNuevos = usuarioMatriculaService.buscarXTipoCuposXinscrLengua(usuAlumnosNuevos);
						
						if(lstUsuAlumnosNuevos==null){
							lstUsuAlumnosNuevos = new ArrayList<UsuarioMatriculaBean>();
						}
						int numeroCuposAlumnosNuevos =lstUsuAlumnosNuevos.size();
						
						if(numeroCuposAlumnosNuevos!=cuposnuevos){
							
								if(cuposnuevos>numeroCuposAlumnosNuevos){
									
									int anadircuposNuevos =	cuposnuevos -numeroCuposAlumnosNuevos  ;
								
									for(int i =0;i<anadircuposNuevos;i++){
										
										
										/*******************************/
						
										UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
										usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
										usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
//										usuarioMatriculaBean.setAudCodigoUsuario(1);
//										usuarioMatriculaBean.setAudHostIP("192.168.1.1");
										
										if(codigonivel==1){
											
											
													usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(1);
													this.setAuditoria(usuarioMatriculaBean, request, true);
													usuarioMatriculaService.insertar(usuarioMatriculaBean);
												
										}
									
										
										/**************************/
										
									}
									
								}else{
									
									int eliminarcuposNuevos =	numeroCuposAlumnosNuevos - cuposnuevos;
								
									for(int i =0;i<eliminarcuposNuevos;i++){
								
										/*******************************/
						
										if(codigonivel==1){
														this.setAuditoria(lstUsuAlumnosNuevos.get(i), request, false);
													usuarioMatriculaService.eliminar(lstUsuAlumnosNuevos.get(i));
												
										}
									
										
										/**************************/
										
									}
									
								}
								
					
						
						}
						else{
							cant="4";
						}
						
						
						
						
						
						
						
						
						
						
						UsuarioMatriculaBean usuAlumnosMatriculados = new UsuarioMatriculaBean();
						usuAlumnosMatriculados.setInscripcionLenguaBean(inscripcionLenguaBean);
						usuAlumnosMatriculados.getTipoCupo().setCodigoRegistro(2);
						List<UsuarioMatriculaBean>lstUsuAlumnosMatriculados = null;
						lstUsuAlumnosMatriculados = usuarioMatriculaService.buscarXTipoCuposXinscrLengua(usuAlumnosMatriculados);
						
						if(lstUsuAlumnosMatriculados==null){
							lstUsuAlumnosMatriculados= new ArrayList<UsuarioMatriculaBean>();
						}
						int numeroCuposAlumnosMatriculados =lstUsuAlumnosMatriculados.size();
						if(numeroCuposAlumnosMatriculados!=cuposantiguos){
							
							
							
							
							if(cuposantiguos>numeroCuposAlumnosMatriculados){
								
								UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
								usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
								usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
//								usuarioMatriculaBean.setAudCodigoUsuario(1);
//								usuarioMatriculaBean.setAudHostIP("192.168.1.1");
								int anadirCuposAlumnosMatriculados= cuposantiguos - numeroCuposAlumnosMatriculados;
								
								for(int i = 0; i<anadirCuposAlumnosMatriculados;i++){
									
									usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
									this.setAuditoria(usuarioMatriculaBean, request, true);
									usuarioMatriculaService.insertar(usuarioMatriculaBean);
									
								}
							}else{
								
								int eliminarCuposAlumnosMatriculados = numeroCuposAlumnosMatriculados - cuposantiguos;
								
								
									for(int i = 0; i<eliminarCuposAlumnosMatriculados;i++){
									
										this.setAuditoria(lstUsuAlumnosMatriculados.get(i), request, false);
									usuarioMatriculaService.eliminar(lstUsuAlumnosMatriculados.get(i));
									
								}
								
								
							}
							
							
							
							
							
													
						}else{
							cant="4";
						}
						
						
					
						this.setAuditoria(insLen, request, false);
						sw = (this.inscripcionLenguaService.actualizar(insLen));	
						cant="2";
					
//						
//						if(insLen.getNumeroCuposInsc()!=inscripcionLenguaBean.getNumeroCuposInsc()){
//							
//							
//							
//							
//							if(Integer.valueOf(insLen.getNumeroCuposInsc())<Integer.valueOf(inscripcionLenguaBean.getNumeroCuposInsc())){
//								
//								
//								UsuarioMatriculaBean usumateliminar = new UsuarioMatriculaBean();
//								
//								InscripcionBean inscripcionBean = new InscripcionBean();
//								inscripcionBean.setCodigo(codigoinscri);
//								inscripcionBean = inscripcionService.getBuscarPorObjecto(inscripcionBean);
//								
//								usumateliminar.getInscripcionLenguaBean().getInscripcionBean().setCodigo(inscripcionBean.getCodigo());
//								usumateliminar.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
//								usumateliminar.setInscripcionLenguaBean(insLen);
//								
//								
//								List<UsuarioMatriculaBean> lstUsuarioMatriculaBean =null;
//								lstUsuarioMatriculaBean = usuarioMatriculaService.getBuscarPorFiltros(usumateliminar);
//								
//								if(lstUsuarioMatriculaBean == null){
//									
//									int numCuposact = Integer.valueOf(inscripcionLenguaBean.getNumeroCuposInsc())-Integer.valueOf(insLen.getNumeroCuposInsc());
//									
//									
//									for(int i=0;i<numCuposact;i++){
//										usuarioMatriculaService.eliminar(lstUsuarioMatriculaBean.get(0));
//										
//									}
//									
//									
//								}
//								
//								
//							}else{
//								
//
//								
//								
//								UsuarioMatriculaBean usuMateAgregar = new UsuarioMatriculaBean();
//								
//								
//								usuMateAgregar.setInscripcionLenguaBean(insLen);
//								usuMateAgregar.getSituacion().setCodigoRegistro(2);
//								
//									int numCuposact = Integer.valueOf(insLen.getNumeroCuposInsc()) - Integer.valueOf(inscripcionLenguaBean.getNumeroCuposInsc());
//									
//									
//									for(int i=0;i<numCuposact;i++){
//										usuarioMatriculaService.insertar(usuMateAgregar);
//										
//									}
//									
//
//								
//								
//							}
//
//							
//							
//							
//						
//							
//							
//							
//							
//						}else{
//							cant="4";
//						}

						
						
						
					}else{
						cant="3";
					}
					

					
					
				}

			} catch (Exception e) { 
				return "0";
			}

			if (sw) {
				if (cant=="1") {
					System.out.println("cant 1 " + cant);
					return "1";
				}else if (cant=="2"){
					System.out.println("cant 2 " + cant);
					return "2";
					
				}else if (cant=="3"){
					System.out.println("cant 3 " + cant);
					return "3";
					
				}else if (cant=="4"){
					System.out.println("cant 4 " + cant);
					return "4";
					
				}else {
					System.out.println("cant 0 " + cant);
					return "0";
				}
				
			} else {
				return "0";
			}
		
			

		}
		
		@RequestMapping(value = "/recargarListadoxInscripcion", method = RequestMethod.GET)
		public ModelAndView recargarListadoxInscripcion(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarListadoxInscripcion " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-inscripcion");
		
			cargarInscripcionXLengua(mav,codigo);
			return mav;
		}
		
		@RequestMapping(value = "/recargarListadoDetalleDocumentoInscripcion", method = RequestMethod.GET)
		public ModelAndView recargarListadoDetalleDocumentoInscripcion(@RequestParam("codigo") Integer codigo) {

			System.out.println("recargarListadoDetalleDocumentoInscripcion codigo " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-documento-inscripcion");
		
			listarDetalleDocumInscri(mav,codigo);
			return mav;
		}
		
		@RequestMapping(value = "/modificarInscripcionxLengua", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doModificarInscripcionxLengua(@RequestParam("codigo") Integer codigo,@RequestParam("codigoinst") Integer codigoinst) {

			System.out.println("codigo " + codigo);
			System.out.println("codigoinst " + codigoinst);
			InstitucionBean inscripcionaBean = new InstitucionBean();
			inscripcionaBean.setCodigo(codigoinst);
			List<LenguaBean> lstlenguaBean = new ArrayList<LenguaBean>();
			List<MaestraBean> lstnivelbean = new ArrayList<MaestraBean>();
		/*	try {
				lstlenguaBeanCombo = lenguaService.listarComboxInstitucion(inscripcionaBean);
				if (VO.isNotEmptyList(lstlenguaBeanCombo)) {
					System.out.println("lstlenguaBeanCombo.size() " +lstlenguaBeanCombo.size());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			InscripcionLenguaBean inle =  new InscripcionLenguaBean();
			inle.setCodigo(codigo);
			try {
				lstNivel  = maestra2Service.listarPorCodigoTabla("nivel",1);
				inle= inscripcionLenguaService.getBuscarPorObjecto(inle);
				
				LenguaBean oLengua= lenguaService.getBuscarPorObjecto(inle.getLenguainscr());
				System.out.println("inle.getLenguainscr() " + inle.getLenguainscr().getCodigo());
				
				System.out.println(oLengua.getNombre());
				lstlenguaBean.add(oLengua);
				lstnivelbean.add(inle.getNivel());
				
				
				setInscripcionLenguaBean(inle);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			swcod="1";
			System.out.println("inscripcionLenguaBean.getCodigo() mod " + inscripcionLenguaBean.getCodigo());
			ModelAndView mav = new ModelAndView("../layout/inscripcion-lengua-registro-modal-view", "command", inscripcionLenguaBean);
			mav.addObject("inscripcionLenguaBean", inscripcionLenguaBean);
			mav.addObject("lstlenguaBeanCombo", lstlenguaBean);
			mav.addObject("swcod", swcod);
			mav.addObject("lstnivelbean",lstnivelbean);
			return mav;
		}
	
		@RequestMapping(value ="/eliminarInscripcionxLengua", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarInscripcionxLengua(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			inscripcionLenguaBean= new InscripcionLenguaBean();
			inscripcionLenguaBean.setCodigo(codigo);
			System.out.println("codigocodigocodigo eliminar " + codigo);
		
			try { 
				this.setAuditoria(inscripcionLenguaBean, request, false);
			sw =  (this.inscripcionLenguaService.eliminar(inscripcionLenguaBean));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				inscripcionLenguaBean.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
		
		@RequestMapping(value ="/eliminarDetalleDocumentoInscripcion", method = RequestMethod.POST)
		@ResponseBody
		public String doeliminarDetalleDocumentoInscripcion(@RequestParam("codigo")Integer codigo,@RequestParam("nombArch")String nombArch,HttpServletRequest request){
			boolean sw=false;
			 documentoInscripcionBean= new DocumentoInscripcionBean();
			 documentoInscripcionBean.setCodigo(codigo);
			System.out.println("codigo eliminarDetalleDocumentoInscripcion " + codigo);
			System.out.println("nombArch " +nombArch);
		
			try { 
				this.setAuditoria(documentoInscripcionBean, request, false);
			sw =  (this.documentoInscripcionService.eliminar(documentoInscripcionBean));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				documentoInscripcionBean.setCodigo(0);
				eliminarArchivo(getRootPath(), nombArch);
				return "1";		
			}else {
				return "0";
			}
			
		}
	
		@RequestMapping(value = "/cargarNivelesIns", method = RequestMethod.GET)
		public @ResponseBody List<MaestraBean> cargarNiveles(@RequestParam("codlengua") String codigo)throws Exception {
		
			List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
			if (!codigo.equals("0")){
				LenguaBean filtro = new LenguaBean();
				filtro.setCodigo(VO.toLong(codigo));
				List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarNiveles(filtro);
			
				if(!VO.isEmptyList(lstLenguaEstructuraBeanNivel)){
					for (LenguaEstructuraBean objLenEstNivel : lstLenguaEstructuraBeanNivel) {
						if(!VO.isEmptyList(lstNivel)){
							for (MaestraBean objMaestroNivel : lstNivel) {
								if(objMaestroNivel.getCodigoRegistro() == objLenEstNivel.getNivel().getCodigoRegistro()){
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
		
	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public InscripcionBean getInscripcionaBean() {
		return inscripcionaBean;
	}

	public void setInscripcionaBean(InscripcionBean inscripcionaBean) {
		this.inscripcionaBean = inscripcionaBean;
	}

	public List<InscripcionBean> getLstInscripcionBean() {
		return lstInscripcionBean;
	}

	public void setLstInscripcionBean(List<InscripcionBean> lstInscripcionBean) {
		this.lstInscripcionBean = lstInscripcionBean;
	}
	
	 public void setValoresPredeterminados(InscripcionBean inscripcionaBean){
		 inscripcionaBean.getInstitucion().setCodigo(0); 
		 inscripcionaBean.getSituacion().setCodigoRegistro(0);
	    }

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public List<InstitucionBean> getLstInstitucionBean() {
		return lstInstitucionBean;
	}

	public void setLstInstitucionBean(List<InstitucionBean> lstInstitucionBean) {
		this.lstInstitucionBean = lstInstitucionBean;
	}

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstPeriodo() {
		return lstPeriodo;
	}

	public void setLstPeriodo(List<MaestraBean> lstPeriodo) {
		this.lstPeriodo = lstPeriodo;
	}

	public List<MaestraBean> getLstCiclo() {
		return lstCiclo;
	}

	public void setLstCiclo(List<MaestraBean> lstCiclo) {
		this.lstCiclo = lstCiclo;
	}


	public List<LenguaBean> getLstlenguaBeanCombo() {
		return lstlenguaBeanCombo;
	}

	public void setLstlenguaBeanCombo(List<LenguaBean> lstlenguaBeanCombo) {
		this.lstlenguaBeanCombo = lstlenguaBeanCombo;
	}

	public InscripcionForm getInscripcionForm() {
		return inscripcionForm;
	}

	public void setInscripcionForm(InscripcionForm inscripcionForm) {
		this.inscripcionForm = inscripcionForm;
	}

	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public DocumentoInscripcionBean getDocumentoInscripcionBean() {
		return documentoInscripcionBean;
	}

	public void setDocumentoInscripcionBean(DocumentoInscripcionBean documentoInscripcionBean) {
		this.documentoInscripcionBean = documentoInscripcionBean;
	}


 

}
