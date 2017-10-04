package com.service.school.web.gestion.controller.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.seguridad.PerfilBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.seguridad.PerfilService;

@Controller
@Scope(value="session")
@RequestMapping(value = "perfilController")
public class PerfilController {
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	private PerfilBean perfilBean;
	private List<MaestraBean>	lstSituacion;
	
	@PostConstruct
	public void init(){
		this.setPerfilBean(new PerfilBean());
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("perfilBean") PerfilBean bean)throws Exception {
		
		return this.getLista(bean);
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",new PerfilBean());
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("perfilBean", new PerfilBean());
		return mav;
	}
	
	@RequestMapping(value = "/obtener", method = RequestMethod.POST)
	public ModelAndView doObtener(@ModelAttribute("perfilBean") PerfilBean bean) {
		
		
		if(bean.getCodigoPerfil()!=null && bean.getCodigoPerfil()>0){
			List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
			try {
				lstPerfilBean = perfilService.getBuscarPorFiltros(bean);
				if(lstPerfilBean != null && lstPerfilBean.size()>0){
					perfilBean = (PerfilBean)lstPerfilBean.get(0);
					
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		}else{
			perfilBean = new PerfilBean();
		}
		
		ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
		mav.addObject("perfilBean", perfilBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("perfilBean") PerfilBean perfilBean) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = true;
		try {
			if (perfilBean.getCodigoPerfil()!=null && perfilBean.getCodigoPerfil()!=0) {
				sw = (perfilService.actualizar(perfilBean));
			} else {
				sw =  (perfilService.insertar(perfilBean)); 
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			perfilBean = new PerfilBean() ;
			return this.getLista(perfilBean);
		} else {
			ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
			return mav;
		}

	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView doEliminar(@ModelAttribute PerfilBean perfilBean) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = true;
		
		try {
			if (perfilBean.getCodigoPerfil()!=null && perfilBean.getCodigoPerfil()!=0) {
				sw = (perfilService.eliminar(perfilBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		//if (sw) {
			perfilBean = new PerfilBean() ;
			return this.getLista(perfilBean);
		/*} else {
			ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
			return mav;
		}*/

	}
	
	private ModelAndView getLista(PerfilBean perfilBean) {
		
		List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
		try {
			lstPerfilBean =  perfilService.getBuscarPorFiltros(perfilBean);
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("seguridad/perfil/listado-perfil", "command",perfilBean);
		mav.addObject("perfilBean", perfilBean);
		mav.addObject("lstPerfilBean", lstPerfilBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionPerfil",0);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
	}  

	public PerfilBean getPerfilBean() {
		return perfilBean;
	}

	public void setPerfilBean(PerfilBean perfilBean) {
		this.perfilBean = perfilBean;
	}
	
	
}
