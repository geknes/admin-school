package com.service.school.web.gestion.controller.general;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
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

import com.service.school.core.bean.bean.generico.AlternativaBean;
import com.service.school.core.bean.bean.generico.CargaMaterialBean;
import com.service.school.core.bean.bean.generico.LeccionMaterialBean;
import com.service.school.core.bean.bean.generico.LenguaBean;
import com.service.school.core.bean.bean.generico.LenguaEstructuraBean;
import com.service.school.core.bean.bean.generico.MaestraBean;
import com.service.school.core.bean.bean.generico.MaterialEjercicioBean;
import com.service.school.core.bean.bean.generico.MaterialTipoEjercicioBean;
import com.service.school.core.bean.bean.generico.PreguntaBean;

import com.service.school.core.bean.bean.generico.RelacionBean;
import com.service.school.core.bean.bean.generico.UnidadBean;
import com.service.school.core.bean.bean.generico.UnidadLeccionBean;
import com.service.school.core.service.exception.ServiceException;
import com.service.school.core.service.service.interfaces.general.AlternativaService;
import com.service.school.core.service.service.interfaces.general.LeccionMaterialService;
import com.service.school.core.service.service.interfaces.general.LenguaEstructuraService;
import com.service.school.core.service.service.interfaces.general.LenguaService;
import com.service.school.core.service.service.interfaces.general.Maestra2Service;
import com.service.school.core.service.service.interfaces.general.MaterialTipoEjercicioService;
import com.service.school.core.service.service.interfaces.general.PreguntaService;

import com.service.school.core.service.service.interfaces.general.RelacionService;
import com.service.school.core.service.service.interfaces.general.UnidadLeccionService;
import com.service.school.core.service.service.interfaces.general.UnidadService;
import com.service.school.web.gestion.controller.base.BaseController;
import com.service.school.web.gestion.utilitarios.FileUtil;
import com.service.school.web.gestion.utilitarios.ResourceUtil;
import com.service.school.web.gestion.utilitarios.VO;

@Controller
@Scope(value="session")
@RequestMapping(value = "cargaMasivaController")
public class CargaMasivaController  extends BaseController{
	
	private CargaMaterialBean 	cargaMaterialBean;
	
	private List<LenguaBean>	lstLengua;
	private List<MaestraBean>	lstNivel;
	private List<MaestraBean>	lstSubNivel;
	private List<MaestraBean> 	lstUnidad;
	
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private LenguaEstructuraService	lenguaEstructuraService;
	
	/** SERVICIOS PARA INSERTAR DATOS **/
	@Autowired
	private PreguntaService 		preguntaService;
	
	@Autowired
	private RelacionService 		relacionService;
	
	@Autowired
	private AlternativaService alternativaService;
	
	/** CAMBIOS **/
	@Autowired
	private UnidadService unidadService;
	
	@Autowired
	private UnidadLeccionService 		unidadLeccionService;
	
	@Autowired
	private LeccionMaterialService 		leccionMaterialService;
	
	@Autowired
	private MaterialTipoEjercicioService 		materialTipoEjercicioService;

