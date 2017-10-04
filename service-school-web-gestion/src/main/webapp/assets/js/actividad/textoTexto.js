/**
 * Mantenimeinto  Texto-Texto
 */
function guardarTextoTexto(){
	
	var p_idEjercicio = $("#idEjercicio").val();
	var p_texto	= $("#textoTexto").val();
	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#idRelacionTextoTexto").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	var p_textoRelacion2 = $("#textoRelacionado2").val();

	var url = contextPath+"/cargaMaterialController/grabarTextoTexto";
	if(p_idMaterial != "0")
	{
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio     :p_idEjercicio,
  					   texto	       : p_texto,
  					   textoRelacionado:p_textoRelacionado,
  					   idTextoTexto:p_idTextoTexto,
  					   idRelacionCabecera:p_idRelacionCabecera,
  					   textoRelacion2:p_textoRelacion2},
  			url 	: url,
  			success : function(data)
  			{
  				if (data != "0") {
  	  				$("#idRelacionTextoTexto").val(data);  
					listarEjercicioTextoTexto();
  	  				msg_exito();
  	  				$("#btn_guardar_texto").attr("disabled",true);
  	  				$("#idRelacionCabecera").val("0");
		  	  		$("#idRelacionTextoTexto").val("0");
		  	  		$("#textoRelacionado").val("").attr("disabled",true);
		  	  		$("#textoTexto").val("").attr("disabled",true);
				}
  				else
  				{
				}
  			},
  			error : function()
  			{
  				console.log("ERROR: ");
  			}
  		});
	}
	else
	{  
			msg_advertencia("Debe seleccionar un Material.");

	}
}
function guardarTextoTextoTexto(){	
	var p_idEjercicio = $("#idEjercicio").val();
	var p_texto	= $("#textoTexto").val();
	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#idRelacionTextoTexto").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	var p_textoRelacion2 = $("#textoRelacionado2").val();
	
	var url = contextPath+"/cargaMaterialController/grabarTextoTexto";
	if(p_idMaterial != "0")
	{
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio     :p_idEjercicio,
  					   texto	       : p_texto,
  					   textoRelacionado:p_textoRelacionado,
  					   idTextoTexto:p_idTextoTexto,
  					   idRelacionCabecera:p_idRelacionCabecera,
  					   textoRelacion2:p_textoRelacion2},
  			url 	: url,
  			success : function(data)
  			{
  				if (data != "0") {
  	  				$("#idRelacionTextoTexto").val(data);  
  	  				listarEjercicioTextoTextoTexto();
  	  				msg_exito();
				}
  				else
  				{
				}
  			},
  			error : function()
  			{
  				console.log("ERROR: ");
  			}
  		});
	}
	else
	{
		msg_advertencia("Debe seleccionar un Material.");
	}
}
function listarEjercicioTextoTexto()
{	

	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarTextoTexto";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].texto+"</td><td>"+data[i].texto2+"</td> <td> <button type='button' onclick='editarTextoTexto(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'textoTexto'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("bodyListeTextoTexto").innerHTML=html;
			}else{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function editarTextoTexto(p_id){
	
	var url =contextPath+"/cargaMaterialController/objrelaciontexto?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#textoTexto").val(data.texto).attr("disabled",false);
        			$("#textoRelacionado").val(data.texto2).attr("disabled",false);
        			$("#idRelacionTextoTexto").val(data.codigo);
        			$("#textoRelacionado2").val(data.texto3);
        			$("#btn_guardar_texto").attr("disabled",false);
			}else{
				console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
	
	
}
var accion_tab = "";
var codigoEliminar="";
function confirmar_accion() {
	
	$('#md_confirmacion').modal('show');
}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}
$("#btnConfirmarGeneric").click(function() {
	
	if (accion_tab.indexOf("textoTexto") >= 0) {
		eliminarTextoTexto();
		accion_tab="";
	}
	if (accion_tab.indexOf("relacion") >= 0) {
		eliminarTextoTextoTexto();
		accion_tab="";
	}

});
function confirmar_eliminar(tabla, codigo){
	console.log("entro a coonfirmar eliminar");
	
	console.log("tabla " +tabla);
	accion_tab = tabla;
	codigoEliminar = codigo;
	$('#md_confirmacion').modal('show');

}
function eliminarTextoTexto() {
	console.log("codigoEliminar" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarTextoTexto?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			listarEjercicioTextoTexto();
			msg_exito();

		},
		error : function(msg) {
			console.log("errot:" + msg);
		}

	});
}
function eliminarTextoTextoTexto() {
	console.log("codigoEliminar" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarTextoTexto?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			listarEjercicioTextoTextoTexto();
			msg_exito();

		},
		error : function(msg) {
			console.log("errot:" + msg);
		}

	});
}
function listarEjercicioTextoTextoTexto()
{	

	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarTextoTexto";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].texto+"</td><td>"+data[i].texto2+"</td> <td>"+data[i].texto3+"</td> <td> <button type='button' onclick='editarTextoTexto(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'relacion'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("bodyListeTextoTextoTexto").innerHTML=html;
			}else{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function validarTextoTexto(){
	
	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#textoTexto").val();
	
	if (p_textoRelacionado != "" && p_idTextoTexto != "") {
		guardarTextoTexto();
	}else{
		msg_advertencia("Debe debe ingresar un texto.");
	}
	
}

function validarTextoTextoTexto(){

	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#textoTexto").val();
	var p_textoTexto = $("#textoRelacionado2").val();
	
	if (p_textoRelacionado != "" && p_idTextoTexto != "" && p_textoTexto != "") {
		guardarTextoTextoTexto();
	}else{
		msg_advertencia("Debe debe ingresar un texto.");
	}
	
}
function nuevoTexto(){
	$("#idRelacionCabecera").val("0");
	$("#idRelacionTextoTexto").val("0");
	$("#textoRelacionado").val("").attr("disabled",false);
	$("#textoTexto").val("").attr("disabled",false);
	$("#btn_guardar_texto").attr("disabled",false);

}

$(document).ready(function(){
	$("#base-tab42").click(function(){
		var liCodEjer = $("#idEjercicio").val();
		if((liCodEjer=="0" || liCodEjer=="" )){
			msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
			$("#base-tab41").click();
			return false;
		}
		
	});
});

function nuevoTextoTextoTexto(){
	$("#idRelacionCabecera").val("0");
	$("#idRelacionTextoTexto").val("0");
	$("#textoRelacionado").val("");
	$("#textoRelacionado2").val("");
	$("#textoTexto").val("");
}