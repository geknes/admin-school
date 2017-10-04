var contextPath = $('#contextPathUrl').val();

function nuevoMaterialTipoEjercicio()
{
	$("#ejercicioTxtTitulo").removeAttr("disabled");
	$("#btn_guardar_ejercicio").removeAttr("disabled");
	limpiarMaterialTipoEjercicio();
}

function grabarMaterialTipoEjercicio()
{	
	var p_idMaterial		= $("#modalCboMaterial").val();
	var p_idTipoEjercicio 	= $("#modalIdTipoEjercicio").val();
	var p_tituloEjercicio 	= $("#ejercicioTxtTitulo").val().trim();
	var p_idEjercicio 		= $("#idEjercicio").val();

	var url = contextPath+"/cargaMaterialController/grabarMaterialEjercicio";
	if(p_idMaterial != "0")
	{
		if(p_tituloEjercicio != "")
		{
			$("#btn_guardar_ejercicio").prop('disabled', true);
			$("#btn_nuevo_ejercicio").prop('disabled', true);
			$("#ejercicioTxtTitulo").prop('disabled', true);
			$.ajax({
	  			type 	: "POST",
	  			data 	: {idTipoEjercicio:p_idTipoEjercicio,tituloEjercicio:p_tituloEjercicio,idMaterial:p_idMaterial,idEjercicio:p_idEjercicio},
	  			url 	: url,
	  			success : function(data)
	  			{
	  				if (data != "0") {
	  	  				$("#idEjercicio").val(data);
	  	  				listarMaterialTipoEjercicio();
	  	  				$("#btn_nuevo_ejercicio").removeAttr("disabled");
	  	  				msg_exito();
	  	  				//$("#ejercicioTxtTitulo").val("");
					}
	  				else
	  				{
					}
	  			},
	  			error : function()
	  			{
	  				$("#btn_nuevo_ejercicio").removeAttr("disabled");
	  				$("#ejercicioTxtTitulo").removeAttr("disabled");
	  				$("#btn_guardar_ejercicio").removeAttr("disabled");
	  				console.log("ERROR: ");
	  			}
	  		});
		}
		else
		{
			$("#ejercicioTxtTitulo").focus();
			msg_advertencia("Debe ingresar un titulo.");
		}
	}
	else
	{
		msg_advertencia("Debe seleccionar un Material.");
	}
}

function listarMaterialTipoEjercicio()
{
	
	var p_idTipoEjercicio 	= $("#modalIdTipoEjercicio").val();
	var p_idMaterial 		= $("#modalCboMaterial").val();
	var url = contextPath+"/cargaMaterialController/listarMaterialTipoEjercicio";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idTipoEjercicio : p_idTipoEjercicio ,idMaterial : p_idMaterial},
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].titulo+"</td> <td> " +
							"<button type='button' onclick='editarMaterialTipoEjercicio(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> " +
							"<button type='button' onclick='confirmar_eliminar(\""+'materialTipoEjercicio'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> " +
							"<button type='button' onclick='seleccionarTab(\""+data[i].codigo+ "\",\""+data[i].titulo+ "\")' data-showp='0' data-id='1' class='btn btn-outline-success btn-sm btn-show' data-toggle='tooltip' data-original-title='Mostrar'><i class='ft-eye'></i></button></td></tr>";
				}
				document.getElementById("idBodyListadoMaterialTipoEjercicio").innerHTML=html;
			}else{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	evitarEspacios();
	validarActividadEjercicio();
}

function evitarEspacios(){
	//$(window).load(function(){
		$("input,textarea").on("keypress", function(e) {
    	    if (e.which === 32 && !this.value.length)
    	        e.preventDefault();
    	});
	//});
}

function seleccionarTab(idEjercicio,titulo) 
{
	$("#idEjercicio").val(idEjercicio);
	$("#ejercicioTxtTitulo").val(titulo);
	document.getElementById('base-tab42').click();
	$("#btn_guardar_ejercicio").prop('disabled', true);
	$("#ejercicioTxtTitulo").prop('disabled', true);
}

