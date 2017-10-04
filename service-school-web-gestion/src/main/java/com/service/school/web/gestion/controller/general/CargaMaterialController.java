package com.service.school.web.gestion.controller.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.school.core.bean.bean.academico.DocenteBean;
import com.service.school.core.bean.bean.academico.InscripcionDocenteBean;
import com.service.school.core.bean.bean.configuracion.PremioBean;
import com.service.school.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import com.service.school.core.bean.bean.generico.AlternativaBean;
import com.service.school.core.bean.bean.generico.ArrastraOraDetBean;
import com.service.school.core.bean.bean.generico.CargaMaterialBean;
import com.service.school.core.bean.bean.generico.InstitucionBean;
//import com.service.school.core.bean.bean.generico.EjercicioBean;
//import com.service.school.core.bean.bean.generico.LeccionBean;
import com.service.school.core.bean.bean.generico.LeccionMaterialBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.MaterialTipoEjercicioBean;
import com.service.school.core.bean.bean.generico.MaterialEjercicioBean;
import com.service.school.core.bean.bean.generico.OracionAlterBean;
import com.service.school.core.bean.bean.generico.OracionCompletarBean;
import com.service.school.core.bean.bean.generico.ArrastraOraciBean;
import com.service.school.core.bean.bean.generico.OrdenarParrafoBean;
import com.service.school.core.bean.bean.generico.OrdenarParrafoCabeceraBean;
import com.service.school.core.bean.bean.generico.PreguntaBean;
import com.service.school.core.bean.bean.generico.RelacionBean;
import com.service.school.core.bean.bean.generico.RelacionCabeceraBean;
import com.service.school.core.bean.bean.generico.TextoPalabraCorrectaBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.bean.bean.generico.UnidadLeccionBean;
//import com.service.school.core.bean.bean.generico.AlternativaBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.AlterTextoPalabraCorrectaService;
import com.service.school.core.service.service.interfaces.general.AlternativaService;
import com.service.school.core.service.service.interfaces.general.ArrastraOraDetService;
import com.service.school.core.service.service.interfaces.general.ArrastraOraciService;
//import com.service.school.core.service.service.interfaces.general.EjercicioService;
import com.service.school.core.service.service.interfaces.general.LeccionMaterialService;
//import com.service.school.core.service.service.interfaces.general.LeccionService;
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
import com.service.school.core.service.service.interfaces.general.PreguntaService;
import com.service.school.core.service.service.interfaces.general.RelacionCabeceraService;
import com.service.school.core.service.service.interfaces.general.RelacionService;
import com.service.school.core.service.service.interfaces.general.TextoPalabraCorrectaService;
import com.service.school.core.service.service.interfaces.general.UnidadLeccionService;
import com.service.school.core.service.service.interfaces.general.UnidadService;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.controller.general.view.InstitucionForm;
import com.service.school.web.gestion.utilitarios.ResourceUtil;
import com.service.school.web.gestion.utilitarios.VO;

@Controller
@Scope(value = "session")
@RequestMapping(value = "cargaMaterialController")
public class CargaMaterialController extends BaseController {

	private CargaMaterialBean cargaMaterialBean;

	// private EjercicioBean ejercicioBean;
	private LenguaBean lenguaActividad;
	// private List<EjercicioBean> lstEjercicio;
	private List<UnidadLeccionBean> lstLeccion;
	private List<MaestraBean> lstNivel;
	private List<MaestraBean> lstSubNivel;
	private List<MaestraBean> lstSituacion;
	private List<LenguaBean> lstLengua;
	private List<MaestraBean> lstUnidad;
	private List<MaestraBean> lstTipoEjercicio;
	private List<LenguaEstructuraBean> lstLenguaEstructuraBean;
	final java.util.Random rand = new java.util.Random();
	final Set<String> identifiers = new HashSet<String>();
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	@Autowired
	private Maestra1Service maestra1Service;

	@Autowired
	private Maestra2Service maestra2Service;

	@Autowired
	private LenguaService lenguaService;

	@Autowired
	private UnidadService unidadService;
	@Autowired
	private OracionCompletarService oracionCompletarService;
	@Autowired
	private ArrastraOraciService arrastraOraciService;
	@Autowired
	private OracionAlterService oracionAlterService;
	 
	
	@Autowired
	private TextoPalabraCorrectaService textoPalabraCorrectaService;
	
	@Autowired
	private AlterTextoPalabraCorrectaService alterTextoPalabraCorrectaService;

	// @Autowired
	// private EjercicioService ejercicioService;
	//
	// @Autowired
	// private LeccionService leccionService;


	@Autowired
	private RelacionService relacionService;
	
	@Autowired
	private RelacionCabeceraService relacionCabeceraService;

	// public EjercicioService getEjercicioService() {
	// return ejercicioService;
	// }
	//
	// public void setEjercicioService(EjercicioService ejercicioService) {
	// this.ejercicioService = ejercicioService;
	// }

	@Autowired
	private PreguntaService preguntaService;

	public PreguntaService getPreguntaService() {
		return preguntaService;
	}

	public void setPreguntaService(PreguntaService preguntaService) {
		this.preguntaService = preguntaService;
	}

	@Autowired
	private AlternativaService alternativaService;

	@Autowired
	private LenguaEstructuraService lenguaEstructuraService;
 
	
	@Autowired
	private LeccionMaterialService leccionMaterialService;
	
  
	    
	
	/** Material Tipo Ejercicio **/
	@Autowired
	private MaterialTipoEjercicioService materialTipoEjercicioService;
	
	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	
	@Autowired
	private OrdenarParrafoService ordenarParrafoService;
	
	private OrdenarParrafoBean ordenarParrafoBean;
	
	@Autowired
	private OrdenarParrafoCabeceraService ordenarParrafoCabeceraService;
	
	private OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean;
	
	private RelacionBean relacionBean;

	public LeccionMaterialService getLeccionMaterialService() {
		return leccionMaterialService;
	}

	public void setLeccionMaterialService(LeccionMaterialService leccionMaterialService) {
		this.leccionMaterialService = leccionMaterialService;
	}

	@Autowired
	private UnidadLeccionService unidadLeccionService;
	@Autowired
	private ArrastraOraDetService arrastraOraDetService;
	
	 
	private static String findFileCeldaAudio() throws FileNotFoundException, IOException {
		/*
		 * NPOIFSFileSystem fsx = new NPOIFSFileSystem( new FileInputStream(
		 * "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls"
		 * )); HSSFWorkbook wb = new HSSFWorkbook(fsx.getRoot(), true); for
		 * (HSSFObjectData obj : wb.getAllEmbeddedObjects()) { String oleName =
		 * obj.getOLE2ClassName(); DirectoryNode dn = (DirectoryNode)
		 * obj.getDirectory(); // if(oleName.contains("Acro") &&
		 * dn.hasEntry("CONTENTS")){ // InputStream is =
		 * dn.createDocumentInputStream("CONTENTS"); FileOutputStream fos = new
		 * FileOutputStream(obj.getDirectory().getName() + ".mp4");
		 * 
		 * File file = new File( "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\" +
		 * obj.getDirectory().getName() + " a.mp4"); try { FileOutputStream fop
		 * = new FileOutputStream(file); if (!file.exists()) {
		 * file.createNewFile(); } // fop.write(data); fop.flush(); fop.close();
		 * System.out.println("Llegó a leer la imagen"); } catch (IOException e)
		 * { e.printStackTrace(); } // fop.close(); // IOUtils.copy(is, fos);
		 * fos.close(); // is.close(); // } } fsx.close();
		 * 
		 * POIFSFileSystem fs = new POIFSFileSystem( new FileInputStream(
		 * "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls"
		 * )); HSSFWorkbook workbook = new HSSFWorkbook(fs); for (HSSFObjectData
		 * obj : workbook.getAllEmbeddedObjects()) { // the OLE2 Class Name of
		 * the object String oleName = obj.getOLE2ClassName();
		 * System.out.println(oleName); if (obj.hasDirectoryEntry()) { // The
		 * DirectoryEntry is a DocumentNode. Examine its entries to // find out
		 * what it is DirectoryNode dn = (DirectoryNode) obj.getDirectory();
		 * System.out.println("nombre:" + dn.getName()); } else { // There is no
		 * DirectoryEntry // Recover the object's data from the HSSFObjectData
		 * instance. byte[] objectData = obj.getObjectData(); }
		 * 
		 * }
		 */
		return "x";
	}

