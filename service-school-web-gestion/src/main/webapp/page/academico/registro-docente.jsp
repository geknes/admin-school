<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro Docente</title>
     <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <!-- END VENDOR CSS-->
    <jsp:include page="../../layout/confirmacion-modal-view.jsp" />
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <script src="${pageContext.request.contextPath}/assets/js/page/busqueda-ubigeo.js" type="text/javascript"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>

	<style type="text/css">
	.ocul {
		display: none;
	}

	.mostrar {
		display: inherit !important;
	}
	</style>

	<script type="text/javascript">
	$( document ).ready(function() {
		ejecutarGuardar = false;
		
		var msj = $("#mensaje").val();//1
		if(msj=='1'){
			msg_exito();
		}else if(msj=='0'){
			msg_error();
		}

		var prmCodigoDocente = "";
		var prmCodigoEspecialidad = "";

		var idDocente = document.getElementById("codigoDocente").value;

		if (idDocente != '0') {
			 document.getElementById("tag2").className ="nav-item mostrar";
			 //$('#limpiar').attr("disabled", true);
		}
		
		var codigo = document.getElementById("codigoDocente").value;
		if (codigo != '0') {
			 $('#limpiar').attr("disabled", true);
		}
		
		$(".optionReset").val("");
		
	});





		/*
		//Ingresamos un mensaje a mostrar
		var mensaje = confirm("¿Seguro que deseas eliminar amiguito?");
		//Detectamos si el usuario acepto el mensaje


		if (mensaje) {
		alert("¡:v bueno ya esta!");
		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/docenteController/eliminarEspecialidad?codigo="+codigoDocente+"&codigoEspecialidad="+codigoEspecialidad,
				success : function(data) {
					if(data=='1'){
						msg_exito();
						refrescarListaEspecialidad(codigoDocente);
					}else if(data=='0'){
						msg_error();
					}
				},
				error : function() {
					console.log("ERROR: ");
				}
			});
		}
		//Detectamos si el usuario denegó el mensaje
		else {
		alert("¡Haz denegado el mensaje amiguito!");
		}
	}

	function refrescarListaEspecialidad(codigoDocente){

		var htmlTabla = "";

		  $.ajax({
		    type: "GET",
		    url : "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente,
			success: function(response){
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
			    		htmlTabla +=
			    			"<tr>"+
	    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
	    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
				    		"<td>"+
								"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick='eliminarConfirmacion("+objInstLengua.docenteBean.codigo+","+objInstLengua.lenguaBean.codigo+");' ><i class='icon-trash'></i></button>"
				    		"</td>"+
			    		"</tr>";
					}
			    	$('#idlistadoEspecialidad').empty();
		  	    	$('#idlistadoEspecialidad').html(htmlTabla);
		    	}
		    },error: function(xhr,status,er) {
	         console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	console.log(er);
			    	//spire_session_901(er);
				    }
		    }
		  });
	}
	*/

	function validarRequired(idfrom){
		//Obtener el codigo docente
		var idDocente = document.getElementById("codigoDocente").value;

		var $myForm = $(idfrom);
		// validar todos los required
		if(! $myForm[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos correctamente");
		}else{
			//la ruta
			var actionForm = $(idfrom).attr("action");

			var inputFileImage = document.getElementById("file");
        	var file = inputFileImage.files[0];

        	//alert($(idfrom).serialize());
        	var data = new FormData();
        	//data.append('docenteBean',$(idfrom).serialize());
        	var codlengua = document.getElementById("codigoLengua").value;
        	var codnivel = document.getElementById("codigoNivel").value;
        	var codnumdoc = document.getElementById("numeroDocumento").value;

			alert(codnumdoc);
        	
        	data.append('codlengua',codlengua);
        	data.append('codnivel',codnivel);
        	data.append('codnumdoc',codnumdoc);	
        	data.append('file',file);
			
			//var url = "${pageContext.request.contextPath}" + actionForm;
			$.ajax({
		           type: "POST",
		           url:  "${pageContext.request.contextPath}/docenteController/grabarEspecialidad",
		           contentType:false,
			   		data: data,
			   		processData:false,
			   		cache:false,
		           success: function(data)
		           {
		        	   if(data=="1"){
		        		   msg_exito();
		        		   refrescarListaEspecialidad(idDocente);
		        		   //volver select a cero
			       	    	$('#codigoLengua').val('');
			    	    	$('#codigoNivel').val('');
			    	    	$('#numeroDocumento').val('');
			    	    	$('#file').val('');


							$("#codigoLengua").css("border", "2px solid rgba(22, 211, 154, 1)");
							$("#codigoNivel").css("border", "2px solid rgba(22, 211, 154, 1)");
							$("#numeroDocumento").css("border", "2px solid rgba(22, 211, 154, 1)");
							$("#file").css("border", "2px solid rgba(22, 211, 154, 1)");

		        	   }else{
		        		   //msg_error();
		        		   msg_info("Ya existe esa lengua con ese nivel");
		        	   }
		           },
					 error: function(xhr,status,er) {
					 msg_error();
				     console.log("error: " + xhr + " status: " + status + " er:" + er);
					    if(xhr.status==500) {
					    	console.log(er);
					 //   	Error_500(er);
					    }
					    if(xhr.status==901) {
				    	console.log(er);
				    //	spire_session_901(er);
		    			}
				    }
		         });
		}
	}

	function validarRequiredDocente(idfrom){
		var $myForm = $(idfrom);

		var departamento = document.getElementById("provinciaSelect");
		var provincia = document.getElementById("comboprovincia");
		var distrito = document.getElementById("combodistrito");
	
		// validar todos los required
		if(! $myForm[0].checkValidity() || departamento.value == "00" ||
				 provincia.value == "00" || distrito.value == "00") {

			/*todo de color verde  ok */

			$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#provinciaSelect").css("color", "#16D39A");
			$("#comboprovincia").css("color", "#16D39A");
			$("#combodistrito").css("color", "#16D39A");
			// mensaje
			 msg_advertencia("Debe completar los campos requeridos correctamente");
			 if(departamento.value == "00" ){
					$("#provinciaSelect").css("border", "2px solid rgba(210, 60, 60, .5)");
					$("#provinciaSelect").css("color", "#444");
					departamento.focus();
				}
			 if(provincia.value == "00"){
					$("#comboprovincia").css("border", "2px solid rgba(210, 60, 60, .5)");
					$("#comboprovincia").css("color", "#444");
					provincia.focus();
				}
			 if(distrito.value == "00"){
					$("#combodistrito").css("border", "2px solid rgba(210, 60, 60, .5)");
					$("#combodistrito").css("color", "#444");
					distrito.focus();
				}
		}
		else{
			ejecutarGuardar = true;		
			///guardarDatos();
			iniciarBloqueo();
			//$(".optionReset").val("");
		}
	}

	function IsNumeric(valor) {
		var log = valor.length;
		var sw = "S";
		for (x = 0; x < log; x++) {
			v1 = valor.substr(x, 1);
			v2 = parseInt(v1);
			//Compruebo si es un valor numérico
			if (isNaN(v2)) {
				sw = "N";
			}
		}
		if (sw == "S") {
			return true;
		} else {
			return false;
		}
	}
	var primerslap = false;
	var segundoslap = false;
	function formateafecha(fecha) {
		var getDate = new Date();
		var fechaActual = new Date(getDate.getFullYear()-17,getDate.getMonth(),getDate.getDate());
		var long = fecha.length;
		var dia;
		var mes;
		var ano;
		if ((long >= 2) && (primerslap == false)) {
			dia = fecha.substr(0, 2);
			if ((IsNumeric(dia) == true) && (dia <= 31)
					&& (dia != "00")) {
				fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
				primerslap = true;
			} else {
				fecha = "";
				primerslap = false;
			}
		} else {
			dia = fecha.substr(0, 1);
			if (IsNumeric(dia) == false) {
				fecha = "";
			}
			if ((long <= 2) && (primerslap = true)) {
				fecha = fecha.substr(0, 1);
				primerslap = false;
			}
		}
		if ((long >= 5) && (segundoslap == false)) {
			mes = fecha.substr(3, 2);
			if ((IsNumeric(mes) == true) && (mes <= 12)
					&& (mes != "00")) {
				fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
				segundoslap = true;
			} else {
				fecha = fecha.substr(0, 3);
				;
				segundoslap = false;
			}
		} else {
			if ((long <= 5) && (segundoslap = true)) {
				fecha = fecha.substr(0, 4);
				segundoslap = false;
			}
		}
		if (long >= 7) {
			ano = fecha.substr(6, 4);
			if (IsNumeric(ano) == false) {
				fecha = fecha.substr(0, 6);
			} else {
				if (long == 10) {
					if ((ano == 0) || (ano < 1900)) {
						fecha = fecha.substr(0, 6);
					}
				}
			}
		}
		if (long >= 10) {
			fecha = fecha.substr(0, 10);
			dia = fecha.substr(0, 2);
			mes = fecha.substr(3, 2);
			ano = fecha.substr(6, 4);
			// Año no viciesto y es febrero y el dia es mayor a 28
			if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
				fecha = fecha.substr(0, 2) + "/";
			}
		}
		if(fecha.length==10){
			if(fechaCorrecta(fecha,convertirFecha(fechaActual))==true){
				fecha = convertirFecha(fechaActual);
				msg_advertencia("El docente debe se mayor de edad");
			}
		}
		return (fecha);
	}

	function fechaCorrecta(fecha1, fecha2){

	    //Split de las fechas recibidas para separarlas
	    var x = fecha1.split("/");
	    var z = fecha2.split("/");

	    //Cambiamos el orden al formato americano, de esto dd/mm/yyyy a esto mm/dd/yyyy
	    fecha1 = x[1] + "/" + x[0] + "/" + x[2];
	    fecha2 = z[1] + "/" + z[0] + "/" + z[2];

	    //Comparamos las fechas
	    if (Date.parse(fecha1) <= Date.parse(fecha2)){
	        return false;
	    }else{
	        return true;
	    }
	}

	/*
	function validaSelect(form) {
		if (form.codigoLenguaMaterna.options[1].selected == true) {
			alert('Esta opción no está disponible');
			form.patata.options[0].selected = true;
		}
	}
	*/
	/*
	function activar(obj){
	  if(obj.value=='0')
		  var selectLengua = document.getElementById("codigoLenguaMaterna").value;
		  alert("ssss");
		  alert(selectLengua);
	  obj.value='';
	         //document.getElementById("dos").disabled=false;
	  //else
	        // document.getElementById("dos").disabled=true;
	}*/
