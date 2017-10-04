package com.service.school.web.gestion.controller.academico;

import java.rmi.ServerException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.academico.AlumnoBean;
import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.InscripcionBean;
import com.service.school.core.bean.bean.academico.InscripcionLenguaBean;
import com.service.school.core.bean.bean.academico.MatriculaAlumnoBean;
import com.service.school.core.bean.bean.academico.MatriculaBean;
import com.service.school.core.bean.bean.academico.MatriculaDocenteBean;
import com.service.school.core.bean.bean.academico.UsuarioMatriculaBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
import com.service.school.core.bean.bean.generico.InstitucionLenguaBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.repository.exception.DAOException;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.academico.AlumnoService;
import com.service.school.core.service.service.interfaces.academico.DocenteService;
import com.service.school.core.service.service.interfaces.academico.InscripcionLenguaService;
import com.service.school.core.service.service.interfaces.academico.InscripcionService;
import com.service.school.core.service.service.interfaces.academico.MatriculaAlumnoService;
import com.service.school.core.service.service.interfaces.academico.MatriculaDocenteService;
import com.service.school.core.service.service.interfaces.academico.MatriculaService;
import com.service.school.core.service.service.interfaces.academico.UsuarioMatriculaService;
import com.service.school.core.service.service.interfaces.general.InstitucionLenguaService;
import com.service.school.core.service.service.interfaces.general.InstitucionService;
import com.service.school.core.service.service.interfaces.general.LenguaEstructuraService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.web.gestion.controller.academico.view.MatriculaForm;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.ResourceUtil;
import com.service.school.web.gestion.utilitarios.VO;

 
@Controller
@Scope(value="session")
@RequestMapping(value = "matriculaController")
public class MatriculaController extends BaseController {

	private MatriculaBean 			matriculaBeanG;
	
	private MatriculaBean 			matriculaBeanA;
	
	private InscripcionBean 		inscripcionBean;
	
	private DocenteBean 			docenteBean;
	
	private AlumnoBean 				alumnoBean;
	
	private List<DocenteBean> 		lstDocenteBean;
	
	private List<MatriculaBean> 	lstMatriculaBean;
	
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstnivel;
	private List<MaestraBean>		lstsubNivel;
	private List<MaestraBean>		lstEstadoMatricula;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;
	
	private List<MaestraBean>		lstTipoDocente;
	
	private List<InstitucionBean>	lstInstitucionBean;
	
	private List<LenguaBean> 		lstLenguaBean; 
	
	private List<MatriculaAlumnoBean>	lstmatriculaAlumno;
	
	@Autowired
	private MatriculaService 		matriculaService;
	
	@Autowired
	private Maestra1Service 		maestra1Service;
	
	@Autowired
	private Maestra2Service 		maestra2Service;
	
	@Autowired
	private InstitucionService		institucionService;
	
	@Autowired
	private InscripcionService		inscripcionService;
	
	@Autowired
	private InscripcionLenguaService	inscripcionLenguaService;
	
	@Autowired
	private LenguaService 			lenguaService;
	
	@Autowired
	private DocenteService 			docenteService;
	
	@Autowired
	private AlumnoService 			alumnoService;
	
	@Autowired
	private MatriculaAlumnoService 	matriculaAlumnoService;
	
	@Autowired
	private MatriculaDocenteService	matriculaDocenteService;
	
	@Autowired
	private InstitucionLenguaService institucionLenguaService;
	
	@Autowired
	private LenguaEstructuraService lenguaEstructuraService;
	
	/****************/
	@Autowired
	private UsuarioMatriculaService usuarioMatriculaService;
	
	/*****************/
	
	private MatriculaForm 			matriculaForm;
	
	private int codigoMat;
	
	@PostConstruct
	public void init(){
		this.setMatriculaBeanG(new MatriculaBean());
		this.setLstMatriculaBean(new ArrayList<MatriculaBean>());
		this.setInscripcionBean(new InscripcionBean());
		this.setLstDocenteBean(new ArrayList<DocenteBean>());
		this.setMatriculaForm(new MatriculaForm());
	}
	
