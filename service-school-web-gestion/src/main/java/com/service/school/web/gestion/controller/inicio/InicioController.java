package com.service.school.web.gestion.controller.inicio;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.seguridad.AccesoBean;
import com.service.school.core.bean.bean.seguridad.PerfilBean;
import com.service.school.core.bean.bean.seguridad.UsuarioBean;
import com.service.school.core.bean.bean.seguridad.UsuarioPerfilBean;
import com.service.school.core.service.service.interfaces.seguridad.AccesoService;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioService;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.VO;
import com.service.school.web.gestion.utilitarios.acceso.AccesoMenuVo;
import com.service.school.web.gestion.utilitarios.acceso.LoginVo;
import com.service.school.web.gestion.utilitarios.acceso.PermisoVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "inicioController")
@SessionAttributes("usuarioSesion")
public class InicioController extends BaseController{
	
	@Autowired
	AccesoService accesoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	
	@RequestMapping(value = "/controlAcceso", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") LoginVo prmLogin,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		
		this.setUsuarioBean(new UsuarioBean());
		
		//Inicializando el Encrypt
		//Encrypt.init();
		
		if (prmLogin != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			//prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getPasswordUsuario()));
			prmUsuario.setPasswordUsuario(prmLogin.getContrasena());
			prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
			
			UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			
			if (oUsuario != null) {
				
				if (oUsuario.getSituacion().getCodigoRegistro()!= 1) {//Activo
					ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
					mav.addObject("msgErrorLogin","Su usuario no se encuentra activo, "
							+ "por favor coordine con el administrador del sistema");
					return mav;
				}
				
				if(oUsuario.getFlgRestPass()!=null && "1".equals(oUsuario.getFlgRestPass())){
					request.getSession().setAttribute("usuarioSesion", oUsuario);
					oUsuario.setPasswordUsuario("");
					oUsuario.setNewPassword("");
					
					ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",oUsuario);
					mav.addObject("usuarioBean", oUsuario);
					return mav;
				}
				
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
				filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
				filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(oUsuario.getCodigoUsuario());
				lstUsuarioPerfilBean = usuarioPerfilService.getBuscarPorFiltros(filtroUsuarioPerfilBean);
				
				long codPerfilSelecc = 0;
				
				if( !VO.isEmptyList(lstUsuarioPerfilBean) ){
					UsuarioPerfilBean prmUP = lstUsuarioPerfilBean.get(0);
					codPerfilSelecc = prmUP.getPerfil().getCodigoPerfil();
				}
				
				oUsuario.setCodPerfilUsuSelec(codPerfilSelecc);
				oUsuario.setLstUsuarioPerfil(lstUsuarioPerfilBean);
						
				return this.getLista(oUsuario, request);
			} else {
				UsuarioBean tmpUsuario = new UsuarioBean();
				tmpUsuario.setNombreUsuario("NV");
				this.setUsuarioBean(tmpUsuario);
				ModelAndView mav = new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
				mav.addObject("msgErrorLogin", "El usuario y/o contraseña no coinciden");
				mav.addObject("usuarioSesion", tmpUsuario);
				return mav;
			}
		}else{
			return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
		}
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView incio(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioSesion");
		
		session.invalidate();
		
		
		//this.setUsuarioBean(new UsuarioBean());
		
		//Inicializando el Encrypt
		//Encrypt.init();
		
		if (usuarioBean != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			//prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getPasswordUsuario()));
			prmUsuario.setCodigoUsuario(usuarioBean.getCodigoUsuario());
			prmUsuario.setPasswordUsuario(usuarioBean.getPasswordUsuario());
			prmUsuario.setNewPassword(usuarioBean.getNewPassword());
			prmUsuario.setAudCodigoUsuario(usuarioBean.getCodigoUsuario());
			prmUsuario.setFlgRestPass("0");
			Integer resultI = usuarioService.cambiarPassword(prmUsuario);
			//UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			
			if (resultI != null && resultI>0) {
				
				
				
				usuario.setPasswordUsuario(usuarioBean.getPasswordUsuario());
				usuario.setFlgRestPass("0");
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
				filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
				filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
				lstUsuarioPerfilBean = usuarioPerfilService.getBuscarPorFiltros(filtroUsuarioPerfilBean);
				
				long codPerfilSelecc = 0;
				
				if( !VO.isEmptyList(lstUsuarioPerfilBean) ){
					UsuarioPerfilBean prmUP = lstUsuarioPerfilBean.get(0);
					codPerfilSelecc = prmUP.getPerfil().getCodigoPerfil();
				}
				
				usuario.setCodPerfilUsuSelec(codPerfilSelecc);
				usuario.setLstUsuarioPerfil(lstUsuarioPerfilBean);
						
				return this.getLista(usuario, request);
			} else {
				UsuarioBean filtro = new UsuarioBean();
				filtro.setCodigoUsuario(usuarioBean.getCodigoUsuario());
				List<UsuarioBean> lstUsuarioBean = usuarioService.getBuscarPorFiltros(filtro);
				if(lstUsuarioBean.size()>0){
					usuario = lstUsuarioBean.get(0);
				}
				request.getSession().setAttribute("usuarioSesion", usuario);
				ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",usuarioBean);
				mav.addObject("msgErrorLogin", "La contrase&nacute;a no coincide con la actual");
				mav.addObject("usuarioBean", usuarioBean);
				return mav;
			}
		}else{
			
			return  new ModelAndView("seguridad/login/login-admin", "command",new LoginVo());
		}
	}
	
	private ModelAndView getLista(UsuarioBean usuario, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("inicio");
		
		try {
			
			int totalPerfiles = 0;
			
			/** TRAER ACCESOS **/
			if(!VO.isEmptyList(usuario.getLstUsuarioPerfil())){
				
				totalPerfiles = usuario.getLstUsuarioPerfil().size();
				
				AccesoBean filtroAccesoBean = new AccesoBean();
				filtroAccesoBean.setPerfil(new PerfilBean());
				filtroAccesoBean.getPerfil().setCodigo(usuario.getCodPerfilUsuSelec());
				List<AccesoBean> lstAccesoBean =  accesoService.getBuscarPorFiltros(filtroAccesoBean);
						
				/** verificar accesos **/
				AccesoMenuVo accesoMenuVo = verificarAccesos(lstAccesoBean);
				request.getSession().setAttribute("accesoMenu", accesoMenuVo);
				mav.addObject("accesoMenu", accesoMenuVo);		
				usuario.setLstAcceso(lstAccesoBean);
			}
			
			this.setUsuarioBean(usuario);	
			request.getSession().setAttribute("totalPerfiles", totalPerfiles);
			mav.addObject("totalPerfiles",totalPerfiles);
			request.getSession().setAttribute("usuarioSesion", usuario);
			mav.addObject("usuarioSesion", usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar(@ModelAttribute("usuarioSesion") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return this.getLista(usuario, request);
	}
	
	@RequestMapping(value = "/obtenerAccesos", method = RequestMethod.GET)
	public ModelAndView obtenerAccesos(@RequestParam("codperfil") String codperfil,
			HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		usuario.setCodPerfilUsuSelec(VO.toLong(codperfil));
		
		return this.getLista(usuario, request);
	}
	
	private AccesoMenuVo verificarAccesos(List<AccesoBean> listaAcceso) {
		
		AccesoMenuVo accesoMenuVo = new AccesoMenuVo();
		
		if(!VO.isEmptyList(listaAcceso)){
			for (int i = 0; i < listaAcceso.size(); i++) {
				AccesoBean bean = listaAcceso.get(i);
				
				if(		!VO.isNull(bean.getComponente()) 
					&& 	!VO.isNull(bean.getComponente().getNombreComponente())
				  ){
					
					String nombreComponente = bean.getComponente().getNombreComponente();
					
					/** INSTITUCION **/
					if (nombreComponente.equals("institucion")) {
						
						accesoMenuVo.setAloc_institucion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** LENGUA **/
					if (nombreComponente.equals("lengua")) {
						
						accesoMenuVo.setAloc_lengua(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** MATERIAL **/
					if (nombreComponente.equals("material")) {
						
						accesoMenuVo.setAloc_material(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("material_carga_directa")) {
						accesoMenuVo.setAloc_material_carga_directa(new PermisoVo());
						accesoMenuVo.getAloc_material_carga_directa().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_material_carga_directa().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_material_carga_directa().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_material_carga_directa().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("material_carga_masiva")) {
						accesoMenuVo.setAloc_material_carga_masiva(new PermisoVo());
						accesoMenuVo.getAloc_material_carga_masiva().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_material_carga_masiva().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_material_carga_masiva().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_material_carga_masiva().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** PERSONAL **/
					if (nombreComponente.equals("personal")) {
						
						accesoMenuVo.setAloc_personal(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** INSCRIPCION **/
					if (nombreComponente.equals("inscripcion")) {
						
						accesoMenuVo.setAloc_inscripcion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** MATRICULA **/
					if (nombreComponente.equals("matricula")) {
						
						accesoMenuVo.setAloc_matricula(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("matricula_registro")) {
						accesoMenuVo.setAloc_matricula_registro(new PermisoVo());
						accesoMenuVo.getAloc_matricula_registro().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_matricula_registro().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_matricula_registro().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_matricula_registro().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("matricula_asignar_usuario")) {
						accesoMenuVo.setAloc_matricula_asignar_usuario(new PermisoVo());
						accesoMenuVo.getAloc_matricula_asignar_usuario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_matricula_asignar_usuario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_matricula_asignar_usuario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_matricula_asignar_usuario().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** DOCENTE **/
					if (nombreComponente.equals("docente")) {
						
						accesoMenuVo.setAloc_docente(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** ALUMNO **/
					if (nombreComponente.equals("alumno")) {
						
						accesoMenuVo.setAloc_alumno(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("alumno_registro")) {
						accesoMenuVo.setAloc_alumno_registro(new PermisoVo());
						accesoMenuVo.getAloc_alumno_registro().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_alumno_registro().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_alumno_registro().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_alumno_registro().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("alumno_seguimiento")) {
						accesoMenuVo.setAloc_alumno_seguimiento(new PermisoVo());
						accesoMenuVo.getAloc_alumno_seguimiento().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_alumno_seguimiento().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_alumno_seguimiento().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_alumno_seguimiento().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** SEGURIDAD **/
					if (nombreComponente.equals("seguridad")) {
						
						accesoMenuVo.setAloc_seguridad(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("seguridad_usuario")) {
						accesoMenuVo.setAloc_seguridad_usuario(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_usuario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_usuario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_usuario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_usuario().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("seguridad_perfil")) {
						accesoMenuVo.setAloc_seguridad_perfil(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_perfil().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_perfil().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_perfil().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_perfil().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("seguridad_acceso")) {
						accesoMenuVo.setAloc_seguridad_acceso(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_acceso().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_acceso().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_acceso().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_acceso().setExportacion(bean.isFlgExport() ? true : false);
					}
					
					/** CONFIGURACION **/
					if (nombreComponente.equals("configuracion")) {
						
						accesoMenuVo.setAloc_configuracion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("configuracion_tabla_maestra")) {
						accesoMenuVo.setAloc_configuracion_tabla_maestra(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_mascota")) {
						accesoMenuVo.setAloc_configuracion_mascota(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_mascota().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_mascota().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_mascota().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_mascota().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("configuracion_traduccion_general")) {
						accesoMenuVo.setAloc_configuracion_traduccion_general(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_traduccion_general().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion_general().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion_general().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion_general().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("configuracion_premio")) {
						accesoMenuVo.setAloc_configuracion_premio(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_premio().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_premio().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_premio().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_premio().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("configuracion_ficha_puntaje")) {
						accesoMenuVo.setAloc_configuracion_ficha_puntaje(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_slider")) {
						accesoMenuVo.setAloc_configuracion_slider(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_slider().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_slider().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_slider().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_slider().setExportacion(bean.isFlgExport() ? true : false); 
					}
					else if (nombreComponente.equals("configuracion_fondo")) {
						accesoMenuVo.setAloc_configuracion_fondo(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_fondo().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_fondo().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_fondo().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_fondo().setExportacion(bean.isFlgExport() ? true : false); 
					}
					
				}
				
			}
		}
	
		return accesoMenuVo;
	}
	
}