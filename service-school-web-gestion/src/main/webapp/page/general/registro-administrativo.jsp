<%@ page contentType="text/html; charset=UTF-8" %>
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
    <title>Registro Administradores</title>
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
<%--    	<script src="${pageContext.request.contextPath}/assets/js/page/busqueda-ubigeo.js" type="text/javascript"></script> --%>

   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
  <script>

//   alert(document.getElementById('frmRegistroPersonal').addEventListener('submit', handleFileSelect, false)); 
  

  ejecutarGuardar = false;
  
  $( document ).ready(function() {

		var valor = $(".optionReset").val();
		if(valor=='0'){
			$(".optionReset").val("");
		}
		


	});

  prmRegion ="";
	 prmProvincia ="";
	 prmDistrito="";
	
	/*********************************/W


  function buscarProvincia(){
	
  	var codDep = $("#provinciaSelect").val();
  	var codPro = "";
  	buscarProvinciaXCodigos(codDep,codPro);
  	
  }






  	function buscarDistrito(){
  		
  		var codDep = $("#provinciaSelect").val();
  		var codPro=$("#comboprovincia").val();
  		var codDis=$("#combodistrito").val();
  		buscarDistritoXCodigos(codDep,codPro,codDis);
  	}
  	
  	
  	
  	
  	
  	
  	
  	
  	


  	function buscarProvinciaXCodigos(codDep,codPro){
  		
  		if(prmRegion!=$("#provinciaSelect").val()){
  			
  		
//  		 alert("hoa");
//  			  var numero =document.getElementById("lblInstitu").value;
  			var id = codDep;
  			var urlubigeo = $("#urlubigeo").val();
  			console.log(urlubigeo);
//  			for(var f=0;f<document.getElementById("comboprovincia").length;f++){
//  				if (document.getElementById("comboprovincia").length > 0) {

//  					document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
//  			    }

//  				}
  			document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").innerHTML=""];
  			document.getElementById("combodistrito").options[document.getElementById("combodistrito").innerHTML=""];
  			document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option("Seleccionar", "00");
  			document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option("Seleccionar", "00");
  		$.ajax({
  			type : "GET",

  			url : "../baseController/buscarProvincia?codigodepartamento="+id,
//  				data : {codigoinst:numero},

  			success : function(data) {
  				console.log("SUCCESS: ", data);


  				for(var i=0; i<data.length;i++){
  					document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);

  					}
  				
  				
  	//
  			},
  			error : function() {
  				console.log("ERROR: ");
  			},
  			complete : function(){
  				
  				if(codPro!=null && codPro!=""){
  					$("#comboprovincia").val(codPro);
  				}else{
  				
  					$("#comboprovincia").val("00");
  				}
  			
  			}
  			
  		});
  		
  	}

  	}




  	function buscarDistritoXCodigos(codDep,codPro,codDis){
  	
  		if(prmRegion!=$("#comboprovincia").val()){
  			
  	
//  			  var numero =document.getElementById("lblInstitu").value;
  			var id = codDep;
  			var id2=codPro;
  			document.getElementById("combodistrito").options[document.getElementById("combodistrito").innerHTML=""];
  			document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option("Seleccionar", "00");
  		$.ajax({
  			type : "GET",
  	///baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
  			url : "../baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
//  				data : {codigoinst:numero},

  			success : function(data) {
  				console.log("SUCCESS: ", data);
//  				$('#provincia').html(data);
//  				alert(data[1].codigo);
//  				document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

//  				for(var f=0;f<document.getElementById("combodistrito").length;f++){
//  					if (document.getElementById("combodistrito").length > 0) {
//  						document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
//  				    }

//  					}


  				for(var i=0; i<data.length;i++){

  					document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);

  					}

  			},
  			error : function() {
  				console.log("ERROR: ");
  			},
  			complete : function() {
  				if(codDis!=null && codDis!=""){
  					$("#combodistrito").val(codDis);
  				}
  			
  			}
  		});
  	}
  	}

  	
  	/*********************************/
  
function formatoDocumento(){
	var tipoDocumento = $('#codigoTipoDocumento').val();

	if(tipoDocumento==1){
		$("#numeroDocumentoPersona").attr("pattern","{12}");

		}

	if(tipoDocumento==2){
		$("#numeroDocumentoPersona").attr("pattern","{12}");

		}

	if(tipoDocumento==3){
		 $("numeroDocumentoPersona").removeAttr("pattern");
		}

}


