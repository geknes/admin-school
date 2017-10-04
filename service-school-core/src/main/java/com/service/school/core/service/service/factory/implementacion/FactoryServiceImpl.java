package com.service.school.core.service.service.factory.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.school.core.service.service.factory.interfaces.FactoryService;
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

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService {
	
	/** ACADEMICO **/
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private EspecialidadService especialidadService;
	@Autowired
	private InscripcionDocenteService inscripcionDocenteService;
	@Autowired
	private InscripcionLenguaService inscripcionLenguaService;
	@Autowired
	private InscripcionService inscripcionService;
	@Autowired
	private MatriculaAlumnoService matriculaAlumnoService;
	@Autowired
	private MatriculaDocenteService matriculaDocenteService;
	@Autowired
	private MatriculaService matriculaService;
	@Autowired
	private UsuarioMatriculaService usuarioMatriculaService;
	
	/** CONFIGURACION **/
	@Autowired
	private ExamenConfiguracionService examenConfiguracionService;
	@Autowired
	private FondoService fondoService;
	@Autowired
	private MascotaService mascotaService;
	@Autowired
	private PremioConfiguracionService premioConfiguracionService;
	@Autowired
	private PremioService premioService;
	@Autowired
	private SliderService sliderService;
	@Autowired
	private SliderDetalleService sliderDetalleService;
	
	/** GENERAL **/
	@Autowired
	private AlternativaService alternativaService;
	@Autowired
	private CrucigramaService crucigramaService;
	@Autowired
	private InstitucionDirectorService institucionDirectorService;
	@Autowired
	private InstitucionLenguaService institucionLenguaService;
	@Autowired
	private InstitucionOperadorService institucionOperadorService;
	@Autowired
	private InstitucionSedeService institucionSedeService;
	@Autowired
	private InstitucionService institucionService;
	@Autowired
	private LeccionMaterialService leccionMaterialService;
	@Autowired
	private LenguaEstructuraService lenguaEstructuraService;
	@Autowired
	private LenguaService lenguaService;
	@Autowired
	private Maestra1Service maestra1Service;
	@Autowired
	private Maestra2Service maestra2Service;
	@Autowired
	private MaterialEjercicioService materialEjercicioService;
	@Autowired
	private MaterialTipoEjercicioService materialTipoEjercicioService;
	@Autowired
	private OracionAlterService oracionAlterService;
	@Autowired
	private OracionCompletarService oracionCompletarService;
	@Autowired
	private OrdenarParrafoCabeceraService ordenarParrafoCabeceraService;
	@Autowired
	private OrdenarParrafoService ordenarParrafoService;
	@Autowired
	private PersonaLenguaService personaLenguaService;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private PersonaNacionalidadService personaNacionalidadService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private RelacionService relacionService;
	@Autowired
	private RelacionCabeceraService relacionCabeceraService;
	@Autowired
	private UbigeoService ubigeoService;
	@Autowired
	private UnidadLeccionService unidadLeccionService;
	@Autowired
	private UnidadService unidadService;

	/** SEGURIDAD **/
	@Autowired
	private AccesoService accesoService;
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Override
	public AlumnoService getAlumnoService() {
		return alumnoService;
	}
	@Override
	public DocenteService getDocenteService() {
		return docenteService;
	}
	@Override
	public EspecialidadService getEspecialidadService() {
		return especialidadService;
	}
	@Override
	public InscripcionDocenteService getInscripcionDocenteService() {
		return inscripcionDocenteService;
	}
	@Override
	public InscripcionLenguaService getInscripcionLenguaService() {
		return inscripcionLenguaService;
	}
	@Override
	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}
	@Override
	public MatriculaAlumnoService getMatriculaAlumnoService() {
		return matriculaAlumnoService;
	}
	@Override
	public MatriculaDocenteService getMatriculaDocenteService() {
		return matriculaDocenteService;
	}
	@Override
	public MatriculaService getMatriculaService() {
		return matriculaService;
	}
	@Override
	public UsuarioMatriculaService getUsuarioMatriculaService() {
		return usuarioMatriculaService;
	}
	@Override
	public ExamenConfiguracionService getExamenConfiguracionService() {
		return examenConfiguracionService;
	}
	@Override
	public FondoService getFondoService() {
		return fondoService;
	}
	@Override
	public MascotaService getMascotaService() {
		return mascotaService;
	}
	@Override
	public PremioConfiguracionService getPremioConfiguracionService() {
		return premioConfiguracionService;
	}
	@Override
	public PremioService getPremioService() {
		return premioService;
	}
	@Override
	public SliderService getSliderService() {
		return sliderService;
	}
	@Override
	public SliderDetalleService getSliderDetalleService() {
		return sliderDetalleService;
	}
	@Override
	public AlternativaService getAlternativaService() {
		return alternativaService;
	}
	@Override
	public CrucigramaService getCrucigramaService() {
		return crucigramaService;
	}
	@Override
	public InstitucionDirectorService getInstitucionDirectorService() {
		return institucionDirectorService;
	}
	@Override
	public InstitucionLenguaService getInstitucionLenguaService() {
		return institucionLenguaService;
	}
	@Override
	public InstitucionOperadorService getInstitucionOperadorService() {
		return institucionOperadorService;
	}
	@Override
	public InstitucionSedeService getInstitucionSedeService() {
		return institucionSedeService;
	}
	@Override
	public InstitucionService getInstitucionService() {
		return institucionService;
	}
	@Override
	public LeccionMaterialService getLeccionMaterialService() {
		return leccionMaterialService;
	}
	@Override
	public LenguaEstructuraService getLenguaEstructuraService() {
		return lenguaEstructuraService;
	}
	@Override
	public LenguaService getLenguaService() {
		return lenguaService;
	}
	@Override
	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}
	@Override
	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}
	@Override
	public MaterialEjercicioService getMaterialEjercicioService() {
		return materialEjercicioService;
	}
	@Override
	public MaterialTipoEjercicioService getMaterialTipoEjercicioService() {
		return materialTipoEjercicioService;
	}
	@Override
	public OracionAlterService getOracionAlterService() {
		return oracionAlterService;
	}
	@Override
	public OracionCompletarService getOracionCompletarService() {
		return oracionCompletarService;
	}
	@Override
	public OrdenarParrafoCabeceraService getOrdenarParrafoCabeceraService() {
		return ordenarParrafoCabeceraService;
	}
	@Override
	public OrdenarParrafoService getOrdenarParrafoService() {
		return ordenarParrafoService;
	}
	@Override
	public PersonaLenguaService getPersonaLenguaService() {
		return personaLenguaService;
	}
	@Override
	public PersonalService getPersonalService() {
		return personalService;
	}
	@Override
	public PersonaNacionalidadService getPersonaNacionalidadService() {
		return personaNacionalidadService;
	}
	@Override
	public PersonaService getPersonaService() {
		return personaService;
	}
	@Override
	public PreguntaService getPreguntaService() {
		return preguntaService;
	}
	@Override
	public RelacionService getRelacionService() {
		return relacionService;
	}
	public void setRelacionCabeceraService(RelacionCabeceraService relacionCabeceraService) {
		this.relacionCabeceraService = relacionCabeceraService;
	}
	@Override
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	@Override
	public UnidadLeccionService getUnidadLeccionService() {
		return unidadLeccionService;
	}
	@Override
	public UnidadService getUnidadService() {
		return unidadService;
	}
	@Override
	public AccesoService getAccesoService() {
		return accesoService;
	}
	@Override
	public PerfilService getPerfilService() {
		return perfilService;
	}
	@Override
	public UsuarioPerfilService getUsuarioPerfilService() {
		return usuarioPerfilService;
	}
	@Override
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	@Override
	public RelacionCabeceraService getRelacionCabeceraService() {
		// TODO Auto-generated method stub
		return null;
	}
	
}