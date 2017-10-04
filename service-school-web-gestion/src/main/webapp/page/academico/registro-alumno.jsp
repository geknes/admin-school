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
    <title>Registro de Estudiante</title>
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

  <script type="text/javascript">
  	  ejecutarGuardar = false;
	  listadoNacionalidad = [];
	  listadoLengua = [];
	  
	  itemNacionalidad = '';
	  itemLengua = '';
	  tipoItem = '';
		

	  $( document ).ready(function() {
			$(".optionReset").val("");
			  
		
		  listadoNacionalidadBean = document.getElementById("ListadoNacionalidadBean").value;
		  listadoLenguaBean = document.getElementById("ListadoLenguaBean").value;
		  //alert(listadoNacionalidadBean);
		  //alert(listadoLenguaBean);
			
		  var cadenaNacionalidadBean = listadoNacionalidadBean.substring(1, listadoNacionalidadBean.length-1);
		  var listadoNacionalidadTemp = cadenaNacionalidadBean.split(",");

		  if(listadoNacionalidadTemp != null && listadoNacionalidadTemp.length > 0){
			  for(var i = 0; i < listadoNacionalidadTemp.length; i=i+2){
				    listadoNacionalidad.push([listadoNacionalidadTemp[i].trim(),listadoNacionalidadTemp[i+1].trim()]);
			  }
		  }
		  

		  var cadenaLenguaBean = listadoLenguaBean.substring(1, listadoLenguaBean.length-1);
		  var listadoLenguaTemp = cadenaLenguaBean.split(",");
		  
		  if(listadoLenguaTemp != null && listadoLenguaTemp.length > 0){
			  for(var i = 0; i < listadoLenguaTemp.length; i=i+4){
				  listadoLengua.push([listadoLenguaTemp[i],listadoLenguaTemp[i+1],listadoLenguaTemp[i+2],listadoLenguaTemp[i+3]]);
		      }
		  }
		  //refrescarNacionalidad();
		  mostrarTablaNacionalidad();
		  mostrarTablaLengua();
		  //alert(listadoNacionalidad);
		  //alert(listadoLengua);



		  personaBean = {
				  codigo : 0
		  };
		  lenguaBean = {
				  codigo : 0
		   };
		   console.log(personaBean);
		   console.log(lenguaBean);
		  	$("#frmRegistroAlumno").submit(function( event ) {
			  //alert( ":v aqui vamos otra vez" );
			  event.preventDefault();
			});


			var codigo = document.getElementById("codigoAlumno").value;
			if (codigo != '0') {
				 $('#limpiar').attr("disabled", true);
			}




		});

		

		function validarRequired(idfrom){
			var $myForm = $(idfrom);

			var departamento = document.getElementById("provinciaSelect");
			var provincia = document.getElementById("comboprovincia");
			var distrito = document.getElementById("combodistrito");
			var lengua = document.getElementById("lblLengua");
			var nacionalidad = document.getElementById("nacionalidad");

			if(! $myForm[0].checkValidity() || (listadoNacionalidad == null || listadoNacionalidad.length <= 0) ||
					(listadoLengua == null || listadoLengua.length <= 0) || departamento.value == "00" ||
					 provincia.value == "00" || distrito.value == "00") {



				/*todo de color verde  ok */
				$("#nacionalidad").css("border", "2px solid rgba(22, 211, 154, .5)");
				$("#lblTipoLengua").css("border", "2px solid rgba(22, 211, 154, .5)");
				$("#lblLengua").css("border", "2px solid rgba(22, 211, 154, .5)");
				
				$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
				$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
				$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");
				$("#provinciaSelect").css("color", "#16D39A");
				$("#comboprovincia").css("color", "#16D39A");
				$("#combodistrito").css("color", "#16D39A");
				// mensaje
				 msg_advertencia("Debe completar los campos requeridos correctamente");

				 if(listadoNacionalidad == null || listadoNacionalidad.length <= 0){
						$("#nacionalidad").css("border", "2px solid rgba(210, 60, 60, .5)");
						nacionalidad.focus();
  				   }
				if(listadoLengua == null || listadoLengua.length <= 0){
						$("#lblTipoLengua").css("border", "2px solid rgba(210, 60, 60, .5)");
						$("#lblLengua").css("border", "2px solid rgba(210, 60, 60, .5)");
						lengua.focus();
					}
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
		/* $('#frmRegistroAlumno').on('submit', function(e){
	    // validation code here
	      alert(":C");
	      e.preventDefault();
	 	});
		 */
	function buscarPersona(e) {
		if (e.which == 13 || e.keyCode == 13) {
			var numerodocumento = $('#numeroDocumentoPersona').val();
			if (numerodocumento.length > 7
					&& numerodocumento.length < 13) {
				validarAlumno();
			}
		}
	}
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
		//$('#nacionalidad').val(data.nacionalidad.codigoRegistro);
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
		//$('#lblLengua').val(data.lenguaBean.codigo);
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



  function validarAlumno(){
	var numeroDocumento=$('#numeroDocumentoPersona').val();
	if(numeroDocumento==null && numeroDocumento==""){
		numeroDocumento=0;

		}
  	$.ajax({
  		type : "POST",
  		url : "${pageContext.request.contextPath}/alumnoController/validaralumno?numerodocumento="+numeroDocumento,
  		success : function(data) {
	if(data.codigo!=0){

		$('#codigoTipoDocumento').val(data.personaBean.tipoDocumento.codigoRegistro);
		$('#numeroDocumentoPersona').val(data.personaBean.numeroDocumento);
		$('#codigoPersona').val(data.personaBean.codigo);
		$('#codigoAlumno').val(data.codigo);
		$('#tm1Situacion').val(data.tm1Situacion.codigoRegistro);
		//$('#nacionalidad').val(data.personaBean.nacionalidad.codigoRegistro);
		$('#nombrePersona').val(data.personaBean.nombrePersona);
		$('#apellidoPaterno').val(data.personaBean.apellidoPaterno);
		$('#apellidoMaterno').val(data.personaBean.apellidoMaterno);
		var strFecha = convertirFecha(data.personaBean.fechaNac);
		$('#fechaNacimiento').val(strFecha);
		//$('#fechaNacimiento').val(data.personaBean.fechaNac);

		$('#cboSexo').val(data.personaBean.sexo.codigoRegistro);
		$('#telefonoUsuario').val(data.personaBean.telefono);
		$('#correoElectronico').val(data.personaBean.correo);

		$('#direccion').val(data.personaBean.direccionPersona);
		$('#idestadocivil').val(data.personaBean.estadoCivil.codigoRegistro);

		$('#lblInstitu').val(data.institucionBean.codigo);
		$('#nivelSelect').val(data.tm2Nivel.codigoRegistro);
		$('#gradoSelect').val(data.tm2Grado.codigoRegistro);
		$('#selectCarrera').val(data.tm2Programa.codigoRegistro);

		/*ubigeo institucion*/
		/*
		var codDepIns = data.institucionBean.ubigeoBean.codigoRegion;
		var codProIns = data.institucionBean.ubigeoBean.codigoProvincia;
		var codDisIns = data.institucionBean.ubigeoBean.codigoDistrito;
		$('#provinciaSelectinstitucion').val(data.institucionBean.ubigeoBean.codigoRegion);
		if (codDepIns != null && codDepIns != "") {
			buscarProvinciaInstitucionXCodigos(codDepIns, codProIns);
			$('#comboprovinciainstitucion').val(codProIns);
			if (codProIns != null && codProIns != "") {
				buscarDistritoInstitucionXCodigos(codDepIns,
						codProIns, codDisIns);
				$('#combodistritoinstitucion').val(codDisIns);
			}
		}
		*/
		
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
		listadoLengua = [];
		listadoNacionalidad = [];
		
		 for(var i = 0; i < data.lstPersonaLenguaBean.length; i++){
			  listadoLengua.push([data.lstPersonaLenguaBean[i].lenguaBean.codigo,data.lstPersonaLenguaBean[i].lenguaBean.nombre,data.lstPersonaLenguaBean[i].tipoLengua.codigo,data.lstPersonaLenguaBean[i].tipoLengua.nombreCorto]);
	      }
	      
		 for(var i = 0; i < data.lstPersonaNacionalidadBean.length; i++){
			 listadoNacionalidad.push([data.lstPersonaNacionalidadBean[i].nacionalidad.codigo,data.lstPersonaNacionalidadBean[i].nacionalidad.nombreCorto]);
	      }
	
		mostrarTablaNacionalidad();
		mostrarTablaLengua();


		}else{

			validarPersona();

		}


  		},
  		error : function() {
  			console.log("ERROR: ");
  		}
  	});

  }




	 //Segundo 2 ubigeo
	 function buscarProvinciaInstitucion(){
	 	 //alert("hoa");
	//		  var numero =document.getElementById("lblInstitu").value;
			var id = $("#provinciaSelectinstitucion").val();
	// 		for(var f=0;f<document.getElementById("comboprovincia").length;f++){
	// 			if (document.getElementById("comboprovincia").length > 0) {

	// 				document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
	// 		    }

	// 			}
			document.getElementById("comboprovinciainstitucion").options[document.getElementById("comboprovinciainstitucion").innerHTML=""];
			document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").innerHTML=""];
			document.getElementById("comboprovinciainstitucion").options[document.getElementById("comboprovinciainstitucion").options.length]=new Option("Seleccionar", "00");
			document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").options.length]=new Option("Seleccionar", "00");
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/baseController/buscarProvincia?codigodepartamento="+id,
	//			data : {codigoinst:numero},

			success : function(data) {
				console.log("SUCCESS: ", data);
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";



				for(var i=0; i<data.length;i++){
					document.getElementById("comboprovinciainstitucion").options[document.getElementById("comboprovinciainstitucion").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);

					}


	//
			},
			error : function() {
				console.log("ERROR: ");
			}
		});

	}



	 function buscarDistritoInstitucion(){
	// 	 alert("hoa");
	//		  var numero =document.getElementById("lblInstitu").value;
			var id = $("#provinciaSelectinstitucion").val();
			var id2=$("#comboprovinciainstitucion").val();
			document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").innerHTML=""];
			document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").options.length]=new Option("Seleccionar", "00");
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
	//			data : {codigoinst:numero},

			success : function(data) {
				console.log("SUCCESS: ", data);
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

	// 			for(var f=0;f<document.getElementById("combodistrito").length;f++){
	// 				if (document.getElementById("combodistrito").length > 0) {
	// 					document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
	// 			    }

	// 				}


				for(var i=0; i<data.length;i++){

					document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);

					}

			},
			error : function() {
				console.log("ERROR: ");
			}
		});

	}



		function buscarProvinciaInstitucionXCodigos(codDep,codPro){
//			 alert("hoa");
//				  var numero =document.getElementById("lblInstitu").value;
				var id = codDep;
				var urlubigeo = $("#urlubigeo").val();
				console.log(urlubigeo);
//				for(var f=0;f<document.getElementById("comboprovincia").length;f++){
//					if (document.getElementById("comboprovincia").length > 0) {

//						document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
//				    }

//					}
				document.getElementById("comboprovinciainstitucion").options[document.getElementById("comboprovinciainstitucion").innerHTML=""];
				document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").innerHTML=""];
				document.getElementById("comboprovinciainstitucion").options[document.getElementById("comboprovinciainstitucion").options.length]=new Option("Seleccionar", "00");
				document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").options.length]=new Option("Seleccionar", "00");
			$.ajax({
				type : "GET",

				url : "../baseController/buscarProvincia?codigodepartamento="+id,
//					data : {codigoinst:numero},

				success : function(data) {
					console.log("SUCCESS: ", data);


					for(var i=0; i<data.length;i++){
						document.getElementById("comboprovinciainstitucion").options[document.getElementById("comboprovinciainstitucion").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);

						}


		//
				},
				error : function() {
					console.log("ERROR: ");
				},
				complete : function(){

					if(codPro!=null && codPro!=""){
						$("#comboprovinciainstitucion").val(codPro);
					}else{

						$("#comboprovinciainstitucion").val("00");
					}

				}

			});

		}




		function buscarDistritoInstitucionXCodigos(codDep,codPro,codDis){
//			 alert("hoa");
//				  var numero =document.getElementById("lblInstitu").value;
				var id = codDep;
				var id2=codPro;
				document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").innerHTML=""];
				document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").options.length]=new Option("Seleccionar", "00");
			$.ajax({
				type : "GET",
		///baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
				url : "../baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
//					data : {codigoinst:numero},

				success : function(data) {
					console.log("SUCCESS: ", data);
//					$('#provincia').html(data);
//					alert(data[1].codigo);
//					document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

//					for(var f=0;f<document.getElementById("combodistrito").length;f++){
//						if (document.getElementById("combodistrito").length > 0) {
//							document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
//					    }

//						}


					for(var i=0; i<data.length;i++){

						document.getElementById("combodistritoinstitucion").options[document.getElementById("combodistritoinstitucion").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);

						}

				},
				error : function() {
					console.log("ERROR: ");
				},
				complete : function() {

					if(codDis!=null && codDis!=""){
						$("#combodistritoinstitucion").val(codDis);
					}

				}
			});

		}





	 function buscarGrado(){
	 	 //alert("hoa");
	//		  var numero =document.getElementById("lblInstitu").value;
			var id = $("#nivelSelect").val();

	// 		for(var f=0;f<document.getElementById("comboprovincia").length;f++){
	// 			if (document.getElementById("comboprovincia").length > 0) {

	// 				document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
	// 		    }

	// 			}
			document.getElementById("gradoSelect").options[document.getElementById("gradoSelect").innerHTML=""];
			document.getElementById("gradoSelect").options[document.getElementById("gradoSelect").options.length]=new Option("Seleccionar", "");
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/alumnoController/buscarGrado?codigonivel="+id,
	//			data : {codigoinst:numero},

			success : function(data) {
				console.log("SUCCESS: ", data);
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";



				if(data!=''){
					for(var i=0; i<data.length;i++){
						document.getElementById("gradoSelect").options[document.getElementById("gradoSelect").options.length]=new Option(data[i].nombreCorto, data[i].codigoRegistro);
					}
				}


	//
			},
			error : function() {
				console.log("ERROR: ");
			}
		});

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
					msg_advertencia("El alumno debe se mayor de edad");
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
<!-- <div id="urlubigeo" style="display=none;">${pageContext.request.contextPath}</div> -->
<input type="hidden" name="country" value="${pageContext.request.contextPath}">
    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
          <jsp:include page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Acad&eacute;mico</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Registro de Estudiante</a>
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
                        <f:form id="frmRegistroAlumno" class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/alumnoController/grabar" onSubmit="return validarGrabar()">

	                      <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Registro de Estudiante </h4>
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
                                    <div class="col-md-12 offset-md-0">
                                      <form class="form">
                                        <div class="form-body">
										  <div class="row">
                                            <div class="col-xs-12">
                                              <h5>DATOS GENERALES</h5>
                                            </div>
                                          </div>

                                            <c:if test="${personaBean.codigo!=0}">
											<input type="hidden" value="${listadoNacionalidadVo}"  id="ListadoNacionalidadBean"  />
                                            <input type="hidden" value="${listadoLenguaVo}"  id="ListadoLenguaBean"/>
											</c:if>

                                          	<f:input type="hidden" path="codigo"  id="codigoAlumno"/>
                                         	<f:input type="hidden" path="personaBean.codigo"  id="codigoPersona"/>
                                          <div class="row">
                                          <div class="form-group col-md-3">
	                                       		 <label for="tm1Situacion">Situaci&oacute;n <span class="required">*</span></label>
                                                 <div class="controls">
	                                                 <f:select id="tm1Situacion" name="tm1Situacion" path="tm1Situacion.codigoRegistro" class="form-control"  data-validation-required-message="Este campo es requerido" required="required" >
	                                                    <f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
	                                                    <f:options  items="${lstSituacion}"
	                                                            itemValue="codigoRegistro"
	                                                            itemLabel="nombreCorto"/>
	                                                </f:select>
												</div>
                                              </div>

                                              <div class="form-group col-md-3">
                                                <label for="tipoDocumento">Tipo Documento <span class="required">*</span></label>
                                                <div class="controls">



	                                                <f:select id="codigoTipoDocumento" name="tipoDocumento" path="personaBean.tipoDocumento.codigoRegistro" onchange="formatoNumeroDocumento();"  class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
	                                                    <f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
	                                                    <f:options  items="${lstTipoDocumento}"
	                                                            itemValue="codigoRegistro"
	                                                            itemLabel="nombreCorto"/>
	                                               	</f:select>
                                               	</div>
                                              </div>

                                              <div class="form-group col-md-3">
                                              	<label for="numeroDocumento">N&uacute;mero Documento <span class="required">*</span></label>
                                                 <div class="controls">
                                                 	<f:input type="text" id="numeroDocumentoPersona" onkeypress="buscarPersona(event);return justNumbers(event);" class="form-control" name="numeroDocumento" path="personaBean.numeroDocumento" data-validation-required-message="Este campo es requerido"  required="required" />
                                                 </div>
                                               </div>
                                               
                                         </div>
                                          <div class="row">
                                              <div class="form-group col-md-3">
                                                  <label for="nombrePersona">Nombres <span class="required">*</span></label>
                                                  <div class="controls">
                                                  	<f:input type="text" id="nombrePersona" class="form-control" name="nombrePersona" path="personaBean.nombrePersona"  data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                              	  </div>
                                               </div>

                                              <div class="form-group col-md-3">
                                                  <label for="apellidoPaterno">Apellido Paterno <span class="required">*</span></label>
                                                  <div class="controls">
                                                  		<f:input type="text" id="apellidoPaterno" class="form-control" name="apellidoPaterno"  path="personaBean.apellidoPaterno"  data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                              	  </div>
                                              </div>
                                              <div class="form-group col-md-3">
                                                  <label for="apellidoMaterno">Apellido Materno <span class="required">*</span></label>
                                                  <div class="controls">
                                                  <f:input type="text" id="apellidoMaterno" class="form-control" name="apellidoMaterno"  path="personaBean.apellidoMaterno"  data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                                  </div>
                                              </div>
                                               <div class="form-group col-md-3">
                                                  <label for="fechanacimiento">Fecha de Nacimiento  <span class="required">*</span></label>
                                            	<div class="controls">
                                            		<!--<f:input type="date" id="fechanacimiento" class="form-control" name="fechanacimiento"   path="personaBean.fechaNac" /> -->
                                              		<f:input id="fechaNacimiento" type="text" name="fecha"   class="form-control"  onchange="cambiarfecha();"   path="personaBean.strFechaNac" size="10" maxlength="10" onKeyUp = "this.value=formateafecha(this.value);" required="required" />
                                              	</div>
                                               </div>

                                          </div>
                                            <div class="row">

                                          <div class="form-group col-md-3">
                                                  <label for="projectinput2">G&eacute;nero <span class="required">*</span></label>
                                                   <div class="controls">
	                                                   <f:select id="cboSexo" name="sexo" path="personaBean.sexo.codigoRegistro" class="form-control "  data-validation-required-message="Este campo es requerido" required="required" >
		                                                    <f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
		                                                	<f:options  items="${lstSexo}"
		                                                            itemValue="codigoRegistro"
		                                                            itemLabel="nombreCorto"/>
	                                                	</f:select>
	                                                </div>
                                              </div>

                                               <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Tel&eacute;fono / Celular <span class="required">*</span></label>
                                                  <div class="controls">
                                                  	<f:input type="text" id="telefonoUsuario" class="form-control" name="telefono"  path="personaBean.telefono" data-validation-required-message="Este campo es requerido" required="required" />
                                              	  </div>
                                              </div>
                                               <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Correo Electr&oacute;nico <span class="required">*</span></label>
                                                  <div class="controls">
                                                  	<f:input type="text" id="correoElectronico" class="form-control" name="correo" path="personaBean.correo" onKeyUp="this.value = this.value.toLowerCase();" data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" data-validation-regex-message="Ingresa un correo valido" data-validation-required-message="Este campo es requerido" required="required" />
                                              	  </div>
                                              </div>
                                              <div class="form-group col-md-3">
												        <label for="projectinput2">Estado Civil <span class="required">*</span></label>
														 <div class="controls">
		                                                   <f:select id="idestadocivil" name="estadocivil" path="personaBean.estadoCivil.codigoRegistro" class="form-control "  data-validation-required-message="Este campo es requerido" required="required" >
			                                                    <f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
			                                                	<f:options  items="${lstEstadoCivil}"
			                                                            itemValue="codigoRegistro"
			                                                            itemLabel="nombreCorto"/>
		                                                	</f:select>
	                                                	</div>
												</div>

                                          </div>
                                          <div class="row">

	                                          <div class="form-group col-md-4">
	                                          	<h5> Nacionalidad </h5>
	                                          </div>

	                                          <div class="form-group col-md-3">
	                                                 <h5> Lengua </h5>
	                                          </div>
                                          </div>
										  <div class="row">
										   <div class="form-group col-md-3">
                                                <label for="nacionalidad">Nacionalidad <span class="required">*</span></label>
                                                <label></label>

                                                <div class="controls">
                                                    <f:select id="nacionalidad" name="nacionalidad" path="personaBean.nacionalidad.codigoRegistro" class="form-control"  data-validation-required-message="Este campo es requerido"  >
		                                                <f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
		                                                <f:options  items="${lstNacionalidad}"
		                                                         itemValue="codigoRegistro"
		                                                         itemLabel="nombreCorto"/>
	                                            	</f:select>
                                            	 </div>
                                              </div>
                                             <div class="form-group col-md-1 " >
                                                  <%--<button type="submit" class="btn btn-outline-info btn-min" style="margin-top: 20px">--%>
                                                    <button type='button' class="btn btn-outline-info btn-min"  onclick="agregarNacionalidad();" style="margin-top: 20px"  >
                                                 <i class="ft-plus"></i></button>
                                              </div>
                                              <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Nombre Lengua  <span class="required">*</span></label>
                                                  <div class="controls">
                                                  		<f:select id="lblLengua" path="personaBean.lenguaBean.nombre" class="form-control selectReset"   data-validation-required-message="Este campo es requerido" >
																<f:option value="0" class="optionReset" label="Seleccionar" />
																<f:options items="${lstLenguaBean}" itemValue="codigo" itemLabel="nombre" />
												  		</f:select>
                                                  </div>
                                             </div>
                                              <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Categoria <span class="required">*</span></label>
                                                  <div class="controls">
                                                  		<f:select id="lblTipoLengua" path="personaBean.lenguaBean.descripcion" class="form-control selectReset"   data-validation-required-message="Este campo es requerido"  >
																<f:option value="0" class="optionReset" label="Seleccionar" />
																<f:options items="${lstTipoLengua}" itemValue="codigoRegistro"
		                                                         itemLabel="nombreCorto"/>
												  		</f:select>
                                                  </div>
                                             </div>
                                             	<div class="form-group col-md-2 " >
                                                  <%--<button type="submit" class="btn btn-outline-info btn-min" style="margin-top: 20px">--%>
                                                    <button type='button' class="btn btn-outline-info btn-min"  onclick="agregarLengua();" style="margin-top: 20px"  >
                                                 <i class="ft-plus"></i></button>
                                                </div>
										  </div>
                                          <div class="row">
										    <div class="col-xs-4">
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Nacionalidad</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="idlistadoNacionalidad">
                                                    <!--
                                                    	<tr>
                                                    		<td>Nacionalidad 1 </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
                                                    	</tr>
                                                    	<tr>
                                                    		<td>Nacionalidad 1 </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
                                                    	</tr>
                                                    	<tr>
                                                    		<td>Nacionalidad 1 </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
                                                    	</tr>
                                                       <!--  <c:forEach var="especialidadBean" items="${lstEspecialidad}">
		                                                  <tr>
		                                                    <td>${especialidadBean.lenguaBean.nombre}</td>
		                                                   	<td>${especialidadBean.tm2Nivel.nombreCorto} </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
		                                                  </tr>
                                                 		</c:forEach> -->
                                                    </tbody>
                                                </table>
                                              </div>
                                              <div class="col-xs-7">
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Nombre Lengua</th>
                                                            <th>Tipo Lengua</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="idlistadoLengua">
                                                    	<!--
                                                    	<tr>
                                                    		<td>Lengua 1 </td>
                                                    		<td>Lengua Materna </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
                                                    	</tr>
                                                    	<tr>
                                                    		<td>Lengua 2 </td>
                                                    		<td>Segunda Lengua </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
                                                    	</tr>
                                                    	<tr>
                                                    		<td>Lengua 3 </td>
                                                    		<td>Segunda Lengua </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
                                                    	</tr>
                                                        <!--<c:forEach var="especialidadBean" items="${lstEspecialidad}">
		                                                  <tr>
		                                                    <td>Nombre Lengua</td>
		                                                   	<td>${especialidadBean.tm2Nivel.nombreCorto} </td>
		                                                    <td><button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>
		                                                    </td>
		                                                  </tr>
                                                 		</c:forEach>-->
                                                    </tbody>
                                                </table>
                                              </div>

                                          </div>
                                          <div class="row">
                                          </br>
                                          </div>
                                           <div class="row">
                                            <div class="col-xs-12">
                                              <h5> DATOS EDUCACI&Oacute;N </h5>
                                              <br>
                                            </div>
                                          </div>
											<%--
                                           <div class="row">
											<div class="form-group col-md-3">
												        <label for="projectinput2">Región</label>
													         <f:select path="institucionBean.ubigeoBean.codigoRegion" onchange="buscarProvinciaInstitucion();" id="provinciaSelectinstitucion" class="form-control"  >
	                                                            <f:option value="00"   label="Seleccionar"/>
	                                                            <f:options  items="${lstRegionInstitucion}"
	                                                                        itemValue="codigoRegion"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                     	 </f:select>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Provincia</label>
													        <f:select path="institucionBean.ubigeoBean.codigoProvincia"  onchange="buscarDistritoInstitucion();" id="comboprovinciainstitucion" name="comboprovincia" class="form-control"  >
	                                                            <f:option value="00"   label="Seleccionar"/>
	                                                            <f:options  items="${lstProvinciaInstitucion}"
	                                                                        itemValue="codigoProvincia"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                       	</f:select>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Distrito</label>
													         <f:select path="institucionBean.ubigeoBean.codigoDistrito" id="combodistritoinstitucion" name="combodistritoinstitucion" class="form-control" >
	                                                            <f:option value="00"   label="Seleccionar"/>
	                                                            <f:options  items="${lstDistritoInstitucion}"
	                                                                        itemValue="codigoDistrito"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                     	  </f:select>
												</div>


                                          </div>
                                           --%>
										  <div class="row">
										   <div class="form-group col-md-9">
                                                <label for="situacionUsuario">Nombre de la Instituci&oacute;n <span class="required">*</span></label>
                                                <div class="controls">
	                                                <f:select id="lblInstitu" path="institucionBean.codigo" class="select2 form-control" required="required">
														<f:option value="0" class="optionReset" label="Seleccionar" />
														<f:options items="${lstInstitucionBean}" itemValue="codigo" itemLabel="nombreInstitucion"  />
													</f:select>
												</div>
                                              </div>
										  </div>

                                          <div class="row">
											<%--
                                              <div class="form-group col-md-3">
                                                <label for="situacionUsuario">Nivel</label>
                                                <div class="controls">
	                                                <f:select  path="tm2Nivel.codigoRegistro" class="select2 form-control" onchange="buscarGrado();" id="nivelSelect"  data-validation-required-message="Este campo es requerido" required="required">
														<f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
														<f:options items="${lstNivel}"
		                                                            itemValue="codigoRegistro"
		                                                            itemLabel="nombreCorto" />
													</f:select>
												</div>
                                              </div>
												--%>
                                              <div class="form-group col-md-3">
                                                <label for="situacionUsuario">Grado <span class="required">*</span></label>
                                                <div class="controls">
	                                                <f:select  path="tm2Grado.codigoRegistro"     id="gradoSelect"  class="select2 form-control"  data-validation-required-message="Este campo es requerido" required="required">
														<f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
														<f:options items="${lstGrado}"
		                                                            itemValue="codigoRegistro"
		                                                            itemLabel="nombreCorto" />
													</f:select>
												</div>
                                              </div>

                                               <div class="form-group col-md-6">
                                                  <label for="carrera">Programa o Carrera <span class="required">*</span></label>
                                                  <div class="controls">
	                                                 <f:select id="selectCarrera" path="tm2Programa.codigoRegistro" class="select2 form-control"  data-validation-required-message="Este campo es requerido" required="required">
														<f:option value=""  selected="true" disabled="disabled" label="Seleccionar"/>
														<f:options items="${lstCarrera}"
		                                                            itemValue="codigoRegistro"
		                                                            itemLabel="nombreCorto" />
													</f:select>
												</div>
                                              </div>

                                          </div>

                                           <div class="row">
                                            <div class="col-xs-12">
                                              <h5> DATOS DE RESIDENCIA  </h5>
                                              <br>
                                            </div>
                                          </div>



                                          <div class="row">
												<div class="form-group col-md-3">
												        <label for="projectinput2">Regi&oacute;n <span class="required">*</span></label>
												        <div class="controls">
													         <f:select path="ubigeoBean.codigoRegion" onchange="buscarProvincia();onColorVerde('#provinciaSelect');"   id="provinciaSelect" class="form-control" >
	                                                            <f:option value="00"  label="Seleccionar"/>
	                                                            <f:options  items="${lstRegion}"
	                                                                        itemValue="codigoRegion"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                     	 </f:select>
                                                     	 </div>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Provincia <span class="required">*</span></label>

													        <f:select path="ubigeoBean.codigoProvincia" onchange="buscarDistrito();onColorVerde('#comboprovincia');" id="comboprovincia" name="comboprovinciainstitucion"  class="form-control" >
	                                                            <f:option value="00"  label="Seleccionar"/>
	                                                            <f:options  items="${lstProvincia}"
	                                                                        itemValue="codigoProvincia"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                       	</f:select>

												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Distrito <span class="required">*</span></label>

													         <f:select path="ubigeoBean.codigoDistrito" id="combodistrito" onchange="onColorVerde('#combodistrito');" name="combodistritoinstitucion" class="form-control" >
	                                                            <f:option value="00"  label="Seleccionar"/>
	                                                            <f:options  items="${lstDistrito}"
	                                                                        itemValue="codigoDistrito"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                     	  </f:select>
												</div>

                                          </div>
										  <div class="row">
										  	<div class="form-group col-md-9">
                                                  <label for="direccion">Direcci&oacute;n <span class="required">*</span></label>
                                                  <div class="controls">
                                                  	<f:input type="text" id="direccion" class="form-control" name="direccion" path="personaBean.direccionPersona" data-validation-required-message="Este campo es requerido" maxlength="50" required="required"/>
                                              	  </div>
                                              </div>
										  </div>

                                          <div class="row">
                                              <div class="form-group col-md-12 text-right">
                                                  <button type="reset" id="limpiar" class="btn btn-secondary mr-1" onclick="limpiarCodigo();">
                                                    <i class="fa fa-eraser"></i> Limpiar
                                                  </button>
                                                    <!-- <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->
													<button id="confirm-text" type="submit"
                                       						class="btn btn-primary" onclick="validarRequired('#frmRegistroAlumno');" >
                                       						<i class="fa fa-floppy-o"></i>
                                       						Guardar
                                       				</button>
                                              </div>
                                          </div>
                                        </div>
                                      </form>
                                    </div>
                                  </div>
                              </div>
                          </div>
                        </f:form>
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
  
    <jsp:include page="../../layout/confirmacion-modal-view.jsp" />
    
    <script type="text/javascript">


	//Agregar Nacionalidad y Lengua en Memoria
	function agregarNacionalidad(){
		//Obtener el valor
		var codigoNacionalidad = document.getElementById("nacionalidad").value;
		//alert(codigoNacionalidad);
		//Obtener el texto
		var comboNacionalidad = document.getElementById("nacionalidad");
		var nombreNacionalidad = comboNacionalidad.options[comboNacionalidad.selectedIndex].text;
		//alert(nombreNacionalidad);
		if(listadoNacionalidad!=null && listadoNacionalidad.length>0){
			var repete = true;
			for(var i = 0; i < listadoNacionalidad.length; i++){
				//alert("listadoNacionalidad[i][0]"+listadoNacionalidad[i][0]);
				//alert("codigoNacionalidad"+codigoNacionalidad);
				if(listadoNacionalidad[i][0]==codigoNacionalidad || codigoNacionalidad==""){
					repete = false;
				}
			}
			if(repete){
				listadoNacionalidad.push([codigoNacionalidad,nombreNacionalidad]);
			}
		}else{
			if(codigoNacionalidad!=""){
				listadoNacionalidad.push([codigoNacionalidad,nombreNacionalidad]);
			}

		}
		refrescarNacionalidad();
		htmlTablaNacionalida = "";
		$('#idlistadoNacionalidad').empty();


		if(listadoNacionalidad!=null && listadoNacionalidad.length>0){
    		for (var i = 0; i < listadoNacionalidad.length; i++) {
	    		var prmNacionalidad = listadoNacionalidad[i];
	    		htmlTablaNacionalida +=
	    			"<tr>"+
	    			"<td>"+prmNacionalidad[1]+"</td>"+
	        		"<td>"+
	    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarNacionalidad('"+prmNacionalidad+"');\"><i class='icon-trash'></i></button>"+
	        		"</td>"+
	    		"</tr>";
	    		//$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
			}
  	    	$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
    	}

	}
	//codigo para remorver el item
	Array.prototype.removeItem = function (a) {
		 for (var i = 0; i < this.length; i++) {
		  if (this[i] == a) {
		   for (var i2 = i; i2 < this.length - 1; i2++) {
		    this[i2] = this[i2 + 1];
		   }
		   this.length = this.length - 1;
		   return;
		  }
		 }
		};

		function eliminarNacionalidad(item){
			itemNacionalidad = item;
			tipoItem = "nacionalidad";

	        $('#md_confirmacion').modal('show');
		}


		function eliminarModalNacionalidad(){
			//alert(item);
			//alert("indice:"+listadoNacionalidad.indexOf(item));
			//alert("ini:"+listadoNacionalidad);
			listadoNacionalidad.removeItem(itemNacionalidad);
			//alert("Fin:"+listadoNacionalidad);
			//alert("Eliminar:"+item[0]);
			//array.splice(1,1);
			refrescarNacionalidad();
			htmlTablaNacionalida = "";
			$('#idlistadoNacionalidad').empty();
			for (var i = 0; i < listadoNacionalidad.length; i++) {
	    		var prmNacionalidad = listadoNacionalidad[i];
	    		htmlTablaNacionalida +=
	    			"<tr>"+
	    			"<td>"+prmNacionalidad[1]+"</td>"+
	        		"<td>"+
	    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarNacionalidad('"+prmNacionalidad+"');\"><i class='icon-trash'></i></button>"+
	        		"</td>"+
	    		"</tr>";
	    		//$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
			}
			$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
		}
			
	function agregarLengua(){
		//Obtener el valor
		var codigoLengua = document.getElementById("lblLengua").value;
		//alert(codigoLengua);
		//Obtener el texto
		var comboLengua = document.getElementById("lblLengua");
		var nombreLengua = comboLengua.options[comboLengua.selectedIndex].text;
		//alert(nombreLengua);


		//Obtener el valor
		var codigoTipoLengua = document.getElementById("lblTipoLengua").value;
		//alert(codigoTipoLengua);
		//Obtener el texto
		var comboTipoLengua = document.getElementById("lblTipoLengua");
		var nombreTipoLengua = comboTipoLengua.options[comboTipoLengua.selectedIndex].text;
		//alert(nombreTipoLengua);


		var repete = true;
		if(listadoLengua!=null && listadoLengua.length>0){

			for(var i = 0; i < listadoLengua.length; i++){
				//alert("listadoNacionalidad[i][0]"+listadoNacionalidad[i][0]);
				//alert("codigoNacionalidad"+codigoNacionalidad);
				//alert(":v "+listadoLengua[i][0]);
				if(listadoLengua[i][0]==codigoLengua || (codigoLengua==""  && codigoTipoLengua!="")){
					repete = false;
				}
			}
			if(repete){
				var repeteLM = true;
				if(codigoTipoLengua == '1'){
					//alert(":v lengua materna...!");
					for(var i = 0; i < listadoLengua.length; i++){
						//alert(":v "+listadoLengua[i][0]);
						if(listadoLengua[i][2] == '1'){
							repeteLM = false;
							//msg_info(" Ya existe una lengua materna '"+listadoLengua[i][1]+"'");
						}
					}
					//if(repeteLM){
						listadoLengua.push([codigoLengua,nombreLengua,codigoTipoLengua,nombreTipoLengua]);
						refrescarLengua();
					//}
					//guardar lengua
				}else{
					listadoLengua.push([codigoLengua,nombreLengua,codigoTipoLengua,nombreTipoLengua]);
					refrescarLengua();
				}

			}
		}else{
			if(codigoLengua!="" && codigoTipoLengua!=""){
				listadoLengua.push([codigoLengua,nombreLengua,codigoTipoLengua,nombreTipoLengua]);
				refrescarLengua();
			}

		}
		//alert(listadoLengua);
		//listadoLengua.push([codigoLengua,nombreLengua,codigoTipoLengua,nombreTipoLengua]);
		//alert(listadoLengua);
		htmlTablaLengua = "";
		$('#idlistadoLengua').empty();
		refrescarLengua();
		if(listadoLengua!=null && listadoLengua.length>0){
    		for (var i = 0; i < listadoLengua.length; i++) {
	    		var prmLengua = listadoLengua[i];
	    		htmlTablaLengua +=
	    			"<tr>"+
	    			"<td>"+prmLengua[1]+"</td>"+
	    			"<td>"+prmLengua[3]+"</td>"+
	        		"<td>"+
	    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarLengua('"+prmLengua+"');\"><i class='icon-trash'></i></button>"+
	        		"</td>"+
	    		"</tr>";
	    		//$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
			}
			//alert(htmlTablaLengua);
  	    	$('#idlistadoLengua').html(htmlTablaLengua);
    	}

	}
	function eliminarLengua(item){
		itemLengua = item;
		tipoItem = "lengua";
        $('#md_confirmacion').modal('show');
	}


	function eliminarModalLengua(){
		//alert(item);
		//alert(item);
		//alert("indice:"+listadoNacionalidad.indexOf(item));
		//alert("ini:"+listadoLengua);
		listadoLengua.removeItem(itemLengua);
		//alert("Fin:"+listadoLengua);
		//alert("Eliminar:"+item[0]);
		//array.splice(1,1);
		htmlTablaLengua = "";
		$('#idlistadoLengua').empty();
		refrescarLengua();
		for (var i = 0; i < listadoLengua.length; i++) {
    		var prmLengua = listadoLengua[i];
    		htmlTablaLengua +=
    			"<tr>"+
    			"<td>"+prmLengua[1]+"</td>"+
    			"<td>"+prmLengua[3]+"</td>"+
        		"<td>"+
    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarLengua('"+prmLengua+"');\"><i class='icon-trash'></i></button>"+
        		"</td>"+
    		"</tr>";
		}
	    	$('#idlistadoLengua').html(htmlTablaLengua);
	}

	function refrescarLengua(){
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/alumnoController/refrescarLengua?listadoLengua="+listadoLengua,
	//			data : {codigoinst:numero},

			success : function(data) {
				console.log("SUCCESS: ", data);
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";


			},
			error : function() {
				console.log("ERROR: ");
			}
		});
	}

	function refrescarNacionalidad(){
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/alumnoController/refrescarNacionalidad?listadoNacionalidad="+listadoNacionalidad,
	//			data : {codigoinst:numero},

			success : function(data) {
				console.log("SUCCESS: ", data);
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";


			},
			error : function() {
				console.log("ERROR: ");
			}
		});
	}
	function mostrarTablaNacionalidad(){
		$('#idlistadoNacionalidad').empty();
		htmlTablaNacionalida = "";
		if(listadoNacionalidad!=null && listadoNacionalidad.length>0){
    		for (var i = 0; i < listadoNacionalidad.length; i++) {
	    		var prmNacionalidad = listadoNacionalidad[i];
	    		htmlTablaNacionalida +=
	    			"<tr>"+
	    			"<td>"+prmNacionalidad[1]+"</td>"+
	        		"<td>"+
	    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarNacionalidad('"+prmNacionalidad+"');\"><i class='icon-trash'></i></button>"+
	        		"</td>"+
	    		"</tr>";
	    		//$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
			}
	    	$('#idlistadoNacionalidad').html(htmlTablaNacionalida);
		}
	}
	function mostrarTablaLengua(){
		htmlTablaLengua = "";
		$('#idlistadoLengua').empty();
		for (var i = 0; i < listadoLengua.length; i++) {
    		var prmLengua = listadoLengua[i];
    		htmlTablaLengua +=
    			"<tr>"+
    			"<td>"+prmLengua[1]+"</td>"+
    			"<td>"+prmLengua[3]+"</td>"+
        		"<td>"+
    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarLengua('"+prmLengua+"');\"><i class='icon-trash'></i></button>"+
        		"</td>"+
    		"</tr>";
		}
	    $('#idlistadoLengua').html(htmlTablaLengua);
	}


   function formatoNumeroDocumento(){
		var tipoDocumento = $('#codigoTipoDocumento').val();
		if(tipoDocumento==1){
			$("#numeroDocumentoPersona").attr("pattern","[0-9]{8}");
			//$("#numeroDocumentoPersona").val("");
		}
		if(tipoDocumento==2){
			$("#numeroDocumentoPersona").attr("pattern","[a-zA-Z]{5,12}");
			//$("#numeroDocumentoPersona").val("");
		}
		if(tipoDocumento==3){
			 $("#numeroDocumentoPersona").removeAttr("pattern");
			 //$("#numeroDocumentoPersona").val("");
		}

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
		$('#codigoAlumno').val("0");
		$('#codigoPersona').val("0");

		listadoLengua = [];
		listadoNacionalidad = [];

		$('#idlistadoNacionalidad').empty();
		$('#idlistadoLengua').empty();
		
		
	}

	
	function validarGrabar(){
		return ejecutarGuardar;
	}


    
    $("#numeroDocumentoPersona").keyup(function(e){
   	   e.preventDefault();

	   var tipodocumento = $('#codigoTipoDocumento').val();
	   var numerodocumento = $('#numeroDocumentoPersona').val();
	   
	   //alert(tipodocumento);
       if(tipodocumento == "1" || tipodocumento == ""){
    	   if (numerodocumento.length > 7) {
      			validarAlumno();
      			}
       }else if(tipodocumento == "2"){
    	   if (numerodocumento.length > 5) {
      			validarAlumno();
      		}
       }
		
   	});



    //CLICK EN CONFIRMAR DEL MODAL
    $( "#btnConfirmarGeneric" ).click(function() {
        $('#md_confirmacion').modal('hide');
		if(tipoItem == "lengua"){
			eliminarModalLengua();
		}else if(tipoItem == "nacionalidad")	{
			eliminarModalNacionalidad();
		}
     });
    </script>
    </body>
</html>