function limpiarformpersonal(){
	document.getElementById("frmRegistroPersonal").reset();
	
}

			function registrarPersonal() {

				var url = $("#frmRegistroPersonal").attr("action"); //Capturar el action del form
				$.ajax({
					type : "POST",
					url : url,
					data : $("#frmRegistroPersonal").serialize(), // Serializar la data del form
					success : function(data) {
						document.location.href = 'listado';
					},
					error : function(xhr, status, er) {//msg_error();
						console.log("error: " + xhr + " status: " + status
								+ " er:" + er);
						if (xhr.status == 500) {
							console.log(er);
						}
						if (xhr.status == 901) {
							console.log(er);
						}
					},
					complete : function() {
					}
				});
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

// 			function justNumbers(e) {
// 				var numeroDocumento = $('#numeroDocumentoPersona').val();
// 				var tipoDocumento = $('#codigoTipoDocumento').val();
// 				if (tipoDocumento != 0) {
// 					if (tipoDocumento == 1) {
// 						if (numeroDocumento.length < 8) {
// 							var keynum = window.event ? window.event.keyCode
// 									: e.which;
// 							if ((keynum == 8) || (keynum == 46))
// 								return true;
// 							return /\d/.test(String.fromCharCode(keynum));
// 						} else {
// 							e.preventDefault();
// 						}
// 					}
// 				}
// 			}


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

			function buscarPersona(e) {
				
					var numerodocumento = $('#numeroDocumentoPersona').val();
					if (numerodocumento.length > 6
							&& numerodocumento.length < 13) {
						validarPersonal();
					}
				
			}


			function validarPersona() {

				var tipoDocumento = $('#codigoTipoDocumento').val();
				var numeroDocumento = $('#numeroDocumentoPersona').val();
				if (numeroDocumento == null && numeroDocumento == "") {
					numeroDocumento = 0;
				}
				$
						.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/personaController/validapersona?tipodocumento="
									+ tipoDocumento
									+ "&numerodocumento="
									+ numeroDocumento,
							success : function(data) {
								if (data.codigo != 0) {
									$('#codigoTipoDocumento').val(
											data.tipoDocumento.codigoRegistro);
									$('#numeroDocumentoPersona').val(
											data.numeroDocumento);
									$('#codigoPersona').val(data.codigo);
									/*$('#codigoPersonal').val();*/
									/*$('#situacionPersonal').val(data);*/
									$('#nacionalidadPersonal').val(
											data.nacionalidad.codigoRegistro);
									$('#nombrePersonal')
											.val(data.nombrePersona);
									$('#apellidoPaternoPersonal').val(
											data.apellidoPaterno);
									$('#apellidoMaternoPersonal').val(
											data.apellidoMaterno);
									var strFecha = convertirFecha(data.fechaNac);
									$('#strfechaNacimiento').val(strFecha);
									$('#lenguaMaterna').val(
											data.lenguaBean.codigo);

									/*$('#gradoPersonal').val(data.);*/
									/*$('#cargoPersonal').val();*/
									$('#sexoPersonal').val(
											data.sexo.codigoRegistro);
									$('#telefonoUsuario').val(data.telefono);
									$('#correoElectronico').val(data.correo);
									$('#provinciaSelect').val(
											data.ubigeoBean.codigoRegion);
									var codDep = data.ubigeoBean.codigoRegion;
									var codPro = data.ubigeoBean.codigoProvincia;
									var codDis = data.ubigeoBean.codigoDistrito;

									if (codDep != null && codDep != "") {
										buscarProvinciaXCodigos(codDep, codPro);
										$('#comboprovincia').val(codPro);
										if (codPro != null && codPro != "") {
											buscarDistritoXCodigos(codDep,
													codPro, codDis);
											$('#combodistrito').val(codDis);
										}
									}

									$('#direccionPersona').val(
											data.direccionPersona);

								}

							},
							error : function() {
								console.log("ERROR: ");
							}
						});
			}


			function validarPersonal() {

				var numeroDocumento = $('#numeroDocumentoPersona').val();
				if (numeroDocumento == null && numeroDocumento == "") {
					numeroDocumento = 0;

				}
				$
						.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/personalController/validaPersonal?numerodocumento="
									+ numeroDocumento,
							success : function(data) {
								if (data.codigo != 0) {
									$('#provinciaSelect')
											.val(
													data.personaBean.ubigeoBean.codigoRegion);
									$('#codigoTipoDocumento')
											.val(
													data.personaBean.tipoDocumento.codigoRegistro);
									$('#numeroDocumentoPersona').val(
											data.personaBean.numeroDocumento);
									$('#codigoPersona').val(
											data.personaBean.codigo);
									$('#codigoPersonal').val(data.codigo);
									$('#situacionPersonal')
											.val(
													data.situacionPersonal.codigoRegistro);
									$('#nacionalidadPersonal')
											.val(
													data.personaBean.nacionalidad.codigoRegistro);
									$('#nombrePersonal').val(
											data.personaBean.nombrePersona);
									$('#apellidoPaternoPersonal').val(
											data.personaBean.apellidoPaterno);
									$('#apellidoMaternoPersonal').val(
											data.personaBean.apellidoMaterno);
									var strFecha = convertirFecha(data.personaBean.fechaNac);

									$('#strfechaNacimiento').val(strFecha);
									$('#lenguaMaterna').val(
											data.personaBean.lenguaBean.codigo);
									$('#gradoPersonal').val(
											data.gradoPersonal.codigoRegistro);
									$('#cargoPersonal').val(
											data.cargoPersonal.codigoRegistro);
									$('#sexoPersonal')
											.val(
													data.personaBean.sexo.codigoRegistro);
									$('#telefonoUsuario').val(
											data.personaBean.telefono);
									$('#correoElectronico').val(
											data.personaBean.correo);
									var codDep = data.personaBean.ubigeoBean.codigoRegion;
									var codPro = data.personaBean.ubigeoBean.codigoProvincia;
									var codDis = data.personaBean.ubigeoBean.codigoDistrito;
									console.log("departamento: ", codDep);
									console.log("provincia: ", codPro);
									console.log("distrito: ", codDis);
									if (codDep != null && codDep != "") {
										buscarProvinciaXCodigos(codDep, codPro);
										$('#comboprovincia').val(codPro);
										if (codPro != null && codPro != "") {
											buscarDistritoXCodigos(codDep,
													codPro, codDis);
											$('#combodistrito').val(codDis);
										}
									}

									$('#direccionPersona').val(
											data.personaBean.direccionPersona);

								} else {

									validarPersona();

								}

							},
							error : function() {
								console.log("ERROR: ");
							}
						});
			}
			
			
			
		
		
		
		
		function fechaCorrecta(fecha1, fecha2){

		    //Split de las fechas recibidas para separarlas
		    var x = fecha1.split("/");
		    var z = fecha2.split("/");

		    //Cambiamos el orden al formato americano, de esto dd/mm/yyyy a esto mm/dd/yyyy
		    fecha1 = x[1] + "/" + x[0] + "/" + x[2];
		    fecha2 = z[1] + "/" + z[0] + "/" + z[2];

		    //Comparamos las fechas
		    if (Date.parse(fecha1) < Date.parse(fecha2)){
		        return false;
		    }else{
		        return true;
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
				var fechaActual = new Date();
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
							if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
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
					
					console.log(fecha.length);
				
					
					if(fechaCorrecta(fecha,convertirFecha(fechaActual))==true){
						fecha = convertirFecha(fechaActual);
						msg_advertencia("Por Favor ingrese una Fecha menor a la Actual");
						
						
					}
						
					
						
					
					
				}
				return (fecha);
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
            <li class="nav-item"><a href="index.html" class="navbar-brand"><img alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
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

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                   <li class="breadcrumb-item"><a href="#">General</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Registro de Gestor</a>
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
                                  <h4 class="card-title"> Registro de Gestores</h4>
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
                                      <f:form id="frmRegistroPersonal" onsubmit="return false" class="form-horizontal" role="form" method="post" action="grabar" novalidate="true" onSubmit="return validarGrabar()">
                                        <div class="form-body">
                                          <div class="row">
                                            <div class="col-xs-12">
                                              <h5>DATOS GENERALES</h5>
                                            </div>
                                          </div>

                                          <div class="row">
                                            <f:input type="hidden" path="codigo"  id="codigoPersonal"/>
                                            <f:input type="hidden" path="personaBean.codigo"  id="codigoPersona"/>

                                            <div class="col-md-3">
                                              <div class="form-group">
                                                <label for="situacionPersonal">Situaci&oacute;n <span class="required">*</span></label>
                                                <div class="controls">
                                                   <f:select id="situacionPersonal"  path="situacionPersonal.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
                                                                <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                                <f:options  items="${lstSituacion}"
                                                                            itemValue="codigoRegistro"
                                                                            itemLabel="nombreCorto"/>
                                                    </f:select>
                                                </div>
                                              </div>
                                            </div>

                                            <div class="col-md-3">
                                              <div class="form-group">
                                                <label for="situacionUsuario">Tipo Documento <span class="required">*</span></label>
                                                <div class="controls">
                                                  <f:select id="codigoTipoDocumento"  path="personaBean.tipoDocumento.codigoRegistro" class="form-control" onchange="formatoDocumento();" data-validation-required-message="Este campo es requerido" required="required" >
                                                            <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstTipoDocumento}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                </div>
                                              </div>
                                            </div>

                                            <div class="form-group col-md-3">
                                                <label for="projectinput2">N&uacute;mero Documento <span class="required">*</span></label>
                                                <div class="controls">
                                                  <f:input id="numeroDocumentoPersona" onkeypress="buscarPersona(event);return justNumbers(event);" type="text" class="form-control"  path="personaBean.numeroDocumento" data-validation-required-message="Este campo es requerido"   maxlength="12" required="required" />
                                              </div>
                                            </div>

                                            <div class="form-group col-md-3">
                                              <label for="situacionUsuario">Nacionalidad <span class="required">*</span></label>
                                                <div class="controls">
                                                    <f:select id="nacionalidadPersonal" path="personaBean.nacionalidad.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
                                                          <f:option value="" label="Seleccionar" selected="true" disabled="disabled"/>
                                                          <f:options  items="${lstNacionalidad}"
                                                                      itemValue="codigoRegistro"
                                                                      itemLabel="nombreCorto"/>
                                                      </f:select>
                                              </div>
                                            </div>
                                          </div>


                                          <div class="row">
                                              <div class="form-group col-md-3">
                                                  <label for="projectinput1">Nombres <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:input id="nombrePersonal" type="text" class="form-control" path="personaBean.nombrePersona" data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                                  </div>
                                              </div>

                                              <div class="form-group  col-md-3">
                                                  <label for="apellidopaterno">Apellido Paterno <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:input id="apellidoPaternoPersonal" type="text" class="form-control" path="personaBean.apellidoPaterno" data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                                  </div>
                                              </div>

                                              <div class="form-group col-md-3">
                                                  <label for="projectinput2">Apellido Materno <span class="required">*</span></label>
                                                  <div class="controls">
                                                      <f:input id="apellidoMaternoPersonal" type="text" class="form-control" path="personaBean.apellidoMaterno" data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                                  </div>
                                              </div>

                                              <div class="form-group col-md-3">
                                                  <label for="fechanacimiento">Fecha de Nacimiento <span class="required">*</span></label>
                                                  <div class="controls">
                                                   <f:input id="strfechaNacimiento"  name="fecha" type="text"  class="form-control"  onchange="cambiarfecha();" path="personaBean.strFechaNac" size="10" data-validation-required-message="Este campo es requerido" maxlength="10" onKeyUp = "this.value=formateafecha(this.value);" required="required"  />