	private static String findFilaCeldaImage(HSSFSheet sheet, int fila, int celda) {
		HSSFPatriarch patriarch = sheet.getRow(fila).getSheet().getDrawingPatriarch();
		File file = null;
		if (patriarch != null) {
			HSSFShape shape = patriarch.getChildren().get(0);
			if (shape instanceof HSSFPicture) {
				HSSFPicture picture = (HSSFPicture) shape;
				if (picture.getShapeType() == HSSFSimpleShape.OBJECT_TYPE_PICTURE) {
					if (picture.getImageDimension() != null) {
						Row row = sheet.getRow(fila);
						if (row != null) {
							Cell cell = row.getCell(celda);
							HSSFPictureData pictureData = picture.getPictureData();
							byte[] data = pictureData.getData();
							// Acá deben de generar un código aleatorio para el
							// nombre de la imagen
							// Por alguna razón no me lee el nombre de la
							// imagen.
							file = new File("C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\imagenEjercicio."
									+ pictureData.suggestFileExtension());
							try {
								FileOutputStream fop = new FileOutputStream(file);
								if (!file.exists()) {
									file.createNewFile();
								}
								fop.write(data);
								fop.flush();
								fop.close();
								// System.out.println("Llegó a leer la imagen");
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					}
				}
			}
			// }
		}
		return file.getName();
	}

	private static String findFilaCelda(HSSFSheet sheet, String codigoTPregunta) {
		String datoCelda = null;
		boolean finRow = false;
		for (Row row : sheet) {
			if (finRow == false) {
				for (Cell cell : row) {
					if (cell.getColumnIndex() == 0) {
						if (cell.getRichStringCellValue().getString().trim().equals(codigoTPregunta)) {
							HSSFRow fila = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell celda = fila.getCell(1);
							if (celda != null) {
								if (codigoTPregunta.equals("{IMG_LECCION}")) {
									// Este el dato que insertaremos (ruta de
									// imagen)
									datoCelda = findFilaCeldaImage(sheet, row.getRowNum(), 1);
								} else {
									// Este el dato que insertaremos
									datoCelda = row.getRowNum() + ":" + celda.toString();
								}
								System.out.println("datoCabecera:" + datoCelda);
								finRow = true;
								break;
							} else {
								System.out.println("No se encontró dato.");
							}
						}
					}
				}
			} else {
				break;
			}
		}
		return datoCelda;
	}

	private static List<String> findFilaCeldaPreguntas(HSSFSheet sheet, String codigoTPregunta) {
		List<String> listaPreguntas = new ArrayList<String>();
		boolean encontroPregunta = false;
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getColumnIndex() == 0) {
					// Buscamos la celda de codigoTPregunta
					if (cell.getRichStringCellValue().getString().trim().equals(codigoTPregunta)) {
						// Nos posicionamos en la fila
						HSSFRow rowTP = sheet.getRow(row.getRowNum());
						// obtenemos el valor de la fila en la celda 1
						HSSFCell cellNP = rowTP.getCell(1);
						// System.out.println(cellNP);
						if (cellNP != null) {
							// Este es el dato que insertaremos (PREGUNTA)
							System.out.println("Pregunta: " + codigoTPregunta + "-" + cellNP.toString());
							listaPreguntas.add(codigoTPregunta + ":" + cellNP.toString());
							encontroPregunta = true;
							break;
						} else {
							System.out.println("No se encontró pregunta o la celda está vacía.");
							encontroPregunta = false; // sigo buscando
						}
					}
					// Si encontré pregunta, buscamos respuestas
					else if (cell.getRichStringCellValue().getString().trim().equals("{*RP}")
							|| cell.getRichStringCellValue().getString().trim().equals("{[RP]}")) {
						// Nos posicionamos en la fila
						HSSFRow rowRP = sheet.getRow(row.getRowNum());
						// obtenemos el valor de la fila en el celda 0
						HSSFCell cellTR = rowRP.getCell(0);
						if (cellTR == null) {
							System.out.println("No hay más respuestas, cellTR es null. Se cierran la pregunta ");
							encontroPregunta = false;
						} else {
							// obtenemos el valor de la fila en el celda 1
							HSSFCell cellRP = rowRP.getCell(1);
							// System.out.println(" ." + cellTR + ":" + cellRP);
							if (cellRP != null) {
								// Este es el dato que insertaremos (RESPUESTA)
								// {*RP} (incorrectas) - {[RP]} (correctas)
								System.out.println("Respuesta: " + cell.getRichStringCellValue().getString().trim()
										+ "-" + cellRP);
								listaPreguntas.add(cell.getRichStringCellValue().getString().trim() + ":" + cellRP);
								break;
							} else {
								System.out.println("No se encontró respuesta o la celda está vacía.");
							}
						}
					} else {
						System.out.println("No hay más respuestas. Se cierran la pregunta ");
						encontroPregunta = false;
					}

				}
			}
		}
		return listaPreguntas;
	}

	public CargaMaterialController() {
		// String lsArchivo =
		// "C:\\Backup_Laptop\\Proyecto MINEDU -
		// Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls";
		// InputStream lmArchivo = null;
		// try {
		// lmArchivo = new FileInputStream(lsArchivo);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		// // Bucaremos todas las preguntas de tipo alternativas (para marcar)
		// String codigoTPregunta = "{TP_ALT}";
		// List<String> listaPreguntas = new ArrayList<String>();
		// HSSFWorkbook wb = null; // libro de trabajo
		// try {
		// wb = new HSSFWorkbook(lmArchivo);
		// HSSFSheet hoja = wb.getSheetAt(0);
		// // Cabecera
		// String nombreEjercicio = findFilaCelda(hoja, "{NOM_EJERCICIO}");
		// String desEjercicio = findFilaCelda(hoja, "{DES_EJERCICIO}");
		// String imgEjercicio = findFilaCelda(hoja, "{IMG_LECCION}");
		// // Detalle
		// listaPreguntas = findFilaCeldaPreguntas(hoja, codigoTPregunta);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

	@PostConstruct
	public void init() {
		this.setCargaMaterialBean(new CargaMaterialBean());
		this.setLstLenguaEstructuraBean(new ArrayList<LenguaEstructuraBean>());
		this.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("cargaMaterialBean") CargaMaterialBean cargaMaterialBean)
			throws Exception {
		System.out.println("-- ingreso a  listado --");
		// return this.getLista(cargaMaterialBean);
		ModelAndView mav = new ModelAndView("general/listado-carga-material", "command", cargaMaterialBean);
		mav.addObject("lstLenguaEstructuraBean", new ArrayList<LenguaEstructuraBean>());
		mav.addObject("lstCargaMaterialBean", new ArrayList<CargaMaterialBean>());
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("cargaMaterialBean") CargaMaterialBean cargaMaterialBean)
			throws Exception {
		System.out.println("--- Ingreso a buscar ---");
		return this.getLista(cargaMaterialBean);
	}

	@RequestMapping(value = "/buscarActividad", method = RequestMethod.POST)
	public ModelAndView doBuscarActividad(@ModelAttribute("cargaMaterialBean") CargaMaterialBean cargaMaterialBean)
			throws Exception {
		System.out.println("--- Ingreso a buscar Actividad---");
		return this.getListar(cargaMaterialBean);
	}
	
	@RequestMapping(value = "/cargarComboMaterial", method = RequestMethod.POST)
	@ResponseBody
	public List<LeccionMaterialBean> getCargarComboMaterial(@RequestParam("codigoLeccion") Integer codigoLeccion) 
	{
		List<LeccionMaterialBean> lst = null;
		LeccionMaterialBean materialBean = new LeccionMaterialBean();
		materialBean.getUnidadLeccionBean().setCodigo(codigoLeccion);
		try {
			lst = leccionMaterialService.buscarPorLeccion(materialBean);
			if (lst != null) {
				System.out.println("------------------> Tamaño lst material" + lst.size());
			}
			else {
				System.out.println("El listado está vacío");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lst;
	}

	private ModelAndView getLista(CargaMaterialBean cargaMaterialBean) {

		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		List<CargaMaterialBean> lstCargaMaterialBean = new ArrayList<CargaMaterialBean>();
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		lenguaEstructuraBean.setLenguaBean(cargaMaterialBean.getLengua());
		lenguaEstructuraBean.setSituacion(cargaMaterialBean.getSituacion());
		try {
			lstLenguaEstructuraBean = lenguaEstructuraService.listarMaterial(lenguaEstructuraBean);
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("general/listado-carga-material", "command", cargaMaterialBean);
		mav.addObject("lstLenguaEstructuraBean", lstLenguaEstructuraBean);
		mav.addObject("lstCargaMaterialBean", lstCargaMaterialBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		System.out.println("-- ingreso a  nuevo --");
		cargaMaterialBean = new CargaMaterialBean();
		// ModelAndView mav = new
		// ModelAndView("general/registro-carga-material", "command",new
		// CargaMaterialBean());
		// -- ModelAndView mav = getListar(new CargaMaterialBean());
		// mav.addObject("cargaMaterialBean", new CargaMaterialBean());
		// this.cargarCombos(mav);
		// -- return mav;
		ModelAndView mav = new ModelAndView("general/registro-carga-material", "command", cargaMaterialBean);

		mav.addObject("cargaMaterialBean", new CargaMaterialBean());
		// mav.addObject("lstEjercicioBean", new ArrayList<EjercicioBean>());
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/cargarContenido", method = RequestMethod.POST)
	public ModelAndView cargarContenido(@RequestParam("valor") String valor,
			@RequestParam("codigoleccion") String codigoleccion, @RequestParam("liMatLecc") String liMatLecc) {

		String url = "";
		ModelAndView mav;

		switch (Integer.valueOf(valor)) {
		case 1:
			url = "/actividad/act-01_";

			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
//			cargarEjercicio(mav, valor, codigoleccion);
			break;
		case 2:
			url = "/actividad/act-02";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
//			cargarEjercicio(mav, valor, codigoleccion);
			cargarEjercicio(mav, valor, codigoleccion, liMatLecc);
			break;
		case 3:
			url = "/actividad/act-02_";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 4:
			url = "/actividad/act-03";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 5:
			url = "/actividad/act-06";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 6:
			url = "/actividad/act-08";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 7:
			url = "/actividad/act-10";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 8:
			url = "/actividad/act-12";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 9:
			url = "/actividad/act-15";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 10:
			url = "/actividad/act-16";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 11:
			url = "/actividad/act-17";

			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 12:
			url = "/actividad/act-19";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 13:
			url = "/actividad/act-20";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 14:
			url = "/actividad/act-32";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 15:
			url = "/actividad/act-23";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 16:
			url = "/actividad/act-26";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 17:
			url = "/actividad/act-50";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 18:
			url = "/actividad/act-18";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
//			cargarEjercicio(mav, valor, codigoleccion);
			break;
		case 19:
			url = "/actividad/act-29";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 20:
			url = "/actividad/act-30";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 21:
			url = "/actividad/act-31";

			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 22:
			url = "/actividad/act-22";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			
//			cargarEjercicio(mav, valor, codigoleccion);
			
			break;
		case 23:
			url = "/actividad/act-33";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 24:
			url = "/actividad/act-34";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 25:
			url = "/actividad/act-35";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 26:
			url = "/actividad/act-01_";

			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			
			url = "/actividad/act-26";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
//			cargarEjercicio(mav, valor, codigoleccion);
			break;
		case 27:
			url = "/actividad/act-51";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
//			cargarEjercicio(mav, valor, codigoleccion);
			break;

		case 28:
			url = "/actividad/act-52";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 29:
			url = "/actividad/act-53";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		case 30:
			url = "/actividad/act-54";
			System.out.println("URL :: " + url);
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;

		// case 31:
		// url = "/actividad/act-01";
		//
		// System.out.println("URL :: "+ url);
		// break;
		// case 32:
		// url = "/actividad/act-02";
		// System.out.println("URL :: "+ url);
		// break;
		// case 33:
		// url = "/actividad/act-02_";
		// System.out.println("URL :: "+ url);
		// break;
		// case 34:
		// url = "/actividad/act-03";
		// System.out.println("URL :: "+ url);
		// break;

		// case 999:
		// url = "/actividad/informes";
		// System.out.println("URL :: "+ url);
		// break;
		default:
			url = "/actividad/act-proceso";
			mav = new ModelAndView(url, "command", new CargaMaterialBean());
			break;
		}

		return mav;
	}

	@RequestMapping(value = "/cargarContenidoPrincipal", method = RequestMethod.POST)
	public ModelAndView cargarContenidoPrincipal(@RequestParam("valor") String valor,
			@RequestParam("codigolengua") Integer codigolengua, @RequestParam("codigonivel") Integer codigonivel,
			@RequestParam("codigosubnivel") Integer codigosubnivel, @RequestParam("liCodUnid") Integer liCodUnid) {

		UnidadBean unidadLeccionBean = new UnidadBean();
		unidadLeccionBean.setCodigo(liCodUnid);
		
		try {
			lstLeccion = unidadLeccionService.listarPorUnidad(unidadLeccionBean);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		// System.out.println("lstLeccion() :: " + lstLeccion);

		ModelAndView mav = new ModelAndView("/actividad/informes", "command", new CargaMaterialBean());
		mav.addObject("lenguaActividad", lenguaActividad);
		mav.addObject("lstLeccion", lstLeccion);
		return mav;
	}

	@RequestMapping(value = "/cargarNiveles", method = RequestMethod.GET)
	public @ResponseBody List<MaestraBean> cargarNiveles(@RequestParam("codlengua") String codigo) throws Exception {
		List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
		if (!codigo.equals("0")) {
			LenguaBean filtro = new LenguaBean();
			filtro.setCodigo(VO.toLong(codigo));
			List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarNiveles(filtro);

			if (!VO.isEmptyList(lstLenguaEstructuraBeanNivel)) {
				for (LenguaEstructuraBean objLenEstNivel : lstLenguaEstructuraBeanNivel) {
					if (!VO.isEmptyList(lstNivel)) {
						for (MaestraBean objMaestroNivel : lstNivel) {
							if (objMaestroNivel.getCodigoRegistro() == objLenEstNivel.getNivel().getCodigoRegistro()) {
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

/*	@RequestMapping(value = "/cargarSubNiveles", method = RequestMethod.GET)
	public @ResponseBody List<MaestraBean> cargarSubNiveles(@RequestParam("codlengua") String codlengua,
			@RequestParam("codnivel") String codnivel) throws Exception {
		List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
		if (!codlengua.equals("0") && !codnivel.equals("0")) {
			LenguaEstructuraBean filtro = new LenguaEstructuraBean();
			filtro.getLenguaBean().setCodigo(VO.toLong(codlengua));
			filtro.getNivel().setCodigoRegistro(VO.toInteger(codnivel));
			List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarSubNiveles(filtro);

			if (!VO.isEmptyList(lstLenguaEstructuraBeanNivel)) {
				for (LenguaEstructuraBean objLenEstSubNivel : lstLenguaEstructuraBeanNivel) {
					if (!VO.isEmptyList(lstSubNivel)) {
						for (MaestraBean objMaestroSubNivel : lstSubNivel) {
							if (objMaestroSubNivel.getCodigoRegistro() == objLenEstSubNivel.getSubNivel()
									.getCodigoRegistro()) {
								lista_response.add(objMaestroSubNivel);
								break;
							}
						}
					}
				}
			}
		}
		return lista_response;
	}
*/
	
	@RequestMapping(value = "/cargarSubNiveles", method = RequestMethod.GET)
	public @ResponseBody List<LenguaEstructuraBean> cargarSubNiveles(
			@RequestParam("codlengua") Integer codlengua,
			@RequestParam("codnivel") Integer codnivel) throws Exception {
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel = new ArrayList<LenguaEstructuraBean>();
	    LenguaBean lenguaBean= new LenguaBean();
	    lenguaBean.setCodigo(codlengua);
		LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
		prmLenguaEstructuraBean.getNivel().setCodigoRegistro(codnivel); 
		prmLenguaEstructuraBean.setLenguaBean(lenguaBean);
		System.out.println("cargarSubNiveles codlengua " + codlengua);
		System.out.println("cargarSubNiveles codnivel " + codnivel); 
		if (codlengua > 0 && codnivel > 0) {
			
			lstLenguaEstructuraBeanSubNivel = 
						lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean); 
		}
		return lstLenguaEstructuraBeanSubNivel;
	}
	
	@RequestMapping(value = "/cargarUnidades", method = RequestMethod.GET)
	public @ResponseBody List<UnidadBean> cargarUnidades(
			@RequestParam("codlenest") Integer codlenguaEstructura )throws Exception {
		List<UnidadBean> lstUnidadBean = new ArrayList<UnidadBean>();
	    
	    UnidadBean unidadBean = new UnidadBean();
		LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
		prmLenguaEstructuraBean.setCodigo(codlenguaEstructura);
		unidadBean.setLenguaEstructuraBean(prmLenguaEstructuraBean);
		System.out.println("codlenguaEstructura " + codlenguaEstructura); 
		if (codlenguaEstructura > 0 ) {
			
			lstUnidadBean = 
					unidadService.getBuscarPorFiltros(unidadBean); 
		}
		return lstUnidadBean;
	}
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstNivel = maestra2Service.listarPorCodigoTabla("nivel", 1);
			lstUnidad = maestra2Service.listarPorCodigoTabla("unidad", 0);
			lstSubNivel = maestra2Service.listarPorCodigoTabla("subNivel", 0);
			lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua", 0);
			lstLengua = lenguaService.cargarCombo();
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstNivel", lstNivel);
		mav.addObject("lstSubNivel", lstSubNivel);
		mav.addObject("lstSituacion", lstSituacion);
		mav.addObject("lstLengua", lstLengua);
		mav.addObject("lstUnidad", lstUnidad);
	}

	private void cargarLengua(ModelAndView mav, int codigolengua, int codigonivel, int codigosubnivel, int liCodUnid) {
		// CargaMaterialBean oMaterial = new CargaMaterialBean();
		LenguaEstructuraBean estructuraBean = new LenguaEstructuraBean();
		UnidadBean unidadBean = new UnidadBean();
		// oMaterial.getLeccion().getLengua().setCodigo(codigolengua);
		// oMaterial.getLeccion().getTm2Nivel().setCodigoRegistro(codigonivel);
		// oMaterial.getLeccion().getTm2SubNivel()
		// .setCodigoRegistro(codigosubnivel);
		estructuraBean.getLenguaBean().setCodigo(codigolengua);
		estructuraBean.getNivel().setCodigo(codigonivel);
		estructuraBean.getSubNivel().setCodigo(codigosubnivel);

		UnidadBean unidadLeccionBean = new UnidadBean();
		unidadLeccionBean.setCodigo(liCodUnid);
		//unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getNivel().setCodigoRegistro(codigonivel);
		try {
			unidadBean = unidadService.buscarLengua(estructuraBean);
			lstLeccion = unidadLeccionService.listarPorUnidad(unidadLeccionBean);
			// lstLeccion = leccionService.getListarPorCriterios(oMaterial
			// .getLeccion());
			// // lstTipoEjercicio =
			// // maestra2Service.listarPorCodigoTabla("ejercicio");
			// System.out.println(lenguaActividad);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
	
		LenguaBean lenguaBean = new LenguaBean();
		//COMENTADO POR PRUEBAS
//		if (unidadBean != null) {
//			lenguaBean = unidadBean.getLenguaEstructuraBean().getLenguaBean();
//			mav.addObject("lenguaBean", lenguaBean);
//		}
		lenguaBean = unidadBean.getLenguaEstructuraBean().getLenguaBean();
		mav.addObject("lenguaBean", lenguaBean);
		mav.addObject("lstLeccion", lstLeccion);
		//lstLeccionMaterial
	}
	
	@RequestMapping(value = "/buscarLeccionMaterial", method = RequestMethod.POST)
	public @ResponseBody List<LeccionMaterialBean> buscarLeccionMaterial(@RequestParam("liCodLecc") int liCodLecc) throws Exception {
		List<LeccionMaterialBean> lstLecMate = new ArrayList<LeccionMaterialBean>();

		LeccionMaterialBean buscar = new LeccionMaterialBean();
		buscar.getUnidadLeccionBean().setCodigo(liCodLecc);
		lstLecMate = leccionMaterialService.buscarPorLeccion(buscar);
		// prmDocenteBean.setNombre("");
		if (lstLecMate == null) {
			lstLecMate = new ArrayList<LeccionMaterialBean>();
		}
		System.out.println(lstLecMate.size());
		return lstLecMate;
	}

	private void cargarEjercicio(ModelAndView mav, String lsTipEjerc, String lsCodLecc, String liMatLecc ) {
		System.out.println("idTipoEjercicio ---> " + lsTipEjerc);
		PreguntaBean preguntaBean = new PreguntaBean();
		List<PreguntaBean> datosMatTEjerPregunta = new ArrayList<PreguntaBean>();
		if(lsTipEjerc.equals("2")){
			
			preguntaBean.getMaterialEjercicioBean().getLeccionMaterialBean().setCodigo(Integer.parseInt(liMatLecc) );
			preguntaBean.getMaterialEjercicioBean().getTipoEjercicio().setCodigoRegistro(Integer.parseInt(lsTipEjerc));
			try {
				datosMatTEjerPregunta = preguntaService.buscarPorMatTEjerPregunta(preguntaBean);	
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			List<AlternativaBean> lstRespuestas = new ArrayList<AlternativaBean>();
			AlternativaBean alternativa = new AlternativaBean();
			alternativa.setRespuestaEstado("0");
			lstRespuestas.add(alternativa);
			lstRespuestas.add(alternativa);
			lstRespuestas.add(alternativa);
			lstRespuestas.add(alternativa);
			mav.addObject("actividadMatTipoEjer",datosMatTEjerPregunta);
			mav.addObject("lstRespuestas",lstRespuestas);
		}
		
		// EjercicioBean ejercicio = new EjercicioBean();
		//
		// ejercicio.getTm2TipoEjercicio().setCodigoRegistro(
		// Integer.valueOf(idTipoEjercicio));
		// ejercicio.getLeccion().setCodigo(Integer.valueOf(idLeccion));
		//
		// try {
		//// ejercicio = ejercicioService.getBuscarPorObjecto(ejercicio);
		// if (ejercicio != null) {
		// System.out.println(ejercicio.getTituloEjercicio());
		// } else {
		// System.out.println("No se pudo obtener el titulo");
		// }
		//
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		// if (ejercicio != null) {
		// mav.addObject("ejercicio", ejercicio);
		// }
	}

	private void cargarTipoEjercicios(ModelAndView mav) {
		try {
			lstTipoEjercicio = maestra2Service.listarPorCodigoTabla("ejercicio", 0);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstTipoEjercicio", lstTipoEjercicio);
	}

	@RequestMapping(value = "/actividadCargarModal", method = RequestMethod.POST)
	public ModelAndView doActividadaCargarModal(@RequestParam("codigolengua") Integer codigolengua,
			@RequestParam("codigonivel") Integer codigonivel, @RequestParam("codigosubnivel") Integer codigosubnivel, 
			@RequestParam("liCodUnid") Integer liCodUnid) {

		ModelAndView mav = new ModelAndView("../layout/actividad-modal-view", "command", new CargaMaterialBean());

//		this.cargarCombos(mav);

		this.cargarTipoEjercicios(mav);

		this.cargarLengua(mav, codigolengua, codigonivel, codigosubnivel,liCodUnid);
		return mav;
	}

	/*
	 * @RequestMapping(value = "/grabarleccion", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public List<LeccionBean> doGrabarLeccion(
	 * 
	 * @RequestParam("nombreleccion") String nombreleccion,
	 * 
	 * @RequestParam("codigolengua") Integer codigolengua,
	 * 
	 * @RequestParam("codigonivel") Integer codigonivel,
	 * 
	 * @RequestParam("codigosubnivel") Integer codigosubnivel,
	 * 
	 * @RequestParam("codigounidad") Integer codigounidad) { List<LeccionBean>
	 * lstLecciones = null; LeccionBean leccionBean = new LeccionBean();
	 * 
	 * leccionBean.setNombreLeccion(nombreleccion);
	 * leccionBean.getLengua().setCodigo(codigolengua);
	 * leccionBean.getTm2Nivel().setCodigoRegistro(codigonivel);
	 * leccionBean.getTm2SubNivel().setCodigoRegistro(codigosubnivel);
	 * leccionBean.getTm2Unidad().setCodigoRegistro(codigounidad);
	 * 
	 * try { if (leccionService.insertar(leccionBean)) {
	 * System.out.println("Se insertó el registro con éxito"); lstLecciones =
	 * leccionService .getListarPorCriterios(leccionBean); } else {
	 * System.out.println("Falló el registro"); } } catch (ServiceException e) {
	 * e.printStackTrace(); } System.out.println("lstLeccion.size() :: " +
	 * lstLeccion.size());
	 * 
	 * return lstLecciones; }
	 */
	@RequestMapping(value = "/grabarejercicio", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarEjercicio(@RequestParam("tituloejercicio") String tituloejercicio,
			@RequestParam("descripcion") String descripcion, @RequestParam("codleccion") Integer codleccion,
			@RequestParam("tm2tipoejercicio") Integer tm2tipoejercicio) {
		// List<EjercicioBean> lstEjercicios = null;
		// EjercicioBean ejercicioBean = new EjercicioBean();
		//
		// ejercicioBean.setTituloEjercicio(tituloejercicio);
		// ejercicioBean.setDescripcionEjercicio(descripcion);
		// ejercicioBean.getLeccion().setCodigo(codleccion);
		// ejercicioBean.getTm2TipoEjercicio().setCodigoRegistro(tm2tipoejercicio);
		//
		// try {
		// if (ejercicioService.insertar(ejercicioBean)) {
		// System.out.println("Se insertó el ejercicio con éxito");
		// // lstEjercicios =
		// // ejercicioService.getBuscarPorFiltros(ejercicioBean);
		// } else {
		// System.out.println("Falló el registro");
		// }
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }

		// System.out.println("lstEjercicios.size() :: "+ lstEjercicios.size());
		// return String.valueOf(ejercicioBean.getCodigo());
		// PROVISIONAL
		return "";
	}

	@RequestMapping(value = "/grabarMaterialTipoEjercicio", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarMaterialTipoEjercicio(@RequestParam("liTipoSQL") Integer liTipoSQL,
			@RequestParam("liMatTEje") Integer liMatTEje,@RequestParam("liCodLecc") Integer liCodLecc,
			@RequestParam("liCodMate") Integer liCodMate, @RequestParam("liTipEjer") Integer liTipEjer,
			@RequestParam("lsTitTEje") String lsTitTEje,@RequestParam("liSituaci") Integer liSituaci) {
		String lsResulta = "";
		MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
		materialTipoEjercicioBean.getLeccionMaterialBean().setCodigo(liCodMate);
		materialTipoEjercicioBean.getTipoEjercicio().setCodigoRegistro(liTipEjer);
		materialTipoEjercicioBean.getSituacionTipo().setCodigoRegistro(liSituaci);
		materialTipoEjercicioBean.setTitulo(lsTitTEje);
		materialTipoEjercicioBean.setCodigo(liMatTEje);
		if (liTipoSQL == 1) {
			materialTipoEjercicioBean.setCodigoUsuarioCreacion(123);
			materialTipoEjercicioBean.setIpCreacion("ip");
		} else {
			materialTipoEjercicioBean.setCodigoUsuarioModificacion(1234);
			materialTipoEjercicioBean.setIpModificacion("ipmod");
		}
		try {
			if (liTipoSQL == 1) {
				if (materialTipoEjercicioService.insertar(materialTipoEjercicioBean)) {
					System.out.println("Se insertó el registro con éxito");
					lsResulta = Integer.toString((int) materialTipoEjercicioBean.getCodigo());
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			} else if (liTipoSQL == 2) {
				if (materialTipoEjercicioService.actualizar(materialTipoEjercicioBean)) {
					System.out.println("Se actualizó el registro con éxito");
					lsResulta = Integer.toString(liMatTEje);
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			} else {
				System.out.println("Falló el registro. No se encontró tipo de acción.");
				lsResulta = "0";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lsResulta;
	
	}
	
	
	@RequestMapping(value = "/buscarRespuestasPregMaTEjer", method = RequestMethod.POST)
	 public @ResponseBody List<AlternativaBean> listadoRespuestasPregunta(
	 @RequestParam("liCodPreg") int liCodPreg) throws Exception {
	 List<AlternativaBean> lstRespuestas = new ArrayList<AlternativaBean>();
	 PreguntaBean preguntaBean = new PreguntaBean();
	 preguntaBean.setCodigo(liCodPreg);
	 try {
			lstRespuestas = alternativaService.buscarPorCodigoPregunta(preguntaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (lstRespuestas == null) {
			lstRespuestas = new ArrayList<AlternativaBean>();
		}

	 System.out.println(lstRespuestas.toString());
	 return lstRespuestas;
}
	
	@RequestMapping(value = "/eliminarMatTEjerPreg", method = RequestMethod.POST)
	@ResponseBody
	public String doEliminarMatTEjerPreg(@RequestParam("liMatTEje") Integer liMatTEje) {
		String lsResulta="";
		MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
		materialTipoEjercicioBean.setCodigo(liMatTEje);
		materialTipoEjercicioBean.setCodigoUsuarioModificacion(666);
		materialTipoEjercicioBean.setIpModificacion("dels77");
		try {
			
				if (materialTipoEjercicioService.eliminar(materialTipoEjercicioBean)) {
					System.out.println("Se insertó el registro con éxito");
					lsResulta = Integer.toString((int) materialTipoEjercicioBean.getCodigo());
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lsResulta;
	}
//	jn9
	// ARRASTRAR ORACIONES
	@RequestMapping(value = "/grabarArrastraOracion", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarArrastraOracion(@RequestParam("p_titulo") String titulo,
			@RequestParam("p_oracion") String oracion, @RequestParam("p_codmatpej") Integer codmatpej, @RequestParam("id_ArrastraOraci") Integer idArrastraOraci ) {
		 ArrastraOraciBean Bean = new ArrastraOraciBean();
		 Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		 Bean.getMaterialTipoEjercicioBean().setCodigo(codmatpej);
		 Bean.setTitulo(titulo);
		 Bean.setOracion(oracion);
		 Bean.setCodigo(idArrastraOraci); 
			try {
				if (Bean.getCodigo() != 0) {
					arrastraOraciService.actualizar(Bean); 
				}else{ 
					arrastraOraciService.insertar(Bean); 
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 }
 
			 return String.valueOf(Bean.getCodigo());
 
		}
	
	@RequestMapping(value = "/ListArrastOraxMaterialTE", method = RequestMethod.GET)
	@ResponseBody 
	public ArrastraOraciBean doListArrastxMaterialTE(@RequestParam("p_codmatpej") Integer codmatTE){
		System.out.println("idTipoEjercicio " + codmatTE);
	 
		ArrastraOraciBean  Bean = new ArrastraOraciBean();
		Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean()); 
		Bean.getMaterialTipoEjercicioBean().setCodigo(codmatTE);
		
		try {
			Bean = this.arrastraOraciService.getBuscarPorTEM(Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;
	}
	
	@RequestMapping(value = "/grabarRespuestaArrastraOraci", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarRespuestaArrastraOraci(@RequestParam("p_oraciondet") String descripcion,
			@RequestParam("p_numorden") String orden, @RequestParam("p_codarrastraora") Integer codOracionGene, @RequestParam("p_codoraxArrastrar") Integer idOracion ) {
		ArrastraOraDetBean Bean = new ArrastraOraDetBean ();
		 Bean.setArrastraOraciBean(new ArrastraOraciBean());
		 Bean.getArrastraOraciBean().setCodigo(codOracionGene);
		 Bean.setOrden(orden);
		 Bean.setDescripcion(descripcion); 
		 Bean.setCodigo(idOracion); 
			try {
				if (Bean.getCodigo() != 0) {
					arrastraOraDetService.actualizar(Bean); 
					System.out.println("PASO A ACTUALIZAR");
				}else{ 
					arrastraOraDetService.insertar(Bean); 
					System.out.println("PASO A INSERTAR");
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 }
 
			 return String.valueOf(Bean.getCodigo());
 
		}
	
	
	@RequestMapping(value = "/BuscarRespArrastrarxCodigo", method = RequestMethod.GET)
	@ResponseBody 
	public ArrastraOraDetBean doBuscarArrastrarxCodigo(@RequestParam("p_codoraxarrastrar") Integer idOracion,
			HttpServletRequest request) {
		ArrastraOraDetBean  Bean = new ArrastraOraDetBean ();
		Bean.setArrastraOraciBean(new ArrastraOraciBean()); 
		Bean.setCodigo(idOracion);
		
		try { System.out.println("LOGR" + Bean + "");
			Bean = this.arrastraOraDetService.getBuscarPorObjecto(Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;
	}
	
	
	@RequestMapping(value = "/ListRespuestasArrastrar", method = RequestMethod.POST)
	@ResponseBody 
	public List<ArrastraOraDetBean> doListRespuestasArrastrar(@RequestParam("p_codarrastraora") Integer idOracion)
	{
		ArrastraOraDetBean  Bean = new ArrastraOraDetBean ();
		Bean.setArrastraOraciBean(new ArrastraOraciBean());  
		Bean.getArrastraOraciBean().setCodigo(idOracion);
		
		List<ArrastraOraDetBean> lstBean  = new ArrayList<ArrastraOraDetBean>();
		try{
			lstBean =  this.arrastraOraDetService.buscarPorCodigoOracion(Bean);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstBean.size() + "CODIGO  idOracion " + idOracion + "WE" +  lstBean);
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	
	@RequestMapping(value = "/eliminarArrastrar", method = RequestMethod.GET)
	@ResponseBody
	public void doeliminarArrastrar(@RequestParam("p_codoraxArrastrar") Integer cod ,
			HttpServletRequest request) {
		boolean sw = false; 
		ArrastraOraDetBean  Bean = new ArrastraOraDetBean(); 
		Bean.setCodigo(cod);
		 

		// this.setAuditoria(lenguaBean, request, false);
		try {
			sw = (arrastraOraDetService.eliminar(Bean));
			System.out.println("paso a eliminar");

		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	// ORACION POR OOMPLETAR
	@RequestMapping(value = "/grabaroracioncompletar", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarOracionCompletar(@RequestParam("p_titulo") String titulo,
			@RequestParam("p_oracion") String oracion, @RequestParam("p_codmatpej") Integer codmatpej, @RequestParam("idOracionComple") Integer idOracionComple ) {
//		 List<OracionCompletarBean> lstEjercicios = null;
		 OracionCompletarBean Bean = new OracionCompletarBean();
		 Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		 Bean.getMaterialTipoEjercicioBean().setCodigo(codmatpej);
		 Bean.setTitulo(titulo);
		 Bean.setOracion(oracion);
		 Bean.setCodigo(idOracionComple);
		  
//		 long valor = 0;
			try {
				if (Bean.getCodigo() != 0) {
					oracionCompletarService.actualizar(Bean);
//					valor = materialTipoEjercicioBean.getCodigo();
				}else{ 
					oracionCompletarService.insertar(Bean);
//					valor = materialTipoEjercicioBean.getCodigo();
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 }
				
//		 try {
//		 if (oracionCompletarService.insertar(Bean)) {
//		 System.out.println("Se insertó el ejercicio con éxito");
//		 // lstEjercicios =
//		 // ejercicioService.getBuscarPorFiltros(ejercicioBean);
//		 } else {
//		 System.out.println("Falló el registro");
//		 } 
//			 System.out.println("lstEjercicios.size() :: "+ lstEjercicios.size());
			 return String.valueOf(Bean.getCodigo());
//			 PROVISIONAL
//			return "";
		}
	
	@RequestMapping(value = "/grabarOracionAlter", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarOracionAlter(@RequestBody OracionAlterBean[] respuestaArray)  {
		 System.out.println("respuestaArray.length" + respuestaArray.length);
		 OracionAlterBean alternativaBean = new OracionAlterBean();
		 alternativaBean.setOracionCompletarBean(new OracionCompletarBean());
//		 alternativaBean.setEspacio("2");
		 for (int i = 0; i < respuestaArray.length; i++) {
			 
		 System.out.println(respuestaArray[i] + "\n");
		 System.out.println("wuuuuuuuuuu"+respuestaArray[i].getOracionCompletarBean().getCodigo()
		 + "\n");
		 alternativaBean.getOracionCompletarBean().setCodigo(
		 respuestaArray[i].getOracionCompletarBean().getCodigo());
//		 alternativaBean.setEspacio(respuestaArray[i].getEspacio());
		 alternativaBean.setEspacio(respuestaArray[i].getEspacio());
		 alternativaBean.setDescripcion(respuestaArray[i].getDescripcion());
		 alternativaBean.setRespuestaEstado(respuestaArray[i]
		 .getRespuestaEstado()); 
		 alternativaBean.setCodigo(respuestaArray[i]
				 .getCodigo());
		
		 try {  
			 if (  alternativaBean.getCodigo()  != 0)  {
				 oracionAlterService.actualizar(alternativaBean);
//		 if (oracionAlterService.insertar(alternativaBean)) {
 		 System.out.println("actualizandooo");
		
		 } else { 
//		 System.out.println("Falló el registro");
			 oracionAlterService.insertar(alternativaBean);
			 System.out.println("insertandoooooo");
		 }
		 } catch (ServiceException e) {
		 e.printStackTrace();
		 }
		 }
		 return String.valueOf(alternativaBean.getCodigo());
	}
	
	
	
	
	
	@RequestMapping(value = "/ListOracionxMaterialTE", method = RequestMethod.GET)
	@ResponseBody 
	public OracionCompletarBean doListOracionxMaterialTE(@RequestParam("p_codmatpej") Integer codmatTE){
		System.out.println("idTipoEjercicio " + codmatTE);
	 
		OracionCompletarBean oracionCompletarBean = new OracionCompletarBean();
		oracionCompletarBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean()); 
		oracionCompletarBean.getMaterialTipoEjercicioBean().setCodigo(codmatTE);
		
		try {
			oracionCompletarBean = this.oracionCompletarService.getBuscarPorTEM(oracionCompletarBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oracionCompletarBean;
	}
	
	
//	@RequestMapping(value = "/ListEspacioxOracion", method = RequestMethod.POST)
//	@ResponseBody 
//	public OracionAlterBean doListEspacioxOracion(@RequestParam("p_codcomporacion") Integer codOracion){
//		System.out.println("idTipoEjercicio " + codOracion);
//	 
//		OracionAlterBean  Bean = new OracionAlterBean();
//		Bean.setOracionCompletarBean(new OracionCompletarBean()); 
//		Bean.getOracionCompletarBean().setCodigo(codOracion);
//		
//		try {
//			Bean = this.oracionAlterService.getBuscarPorObjecto(Bean);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return Bean;
//	}
	
	
	
	@RequestMapping(value = "/ListEspacioxOracion", method = RequestMethod.POST)
	@ResponseBody 
	public List<OracionAlterBean> doListEspacioxOracion(@RequestParam("p_codcomporacion") Integer codOracion)
	{
		OracionAlterBean  Bean = new OracionAlterBean();
		Bean.setOracionCompletarBean(new OracionCompletarBean()); 
		Bean.getOracionCompletarBean().setCodigo(codOracion);
		
		List<OracionAlterBean> lstBean  = new ArrayList<OracionAlterBean>();
		try{
			lstBean = this.getOracionAlterService().getBuscarPorOracion(Bean);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	
	
	@RequestMapping(value = "/BuscarAlternativasxEspacioOracion", method = RequestMethod.GET)
	@ResponseBody 
	public List<OracionAlterBean> dobuscarAlternativasxEspacioOracion(@RequestParam("p_codcomporacion") Integer codOracion,@RequestParam("p_numespacio") String Espacio)
	{
		OracionAlterBean  Bean = new OracionAlterBean();
		Bean.setOracionCompletarBean(new OracionCompletarBean()); 
		Bean.getOracionCompletarBean().setCodigo(codOracion);
		Bean.setEspacio(Espacio);
		
		List<OracionAlterBean> lstBean  = new ArrayList<OracionAlterBean>();
		try{
			lstBean = this.getOracionAlterService().buscarPorEspacioOracion(Bean);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	
	@RequestMapping(value = "/eliminarAlternativasOracion", method = RequestMethod.GET)
	@ResponseBody
	public void eliminaralterora(@RequestParam("p_codcomporacion") Integer codoracion,@RequestParam("p_numespacio") String codEspacio,
			HttpServletRequest request) {
		boolean sw = false; 
		OracionAlterBean  Bean = new OracionAlterBean();
		Bean.setOracionCompletarBean(new OracionCompletarBean()); 
		Bean.getOracionCompletarBean().setCodigo(codoracion);
		Bean.setEspacio(codEspacio);

		// this.setAuditoria(lenguaBean, request, false);
		try {
			sw = (this.getOracionAlterService().eliminar(Bean));

		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
//	jn9
	@RequestMapping(value = "/grabarPregunta", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarPregunta(@RequestParam("liTipoSQL") Integer liTipoSQL,
			@RequestParam("liMatTEje") Integer liMatTEje,
			@RequestParam("liCodPreg") Integer liCodPreg,
			@RequestParam("lsDesPreg") String lsDesPreg) {
		PreguntaBean preguntaBean = new PreguntaBean();
		String lsResulta = "";

		preguntaBean.setCodigo(liCodPreg);
		preguntaBean.setDescripcion(lsDesPreg);
		preguntaBean.getMaterialEjercicioBean().setCodigo(liMatTEje);
		preguntaBean.setTipoPregunta(1); 
		if (liTipoSQL == 1) {
			preguntaBean.setCodigoUsuarioCreacion(123);
			preguntaBean.setIpCreacion("ip");
		} else {
			preguntaBean.setCodigoUsuarioModificacion(1234);
			preguntaBean.setIpModificacion("ipmod");
		}
		try {
			if (liTipoSQL == 1) {
				if (preguntaService.insertar(preguntaBean)) {
					System.out.println("Se insertó el registro con éxito");
					lsResulta = Integer.toString((int) preguntaBean.getCodigo());
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			} else if (liTipoSQL == 2) {
				if (preguntaService.actualizar(preguntaBean)) {
					System.out.println("Se actualizó el registro con éxito");
					lsResulta = Integer.toString(liCodPreg);
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			} else {
				System.out.println("Falló el registro. No se encontró tipo de acción.");
				lsResulta = "0";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lsResulta;
	}
	
	@RequestMapping(value = "/grabarRespuestasPregunta", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarRespuestasPregunta(@RequestBody AlternativaBean[] respuestaArray) {
		System.out.println("respuestaArray.length" + respuestaArray.length);
		for (int i = 0; i < respuestaArray.length; i++) {
			String lsResulta="";
			AlternativaBean alternativaBean = new AlternativaBean();
			 System.out.println(respuestaArray[i] + "\n");
			 System.out.println(respuestaArray[i].getPreguntaBean().getCodigo() + "\n");
			 alternativaBean.getPreguntaBean().setCodigo(respuestaArray[i].getPreguntaBean().getCodigo());
			 alternativaBean.setDescripcion(respuestaArray[i].getDescripcion());
			 alternativaBean.setRespuestaEstado(respuestaArray[i].getRespuestaEstado());
			 alternativaBean.setCodigo(respuestaArray[i].getCodigo());
			 try {
				 if(respuestaArray[i].getCodigo()==0){
					 if (alternativaService.insertar(alternativaBean)) {
						 System.out.println("Se insertó el registro con éxito");
						 lsResulta = "1";
					 } else {
						 System.out.println("Falló el registro");
						 lsResulta = "0";
					 }
				 } else if(respuestaArray[i].getCodigo()>0){
					 if (alternativaService.actualizar(alternativaBean)) {
						 System.out.println("Se actualizó el registro con éxito");
						 lsResulta = "1";
					 } else {
						 System.out.println("Falló el registro");
						 lsResulta = "0";
					 }
				 }
				
			 } catch (ServiceException e) {
				 e.printStackTrace();
			 }
		}
		return "1";
	}
	/***
	@RequestMapping(value = "/grabarPregunta", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarPregunta(@RequestParam("codejercicio") Integer codejercicio,
			@RequestParam("descripcion") String descripcion, @RequestParam("pregunta") int pregunta) {
		PreguntaBean preguntaBean = new PreguntaBean();
		if (codejercicio != null) {
			// preguntaBean.getEjercicioBean().setCodigo(codejercicio);
			// preguntaBean.setDescripcion(descripcion);
			// preguntaBean.setTipoPregunta(1);
			// try {
			// if (preguntaService.insertar(preguntaBean)) {
			// System.out.println("Se insertó la pregunta con éxito");
			// // lstEjercicios =
			// // ejercicioService.getBuscarPorFiltros(ejercicioBean);
			// } else {
			// System.out.println("Falló el registro de pregunta");
			// }
			// } catch (ServiceException e) {
			// e.printStackTrace();
			// }
			//preguntaService.insertar(preguntaBean)
			return String.valueOf(preguntaBean.getCodigo());
		} else {
			System.out.println("El código de ejercicio está vacío");
			return null;
		}

		// System.out.println(preguntaBean.getCodigo());

	}
*/
	@RequestMapping(value = "/grabarrespuesta1", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarRespuesta() {
		// @RequestBody AlternativaBean[] respuestaArray) {
		// System.out.println("respuestaArray.length" + respuestaArray.length);
		// for (int i = 0; i < respuestaArray.length; i++) {
		// AlternativaBean alternativaBean = new AlternativaBean();
		// System.out.println(respuestaArray[i] + "\n");
		// System.out.println(respuestaArray[i].getPreguntaBean().getCodigo()
		// + "\n");
		// alternativaBean.getPreguntaBean().setCodigo(
		// respuestaArray[i].getPreguntaBean().getCodigo());
		// alternativaBean.setDescripcion(respuestaArray[i].getDescripcion());
		// alternativaBean.setRespuestaEstado(respuestaArray[i]
		// .getRespuestaEstado());
		//
		// try {
		// if (alternativaService.insertar(alternativaBean)) {
		// System.out.println("Se insertó el registro con éxito");
		//
		// } else {
		// System.out.println("Falló el registro");
		// }
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		// }
		return "Se insertó el registro";
	}

	@RequestMapping(value = "/actualizarPregunta", method = RequestMethod.POST)
	@ResponseBody
	public String doModificarPregunta(@RequestParam("codejercicio") Integer codejercicio,
			@RequestParam("descripcion") String descripcion, @RequestParam("pregunta") int pregunta) {
		PreguntaBean preguntaBean = new PreguntaBean();
		// preguntaBean.getEjercicioBean().setCodigo(codejercicio);
		// preguntaBean.setDescripcion(descripcion);
		// preguntaBean.setCodigo(pregunta);
		// try {
		// if (preguntaService.actualizar(preguntaBean)) {
		// System.out.println("Se actualizó el registro con éxito");
		// } else {
		// System.out.println("Falló el registro");
		// }
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		return String.valueOf(preguntaBean.getCodigo());
	}

	@RequestMapping(value = "/actualizarRelacion", method = RequestMethod.POST)
	@ResponseBody
	public String doModificarPregunta(@RequestParam("codejercicio") Integer codejercicio,
			@RequestParam("palabra") String palabra, @RequestParam("texto") String texto,
			@RequestParam("tiporelacion") Integer tiporelacion, @RequestParam("orden") Integer orden,
			@RequestParam("orientacion") Integer orientacion) {
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setCodigo(codejercicio);
		relacionBean.setPalabra(palabra);
		relacionBean.setTexto(texto);
		relacionBean.setTipoRelacion(tiporelacion);
		// relacionBean.setOrden(orden);
		// relacionBean.setOrientacion(orientacion);

		try {
			if (relacionService.actualizar(relacionBean)) {
				System.out.println("Se actualizó el registro con éxito");
			} else {
				System.out.println("Falló el registro");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return String.valueOf(relacionBean.getCodigo());
	}
	
/*	@RequestMapping(value = "/eliminarMaterialTipoEjercicio", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminarMaterialTipoEjercicio(@RequestParam("p_codmatpej") Integer p_codmatpej ) {
		if (p_codmatpej != null || p_codmatpej == 0 ) {
			System.out.println("error al eliminar");
		}
		MaterialTipoEjercicioBean Bean = new MaterialTipoEjercicioBean();		 
		Bean.setCodigo(p_codmatpej);
		 try {
		 if (materialTipoEjercicioService.eliminar(Bean)) {
		 System.out.println("Se eliminó el registro con éxito");
		 } else {
		 System.out.println("Falló el registro");
		 }
		 } catch (ServiceException e) {
		 e.printStackTrace();
		 }
		return String.valueOf(Bean.getCodigo());
	}*/
	@RequestMapping(value = "/eliminarMaterialTipoEjercicio", method = RequestMethod.GET)
	@ResponseBody
	public Long doEliminarMaterialTipoEjercicio(@RequestParam("p_codmatpej") Integer p_codmatpej){
		System.out.println("-----Ingreso a eliminar material parrafo ----");
		MaterialTipoEjercicioBean Bean = new MaterialTipoEjercicioBean();
		Bean.setCodigo(p_codmatpej);
		
		long valor = 0;
		try {
			if (Bean.getCodigo() != 0) {
				this.getMaterialTipoEjercicioService().eliminar(Bean);
				valor = 0;
			}else{

			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	 
	

	@RequestMapping(value = "/eliminarPregunta", method = RequestMethod.POST)
	@ResponseBody
	public String doEliminarPregunta(@RequestParam("codejercicio") Integer codejercicio,
			@RequestParam("descripcion") String descripcion, @RequestParam("pregunta") int pregunta) {
		PreguntaBean preguntaBean = new PreguntaBean();
		// preguntaBean.getEjercicioBean().setCodigo(codejercicio);
		// preguntaBean.setDescripcion(descripcion);
		// preguntaBean.setCodigo(pregunta);
		// try {
		// if (preguntaService.eliminar(preguntaBean)) {
		// System.out.println("Se eliminó el registro con éxito");
		// } else {
		// System.out.println("Falló el registro");
		// }
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		return String.valueOf(preguntaBean.getCodigo());
	}

	@RequestMapping(value = "/actualizarrespuesta", method = RequestMethod.POST)
	@ResponseBody
	public String doActualizarRespuesta() {
		// @RequestBody AlternativaBean[] respuestaArray) {
		// System.out.println("respuestaArray.length" + respuestaArray.length);
		// for (int i = 0; i < respuestaArray.length; i++) {
		// AlternativaBean respuestaBean = new AlternativaBean();
		// System.out.println(respuestaArray[i] + "\n");
		// System.out.println(respuestaArray[i].getPreguntaBean().getCodigo()
		// + "\n");
		// respuestaBean.getPreguntaBean().setCodigo(
		// respuestaArray[i].getPreguntaBean().getCodigo());
		// respuestaBean.setDescripcion(respuestaArray[i].getDescripcion());
		// respuestaBean.setRespuestaEstado(respuestaArray[i]
		// .getRespuestaEstado());
		// respuestaBean.setCodigo(respuestaArray[i].getCodigo());
		// try {
		// if (alternativaService.actualizar(respuestaBean)) {
		// System.out.println("Se actualizó el registro con éxito");
		//
		// } else {
		// System.out.println("Falló el registro");
		// }
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		// }
		return "Se actualizó el registro";
	}

	private void listarLecciones() {
		// EjercicioBean t = new EjercicioBean();
		// t.getLengua().setCodigo(0);
		// t.getLeccion().getTm2Nivel().setCodigoRegistro(0);
		// t.getLeccion().getTm2SubNivel().setCodigoRegistro(0);
		// t.getLeccion().getTm2Unidad().setCodigoRegistro(0);
		// t.setCodigo(0);
		// t.getLeccion().setCodigo(0);
		//
		// try {
		// lstEjercicio = ejercicioService.getBuscarPorFiltros(t);
		// if (lstEjercicio != null && lstEjercicio.size() > 0) {
		// System.out.println("lstEjercicio.size() :: "
		// + lstEjercicio.size());
		// } else {
		// System.out.println("La lista se encuentra vacia");
		// }
		//
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
	}

	@RequestMapping(value = "/grabarImagen", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarImagen(@RequestParam("codigoejercicio") Integer codigoejercicio,
			@RequestParam("tituloejercicio") String tituloejercicio, @RequestParam("descripcion") String descripcion,
			@RequestParam("codleccion") Integer codleccion, @RequestParam("tm2tipoejercicio") Integer tm2tipoejercicio,
			@RequestParam("file") MultipartFile[] files, @RequestParam("fileAudio") MultipartFile[] filesAudio) {
		System.out.println(codigoejercicio);
		System.out.println(tituloejercicio);
		System.out.println(descripcion);
		System.out.println(codleccion);
		System.out.println(tm2tipoejercicio);
		// EjercicioBean ejercicio = new EjercicioBean();
		boolean sw = true;
		boolean swNuevaUrlImagen = false;
		boolean swUrlAudio = false;
		MultipartFile fileAudio = null;
		if (codigoejercicio > 0) {
			// ejercicio.setCodigo(codigoejercicio);
		}
		// ejercicio.setTituloEjercicio(tituloejercicio);
		// ejercicio.setDescripcionEjercicio(descripcion);
		// ejercicio.getLeccion().setCodigo(codleccion);
		// ejercicio.getTm2TipoEjercicio().setCodigoRegistro(tm2tipoejercicio);
		//
		// ejercicio.setTipoActividad(1);
		try {

			if (files.length > 0) {
				swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null)
						&& (files[0].getOriginalFilename().trim().length() > 0);
				System.out.println(swNuevaUrlImagen);
				System.out.println(files[0].getOriginalFilename());
			}
			if (swNuevaUrlImagen) {
				// ejercicio.setFileImagen(files[0]);
				// if (files[0].getOriginalFilename() != null) {
				// ejercicio.setNombeImagen(files[0].getOriginalFilename());
				// System.out.println(ejercicio.getNombeImagen());
				// }
			}

			if (filesAudio.length > 0) {
				swUrlAudio = (filesAudio[0] != null) && (filesAudio[0].getOriginalFilename() != null)
						&& (filesAudio[0].getOriginalFilename().trim().length() > 0);
				System.out.println(swUrlAudio);
				System.out.println(filesAudio[0].getOriginalFilename());
			}
			if (swUrlAudio) {
				fileAudio = filesAudio[0];
				// ejercicio.setFileImagen(filesAudio[0]);
				if (filesAudio[0].getOriginalFilename() != null) {
					// ejercicio.setUbicacionImagen(filesAudio[0]
					// .getOriginalFilename());
					// System.out.println(ejercicio.getUbicacionImagen());
				}
			}
			if (sw) {

				if (swNuevaUrlImagen) {
					// super.cargarArchivo(this.getRootPath(),
					// ejercicio.getNombeImagen(),
					// ejercicio.getFileImagen());
					// // tmpUrlImagen = lenguaBean.getImagenNombre();

				}
				if (swUrlAudio) {
					// super.cargarArchivo(this.getRootPath(),
					// ejercicio.getUbicacionImagen(), fileAudio);
					// tmpUrlImagen = lenguaBean.getImagenNombre();

				}
				// if (codigoejercicio > 0) {
				// if (ejercicioService.actualizar(ejercicio)) {
				// System.out
				// .println("Se actualizó el ejercicio con éxito");
				// // lstEjercicios =
				// // ejercicioService.getBuscarPorFiltros(ejercicioBean);
				// } else {
				// System.out.println("Falló el registro");
				// }
				// } else {
				// if (ejercicioService.insertar(ejercicio)) {
				// System.out.println("Se insertó el ejercicio con éxito");
				// // lstEjercicios =
				// // ejercicioService.getBuscarPorFiltros(ejercicioBean);
				// } else {
				// System.out.println("Falló el registro");
				// }
				// }

				// ModelAndView mav = new
				// ModelAndView("general/lengua/registro-lengua",
				// "command",lenguaBean);
				// mav.addObject("swMensaje","1");
				// mav.addObject("lstSituacion",lstSituacion);
				// return mav;
			} else {
				// ModelAndView mav = new
				// ModelAndView("general/lengua/registro-lengua",
				// "command",lenguaBean);
				// mav.addObject("swMensaje", "0");
				// mav.addObject("lstSituacion",lstSituacion);
				// return mav;
			}
			// else {
			// ejercicioBean.setImagenNombre(tmpUrlImagen);
			// }
			//
			// if (this.getLenguaService().existe(lenguaBean)) {
			// ModelAndView mav = new
			// ModelAndView("general/lengua/registro-lengua",
			// "command",lenguaBean);
			// mav.addObject("swMensaje","3");
			// mav.addObject("lstSituacion",lstSituacion);
			// return mav;
			// }else{
			// if (lenguaBean.getCodigo()==0) {
			// System.out.println("insertar "+lenguaBean);
			// this.setAuditoria(lenguaBean, request, true);
			// sw = (this.getLenguaService().insertar(lenguaBean));
			// } else {
			// System.out.println("actualizar "+lenguaBean);
			// this.setAuditoria(lenguaBean, request, false);
			// sw = (this.getLenguaService().actualizar(lenguaBean));
			// }
			// }
			//

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return String.valueOf(ejercicio.getCodigo());
		return "";
	}

	@RequestMapping(value = "/actualizarImagen", method = RequestMethod.POST)
	@ResponseBody
	public String doActualizarImagen(@RequestParam("codigoejercicio") int codigoejercicio,
			@RequestParam("tituloejercicio") String tituloejercicio, @RequestParam("descripcion") String descripcion,
			@RequestParam("codleccion") Integer codleccion, @RequestParam("tm2tipoejercicio") Integer tm2tipoejercicio,
			@RequestParam("file") MultipartFile[] files, @RequestParam("fileAudio") MultipartFile[] filesAudio) {
		System.out.println(codigoejercicio);
		System.out.println(tituloejercicio);
		System.out.println(descripcion);
		System.out.println(codleccion);
		System.out.println(tm2tipoejercicio);
		// EjercicioBean ejercicio = new EjercicioBean();
		// boolean sw = true;
		// boolean swNuevaUrlImagen = false;
		// boolean swUrlAudio = false;
		// MultipartFile fileAudio = null;
		// ejercicio.setCodigo(codigoejercicio);
		// ejercicio.setTituloEjercicio(tituloejercicio);
		// ejercicio.setDescripcionEjercicio(descripcion);
		// ejercicio.getLeccion().setCodigo(codleccion);
		// ejercicio.getTm2TipoEjercicio().setCodigoRegistro(tm2tipoejercicio);
		// ejercicio.setTipoActividad(1);
		// try {
		//
		// if (files.length > 0) {
		// swNuevaUrlImagen = (files[0] != null)
		// && (files[0].getOriginalFilename() != null)
		// && (files[0].getOriginalFilename().trim().length() > 0);
		// System.out.println(swNuevaUrlImagen);
		// System.out.println(files[0].getOriginalFilename());
		// }
		// if (swNuevaUrlImagen) {
		// ejercicio.setFileImagen(files[0]);
		// if (files[0].getOriginalFilename() != null) {
		// ejercicio.setNombeImagen(files[0].getOriginalFilename());
		// System.out.println(ejercicio.getNombeImagen());
		// }
		// }
		//
		// if (filesAudio.length > 0) {
		// swUrlAudio = (filesAudio[0] != null)
		// && (filesAudio[0].getOriginalFilename() != null)
		// && (filesAudio[0].getOriginalFilename().trim().length() > 0);
		// System.out.println(swUrlAudio);
		// System.out.println(filesAudio[0].getOriginalFilename());
		// }
		// if (swUrlAudio) {
		// fileAudio = filesAudio[0];
		// if (filesAudio[0].getOriginalFilename() != null) {
		// ejercicio.setUbicacionImagen(filesAudio[0]
		// .getOriginalFilename());
		// System.out.println(ejercicio.getUbicacionImagen());
		// }
		// }
		// if (sw) {
		//
		// if (swNuevaUrlImagen) {
		// super.cargarArchivo(this.getRootPath(),
		// ejercicio.getNombeImagen(),
		// ejercicio.getFileImagen());
		//
		// }
		// if (swUrlAudio) {
		// super.cargarArchivo(this.getRootPath(),
		// ejercicio.getUbicacionImagen(), fileAudio);
		//
		// }
		// if (ejercicioService.actualizar(ejercicio)) {
		// ejercicio.setCodigo(codigoejercicio);
		// System.out.println("Se actualizó el ejercicio con éxito");
		// } else {
		// System.out.println("Falló el registro");
		// }
		//
		// } else {
		//
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// return String.valueOf(ejercicio.getCodigo());
		return "";
	}
//---------------------------------------INICIO RELACION----------------------------------------------------
	@RequestMapping(value = "/editarRelacionDetalleTexto", method = RequestMethod.POST)
	@ResponseBody
	public String doEditarRelacionDetalleTexto(@RequestParam("codrelaci") 	long codrelaci,
												@RequestParam("codprelcab") long codprelcab,
												@RequestParam("palabra") 	String palabra,
												@RequestParam("nombImagen") String nombImagen,
												HttpServletRequest request) 
	{
		System.out.println("editarRelacionDetalleTexto------------------->"+palabra);

		RelacionBean relacion = new RelacionBean();
		relacion.setCodigo(codrelaci);
		relacion.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacion.getRelacionCabeceraBean().setCodigo(codprelcab);
		relacion.setImagen(nombImagen);
		relacion.setPalabra(palabra);
		this.setAuditoria(relacion, request, false);

		try {
				if (relacionService.actualizar(relacion)) 
				{
					System.out.println("Se modificó la relación con éxito");
				} 
				else 
				{
					System.out.println("Falló al modificar.");
				}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return String.valueOf(relacion.getCodigo());
	}
	
	@RequestMapping(value = "/editarRelacionDetalleImagen", method = RequestMethod.POST)
	@ResponseBody
	public String doEditarRelacionDetalleImagen(@RequestParam("codrelaci") 	long codrelaci,
												@RequestParam("codprelcab") long codprelcab,
												@RequestParam("palabra") 	String palabra, 
												@RequestParam("file") 		MultipartFile[] files,
												HttpServletRequest request) 
	{
		System.out.println("editarRelacionDetalleImagen------------------->"+palabra);

		RelacionBean relacion = new RelacionBean();
		boolean swNuevaUrlImagen = false;

		relacion.setCodigo(codrelaci);
		relacion.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacion.getRelacionCabeceraBean().setCodigo(codprelcab);
		relacion.setPalabra(palabra);
		this.setAuditoria(relacion, request, false);

		if (files.length > 0) 
		{
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null)
							&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);
			System.out.println(files[0].getOriginalFilename());
		}
		if (swNuevaUrlImagen) 
		{
			relacion.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null) 
			{
				relacion.setImagen(files[0].getOriginalFilename());
				System.out.println(relacion.getImagen());
			}
		}
		try {
				if (relacionService.actualizar(relacion)) 
				{
					if (swNuevaUrlImagen) 
					{
						super.cargarArchivo(this.getRootPath(), relacion.getImagen(), relacion.getFileImagen());
					}
					System.out.println("Se modificó la relación con éxito");
				} 
				else 
				{
					System.out.println("Falló al modificar.");
				}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return String.valueOf(relacion.getCodigo());
	}
	
	@RequestMapping(value = "/listarRelacionDetalleImagen", method = RequestMethod.POST)
	@ResponseBody 
	public List<RelacionBean> doListaRelacionDetalleImagen(@RequestParam("idRelCab") long idRelCab)
	{
		System.out.println("idTipoEjercicio " + idRelCab);
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setCodigo(idRelCab);
		
		List<RelacionBean> lstRelacionBean = new ArrayList<RelacionBean>();
		try 
		{
			lstRelacionBean = relacionService.buscarPorRelacionCabecera(relacionBean);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
//		System.out.println("----------------------------------->"+lstRelacionBean.size());
		return lstRelacionBean;
	}
	
	@RequestMapping(value = "/listarRelacionCabecera", method = RequestMethod.POST)
	@ResponseBody 
	public List<RelacionCabeceraBean> doListaRelacionCabecera(@RequestParam("idEjercicio") Integer idEjercicio)
	{
		System.out.println("idTipoEjercicio " + idEjercicio);
		RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean();
		relacionCabeceraBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		relacionCabeceraBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
		
		List<RelacionCabeceraBean> lstRelacionCabeceraBean = new ArrayList<RelacionCabeceraBean>();
		try 
		{
			lstRelacionCabeceraBean = relacionCabeceraService.buscarPorEjercicio(relacionCabeceraBean);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
//		System.out.println("----------------------------------->"+lstRelacionBean.size());
		return lstRelacionCabeceraBean;
	}
	
	@RequestMapping(value = "/grabarRelacionCabecera", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarRelacionCabecera(@RequestParam("codprelcab") 		Integer codprelcab,
											@RequestParam("codejercicio") 	Integer codejercicio,
											@RequestParam("titulo") 		String titulo,
											HttpServletRequest request) 
	{
		System.out.println(codejercicio);
		System.out.println(titulo);

		RelacionCabeceraBean cabeceraBean = new RelacionCabeceraBean();

		cabeceraBean.setCodigo(codprelcab);
		cabeceraBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		cabeceraBean.getMaterialTipoEjercicioBean().setCodigo(codejercicio);
		cabeceraBean.setTitulo(titulo);;
		this.setAuditoria(cabeceraBean, request, true);
		
		if(cabeceraBean.getCodigo() != 0)
		{
			try 
			{
				relacionCabeceraService.actualizar(cabeceraBean);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				relacionCabeceraService.insertar(cabeceraBean);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return String.valueOf(cabeceraBean.getCodigo());
	}
	
	@RequestMapping(value = "/grabarRelacionDetalleImagen", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarRelacionDetalleImagen(@RequestParam("codprelcab") Integer codprelcab,
												@RequestParam("palabra") 	String palabra, 
												@RequestParam("file") 		MultipartFile[] files,
												HttpServletRequest request) 
	{
		System.out.println("------------------->"+palabra);

		RelacionBean relacion = new RelacionBean();
		boolean swNuevaUrlImagen = false;

		relacion.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacion.getRelacionCabeceraBean().setCodigo(codprelcab);
		relacion.setPalabra(palabra);
		this.setAuditoria(relacion, request, true);
		
		if (files.length > 0) 
		{
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null)
							&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);
			System.out.println(files[0].getOriginalFilename());
		}
		if (swNuevaUrlImagen) 
		{
			relacion.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null) 
			{
				relacion.setImagen(files[0].getOriginalFilename());
				System.out.println(relacion.getImagen());
			}
		}
		try {
				if (relacionService.insertar(relacion)) 
				{
					if (swNuevaUrlImagen) 
					{
						super.cargarArchivo(this.getRootPath(), relacion.getImagen(), relacion.getFileImagen());
					}
					System.out.println("Se insertó la relación con éxito");
				} 
				else 
				{
					System.out.println("Falló el registro");
				}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return String.valueOf(relacion.getCodigo());
	}
	
	@RequestMapping(value = "/eliminarRelacion", method = RequestMethod.POST)
	@ResponseBody
	public String doEliminarRelacion(@RequestParam("idRelacionCabecera") Integer idRelacionCabecera,
									HttpServletRequest request) {

		RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean();
		relacionCabeceraBean.setCodigo(idRelacionCabecera);
		this.setAuditoria(relacionCabeceraBean, request, false);
		
		boolean sw = false;
		try {
			sw = relacionCabeceraService.eliminar(relacionCabeceraBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return sw ? "1" : "0";
	}
//---------------------------------------FIN RELACION----------------------------------------------------
	/********* MSB **************/
	@RequestMapping(value = "/grabarRelacion2", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarRelacion2(@RequestParam("codejercicio") Integer codejercicio,
			@RequestParam("palabra") String palabra, @RequestParam("texto") String texto,
			@RequestParam("tiporelacion") Integer tiporelacion, @RequestParam("orden") Integer orden,
			@RequestParam("orientacion") Integer orientacion) {
		System.out.println(codejercicio);
		System.out.println(palabra);
		System.out.println(texto);
		System.out.println(tiporelacion);
		System.out.println(orden);
		System.out.println(orientacion);
		RelacionBean relacion = new RelacionBean();
		boolean sw = true;

		// relacion.getEjercicioBean().setCodigo(codejercicio);
		relacion.setPalabra(palabra);
		relacion.setTexto(texto);
		relacion.setTipoRelacion(tiporelacion);
		// relacion.setOrden(orden);
		// relacion.setOrientacion(orientacion);
		try {

			if (sw) {

				if (relacionService.insertar(relacion)) {
					System.out.println("Se insertó el ejercicio con éxito");
					// lstEjercicios =
					// ejercicioService.getBuscarPorFiltros(ejercicioBean);
				} else {
					System.out.println("Falló el registro");
				}
				// ModelAndView mav = new
				// ModelAndView("general/lengua/registro-lengua",
				// "command",lenguaBean);
				// mav.addObject("swMensaje","1");
				// mav.addObject("lstSituacion",lstSituacion);
				// return mav;
			} else {
				// ModelAndView mav = new
				// ModelAndView("general/lengua/registro-lengua",
				// "command",lenguaBean);
				// mav.addObject("swMensaje", "0");
				// mav.addObject("lstSituacion",lstSituacion);
				// return mav;
			}
			// else {
			// ejercicioBean.setImagenNombre(tmpUrlImagen);
			// }
			//
			// if (this.getLenguaService().existe(lenguaBean)) {
			// ModelAndView mav = new
			// ModelAndView("general/lengua/registro-lengua",
			// "command",lenguaBean);
			// mav.addObject("swMensaje","3");
			// mav.addObject("lstSituacion",lstSituacion);
			// return mav;
			// }else{
			// if (lenguaBean.getCodigo()==0) {
			// System.out.println("insertar "+lenguaBean);
			// this.setAuditoria(lenguaBean, request, true);
			// sw = (this.getLenguaService().insertar(lenguaBean));
			// } else {
			// System.out.println("actualizar "+lenguaBean);
			// this.setAuditoria(lenguaBean, request, false);
			// sw = (this.getLenguaService().actualizar(lenguaBean));
			// }
			// }
			//

		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(relacion.getCodigo());
	}

//	@RequestMapping(value = "/grabarMaterialEjercicioRelacion", method = RequestMethod.POST)
//	@ResponseBody
//	public Long doGrabarGrabarMaterialTipoEjercicioRelacion(@RequestParam("idTipoEjercicio") Integer idTipoEjercicio,
//			 												@RequestParam("tituloEjercicio") String tituloEjercicio,
//			 												@RequestParam("idMaterial") Integer idMaterial,
//			 												@RequestParam("idEjercicio") Integer idEjercicio){
//		System.out.println("-----Ingreso a grabarMaterialEjercicioRelacion ----");
//		MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
//		materialTipoEjercicioBean.getLeccionMaterialBean().setCodigo(idMaterial);
//		materialTipoEjercicioBean.getTipoEjercicio().setCodigoRegistro(idTipoEjercicio);
//		materialTipoEjercicioBean.getSituacionTipo().setCodigoRegistro(1);
//		materialTipoEjercicioBean.setTitulo(tituloEjercicio);
//		materialTipoEjercicioBean.setCodigo(idEjercicio);
//
//		long valor = 0;
//		try {
//			if (materialTipoEjercicioBean.getCodigo() == 0) {
//				this.getMaterialTipoEjercicioService().insertar(materialTipoEjercicioBean);
//				valor = materialTipoEjercicioBean.getCodigo();
//			}else{
//				this.getMaterialTipoEjercicioService().actualizar(materialTipoEjercicioBean);
//				valor = materialTipoEjercicioBean.getCodigo();
//			}
//			
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//
//		return valor;
//
//		}
	
	
	/********* MSB **************/
	@RequestMapping(value = "/modificarRelacion2", method = RequestMethod.POST)
	@ResponseBody
	public String doModificarRelacion2(@RequestParam("codigo") Integer codigo, @RequestParam("palabra") String palabra,
			@RequestParam("texto") String texto, @RequestParam("tiporelacion") Integer tiporelacion,
			@RequestParam("orden") Integer orden, @RequestParam("orientacion") Integer orientacion) {

		RelacionBean relacion = new RelacionBean();
		boolean sw = true;

		relacion.setCodigo(codigo);
		relacion.setPalabra(palabra);
		relacion.setTexto(texto);
		relacion.setTipoRelacion(tiporelacion);
		// relacion.setOrden(orden);
		// relacion.setOrientacion(orientacion);
		try {

			if (sw) {
				if (relacionService.actualizar(relacion)) {
					System.out.println("Se insertó el ejercicio con éxito");
				} else {
					System.out.println("Falló el registro");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(relacion.getCodigo());
	}

	/**************** MSB ********************/
	@RequestMapping(value = "/buscarrelacion", method = RequestMethod.POST)
	public @ResponseBody List<RelacionBean> listadoRelacionActividad(@RequestParam("p_codejercicio") int p_codejercicio)
			throws Exception {
		List<RelacionBean> lstpregunta = new ArrayList<RelacionBean>();

		// EjercicioBean ejercicioBean = new EjercicioBean();
		// ejercicioBean.setCodigo(p_codejercicio);
		//
		// lstpregunta = relacionService.buscarPorEjercicio(ejercicioBean);
		// // prmDocenteBean.setNombre("");
		// if (lstpregunta == null) {
		// lstpregunta = new ArrayList<RelacionBean>();
		// }
		// System.out.println(lstpregunta.size() +
		// "<---------------------------");
		return lstpregunta;
	}

	/**************** MSB **************/
	@RequestMapping(value = "/eliminarRelacionMSB", method = RequestMethod.POST)
	@ResponseBody
	public String doEliminarRelacionMSB(@RequestParam("codigo") Integer codigo) {

		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setCodigo(codigo);
		boolean sw = false;
		try {
			sw = relacionService.eliminar(relacionBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return sw ? "1" : "0";
	}

	@RequestMapping(value = "/buscarpregunta", method = RequestMethod.POST)
	public @ResponseBody List<PreguntaBean> listadoPreguntaActividad(@RequestParam("p_codejercicio") int p_codejercicio)
			throws Exception {
		List<PreguntaBean> lstpregunta = new ArrayList<PreguntaBean>();

		CargaMaterialBean prmCargaMaterialBean = new CargaMaterialBean();
		// prmCargaMaterialBean.getPregunta().getEjercicioBean()
		// .setCodigo(p_codejercicio);
		// lstpregunta = preguntaService.buscarPorEjercicio(prmCargaMaterialBean
		// .getPregunta().getEjercicioBean());
		// // prmDocenteBean.setNombre("");
		// if (lstpregunta == null) {
		// lstpregunta = new ArrayList<PreguntaBean>();
		// }
		return lstpregunta;
	}

	// @RequestMapping(value = "/buscarrespuestas", method = RequestMethod.POST)
	// public @ResponseBody List<AlternativaBean> listadoRespuestasPregunta(
	// @RequestParam("p_codpregunta") int p_codpregunta) throws Exception {
	// List<AlternativaBean> lstRespuestas = new ArrayList<AlternativaBean>();
	//
	// CargaMaterialBean prmCargaMaterialBean = new CargaMaterialBean();
	// prmCargaMaterialBean.getRespuestas().getPreguntaBean()
	// .setCodigo(p_codpregunta);
	// // lstRespuestas = respuestaService.bu
	// lstRespuestas = alternativaService
	// .buscarPorCodigoPregunta(prmCargaMaterialBean.getRespuestas()
	// .getPreguntaBean());
	// // lstRespuestas =
	// //
	// preguntaService.buscarPorEjercicio(prmCargaMaterialBean.getPregunta().getEjercicioBean());
	// // prmDocenteBean.setNombre("");
	// if (lstRespuestas == null) {
	// lstRespuestas = new ArrayList<AlternativaBean>();
	// }
	// System.out.println(lstRespuestas.toString());
	// return lstRespuestas;
	// }

	private ModelAndView getListar(CargaMaterialBean cargaMaterialBean) {
		// List<EjercicioBean> lstEjercicioBean = new
		// ArrayList<EjercicioBean>();

		// EjercicioBean ejercicioBean = new EjercicioBean();
		//
		// ejercicioBean.setLengua(new LenguaBean());
		// ejercicioBean.getLeccion().setTm2Nivel(new MaestraBean());
		// ejercicioBean.getLeccion().setTm2SubNivel(new MaestraBean());
		// ejercicioBean.getLeccion().setTm2Unidad(new MaestraBean());
		//
		// ejercicioBean.getLengua().setCodigo(
		// cargaMaterialBean.getLengua().getCodigo());
		// ejercicioBean
		// .getLeccion()
		// .getTm2Nivel()
		// .setCodigoRegistro(
		// cargaMaterialBean.getNivel().getCodigoRegistro());
		// ejercicioBean
		// .getLeccion()
		// .getTm2SubNivel()
		// .setCodigoRegistro(
		// cargaMaterialBean.getSubNivel().getCodigoRegistro());
		// ejercicioBean
		// .getLeccion()
		// .getTm2Unidad()
		// .setCodigoRegistro(
		// cargaMaterialBean.getUnidad().getCodigoRegistro());

		try {
			// lstEjercicioBean = (List<EjercicioBean>)
			// this.getEjercicioService()
			// .getBuscarPorFiltros(ejercicioBean);
			//
			// System.out.println("tamaño lstEjercicioBean "
			// + lstEjercicioBean.size());
		} catch (Exception e) {
			System.out.println("getLista falló" + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("general/registro-carga-material", "command", cargaMaterialBean);

		mav.addObject("cargaMaterialBean", cargaMaterialBean);
		// System.out.println("lstEjercicioBean " + lstEjercicioBean);
		// mav.addObject("lstEjercicioBean", lstEjercicioBean);
		this.cargarCombos(mav);
		return mav;
	}

	private ModelAndView getListar2(CargaMaterialBean cargaMaterialBean) {

		List<PreguntaBean> lstPreguntaBean = new ArrayList<PreguntaBean>();
		try {
			// lstPreguntaBean = (List<PreguntaBean>) this.getPreguntaService()
			// .buscarPorEjercicio(cargaMaterialBean.getEjercicio());
			System.out.println("tamaño lstEjercicioBean " + lstPreguntaBean.size());
		} catch (Exception e) {
			System.out.println("getLista falló" + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("actividad/act-01", "command", cargaMaterialBean);
		// ModelAndView mav = getListar2(new CargaMaterialBean());
		mav.addObject("cargaMaterialBean", cargaMaterialBean);
		System.out.println("lstPreguntaBean " + lstPreguntaBean);
		mav.addObject("lstPreguntaBean", lstPreguntaBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/leccionCargarModal", method = RequestMethod.POST)
	public ModelAndView doLeccionCargarModal(@RequestParam("liCodLecc") Integer liCodLecc) {

		ModelAndView mav = new ModelAndView("../page/actividad/ajax/registro-leccion-view", "command",
				new CargaMaterialBean());

		LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		mav.addObject("leccionMaterial",leccionMaterialBean);
		mav.addObject("unidadLeccion", unidadLeccionBean);
		return mav;
	}

	@RequestMapping(value = "/editarLeccionCargarModal", method = RequestMethod.POST)
	public ModelAndView doEditarLeccionCargarModal(@RequestParam("liCodLecc") Integer liCodLecc) {

		ModelAndView mav = new ModelAndView("../page/actividad/ajax/registro-leccion-view", "command",
				new CargaMaterialBean());

		LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.setCodigo(liCodLecc);
		try {
			unidadLeccionBean = unidadLeccionService.getBuscarPorObjecto(unidadLeccionBean);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("leccionMaterial",leccionMaterialBean);
		mav.addObject("unidadLeccion", unidadLeccionBean);
		return mav;
	}

	/*
	 * leccionCargarModal
	 */
	@RequestMapping(value = "/listarLeccionMaterial", method = RequestMethod.POST)
	public @ResponseBody List<LeccionMaterialBean> listarLeccionMaterial(@RequestParam("liCodLecc") int liCodLecc,
			@RequestParam("liSitLeMa") int liSitLeMa) throws Exception {
		List<LeccionMaterialBean> lstLecMate = new ArrayList<LeccionMaterialBean>();

		LeccionMaterialBean buscar = new LeccionMaterialBean();
		buscar.setCodigo(liCodLecc);
		buscar.getSituacionLeccionMaterial().setCodigo(liSitLeMa);
		lstLecMate = leccionMaterialService.getBuscarPorFiltros(buscar);
		// prmDocenteBean.setNombre("");
		if (lstLecMate == null) {
			lstLecMate = new ArrayList<LeccionMaterialBean>();
		}
		System.out.println(lstLecMate.size());
		return lstLecMate;
	}

	@RequestMapping(value = "/eliminarLeccion", method = RequestMethod.POST)
	@ResponseBody
	public String doEliminarLeccion(@RequestParam("liLeccion") Integer liCodMate) {
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.setCodigo(liCodMate);
		unidadLeccionBean.setCodigoUsuarioModificacion(12346);
		unidadLeccionBean.setIpModificacion("ipdel");
		String lsMsgRtrn="";
		try {
			if (unidadLeccionService.eliminar(unidadLeccionBean)) {
				System.out.println("Se eliminó la lección con éxito");
				lsMsgRtrn = "1";
			} else {
				System.out.println("Falló al eliminar.");
				lsMsgRtrn = "0";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lsMsgRtrn;
	}
	
	@RequestMapping(value = "/grabarLeccion", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarLeccion(@RequestParam("liTipoSQL") Integer liTipoSQL,
			@RequestParam("liLeccion") Integer liLeccion, @RequestParam("lsNomLecc") String lsNomLecc,
			@RequestParam("llSitLecc") Integer liSitLecc, @RequestParam("liCodUnid") Integer liCodUnid) {

		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		String lsResulta = "";
		unidadLeccionBean.getUnidadBean().setCodigo(liCodUnid);
		unidadLeccionBean.setCodigo(liLeccion);
		unidadLeccionBean.setNombre(lsNomLecc);
		unidadLeccionBean.setDescripcion(lsNomLecc);
		unidadLeccionBean.getSituacion().setCodigoRegistro(liSitLecc);
		if (liTipoSQL == 1) {
			unidadLeccionBean.setCodigoUsuarioCreacion(123);
			unidadLeccionBean.setIpCreacion("ip");
		} else {
			unidadLeccionBean.setCodigoUsuarioModificacion(1234);
			unidadLeccionBean.setIpModificacion("ipmod");
		}
		try {
			if (liTipoSQL == 1) {
				if (unidadLeccionService.insertar(unidadLeccionBean)) {
					System.out.println("Se insertó el registro con éxito");
					lsResulta = Integer.toString((int) unidadLeccionBean.getCodigo());
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			} else if (liTipoSQL == 2) {
				if (unidadLeccionService.actualizar(unidadLeccionBean)) {
					System.out.println("Se actualizó el registro con éxito");
					lsResulta = Integer.toString(liLeccion);
				} else {
					System.out.println("Falló el registro");
					lsResulta = "0";
				}
			} else {
				System.out.println("Falló el registro. No se encontró tipo de acción.");
				lsResulta = "0";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lsResulta;

	}

	public String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	@RequestMapping(value = "/eliminarLeccionMaterial", method = RequestMethod.POST)
	@ResponseBody
	public String doEliminarMaterial(@RequestParam("liCodMate") Integer liCodMate) {
		LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
		leccionMaterialBean.setCodigo(liCodMate);
		leccionMaterialBean.setCodigoUsuarioCreacion(12346);
		leccionMaterialBean.setIpCreacion("ipdel");
		String lsMsgRtrn="";
		try {
			if (leccionMaterialService.eliminar(leccionMaterialBean)) {
				System.out.println("Se eliminó el material con éxito");
				lsMsgRtrn = "1";
			} else {
				System.out.println("Falló al eliminar.");
				lsMsgRtrn = "0";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lsMsgRtrn;
	}
	
	@RequestMapping(value = "/grabarMaterial", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarMaterial(@RequestParam("liTipoSQL") Integer liTipoSQL,
			@RequestParam("liCodMate") Integer liCodMate, @RequestParam("lsDesMate") String lsDesMate,
			@RequestParam("lsCtxMate") String lsCtxMate, @RequestParam("liCodLecc") Integer liCodLecc,
			@RequestParam("liTipMate") Integer liTipMate, @RequestParam("lfImgMate") MultipartFile[] lfImgMate,
			@RequestParam("lfAudMate") MultipartFile[] lfAudMate) {

		LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
		boolean swRtaMate = true;
		boolean swImgMate = false;
		boolean swAudMate = false;
		MultipartFile lfAudioMa = null;
		MultipartFile lfImageMa = null;
		leccionMaterialBean.setCodigo(liCodMate);
		leccionMaterialBean.setDescripcionMaterial(lsDesMate);
		leccionMaterialBean.setContexto(lsCtxMate);
		leccionMaterialBean.setSwEditable("1");
		leccionMaterialBean.getUnidadLeccionBean().setCodigo(liCodLecc);
		
		
		if (lfImgMate.length > 0) {
			 swImgMate = (lfImgMate[0] != null) && (lfImgMate[0].getOriginalFilename() != null) && (lfImgMate[0].getOriginalFilename().trim().length() > 0);
			 System.out.println(swImgMate);
			 System.out.println(lfImgMate[0].getOriginalFilename());
		}
		if(lfImgMate[0].getOriginalFilename().contains("img--Vacio---")){
			 swImgMate = false;
			 leccionMaterialBean.setNombreImagen(lfImgMate[0].getOriginalFilename().split("---")[1]);
		}
		if (swImgMate) {
			lfImageMa = lfImgMate[0] ;
			if (lfImgMate[0].getOriginalFilename() != null) {
				leccionMaterialBean.setNombreImagen(lfImgMate[0].getOriginalFilename());
				System.out.println(leccionMaterialBean.getNombreImagen());
			}
			
			File dir = new File(this.getRootPath() + File.separator + leccionMaterialBean.getNombreImagen());                
	        if (dir.exists()){
	            //dir.mkdirs();
	        	System.out.println("img"+ dir.getName());
	        	String fileNameWithOutExt = FilenameUtils.removeExtension(leccionMaterialBean.getNombreImagen());
	        	String fileNameExt = FilenameUtils.getExtension(leccionMaterialBean.getNombreImagen());
	        	System.out.println("imgnefile" + randomIdentifier());
	        	leccionMaterialBean.setNombreImagen(randomIdentifier()+"."+fileNameExt);
	        }   
			super.cargarArchivo(this.getRootPath(),leccionMaterialBean.getNombreImagen(),lfImageMa);
		}
		
				
		if (lfAudMate.length > 0) {
			swAudMate = (lfAudMate[0] != null) && (lfAudMate[0].getOriginalFilename() != null) && (lfAudMate[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swAudMate);
			System.out.println(lfAudMate[0].getOriginalFilename());
		}
		if(lfAudMate[0].getOriginalFilename().contains("audio--Vacio---")){
			swAudMate = false;
			leccionMaterialBean.setRutaAudio(lfAudMate[0].getOriginalFilename().split("---")[1]);
		}
		if (swAudMate) {
			lfAudioMa = lfAudMate[0];
			if (lfAudMate[0].getOriginalFilename() != null) {
				leccionMaterialBean.setRutaAudio(lfAudMate[0].getOriginalFilename());
				System.out.println(leccionMaterialBean.getRutaAudio());
			}
			File dir = new File(this.getRootPath() + File.separator + leccionMaterialBean.getRutaAudio());        
			 if (dir.exists()){
		            //dir.mkdirs();
		        	System.out.println("img"+ dir.getName());
		        	String fileNameWithOutExt = FilenameUtils.removeExtension(leccionMaterialBean.getRutaAudio());
		        	String fileNameExt = FilenameUtils.getExtension(leccionMaterialBean.getRutaAudio());
		        	System.out.println("imgnefile" + randomIdentifier());
		        	leccionMaterialBean.setRutaAudio(randomIdentifier()+"."+fileNameExt);
		        }   
			super.cargarArchivo(this.getRootPath(),leccionMaterialBean.getRutaAudio(), lfAudioMa);
		}
		
		leccionMaterialBean.setExtencionImagen("");
		//el tipo de material donde se debe de guardar? yo lo he puesto en este campo, definir ya.
		leccionMaterialBean.getSituacionLeccionMaterial().setCodigo(liTipMate);
		if (liTipoSQL == 1) {
			leccionMaterialBean.setCodigoUsuarioCreacion(123);
			leccionMaterialBean.setIpCreacion("ip");
		} else {
			leccionMaterialBean.setCodigoUsuarioModificacion(1234);
			leccionMaterialBean.setIpModificacion("ipmod");
		}
		try {
			if (liTipoSQL == 1) {
				if (leccionMaterialService.insertar(leccionMaterialBean)) {
					System.out.println("Se insertó  el material con éxito");
				} else {
					System.out.println("Falló al insertar.");
				}
			} else if (liTipoSQL == 2) {
				if (leccionMaterialService.actualizar(leccionMaterialBean)) {
					System.out.println("Se actualizó el material con éxito");
				} else {
					System.out.println("Falló al actualizar.");
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return String.valueOf(leccionMaterialBean.getCodigo());
		
	}
	
	/** Insertar Matertial Tipo Ejercicio. **/
	
	@RequestMapping(value = "/grabarMaterialEjercicio", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarGrabarMaterialTipoEjercicio(@RequestParam("idTipoEjercicio") Integer idTipoEjercicio,
			 										@RequestParam("tituloEjercicio") String tituloEjercicio,
			 										@RequestParam("idMaterial") Integer idMaterial,
			 										@RequestParam("idEjercicio") Integer idEjercicio){
		System.out.println("-----Ingreso a grabarMaterialEjercicio ----");
		MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
		materialTipoEjercicioBean.getLeccionMaterialBean().setCodigo(idMaterial);
		materialTipoEjercicioBean.getTipoEjercicio().setCodigoRegistro(idTipoEjercicio);
		materialTipoEjercicioBean.getSituacionTipo().setCodigoRegistro(1);
		materialTipoEjercicioBean.setTitulo(tituloEjercicio);
		materialTipoEjercicioBean.setCodigo(idEjercicio);
		
		
		long valor = 0;
		try {
			if (materialTipoEjercicioBean.getCodigo() != 0) {
				this.getMaterialTipoEjercicioService().actualizar(materialTipoEjercicioBean);
				valor = materialTipoEjercicioBean.getCodigo();
			}else{

				this.getMaterialTipoEjercicioService().insertar(materialTipoEjercicioBean);
				valor = materialTipoEjercicioBean.getCodigo();
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	@RequestMapping(value = "/eliminarMaterialEjercicio", method = RequestMethod.POST)
	@ResponseBody
	public Long doEliminarGrabarMaterialTipoEjercicio(@RequestParam("idEjercicio") Integer idEjercicio){
		System.out.println("-----Ingreso a EliminarMaterial ----");
		MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
		materialTipoEjercicioBean.setCodigo(idEjercicio);
		
		
		long valor = 0;
		try {
			if (materialTipoEjercicioBean.getCodigo() != 0) {
				this.getMaterialTipoEjercicioService().eliminar(materialTipoEjercicioBean);
				valor = 0;
			}else{

			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	
	@RequestMapping(value = "/listarMaterialTipoEjercicio", method = RequestMethod.POST)
	@ResponseBody 
	public List<MaterialTipoEjercicioBean> doListaMaterialTipoEjercicio(@RequestParam("idTipoEjercicio") Integer idTipoEjercicio,
			  															@RequestParam("idMaterial") Integer idMaterial
			  															){
		System.out.println("idTipoEjercicio " + idTipoEjercicio);
		System.out.println("idMaterial " + idMaterial);
		materialTipoEjercicioBean.getTipoEjercicio().setCodigoRegistro(idTipoEjercicio);
		materialTipoEjercicioBean.getLeccionMaterialBean().setCodigo(idMaterial);
		
		List<MaterialTipoEjercicioBean> lstMaterialTipoEjercicioBeans = new ArrayList<MaterialTipoEjercicioBean>();
		try {
			lstMaterialTipoEjercicioBeans = this.getMaterialTipoEjercicioService().getBuscarPorFiltros(materialTipoEjercicioBean);
			if (lstMaterialTipoEjercicioBeans != null && lstMaterialTipoEjercicioBeans.size() >0) {
				
				System.out.println("--------------------------->"+ lstMaterialTipoEjercicioBeans.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstMaterialTipoEjercicioBeans;
	}
	@RequestMapping(value = "/objlistarMaterialEjercicio", method = RequestMethod.GET)
	@ResponseBody 
	public MaterialTipoEjercicioBean doObjListarEjercicio(@RequestParam("codEjercicio") Integer codEjercicio){
		System.out.println("idTipoEjercicio " + codEjercicio);
		System.out.println("--- objlistarMaterialEjercicio ---");
		System.out.println("codEjercicio -------->" +codEjercicio);
		MaterialTipoEjercicioBean oMaterialTipoEjercicioBean = new MaterialTipoEjercicioBean();
		oMaterialTipoEjercicioBean.setCodigo(codEjercicio);
		
		try {
			materialTipoEjercicioBean = this.getMaterialTipoEjercicioService().getBuscarPorObjecto(oMaterialTipoEjercicioBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materialTipoEjercicioBean;
	}

	/** Inicio Crud parrafo**/
	@RequestMapping(value = "/grabarParrafo", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarParrafo(@RequestParam("idOrdenarParrafoCabecera") 	Integer idOrdenarParrafoCabecera,
			 					@RequestParam("numeroOrden") 	Integer numeroOrden,
			 					@RequestParam("parrafo") 		String parrafo,
			 					@RequestParam("idParrafo") 		Integer idParrafo){
		System.out.println("-----Ingreso a Grabar parrafo ----");
		
		OrdenarParrafoBean ordenarParrafoBean = new OrdenarParrafoBean();
		ordenarParrafoBean.getMaterialTipoEjercicioBean().setCodigo(0);
		ordenarParrafoBean.setTitulo("");
		ordenarParrafoBean.setParrafo(parrafo);
		ordenarParrafoBean.setNumeroOrden(numeroOrden);
		ordenarParrafoBean.setCodigo(idParrafo);
		ordenarParrafoBean.getOrdenarParrafoCabeceraBean().setCodigo(idOrdenarParrafoCabecera);
		long valor = 0;
		try {
			if (ordenarParrafoBean.getCodigo() == 0) {
				this.getOrdenarParrafoService().insertar(ordenarParrafoBean);
				valor = ordenarParrafoBean.getCodigo();
			}else{
				this.getOrdenarParrafoService().actualizar(ordenarParrafoBean);
				valor = ordenarParrafoBean.getCodigo();
			}			
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
		return valor;
		}
	
	@RequestMapping(value = "/listarParrafo", method = RequestMethod.POST)
	@ResponseBody 
	public List<OrdenarParrafoBean> doListarParrafo(@RequestParam("idOrdenarParrafoCabecera") 	Integer idOrdenarParrafoCabecera){
		System.out.println("---- listarParrafo ---");
		System.out.println("idOrdenarParrafoCabecera :: "+ idOrdenarParrafoCabecera);
		OrdenarParrafoBean oOrdenarParrafoBean = new OrdenarParrafoBean();
		oOrdenarParrafoBean.getOrdenarParrafoCabeceraBean().setCodigo(idOrdenarParrafoCabecera);
				
		List<OrdenarParrafoBean> lstOrderOrdenarParrafoBeans = new ArrayList<OrdenarParrafoBean>();
		try {
			lstOrderOrdenarParrafoBeans = this.getOrdenarParrafoService().getBuscarPorFiltros(oOrdenarParrafoBean);
			
			if (lstOrderOrdenarParrafoBeans != null && lstOrderOrdenarParrafoBeans.size()>0) {
				
				System.out.println("----------------------------------->"+lstOrderOrdenarParrafoBeans.size());
				
			}else{
				
				System.out.println("lstOrderOrdenarParrafoBeans llego  null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return lstOrderOrdenarParrafoBeans;
	}
	
	@RequestMapping(value = "/objlistarParrafo", method = RequestMethod.GET)
	@ResponseBody 
	public OrdenarParrafoBean doObjlistarParrafo(@RequestParam("codParrafo") Integer codParrafo){
		System.out.println("codParrafo " + codParrafo);
		System.out.println("--- objlistarParrafo ---");
		System.out.println("codEjercicio -------->" +codParrafo);
		OrdenarParrafoBean oOrdenarParrafoBean = new OrdenarParrafoBean();
		oOrdenarParrafoBean.setCodigo(codParrafo);
		
		try {
			ordenarParrafoBean = this.getOrdenarParrafoService().getBuscarPorObjecto(oOrdenarParrafoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordenarParrafoBean;
	}
	
	@RequestMapping(value = "/objlistarOrdenarParrafoCabecera", method = RequestMethod.GET)
	@ResponseBody 
	public OrdenarParrafoCabeceraBean doObjlistarOrdenarParrafoCabecera(@RequestParam("codigo") Integer codigo){
		System.out.println("codigo " + codigo);
		System.out.println("--- objlistarParrafoCabecera ---");
		System.out.println("codEjercicio -------->" +codigo);
		OrdenarParrafoCabeceraBean oOrdenarParrafoCabeceraBean = new OrdenarParrafoCabeceraBean();
		oOrdenarParrafoCabeceraBean.setCodigo(codigo);
		
		try {
			ordenarParrafoCabeceraBean = this.getOrdenarParrafoCabeceraService().getBuscarPorObjecto(oOrdenarParrafoCabeceraBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordenarParrafoCabeceraBean;
	}
	
	@RequestMapping(value = "/eliminarParrafoCabecera", method = RequestMethod.GET)
	@ResponseBody
	public Long doEliminarParrafoCabecera(@RequestParam("codigo") Integer codigo){
		System.out.println("-----Ingreso a eliminarParrafoCabecera ----");
		OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean = new OrdenarParrafoCabeceraBean();
		ordenarParrafoCabeceraBean.setCodigo(codigo);
		
		long valor = 0;
		try {
			if (ordenarParrafoCabeceraBean.getCodigo() != 0) {
				this.getOrdenarParrafoCabeceraService().eliminar(ordenarParrafoCabeceraBean);
				valor = 0;
			}else{

			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	@RequestMapping(value = "/eliminarParrafo", method = RequestMethod.GET)
	@ResponseBody
	public Long doEliminarParrafo(@RequestParam("codigo") Integer codigo){
		System.out.println("-----Ingreso a eliminarParrafo ----");
		OrdenarParrafoBean oOrdenarParrafoBean = new OrdenarParrafoBean();
		oOrdenarParrafoBean.setCodigo(codigo);
		
		long valor = 0;
		try {
			if (oOrdenarParrafoBean.getCodigo() != 0) {
				this.getOrdenarParrafoService().eliminar(oOrdenarParrafoBean);
				valor = 0;
			}else{

			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	@RequestMapping(value = "/grabarOrdenParrafoCabecera", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarOrdenParrafoCabecera(@RequestParam("idEjercicio") Integer idEjercicio,
			 								 @RequestParam("tituloCabecera") String tituloCabecera,
			 								@RequestParam("idOrdenParrafoCabecera") int idOrdenParrafoCabecera
			 									 								 ){
		System.out.println("-----Ingreso a grabarOrdenParrafoCabecera ----");
		OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean = new OrdenarParrafoCabeceraBean();
		ordenarParrafoCabeceraBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
		ordenarParrafoCabeceraBean.setTitulo(tituloCabecera);
		ordenarParrafoCabeceraBean.setCodigo(idOrdenParrafoCabecera);
		
		
		
		long valor = 0;
		try {
			if (ordenarParrafoCabeceraBean.getCodigo() != 0) {
				this.getOrdenarParrafoCabeceraService().actualizar(ordenarParrafoCabeceraBean);
				valor = ordenarParrafoCabeceraBean.getCodigo();
			}else{

				this.getOrdenarParrafoCabeceraService().insertar(ordenarParrafoCabeceraBean);
				valor = ordenarParrafoCabeceraBean.getCodigo();
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	@RequestMapping(value = "/listarParrafoCabecera", method = RequestMethod.POST)
	@ResponseBody 
	public List<OrdenarParrafoCabeceraBean> doListarParrafoCabecera(@RequestParam("idEjercicio") Integer idEjercicio
			  														
			  															){
		OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean =  new OrdenarParrafoCabeceraBean();
		ordenarParrafoCabeceraBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
	
		
		List<OrdenarParrafoCabeceraBean> lstOrdenarParrafoCabeceraBean = new ArrayList<OrdenarParrafoCabeceraBean>();
		try {
			lstOrdenarParrafoCabeceraBean = this.getOrdenarParrafoCabeceraService().getBuscarPorFiltros(ordenarParrafoCabeceraBean);
			if (lstOrdenarParrafoCabeceraBean != null && lstOrdenarParrafoCabeceraBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstOrdenarParrafoCabeceraBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstOrdenarParrafoCabeceraBean;
	}
	@RequestMapping(value = "/grabarTextoTexto", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarTextoTexto(@RequestParam("idEjercicio") Integer idEjercicio,
			 					   @RequestParam("texto") String texto,
			 					   @RequestParam("textoRelacionado") String textoRelacionado,
			 					   @RequestParam("idTextoTexto") Integer idTextoTexto,
			 					   @RequestParam("idRelacionCabecera") Integer idRelacionCabecera,
			 					  @RequestParam("textoRelacion2") String textoRelacion2){
		System.out.println("-----Ingreso a grabarTextoTexto ----");
		RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean();
		relacionCabeceraBean.setTitulo("");
		System.out.println("idEjercicio"+idEjercicio);
		relacionCabeceraBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		relacionCabeceraBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
		relacionCabeceraBean.setCodigoUsuarioCreacion(1);
		relacionCabeceraBean.setIpCreacion("");
		
		RelacionBean relacionBean =  new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.setPalabra("");
		relacionBean.setTexto(texto);
		relacionBean.setTexto2(textoRelacionado);
		relacionBean.setCodigo(idTextoTexto);
		relacionBean.setImagen("");
		relacionBean.setOrientacion(0);
		relacionBean.setOrden(0);
		relacionBean.setTipoRelacion(0);
		relacionBean.setCodigoUsuarioCreacion(1);
		relacionBean.setIpCreacion("");
		relacionBean.setTexto3(textoRelacion2);

		relacionBean.getRelacionCabeceraBean().setCodigo(idRelacionCabecera);
		
		
		long valor = 0;
		try {
			if (relacionBean.getCodigo() != 0) {
				relacionBean.setCodigoUsuarioModificacion(1);
				this.getRelacionService().actualizar(relacionBean);
				valor = relacionBean.getCodigo();
			}else{

				this.getRelacionCabeceraService().insertar(relacionCabeceraBean);
				System.out.println("relacionCabeceraBean.getCodigo() : " + relacionCabeceraBean.getCodigo());
				
				relacionBean.getRelacionCabeceraBean().setCodigo(relacionCabeceraBean.getCodigo());
				
				System.out.println("Insertar Relacion");
				
				this.getRelacionService().insertar(relacionBean);
				valor = relacionBean.getCodigo();
			}
			
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	@RequestMapping(value = "/grabarCrucigrama", method = RequestMethod.POST)
	@ResponseBody
	public Long dGrabarCrucigrama(
		   @RequestParam("idEjercicio") Integer idEjercicio,
		   @RequestParam("palabra") String palabra,
		   @RequestParam("definicion") String definicion,
		   @RequestParam("orden") Integer orden,
		   @RequestParam("orientacion") Integer orientacion,
		   @RequestParam("idCrucigrama") Integer idCrucigrama,
		   @RequestParam("idRelacionCabecera") Integer idRelacionCabecera
		 
			)
	{
		System.out.println("-----Ingreso a grabarTextoTexto ----");
		RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean();
		relacionCabeceraBean.setTitulo("");
		System.out.println("idEjercicio"+idEjercicio);
		relacionCabeceraBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		relacionCabeceraBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
		relacionCabeceraBean.setAudCodigoUsuario(1);
		relacionCabeceraBean.setAudHostIP("");
//		relacionCabeceraBean.setIpCreacion("192.40.142.13");
		relacionCabeceraBean.setIpCreacion("");
		
		
		
		RelacionBean relacionBean =  new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.setPalabra(palabra);
		relacionBean.setTexto(definicion);
		relacionBean.setTexto2("");
		relacionBean.setCodigo(idCrucigrama);
		relacionBean.setImagen("");
		relacionBean.setOrientacion(orientacion);
		relacionBean.setOrden(orden);
		relacionBean.setTipoRelacion(0);
		relacionBean.setAudCodigoUsuario(1);
		relacionBean.setAudHostIP("");
		relacionBean.setTexto3("");
		 
		relacionBean.setCodigoUsuarioCreacion(1);
		relacionBean.setIpCreacion("");
	 

		relacionBean.getRelacionCabeceraBean().setCodigo(idRelacionCabecera);
		
		
		long valor = 0;
		try {
			if (relacionBean.getCodigo() != 0) {
				relacionBean.setCodigoUsuarioModificacion(1);
			 
				this.getRelacionService().actualizar(relacionBean);
				valor = relacionBean.getCodigo();
			}else{

				this.getRelacionCabeceraService().insertar(relacionCabeceraBean);
				System.out.println("relacionCabeceraBean.getCodigo() : " + relacionCabeceraBean.getCodigo());
				
				relacionBean.getRelacionCabeceraBean().setCodigo(relacionCabeceraBean.getCodigo());
				
				System.out.println("Insertar Relacion");
				
				this.getRelacionService().insertar(relacionBean);
				valor = relacionBean.getCodigo();
			}
			
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	@RequestMapping(value = "/listarTextoTexto", method = RequestMethod.POST)
	@ResponseBody 
	public List<RelacionBean> doListarTextoTexto(@RequestParam("idEjercicio") Integer idEjercicio){
		System.out.println("---- Ingreso a listarTextoTexto ----");
		
		RelacionBean relacionBean =  new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
	
		
		List<RelacionBean> lstRelacionBean = new ArrayList<RelacionBean>();
		try {
			lstRelacionBean = this.getRelacionService().listarTextoTexto(relacionBean);
			if (lstRelacionBean != null && lstRelacionBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstRelacionBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstRelacionBean;
	}
	
	@RequestMapping(value = "/listarCrucigrama", method = RequestMethod.POST)
	@ResponseBody 
	public List<RelacionBean> dolistarCrucigrama(@RequestParam("idEjercicio") Integer idEjercicio){
		System.out.println("---- Ingreso a listarTextoTexto ----");
		
		RelacionBean relacionBean =  new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
	
		
		List<RelacionBean> lstRelacionBean = new ArrayList<RelacionBean>();
//		try {
//			lstRelacionBean = this.getRelacionService().listarCrucigrama(relacionBean);
//			if (lstRelacionBean != null && lstRelacionBean.size() >0) {
//				
//				System.out.println("--------------------------->"+ lstRelacionBean.size());
//			}else{
//				System.out.println("Lista vacia");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}

		return lstRelacionBean;
	}
	
	@RequestMapping(value = "/objrelaciontexto", method = RequestMethod.GET)
	@ResponseBody 
	public RelacionBean doObjrelaciontexto(@RequestParam("codigo") Integer codigo){

		RelacionBean oRelacionBean = new RelacionBean();
		oRelacionBean.setCodigo(codigo);
		System.out.println("oRelacionBean.getCodigo()"+oRelacionBean.getCodigo());
		relacionBean = new RelacionBean();
		oRelacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		oRelacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		try {
			
			relacionBean = this.getRelacionService().getBuscarPorObjecto(oRelacionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relacionBean;
	}
	
	@RequestMapping(value = "/objrelacionCrucigrama", method = RequestMethod.GET)
	@ResponseBody 
	public RelacionBean doObjrelacionCrucigrama(@RequestParam("codigo") Integer codigo){

		RelacionBean oRelacionBean = new RelacionBean();
		oRelacionBean.setCodigo(codigo);
		System.out.println("oRelacionBean.getCodigo()"+oRelacionBean.getCodigo());
		relacionBean = new RelacionBean();
		oRelacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		oRelacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		try {
			
			relacionBean = this.getRelacionService().getBuscarPorObjecto(oRelacionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relacionBean;
	}
	
	@RequestMapping(value = "/eliminarTextoTexto", method = RequestMethod.GET)
	@ResponseBody
	public Long doEliminarTextoTexto(@RequestParam("codigo") Integer codigo){
		System.out.println("-----Ingreso a eliminarParrafo ----");
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setCodigo(codigo);
		
		long valor = 0;
		try {
			if (relacionBean.getCodigo() != 0) {
				this.getRelacionService().eliminar(relacionBean);
				valor = 0;
			}else{

			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	
	@RequestMapping(value = "/eliminarCrucigrama", method = RequestMethod.GET)
	@ResponseBody
	public Long doEliminarCrucigrama(@RequestParam("codigo") Integer codigo){
		System.out.println("-----Ingreso a eliminarParrafo ----");
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setCodigo(codigo);
		
		long valor = 0;
		try {
			if (relacionBean.getCodigo() != 0) {
				this.getRelacionService().eliminar(relacionBean);
				valor = 0;
			}else{

			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;

		}
	

	/***********************R****************************/
	@RequestMapping(value = "/ListTextoPalabraCorrectaxMaterialTE", method = RequestMethod.GET)
	@ResponseBody 
	public TextoPalabraCorrectaBean doListTextoPalabraCorrectaxMaterialTE(@RequestParam("p_codmatpej") Integer codmatTE){
		System.out.println("idTipoEjercicio " + codmatTE);
		TextoPalabraCorrectaBean  oTextoPalabraCorrectaBean = null;
		
		TextoPalabraCorrectaBean textoPalabraCorrectaBean = new TextoPalabraCorrectaBean();
		textoPalabraCorrectaBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean()); 
		textoPalabraCorrectaBean.getMaterialTipoEjercicioBean().setCodigo(codmatTE);
		
		try {
			oTextoPalabraCorrectaBean = this.textoPalabraCorrectaService.getBuscarPorTEM(textoPalabraCorrectaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oTextoPalabraCorrectaBean;
	}
	
	@RequestMapping(value = "/ListEspacioxTextoPalabraCorrecta", method = RequestMethod.POST)
	@ResponseBody 
	public List<AlterTextoPalabraCorrectaBean> doListEspacioxTextoPalabraCorrecta(@RequestParam("p_codtextopalabracorrec") Integer codOracion)
	{
		AlterTextoPalabraCorrectaBean  Bean = new AlterTextoPalabraCorrectaBean();
		Bean.setTextoPalabraCorrectaBean(new TextoPalabraCorrectaBean()); 
		Bean.getTextoPalabraCorrectaBean().setCodigo(codOracion);
		
		List<AlterTextoPalabraCorrectaBean> lstBean  = new ArrayList<AlterTextoPalabraCorrectaBean>();
		try{
			lstBean = this.alterTextoPalabraCorrectaService.getBuscarPorTextoPalabraCorrecta(Bean);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("List<AlterTextoPalabraCorrectaBean>1--------------------------->"+ lstBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	 
	@RequestMapping(value = "/BuscarAlternativasxPalabraCorrectaTexto", method = RequestMethod.GET)
	@ResponseBody 
	public List<AlterTextoPalabraCorrectaBean> doBuscarAlternativasxPalabraCorrectaTexto(@RequestParam("p_codcomporacion") Integer codOracion,@RequestParam("p_numespacio") String Espacio)
	{
		AlterTextoPalabraCorrectaBean  Bean = new AlterTextoPalabraCorrectaBean();
		Bean.setTextoPalabraCorrectaBean(new TextoPalabraCorrectaBean()); 
		Bean.getTextoPalabraCorrectaBean().setCodigo(codOracion);
		Bean.setPalabraCorrecta(Espacio);
		
		List<AlterTextoPalabraCorrectaBean> lstBean  = new ArrayList<AlterTextoPalabraCorrectaBean>();
		try{
			lstBean = this.alterTextoPalabraCorrectaService.buscarxPalabraxTexto(Bean);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("List<AlterTextoPalabraCorrectaBean>2--------------------------->"+ lstBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	
	
	@RequestMapping(value = "/grabarTextoPalabraCorrecta", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarTextoPalabraCorrecta(@RequestParam("p_titulo") String titulo,
			@RequestParam("p_oracion") String oracion, @RequestParam("p_codmatpej") Integer codmatpej, @RequestParam("idOracionComple") Integer idOracionComple, HttpServletRequest request) {

		 TextoPalabraCorrectaBean Bean = new TextoPalabraCorrectaBean();
		 Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		 Bean.getMaterialTipoEjercicioBean().setCodigo(codmatpej);
		 Bean.setTitulo(titulo);
		 Bean.setTexto(oracion);
		 Bean.setCodigo(idOracionComple);
		  
	
			try {
				if (Bean.getCodigo() != 0) {
					this.setAuditoria(Bean, request, false);
					this.textoPalabraCorrectaService.actualizar(Bean);
				}else{ 
					this.setAuditoria(Bean, request, true);
					this.textoPalabraCorrectaService.insertar(Bean);
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 return "0";
			 }
		
			
//			 try {
//			 if (oracionCompletarService.insertar(Bean)) {
//			 System.out.println("Se insertó el ejercicio con éxito");
//			 // lstEjercicios =
//			 // ejercicioService.getBuscarPorFiltros(ejercicioBean);
//			 } else {
//			 System.out.println("Falló el registro");
//			 } 
//				 System.out.println("lstEjercicios.size() :: "+ lstEjercicios.size());
				 return String.valueOf(Bean.getCodigo());
//				 PROVISIONAL
//				return "";
			}
	@RequestMapping(value = "/grabarPalabraCorrectaTexto", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarPalabraCorrectaTexto(@RequestBody OracionAlterBean[] respuestaArray, HttpServletRequest request)  {
		 System.out.println("respuestaArray.length" + respuestaArray.length);
		 AlterTextoPalabraCorrectaBean alternativaBean = new AlterTextoPalabraCorrectaBean();
		 alternativaBean.setTextoPalabraCorrectaBean(new TextoPalabraCorrectaBean());
		 
		 for (int i = 0; i < respuestaArray.length; i++) {
			 
			 System.out.println(respuestaArray[i] + "\n");
			 System.out.println("wuuuuuuuuuu"+respuestaArray[i].getOracionCompletarBean().getCodigo()
			 + "\n");
			 alternativaBean.getTextoPalabraCorrectaBean().setCodigo(respuestaArray[i].getOracionCompletarBean().getCodigo());
	
			 alternativaBean.setPalabraCorrecta(respuestaArray[i].getEspacio());
			 alternativaBean.setDescripcion(respuestaArray[i].getDescripcion());
			 alternativaBean.setRespuestaEstado(respuestaArray[i].getRespuestaEstado()); 
			 alternativaBean.setCodigo(respuestaArray[i].getCodigo());
			
			 try {  
				 if (alternativaBean.getCodigo()  != 0)  {
						this.setAuditoria(alternativaBean, request, false);
					 this.alterTextoPalabraCorrectaService.actualizar(alternativaBean);
					 System.out.println("actualizandooo");
			
				 } else { 
						this.setAuditoria(alternativaBean, request, true);
					 this.alterTextoPalabraCorrectaService.insertar(alternativaBean);
					 System.out.println("insertandoooooo");
				 }
			 } catch (ServiceException e) {
				 e.printStackTrace();
			 }
		 }
		 
		 return String.valueOf(alternativaBean.getCodigo());
	}
	
	@RequestMapping(value = "/eliminarAlternativasTextoPalabraCorrecta", method = RequestMethod.GET)
	@ResponseBody
	public void doEliminarAlternativasTextoPalabraCorrecta(@RequestParam("p_codcomporacion") Integer codoracion,@RequestParam("p_numespacio") String codEspacio,
			HttpServletRequest request) {
		boolean sw = false; 
		AlterTextoPalabraCorrectaBean  Bean = new AlterTextoPalabraCorrectaBean();
		Bean.setTextoPalabraCorrectaBean(new TextoPalabraCorrectaBean()); 
		Bean.getTextoPalabraCorrectaBean().setCodigo(codoracion);
		Bean.setPalabraCorrecta(codEspacio);

		// this.setAuditoria(lenguaBean, request, false);
		try {
			this.setAuditoria(Bean, request, false);
			sw = (this.alterTextoPalabraCorrectaService.eliminar(Bean));

		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
			 					 
	public CargaMaterialBean getCargaMaterialBean() {
		return cargaMaterialBean;
	}

	public void setCargaMaterialBean(CargaMaterialBean cargaMaterialBean) {
		this.cargaMaterialBean = cargaMaterialBean;
	}

	// public LeccionService getLeccionService() {
	// return leccionService;
	// }
	//
	// public void setLeccionService(LeccionService leccionService) {
	// this.leccionService = leccionService;
	// }

	public List<LenguaEstructuraBean> getLstLenguaEstructuraBean() {
		return lstLenguaEstructuraBean;
	}

	public void setLstLenguaEstructuraBean(List<LenguaEstructuraBean> lstLenguaEstructuraBean) {
		this.lstLenguaEstructuraBean = lstLenguaEstructuraBean;
	}

	// public EjercicioBean getEjercicioBean() {
	// return ejercicioBean;
	// }
	//
	// public void setEjercicioBean(EjercicioBean ejercicioBean) {
	// this.ejercicioBean = ejercicioBean;
	// }

	public String getRootPath() {
		return ResourceUtil.getKey("ruta.natigu.archivos.general.material");
	}

	public MaterialTipoEjercicioService getMaterialTipoEjercicioService() {
		return materialTipoEjercicioService;
	}

	public void setMaterialTipoEjercicioService(
			MaterialTipoEjercicioService materialTipoEjercicioService) {
		this.materialTipoEjercicioService = materialTipoEjercicioService;
	}

	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}
	

	public OracionAlterService getOracionAlterService() {
		return oracionAlterService;
	}

	public void setOracionAlterService(OracionAlterService oracionAlterService) {
		this.oracionAlterService = oracionAlterService;
	}
	

	public OrdenarParrafoService getOrdenarParrafoService() {
		return ordenarParrafoService;
	}

	public void setOrdenarParrafoService(OrdenarParrafoService ordenarParrafoService) {
		this.ordenarParrafoService = ordenarParrafoService;
	}

	public OrdenarParrafoBean getOrdenarParrafoBean() {
		return ordenarParrafoBean;
	}

	public void setOrdenarParrafoBean(OrdenarParrafoBean ordenarParrafoBean) {
		this.ordenarParrafoBean = ordenarParrafoBean;
	}

	public OrdenarParrafoCabeceraService getOrdenarParrafoCabeceraService() {
		return ordenarParrafoCabeceraService;
	}

	public void setOrdenarParrafoCabeceraService(
			OrdenarParrafoCabeceraService ordenarParrafoCabeceraService) {
		this.ordenarParrafoCabeceraService = ordenarParrafoCabeceraService;
	}

	public OrdenarParrafoCabeceraBean getOrdenarParrafoCabeceraBean() {
		return ordenarParrafoCabeceraBean;
	}

	public void setOrdenarParrafoCabeceraBean(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) {
		this.ordenarParrafoCabeceraBean = ordenarParrafoCabeceraBean;
	}

	public RelacionService getRelacionService() {
		return relacionService;
	}

	public void setRelacionService(RelacionService relacionService) {
		this.relacionService = relacionService;
	}

	public RelacionCabeceraService getRelacionCabeceraService() {
		return relacionCabeceraService;
	}

	public void setRelacionCabeceraService(
			RelacionCabeceraService relacionCabeceraService) {
		this.relacionCabeceraService = relacionCabeceraService;
	}

	public RelacionBean getRelacionBean() {
		return relacionBean;
	}

	public void setRelacionBean(RelacionBean relacionBean) {
		this.relacionBean = relacionBean;
	}

	
		
}
