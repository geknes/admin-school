package com.service.school.core.service.service.factory.interfaces;

import com.service.school.core.service.service.interfaces.academico.AlumnoService;
import com.service.school.core.service.service.interfaces.academico.DocenteService;
import com.service.school.core.service.service.interfaces.academico.EspecialidadService;
import com.service.school.core.service.service.interfaces.academico.InscripcionDocenteService;
import com.service.school.core.service.service.interfaces.academico.InscripcionLenguaService;
import com.service.school.core.service.service.interfaces.academico.InscripcionService;
import com.service.school.core.service.service.interfaces.academico.MatriculaAlumnoService;
import com.service.school.core.service.service.interfaces.academico.MatriculaDocenteService;
import com.service.school.core.service.service.interfaces.academico.MatriculaService;
import com.service.school.core.service.service.interfaces.academico.UsuarioMatriculaService;
import com.service.school.core.service.service.interfaces.configuracion.ExamenConfiguracionService;
import com.service.school.core.service.service.interfaces.configuracion.FondoService;
import com.service.school.core.service.service.interfaces.configuracion.MascotaService;
import com.service.school.core.service.service.interfaces.configuracion.PremioConfiguracionService;
import com.service.school.core.service.service.interfaces.configuracion.PremioService;
import com.service.school.core.service.service.interfaces.configuracion.SliderDetalleService;
import com.service.school.core.service.service.interfaces.configuracion.SliderService;
import com.service.school.core.service.service.interfaces.general.AlternativaService;
import com.service.school.core.service.service.interfaces.general.CrucigramaService;
import com.service.school.core.service.service.interfaces.general.InstitucionDirectorService;
import com.service.school.core.service.service.interfaces.general.InstitucionLenguaService;
import com.service.school.core.service.service.interfaces.general.InstitucionOperadorService;
import com.service.school.core.service.service.interfaces.general.InstitucionSedeService;
import com.service.school.core.service.service.interfaces.general.InstitucionService;
import com.service.school.core.service.service.interfaces.general.LeccionMaterialService;
import com.service.school.core.service.service.interfaces.general.LenguaEstructuraService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra1Service;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.core.service.service.interfaces.general.MaterialEjercicioService;
import com.service.school.core.service.service.interfaces.general.MaterialTipoEjercicioService;
import com.service.school.core.service.service.interfaces.general.OracionAlterService;
import com.service.school.core.service.service.interfaces.general.OracionCompletarService;
import com.service.school.core.service.service.interfaces.general.OrdenarParrafoCabeceraService;
import com.service.school.core.service.service.interfaces.general.OrdenarParrafoService;
import com.service.school.core.service.service.interfaces.general.PersonaLenguaService;
import com.service.school.core.service.service.interfaces.general.PersonaNacionalidadService;
import com.service.school.core.service.service.interfaces.general.PersonaService;
import com.service.school.core.service.service.interfaces.general.PersonalService;
import com.service.school.core.service.service.interfaces.general.PreguntaService;
import com.service.school.core.service.service.interfaces.general.RelacionCabeceraService;
import com.service.school.core.service.service.interfaces.general.RelacionService;
import com.service.school.core.service.service.interfaces.general.UbigeoService;
import com.service.school.core.service.service.interfaces.general.UnidadLeccionService;
import com.service.school.core.service.service.interfaces.general.UnidadService;
import com.service.school.core.service.service.interfaces.seguridad.AccesoService;
import com.service.school.core.service.service.interfaces.seguridad.PerfilService;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import com.service.school.core.service.service.interfaces.seguridad.UsuarioService;

public interface FactoryService {
	
	/** ACADEMICO **/
	public AlumnoService getAlumnoService();
	public DocenteService getDocenteService();
	public EspecialidadService getEspecialidadService();
	public InscripcionDocenteService getInscripcionDocenteService();
	public InscripcionLenguaService getInscripcionLenguaService();
	public InscripcionService getInscripcionService();
	public MatriculaAlumnoService getMatriculaAlumnoService();
	public MatriculaDocenteService getMatriculaDocenteService();
	public MatriculaService getMatriculaService();
	public UsuarioMatriculaService getUsuarioMatriculaService();

	/** CONFIGURACION **/
	public ExamenConfiguracionService getExamenConfiguracionService();
	public FondoService getFondoService();
	public MascotaService getMascotaService();
	public PremioConfiguracionService getPremioConfiguracionService();
	public PremioService getPremioService();
	public SliderService getSliderService();
	public SliderDetalleService getSliderDetalleService();

	/** GENERAL **/
	public AlternativaService getAlternativaService();
	public CrucigramaService getCrucigramaService();
	public InstitucionDirectorService getInstitucionDirectorService();
	public InstitucionLenguaService getInstitucionLenguaService();
	public InstitucionOperadorService getInstitucionOperadorService();
	public InstitucionSedeService getInstitucionSedeService();
	public InstitucionService getInstitucionService();
	public LeccionMaterialService getLeccionMaterialService();
	public LenguaEstructuraService getLenguaEstructuraService();
	public LenguaService getLenguaService();
	public Maestra1Service getMaestra1Service();
	public Maestra2Service getMaestra2Service();
	public MaterialEjercicioService getMaterialEjercicioService();
	public MaterialTipoEjercicioService getMaterialTipoEjercicioService();
	public OracionAlterService getOracionAlterService();
	public OracionCompletarService getOracionCompletarService();
	public OrdenarParrafoCabeceraService getOrdenarParrafoCabeceraService();
	public OrdenarParrafoService getOrdenarParrafoService();
	public PersonaLenguaService getPersonaLenguaService();
	public PersonalService getPersonalService();
	public PersonaNacionalidadService getPersonaNacionalidadService();
	public PersonaService getPersonaService();
	public PreguntaService getPreguntaService();
	public RelacionService getRelacionService();
	public RelacionCabeceraService getRelacionCabeceraService();
	public UbigeoService getUbigeoService();
	public UnidadLeccionService getUnidadLeccionService();
	public UnidadService getUnidadService();

	/** SEGURIDAD **/
	public AccesoService getAccesoService();
	public PerfilService getPerfilService();
	public UsuarioPerfilService getUsuarioPerfilService();
	public UsuarioService getUsuarioService();

}