<%--                                                     <f:input id="fechaNacimiento"  name="fecha" type="hidden"  class="form-control"   path="personaBean.fechaNac" size="10" maxlength="10" onKeyUp = "this.value=formateafecha(this.value);" /> --%>
                                                  </div>
                                              </div>
                                          </div>

                                          <div class="row">
                                              <div class="form-group col-md-3">
                                                  <label for="projectinput2">Grado o t&iacute;tulo <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:select  id="gradoPersonal" path="gradoPersonal.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstGrado}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                  </div>
                                              </div>

                                              <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Cargo <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:select id="cargoPersonal"  path="cargoPersonal.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstCargo}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                  </div>
                                              </div>
                                              
                                              
                                               <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Lengua Materna  <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:select id="lenguaMaterna"  path="personaBean.lenguaBean.codigo" class="form-control selectReset" data-validation-required-message="Este campo es requerido" required="required" >
                                                           <f:option value="0"  class="optionReset"  label="Seleccionar" />
                                                        
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                                        </f:select>
                                                  </div>
                                              </div>

                                           
                                             <div class="form-group col-md-3 mb-2">
                                                <label for="situacionUsuario">Perfil <span class="required">*</span></label>
                                                <div class="controls">

                                               <f:textarea path="personaBean.tipoPersona.nombreCorto"  class="form-control"  id="my-text-box" disabled="true" style="resize: none;"></f:textarea>

                                                </div>
                                             </div>


                                          </div>

                                          <div class="row">
                                              <div class="form-group col-md-3">
                                                  <label for="projectinput2">G&eacute;nero <span class="required">*</span></label>
                                                  <div class="controls">
                                                        <f:select id="sexoPersonal" path="personaBean.sexo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
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
                                                     <f:input id="telefonoUsuario" type="text" class="form-control" path="personaBean.telefono" data-validation-required-message="Este campo es requerido" required="required" />
                                                  </div>
                                              </div>

                                              <div class="form-group col-md-3">
                                                  <label for="correoElectronico">Correo Electr&oacute;nico <span class="required">*</span></label>
                                                  <div class="controls">
                                                      <f:input id="correoElectronico" type="email" class="form-control" path="personaBean.correo" required="true" data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" data-validation-regex-message="Ingresa un correo valido" data-validation-required-message="Este campo es requerido" required="required" />
                                                  </div>
                                              </div>
                                          </div>

                                          <div class="row">
                                            <div class="col-xs-12">
                                              <h5> DATOS DE RESIDENCIA </h5>
                                              <br>
                                            </div>
                                          </div>

                                           <div class="row">
                      												<div class="form-group col-md-3">
                      												        <label for="cboRegion">Región <span class="required">*</span></label>
                                                  <div class="controls">
                      												          <f:select  path="personaBean.ubigeoBean.codigoRegion" onchange="buscarProvincia();" id="provinciaSelect" class="form-control" required="required"  >
	                                                            <f:option value="00"   label="Seleccionar"/>
	                                                            <f:options  items="${lstRegion}"
	                                                                        itemValue="codigoRegion"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                     	 </f:select>
                                                  </div>
                      												</div>
                      												<div class="form-group col-md-3">
                      												        <label for="cboProvincia">Provincia <span class="required">*</span></label>
                                                  <div class="controls">
                      												        <f:select path="personaBean.ubigeoBean.codigoProvincia"  onchange="buscarDistrito();" id="comboprovincia" name="comboprovincia"  class="form-control"  required="required" >
	                                                            <f:option value="00"  label="Seleccionar"/>
	                                                            <f:options  items="${lstProvincia}"
	                                                                        itemValue="codigoProvincia"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                       	</f:select>
                                                  </div>
                      												</div>
                      												<div class="form-group col-md-3">
                      												        <label for="cboDisctrito">Distrito <span class="required">*</span></label>
                                                  <div class="controls">
                      												         <f:select path="personaBean.ubigeoBean.codigoDistrito" id="combodistrito" name="combodistrito" class="form-control" required="required"  >
	                                                            <f:option value="00"  label="Seleccionar"/>
	                                                            <f:options  items="${lstDistrito}"
	                                                                        itemValue="codigoDistrito"
	                                                                        itemLabel="nombreUbigeo"/>
	                                                     	  </f:select>
                                                </div>
                                              </div>
                      										</div>
                                           <div class="row">
                                               <div class="form-group col-md-9">
                                                  <label for="direccionPersona">Direcci&oacute;n <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:input id="direccionPersona" type="text" class="form-control" path="personaBean.direccionPersona" data-validation-required-message="Este campo es requerido"  maxlength="50" required="required" />
                                                  </div>
                                              </div>
                                          </div>

                                          <div class="row">
                                              <div class="form-group col-md-12 text-right">
                                                  <button type="button" onclick="limpiarformpersonal();" class="btn btn-secondary mr-1">
                                                    <i class="ft-search"></i> Limpiar
                                                  </button>
                                                  <button type="submit"  id="btnRegistroPersonal" class="btn btn-primary" onclick="validarRequired('#frmRegistroPersonal');">
                                                    <i class="ft-search"  ></i> Guardar
                                                  </button>
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
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

