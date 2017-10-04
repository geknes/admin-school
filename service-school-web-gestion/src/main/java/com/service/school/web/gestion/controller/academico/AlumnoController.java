package com.service.school.web.gestion.controller.academico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.StoredProcedureQuery;
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
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.configuracion.MascotaBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.generico.PersonaLenguaBean;
import com.service.school.core.bean.bean.generico.PersonaNacionalidadBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.AlumnoService;
import com.service.school.core.service.service.interfaces.general.InstitucionService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.core.service.service.interfaces.general.PersonaLenguaService;
import com.service.school.core.service.service.interfaces.general.PersonaNacionalidadService;
import com.service.school.core.service.service.interfaces.general.PersonaService;
import com.service.school.core.service.service.interfaces.general.UbigeoService;
import com.service.school.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "alumnoController")
public class AlumnoController extends BaseController {


	protected UsuarioBean usuarioBean;
	
	private AlumnoBean 			alumnoBean;
	private List<AlumnoBean> 	lstAlumnoBean;


	private List<MaestraBean>	lstSituacion,lstTipoDocumento,lstNacionalidad,lstSexo;
	private List<MaestraBean>	lstNivel,lstGrado,lstCarrera,lstTipoLengua,lstEstadoCivil;

	private UbigeoBean ubigeoBean;
	private List<UbigeoBean> lstRegion;
	private List<UbigeoBean> lstProvincia;
	private List<UbigeoBean> lstDistrito;

	private UbigeoBean ubigeoBeanIntitucion;
	private List<UbigeoBean> lstRegionInstitucion;
	private List<UbigeoBean> lstProvinciaInstitucion;
	private List<UbigeoBean> lstDistritoInstitucion;
	
	private List<InstitucionBean>	lstInstitucionBean;
	private List<LenguaBean> lstLenguaBean;

	private List<PersonaNacionalidadBean> lstPersonaNacionalidadBean;
	private List<PersonaLenguaBean> lstPersonaLenguaBean;
	/******************** Vo **********************/
	private List<String> listadoNacionalidadVo;
	private List<String> listadoLenguaVo;
	
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private Maestra1Service maestra1Service;
	@Autowired
	private Maestra2Service maestra2Service;
	@Autowired 
	private PersonaService personaService;
    @Autowired
	private InstitucionService	institucionService;
	@Autowired
	private LenguaService 	lenguaService;
	@Autowired
	private UbigeoService ubigeoService;
	

	@Autowired
	private PersonaLenguaService personaLenguaService;
	@Autowired
	private PersonaNacionalidadService personaNacionalidadService;
	
