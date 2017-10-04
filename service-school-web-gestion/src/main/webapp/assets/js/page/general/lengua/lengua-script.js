/** IMPLEMENTACION * */


function confirmar_accion(codigo, tabla) {
	// alert("tabla " + tabla)
	$('#md_confirmacion').modal('show');
	$("#btnConfirmarGeneric").click(function() { 
		if(tabla == 'unidad'){
			eliminarUnidad(codigo); 	
		}else if(tabla == 'leccion'){
			eliminarLeccion(codigo); 	
		} 
	});

}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}


 

function consultaEliminarLenguaEstructura(idButton, codigoSede) {
	var accion_tab = idButton;
	codSede = codigoSede;
	$('#md_confirmacion').modal('show');
}

function cargarLenguaEstructura() {
	var contextPath = $('#contextPath').val();
	var codigo = $('#codigoLengua').val();

	$.ajax({
		url : contextPath + "/lenguaController/listaEstructura?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {
			$("#modalLenguaEstructura").modal('show');
			$("#modalLenguaEstructuraContent").html(data);
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function grabarLenguaEstructura() {

	var contextPath = $('#contextPath').val();
	var codigo = $('#codigoLengua').val();
	var subNiveles = [];
	var status = '';
	$(".get_value").each(function() {
		if ($(this).is(":checked")) {
			subNiveles.push($(this).val());
		}
	});

	dirURL = contextPath + "/lenguaController/grabarEstructura?codigo="
			+ codigo + "&subNiveles=" + subNiveles;
	$.ajax({

		url : dirURL,
		type : 'POST',
		success : function(data) {
			refrescarTablaDetalleEstructura();
			console.log("SUCCESS: ", data);
			status = data;
			if (data == "1") {
				msg_exito();
				$('#bootstrap2').modal('show');
				$('#modalLenguaEstructura').modal('hide');
			} else {
				msg_error();
			}
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function refrescarTablaDetalleEstructura() {
	var contextPath = $('#contextPath').val();
	var id = $('#codigoLengua').val();
	$.ajax({
		type : "GET",

		url : contextPath + "/lenguaController/recargarListadoxLengua",
		data : {
			codigo : id
		},

		success : function(data) {
			console.log("SUCCESS: ", data);
			$('#listadoDetalleLengua').html(data);
		},
		error : function() {
			console.log("ERROR: ");
		}
	});

}

function lenguaCargarModal() {
	var contextPath = $('#contextPath').val();
	var codigoLengua = $('#codigoLengua').val(); // document.getElementById("codigoLengua").value;

	path = contextPath + "/lenguaController/lenguaCargarModal?codigo="
			+ codigoLengua;
	// alert("path " + path)
	if (codigoLengua == 0) {
		alert("¡Debe registrar lengua.!");
	} else {
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#modalLenguaEstructura").modal('show');
				$("#modalLenguaEstructuraContent").html(data);

			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		});
	}
}

function grabarUnidad() {
	var actionForm = $('#frmInsertarUnidad').attr("action");
	var contextPath = $('#contextPath').val();
	var idLengua = $('#codigoLengua').val();
	var idSubNivel = $('#cmm_sub_nivel').val();
	var url = contextPath + "/lenguaController/" + actionForm;
	var unidad =  $('#unidad').val();
	var nombre = $('#nombreUnidad').val();
	if(idSubNivel == 0 || unidad == 0 || nombre  == "" ){
		msg_advertencia("Complete los campos requeridos(*).")
	}else{
	// alert("contextPath " + url)
	$.ajax({
		type : "POST",
		url : url,

		data : $('#frmInsertarUnidad').serialize(),
		success : function(data) {
			if (data == "0") {
				msg_advertencia("Registro ya existe.");
			}
			if (data == "1") {
				msg_exito();
				
				refrescarTablaListadoUnidad();
			}
			if (data == "2") {
				msg_advertencia("Complete los campos requeridos(*).")
			}
			if (data == "3") {
				msg_advertencia("La unidad ya fue registrada")
			}
			if (data == "4") {
				// msg_advertencia("Seleccione una lengua.");
			}
			if (data == "5") {
				// msg_advertencia("Existe lengua.");
			}
		},
		error : function(xhr, status, er) {
			msg_error();
			console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}
		},
		complete : function() {
			limpiarDatosUnidad();
			// listarDirectorInstitucion();
		}
	});
  }
}

function limpiarUnidad() {
	$('#cmm_nivel').val("0");
	$('#cmm_sub_nivel').empty();
	$('#cmm_sub_nivel').html("<option value='0'>Seleccione</option>"); 
	$('#unidad').val("");
	$('#descripcionUnidad').val("");
	$('#traduccion').val(""); 
	$('#nombreUnidad').val("");
	$('#codigoUnidadBean').val("0");
}

function modificarUnidad(codigo) {   
	
	var contextPath = $('#contextPath').val();  ;
	
	$
	.ajax({
		url : contextPath+"/lenguaController/modificarUnidad?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {  
			if (data != null || data.length>0) { 
				console.log("data " + data.lenguaEstructuraBean.codigo);
				$('#cmm_nivel').val(data.lenguaEstructuraBean.nivel.codigoRegistro);
				cargarSubNiveles(data.lenguaEstructuraBean.codigo);
				
				$('#unidad').val(data.unidad.codigoRegistro);
				$('#descripcionUnidad').val(data.descripcion);
				$('#traduccion').val("");
			//	$('#cmm_sub_nivel').val(data.lenguaEstructuraBean.codigo); 
				$('#nombreUnidad').val(data.nombre);
				$('#codigoUnidadBean').val(data.codigo);
			}	
		},
		error : function(request, status, error) {
			 
		}
	});
}


function eliminarUnidad(codigo) {
//	 alert("eliminarUnidad " + codigo);
	
	var contextPath = $('#contextPath').val();
	
	$
			.ajax({
				url : contextPath+"/lenguaController/eliminarUnidad?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) { 
					msg_exito();
					$('#md_confirmacion').modal('hide');
					refrescarTablaListadoUnidad();
				 
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
}

function refrescarTablaListadoLengua() {
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url : contextPath+"/lenguaController/listarLenguas?codigo=0",
				type : 'GET',

				success : function(data) {
					console.log("SUCCESS: ", data);
					$('#listadoDetalleLengua').html(data);
				},
				error : function() {
					console.log("ERROR: ");
				}
			});

}

function refrescarTablaListadoUnidad() {
	var contextPath = $('#contextPath').val();
	var idLengua = $('#codigoLengua').val();
	$
			.ajax({
				url : contextPath+"/lenguaController/listarUnidades?codigo="+idLengua,
				type : 'GET',

				success : function(data) {
					console.log("SUCCESS: ", data);
					$('#listadoUnidadesLengua').empty()
					$('#listadoUnidadesLengua').html(data);
				},
				error : function(xhr, status, er) {
					//msg_error();
					console.log("error: " + xhr + " status: " + status + " er:" + er);
				}
			});

}


function grabarLeccion() {
	var actionForm = $('#frmInsertarLeccion').attr("action");
	var contextPath = $('#contextPath').val();
	var url = contextPath + "/lenguaController/" + actionForm;
	// alert("contextPath:: " + url)
	$.ajax({
		type : "POST",
		url : url,

		data : $('#frmInsertarLeccion').serialize(),
		success : function(data) {
			if (data == "0") {
				msg_advertencia("Registro ya existe.");
			}
			if (data == "1") {
				msg_exito();
				$('#modalLenguaEstructuraUnidad').modal('hide');
				refrescarTablaListadoUnidad();
			}
			if (data == "2") {
				msg_advertencia("Complete los campos requeridos(*).")
			}
			if (data == "3") {
				msg_advertencia("La lecci&oacute;n ya fue registrada")
			}
			if (data == "4") {
				// msg_advertencia("Seleccione una lengua.");
			}
			if (data == "5") {
				// msg_advertencia("Existe lengua.");
			}
		},
		error : function(xhr, status, er) {
			msg_error();
			console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}
		},
		complete : function() {
			limpiarDatosUnidad();
			// listarDirectorInstitucion();
		}
	});

}
function modificarLeccion(codigo) {   
	//alert("modificarLeccion " +codigo )
	var contextPath = $('#contextPath').val();  ;
	
	$
	.ajax({
		url : contextPath+"/lenguaController/modificarLeccion?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {  
			if (data != null || data.length>0) { 
				console.log("data " + data.codigo);
				$('#situacionLeccion').val(data.situacion.codigoRegistro); 
				$('#nombreLeccion').val(data.nombre);
				$('#codigoLeccion').val(data.codigo);
				$('#codigoUnidad').val(data.unidadBean.codigo);
			}	
		},
		error : function(request, status, error) {
			 
		}
	});
}

function eliminarLeccion(codigo) {
//	 alert("eliminarUnidad " + codigo);
	
	var contextPath = $('#contextPath').val();
	
	$
			.ajax({
				url : contextPath+"/lenguaController/eliminarLeccion?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) { 
					msg_exito();
					$('#md_confirmacion').modal('hide');
					$('#modalLenguaEstructuraUnidad').modal('hide');
					refrescarTablaListadoUnidad();
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
}

function limpiarDatosUnidad() {
	$('#cmm_sub_nivel').val("0");
	$('#unidad').val("");
	$('#descripcionUnidad').val("");
	$('#traduccion').val("");
	$('#nombreUnidad').val("");
	$('#codigoUnidadBean').val("0");

}

function cargarNiveles() {
	var codigoLengua = $('#codigoLengua').val();
	$
			.ajax({
				type : "GET",
				data : "codigo=" + codigoLengua,
				url : "${pageContext.request.contextPath}/lenguaController/cargarNiveles",
				success : function(data) {
					if (data != null) {

						data.sort(function(a, b) {
							return (a.codigoRegistro - b.codigoRegistro);
						});

						html += "<option value='0'>Todos</option>";
						for (var i = 0; i < data.length; i++) {
							html += "<option value='" + data[i].codigoRegistro
									+ "'>" + data[i].nombreCorto + "</option>";
						}
					} else {
						html += "<option value='0'>Todos</option>";
					}

				},
				error : function(xhr, status, er) {
					console.log("error: " + xhr + " status: " + status + " er:"
							+ er);
					if (xhr.status == 500) {
						console.log(er);
						// Error_500(er);
					}
					if (xhr.status == 901) {
						console.log(er);
						// spire_session_901(er);
					}
				},
				complete : function() {
					$('#cmm_nivel').empty();
					$('#cmm_nivel').html(html);
				}
			});

}

function cargarSubNiveles(codLengEstructura) {
	var idLengua = $('#codigoLengua').val();
	var idNivel = $('#cmm_nivel').val();
	var contextPath = $('#contextPath').val();
	var html = "";

	// alert(idLengua + ": " + idNivel+ ": " + contextPath)
	$.ajax({
		type : "GET",
		data : "codigo=" + idLengua + "&codnivel=" + idNivel,

		url : contextPath + "/lenguaController/cargarSubNiveles",

		success : function(data) {
			if (data != null) {

				data.sort(function(a, b) {
					return (a.codigoRegistro - b.codigoRegistro);
				});

				html += "<option value='0'>Seleccione</option>";
				for (var i = 0; i < data.length; i++) {
					if(data[i].codigo == codLengEstructura ){
						html += "<option value='" + data[i].codigo + "' selected='true'>"
						+ data[i].subNivel.nombreCorto + "</option>";
					}else{
					html += "<option value='" + data[i].codigo + "'>"
							+ data[i].subNivel.nombreCorto + "</option>";
					}
				}
			} else {
				html += "<option value='0'>Todos</option>";
			}

		},
		error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}
		},
		complete : function() {
			$('#cmm_sub_nivel').empty();
			$('#cmm_sub_nivel').html(html);
		}
	});
}

function lenguaCargarModalUnidadLeccion(codigo) {
	var contextPath = $('#contextPath').val();
	$('#codigoUnidad').val(codigo);
	if (codigoLengua == 0) {
		alert("¡Debe registrar lengua.!");
	} else {
		$.ajax({
			type : "POST",

			url : contextPath
					+ "/lenguaController/lenguaCargarModalUnidadLeccion",
			data : {
				codigo : codigo
			},

			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#modalLenguaEstructuraUnidad").modal('show');
				$("#modalLenguaEstructuraUnidadContent").html(data);

			},
			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
				console.log("ERROR: ");
			}
		});
	}
}

function cargarUnidades() {
	var idLengua = $('#cmm_lengua').val();
	var idNivel = $('#cmm_nivel').val();
	var idSubNivel = $('#cmm_sub_nivel').val();
	// var contextPath = $('#contextPathUrl').val();
	// var html = "";

	if (idSubNivel != '0') {
		$('#cmm_unidades').val('0');
		$('#idDivContSelecUnidad').css('display', 'block');
	} else {
		$('#idDivContSelecUnidad').css('display', 'none');
		$('#cmm_unidades').val('0');
	}
}