	public MatriculaController (){
				
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("matriculaBean") MatriculaBean matriculaBean)throws Exception {
		//this.setValoresPredeterminados(matriculaBeanG);
		MatriculaBean prmMatriculaBean = new MatriculaBean();
		
		System.out.println("matriculaBean.getCodigo() " + matriculaBean.getInsti().getCodigo());
		prmMatriculaBean.getInsti().setCodigo(matriculaBean.getInsti().getCodigo());
		prmMatriculaBean.getLengua().setCodigo(matriculaBean.getLengua().getCodigo());
		prmMatriculaBean.getSituacion().setCodigoRegistro(matriculaBean.getSituacion().getCodigoRegistro());
		prmMatriculaBean.getNivel().setCodigoRegistro(matriculaBean.getNivel().getCodigoRegistro());
//		prmMatriculaBean.getSubNivel().setCodigoRegistro(1);
				
//		return this.getLista(prmMatriculaBean);
		ModelAndView mav = new ModelAndView("academico/listado-matricula", "command",matriculaBean);
		//System.out.println("lstMatriculaBean "+lstMatriculaBean);
		//mav.addObject("lstMatriculaBean", lstMatriculaBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		//this.cargarCombosLengua(mav);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("matriculaBean") MatriculaBean matriculaBean)	throws Exception {
		//this.setValoresPredeterminados(matriculaBeanG);
		MatriculaBean prmMatriculaBean = new MatriculaBean();
		
		System.out.println("matriculaBean.getInsti().getCodigo() " + matriculaBean.getInsti().getCodigo());
		System.out.println("matriculaBean.getLengua().getCodigo() " + matriculaBean.getLengua().getCodigo());
		System.out.println("matriculaBean.getNivel().getCodigoRegistro() " + matriculaBean.getNivel().getCodigoRegistro());
		prmMatriculaBean.getInsti().setCodigo(matriculaBean.getInsti().getCodigo());
		prmMatriculaBean.getLengua().setCodigo(matriculaBean.getLengua().getCodigo());
		prmMatriculaBean.getSituacion().setCodigoRegistro(matriculaBean.getSituacion().getCodigoRegistro());
		prmMatriculaBean.getNivel().setCodigoRegistro(matriculaBean.getNivel().getCodigoRegistro());
//		prmMatriculaBean.getSubNivel().setCodigoRegistro(1);
		return this.getLista(prmMatriculaBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("academico/registro-matricula", "command", new MatriculaForm());
		
//		docenteBean = new DocenteBean();
//		docenteBean.getInstitucionBean().setCodigo(3);
//		try {
//			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarxCodigoInstitucion(docenteBean);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		alumnoBean = new AlumnoBean();
//		alumnoBean.getTm1Situacion().setCodigoRegistro(1);
//		List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
//		try {
//			//modificar despues
//			lstAlumnoBean = (List<AlumnoBean>) this.alumnoService.getBuscarPorFiltros(alumnoBean);
//			
//			//System.out.println("lstAlumnoBean tamaño "+lstAlumnoBean.size());
//		} catch (Exception e) {
//			System.out.println("getLista " + e.getMessage());
//		}
//		
		

		mav.addObject("matriculaBean", new MatriculaBean());
		mav.addObject("matriculaDocenteBean", new MatriculaDocenteBean());
		mav.addObject("matriculaAlumnoBean", new MatriculaAlumnoBean());
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
		return mav;
	}
	
	@RequestMapping(value = "/nuevoModal", method = RequestMethod.GET)
	public ModelAndView doNuevoModal() {
		
		ModelAndView mav = new ModelAndView("../layout/docente-modal-view", "command",new MatriculaBean());
		
//		mav.addObject("lstMatriculaBean",lstMatriculaBean);
//		mav.addObject("matriculaBean", new MatriculaBean());
//		this.cargarCombos(mav);
//		this.cargarCombosInstitucion(mav);
//		this.cargarCombosLengua(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo ) {

		System.out.println("codigo " + codigo);

		MatriculaBean prmMatriculaBean = new MatriculaBean();
		prmMatriculaBean.setCodigo(codigo);
		try {
			matriculaBeanG = this.matriculaService.getBuscarPorObjecto(prmMatriculaBean);
			matriculaForm.setMatriculaBean(matriculaBeanG);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
				
		System.out.println("modificar matriculaBeanG: " + matriculaBeanG);
		
		ModelAndView mav = new ModelAndView("academico/registro-matricula", "command",matriculaForm);//matriculaBeanG
//		mav.addObject("matriculaBean", matriculaBeanG);
		mav.addObject("matriculaForm", matriculaForm);

		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
		System.out.println("matriculaForm.getMatriculaBean().getCodigo() " + matriculaForm.getMatriculaBean().getCodigo());
		cargarAlumnosDocenteXMatricula(mav,(int)matriculaForm.getMatriculaBean().getCodigo());
		cargarDocenteXMatricula(mav, (int)matriculaForm.getMatriculaBean().getCodigo());
		return mav;
	}
	
	@RequestMapping(value = "/obtenerNumCupos", method = RequestMethod.POST)
	@ResponseBody
	public String doObtenerNumCupos(@RequestParam("codigoinst") Integer codigoinst,@RequestParam("codigolengua") Integer codigolengua) {

		System.out.println("codigoinst " + codigoinst);		
		System.out.println("codigolengua " + codigolengua);
		String cantidad="";

		InscripcionBean prmInscripcionBean = new InscripcionBean();
		prmInscripcionBean.getInstitucion().setCodigo(codigoinst);
		prmInscripcionBean.getLengua().setCodigo(codigolengua);
		
		
		try {
			inscripcionBean = this.inscripcionService.getNumcuposXcodInstiCodLengua(prmInscripcionBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		if (inscripcionBean!=null && inscripcionBean.getNumCupos()!=null) {
			cantidad=inscripcionBean.getNumCupos();
			System.out.println("cantidad " +cantidad);
		}
	
		return cantidad;

	}
	
	@RequestMapping(value = "/obtenerInscripcionLenguaDetalle", method = RequestMethod.POST)
	public @ResponseBody InscripcionLenguaBean doObtenerInscripcionLenguaDetalle(@RequestParam("codigoDetalle") Integer codigoDetalle,HttpServletRequest request) {

		System.out.println("codigoDetalle obtenerInscripcionLenguaDetalle" + codigoDetalle);		
		
		InscripcionLenguaBean inscripcionLenguaBean= new InscripcionLenguaBean();

		InscripcionLenguaBean prmInscripcionBean = new InscripcionLenguaBean();
		prmInscripcionBean.setCodigo(codigoDetalle);
		
		try {
				inscripcionLenguaBean = this.inscripcionLenguaService.getBuscarPorObjectoDetalleMatricula(prmInscripcionBean);
			} catch (ServerException e) {				
				e.printStackTrace();
			}
		
		if (VO.isNotNull(inscripcionLenguaBean)){
			System.out.println("inscripcionLenguaBean::: " + inscripcionLenguaBean.getCodigo() + inscripcionLenguaBean.getInstitucion().getNombreInstitucion());
		}else{
			inscripcionLenguaBean=null;
		}
	
		return inscripcionLenguaBean;

	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		matriculaBeanG= new MatriculaBean();
		matriculaBeanG.setCodigo(codigo);
		System.out.println("codigocodigocodigo eliminar " + codigo);

		try { 
					   this.setAuditoria(matriculaBeanG, request, false);
				sw =  (this.matriculaService.eliminar(matriculaBeanG));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		matriculaBeanG.setCodigo(0);
		this.setValoresPredeterminados(matriculaBeanG);
		ModelAndView mav = this.getLista(matriculaBeanG);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("matriculaForm") MatriculaForm matriculaForm,HttpServletRequest request) {
		
		System.out.println("inscripcionBean "+matriculaForm);
		System.out.println("inscripcionBean.getCodigo() "+matriculaForm.getMatriculaBean().getCodigo());
		
		boolean sw = false;
		try {
			System.out.println("matriculaForm.getMatriculaBean().getInscripcionLenguaBean().getNumeroCuposDisp()) 111 " + matriculaForm.getMatriculaBean().getInscripcion().getNumCupos());
			if (Integer.valueOf(matriculaForm.getMatriculaBean().getInscripcion().getNumCupos())!=0) {//getInscripcionLenguaBean().getNumero
				if (matriculaForm.getMatriculaBean().getCodigo()==0) {
					
					System.out.println("insertar "+matriculaForm.getMatriculaBean());
						   this.setAuditoria(matriculaForm.getMatriculaBean(), request, true);
					sw =  (this.matriculaService.insertar(matriculaForm.getMatriculaBean())); 
						
					
				} else {
					System.out.println("actualizar "+matriculaForm.getMatriculaBean());
					System.out.println("matriculaForm.getMatriculaBean().getFlagEstado().getCodigoRegistro() " + matriculaForm.getMatriculaBean().getFlagEstado().getCodigoRegistro());
					   this.setAuditoria(matriculaForm.getMatriculaBean(), request, false);
					sw = (this.matriculaService.actualizar(matriculaForm.getMatriculaBean()));
				}
			}else {
				System.out.println("entro al else matriculaForm.getMatriculaBean().getvNumcuposrest()");
				sw= false;
				
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			System.out.println("matriculaForm.getMatriculaBean().getvNumcuposrest() 2 " + matriculaForm.getMatriculaBean().getvNumcuposrest());
			//actualizarNumCuposRestMatri((int)matriculaForm.getMatriculaBean().getCodigo(), matriculaForm.getMatriculaBean().getvNumcuposrest());
			MatriculaBean matriculaBeanInsr= null;
//			matriculaBean = new MatriculaBean() ;
//			this.setValoresPredeterminados(matriculaBeanG);
//			return this.getLista(matriculaBean);
			System.out.println("matriculaForm.getMatriculaBean().getCodigo() " +matriculaForm.getMatriculaBean().getCodigo());
			MatriculaBean prmMatriculaBean = new MatriculaBean();
			prmMatriculaBean.setCodigo(matriculaForm.getMatriculaBean().getCodigo());
			try {
				matriculaBeanInsr = this.matriculaService.getBuscarPorObjecto(prmMatriculaBean);
				matriculaForm.setMatriculaBean(matriculaBeanInsr);
				System.out.println("matriculaBeanInsrmatriculaBeanInsr " + matriculaForm.getMatriculaBean().getFlagMatricula());
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
		
			ModelAndView mav = new ModelAndView("academico/registro-matricula", "command",matriculaForm);
			System.out.println("matriculaForm.getMatriculaBean().getCodigo() " +matriculaForm.getMatriculaBean().getCodigo());
			mav.addObject("matriculaForm", matriculaForm);
			this.cargarCombos(mav);
			this.cargarCombosInstitucion(mav);
			this.cargarCombosLengua(mav);
			cargarAlumnosDocenteXMatricula(mav,(int)matriculaForm.getMatriculaBean().getCodigo());
			cargarDocenteXMatricula(mav, (int)matriculaForm.getMatriculaBean().getCodigo());
			//codigoMat= (int)matriculaForm.getMatriculaBean().getCodigo();
			mav.addObject("swMensaje",sw?"1":"0");
			
			
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-matricula", "command",new MatriculaForm());
			//this.setValoresPredeterminados(matriculaBeanG);
			mav.addObject("matriculaBean", new MatriculaBean());
			mav.addObject("matriculaDocenteBean", new MatriculaDocenteBean());
			mav.addObject("matriculaAlumnoBean", new MatriculaAlumnoBean());
			this.cargarCombos(mav);
			this.cargarCombosInstitucion(mav);
			this.cargarCombosLengua(mav);
			if (sw) {
				mav.addObject("swMensaje",sw?"1":"0");
			}else {
				mav.addObject("swMensajeNumCupos","1");
			}
			
			
			return mav;
			
		}


	}

	private ModelAndView getLista(MatriculaBean matriculaBean) {
		
		List<MatriculaBean> lstMatriculaBean =new ArrayList<MatriculaBean>(); 
		try {
			lstMatriculaBean = (List<MatriculaBean>) this.getMatriculaService().getBuscarPorFiltros(matriculaBean);
			System.out.println("lstMatriculaBean "+lstMatriculaBean.size());
		} catch (Exception e) {
			System.out.println("getLista lstMatriculaBean " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("academico/listado-matricula", "command",matriculaBean);
		System.out.println("lstMatriculaBean "+lstMatriculaBean);
		mav.addObject("lstMatriculaBean", lstMatriculaBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		//this.cargarCombosLengua(mav);
		return mav;
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
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionMatricula",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstnivel==null) {
			try {
				lstnivel = maestra2Service.listarPorCodigoTabla("nivel",1);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstsubNivel==null) {
			try {
				lstsubNivel = maestra2Service.listarPorCodigoTabla("subNivel",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}
		if (lstEstadoMatricula==null) {
				try {
					lstEstadoMatricula = maestra1Service.listarPorCodigoTabla("estadoMatricula",0);
					System.out.println("lstEstadoMatricula.size() " + lstEstadoMatricula.size());
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}	
		}
		if (lstPeriodo==null) {
			try {
				lstPeriodo = maestra2Service.listarPorCodigoTabla("periodo",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	
		}
		if (lstCiclo==null) {
			try {
				lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	
		}
		
		
		
		
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstsubNivel",lstsubNivel); 
		mav.addObject("lstnivel",lstnivel); 
		
		mav.addObject("lstEstadoMatricula",lstEstadoMatricula); 
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstCiclo",lstCiclo); 
		
	} 
	
	 public void setValoresPredeterminados(MatriculaBean matriculaBean){
		 matriculaBean.getInsti().setCodigo(0); 
		 matriculaBean.getLengua().setCodigo(0);
		 matriculaBean.getNivel().setCodigoRegistro(0);
		 matriculaBean.getSubNivel().setCodigoRegistro(0);
		 matriculaBean.getSituacion().setCodigoRegistro(0);
	    }
	
		@RequestMapping(value = "/listarDocenteCodigoInsti", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doListarDocenteCodigoInsti(@RequestParam("codigoinst") Integer codigoinst) {

			System.out.println("codigoinst " + codigoinst);	
			

			docenteBean = new DocenteBean();
			docenteBean.setInscripcionLenguaBean(new InscripcionLenguaBean());
			docenteBean.getInscripcionLenguaBean().setCodigo(codigoinst);
			try {
				lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarxCodigoInstitucion(docenteBean);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (lstTipoDocente==null) {
				try {
					lstTipoDocente = maestra2Service.listarPorCodigoTabla("TipoDocente",0);
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}	
			}
			
			ModelAndView mav = new ModelAndView("../layout/grupo-docente-modal-view", "command",docenteBean);
			mav.addObject("matriculaDocenteBean", new MatriculaDocenteBean());
			mav.addObject("lstDocenteBean", lstDocenteBean);
			mav.addObject("lstTipoDocente",lstTipoDocente); 
			return mav;
		}
		
		@RequestMapping(value = "/recargarListadoxInscripcionDetalle", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView recargarListadoxInscripcionDetalle(@RequestParam("codigoDInslen") Integer codigoDInslen, @RequestParam("nombre") String nombre, @RequestParam("numDocumento") String numDocumento) {

			System.out.println("codigoDInslen " + codigoDInslen);	
			System.out.println("nombre " + nombre);	
			System.out.println("numDocumento " + numDocumento);	
			
			DocenteBean	docenteBean = new DocenteBean();
			docenteBean.setInscripcionLenguaBean(new InscripcionLenguaBean());
			docenteBean.getInscripcionLenguaBean().setCodigo(codigoDInslen);
			docenteBean.getPersonaBean().setNombrePersona(nombre);
			docenteBean.getPersonaBean().setNumeroDocumento(numDocumento);
			try {
				lstDocenteBean = docenteService.getBuscarxCodigoInstitucionDetalleNombreDocum(docenteBean);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (lstTipoDocente==null) {
				try {
					lstTipoDocente = maestra2Service.listarPorCodigoTabla("TipoDocente",0);
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}	
			}
			if (VO.isNotEmptyList(lstDocenteBean)) {
					System.out.println("lstDocenteBean.size()asad " + lstDocenteBean.size());
					System.out.println("lstTipoDocente.size() " + lstTipoDocente.size());
			}
			ModelAndView mav = new ModelAndView("academico/listado-modal-detalle-matricula-docente", "command",docenteBean);
			mav.addObject("matriculaDocenteBean", new MatriculaDocenteBean());
			mav.addObject("lstDocenteBean", lstDocenteBean);
			mav.addObject("lstTipoDocente",lstTipoDocente); 
			//cargarInscripcionXLengua(mav,codigo);
			return mav;
		}
		
		@RequestMapping(value = "/cargarPopupListadoInstitucion", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doCargarPopupListadoInstitucion() {
			InscripcionLenguaBean prmInscripcionLengua = new InscripcionLenguaBean();
			List<InscripcionLenguaBean> lstInscripcionLenguaBean = new ArrayList<InscripcionLenguaBean>();
			
			try {
				lstInscripcionLenguaBean=inscripcionLenguaService.listarInscripcionLengua(prmInscripcionLengua);
				if (VO.isNotEmptyList(lstInscripcionLenguaBean)) {
					System.out.println("lstInscripcionLenguaBean.size() " + lstInscripcionLenguaBean.size());
				}
			} catch (ServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ModelAndView mav = new ModelAndView("../layout/listado-Inscripcion-detalle-modal-view");//, "command", new InscripcionLenguaBean()
			//mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean());
			mav.addObject("lstInscripcionLenguaBean",lstInscripcionLenguaBean); 
			return mav;
		}
		
		@RequestMapping(value = "/listarAlumnoCodigoInsti", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doListarAlumnoCodigoInsti(@RequestParam("codigoinst") Integer codigoinst,@RequestParam("codinscrlengua") Integer codinscrlengua,@RequestParam("tiponivel") Integer tiponivel, @RequestParam("nombrePerso") String nombrePerso) {
			System.out.println("------------------listarAlumnoCodigoInsti----------------------");
			System.out.println("codigoinst " + codigoinst);	
			System.out.println("codinscrlengua " + codinscrlengua);	
			System.out.println("nombrePerso " + nombrePerso);

			alumnoBean = new AlumnoBean();
			alumnoBean.getInstitucionBean().setCodigo(codigoinst);
			alumnoBean.setInscripcionLenguaBean(new InscripcionLenguaBean());
			alumnoBean.getInscripcionLenguaBean().setCodigo(codinscrlengua);
			alumnoBean.getPersonaBean().setNombrePersona(nombrePerso);
			List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
			try {
				
				lstAlumnoBean = (List<AlumnoBean>) this.alumnoService.getBuscarxCodigoInstitucion(alumnoBean);
				
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
			ModelAndView mav = new ModelAndView("../layout/alumno-modal-view", "command",alumnoBean);
			
			mav.addObject("lstAlumnoBean", lstAlumnoBean);
		
			return mav;
		}
		
		@RequestMapping(value = "/listarAlumnoCodigoInstiDetModalView", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doListarAlumnoCodigoInstiModalView(@RequestParam("codigoinst") Integer codigoinst,@RequestParam("codinscrlengua") Integer codinscrlengua,@RequestParam("tiponivel") Integer tiponivel, @RequestParam("nombrePerso") String nombrePerso) {
			System.out.println("------------------listarAlumnoCodigoInsti----------------------");
			System.out.println("codigoinst " + codigoinst);	
			System.out.println("codinscrlengua " + codinscrlengua);	
			System.out.println("nombrePerso " + nombrePerso);

			alumnoBean = new AlumnoBean();
			alumnoBean.getInstitucionBean().setCodigo(codigoinst);
			alumnoBean.setInscripcionLenguaBean(new InscripcionLenguaBean());
			alumnoBean.getInscripcionLenguaBean().setCodigo(codinscrlengua);
			alumnoBean.getPersonaBean().setNombrePersona(nombrePerso);
			List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
			try {
				
				lstAlumnoBean = (List<AlumnoBean>) this.alumnoService.getBuscarxCodigoInstitucion(alumnoBean);
				
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
			ModelAndView mav = new ModelAndView("academico/listado-modal-detalle-matricula-alumno", "command",alumnoBean);
			
			mav.addObject("lstAlumnoBean", lstAlumnoBean);
		
			return mav;
		}
	
		private void cargarAlumnosDocenteXMatricula(ModelAndView mav, int codigoMat){
			MatriculaAlumnoBean matAlum = new MatriculaAlumnoBean();
			matAlum.getMatriculaBean().setCodigo(codigoMat);
			List<MatriculaAlumnoBean>	lstMatriculaAlumnoBean=null;
		
				try {
					lstMatriculaAlumnoBean = matriculaAlumnoService.getBuscarMatriculaXAlumno(matAlum);
					if (VO.isNotEmptyList(lstMatriculaAlumnoBean)) {
						System.out.println(" lstMatriculaAlumnoBean "+ lstMatriculaAlumnoBean.size());
					}
					
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}		
		
	
			
			mav.addObject("lstmatriculaAlumno",lstMatriculaAlumnoBean); 
		
		} 
	
		@RequestMapping(value = "/LenguaxInstitucion", method = RequestMethod.GET)
		@ResponseBody
		public List<InstitucionLenguaBean> doLenguaxInstitucion(@RequestParam("codigoinst") String codigoinst) {

			System.out.println("codigoinst " + codigoinst);	
			//List<LenguaBean> lstLengua = new ArrayList<LenguaBean>();
			List<InstitucionLenguaBean> listaInstitucionLenguaBean = new ArrayList<InstitucionLenguaBean>();
			if (!codigoinst.equals("0")){
				InstitucionBean inscripcionaBean = new InstitucionBean();
				inscripcionaBean.setCodigo(Integer.valueOf(codigoinst));
				InstitucionLenguaBean oInstitucionLenguaBean = new InstitucionLenguaBean();
				oInstitucionLenguaBean.getInstitucionBean().setCodigo(Integer.valueOf(codigoinst));
				try {
					//lstLengua = lenguaService.listarComboxInstitucion(inscripcionaBean);//listarComboxInstitucion
					listaInstitucionLenguaBean =  institucionLenguaService.getBuscarPorFiltros(oInstitucionLenguaBean);
					if (VO.isNotEmptyList(listaInstitucionLenguaBean)) {
						System.out.println("listaInstitucionLenguaBean.size() " +listaInstitucionLenguaBean.size());
					}else {
						listaInstitucionLenguaBean=null;
					}
				} catch (ServiceException e) {
					
					e.printStackTrace();
				}
			}
		
	
			return listaInstitucionLenguaBean;
		}
		
		@RequestMapping(value = "/nivelXLengua", method = RequestMethod.GET)
		@ResponseBody
		public List<LenguaEstructuraBean> doNivelXLengua(@RequestParam("codigolengua") String codigolengua) {

			System.out.println("codigolengua " + codigolengua);	
			//List<LenguaBean> lstLengua = new ArrayList<LenguaBean>();
			List<LenguaEstructuraBean> listaInstitucionLenguaBean = new ArrayList<LenguaEstructuraBean>();
			if (!codigolengua.equals("0")){
			
				LenguaBean oLenguaBean = new LenguaBean();
				oLenguaBean.setCodigo(Integer.valueOf(codigolengua));
				try {
					//lstLengua = lenguaService.listarComboxInstitucion(inscripcionaBean);//listarComboxInstitucion
					listaInstitucionLenguaBean =  lenguaEstructuraService.listarNivelesxLenguaAll(oLenguaBean);
					if (VO.isNotEmptyList(listaInstitucionLenguaBean)) {
						System.out.println("listaInstitucionLenguaBean.size() " +listaInstitucionLenguaBean.size());
					}else {
						listaInstitucionLenguaBean=null;
					}
				} catch (ServiceException e) {
					
					e.printStackTrace();
				}
			}
		
	
			return listaInstitucionLenguaBean;
		}
	
		@RequestMapping(value = "/agregarAlumnoXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarAlumnoXMatricula(@RequestParam("codMatri") Integer codMatri,@RequestParam("codAlu") Integer codAlu,@RequestParam("codInscLen") Integer codInscLen,HttpServletRequest request) {
			
			String cant="";
			System.out.println("-------------------------agregarAlumnoXMatricula-------------------------");
			System.out.println("codMatri " + codMatri);		
			System.out.println("codAlu " + codAlu);
		

			MatriculaAlumnoBean insLen = new MatriculaAlumnoBean();
			insLen.getMatriculaBean().setCodigo(codMatri);
			insLen.getAlumnoBean().setCodigo(codAlu);
			insLen.setCodigoUsuarioCreacion(1);
			
			/***********************************************************/
			UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
			usuarioMatriculaBean.getAlumnoBean().setCodigo(codAlu);
			usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(codInscLen);
			usuarioMatriculaBean.setAudCodigoUsuario(Long.valueOf(1));
			usuarioMatriculaBean.setAudHostIP("192.168.1.1");
			
			
			/************************************************************/
		
			
			boolean sw = false;
			try {
//				if (inscripcionLenguaBean.getCodigo()==0) {
							System.out.println("insert agregarlengua");
							this.setAuditoria(insLen, request, true);
					sw =  (this.matriculaAlumnoService.insertar(insLen)); 
					
					
					if(sw==true){
							this.setAuditoria(usuarioMatriculaBean, request, true);
						sw = (this.usuarioMatriculaService.asignarUsuario(usuarioMatriculaBean));
					}
					cant="1";
					
								
//				} else {
//					System.out.println("actualizasar agregarlengua");
//					System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
//					insLen.setCodigo(inscripcionLenguaBean.getCodigo());
//					
//					sw = (this.inscripcionLenguaService.actualizar(insLen));
//					cant="2";
//				}

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
					
				}else {
					System.out.println("cant 0 " + cant);
					return "0";
				}
				
			} else {
				return "0";
			}
		
			

		}
		
		@RequestMapping(value ="/eliminarAlumnoXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarAlumnoXMatricula(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			MatriculaAlumnoBean matriAlua= new MatriculaAlumnoBean();
			matriAlua.setCodigo(codigo);
			System.out.println("codigocodigocodigo eliminar " + codigo);
		
			try { 
					this.setAuditoria(matriAlua, request, false);
			sw =  (this.matriculaAlumnoService.eliminar(matriAlua));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				matriAlua.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
	
		@RequestMapping(value = "/recargarAlumnoXMatricula", method = RequestMethod.GET)
		public ModelAndView recargarAlumnoXMatricula(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarAlumnoXMatricula " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-matricula-Alumno");
		
			cargarAlumnosDocenteXMatricula(mav,codigo);
			
			return mav;
		}
		
		private void cargarDocenteXMatricula(ModelAndView mav, int codigoMat){
			MatriculaDocenteBean matAlum = new MatriculaDocenteBean();
			matAlum.getMatriculaBean().setCodigo(codigoMat);
			List<MatriculaDocenteBean>	lstMatriculaDocenteBean=null;
		
				try {
					lstMatriculaDocenteBean = matriculaDocenteService.listarDocentexMatricula(matAlum);
					if (VO.isNotEmptyList(lstMatriculaDocenteBean)) {
						System.out.println(" lstMatriculaAlumnoBean "+ lstMatriculaDocenteBean.size());
					}
					
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}		
		
	
			
			mav.addObject("lstMatriculaDocenteBean",lstMatriculaDocenteBean); 
		
		}
		
		@RequestMapping(value = "/recargarDocenteXMatricula", method = RequestMethod.GET)
		public ModelAndView recargarDocenteXMatricula(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarDocenteXMatricula " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-matricula-Docente");
		
			cargarDocenteXMatricula(mav,codigo);
			
			return mav;
		}
		
		@RequestMapping(value = "/agregarDocenteXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarDocenteXMatricula(@RequestParam("codMatri") Integer codMatri,@RequestParam("codDoc") Integer codDoc,@RequestParam("tipDoc") Integer tipDoc,HttpServletRequest request) {
			
			String cant="";
			System.out.println("-------------------------agregarAlumnoXMatricula-------------------------");
			System.out.println("codMatri " + codMatri);		
			System.out.println("codAlu " + codDoc);
			System.out.println("tipDoc " + tipDoc);
		
			MatriculaDocenteBean oMatriculaDocenteBean = null;
			MatriculaDocenteBean insLen = new MatriculaDocenteBean();
			insLen.getMatriculaBean().setCodigo(codMatri);
			insLen.getDocenteBean().setCodigo(codDoc);
			insLen.getTipoDocente().setCodigoRegistro(tipDoc);
			insLen.getSituacionMatriculaDocente().setCodigoRegistro(1);
//			insLen.setCodigoUsuarioCreacion(1);
//			insLen.setIpCreacion("1");
			
			boolean sw = false;
			try {
				
				oMatriculaDocenteBean = this.matriculaDocenteService.validarDocentexMatricula(insLen);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (VO.isNotNull(oMatriculaDocenteBean)) {
				System.out.println("oMatriculaDocenteBean.getTipoDocente().getCodigoRegistro()1 "+ oMatriculaDocenteBean.getTipoDocente().getCodigoRegistro());
				if (oMatriculaDocenteBean.getTipoDocente().getCodigoRegistro()!=1) {
					try {
						System.out.println("insert agregarmatriculaDocente 1 ");
						this.setAuditoria(insLen, request, true);
						sw =  (this.matriculaDocenteService.insertar(insLen)); 
						cant="1";


				} catch (Exception e) { 
					return "0";
				}
				}else {
					System.out.println("oMatriculaDocenteBean.getTipoDocente().getCodigoRegistro()2 "+ oMatriculaDocenteBean.getTipoDocente().getCodigoRegistro());
					//sw=true;
					cant="3";
					return "3";
				}
			}else {
				try {
					System.out.println("insert agregarmatriculaDocente 2 ");
					this.setAuditoria(insLen, request, true);
					sw =  (this.matriculaDocenteService.insertar(insLen)); 
					cant="1";


				} catch (Exception e) { 
					return "0";
				}
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
				}else {
					System.out.println("cant 0 " + cant);
					return "0";
				}
				
			} else {
				return "0";
			}
		
			

		}
		
		@RequestMapping(value ="/eliminarDocenteXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarDocenteXMatricula(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			MatriculaDocenteBean matriAlua= new MatriculaDocenteBean();
			matriAlua.setCodigo(codigo);
			System.out.println("codigocodigocodigo eliminar " + codigo);
//			matriAlua.setCodigoUsuarioModificacion(1);
//			matriAlua.setIpModificacion("1");
			try { 
					this.setAuditoria(matriAlua, request, false);
			sw =  (this.matriculaDocenteService.eliminar(matriAlua));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				matriAlua.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
	
//		@RequestMapping(value ="/actualizarNumCuposRestMatri", method = RequestMethod.POST)
//		@ResponseBody
		public String actualizarNumCuposRestMatri(int codigo, String numCuposRest){
			boolean sw=false;
			System.out.println("codigoMat codigoMat codigoMat " + codigo);
			System.out.println("numCuposRest " + numCuposRest);
			MatriculaBean matriAlua= new MatriculaBean();
			matriAlua.setCodigo(codigo);
			matriAlua.setvNumcuposrest(numCuposRest);
			matriAlua.setCodigoUsuarioModificacion(1);
			matriAlua.setIpModificacion("1");
		
			try { 
			sw =  (this.matriculaService.actualizarNumCuposRest(matriAlua));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				return "1";		
			}else {
				return "0";
			}
			
		}	
//		@RequestMapping(value ="/actualizarNumCuposDispInscripLengua", method = RequestMethod.POST)
//		@ResponseBody
//		public String actualizarNumCuposDispInscripLengua(@RequestParam("codigo")Integer codigo,@RequestParam("numCuposDisp")String numCuposDisp,HttpServletRequest request){
//			
//			boolean sw=false;
//			System.out.println("codigocodigocodigo " + codigo);
//			System.out.println("numCuposDisp " + numCuposDisp);
//			InscripcionLenguaBean matriAlua= new InscripcionLenguaBean();
//			matriAlua.setCodigo(codigo);
//			matriAlua.setNumeroCuposDisp(numCuposDisp);			
//			matriAlua.setCodigoUsuarioModificacion(1);
//			matriAlua.setIpModificacion("1");
//			try { 
//			sw =  (this.inscripcionLenguaService.actualizarNumCuposDisp(matriAlua));  
//			
//			} catch (Exception e) { 
//				e.printStackTrace();
//			} 		
//			if (sw) {
//				return "1";		
//			}else {
//				return "0";
//			}
//			
//		}	
		
	public MatriculaBean getMatriculaBeanG() {
		return matriculaBeanG;
	}

	public void setMatriculaBeanG(MatriculaBean matriculaBeanG) {
		this.matriculaBeanG = matriculaBeanG;
	}

	public List<MatriculaBean> getLstMatriculaBean() {
		return lstMatriculaBean;
	}

	public void setLstMatriculaBean(List<MatriculaBean> lstMatriculaBean) {
		this.lstMatriculaBean = lstMatriculaBean;
	}

	public MatriculaService getMatriculaService() {
		return matriculaService;
	}

	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
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

	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}

	public List<MaestraBean> getLstnivel() {
		return lstnivel;
	}

	public void setLstnivel(List<MaestraBean> lstnivel) {
		this.lstnivel = lstnivel;
	}

	public List<MaestraBean> getLstsubNivel() {
		return lstsubNivel;
	}

	public void setLstsubNivel(List<MaestraBean> lstsubNivel) {
		this.lstsubNivel = lstsubNivel;
	}

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstEstadoMatricula() {
		return lstEstadoMatricula;
	}

	public void setLstEstadoMatricula(List<MaestraBean> lstEstadoMatricula) {
		this.lstEstadoMatricula = lstEstadoMatricula;
	}

	public List<MaestraBean> getLstCiclo() {
		return lstCiclo;
	}

	public void setLstCiclo(List<MaestraBean> lstCiclo) {
		this.lstCiclo = lstCiclo;
	}

	public List<MaestraBean> getLstPeriodo() {
		return lstPeriodo;
	}

	public void setLstPeriodo(List<MaestraBean> lstPeriodo) {
		this.lstPeriodo = lstPeriodo;
	}

	public InscripcionBean getInscripcionBean() {
		return inscripcionBean;
	}

	public void setInscripcionBean(InscripcionBean inscripcionBean) {
		this.inscripcionBean = inscripcionBean;
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

	public List<MatriculaAlumnoBean> getLstmatriculaAlumno() {
		return lstmatriculaAlumno;
	}

	public void setLstmatriculaAlumno(List<MatriculaAlumnoBean> lstmatriculaAlumno) {
		this.lstmatriculaAlumno = lstmatriculaAlumno;
	}

	public MatriculaForm getMatriculaForm() {
		return matriculaForm;
	}

	public void setMatriculaForm(MatriculaForm matriculaForm) {
		this.matriculaForm = matriculaForm;
	}

	


}