/*	function guardarEspecialidad(contextController, idForm){
	function guardarEspecialidad(docenteBean){

//		var actionForm = $("#frmInsertarLengua").attr("action");
//		var url = contextController + actionForm;
//		var url = contextController + actionForm;

	 	$.ajax({
	           type: "GET",
	           url:  "${pageContext.request.contextPath}/docenteController/insertarEspecialidad?docenteBean="+docenteBean,
	           //data: $("#frmInsertarLengua").serialize(),
	           success: function(data)
	           {
	        	   msg_exito();
	           },
				error: function(xhr,status,er) {
					msg_error();
			     console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	console.log(er);
				 //   	Error_500(er);
				    }
				    if(xhr.status==901) {
			    	console.log(er);
			    //	spire_session_901(er);
	    			}
			    },
			    complete: function(){

			    	refrescarListaEspecialidad();

			    }
	         });
	    return false;
	}


	function refrescarListaEspecialidad(){

		var codinstitucion = $('#codigoInstitucion').val();
		var contextPath = $('#contextPathUrl').val();
		var htmlTabla = "";

		  $.ajax({
		    type: "GET",
		    //data: "entidad=" + entidad,
		    url: contextPath+"/institucionController/refrescarListaInstLengua?codigoInst="+codinstitucion,
		    success: function(response){
		    	console.log(response);
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
			    		htmlTabla +=
			    			"<tr>"+
			    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
					    		"<td>"+
						    		"<a title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' href='eliminarLengua?codigo="+objInstLengua.codigo+"'><i class='icon-trash'></i></a>"+
					    			//"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionOperador("+objInstDirector.codigo+");'><i class='icon-pencil'></i></button>"+
					    		"</td>"+
			    		"</tr>";
					}
			    	console.log(htmlTabla);
			    	$('#idBodyListaInstLengua').empty();
		  	    	$('#idBodyListaInstLengua').html(htmlTabla);
		    	}
		    },error: function(xhr,status,er) {
	         console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	console.log(er);
			    	//spire_session_901(er);
				    }
		    },
		    complete: function(){
		    	$('#cboLenguaSelecInst').val(0);
		    }
		  });
	}
		*/

	function validarPersona(){
			
		var tipoDocumento= $('#codigoTipoDocumento').val();

		var numeroDocumento=$('#numeroDocumentoPersona').val();
		if(numeroDocumento==null && numeroDocumento==""){
			numeroDocumento=0;

			}
	  	$.ajax({
	  		type : "POST",
	  		url : "${pageContext.request.contextPath}/personaController/validapersona?tipodocumento="+tipoDocumento+"&numerodocumento="+numeroDocumento,
	  		success : function(data) {
		if(data.codigo!=0){
			$('#codigoTipoDocumento').val(data.tipoDocumento.codigoRegistro);
			$('#numeroDocumentoPersona').val(data.numeroDocumento);
			$('#codigoPersona').val(data.codigo);
			/*$('#codigoPersonal').val();*/
			/*$('#tm1Situacion').val(data);*/
			$('#nacionalidad').val(data.nacionalidad.codigoRegistro);
			$('#nombrePersona').val(data.nombrePersona);
			$('#apellidoPaterno').val(data.apellidoPaterno);
			$('#apellidoMaterno').val(data.apellidoMaterno);
			/* $('#fechaNacimiento').val(data.fechaNac); */
			var strFecha = convertirFecha(data.fechaNac);
			$('#fechaNacimiento').val(strFecha);
			//var strFecha = convertirFecha(data.personaBean.fechaNac);
			//$('#fechaNacimiento').val(strFecha);
			/*$('#gradoPersonal').val(data.);*/
			/*$('#cargoPersonal').val();*/


			$('#cboSexo').val(data.sexo.codigoRegistro);
			$('#telefonoUsuario').val(data.telefono);
			$('#correoElectronico').val(data.correo);
			$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
			/*ubigeo persona */
			var codDep = data.ubigeoBean.codigoRegion;
			var codPro = data.ubigeoBean.codigoProvincia;
			var codDis = data.ubigeoBean.codigoDistrito;
			$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
			if (codDep != null && codDep != "") {
				buscarProvinciaXCodigos(codDep, codPro);
				$('#comboprovincia').val(codPro);
				if (codPro != null && codPro != "") {
					buscarDistritoXCodigos(codDep,
							codPro, codDis);
					$('#combodistrito').val(codDis);
				}
			}
			$('#direccion').val(data.direccionPersona);
			$('#lblLengua').val(data.lenguaBean.codigo);
		/*
			$('#lblInstitu').val(data.direccionPersona);
			$('#nivelSelect').val(data.direccionPersona);
			$('#gradoSelect').val(data.direccionPersona);
			$('#selectCarrera').val(data.direccionPersona);
			$('#provinciaSelectinstitucion').val(data.direccionPersona);
			$('#comboprovinciainstitucion').val(data.direccionPersona);
			$('#combodistritoinstitucion').val(data.direccionPersona);
			*/

			}


	  		},
	  		error : function() {
	  			console.log("ERROR: ");
	  		}
	  	});
	  }



	function validarDocente(){

		var numeroDocumento=$('#numeroDocumentoPersona').val();
		if(numeroDocumento==null && numeroDocumento==""){
			numeroDocumento=0;
		}
	  	$.ajax({
	  		type : "POST",
	  		url : "${pageContext.request.contextPath}/docenteController/validarDocente?numerodocumento="+numeroDocumento,
	  		success : function(data) {
		if(data.codigo!=0){
			//alert(data);
			//console.log(data);
			$('#codigoTipoDocumento').val(data.personaBean.tipoDocumento.codigoRegistro);
			$('#numeroDocumentoPersona').val(data.personaBean.numeroDocumento);
			$('#codigoPersona').val(data.personaBean.codigo);
			$('#codigoDocente').val(data.codigo);
			$('#tm1Situacion').val(data.situacion.codigoRegistro);
			$('#nacionalidad').val(data.personaBean.nacionalidad.codigoRegistro);
			$('#nombrePersona').val(data.personaBean.nombrePersona);
			$('#apellidoPaterno').val(data.personaBean.apellidoPaterno);
			$('#apellidoMaterno').val(data.personaBean.apellidoMaterno);
			var strFecha = convertirFecha(data.personaBean.fechaNac);
			$('#fechaNacimiento').val(strFecha);
			//$('#fechaNacimiento').val(data.personaBean.fechaNac);

			$('#cboSexo').val(data.personaBean.sexo.codigoRegistro);
			$('#telefonoUsuario').val(data.personaBean.telefono);
			$('#correoElectronico').val(data.personaBean.correo);

			$('#lblLengua').val(data.personaBean.lenguaBean.codigo);

			$('#lblInstitu').val(data.institucionBean.codigo);

			$('#gradoSelect').val(data.gradoDocente.codigoRegistro);
			$('#nivelSelect').val(data.carreraDocente.codigoRegistro);
			//$('#selectCarrera').val(data.tm2Programa.codigoRegistro);

			/*ubigeo persona */
			var codDep = data.ubigeoBean.codigoRegion;
			var codPro = data.ubigeoBean.codigoProvincia;
			var codDis = data.ubigeoBean.codigoDistrito;
			$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
			if (codDep != null && codDep != "") {
				buscarProvinciaXCodigos(codDep, codPro);
				$('#comboprovincia').val(codPro);
				if (codPro != null && codPro != "") {
					buscarDistritoXCodigos(codDep,
							codPro, codDis);
					$('#combodistrito').val(codDis);
				}
			}

			$('#direccion').val(data.personaBean.direccionPersona);
			refrescarListaEspecialidad(data.codigo);
			 document.getElementById("tag2").className ="nav-item mostrar";
			 /*aqui las especialidades*/
			//console.log(data);
			}else{
				refrescarListaEspecialidad(data.codigo);
				document.getElementById("tag2").className ="nav-item ocul";
				validarPersona();
			}


	  		},
	  		error : function() {
	  			console.log("ERROR: ");
	  		}
	  	});

	  }


		function buscarPersona(e) {
			if (e.which == 13 || e.keyCode == 13) {
				var numerodocumento = $('#numeroDocumentoPersona').val();
				if (numerodocumento.length > 7
						&& numerodocumento.length < 13) {
					validarDocente();

				}
			}
		}

	function formatoNumeroDocumento(){
		var tipoDocumento = $('#codigoTipoDocumento').val();
		if(tipoDocumento==1){
			$("#numeroDocumentoPersona").attr("pattern","[0-9]{8}");
		}
		if(tipoDocumento==2){
			$("#numeroDocumentoPersona").attr("pattern","[a-zA-Z]{5,12}");
		}
		if(tipoDocumento==3){
			 $("#numeroDocumentoPersona").removeAttr("pattern");
		}

	}

	 function convertirFecha(fecha) {
			var strFecha = "";
			var fecha = new Date(fecha);
			var dia = "";
			var mes = "";
			if (fecha.getDate().toString().length == 1) {
				dia = "0" + fecha.getDate().toString();
			} else {
				dia = fecha.getDate().toString();
			}
			if ((fecha.getMonth() + 1).toString().length == 1) {
				mes = "0" + (fecha.getMonth() + 1);
			} else {
				mes = (fecha.getMonth() + 1).toString();
			}
			return strFecha = dia + "/" + mes + "/" + fecha.getFullYear();
		}

	 function soloNumeros(e)
		{
		   var keynum = window.event ? window.event.keyCode : e.which;
		   if ((keynum == 8) || (keynum == 46))
		        return true;
		    return /\d/.test(String.fromCharCode(keynum));
		}

	 
   function justNumbers(e) {
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		var tipoDocumento = $('#codigoTipoDocumento').val();
		if (tipoDocumento != 0) {
			/*DNI*/
			if (tipoDocumento == 1) {
				if (numeroDocumento.length < 8) {
					var keynum = window.event ? window.event.keyCode
							: e.which;
					if ((keynum == 8) || (keynum == 46))
						return true;
					return /\d/.test(String.fromCharCode(keynum));
				} else {
					var keynum = window.event ? window.event.keyCode
							: e.which;
					if ((keynum == 8))
						return true;
					e.preventDefault();
				}
			}
			/*PASAPORTE*/
			if (tipoDocumento == 2) {
				if (numeroDocumento.length < 12) {
					 key = e.keyCode || e.which;
					    tecla = String.fromCharCode(key).toString();
					    letras = " 1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

					    tecla_especial = false
					    for(var i in especiales) {
					        if(key == especiales[i]) {
					            tecla_especial = true;
					            break;
					        }
					    }

					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
					/* alert('Tecla no aceptada');*/
					        return false;
					      }
				} else {
					e.preventDefault();
				}
			}

		}
	}

   /* function buscarPersona(e) {
	   /*
		if (e.which == 13 || e.keyCode == 13) {
			var numerodocumento = $('#numeroDocumentoPersona').val();
			if (numerodocumento.length > 7
					&& numerodocumento.length < 13) {
				validarPersonal();
			}
		}
	}
	*/
	</script>


  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="index.html" class="navbar-brand"><img alt="stack admin logo" src="../app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text">ALOC</h2></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
              <jsp:include page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
          <jsp:include page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
      </div>
    </div>
	<input type="hidden" value="${swMensaje}"  id="mensaje"  />
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Acad&eacute;mico</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Registro de Docente</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Registro de Docente </h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">

                                    <div class="col-md-12">
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">General</a>
                                        </li>
                                        <li id="tag2" class="nav-item ocul">
                                          <a class="nav-link " id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Lengua Originaria de Dominio</a>
                                        </li>
                                      </ul>
                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <f:form  id="frmRegistroDocente" class="form mt-1" role="form" method="post" action="grabar"  onSubmit="return validarGrabar()">
                                            <div class="form-body">
                                             <div class="row">
                                                <div class="col-xs-12">
                                                  <h5>DATOS GENERALES</h5>
                                                </div>
                                              </div>
                                                <f:input type="hidden" path="codigo"  id="codigoDocente"  />
                                          			<f:input type="hidden" path="personaBean.codigo"  id="codigoPersona"/>
                                                
                                              <div class="row">
                                                 <div class="form-group col-md-3 mb-2">
                                                     <label for="situacionUsuario">Situaci&oacute;n <span class="required">*</span></label>
                                                   <div class="controls">
	                                                   <f:select id="tm1Situacion"  path="situacion.codigoRegistro" class="form-control"   data-validation-required-message="Este campo es requerido" required="required">
	                                                            <f:option value="" label="Seleccionar"/>
	                                                            <f:options  items="${lstSituacion}"
	                                                                        itemValue="codigoRegistro"
	                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
													</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Tipo Documento <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select id="codigoTipoDocumento"  path="personaBean.tipoDocumento.codigoRegistro" onchange="formatoNumeroDocumento();" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstTipoDocumento}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                                                  </div>

                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput2">N&uacute;mero Documento <span class="required">*</span></label>
                                                 		<div class="controls" id="numdoc">
                                                 		<f:input type="text" id="numeroDocumentoPersona" onkeypress="buscarPersona(event);return justNumbers(event);" class="form-control" path="personaBean.numeroDocumento" data-validation-required-message="Este campo es requerido"  required="required"/>
                                                  		</div>
                                                  </div>

                                                  <div class="form-group col-md-3">
                                                    <label for="situacionUsuario">Nacionalidad <span class="required">*</span></label>
                                                    <div class="controls">
                                                    <f:select id="nacionalidad" path="personaBean.nacionalidad.codigoRegistro" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstNacionalidad}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                    </f:select>
                                                    </div>
                                                  </div>

                                              </div>
												
                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput1">Nombres <span class="required">*</span></label>
                                                 		<div class="controls">
                                                 		<f:input id="nombrePersona" type="text" class="form-control" path="personaBean.nombrePersona"  data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required"/>
                                                  		</div>
                                                  </div>

                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="apellidopaterno">Apellido Paterno <span class="required">*</span></label>
                                                       <div class="controls">
                                                       <f:input type="text" id="apellidoPaterno" class="form-control" path="personaBean.apellidoPaterno"  data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required"/>
                                                  		</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput2">Apellido Materno <span class="required">*</span></label>
                                                    <f:input type="text" id="apellidoMaterno" class="form-control" path="personaBean.apellidoMaterno"  data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required"/>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="fechanacimiento">Fecha de Nacimiento <span class="required">*</span></label>
                                                  	  <div class="controls">
                                                  		<f:input type="text" id="fechaNacimiento" name="fecha"   class="form-control"  onchange="cambiarfecha();"   path="personaBean.strFechaNac" size="10" maxlength="10" onKeyUp = "this.value=formateafecha(this.value);" required="required"/>
                                                      </div>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="form-group col-md-3">
                                                    <label for="projectinput2">G&eacute;nero <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select id="cboSexo"  path="personaBean.sexo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSexo}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                                                </div>

                                               <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Tel&eacute;fono / Celular <span class="required">*</span></label>
                                                  <div class="controls">
                                                  	<f:input type="text" id="telefonoUsuario" class="form-control" name="telefono"  path="personaBean.telefono" data-validation-required-message="Este campo es requerido" required="required"/>
                                              	  </div>
                                              </div>
                                                <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Correo Electr&oacute;nico <span class="required">*</span></label>
                                                   <div class="controls">
                                                   <f:input type="text" id="correoElectronico" class="form-control" path="personaBean.correo"  data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" onKeyUp="this.value = this.value.toLowerCase();" data-validation-regex-message="Ingresa un correo valido" data-validation-required-message="Este campo es requerido" required="required"/>
                                                	</div>
                                                </div>
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Lengua Materna <span class="required">*</span></label>
                                                 	<div class="controls">
                                                 		<f:select  path="personaBean.lenguaBean.codigo" id="lblLengua" class="form-control selectReset" name="codigoLenguaMaterna"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="0" label="Seleccionar"  class="optionReset" />
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                                        </f:select>
                                                    </div>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <h5>DATOS PROFESIONALES</h5>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="form-group col-md-6 mb-2">
                                                  <div class="form-group">
                                                    <label for="situacionUsuario">Nombre de la Instituci&oacute;n <span class="required">*</span></label>
														<div class="controls">
														<f:select id="lblInstitu" path="institucionBean.codigo"  class="select2 form-control selectReset"  data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="0" class="optionReset" label="Seleccionar" />
															<f:options items="${lstInstitucion}" itemValue="codigo" itemLabel="nombreInstitucion" />
														</f:select>
														</div>
                                                  </div>
                                                </div>
												  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Grado o t&iacute;tulo <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select  path="gradoDocente.codigoRegistro" id="gradoSelect" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstGrado}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                                                  </div>
                                              </div>
                                              <%-- 
                                              <div class="row">
                                             --%>
												<%-- 
                                                <div class="form-group col-md-3 mb-2">
                                                  <%--<label for="situacionUsuario">Carrera <span class="required">*</span></label> --%>
                                                  <%--
                                                  <label for="situacionUsuario">Nivel de instrucción <span class="required">*</span></label>

                                                   <div class="controls">
                                                   <f:select  path="carreraDocente.codigoRegistro" id="nivelSelect" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstCarrera}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                     </div>
                                                     
                                                </div>
                                              </div>
												--%>
                                              <div class="row">
                                                <div class="col-xs-12">
                                               	 <h5> DATOS DE RESIDENCIA  </h5>
                                                  <br>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="form-group col-md-3">
												        <label for="projectinput2">Regi&oacute;n</label>
												          <f:select path="ubigeoBean.codigoRegion" onchange="buscarProvincia();" id="provinciaSelect" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstRegion}"
                                                                        itemValue="codigoRegion"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Provincia</label>

												        <f:select path="ubigeoBean.codigoProvincia" onchange="buscarDistrito();" id="comboprovincia" name="comboprovincia" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstProvincia}"
                                                                        itemValue="codigoProvincia"
                                                                        itemLabel="nombreUbigeo"/>
                                                       	</f:select>


												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Distrito</label>
												         <f:select path="ubigeoBean.codigoDistrito" id="combodistrito" name="combodistrito" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstDistrito}"
                                                                        itemValue="codigoDistrito"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>

                                              </div>

											  <div class="row">
											    <div class="form-group col-md-9">
                                                 	<div class="controls">
                                                    <label for="direccion">Direcci&oacute;n <span class="required">*</span></label>
                                                     <f:input type="text" id="direccion" class="form-control" path="personaBean.direccionPersona" data-validation-required-message="Este campo es requerido" maxlength="50" required="required"/>
                                                	</div>
                                                </div>
											  </div>

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="reset" class="btn btn-secondary mr-1" onclick="limpiarCodigo();" id="limpiar">
                                                        <i class="fa fa-eraser"></i> Limpiar
                                                      </button>
                                                      <button type="submit" onclick="validarRequiredDocente('#frmRegistroDocente');" class="btn btn-primary">
                                                    <i class="fa fa fa-floppy-o" ></i> Guardar
                                                  </button>