function editarMaterialTipoEjercicio(p_id){
	
	$("#btn_guardar_ejercicio").removeAttr("disabled");
	$("#ejercicioTxtTitulo").removeAttr("disabled");
	var url =contextPath+"/cargaMaterialController/objlistarMaterialEjercicio?codEjercicio="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        			$("#ejercicioTxtTitulo").val(data.titulo);
        			$("#idEjercicio").val(data.codigo);
			}else{
				console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
	
	
}

function grabarOrdenarParrafoCabecera(){
	var p_idEjercicio = $("#idEjercicio").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_tituloCabecera = $("#tituloActividad").val().trim();
	var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
	var url = contextPath+"/cargaMaterialController/grabarOrdenParrafoCabecera";
	if(p_idMaterial != "0"){
		console.log("titulo:" + p_tituloCabecera);
		if(p_tituloCabecera!=""){
			$.ajax({
	  			type 	: "POST",
	  			data 	: {idEjercicio:p_idEjercicio,
	  						tituloCabecera : p_tituloCabecera,
	  						idOrdenParrafoCabecera:p_idOrdenParrafoCabecera},
	  			url 	: url,
	  			success : function(data)
	  			{
	  				if (data != "0") {
	  	  				$("#idOrdenParrafoCabecera").val(data);  	  				
	  	  				listarParrafoCabecera();
	  	  				document.getElementById("btnTituloParrafoCabecera").disabled = true;
	  	  				document.getElementById("btnGuardarParrafo").disabled = false;
	  	  				document.getElementById("btn_nuevo_parrafo").disabled = false;
	  	  				msg_exito();
	  	  				$("#tituloActividad").val("").attr("disabled",true);
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
		}else{
		      msg_info("Debe completar el título de la actividad");
		    }
	}
	else
	{
		msg_advertencia("Debe seleccionar un Material.");
	}
}

function cargarComboMaterial()
{
	var html = "";
	var idLeccion = $("#modalCboLeccion").val();
	$("#modalIdLeccion").val(idLeccion);
//	alert("cargarCombo" + idLeccion);
	var url = contextPath+"/cargaMaterialController/cargarComboMaterial"
  		$.ajax({
  			type 	: "POST",
  			data 	: {codigoLeccion:idLeccion},
  			url 	: url,
  			success : function(data)
  			{
  				if(data!=null)
  				{
	   	    		data.sort(function (a, b)
	   	    		{
	   	    		    return (a.codigo - b.codigo);
	   	    		});
	   	    		html+="<option value='0'>Todos</option>";
	   	    		for(var i=0; i<data.length;i++){
	   	    			html+="<option value='"+data[i].codigo+"'>"+data[i].descripcionMaterial+"</option>";
					}
	   	    	}
  				else
  				{
	   	    		html+="<option value='0'>Todos</option>";
	   	    	}
  			},
  			error : function()
  			{
  				console.log("ERROR: ");
  			},
  			complete: function()
  			{
				$('#modalCboMaterial').html(html);
			}
  		});
}

function listarParrafoCabecera()
{	
	document.getElementById("btnGuardarParrafo").disabled = true;
	document.getElementById("btn_nuevo_parrafo").disabled = true;
	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarParrafoCabecera";
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
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].titulo+"</td> <td> <button type='button' onclick='editarOrdenarParrafoCabecera(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'cabecera'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("idListadoParrafoCabecera").innerHTML=html;
			}else{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function editarOrdenarParrafoCabecera(p_id){
	document.getElementById("btnTituloParrafoCabecera").disabled = false;
	document.getElementById("btnGuardarParrafo").disabled = false;
	document.getElementById("btn_nuevo_parrafo").disabled = false;
	listarParrafo();
	var url =contextPath+"/cargaMaterialController/objlistarOrdenarParrafoCabecera?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        			$("#tituloActividad").val(data.titulo).attr("disabled",false);
        			$("#idOrdenParrafoCabecera").val(data.codigo);
        			$("#btnTituloParrafoCabecera").attr("disabled",false);
        			$("#parrafo").val("").attr("disabled",false);
        			$("#numeroOrdenParrafo").val("").attr("disabled",false);
			}else{
				console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
	
	
}
/*
function eliminarmatej(codigo){
    //  alert("eliminarLengua " + codigo);
        $.ajax({
          url : "/procalidad-natigu-web-gestion/cargaMaterialController/eliminarMaterialTipoEjercicio?p_codmatpej="+codigo,
          type : 'GET',
          success : function(data) {
        	  $('#md_confirmacion').modal('hide');
        	  listarMaterialTipoEjercicio();
        	  msg_exito();
          },
          error : function(request, status, error) {
            alert(error);
          }
         });
  		};
*/
/*
function eliminarMaterialTipoEjercicio(id) {
	$("#idEjercicio").val(id);
	var p_idEjercicio = $("#idEjercicio").val();
	alert(p_idEjercicio);

	var url = contextPath+"/cargaMaterialController/eliminarMaterialEjercicio"
	if(p_idMaterial != "0")
	{
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio:p_idEjercicio},
  			url 	: url,
  			success : function(data)
  			{
  				if (data != 0) {
  	  				$("#idEjercicio").val(data);
  	  				listarMaterialTipoEjercicio();
  	  				msg_exito();
				}
  				else
  				{
  	  				listarMaterialTipoEjercicio();
  	  				msg_exito();
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
		alert("Debe seleccionar un Material.");
	}
	
}*/

function guardarParrafo(){
	
	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
	var p_numeroOrden = $("#numeroOrdenParrafo").val();
	var p_parrafo = $("#parrafo").val();
	var p_idParrafo = $("#idOrdenarParrafo").val();
	var url = contextPath+"/cargaMaterialController/grabarParrafo";
	console.log("paf:" + p_parrafo + "/"+ p_idParrafo);
	if(p_parrafo!="" && (p_idParrafo!="" || p_idParrafo=="0") ){
		$.ajax({
  			type 	: "POST",
  			data 	: {
  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
  					   numeroOrden:p_numeroOrden,
  					   parrafo:p_parrafo,
  					   idParrafo:p_idParrafo},
  			url 	: url,

  			success : function(data)
  			{
  				if (data != "0") {
  	  			$("#idOrdenarParrafo").val(data);
  	  			listarParrafo();
  	  			document.getElementById("btnGuardarParrafo").disabled = true;
  	  			msg_exito();
  	  			$("#parrafo").val("").attr("disabled",true);
  	  			$("#numeroOrdenParrafo").val("").attr("disabled",true);
				}else{
					
				}

  			},
  			error : function()
  			{
  				console.log("ERROR: ");
  			}
  		});
	} else{
		 msg_info("Debe completar los campos del parrafo.");
	}	
	
}

function editarParrafo(p_id){
	
	document.getElementById("btnGuardarParrafo").disabled = false;
	var url =contextPath+"/cargaMaterialController/objlistarParrafo?codParrafo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        			$("#numeroOrdenParrafo").val(data.numeroOrden);
        			$("#parrafo").val(data.parrafo).attr("disabled",false);
        			$("#idOrdenarParrafo").val(data.codigo).attr("disabled",false);
        			$("#btnGuardarParrafo").attr("disabled",false);
			}else{
				console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
	
	
}


function listarParrafo()
{
	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();	
	var url = contextPath+"/cargaMaterialController/listarParrafo";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idOrdenarParrafoCabecera : p_idOrdenarParrafoCabecera},
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].parrafo+"</td> <td> <button type='button' onclick='editarParrafo(\""+data[i].codigo+ "\",\""+data[i].parrafo+"\",\""+data[i].numeroOrden+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'parrafo'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("idBodyListadoParrafo").innerHTML=html;
			}else{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}





function limpiarMaterialTipoEjercicio()

{
	$("#ejercicioTxtTitulo").val("");
	$("#idEjercicio").val("0");
}
/*
var codigomatej ="";
    function confirmar_accionmatej(codigo) {
		codigomatej = codigo;
		$('#md_confirmacion').modal('show');

	}

    $("#btnConfirmarGeneric").click(function() {
		eliminarmatej(codigomatej);

	});*/

    function eliminarmatej(codigo){
        //  alert("eliminarLengua " + codigo);
	        $.ajax({
	          url : "/procalidad-natigu-web-gestion/cargaMaterialController/eliminarMaterialTipoEjercicio?p_codmatpej="+codigo,
	          type : 'GET',
	          success : function(data) 
	          {
	        	  $('#md_confirmacion').modal('hide');
	        	  listarMaterialTipoEjercicio();
	        	  msg_exito();
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
//		alert("accion_tab : "+accion_tab);
//		alert("relacionCabecera : "+ accion_tab.indexOf("relacionCabecera"));
//		alert("parrafo : "+ accion_tab.indexOf("parrafo"));
//		alert("materialTipoEjercicio : "+ accion_tab.indexOf("materialTipoEjercicio"));
//		alert("cabecera : "+ accion_tab.indexOf("cabecera"));
		if(accion_tab.indexOf("relacionCabecera") >= 0)
		{
			eliminarRelacion(codigoEliminar);
			accion_tab = "";
			codigoEliminar = "";
		}
		if (accion_tab.indexOf("parrafo") >= 0) {
			eliminarParrafo();
			accion_tab="";
		}
		if(accion_tab.indexOf("materialTipoEjercicio") >= 0){
			eliminarmatej(codigoEliminar);
		}
		if(accion_tab.indexOf("cabecera") >= 0){
			eliminarParrafoCabecera(codigoEliminar);
			accion_tab="";
		}
	});
	function confirmar_eliminar(tabla, codigo){
//		console.log("entro a coonfirmar eliminar");
		
		console.log("tabla " +tabla);
		accion_tab = tabla;
		codigoEliminar = codigo;
		$('#md_confirmacion').modal('show');
//		alert(accion_tab);
	}
	


	
	function eliminarParrafo() {
		console.log("codigoEliminar" + codigoEliminar);
		var url = contextPath+"/cargaMaterialController/eliminarParrafo?codigo="+codigoEliminar
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				console.log("Se eliminó con éxito");
				$('#md_confirmacion').modal('hide');
				codigoEliminar = "";
				listarParrafo();
				msg_exito();

			},
			error : function(msg) {
				console.log("errot:" + msg);
			}

		});
	}
	function eliminarParrafoCabecera(id) {
		console.log("codigoEliminar" + codigoEliminar);
		var url = contextPath+"/cargaMaterialController/eliminarParrafoCabecera?codigo="+id
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				console.log("Se eliminó con éxito");
				$('#md_confirmacion').modal('hide');
				codigoEliminar = "";
				listarParrafoCabecera();
				msg_exito();

			},
			error : function(msg) {
				console.log("errot:" + msg);
			}

		});
	}
	
	function nuevo(){
		
		document.getElementById("btn_guardar_ejercicio").disabled = false;
		 $("#ejercicioTxtTitulo").val("").attr("disabled",false);
		 $("#idEjercicio").val("0");
	}
	function nuevo_TituloCabecera(){
		document.getElementById("btnTituloParrafoCabecera").disabled = false;
		$("#tituloActividad").val("").attr("disabled",false);
		$("#idOrdenParrafoCabecera").val("0");
		$("#btnTituloParrafoCabecera").attr("disabled",false);
	}
	function nuevo_parrafo(){
		document.getElementById("btnGuardarParrafo").disabled = false;
		$("#numeroOrdenParrafo").val("").attr("disabled",false);
		$("#parrafo").val("").attr("disabled",false);
		$("#idOrdenarParrafo").val("0");
		$("#btnGuardarParrafo").attr("disabled",false);
	}
	
	function validarActividadEjercicio(){
		$("#base-tab42,#base-tab43").click(function(){
			var liCodEjer = $("#idEjercicio").val();
			if((liCodEjer=="0" || liCodEjer=="" )){
				msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
				$("#base-tab41").click();
				return false;
			}
			
		});
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

      		