	public AlumnoController (){
		this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
		this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
	}


	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)throws Exception {
		return this.doListado(alumnoBean, request);
	}
	
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		/* UsuarioBean */
		alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		System.out.println("usuarioBean.getPersona().getCodigo():"+usuarioBean.getPersona().getCodigo());
		System.out.println("usuarioBean.getCodPerfilUsuSelec():"+String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		
		System.out.println("alumnoBean : "+alumnoBean);
		if (alumnoBean.getPersonaBean() == null) {
			alumnoBean.setPersonaBean(new PersonaBean());
			alumnoBean.getPersonaBean().setNombrePersona("");
			alumnoBean.getPersonaBean().setNumeroDocumento("");
		}
		if (alumnoBean.getInstitucionBean() == null) {
			alumnoBean.setInstitucionBean(new InstitucionBean());
			alumnoBean.getInstitucionBean().setNombreInstitucion("");
		}
		if (alumnoBean.getTm1Situacion() == null) {
			alumnoBean.setTm1Situacion(new MaestraBean());
			alumnoBean.getTm1Situacion().setCodigoRegistro(0);
		}
		PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
		personaNacionalidadBean.setPersonaBean(new PersonaBean());
		personaNacionalidadBean.getPersonaBean().setCodigo(0);
		alumnoBean.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
		alumnoBean.getLstPersonaNacionalidadBean().add(personaNacionalidadBean);
		
		ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
		mav.addObject("lstAlumnoBean", new ArrayList<AlumnoBean>());
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)
			throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		return this.getLista(alumnoBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		ModelAndView mav = new ModelAndView("academico/registro-alumno", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo,HttpServletRequest request) {

		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		AlumnoBean prmAlumnoBean = new AlumnoBean();
		prmAlumnoBean.setCodigo(codigo);
		
		try {
			prmAlumnoBean = this.getAlumnoService().getBuscarPorObjecto(prmAlumnoBean);
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		
		if (prmAlumnoBean != null) {
			//setear la lengua y la nacionalidad (old)
			prmAlumnoBean.getPersonaBean().getNacionalidad().setCodigoRegistro(0);
			prmAlumnoBean.getPersonaBean().getLenguaBean().setCodigo(0);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
			
			if(prmAlumnoBean.getPersonaBean().getFechaNac()!=null){
				String fechaConFormato = sdf.format(prmAlumnoBean.getPersonaBean().getFechaNac()); 
				
//				Date nuevaFecha=null;
//					nuevaFecha = sdf.parse(fechaConFormato);
				prmAlumnoBean.getPersonaBean().setStrFechaNac(fechaConFormato);
				System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmAlumnoBean.getPersonaBean().getStrFechaNac());
			}
			
//			if(prmAlumnoBean.getTm2Nivel()!=null){
//				try {
//					if (prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==1) {
//						lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno");
//					}else if(prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==2){
//						lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria");
//					}
//				} catch (ServiceException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			try {
				lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			// Setar los listados de nacionalidad y lengua
			this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
			this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
			
			System.out.println(prmAlumnoBean.getPersonaBean().getCodigo());
			/*********************************************/
			PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
			personaNacionalidadBean.setPersonaBean(new PersonaBean());
			personaNacionalidadBean.getPersonaBean().setCodigo(prmAlumnoBean.getPersonaBean().getCodigo());
			System.out.println("codigo de persona "+personaNacionalidadBean.getPersonaBean().getCodigo());
			//Obtener el listado de las nacionalidades
			try {
				this.lstPersonaNacionalidadBean = (List<PersonaNacionalidadBean>) this.getPersonaNacionalidadService().getBuscarPorCodigoPersona(personaNacionalidadBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			/**********************************************/
		    PersonaLenguaBean personaLenguaBean = new PersonaLenguaBean();
		    personaLenguaBean.setPersonaBean(new PersonaBean());
		    personaLenguaBean.getPersonaBean().setCodigo(prmAlumnoBean.getPersonaBean().getCodigo());
			System.out.println("codigo de persona "+personaLenguaBean.getPersonaBean().getCodigo());
			//Obtener el listado de las lenguas
			try {
				this.lstPersonaLenguaBean = (List<PersonaLenguaBean>) this.getPersonaLenguaService().getBuscarPorCodigoPersona(personaLenguaBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			//Almacenar las listas de nacionalidad y lenguas en alumno
			prmAlumnoBean.setLstPersonaNacionalidadBean(this.getLstPersonaNacionalidadBean());
			prmAlumnoBean.setLstPersonaLenguaBean(this.getLstPersonaLenguaBean());
//			System.out.println(prmAlumnoBean.getLstPersonaNacionalidadBean().size());
			System.out.println(":v");
			// VO
			listadoNacionalidadVo = new ArrayList<String>();
			listadoLenguaVo = new ArrayList<String>();
			
			if (prmAlumnoBean.getLstPersonaNacionalidadBean() != null	&&	prmAlumnoBean.getLstPersonaNacionalidadBean().size() > 0 ) {
				for (PersonaNacionalidadBean prmPersonaNacionalidadBean : prmAlumnoBean.getLstPersonaNacionalidadBean()) {
					listadoNacionalidadVo.add(String.valueOf(prmPersonaNacionalidadBean.getNacionalidad().getCodigo()));
					listadoNacionalidadVo.add(prmPersonaNacionalidadBean.getNacionalidad().getNombreCorto());
				}			
			}
			
			if (prmAlumnoBean.getLstPersonaLenguaBean() != null	&&	prmAlumnoBean.getLstPersonaLenguaBean().size() > 0 ) {
				for (PersonaLenguaBean prmPersonaLenguaBean : prmAlumnoBean.getLstPersonaLenguaBean()) {
					listadoLenguaVo.add(String.valueOf(prmPersonaLenguaBean.getLenguaBean().getCodigo()));
					listadoLenguaVo.add(prmPersonaLenguaBean.getLenguaBean().getNombre());
					listadoLenguaVo.add(String.valueOf(prmPersonaLenguaBean.getTipoLengua().getCodigo()));
					listadoLenguaVo.add(prmPersonaLenguaBean.getTipoLengua().getNombreCorto());
				}			
			}

			
			mav = new ModelAndView("academico/registro-alumno", "command", prmAlumnoBean);
			mav.addObject("alumnoBean", prmAlumnoBean);
			mav.addObject("listadoNacionalidadVo", listadoNacionalidadVo);
			mav.addObject("listadoLenguaVo", listadoLenguaVo);
			this.cargarUbigeoIntitucion(mav, prmAlumnoBean);
			this.cargarUbigeo(mav,prmAlumnoBean);
			this.cargarCombos(mav);
		}else{//Encaso quieran ingresar por la url se redireciona a listado.
			/* UsuarioBean */
			prmAlumnoBean = new AlumnoBean();
			prmAlumnoBean.setCodigo(0);
			prmAlumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			prmAlumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			mav = this.getLista(prmAlumnoBean);
			mav.addObject("swMensaje","0");
		}
		
		return mav;
		
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		
		boolean sw=false;
		alumnoBean= new AlumnoBean();
		alumnoBean.setCodigo(codigo);
		
		try { 
			this.setAuditoria(alumnoBean, request, false);
			sw =  (this.getAlumnoService().eliminar(alumnoBean));  
			System.out.println("sw es : "+sw);
		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		this.setValoresPredeterminados(alumnoBean);
		
		/* UsuarioBean */
		alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		ModelAndView mav = this.getLista(alumnoBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.GET)
	public ModelAndView doGrabarListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)throws Exception {
		return this.doListado(alumnoBean, request);
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request) {
		
		//Obtener la sesion
		HttpSession session = request.getSession();
		//Obtener el usuario Bean
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		PersonaBean prmPersona = new PersonaBean();
		
		boolean sw = false;
		try {
			//Si codigo alumno es igual a cero entonces guarda nuevos datos
			if (alumnoBean.getCodigo() == 0) {/*** nuevo ***/
				prmPersona = alumnoBean.getPersonaBean();
				//Buscar si la persona ya existe por Tipo de documento y numero de documento
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				//Si persona es igual a null es que ya existe
				if(prmPersona==null){
					
					prmPersona= alumnoBean.getPersonaBean();
					
					prmPersona.setCodigoUbigeo(alumnoBean.getUbigeoBean().getCodigoRegion()+alumnoBean.getUbigeoBean().getCodigoProvincia()+alumnoBean.getUbigeoBean().getCodigoDistrito());
					alumnoBean.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoRegion()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoProvincia()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoDistrito());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					if(alumnoBean.getPersonaBean().getStrFechaNac()!=null){
						Date fechaConFormato = sdf.parse(alumnoBean.getPersonaBean().getStrFechaNac().toString()); 
//						
						prmPersona.setFechaNac(fechaConFormato);
						
					}
					/************************************************/
					sw = (this.getPersonaService().insertar(prmPersona));
					alumnoBean.setPersonaBean(prmPersona);
				}
				
				// almacenar los datos de las Nacionalidades y Leguas
				alumnoBean.setLstPersonaNacionalidadBean(this.lstPersonaNacionalidadBean);
				alumnoBean.setLstPersonaLenguaBean(this.lstPersonaLenguaBean);
				// Insertar datos al alumno
				/**************************************************/
				this.setAuditoria(alumnoBean, request, true);
				sw =  (this.getAlumnoService().insertar(alumnoBean));
				/****************************************************/
				//insertar las nacionalidad
				if (alumnoBean.getLstPersonaNacionalidadBean() != null && alumnoBean.getLstPersonaNacionalidadBean().size() != 0) {
					for (PersonaNacionalidadBean personaNacionalidadBean : alumnoBean.getLstPersonaNacionalidadBean()) {
						personaNacionalidadBean.setPersonaBean(new PersonaBean());
						personaNacionalidadBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
						this.setAuditoria(personaNacionalidadBean, request, true);
						sw = (this.getPersonaNacionalidadService().insertar(personaNacionalidadBean));
					}
				}
				/****************************************************/
				//insertar las lenguas
				if (alumnoBean.getLstPersonaLenguaBean() != null && alumnoBean.getLstPersonaLenguaBean().size() != 0) {
					//for (int i = 0; i < alumnoBean.getLstPersonaLenguaBean().size(); i++) {
					for (PersonaLenguaBean personaLenguaBean : alumnoBean.getLstPersonaLenguaBean()) {
						personaLenguaBean.setPersonaBean(new PersonaBean());
						personaLenguaBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
						this.setAuditoria(personaLenguaBean, request, true);
						sw = (this.getPersonaLenguaService().insertar(personaLenguaBean));
					}
				}
				
			} else {/** modificar **/
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(alumnoBean.getPersonaBean().getStrFechaNac()!=null){
					Date fechaConFormato = sdf.parse(alumnoBean.getPersonaBean().getStrFechaNac().toString()); 
					prmPersona.setFechaNac(fechaConFormato);
					alumnoBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
				}
				
				alumnoBean.getPersonaBean().setCodigoUbigeo(alumnoBean.getUbigeoBean().getCodigoRegion()+alumnoBean.getUbigeoBean().getCodigoProvincia()+alumnoBean.getUbigeoBean().getCodigoDistrito());
				alumnoBean.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoRegion()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoProvincia()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoDistrito());
				
				this.setAuditoria(alumnoBean, request, false);
				sw =  (this.getAlumnoService().actualizar(alumnoBean));

				System.out.println("alumnoBean.getPersonaBean().getCodigo():"+alumnoBean.getPersonaBean().getCodigo());

				/**********************************************************************/
				//Nacionalidad y Lengua
				List<PersonaNacionalidadBean> lstPersonaNacionalidadBeanEliminar = new ArrayList<PersonaNacionalidadBean>();
				List<PersonaLenguaBean> lstPersonaLenguaBeanEliminar = new ArrayList<PersonaLenguaBean>();
				/************* inicio nacionalidad *****************************/
				if (listadoNacionalidadVo != null	&&	listadoNacionalidadVo.size() > 0 ) {
					for (int i = 0; i < listadoNacionalidadVo.size();i=i+2) {
						boolean seEliminoNacionalidad = true;
						PersonaNacionalidadBean  prmPersonaNacionalidadBeanEliminar;
						for (PersonaNacionalidadBean nacionalidadBean : this.lstPersonaNacionalidadBean) {

							System.out.println(listadoNacionalidadVo.get(i).trim()+"  vs  "+String.valueOf(nacionalidadBean.getNacionalidad().getCodigo()).trim());
							if (listadoNacionalidadVo.get(i).trim().equals(String.valueOf(nacionalidadBean.getNacionalidad().getCodigo()).trim())) {
								seEliminoNacionalidad = false;
							}
							
						}
						
						if (seEliminoNacionalidad) {
							//Se eliminar esa nacionalidad
							prmPersonaNacionalidadBeanEliminar = new PersonaNacionalidadBean();
							
							prmPersonaNacionalidadBeanEliminar.setPersonaBean(new PersonaBean());
							prmPersonaNacionalidadBeanEliminar.setNacionalidad(new MaestraBean());
								
							prmPersonaNacionalidadBeanEliminar.getNacionalidad().setCodigo(Long.parseLong(listadoNacionalidadVo.get(i)));
							prmPersonaNacionalidadBeanEliminar.getNacionalidad().setNombreCorto(listadoNacionalidadVo.get(i+1));
							lstPersonaNacionalidadBeanEliminar.add(prmPersonaNacionalidadBeanEliminar);
							
						}
					}
						
				}
				System.out.println("Datos nuevos");
				if (this.lstPersonaNacionalidadBean != null && this.lstPersonaNacionalidadBean.size() != 0) {
					for (PersonaNacionalidadBean nacionalidadBean : this.lstPersonaNacionalidadBean) {
						nacionalidadBean.setPersonaBean(new PersonaBean());
						nacionalidadBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
						this.setAuditoria(nacionalidadBean, request, true);
						sw = (this.getPersonaNacionalidadService().insertar(nacionalidadBean));
						
					}//System.out.println(this.lstPersonaNacionalidadBean);
				}
				System.out.println("Fin");
				
				System.out.println("Datos Eliminar");
				for (PersonaNacionalidadBean nacionalidadBean : lstPersonaNacionalidadBeanEliminar) {
					nacionalidadBean.setPersonaBean(new PersonaBean());
					nacionalidadBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
					this.setAuditoria(nacionalidadBean, request, false);
					sw = (this.getPersonaNacionalidadService().eliminar(nacionalidadBean));
				
				}//System.out.println(this.lstPersonaNacionalidadBean);
				/************* fin nacionalidad *****************************/
				/**********************************************************************/
				/************* inicio lengua *****************************/
				if (listadoLenguaVo != null	&&	listadoLenguaVo.size() > 0 ) {
					for (int i = 0; i < listadoLenguaVo.size();i=i+4) {
						boolean seEliminolistadoLenguaVo = true;
						PersonaLenguaBean  prmPersonaLenguaBeanEliminar;
						for (PersonaLenguaBean personaLenguaBean : this.lstPersonaLenguaBean) {

							System.out.println(listadoLenguaVo.get(i).trim()+"  vs  "+String.valueOf(personaLenguaBean.getLenguaBean().getCodigo()).trim());
//							if (listadoLenguaVo.get(i).trim().equals(String.valueOf(personaLenguaBean.getLenguaBean().getCodigo()).trim())) {
//								seEliminolistadoLenguaVo = false;
//							}
							if(listadoLenguaVo.get(i).trim().equals(String.valueOf(personaLenguaBean.getLenguaBean().getCodigo()).trim()) && (listadoLenguaVo.get(i+2).trim().equals(String.valueOf(personaLenguaBean.getTipoLengua().getCodigo()).trim()))){
								seEliminolistadoLenguaVo = false;
							}
						}
						
						if (seEliminolistadoLenguaVo) {
							//Se eliminar esa nacionalidad
							prmPersonaLenguaBeanEliminar = new PersonaLenguaBean();
							
							prmPersonaLenguaBeanEliminar.setPersonaBean(new PersonaBean());
							prmPersonaLenguaBeanEliminar.setLenguaBean(new LenguaBean());
							prmPersonaLenguaBeanEliminar.setTipoLengua(new MaestraBean());
							
							prmPersonaLenguaBeanEliminar.getLenguaBean().setCodigo(Long.parseLong(listadoLenguaVo.get(i)));
							prmPersonaLenguaBeanEliminar.getLenguaBean().setNombre(listadoLenguaVo.get(i+1));
							
							prmPersonaLenguaBeanEliminar.getTipoLengua().setCodigo(Long.parseLong(listadoLenguaVo.get(i+2)));
							prmPersonaLenguaBeanEliminar.getTipoLengua().setNombreCorto(listadoLenguaVo.get(i+3));
							
							lstPersonaLenguaBeanEliminar.add(prmPersonaLenguaBeanEliminar);
							
						}
					}
						
				}
				
				if (this.lstPersonaLenguaBean != null && this.lstPersonaNacionalidadBean.size() != 0) {
					for (PersonaLenguaBean personaLenguaBean : this.lstPersonaLenguaBean) {
						personaLenguaBean.setPersonaBean(new PersonaBean());
						personaLenguaBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
						this.setAuditoria(personaLenguaBean, request, true);
						sw = (this.getPersonaLenguaService().insertar(personaLenguaBean));
						
						
					}//System.out.println(this.lstPersonaNacionalidadBean);
				}
				System.out.println("Fin");
				
				System.out.println("Datos Eliminar");
				for (PersonaLenguaBean lenguaBean : lstPersonaLenguaBeanEliminar) {
					lenguaBean.setPersonaBean(new PersonaBean());
					lenguaBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
					this.setAuditoria(lenguaBean, request, false);
					sw = (this.getPersonaLenguaService().eliminar(lenguaBean));
				}
				/************* fin lengua *****************************/
			}

		} catch (Exception e) { 
			sw = false;
			e.printStackTrace();
		}

		if (sw) {
			alumnoBean = new AlumnoBean() ;
			/* UsuarioBean */
			alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			
			//return this.getLista(alumnoBean);
			ModelAndView mav = this.getLista(alumnoBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}

	private ModelAndView getLista(AlumnoBean alumnoBean) {
		//List<AlumnoBean> lstAlumnoBean = null
		List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
		try {
			//modificar despues
			lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean);
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
		System.out.println("lstAlumnoBean "+lstAlumnoBean);
		mav.addObject("lstAlumnoBean", lstAlumnoBean);
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}
	
	private void cargarUbigeo(ModelAndView mav,AlumnoBean alumnoBean){

		ubigeoBean = new UbigeoBean();
		if(alumnoBean!=null){
			ubigeoBean = alumnoBean.getUbigeoBean();
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
	
	private void cargarUbigeoIntitucion(ModelAndView mav,AlumnoBean alumnoBean){
		
		ubigeoBeanIntitucion = new UbigeoBean();
		if(alumnoBean!=null){
			ubigeoBeanIntitucion = alumnoBean.getInstitucionBean().getUbigeoBean();
		}
		
		try {
			lstRegionInstitucion = this.getUbigeoService().listarRegion();
			lstProvinciaInstitucion = this.getUbigeoService().listarProvincia(ubigeoBeanIntitucion);
			lstDistritoInstitucion = this.getUbigeoService().listarDistrito(ubigeoBeanIntitucion);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}		
	
		
		mav.addObject("lstRegionInstitucion",lstRegionInstitucion); 
		mav.addObject("lstProvinciaInstitucion",lstProvinciaInstitucion);
		mav.addObject("lstDistritoInstitucion",lstDistritoInstitucion); 
	}
	
	private void cargarCombos(ModelAndView mav){

		LenguaBean lenguaBean = new LenguaBean();
		ubigeoBean = new UbigeoBean();
		
		if (usuarioBean!=null){
			try {
				//lstInstitucionBean = institucionService.getListarCombo(inst);
				this.lstInstitucionBean = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
				
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionAlumno",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
				lstSexo = maestra2Service.listarPorCodigoTabla("sexo",0);
				lstLenguaBean = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
				//lstNivel = maestra2Service.listarPorCodigoTabla("nivelAlumno");
				lstTipoLengua = maestra1Service.listarPorCodigoTabla("tipoLengua",0);
				lstGrado = maestra2Service.listarPorCodigoTabla("grado",0);
				lstCarrera = maestra2Service.listarPorCodigoTabla("carreraAlumno",0);
				lstEstadoCivil = maestra2Service.listarPorCodigoTabla("estadoCivil",0);
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad);
		mav.addObject("lstSexo",lstSexo); 
		mav.addObject("lstInstitucionBean",lstInstitucionBean); 
		mav.addObject("lstLenguaBean",lstLenguaBean); 
		
		mav.addObject("lstNivel",lstNivel); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCarrera",lstCarrera); 
		mav.addObject("lstTipoLengua",lstTipoLengua); 
		mav.addObject("lstEstadoCivil",lstEstadoCivil); 
		
	}
	
	@RequestMapping(value = "/buscarGrado", method = RequestMethod.GET)
	public @ResponseBody  List<MaestraBean> doBuscarGrado(@RequestParam("codigonivel") String codigo)throws Exception {
		List<MaestraBean> prmGrado = new ArrayList<MaestraBean>();
			if (codigo.equals("1")) {
				prmGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno",0);
			}else if(codigo.equals("2")){
				prmGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria",0);
			}
		return prmGrado;
	}
	

	@RequestMapping(value = "/validaralumno", method = RequestMethod.POST)
	public @ResponseBody AlumnoBean validarAlumno(@RequestParam("numerodocumento") String numeroDocumento) {
		
		AlumnoBean alumnoBean2 = new AlumnoBean();
		/* UsuarioBean */
		alumnoBean2.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean2.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		alumnoBean2.getPersonaBean().setNumeroDocumento(numeroDocumento);
		
		AlumnoBean alum = new AlumnoBean();
		lstAlumnoBean = new ArrayList<AlumnoBean>();
		try {
			lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean2);
			
			if(lstAlumnoBean!=null){
				lstAlumnoBean.get(0).setAudTipo("0");
				lstAlumnoBean.get(0).setAudCodigoUsuario(0);
				
				alum = this.getAlumnoService().getBuscarPorObjecto(lstAlumnoBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*********************************************/
		PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
		personaNacionalidadBean.setPersonaBean(new PersonaBean());
		personaNacionalidadBean.getPersonaBean().setCodigo(alum.getPersonaBean().getCodigo());
		System.out.println("codigo de persona "+personaNacionalidadBean.getPersonaBean().getCodigo());
		//Obtener el listado de las nacionalidades
		try {
			this.lstPersonaNacionalidadBean = (List<PersonaNacionalidadBean>) this.getPersonaNacionalidadService().getBuscarPorCodigoPersona(personaNacionalidadBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		/**********************************************/
	    PersonaLenguaBean personaLenguaBean = new PersonaLenguaBean();
	    personaLenguaBean.setPersonaBean(new PersonaBean());
	    personaLenguaBean.getPersonaBean().setCodigo(alum.getPersonaBean().getCodigo());
		System.out.println("codigo de persona "+personaLenguaBean.getPersonaBean().getCodigo());
		//Obtener el listado de las lenguas
		try {
			this.lstPersonaLenguaBean = (List<PersonaLenguaBean>) this.getPersonaLenguaService().getBuscarPorCodigoPersona(personaLenguaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		//Almacenar las listas de nacionalidad y lenguas en alumno
		alum.setLstPersonaNacionalidadBean(this.getLstPersonaNacionalidadBean());
		alum.setLstPersonaLenguaBean(this.getLstPersonaLenguaBean());
//		System.out.println(prmAlumnoBean.getLstPersonaNacionalidadBean().size());
		
		
		return alum;

	}
	
	@RequestMapping(value = "/refrescarLengua", method = RequestMethod.GET)
	public @ResponseBody String refrescarLengua(@RequestParam("listadoLengua") List<String> listadoLengua) {
		
		System.out.println("----------------------");
		System.out.println(listadoLengua);
		
		this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
	    
		PersonaLenguaBean  personaLenguaBean;
		// TODO Auto-generated catch block
		
//		this.alumnoBean.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
		if (listadoLengua != null && listadoLengua.size() != 0) {
			System.out.println("cantidad : "+listadoLengua.size());
			for (int i = 0; i < listadoLengua.size();i=i+4) {
				
				personaLenguaBean = new PersonaLenguaBean();
				personaLenguaBean.setPersonaBean(new PersonaBean());
				personaLenguaBean.setLenguaBean(new LenguaBean());
				personaLenguaBean.setTipoLengua(new MaestraBean());
				
				personaLenguaBean.getLenguaBean().setCodigo(Long.parseLong(listadoLengua.get(i)));
				personaLenguaBean.getLenguaBean().setNombre(listadoLengua.get(i+1));
				
				personaLenguaBean.getTipoLengua().setCodigo(Long.parseLong(listadoLengua.get(i+2)));
				personaLenguaBean.getTipoLengua().setNombreCorto(listadoLengua.get(i+3));
				this.lstPersonaLenguaBean.add(personaLenguaBean);
				/*
				System.out.println("codigo Legunda "+listadoLengua.get(i));
				System.out.println("nombre lengua "+listadoLengua.get(i+1));
				System.out.println("codgio tipo lengua "+listadoLengua.get(i+2));
				System.out.println("tipo lengua "+listadoLengua.get(i+3));
				*/
			}
			System.out.println(this.lstPersonaLenguaBean);
		}
		
		return "1";

	}
	
	@RequestMapping(value = "/refrescarNacionalidad", method = RequestMethod.GET)
	public @ResponseBody String refrescarNacionalidad(@RequestParam("listadoNacionalidad") List<String> listadoNacionalidad) {

		// TODO Auto-generated catch block
		System.out.println("----------------------");
		System.out.println(listadoNacionalidad);
		this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
		
		PersonaNacionalidadBean  personaNacionalidadBean;
		
		if (listadoNacionalidad != null && listadoNacionalidad.size() != 0) {
			for (int i = 0; i < listadoNacionalidad.size();i=i+2) {
				
				personaNacionalidadBean = new PersonaNacionalidadBean();
				personaNacionalidadBean.setPersonaBean(new PersonaBean());
				personaNacionalidadBean.setNacionalidad(new MaestraBean());
					
				System.out.println("codigo Nacionalidad "+listadoNacionalidad.get(i));
				System.out.println("nombre Nacionalidad "+listadoNacionalidad.get(i+1));
				personaNacionalidadBean.getNacionalidad().setCodigo(Long.parseLong(listadoNacionalidad.get(i)));
				personaNacionalidadBean.getNacionalidad().setNombreCorto(listadoNacionalidad.get(i+1));
				this.lstPersonaNacionalidadBean.add(personaNacionalidadBean);
			}
		}
		return "1";

	}
	
	public PersonaService getPersonaService() {
		return personaService;
	}
	
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	public AlumnoBean getAlumnoBean() {
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public List<AlumnoBean> getLstAlumnoBean() {
		return lstAlumnoBean;
	}

	public void setLstAlumnoBean(List<AlumnoBean> lstAlumnoBean) {
		this.lstAlumnoBean = lstAlumnoBean;
	}

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public void setAlumnoService(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}
	
	
	
	public InstitucionService getInstitucionService() {
		return institucionService;
	}
	
	public List<PersonaNacionalidadBean> getLstPersonaNacionalidadBean() {
		return lstPersonaNacionalidadBean;
	}

	public void setLstPersonaNacionalidadBean(
			List<PersonaNacionalidadBean> lstPersonaNacionalidadBean) {
		this.lstPersonaNacionalidadBean = lstPersonaNacionalidadBean;
	}

	public List<PersonaLenguaBean> getLstPersonaLenguaBean() {
		return lstPersonaLenguaBean;
	}

	public void setLstPersonaLenguaBean(List<PersonaLenguaBean> lstPersonaLenguaBean) {
		this.lstPersonaLenguaBean = lstPersonaLenguaBean;
	}

	
	
	public PersonaLenguaService getPersonaLenguaService() {
		return personaLenguaService;
	}

	public void setPersonaLenguaService(PersonaLenguaService personaLenguaService) {
		this.personaLenguaService = personaLenguaService;
	}

	public PersonaNacionalidadService getPersonaNacionalidadService() {
		return personaNacionalidadService;
	}

	public void setPersonaNacionalidadService(
			PersonaNacionalidadService personaNacionalidadService) {
		this.personaNacionalidadService = personaNacionalidadService;
	}

	public void setValoresPredeterminados(AlumnoBean alumnoBean){
		alumnoBean.setCodigo(0);
		alumnoBean.setPersonaBean(new PersonaBean());
		alumnoBean.getPersonaBean().setNombrePersona(""); 
		alumnoBean.setTm1Situacion(new MaestraBean());
		alumnoBean.getTm1Situacion().setCodigoRegistro(0);
	 }
	
}
