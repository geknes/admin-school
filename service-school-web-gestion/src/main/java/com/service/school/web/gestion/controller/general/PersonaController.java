package com.service.school.web.gestion.controller.general;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.generico.PersonaBean;
import com.service.school.core.bean.bean.generico.PersonalBean;
import com.service.school.core.bean.bean.generico.UbigeoBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.PersonaService;
import com.service.school.core.service.service.interfaces.general.UbigeoService;


@Controller
@Scope(value="session")
@RequestMapping(value = "personaController")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	private PersonaBean personaBean;
	

	@RequestMapping(value = "/validapersona", method = RequestMethod.POST)
	public @ResponseBody PersonaBean validaPersona(@RequestParam("tipodocumento") Integer tipoDocumento, @RequestParam("numerodocumento") String numeroDocumento) {

		List<UbigeoBean> lstUbigeoBean;
		UbigeoBean ubigeoBean;
 		personaBean = new PersonaBean();
		personaBean.getTipoDocumento().setCodigoRegistro(tipoDocumento);
		personaBean.setNumeroDocumento(numeroDocumento);
	
		try {
			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(personaBean);
			
			if(personaBean!=null){
				ubigeoBean=new UbigeoBean();
				ubigeoBean.setCodigoUbigeo(personaBean.getCodigoUbigeo());
				lstUbigeoBean = (List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
				if(lstUbigeoBean!=null){
					ubigeoBean=lstUbigeoBean.get(0);
					personaBean.getUbigeoBean().setCodigoUbigeo(ubigeoBean.getCodigoUbigeo());
					personaBean.getUbigeoBean().setNombreUbigeo(ubigeoBean.getNombreUbigeo());
				}
			}
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		if(personaBean==null){
			personaBean=new  PersonaBean();
		}
		
		return personaBean;
	}


	public PersonaService getPersonaService() {
		return personaService;
	}


	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}


	public PersonaBean getPersonaBean() {
		return personaBean;
	}


	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	
	
}