<script type="text/javascript">


function validarRequired(idfrom){
	
	var departamento = document.getElementById("provinciaSelect");
	var provincia = document.getElementById("comboprovincia");
	var distrito = document.getElementById("combodistrito");
	
	var $myForm = $(idfrom);
	if(! $myForm[0].checkValidity()  || departamento.value == "00" ||
			 provincia.value == "00" || distrito.value == "00") {


		$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");
	
		
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
	


	}else{

		ejecutarGuardar = true;		
		
		$(".optionReset").val("");
		registrarPersonal();
	}



}


function cambiarfecha(){

// 		var date = document.getElementById("strfechaNacimiento").value;


// 		document.getElementById("fechaNacimiento").value= date;
// 		alert(document.getElementById("fechaNacimiento").value);



}


document.getElementById("btnRegistroPersonal").addEventListener("click", function(){
	 
	
	 prmRegion =$('#provinciaSelect').val();
	 prmProvincia =$('#comboprovincia').val();
	 prmDistrito=$('#combodistrito').val();
	 

// 	  if($('#provinciaSelect').val()=="00"){
	
// // 		  $('#provinciaSelect').val("");
// 	  }
	  
// 	  if($('#comboprovincia').val()=="00"){

// 	  }
	  
// 	  if($('#combodistrito').val()=="00"){

// 	  }
});

</script>

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
		function validarGrabar(){
			return ejecutarGuardar;
		}
  	</script>
  
  </body>
</html>