<!--                                                       <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->

                                                  </div>
                                              </div>
                                            </div>
                                          </f:form>
                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                         <f:form class="form mt-1"  id="frmInsertarLengua" role="form" method="post" action="${pageContext.request.contextPath}/docenteController/grabarEspecialidad" onsubmit="return false">
                                            <div class="form-body">

                                              <div class="row">
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Lengua</label>
                                                   <f:input type="hidden" path="codigo"  id="codigoDocente"/>
													<div class="controls">
													<f:select  path="especialidadBean.lenguaBean.codigo" id="codigoLengua" class="form-control selectReset"   data-validation-required-message="Este campo es requerido" required="required">

                                                            <f:option value="0" class="optionReset" label="Seleccionar"/>
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                               		</f:select>
                                               		</div>
                                                </div>
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Nivel de Dominio</label>
                                                   <div class="controls">
                                                   <f:select  path="especialidadBean.tm2Nivel.codigoRegistro" id="codigoNivel"  class="form-control"   data-validation-required-message="Este campo es requerido"	required="required">
                                                            <f:option value="" selected="" label="Seleccionar"/>
                                                            <f:options  items="${lstNivel}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                  </f:select>
                                                  </div>
                                                </div>
                                               <div class="form-group col-md-2 " >
                                                  <%--<button type="submit" class="btn btn-outline-info btn-min" style="margin-top: 20px">--%>
                                                    <button type='submit' class="btn btn-outline-info btn-min"  onclick="validarRequired('#frmInsertarLengua');" style="margin-top: 20px"  >
                                                 <i class="ft-plus"></i></button>
                                                </div>
                                              </div>

												<%--
												<div class="row">
												<f:input type="hidden" id="idRutaDoc" class="form-control" path="inscripcionBean.rutaDocumento"/>
											  	  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero del Documento <span class="required">*</span></label>
                                                      <div class="controls">
                                                      <f:input type="text" class="form-control" path="inscripcionBean.numeroDocumento" onkeypress="return justNumbers(event);" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" required="required"/>

                                                	 </div>
                                                  </div>
                                                 <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento==null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir Documento <span class="required">*</span></label>
                                                  <input type="file" id="file" class="form-control" name="file" data-validation-required-message="Este campo es requerido" required="required">
                                                 </div>
                                                </c:if>
                                                <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento!=null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir Documento </label>
                                                  <input type="file" id="file" class="form-control" name="file" >
                                                 </div>
                                                </c:if>

												<div class="form-group col-md-9">
												 <div class="controls">

												   <!-- onclick="descargarArchivo()" <a  download="Archivo">Descargar Archivo</a>-->
                                                 </div>
                                                 </div>
                                                 <div class="form-group col-md-9">
                                                  <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento!=null && swMensaje!=0}">

                                                  <a id="idlink" target="_Blank" onclick="descargarArchivo();">
                                                    <div class="link link_derecho">
                                                   <img class="media-object" border="0" align="middle" name="contenedorRuta" src="${pageContext.request.contextPath}/assets/img/archivoDescarga.png"
                                                  style="width: 50px;height: 50px;" id="contenedorRuta"/>
                                                  <div style="margin-top: -35px;margin-left: 59px;">Descargar Archivo </div>
                                                  </div>
                                                  </a>
												 </c:if>
												 </div>
                                              </div>
												--%>
												<div class="row">
												<%--  --%>
												 <f:input type="hidden" id="idRutaDoc" class="form-control" path="especialidadBean.rutaDocumento"/>
											  	  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero del Documento <span class="required">*</span></label>
                                                      <div class="controls">
                                                      <f:input type="text" id="numeroDocumento" class="form-control" path="especialidadBean.numeroDocumento" onkeypress="return soloNumeros(event);" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" required="required"/>
                                                	 </div>
                                                  </div>
                                                 <c:if test="${especialidadBean.rutaDocumento==null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir Documento <span class="required">*</span></label>
                                                  <input type="file" id="file" class="form-control" name="file" data-validation-required-message="Este campo es requerido" required="required">
                                                 </div>
                                                </c:if>
                                                <c:if test="${especialidadBean.rutaDocumento!=null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir Documento </label>
                                                  <input type="file" id="file" class="form-control" name="file" >
                                                 </div>
                                                </c:if>

												<div class="form-group col-md-9">
												 <div class="controls">

												   <!-- onclick="descargarArchivo()" <a  download="Archivo">Descargar Archivo</a>-->
                                                 </div>
                                                 </div>
                                                 <div class="form-group col-md-9">
                                                  <c:if test="${especialidadBean.rutaDocumento!=null && swMensaje!=0}">
                                                  <a id="idlink" target="_Blank" onclick="descargarArchivo();">
                                                    <div class="link link_derecho">
                                                   <img class="media-object" border="0" align="middle" name="contenedorRuta" src="${pageContext.request.contextPath}/assets/img/archivoDescarga.png"
                                                  style="width: 50px;height: 50px;" id="contenedorRuta"/>
                                                  <div style="margin-top: -35px;margin-left: 59px;">Descargar Archivo </div>
                                                  </div>
                                                  </a>
												 </c:if>
												 </div>
                                                <%--  --%>
                                              </div>
                                            <div class="row">
                                              <div class="col-xs-6">
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Lengua</th>
                                                            <th width="70">Nivel de Dominio</th>
                                                            <th width="90">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="idlistadoEspecialidad">
                                                        <c:forEach var="especialidadBean" items="${lstEspecialidad}">
		                                                  <tr>
		                                                    <td>${especialidadBean.lenguaBean.nombre}</td>
		                                                   	<td>${especialidadBean.tm2Nivel.nombreCorto} </td>
		                                                    <td>
		                                                    <%-- <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" href="modificar?codigo=${especialidadBean.codigo}"><i class="icon-pencil"></i></a> --%>
		                                                    <button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
                                                 			
		                                                    </td>
		                                                  </tr>
                                                 		</c:forEach>
                                                    </tbody>
                                                </table>
                                              </div>
                                            </div>

                                            </div>
                                          </f:form>
                                        </div>

                                      </div>
                                    </div>

                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="#" target="_blank" class="text-bold-800 grey darken-2">Natigu </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy Business</span></p>
    </footer>
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
  
    
    <script type="text/javascript">


    function descargarArchivo() {
 	   var url= $('#idRutaDoc').val();

 		/* var nuevaurl="<a id='iddes' href="+url+" download="+url+">Descargar Archivo</a>"; */
 		var nuevaurl=" href="+url+" download="+url+" ";

 	  //document.getElementById("iddes").click();


 			/* $('#contenedorRuta').html(nuevaurl); */
 		/* 	$('#idlink').html(nuevaurl); */
 			$('#idlink').attr('href',"file:///"+url);
 			$('#idlink').attr('download',url);
 			$('#idlink').click(function(e) {
 				e.stopPropagation();
 				return;

 		    });
 			$('#idlink').click(function(e) {
 				 e.stopPropagation();
 				 return;

 			});


 	}
    
    function onColorVerde(id){
		var idvalor =$(id).val();
		if(idvalor == "00"){
			$(id).css("color", "#444");
		}else{
			$(id).css("color", "#16D39A");
		}
	}

    function limpiarCodigo(){
    	//$("#tag2").removeClass("mostrar");
        document.getElementById("tag2").className ="nav-item ocul";
		$('#codigoDocente').val("0");
		$('#codigoPersona').val("0");
				
	}
	
    
    function validarGrabar(){
		return ejecutarGuardar;
	}

    function eliminarConfirmacion(codigoDocente,codigoEspecialidad) {
        //almacenar datos
    	prmCodigoDocente = codigoDocente;
    	prmCodigoEspecialidad = codigoEspecialidad;
    	
		//mostrar modal
		$('#md_confirmacion').modal('show');
	}
	//click en boton confirmar
    $( "#btnConfirmarGeneric" ).click(function() {
		  eliminarEspecialidad(prmCodigoDocente,prmCodigoEspecialidad);
		  $('#md_confirmacion').modal('hide');
	});


	function eliminarEspecialidad(codigoDocente,codigoEspecialidad){

		 $.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/docenteController/eliminarEspecialidad?codigo="+codigoDocente+"&codigoEspecialidad="+codigoEspecialidad,
				success : function(data) {
					if(data=='1'){
						msg_exito();
						refrescarListaEspecialidad(codigoDocente);
					}else if(data=='0'){
						msg_error();
					}
				},
				error : function() {
					console.log("ERROR: ");
				}
			});

	}


	function refrescarListaEspecialidad(codigoDocente){
		var htmlTabla = "";

		  $.ajax({
		    type: "GET",
		    url : "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente,
			success: function(response){

		    	$('#idlistadoEspecialidad').empty();

		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
			    		htmlTabla +=
			    			"<tr>"+
	    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
	    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
				    		"<td>"+
								"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarConfirmacion('"+objInstLengua.docenteBean.codigo+"','"+objInstLengua.lenguaBean.codigo+"');\"><i class='icon-trash'></i></button>"+
				    		"</td>"+
			    		"</tr>";
					}
		  	    	$('#idlistadoEspecialidad').html(htmlTabla);
		    	}
		    },error: function(xhr,status,er) {
	         console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	console.log(er);
			    	//spire_session_901(er);
				    }
		    }
		  });
	}

	$("#numeroDocumentoPersona").keyup(function(e){
	   	   e.preventDefault();

		   var tipodocumento = $('#codigoTipoDocumento').val();
		   var numerodocumento = $('#numeroDocumentoPersona').val();
		   
		   //alert(tipodocumento);
	       if(tipodocumento == "1" || tipodocumento == ""){
	    	   if (numerodocumento.length > 7) {
	    		   validarDocente();
	      			}
	       } else if(tipodocumento == "2"){
	    	   if (numerodocumento.length > 5) {
	    		   validarDocente();
	      		}
	       }
			
	  });
	
    </script>
  </body>
</html>