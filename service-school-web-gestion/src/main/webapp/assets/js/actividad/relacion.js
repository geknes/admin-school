var contextPath 	= $('#contextPathUrl').val();
var accion_tab 		= "";
var codigoEliminar	= "";
var validarImagen  	= true;
var validarPalabra 	= true;

function editarDetalleRelacion()
{
	var p_codprelcab 	= $("#idRelacionCabecera").val();
	var exito			= "1";
	validarDetalle();
	if(validarPalabra)
	{
		$("#tblRelacion tbody tr").each(function (index)
		{
			var i = (index+1);
			var p_codrelaci		= $("#idRelacionDetalle"+i).val();
			var p_palabra		= $("#txtPalabra"+i).val();
			var inputFileImage 	= document.getElementById("file"+i);
			var file 			= inputFileImage.files[0];
			var nombImagen		= $("#idNombreImg"+i).val().trim();
					
			if(file != undefined)
			{
				var url 			= contextPath+"/cargaMaterialController/editarRelacionDetalleImagen";
				var data 			= new FormData();
				data.append('codrelaci',	p_codrelaci);
				data.append('codprelcab',	p_codprelcab);
				data.append('palabra',		p_palabra);
				data.append('file',			file);
				if (p_codprelcab != "0" && exito == "1") 
				{
					$.ajax({
							type : 	"POST",
							url	 :	url,
							contentType:false,
						   	data:data,
						   	processData:false,
						   	cache:false,
						   	success: function(data)
						  	{
						   		exito = "1";
						  	},
						  	error : function()
						  	{
						  	  	exito = "0";
						 	 	console.log("ERROR: "+ "No se pudo ingresar el registro");
						  	 }
						});
					}
				}
				else
				{
					var url 			= contextPath+"/cargaMaterialController/editarRelacionDetalleTexto";
					var data 			= new FormData();
					data.append('nombImagen',	nombImagen);
					data.append('codrelaci',	p_codrelaci);
					data.append('codprelcab',	p_codprelcab);
					data.append('palabra',		p_palabra);
					if (p_codprelcab != "0" && exito == "1") 
					{
						$.ajax({
								type : 	"POST",
								url	 :	url,
								contentType:false,
						   		data:data,
						   		processData:false,
						   		cache:false,
						   		success: function(data)
						  	  	{
						   			exito = "1";
						  	  	},
						  	  	error : function()
						  	  	{
						  	  		exito = "0";
						 	 		console.log("ERROR: "+ "No se pudo ingresar el registro");
						  	  	}
						});
					}
				}
		});
		if(exito == "0")
		{
			msg_error();
		}
		else
		{
			msg_exito();
		}
	}
	else
	{
		msg_advertencia("Debe llenar los campos de texto.");
	}
	
	
	activarBotonesRelacion();
	listarRelacionCabecera();
}

function eliminarRelacion(idRelacionCabecera)
{
	var p_idEjercicio 	= $("#idEjercicio").val();
	var url 			= contextPath+"/cargaMaterialController/eliminarRelacion";
	$.ajax({
         type : 'POST',
         data : {idRelacionCabecera:idRelacionCabecera},
         url  : url,
         success : function(data) 
         {
	         console.log("Se eliminó con éxito");
	       	 $('#md_confirmacion').modal('hide');
	       	 listarRelacionCabecera();
	       	 msg_exito();
         },
         error : function(request, status, error) 
         {
        	 msg_error();
        	 console.log("No se pudo eliminar el registro");
         }
      });
}

function editarRelacion(idRelacion,titulo)
{
	desactivarBotonesRelacion();
	limpiarActividad();
	$("#idRelacionCabecera").val(idRelacion);
	$("#relacionTitulo").val(titulo);
	listarDetalleImagen(idRelacion);
	activarBotonesRelacion();
	flagActividad(false);
	
}

