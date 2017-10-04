package com.service.school.web.gestion.controller.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.service.service.interfaces.general.UbigeoService;
import com.service.school.web.gestion.controller.base.BaseController;



@Controller
@Scope(value="session")
@RequestMapping(value = "baseController")
public class UbigeoController extends BaseController {

	@Autowired
	public UbigeoService ubigeoService;
	public UbigeoBean ubigeobean;
//	@RequestMapping(value = "/listardepartamento", method = RequestMethod.GET)
//	public List<UbigeoBean> doListaDepartamento(@ModelAttribute("docenteBean") DocenteBean docenteBean)throws Exception {
//		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
//		DocenteBean prmDocenteBean = new DocenteBean();
//		prmDocenteBean= docenteBean;
//		//prmDocenteBean.setNombre("");
////		return this.getLista(prmDocenteBean);
//		
//		
//		return lstProvincia;
//	}
//	
	
	
	@RequestMapping(value = "/buscarProvincia", method = RequestMethod.GET)
	public @ResponseBody List<UbigeoBean> doBuscarProvincia(@RequestParam("codigodepartamento") String codigo)throws Exception {
		System.out.println("gua gua.. :"+codigo);
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		if (!codigo.equals("00")){
			ubigeobean = new UbigeoBean();
			ubigeobean.setCodigoRegion(codigo);
			lstProvincia = ubigeoService.listarProvincia(ubigeobean);
		}
		return lstProvincia;
	}
	
	

	
	
	@RequestMapping(value = "/buscarDistrito", method = RequestMethod.GET)
	public @ResponseBody  List<UbigeoBean> doBuscarDistrito(@RequestParam("codigodepartamento") String codigo,@RequestParam("codigoprovincia") String codigoprovincia)throws Exception {
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		if (!codigoprovincia.equals("00")){
		ubigeobean = new UbigeoBean();
		ubigeobean.setCodigoRegion(codigo);
		ubigeobean.setCodigoProvincia(codigoprovincia);
		lstProvincia = ubigeoService.listarDistrito(ubigeobean);
		}
		return lstProvincia;
	}

	
	@RequestMapping(value = "/buscarubigeo", method = RequestMethod.GET)
	public @ResponseBody  List<UbigeoBean> doBuscarUbigeo(@RequestParam("nombredepartamento") String nombreDepartamento,@RequestParam("nombreprovincia") String nombreProvincia, @RequestParam("nombredistrito") String nombreDistrito)throws Exception {
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		
		ubigeobean = new UbigeoBean();
		ubigeobean.setCodigoRegion(nombreDepartamento);
		ubigeobean.setCodigoProvincia(nombreProvincia);
		ubigeobean.setCodigoDistrito(nombreDistrito);
		ubigeobean.setCodigoUbigeo("");
		lstProvincia = ubigeoService.getBuscarPorFiltros(ubigeobean);
		if(lstProvincia==null){
			lstProvincia = new ArrayList<UbigeoBean>();
		}
		return lstProvincia;
	}

	
}