	private static String findFileCeldaAudio() throws FileNotFoundException, IOException {
		/*
		 * NPOIFSFileSystem fsx = new NPOIFSFileSystem( new
		 * FileInputStream("C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls"
		 * )); HSSFWorkbook wb = new HSSFWorkbook(fsx.getRoot(), true); for
		 * (HSSFObjectData obj : wb.getAllEmbeddedObjects()) { String oleName =
		 * obj.getOLE2ClassName(); DirectoryNode dn = (DirectoryNode)
		 * obj.getDirectory(); // if(oleName.contains("Acro") &&
		 * dn.hasEntry("CONTENTS")){ // InputStream is =
		 * dn.createDocumentInputStream("CONTENTS"); FileOutputStream fos = new
		 * FileOutputStream(obj.getDirectory().getName() + ".mp4");
		 * 
		 * File file = new File(
		 * "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\" + obj.getDirectory().getName() + "
		 * a.mp4"); try { FileOutputStream fop = new FileOutputStream(file); if
		 * (!file.exists()) { file.createNewFile(); } // fop.write(data);
		 * fop.flush(); fop.close();
		 * System.out.println("Llegó a leer la imagen"); } catch (IOException e)
		 * { e.printStackTrace(); } // fop.close(); // IOUtils.copy(is, fos);
		 * fos.close(); // is.close(); // } } fsx.close();
		 * 
		 * POIFSFileSystem fs = new POIFSFileSystem( new
		 * FileInputStream("C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls"
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
									//datoCelda = row.getRowNum() + ":" + celda.toString();
									datoCelda = celda.toString();
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
			} else{
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
							System.out.println("Pregunta: "+ codigoTPregunta+"-" +cellNP.toString());
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

	public CargaMasivaController() {
//		String lsArchivo = "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls";
		/*String lsArchivo = "D:\\TIPO_PREGUNTA_ALTERNATIVAS.xls";
		InputStream lmArchivo = null;
		try {
			lmArchivo = new FileInputStream(lsArchivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Bucaremos todas las preguntas de tipo alternativas (para marcar)
		String codigoTPregunta = "{TP_ALT}";
		List<String> listaPreguntas = new ArrayList<String>();
		HSSFWorkbook wb = null; // libro de trabajo
		try {
			wb = new HSSFWorkbook(lmArchivo);
			HSSFSheet hoja = wb.getSheetAt(0);
			// Cabecera
			String nombreEjercicio = findFilaCelda(hoja, "{NOM_EJERCICIO}");
			String desEjercicio = findFilaCelda(hoja, "{DES_EJERCICIO}");
			String imgEjercicio = findFilaCelda(hoja, "{IMG_LECCION}");
			// Detalle
			listaPreguntas = findFilaCeldaPreguntas(hoja, codigoTPregunta);
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
	
	@PostConstruct
	public void init()
	{
		this.setCargaMaterialBean(new CargaMaterialBean());
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("cargaMaterialBean") CargaMaterialBean cargaMaterialBean)throws Exception {
		ModelAndView mav = new ModelAndView("general/material/carga-material-masivo", "command",cargaMaterialBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/cargarNiveles", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/cargarSubNiveles", method = RequestMethod.GET)
	public @ResponseBody List<MaestraBean> cargarSubNiveles(@RequestParam("codlengua") String codlengua,@RequestParam("codnivel") String codnivel)throws Exception {
		List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
		if (!codlengua.equals("0") && !codnivel.equals("0")){
			LenguaEstructuraBean filtro = new LenguaEstructuraBean();
			filtro.getLenguaBean().setCodigo(VO.toLong(codlengua));
			filtro.getNivel().setCodigoRegistro(VO.toInteger(codnivel));
			List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarSubNiveles(filtro);
			
			if(!VO.isEmptyList(lstLenguaEstructuraBeanNivel)){
				for (LenguaEstructuraBean objLenEstSubNivel : lstLenguaEstructuraBeanNivel) {
					if(!VO.isEmptyList(lstSubNivel)){
						for (MaestraBean objMaestroSubNivel : lstSubNivel) {
							if(objMaestroSubNivel.getCodigoRegistro() == objLenEstSubNivel.getSubNivel().getCodigoRegistro()){
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
	
	private void cargarCombos(ModelAndView mav)
	{
		try 
		{
			lstLengua = lenguaService.cargarCombo();
			lstNivel  = maestra2Service.listarPorCodigoTabla("nivel",1);
			lstSubNivel = maestra2Service.listarPorCodigoTabla("subNivel",0);
			lstUnidad = maestra2Service.listarPorCodigoTabla("unidad",0);
		} 
		catch (ServiceException e) 
		{
			e.printStackTrace();
		}	
		mav.addObject("lstLengua", lstLengua);
		mav.addObject("lstNivel",lstNivel);
		mav.addObject("lstSubNivel", lstSubNivel);
		mav.addObject("lstUnidad",lstUnidad);
	} 
	
	/***********************************************************************************************************
	 * GESTION DE ARCHIVO
	 * 
	 ***********************************************************************************************************/
	@RequestMapping(value = "/generarArchivo", method = RequestMethod.GET)	
	public ModelAndView generarArchivo(	@RequestParam("codlengua") String codlengua,
								@RequestParam("codnivel") String codnivel,
								@RequestParam("codsubnivel") String codsubnivel,
								@RequestParam("codunidad") String codunidad,
								HttpServletResponse response, HttpServletRequest request) {
		
			LenguaBean  lengua_selecc = new LenguaBean();
			MaestraBean nivel_selecc = new MaestraBean();
			MaestraBean subnivel_selecc = new MaestraBean();
			MaestraBean unidad_selecc = new MaestraBean();
			String nombreArchivo = "";
			
		try {
			
			for (LenguaBean objLengua : lstLengua) {
				if(objLengua.getCodigo() == VO.toLong(codlengua)){
					lengua_selecc = objLengua;
					break;
				}
			}
			
			if(!codnivel.equals("0") && !codsubnivel.equals("0") && !codunidad.equals("0")){
				/** 1 NIVEL - 1 SUBNIVEL - 1 UNIDAD **/
				
				//nombreArchivo= codlengua+"_"+codnivel+"_"+codsubnivel+"_"+codunidad+"_"+"plantilla_carga_masiva.xls";
				
				nivel_selecc = this.obtenerRegistroMaestro(lstNivel, VO.toInteger(codnivel));
				subnivel_selecc = this.obtenerRegistroMaestro(lstSubNivel, VO.toInteger(codsubnivel));
				unidad_selecc = this.obtenerRegistroMaestro(lstUnidad, VO.toInteger(codunidad));
				
				Date ahora = new Date();
				String strAhora = VO.dateAndHourToString(ahora);
				
				if(!VO.isNull(strAhora)){
					if(strAhora.contains("/")){
						strAhora = strAhora.replace("/", "-");
					}
					if(strAhora.contains(" ")){
						strAhora = strAhora.replace(" ", "_");
					}
					if(strAhora.contains(":")){
						strAhora = strAhora.replace(":", "-");
					}
				}
				
				nombreArchivo= lengua_selecc.getNombre()+"_N"+codnivel+"_SN"+codsubnivel+"_U"+codunidad+"_"+"carga_masiva_"+strAhora+".xls";
				
				HSSFWorkbook workbook = this.generarHSSFWorkbook(lengua_selecc, nivel_selecc, subnivel_selecc, unidad_selecc);
				
				File dir = FileUtil.fileExists(this.getRootPath());
				File serverFile = new File(dir.getAbsolutePath() + File.separator + nombreArchivo);
				
				FileOutputStream fichero = new FileOutputStream(serverFile);
				workbook.write(fichero);
				fichero.flush();
				fichero.close();
				
			}else if(!codnivel.equals("0") && !codsubnivel.equals("0") && codunidad.equals("0")){
				/** 1 NIVEL - 1 SUBNIVEL - TODOS UNIDAD **/
				
				nivel_selecc = this.obtenerRegistroMaestro(lstNivel, VO.toInteger(codnivel));
				subnivel_selecc = this.obtenerRegistroMaestro(lstSubNivel, VO.toInteger(codsubnivel));
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("general/material/ajax/detalle-archivo-generado-ajax", "command",cargaMaterialBean);
		mav.addObject("nombreArchivo",nombreArchivo);
		return mav;
		
	}
	
	@RequestMapping(value = "/descargarArchivo", method = RequestMethod.GET)	
	public void descargarArchivo(@RequestParam("fileName") String fileName, HttpServletResponse response,HttpServletRequest request) {
		
		try {
			
			File serverFile = new File(this.getRootPath() + File.separator + fileName);
			
			if(serverFile.exists()){
				InputStream lmArchivo = new FileInputStream(serverFile);
				HSSFWorkbook workbook = new HSSFWorkbook(lmArchivo);
				super.exportarExcel(workbook, fileName, response);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	@RequestMapping(value = "/subirArchivo", method = RequestMethod.POST)	
	@ResponseBody
	//public ModelAndView subirArchivo(@RequestParam("fileCarga") MultipartFile[] files,@RequestParam("fileCargaRar") MultipartFile[] filesZip, HttpServletResponse response,HttpServletRequest request) {
	public String subirArchivo(@RequestParam("fileCarga") MultipartFile[] files,@RequestParam("fileCargaRar") MultipartFile[] filesZip, HttpServletResponse response,HttpServletRequest request) {
	
		boolean swNuevoArchivo = false;
		boolean swNuevoArchivoZip = false;
		
		try {
			
			if (files.length>0) {
				swNuevoArchivo = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );
				swNuevoArchivoZip = (filesZip[0]!=null) && (filesZip[0].getOriginalFilename()!=null ) && (filesZip[0].getOriginalFilename().trim().length()>0 );
			}
			
			if(swNuevoArchivo){

				InputStream lmArchivo = files[0].getInputStream();
				
				HSSFWorkbook wb = new HSSFWorkbook(lmArchivo);
				HSSFSheet hoja = wb.getSheetAt(0);
				
				/** VALORES SELECCIONADOS **/
				String strCodLengua = findFilaCelda(hoja, "{LENGUA_SELEC}");
				String strCodNivel = findFilaCelda(hoja, "{NIVEL_SELEC}");
				String strCodSubNivel = findFilaCelda(hoja, "{SUBNIVEL_SELEC}");
				String strCodUnidad = findFilaCelda(hoja, "{UNIDAD_SELEC}");
				
				/** LECCION 1 **/
				String nombreLeccion1 = findFilaCelda(hoja, "{NOM_LECCION_1}");
				String descLeccion1 = findFilaCelda(hoja, "{DES_LECCION_1}");
				
				/** EJERCICIO 1 **/
				String nombreEjercicio1 = findFilaCelda(hoja, "{NOM_EJERCICIO_1}");
				String descEjercicio1 = findFilaCelda(hoja, "{DES_EJERCICIO_1}");
				String imgEjercicio1 = findFilaCelda(hoja, "{IMG_EJERCICIO_1}");
				String audioEjercicio1 = findFilaCelda(hoja, "{AUD_EJERCICIO_1}");
				
				/** ACTIVIDAD 1 **/
				String nombreActividad1 = findFilaCelda(hoja, "{NOM_ACTIVIDAD_1}");
				String descActividad1 = findFilaCelda(hoja, "{DES_ACTIVIDAD_1}");
				// Bucaremos todas las preguntas de tipo alternativas (para marcar)
				String codigoTPregunta = "{TP_ALT_1}";
				String pregunta1 = findFilaCelda(hoja, codigoTPregunta);
				List<String> listaPreguntas = new ArrayList<String>();
				// Detalle
				listaPreguntas = findFilaCeldaPreguntas(hoja, codigoTPregunta);
				
				/** EJERCICIO 2 RELACION TEXTO - IMAGEN**/
				String nombreEjercicio2 = findFilaCelda(hoja, "{NOM_ACTIVIDAD_2}");
				String descEjercicio2 = findFilaCelda(hoja, "{DES_ACTIVIDAD_2}");
				
				/** EJERCICIO 3 **/
				String nombreEjercicio3 = findFilaCelda(hoja, "{NOM_ACTIVIDAD_3}");
				String descEjercicio3 = findFilaCelda(hoja, "{DES_ACTIVIDAD_3}");
				
				/** EJERCICIO 4 **/
				String nombreEjercicio4 = findFilaCelda(hoja, "{NOM_ACTIVIDAD_4}");
				String descEjercicio4 = findFilaCelda(hoja, "{DES_ACTIVIDAD_4}");
				
				/** EJERCICIO 5 **/
				String nombreEjercicio5 = findFilaCelda(hoja, "{NOM_ACTIVIDAD_5}");
				String descEjercicio5 = findFilaCelda(hoja, "{DES_ACTIVIDAD_5}");
				
				/** EJERCICIO 6 **/
				String nombreEjercicio6 = findFilaCelda(hoja, "{NOM_ACTIVIDAD_6}");
				String descEjercicio6 = findFilaCelda(hoja, "{DES_ACTIVIDAD_6}");
				
				/** RELACIONES **/
				
				/** LECCION 2 **/
				String nombreLeccion2 = findFilaCelda(hoja, "{NOM_EJERCICIO_2}");
				String descLeccion2 = findFilaCelda(hoja, "{DES_EJERCICIO_2}");
				
				// Bucaremos todas las preguntas de tipo alternativas (para marcar)
				String codigoTPregunta_2 = "{TP_ALT_2}";
				List<String> listaPreguntas_2 = new ArrayList<String>();
				// Detalle
				listaPreguntas_2 = findFilaCeldaPreguntas(hoja, codigoTPregunta);
				
				boolean sw = false;
				
				if(strCodLengua.contains(".0")){
					strCodLengua = strCodLengua.replace(".0", "");
				}
				if(strCodNivel.contains(".0")){
					strCodNivel = strCodNivel.replace(".0", "");
				}
				if(strCodSubNivel.contains(".0")){
					strCodSubNivel = strCodSubNivel.replace(".0", "");
				}
				if(strCodUnidad.contains(".0")){
					strCodUnidad = strCodUnidad.replace(".0", "");
				}
				
				/** BUSQUEDA DE TODAS LAS ESTRUCTURAS DE LA LENGUA **/
				LenguaBean filtroLenguaBean = new LenguaBean();
				filtroLenguaBean.setCodigo(VO.toLong(strCodLengua));
				List<LenguaEstructuraBean> listaLenguaEstructuraBean = lenguaEstructuraService.listarPorCodigoLengua(filtroLenguaBean);
				
				if(!VO.isEmptyList(listaLenguaEstructuraBean)){
					
					long codLenguaEstructuraBean = 0;
					
					/** RECORRER Y EXTRAER CODIGO LENGUA ESTRUCTURA POR EL NIVEL Y SUBNIVEL SELECCIONADO **/
					for (int i = 0; i < listaLenguaEstructuraBean.size(); i++) {
						LenguaEstructuraBean prmLE = listaLenguaEstructuraBean.get(i);
						if(VO.toInteger(strCodNivel) == prmLE.getNivel().getCodigoRegistro()){
							if(VO.toInteger(strCodNivel) == prmLE.getSubNivel().getCodigoRegistro()){
								codLenguaEstructuraBean = prmLE.getCodigo();
								break;
							}
						}
					}
					
					/** SI SE ENCUENTRA REGISTRO EN TABLA LENGUA ESTRUCTURA **/
					if(codLenguaEstructuraBean > 0){
						
						long codUnidadEncontrado = 0;
						
						/** BUSQUEDA DE LA UNIDAD POR MEDIO DEL CODIGO DE LA ESTRUCTURA Y MAESTRO UNIDAD **/
						UnidadBean filtroUnidad = new UnidadBean();
						filtroUnidad.setLenguaEstructuraBean(new LenguaEstructuraBean());
						filtroUnidad.getLenguaEstructuraBean().setCodigo(codLenguaEstructuraBean);
						filtroUnidad.setUnidad(new MaestraBean());
						filtroUnidad.getUnidad().setCodigoRegistro(VO.toInteger(strCodUnidad));
						List<UnidadBean> listaUnidadBean = unidadService.getBuscarPorFiltros(filtroUnidad);
						
						if(!VO.isEmptyList(listaUnidadBean)){
							codUnidadEncontrado = listaUnidadBean.get(0).getCodigo();
						}
						
						/** SI SE ENCUENTRA REGISTRO EN TABLA UNIDAD **/
						if(codUnidadEncontrado>0){
							
							/** INSERTAR LECCION 1 **/			
							UnidadLeccionBean leccionBean = new UnidadLeccionBean();
							leccionBean.setNombre(nombreLeccion1);
							leccionBean.setDescripcion(descLeccion1);
							leccionBean.setSituacion(new MaestraBean());
							leccionBean.getSituacion().setCodigoRegistro(1);
							leccionBean.setUnidadBean(new UnidadBean());
							leccionBean.getUnidadBean().setCodigo(codUnidadEncontrado);
							
							sw = unidadLeccionService.insertar(leccionBean);				
							
							if(sw){
								
								if(!VO.isNull(leccionBean) && leccionBean.getCodigo()>0){
									/**DESCOMPRIMIR IMAGENES**/
									if(swNuevoArchivoZip){
										String rutaImagenes = this.getRutaExterna("ruta.natigu.archivos.recursos.externos.imagen");
										
										byte[] bytes = filesZip[0].getBytes();               
						    			File dir=FileUtil.fileExists(rutaImagenes);
						                File zip = new File(dir.getAbsolutePath()+File.separator+filesZip[0].getOriginalFilename());
						                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(zip));
						                stream.write(bytes);
						                stream.close();
						                
										this.unZipFiles(zip, rutaImagenes+File.separator+strCodLengua+File.separator+strCodNivel+File.separator+strCodSubNivel+File.separator+strCodUnidad);
									}
									/**FIN DESCOMPRIMIR IMAGENES**/
									
									/** BEGIN INSERTAR MATERIAL 1 **/						
									LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
									leccionMaterialBean.setUnidadLeccionBean(new UnidadLeccionBean());
									leccionMaterialBean.getUnidadLeccionBean().setCodigo(leccionBean.getCodigo());
									leccionMaterialBean.setSituacionLeccionMaterial(new MaestraBean());
									leccionMaterialBean.getSituacionLeccionMaterial().setCodigoRegistro(1);
									leccionMaterialBean.setDescripcionMaterial(nombreEjercicio1);
									leccionMaterialBean.setContexto(descEjercicio1);
									leccionMaterialBean.setNombreImagen(imgEjercicio1);
									leccionMaterialBean.setRutaAudio(audioEjercicio1);
									
									sw = leccionMaterialService.insertar(leccionMaterialBean);
									
									if(sw){
										if(!VO.isNull(leccionMaterialBean) && leccionMaterialBean.getCodigo()>0){
											
											/** BEGIN INSERTAR EJERCICIO 1 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_1 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_1.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_1.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_1.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_1.getTipoEjercicio().setCodigoRegistro(1);
											materialTipoEjercicioBean_1.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_1.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_1);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_1) && materialTipoEjercicioBean_1.getCodigo()>0){
													/** INSERTAR PREGUNTAS Y RESPUESTAS **/
													this.registrarPreguntasYRespuestas(hoja, "{TP_ALT_1}", "{[RP]}", "{*RP}", materialTipoEjercicioBean_1.getCodigo(), 1);
												}
											}
											
											/** BEGIN INSERTAR EJERCICIO 2 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_2 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_2.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_2.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_2.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_2.getTipoEjercicio().setCodigoRegistro(2);
											materialTipoEjercicioBean_2.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_2.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_2);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_2) && materialTipoEjercicioBean_2.getCodigo()>0){
													/** INSERTAR RELACIONES TEXT-IMG CON EL CODIGO EJERCICIO **/
													this.registrarRelacionPalabraImagen(hoja, "{TP_REL_I_1}", "{[PRI]}", materialTipoEjercicioBean_2.getCodigo());
												}
											}
											
											/** BEGIN INSERTAR EJERCICIO 3 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_3 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_3.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_3.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_3.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_3.getTipoEjercicio().setCodigoRegistro(3);
											materialTipoEjercicioBean_3.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_3.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_3);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_3) && materialTipoEjercicioBean_3.getCodigo()>0){
													/** INSERTAR RELACIONES TEXT-TEXT CON EL CODIGO EJERCICIO **/
													this.registrarRelacionPalabraTexto(hoja,"{TP_REL_T_1}","{[PRT]}",materialTipoEjercicioBean_3.getCodigo());
												}
											}
											
											/** BEGIN INSERTAR EJERCICIO 4 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_4 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_4.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_4.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_4.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_4.getTipoEjercicio().setCodigoRegistro(4);
											materialTipoEjercicioBean_4.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_4.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_4);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_4) && materialTipoEjercicioBean_4.getCodigo()>0){
													/** INSERTAR CORREGIR TEXTO CON EL CODIGO EJERCICIO **/
													this.registrarPreguntasYRespuestas(hoja, "{TP_PALCORR_1}", "{[ACR]}", "{*ACR}", materialTipoEjercicioBean_4.getCodigo(), 2);
												}
											}
											
											/** BEGIN INSERTAR EJERCICIO 5 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_5 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_5.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_5.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_5.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_5.getTipoEjercicio().setCodigoRegistro(3);
											materialTipoEjercicioBean_5.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_5.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_5);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_5) && materialTipoEjercicioBean_5.getCodigo()>0){
													/** INSERTAR COMPLETAR TEXTO CON EL CODIGO EJERCICIO **/
													this.registrarPreguntasYRespuestas(hoja, "{TP_PALCOM_1}", "{[ACM]}", "{*ACM}", materialTipoEjercicioBean_5.getCodigo(), 3);
												}
											}
											
											/** BEGIN INSERTAR EJERCICIO 6 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_6 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_6.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_6.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_6.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_6.getTipoEjercicio().setCodigoRegistro(3);
											materialTipoEjercicioBean_6.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_6.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_6);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_6) && materialTipoEjercicioBean_6.getCodigo()>0){
													/** INSERTAR CRUCIGRAMA **/
													this.registrarRelacionCrucigrama(hoja, "{TP_CRUC_1}", "{[CRG]}", materialTipoEjercicioBean_6.getCodigo());
												}
											}
											
										}
										
									}
									/** ************END INSERTAR MATERIAL 1*********** **/
								}
								
							}
							
							/** BEGIN INSERTAR LECCION 2 **/
							leccionBean = new UnidadLeccionBean();
							leccionBean.setNombre(nombreLeccion2);
							leccionBean.setDescripcion(descLeccion2);
							leccionBean.setSituacion(new MaestraBean());
							leccionBean.getSituacion().setCodigoRegistro(1);
							leccionBean.setUnidadBean(new UnidadBean());
							leccionBean.getUnidadBean().setCodigo(codUnidadEncontrado);
							
							sw = unidadLeccionService.insertar(leccionBean);	
						
							if(sw){
								
								if(!VO.isNull(leccionBean) && leccionBean.getCodigo()>0){
									
									/** BEGIN INSERTAR MATERIAL 1 **/
									LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
									leccionMaterialBean.setUnidadLeccionBean(new UnidadLeccionBean());
									leccionMaterialBean.getUnidadLeccionBean().setCodigo(leccionBean.getCodigo());
									leccionMaterialBean.setSituacionLeccionMaterial(new MaestraBean());
									leccionMaterialBean.getSituacionLeccionMaterial().setCodigoRegistro(1);
									leccionMaterialBean.setDescripcionMaterial(nombreEjercicio2);
									leccionMaterialBean.setContexto(descEjercicio2);
									leccionMaterialBean.setNombreImagen("");
									leccionMaterialBean.setRutaAudio("");
									
									sw = leccionMaterialService.insertar(leccionMaterialBean);
									
									if(sw){
										if(!VO.isNull(leccionMaterialBean) && leccionMaterialBean.getCodigo()>0){
											
											/** BEGIN INSERTAR EJERCICIO 1 **/
											MaterialTipoEjercicioBean materialTipoEjercicioBean_1 = new MaterialTipoEjercicioBean();
											materialTipoEjercicioBean_1.setLeccionMaterialBean(new LeccionMaterialBean());
											materialTipoEjercicioBean_1.getLeccionMaterialBean().setCodigo(leccionMaterialBean.getCodigo());
											materialTipoEjercicioBean_1.setTipoEjercicio(new MaestraBean());
											materialTipoEjercicioBean_1.getTipoEjercicio().setCodigoRegistro(1);
											materialTipoEjercicioBean_1.setSituacionTipo(new MaestraBean());
											materialTipoEjercicioBean_1.getSituacionTipo().setCodigoRegistro(1);
											
											sw = materialTipoEjercicioService.insertar(materialTipoEjercicioBean_1);
											
											if(sw){
												if(!VO.isNull(materialTipoEjercicioBean_1) && materialTipoEjercicioBean_1.getCodigo()>0){
													/** INSERTAR PREGUNTAS Y RESPUESTAS **/
													this.registrarPreguntasYRespuestas(hoja, "{TP_ALT_2}", "{[RP2]}", "{*RP2}", materialTipoEjercicioBean_1.getCodigo(), 1);
												}
											}
											
											/** BEGIN INSERTAR EJERCICIO 2 **/
											
											
											/** BEGIN INSERTAR EJERCICIO 3 **/
											
											
											/** BEGIN INSERTAR EJERCICIO 4 **/
											
											
											/** BEGIN INSERTAR EJERCICIO 5 **/
											
											
											/** BEGIN INSERTAR EJERCICIO 6 **/
											
											
										}
										
									}
									/** ************END INSERTAR MATERIAL 1*********** **/
								}
								
							}
						}
						
					}
					
				}
				
			}
						
		} catch (Exception e) {
			e.getStackTrace();
		}	
		
		/*ModelAndView mav = new ModelAndView("general/material/carga-material-masivo", "command",cargaMaterialBean);
		this.cargarCombos(mav);
		mav.addObject("swMensaje","1");
		return mav;*/
		return "1";
	}
	
	private void registrarRelacionPalabraTexto(HSSFSheet sheet, String codigoTRelacion, String codigoOpcionRelacion, long codEjercicio){
		try {
			RelacionBean relacion = null;
			for (Row row : sheet) {
				for (Cell cell : row) {
					if(cell.getColumnIndex() == 0){
						if(cell.getRichStringCellValue().getString().trim().equals(codigoOpcionRelacion)){
							relacion = new RelacionBean();
							// Nos posicionamos en la fila
							HSSFRow rowTP = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell cellP = rowTP.getCell(1);
							HSSFCell cellT = rowTP.getCell(2);
							if (cellP != null && cellT !=null) {
//								relacion.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
//								relacion.getMaterialTipoEjercicioBean().setCodigo(codEjercicio);
								relacion.setPalabra(cellP.toString());
								relacion.setTexto(cellT.toString());
								relacion.setTipoRelacion(2);
								relacionService.insertar(relacion);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void registrarRelacionPalabraImagen(HSSFSheet sheet, String codigoTRelacion, String codigoOpcionRelacion, long codEjercicio){
		try {
			String ruta_imagen_externa = this.getRutaExterna("ruta.natigu.archivos.recursos.externos.imagen");
			RelacionBean relacion = null;
			for (Row row : sheet) {
				for (Cell cell : row) {
					if(cell.getColumnIndex() == 0){
						if(cell.getRichStringCellValue().getString().trim().equals(codigoOpcionRelacion)){
							relacion = new RelacionBean();
							// Nos posicionamos en la fila
							HSSFRow rowTP = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell cellP = rowTP.getCell(1);
							HSSFCell cellI = rowTP.getCell(2);
							if (cellP != null && cellI !=null) {
//								relacion.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
//								relacion.getMaterialTipoEjercicioBean().setCodigo(codEjercicio);
								relacion.setPalabra(cellP.toString());
								relacion.setImagen(codEjercicio+File.separator+cellI.toString());
								relacion.setTipoRelacion(1);
								relacionService.insertar(relacion);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registrarRelacionCrucigrama(HSSFSheet sheet, String codigoTRelacion, String codigoOpcionRelacion, long codEjercicio){
		try {
			String ruta_imagen_externa = this.getRutaExterna("ruta.natigu.archivos.recursos.externos.imagen");
			RelacionBean relacion = null;
			for (Row row : sheet) {
				for (Cell cell : row) {
					if(cell.getColumnIndex() == 0){
						if(cell.getRichStringCellValue().getString().trim().equals(codigoOpcionRelacion)){
							relacion = new RelacionBean();
							// Nos posicionamos en la fila
							HSSFRow rowTP = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell cellD = rowTP.getCell(1);
							HSSFCell cellP = rowTP.getCell(2);
							HSSFCell cellPos = rowTP.getCell(3);
							HSSFCell cellO = rowTP.getCell(4);
							if (cellP != null && cellD !=null) {
//								relacion.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
//								relacion.getMaterialTipoEjercicioBean().setCodigo(codEjercicio);
								relacion.setPalabra(cellP.toString());
								relacion.setTexto(cellD.toString());
								relacion.setTipoRelacion(3);
								relacion.setOrden(VO.toInteger(cellO.toString()));
								relacion.setOrientacion("H".equals(cellPos.toString()) || "h".equals(cellPos.toString()) ? 1:2);
								relacionService.insertar(relacion);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registrarPreguntasYRespuestas(HSSFSheet sheet, String codigoTPregunta, String correcto, String incorrecto, long codEjercicio, Integer tipoPregunta) {
		
		try {
			
			boolean encontroPregunta = false;
			PreguntaBean preguntaBean = null;
			
			for (Row row : sheet) {
				for (Cell cell : row) {
					if (cell.getColumnIndex() == 0) {
						// Buscamos la celda de codigoTPregunta				
									
						if (cell.getRichStringCellValue().getString().trim().equals(codigoTPregunta)) {
							
							preguntaBean = new PreguntaBean();
							
							// Nos posicionamos en la fila
							HSSFRow rowTP = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell cellNP = rowTP.getCell(1);
							// System.out.println(cellNP);
							if (cellNP != null) {
								// Este es el dato que insertaremos (PREGUNTA)
								System.out.println("Pregunta: "+ codigoTPregunta+"-" +cellNP.toString());
								
								preguntaBean.setMaterialEjercicioBean(new MaterialTipoEjercicioBean());
								preguntaBean.getMaterialEjercicioBean().setCodigo(codEjercicio);
								preguntaBean.setDescripcion(cellNP.toString());
								preguntaBean.setTipoPregunta(tipoPregunta);
								preguntaService.insertar(preguntaBean);
								
								encontroPregunta = true;
								break;
							} else {
								System.out.println("No se encontró pregunta o la celda está vacía.");
								encontroPregunta = false; // sigo buscando
							}
						}
						// Si encontré pregunta, buscamos respuestas
						else if (cell.getRichStringCellValue().getString().trim().equals(incorrecto)
								|| cell.getRichStringCellValue().getString().trim().equals(correcto)) {
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
									
									AlternativaBean respuestaBean = new AlternativaBean();
									respuestaBean.setPreguntaBean(new PreguntaBean());
									respuestaBean.getPreguntaBean().setCodigo(preguntaBean.getCodigo());
									respuestaBean.setDescripcion(cellRP.toString());
									respuestaBean.setRespuestaEstado(cellTR.toString().equals(correcto) ? "1" : "2");
									alternativaService.insertar(respuestaBean);
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
		} catch (Exception e) {
			
		}
		
	}
	
	private MaestraBean obtenerRegistroMaestro(List<MaestraBean> lista, Integer codigoRegistro){
		MaestraBean bean = new MaestraBean();
		
		for (MaestraBean objMaestro : lista) {
			if(objMaestro.getCodigoRegistro() == codigoRegistro){
				bean = objMaestro;
				break;
			}
		}
		return bean;
	}
	
	private HSSFWorkbook generarHSSFWorkbook(LenguaBean lengua, MaestraBean nivel, MaestraBean subNivel, MaestraBean unidad) {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Plantilla"); // Hoja de Trabajo 1
		
		//sheet.setColumnWidth(0, 5000);
		sheet.setColumnHidden(0, true); // Ocultar primera columna con las variables
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 6000);
        //sheet.setColumnWidth(4, 5000);
        //sheet.setColumnWidth(5, 6000);
		
        String concat_valores_selecc = lengua.getCodigo()+"_"+nivel.getCodigoRegistro()+"_"+subNivel.getCodigoRegistro()+"_"+unidad.getCodigoRegistro();
        
		int countRow = 0;

		// CABECERA
        Row rowTitulo = sheet.createRow(0); // CREANDO FILA 1
        Cell cellTitulo  = rowTitulo.createCell(0); // CREANDO COLUMNA 1
        cellTitulo.setCellValue("INFORMACIÓN");
        sheet.addMergedRegion(new CellRangeAddress(  // UNIENDO 4 COLUMNAS
	    		cellTitulo.getRowIndex(), 
	    		cellTitulo.getRowIndex(), 
	    		cellTitulo.getColumnIndex(), 
	    		cellTitulo.getColumnIndex()+3  
        ));
        setStyleLisCabecera(workbook, cellTitulo);
		
        Row rowValoresSelecc = sheet.createRow(1); // CREANDO FILA 2
        Cell cellValSelecc  = rowValoresSelecc.createCell(0); // CREANDO COLUMNA 1
        cellValSelecc.setCellValue("{LENGUA_SELEC}");
        cellValSelecc  = rowValoresSelecc.createCell(1); // CREANDO COLUMNA 2
        cellValSelecc.setCellValue(lengua.getCodigo());
        setStyleCellAlign(workbook, cellValSelecc, 0);
        cellValSelecc  = rowValoresSelecc.createCell(2); // CREANDO COLUMNA 3
        cellValSelecc.setCellValue("Lengua");
        cellValSelecc  = rowValoresSelecc.createCell(3); // CREANDO COLUMNA 4
        cellValSelecc.setCellValue(lengua.getNombre());
        setStyleFormat(workbook,cellValSelecc);
        
        rowValoresSelecc = sheet.createRow(2); // CREANDO FILA 3
        cellValSelecc  = rowValoresSelecc.createCell(0); // CREANDO COLUMNA 1
        cellValSelecc.setCellValue("{NIVEL_SELEC}");
        cellValSelecc  = rowValoresSelecc.createCell(1); // CREANDO COLUMNA 2
        cellValSelecc.setCellValue(nivel.getCodigoRegistro());
        setStyleCellAlign(workbook, cellValSelecc, 0);
        cellValSelecc  = rowValoresSelecc.createCell(2); // CREANDO COLUMNA 3
        cellValSelecc.setCellValue("Nivel");
        cellValSelecc  = rowValoresSelecc.createCell(3); // CREANDO COLUMNA 4
        cellValSelecc.setCellValue(nivel.getNombreCorto());
        setStyleFormat(workbook,cellValSelecc);
        
        rowValoresSelecc = sheet.createRow(3); // CREANDO FILA 4
        cellValSelecc  = rowValoresSelecc.createCell(0); // CREANDO COLUMNA 1
        cellValSelecc.setCellValue("{SUBNIVEL_SELEC}");
        cellValSelecc  = rowValoresSelecc.createCell(1); // CREANDO COLUMNA 2
        cellValSelecc.setCellValue(subNivel.getCodigoRegistro());
        setStyleCellAlign(workbook, cellValSelecc, 0);
        cellValSelecc  = rowValoresSelecc.createCell(2); // CREANDO COLUMNA 3
        cellValSelecc.setCellValue("Sub Nivel");
        cellValSelecc  = rowValoresSelecc.createCell(3); // CREANDO COLUMNA 4
        cellValSelecc.setCellValue(subNivel.getNombreCorto());
        setStyleFormat(workbook,cellValSelecc);
        
        rowValoresSelecc = sheet.createRow(4); // CREANDO FILA 5
        cellValSelecc  = rowValoresSelecc.createCell(0); // CREANDO COLUMNA 1
        cellValSelecc.setCellValue("{UNIDAD_SELEC}");
        cellValSelecc  = rowValoresSelecc.createCell(1); // CREANDO COLUMNA 2
        cellValSelecc.setCellValue(unidad.getCodigoRegistro());
        setStyleCellAlign(workbook, cellValSelecc, 0);
        cellValSelecc  = rowValoresSelecc.createCell(2); // CREANDO COLUMNA 3
        cellValSelecc.setCellValue("Unidad");
        cellValSelecc  = rowValoresSelecc.createCell(3); // CREANDO COLUMNA 4
        cellValSelecc.setCellValue(unidad.getNombreCorto());
        setStyleFormat(workbook,cellValSelecc);
        
        Row rowEspacio = null;
        Cell cellEspacio = null;
        
		rowEspacio = sheet.createRow(5); // CREANDO FILA 6
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
		
        Row rowLeccion = null;
        Cell cellLeccion = null;
        
        rowLeccion = sheet.createRow(6); // CREANDO FILA 7
        cellLeccion  = rowLeccion.createCell(0);
        cellLeccion.setCellValue("LECCION 1");
        sheet.addMergedRegion(new CellRangeAddress(  // UNIENDO 4 COLUMNAS
        		cellLeccion.getRowIndex(), 
        		cellLeccion.getRowIndex(), 
        		cellLeccion.getColumnIndex(), 
        		cellLeccion.getColumnIndex()+3  
        ));
        setStyleLisCabecera(workbook, cellLeccion);
        setStyleCellAlign(workbook, cellLeccion, 0);
        
        rowLeccion = sheet.createRow(7); // CREANDO FILA 8
		cellLeccion = rowLeccion.createCell(0);
    	cellLeccion.setCellValue("{NOM_LECCION_1}");
    	cellLeccion = rowLeccion.createCell(1);
    	cellLeccion.setCellValue("LECCION 1");
    	setStyleWrapped(workbook, cellLeccion);
    	
    	rowLeccion = sheet.createRow(8); // CREANDO FILA 9
		cellLeccion = rowLeccion.createCell(0);
    	cellLeccion.setCellValue("{DES_LECCION_1}");
    	cellLeccion = rowLeccion.createCell(1);
    	cellLeccion.setCellValue("Reemplazar aquí la descripción de la lección");
    	setStyleWrapped(workbook, cellLeccion);
        
        rowEspacio = sheet.createRow(9); // CREANDO FILA 10
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        Row rowEjercicio = null;
        Cell cellEjercicio = null;
        
        rowEjercicio = sheet.createRow(10); // CREANDO FILA 11
        cellEjercicio  = rowEjercicio.createCell(0);
        cellEjercicio.setCellValue("MATERIAL 1");
        sheet.addMergedRegion(new CellRangeAddress(  // UNIENDO 4 COLUMNAS
        		cellEjercicio.getRowIndex(), 
        		cellEjercicio.getRowIndex(), 
        		cellEjercicio.getColumnIndex(), 
        		cellEjercicio.getColumnIndex()+3  
        ));
        setStyleLisCabecera(workbook, cellEjercicio);
        setStyleCellAlign(workbook, cellEjercicio, 0);
        
        rowEjercicio = sheet.createRow(11); // CREANDO FILA 12
        cellEjercicio = rowEjercicio.createCell(0);
        cellEjercicio.setCellValue("{NOM_MATERIAL_1}");
        cellEjercicio = rowEjercicio.createCell(1);
        cellEjercicio.setCellValue("MATERIAL 1");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowEjercicio = sheet.createRow(12); // CREANDO FILA 13
    	cellEjercicio = rowEjercicio.createCell(0);
    	cellEjercicio.setCellValue("{DES_MATERIAL_1}");
    	cellEjercicio = rowEjercicio.createCell(1);
    	cellEjercicio.setCellValue("Reemplazar aquí la descripción del material");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowEjercicio = sheet.createRow(13); // CREANDO FILA 14
    	cellEjercicio = rowEjercicio.createCell(0);
    	cellEjercicio.setCellValue("{IMG_MATERIAL_1}");
    	cellEjercicio = rowEjercicio.createCell(1);
    	cellEjercicio.setCellValue(concat_valores_selecc+"_nombre-imagen");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowEjercicio = sheet.createRow(14); // CREANDO FILA 15
    	cellEjercicio = rowEjercicio.createCell(0);
    	cellEjercicio.setCellValue("{AUD_MATERIAL_1}");
    	cellEjercicio = rowEjercicio.createCell(1);
    	cellEjercicio.setCellValue(concat_valores_selecc+"_nombre-audio");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(15); // CREANDO FILA 16
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        Row rowActividad = null;
        Cell cellActividad = null;
    	
        rowActividad = sheet.createRow(16); // CREANDO FILA 17
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("EJERCICIO 1");
        setStyleLisCabecera(workbook, cellActividad);
        setStyleCellAlign(workbook, cellActividad, 0);
        
        rowActividad = sheet.createRow(17); // CREANDO FILA 18
        cellActividad = rowActividad.createCell(0);
        cellActividad.setCellValue("{NOM_EJERCICIO_1}");
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("PREGUNTAS Y RESPUESTAS");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowActividad = sheet.createRow(18); // CREANDO FILA 19
    	cellActividad = rowActividad.createCell(0);
    	cellActividad.setCellValue("{DES_EJERCICIO_1}");
    	cellActividad = rowActividad.createCell(1);
    	cellActividad.setCellValue("Reemplazar aquí la descripción del ejercicio");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(19); // CREANDO FILA 20
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        countRow = 19;
        
        countRow = countRow + 1;
        
        for (int i = 0; i < 5; i++) {
			
        	Row rowPregunta = sheet.createRow(countRow);
            Cell cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{TP_ALT_1}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("ESTO SERÁ UNA PREGUNTA CUALQUIERA. MARCAREMOS LA QUE CREAMOS QUE SEA CORRECTA. "+(i+1));
            
            rowPregunta = sheet.createRow(countRow+1);
            cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{*RP}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("RESPUESTA 1");
        	
            rowPregunta = sheet.createRow(countRow+2);
            cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{*RP}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("RESPUESTA 2");
            
            rowPregunta = sheet.createRow(countRow+3);
            cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{[RP]}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("RESPUESTA 3");
            
            rowEspacio = sheet.createRow(countRow+4);
            cellEspacio  = rowEspacio.createCell(0);
            cellEspacio.setCellValue("");
        	
            countRow = countRow + 5;
		}
        
        rowActividad = sheet.createRow(countRow); // CREANDO FILA countRow
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("EJERCICIO 2");
        setStyleLisCabecera(workbook, cellActividad);
        setStyleCellAlign(workbook, cellActividad, 0);
        
        rowActividad = sheet.createRow(countRow+1); // CREANDO FILA 
        cellActividad = rowActividad.createCell(0);
        cellActividad.setCellValue("{NOM_EJERCICIO_2}");
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("RELACION PALABRA - IMAGEN");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowActividad = sheet.createRow(countRow+2); // CREANDO FILA 
    	cellActividad = rowActividad.createCell(0);
    	cellActividad.setCellValue("{DES_EJERCICIO_2}");
    	cellActividad = rowActividad.createCell(1);
    	cellActividad.setCellValue("Reemplazar aquí la descripción del ejercicio");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(countRow+3); // CREANDO FILA 
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        Row rowRelacion = null;
        Cell cellRelacion = null;
        
        rowRelacion = sheet.createRow(countRow+4); // CREANDO FILA 
        cellRelacion = rowRelacion.createCell(0);
        cellRelacion.setCellValue("{TP_REL_I_1}");
        
        countRow = countRow + 5;
        
        for (int i = 0; i < 3; i++) {
        	rowRelacion = sheet.createRow(countRow); // CREANDO FILA 
            cellRelacion = rowRelacion.createCell(0);
            cellRelacion.setCellValue("{[PRI]}");
            cellRelacion = rowRelacion.createCell(1);
            cellRelacion.setCellValue("INGRESE PALABRA "+(i+1));
            cellRelacion = rowRelacion.createCell(2);
            cellRelacion.setCellValue("NOMBRE IMAGEN "+(i+1));
            countRow++;
		}
        
        countRow = countRow + 1;
        
        rowEspacio = sheet.createRow(countRow); // CREANDO FILA 
        cellEspacio = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        rowActividad = sheet.createRow(countRow+1); // CREANDO FILA countRow
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("EJERCICIO 3");
        setStyleLisCabecera(workbook, cellActividad);
        setStyleCellAlign(workbook, cellActividad, 0);
        
        rowActividad = sheet.createRow(countRow+2); // CREANDO FILA 
        cellActividad = rowActividad.createCell(0);
        cellActividad.setCellValue("{NOM_EJERCICIO_3}");
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("RELACION PALABRA - TEXTO");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowActividad = sheet.createRow(countRow+3); // CREANDO FILA 
    	cellActividad = rowActividad.createCell(0);
    	cellActividad.setCellValue("{DES_EJERCICIO_3}");
    	cellActividad = rowActividad.createCell(1);
    	cellActividad.setCellValue("Reemplazar aquí la descripción del ejercicio");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(countRow+4); // CREANDO FILA 
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        rowRelacion = sheet.createRow(countRow+5); // CREANDO FILA 
        cellRelacion = rowRelacion.createCell(0);
        cellRelacion.setCellValue("{TP_REL_T_1}");
        
        countRow = countRow + 6;
        
        for (int i = 0; i < 3; i++) {
        	rowRelacion = sheet.createRow(countRow); // CREANDO FILA 
            cellRelacion = rowRelacion.createCell(0);
            cellRelacion.setCellValue("{[PRT]}");
            cellRelacion = rowRelacion.createCell(1);
            cellRelacion.setCellValue("INGRESE PALABRA "+(i+1));
            cellRelacion = rowRelacion.createCell(2);
            cellRelacion.setCellValue("INGRESE TEXTO "+(i+1));
            countRow++;
		}
        
        /*****************CORREGIR TEXTO*************************/
        rowEspacio = sheet.createRow(countRow); // CREANDO FILA 
        cellEspacio = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        rowActividad = sheet.createRow(countRow+1); // CREANDO FILA countRow
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("ACTIVIDAD 4: CORREGIR TEXTO");
        setStyleLisCabecera(workbook, cellActividad);
        setStyleCellAlign(workbook, cellActividad, 0);
        
        rowActividad = sheet.createRow(countRow+2); // CREANDO FILA 
        cellActividad = rowActividad.createCell(0);
        cellActividad.setCellValue("{NOM_ACTIVIDAD_4}");
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("ACTIVIDAD 4");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowActividad = sheet.createRow(countRow+3); // CREANDO FILA 
    	cellActividad = rowActividad.createCell(0);
    	cellActividad.setCellValue("{DES_ACTIVIDAD_4}");
    	cellActividad = rowActividad.createCell(1);
    	cellActividad.setCellValue("Reemplazar aquí la descripción de la actividad");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(countRow+4); // CREANDO FILA 
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        

        Row rowTextoCorregir = sheet.createRow(countRow+5); // CREANDO FILA 
        rowTextoCorregir.setHeightInPoints(100);
        Cell cellTextoCorregir = rowTextoCorregir.createCell(0);
        cellTextoCorregir.setCellValue("{TP_CORR_TEXT_1}");
        cellTextoCorregir = rowTextoCorregir.createCell(1);
        cellTextoCorregir.setCellValue("Reemplazar aquí el texto a corregir, tal cual como aparecera al alumno");
   
        
        countRow = countRow + 6;
        
        for (int i = 0; i < 4; i++) {
			
        	Row rowPalabra = sheet.createRow(countRow);
            Cell cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{TP_PALCORR_1}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("("+(i+1)+")");
            
            rowPalabra = sheet.createRow(countRow+1);
            cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{*ACR}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("ALTERNATIVA 1");
        	
            rowPalabra = sheet.createRow(countRow+2);
            cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{*ACR}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("ALTERNATIVA 2");
            
            rowPalabra = sheet.createRow(countRow+3);
            cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{[ACR]}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("ALTERNATIVA 3");
            
            rowEspacio = sheet.createRow(countRow+4);
            cellEspacio  = rowEspacio.createCell(0);
            cellEspacio.setCellValue("");
        	
            countRow = countRow + 5;
		}
        /***********************FIN CORREGIR TEXTO***********************************/
        
        /*****************COMPLETAR TEXTO*************************/
        rowEspacio = sheet.createRow(countRow); // CREANDO FILA 
        cellEspacio = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        rowActividad = sheet.createRow(countRow+1); // CREANDO FILA countRow
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("ACTIVIDAD 5: COMPLETAR TEXTO");
        setStyleLisCabecera(workbook, cellActividad);
        setStyleCellAlign(workbook, cellActividad, 0);
        
        rowActividad = sheet.createRow(countRow+2); // CREANDO FILA 
        cellActividad = rowActividad.createCell(0);
        cellActividad.setCellValue("{NOM_ACTIVIDAD_5}");
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("ACTIVIDAD 5");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowActividad = sheet.createRow(countRow+3); // CREANDO FILA 
    	cellActividad = rowActividad.createCell(0);
    	cellActividad.setCellValue("{DES_ACTIVIDAD_5}");
    	cellActividad = rowActividad.createCell(1);
    	cellActividad.setCellValue("Reemplazar aquí la descripción de la actividad");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(countRow+4); // CREANDO FILA 
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        

        Row rowTextoCompletar = sheet.createRow(countRow+5); // CREANDO FILA 
        rowTextoCompletar.setHeightInPoints(100);
        Cell cellTextoCompletar = rowTextoCompletar.createCell(0);
        cellTextoCompletar.setCellValue("{TP_COMP_TEXT}");
        cellTextoCompletar = rowTextoCompletar.createCell(1);
        cellTextoCompletar.setCellValue("Reemplazar aquí el texto a completar, tal cual como aparecera al alumno");
        
        
        countRow = countRow + 6;
        
        for (int i = 0; i < 4; i++) {
			
        	Row rowPalabra = sheet.createRow(countRow);
            Cell cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{TP_PALCOM_1}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("("+(i+1)+")");
            
            rowPalabra = sheet.createRow(countRow+1);
            cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{*ACM}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("ALTERNATIVA 1");
        	
            rowPalabra = sheet.createRow(countRow+2);
            cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{*ACM}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("ALTERNATIVA 2");
            
            rowPalabra = sheet.createRow(countRow+3);
            cellPalabra = rowPalabra.createCell(0);
            cellPalabra.setCellValue("{[ACM]}");
            cellPalabra = rowPalabra.createCell(1);
            cellPalabra.setCellValue("ALTERNATIVA 3");
            
            rowEspacio = sheet.createRow(countRow+4);
            cellEspacio  = rowEspacio.createCell(0);
            cellEspacio.setCellValue("");
        	
            countRow = countRow + 5;
		}
        /**********************FIN COMPLETAR TEXTO************************************/
        
        /******************** INICIO DE CRUCIGRAMA ******************************/
        
        countRow = countRow + 1;
        
        rowEspacio = sheet.createRow(countRow); // CREANDO FILA 
        cellEspacio = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        rowActividad = sheet.createRow(countRow+1); // CREANDO FILA countRow
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("ACTIVIDAD 6: CRUCIGRAMA");
        setStyleLisCabecera(workbook, cellActividad);
        setStyleCellAlign(workbook, cellActividad, 0);
        
        rowActividad = sheet.createRow(countRow+2); // CREANDO FILA 
        cellActividad = rowActividad.createCell(0);
        cellActividad.setCellValue("{NOM_ACTIVIDAD_6}");
        cellActividad = rowActividad.createCell(1);
        cellActividad.setCellValue("ACTIVIDAD 6");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowActividad = sheet.createRow(countRow+3); // CREANDO FILA 
    	cellActividad = rowActividad.createCell(0);
    	cellActividad.setCellValue("{DES_ACTIVIDAD_6}");
    	cellActividad = rowActividad.createCell(1);
    	cellActividad.setCellValue("Reemplazar aquí la descripción de la actividad");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(countRow+4); // CREANDO FILA 
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        rowRelacion = sheet.createRow(countRow+5); // CREANDO FILA 
        cellRelacion = rowRelacion.createCell(0);
        cellRelacion.setCellValue("{TP_CRUC_1}");
        
        countRow = countRow + 6;
        
        for (int i = 0; i < 3; i++) {
        	rowRelacion = sheet.createRow(countRow); // CREANDO FILA 
            cellRelacion = rowRelacion.createCell(0);
            cellRelacion.setCellValue("{[CRG]}");
            cellRelacion = rowRelacion.createCell(1);
            cellRelacion.setCellValue("INGRESE DEFINICIÓN "+(i+1));
            cellRelacion = rowRelacion.createCell(2);
            cellRelacion.setCellValue("INGRESE PALABRA "+(i+1));
            cellRelacion = rowRelacion.createCell(3);
            cellRelacion.setCellValue("INGRESE POSICIÓN "+(i+1)+" (H: HORIZONTAL, V: VERTICAL)");
            cellRelacion = rowRelacion.createCell(4);
            cellRelacion.setCellValue("INGRESE NUMERO ORDEN "+(i+1));
            countRow++;
		}
        
        /*******************FIN DE CRUCIGRAMA******************************/
        
        countRow = countRow + 1;
        
        rowEjercicio = sheet.createRow(countRow); // CREANDO FILA
        cellEjercicio  = rowEjercicio.createCell(0);
        cellEjercicio.setCellValue("EJERCICIO 2");
        sheet.addMergedRegion(new CellRangeAddress(  // UNIENDO 4 COLUMNAS
        		cellEjercicio.getRowIndex(), 
        		cellEjercicio.getRowIndex(), 
        		cellEjercicio.getColumnIndex(), 
        		cellEjercicio.getColumnIndex()+3  
        ));
        setStyleLisCabecera(workbook, cellEjercicio);
        setStyleCellAlign(workbook, cellEjercicio, 0);
        
        rowEjercicio = sheet.createRow(countRow+1); // CREANDO FILA 
        cellEjercicio = rowEjercicio.createCell(0);
        cellEjercicio.setCellValue("{NOM_EJERCICIO_2}");
        cellEjercicio = rowEjercicio.createCell(1);
        cellEjercicio.setCellValue("EJERCICIO 2");
    	setStyleWrapped(workbook, cellEjercicio);
    	
    	rowEjercicio = sheet.createRow(countRow+2); // CREANDO FILA 
    	cellEjercicio = rowEjercicio.createCell(0);
    	cellEjercicio.setCellValue("{DES_EJERCICIO_2}");
    	cellEjercicio = rowEjercicio.createCell(1);
    	cellEjercicio.setCellValue("Reemplazar aquí la descripción del ejercicio");
    	setStyleWrapped(workbook, cellEjercicio);
        
    	rowEspacio = sheet.createRow(countRow+3); // CREANDO FILA 
        cellEspacio  = rowEspacio.createCell(0);
        cellEspacio.setCellValue("");
        
        countRow = countRow + 4;
        
        for (int i = 0; i < 6; i++) {
			
        	Row rowPregunta = sheet.createRow(countRow);
            Cell cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{TP_ALT_2}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("ESTO SERÁ UNA PREGUNTA CUALQUIERA. MARCAREMOS LA QUE CREAMOS QUE SEA CORRECTA. "+(i+1));
            
            rowPregunta = sheet.createRow(countRow+1);
            cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{*RP2}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("RESPUESTA 1");
        	
            rowPregunta = sheet.createRow(countRow+2);
            cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{*RP2}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("RESPUESTA 2");
            
            rowPregunta = sheet.createRow(countRow+3);
            cellPregunta = rowPregunta.createCell(0);
            cellPregunta.setCellValue("{[RP2]}");
            cellPregunta = rowPregunta.createCell(1);
            cellPregunta.setCellValue("RESPUESTA 3");
            
            rowEspacio = sheet.createRow(countRow+4);
            cellEspacio  = rowEspacio.createCell(0);
            cellEspacio.setCellValue("");
        	
            countRow = countRow + 5;
		}
    	
		return workbook; 
	}
	
	private static String findColumnValueFromFilaCelda(HSSFSheet sheet, String codigoTPregunta, int columna) {
		String datoCelda = null;
		boolean finRow = false;
		for (Row row : sheet) {
			if (finRow == false) {
				for (Cell cell : row) {
					if (cell.getColumnIndex() == 0) {
						if (cell.getRichStringCellValue().getString().trim().equals(codigoTPregunta)) {
							HSSFRow fila = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell celda = fila.getCell(columna);
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
			} else{
				break;
			}
		}
		return datoCelda;
	}
	
	private String getRootPath(){
		return ResourceUtil.getKey("ruta.natigu.archivos.material.cargamasiva");
	}
	
	private String getRutaExterna(String key){
		return ResourceUtil.getKey(key);
	}
	
	public CargaMaterialBean getCargaMaterialBean() {
		return cargaMaterialBean;
	}

	public void setCargaMaterialBean(CargaMaterialBean cargaMaterialBean) {
		this.cargaMaterialBean = cargaMaterialBean;
	}

}