function flagActividad(accion){
	$("#btn_guardar_actividad").prop("disabled", accion);
	$("#relacionTitulo").attr("disabled",accion);
	$("#txtPalabra1").attr("disabled",accion);
	$("#txtPalabra2").attr("disabled",accion);
	$("#txtPalabra3").attr("disabled",accion);
	$("#file1").attr("disabled",accion);
	$("#file2").attr("disabled",accion);
	$("#file3").attr("disabled",accion);
}
function desactivarBotonesRelacion()
{
	$("#btn_nuevo_actividad").prop("disabled", true);
	$("#btn_guardar_actividad").prop("disabled", true);
}

function activarBotonesRelacion()
{
	$("#btn_nuevo_actividad").removeAttr("disabled");
	$("#btn_guardar_actividad").removeAttr("disabled");
}

function listarDetalleImagen(idRelacion)
{
	var p_idRelCab 	= idRelacion
	var url 		= contextPath+"/cargaMaterialController/listarRelacionDetalleImagen";
	var html 		= "";
	$.ajax({
		type : 'POST',
		data :{idRelCab : p_idRelCab},
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS:", data);
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{	
					var imgid = "imgmas"+(i+1);
					var file = "file"+(i+1);
					var idDetalle = "idRelacionDetalle"+(i+1);
					var imagen 	  = "idNombreImg"+(i+1);
					var imgsrc = contextPath+"/material/"+data[i].imagen;
					$("#txtPalabra"+(i+1)).val(data[i].palabra);
					$('#'+imagen).val(data[i].imagen);
					$('#'+imgid).attr('src',imgsrc);
					$('#'+idDetalle).val(data[i].codigo);
				}
			}
			else
			{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
}

function listarRelacionCabecera()
{
	var p_idEjercicio 	= $("#idEjercicio").val();
	var url 			= contextPath+"/cargaMaterialController/listarRelacionCabecera";
	var html 			= "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio},
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			limpiarActividad();
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].titulo+"</td> <td> <button type='button' onclick='editarRelacion(\""+data[i].codigo+ "\",\""+data[i].titulo+"\",\""+data[i].imagen+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'relacionCabecera'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("idTablaRelacionListado").innerHTML=html;
			}
			else
			{
				console.log("SUCCESS: ", "La lista está vacía");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
}

function limpiarActividad()
{
	$("#idRelacionCabecera").val("0");
	$("#relacionTitulo").val("");
	$("#imgmas1").attr("src","../assets/img/usar_imagen.jpg");
	$("#imgmas2").attr("src","../assets/img/usar_imagen.jpg");
	$("#imgmas3").attr("src","../assets/img/usar_imagen.jpg");
	$("#file1").val("");
	$("#file2").val("");
	$("#file3").val("");
	$("#txtPalabra1").val("");
	$("#txtPalabra2").val("");
	$("#txtPalabra3").val("");
	$("#idRelacionDetalle1").val("0");
	$("#idRelacionDetalle2").val("0");
	$("#idRelacionDetalle3").val("0");
	$("#idNombreImg1").val("");
	$("#idNombreImg2").val("");
	$("#idNombreImg3").val("");
	accion_tab = "";
	codigoEliminar = "";
}

function nuevoRelacion()
{
	limpiarActividad();
	flagActividad(false);
}

function insertarRelacionCabecera()
{
	desactivarBotonesRelacion();
	var p_codejercicio 	= $("#idEjercicio").val();
	var p_codprelcab 	= $("#idRelacionCabecera").val();
 	var p_titulo		= $("#relacionTitulo").val();
 	var url 			= contextPath+"/cargaMaterialController/grabarRelacionCabecera";
	var data 			= new FormData();
	data.append('codprelcab',p_codprelcab);
	data.append('codejercicio',p_codejercicio);
	data.append('titulo',p_titulo);
	if (p_codejercicio != "0") 
	{
		validarDetalle();
//		alert("validarImagen && validarPalabra" + validarImagen + validarPalabra);
		if(p_codprelcab != "0")
		{
			if(validarPalabra)
			{
				$.ajax({
					type : 	"POST",
					url	 :	url,
					contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			  	  	{
			  			$("#idRelacionCabecera").val(data);
			 			if(p_codprelcab != data)
			  			{
//			  				alert("insertarDetalleRelacionImagen();");
			  				insertarDetalleRelacionImagen();
			  			}
			  			else
			  			{
			  				editarDetalleRelacion();
						}
				  			flagActividad(true);
				  	 },
				  	 error : function()
				  	 {
				  	  	msg_error("No se pudo ingresar el registro");
				 	 	console.log("ERROR: ");
				  	  }
				});
			}
			else
			{
				msg_advertencia("Debe cargar todas las imagenes y llenar todos los campos de texto.");
				activarBotonesRelacion();
			}
		}
		else
		{
			if(validarImagen && validarPalabra)
			{
				$.ajax({
					type : 	"POST",
					url	 :	url,
					contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
					success: function(data)
			  	  	{
				 		$("#idRelacionCabecera").val(data);
						if(p_codprelcab != data)
						{
//				  				alert("insertarDetalleRelacionImagen();");
				  			insertarDetalleRelacionImagen();
				  		}
				  		else
				  		{
				  			editarDetalleRelacion();
				  		}
				  		flagActividad(true);
				   	},
				   	error : function()
				   	{
			  	  		msg_error("No se pudo ingresar el registro");
			 	 		console.log("ERROR: ");
			  	  	}
				});
			}
			else
			{
				msg_advertencia("Debe cargar todas las imagenes y llenar todos los campos de texto.");
				activarBotonesRelacion();
			}
		}
	}
	else
	{
		msg_info("Debe seleccionar un ejercicio para agregar esta actividad.");
		activarBotonesRelacion();
	}
	
}

function validarDetalle()
{
	validarImagen  	= true;
	validarPalabra 	= true;
	$("#tblRelacion tbody tr").each(function (index)
	{
		var i = (index+1);
		var inputFileImage 	= document.getElementById("file"+i);
		var file 			= inputFileImage.files[0];
		var p_palabra		= $("#txtPalabra"+i).val().trim();
		if(validarImagen)
		{
			if(file == undefined)
			{
				validarImagen = false;
			}
		}
		if(validarPalabra)
		{
			if(p_palabra == "")
			{
				validarPalabra = false;
			}
		}
	});
//	alert("validarImagen && validarPalabra" + validarImagen + validarPalabra);
}

function insertarDetalleRelacionImagen()
{
	var p_codprelcab 	= $("#idRelacionCabecera").val();
	var url 			= contextPath+"/cargaMaterialController/grabarRelacionDetalleImagen";
	var exito			= "1";
	$("#tblRelacion tbody tr").each(function (index)
	{
		var i = (index+1);
		var p_palabra		= $("#txtPalabra"+i).val().trim();
		var inputFileImage 	= document.getElementById("file"+i);
		var file 			= inputFileImage.files[0];
		var data 			= new FormData();

		data.append('codprelcab',	p_codprelcab);
		data.append('palabra',		p_palabra);
		data.append('file',			file);
		if (p_codprelcab != "0" && exito == "1") 
		{
			$.ajax({
				type : 	"POST",
				url	 :	url,
				contentType:false,
		   		data:data,
		   		processData:false,
		   		cache:false,
		   		success: function(data)
		  	  	{
		   			if(data != "0")
		   			{
		   				exito = "1";
		   			}
		   			else
		   			{
		   				exito = "0";
		   			}
		   			
		  	  	},
		  	  	error : function()
		  	  	{
		  	  		exito = "0";
		 	 		console.log("ERROR: "+ "No se pudo ingresar el registro");
		  	  	}
			});
		}
		
	 });
	if(exito == "0")
	{
		msg_error();
	}
	else
	{
		msg_exito();
	}
	activarBotonesRelacion();
	listarRelacionCabecera();
}
