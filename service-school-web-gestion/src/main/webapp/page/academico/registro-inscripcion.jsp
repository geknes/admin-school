<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro Inscripci&oacute;n</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">

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

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
           <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">

   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
   <%--  <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script> --%>
  <%-- <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script> --%>
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
<%-- 	 <script src="${pageContext.request.contextPath}/assets/js/page/generico-script.js" type="text/javascript"></script> --%>

<style type="text/css">
.ocul {
	display: none;
}

.mostrar {
	display: inherit !important;
}
</style>



<script type="text/javascript">


function cambiarfecha(){






}

function resetfrmRegistroDetDocumentoInstitucion() {

	document.getElementById('frmRegistroDetDocumentoInstitucion').reset();

}

function agregarDetDocumentoInscripcion() {
	  
	 
	  
		 var actionForm = $('#frmRegistroDetDocumentoInstitucion').attr("action");
     	var url = "${pageContext.request.contextPath}/inscripcionController/" + actionForm;
	 	 var $myForm = $('#frmRegistroDetDocumentoInstitucion');
	 	var dataee = new FormData(document.getElementById("frmRegistroDetDocumentoInstitucion")); 
	 	 
 		// validar todos los required
 		if(! $myForm[0].checkValidity()) {
 			 msg_advertencia("Debe completar los campos requeridos correctamente");
 		
 		}else{
			$.ajax({
						type : "POST",
						url : url,
						//data: $('#frmRegistroDetDocumentoInstitucion').serialize(),
						data: dataee,
						enctype: 'multipart/form-data',
					    processData: false,  // tell jQuery not to process the data
					    contentType: false,   // tell jQuery not to set contentType
					    dataType: 'json', // as you want
				success : function(data) {
				recargarListadoDetalleDocumentoInscripcion();
				console.log("SUCCESS: ", data);
				
				if (data=="1") {
					msg_info('Se agrego correctamente el archivo');
					resetfrmRegistroDetDocumentoInstitucion();
					/* $('#grupo-docente-modal').modal('hide'); */
					/* $("#bootstrap #frmSede").empty();
					$('#bootstrap').modal('hide'); */
				}else if(data=="0"){
					msg_advertencia('Errores 1');
	
					/* $('#grupo-docente-modal').modal('hide'); */
					/* $("#bootstrap #frmSede").empty();
					$('#bootstrap').modal('hide'); */
				}else {
					msg_advertencia('Ocurrio algo improvisto');
				}
	
				
			},
			error : function(xhr, status, er) {
			        console.log("error: " + xhr + " status: " + status + " er:" + er);
						msg_error();
						console.log("errot:" + data);
					}
		});
	 }
}


function validarRequired(idfrom){
    var $myForm = $(idfrom);
    if(! $myForm[0].checkValidity()) {
       msg_advertencia("Debe completar correctamente todos los campos requeridos");
    }
  }

$(document).ready(function() {
	var date1 = $('#strfechaNacimiento').val();

	$("#fechaNacimiento").val(date1);
	prmCodigo = "";
	prmNomAr = "";
	var tipoTab = "";
	var msj = $("#mensaje").val();//1
	if(msj=='1'){
		msg_exito();
	}else if(msj=='0'){
		msg_info("ya se registro anteriormente la inscripción");
	}




	var valor = $(".optionReset").val();
/* 	if(valor=='0'){ */
		$(".optionReset").val("");
	/* } */

	//cambiarfecha();
/* 	var d = date1;
	var str = $.datepicker.formatDate('yy-mm-dd', d);
	alert(str); */
 });


	function convertirFecha(fecha){
			var strFecha="";
		var fecha = new Date(fecha);
			var dia="";
			var mes="";
			if(fecha.getDate().toString().length==1){
					dia="0"+fecha.getDate().toString();
				}else{
					dia=fecha.getDate().toString();
					}
			if(fecha.getMonth().toString().length==1){
				mes="0"+(fecha.getMonth()+1);
			}else{
				mes=fecha.getMonth().toString();
				}
			return strFecha=dia+"/"+mes +"/"+fecha.getFullYear();
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

 	 function listadoDocentesXInscripcionLengua(){

// 		  var numero =document.getElementById("lblInstitu").value;
		var codigoInst =$('#idCodigoInstitucionInscLengua').val();
		var codigoInscLen =$('#idCodigoInscripcionLengua').val();
		var codigoInsc=0;
		var situacion = 1;
		var html = "";
		$.ajax({

			type : "POST",

			url : "${pageContext.request.contextPath}/docenteController/listadocentesasignados?codigoInst="+codigoInst+"&codigoinsclen="+codigoInscLen+"&codigoinsc="+codigoInsc+"&situacion="+situacion,
// 			data : {codigoinst:numero},

			success : function(data) {





  				for(var i=0;i<data.length;i++){

  					var fecha =convertirFecha(data[i].fechaCreacion);



  					html=html+"<tr><td>"+data[i].codigo+"</td><td>"+data[i].docenteBean.personaBean.nombrePersona +" "+ data[i].docenteBean.personaBean.apellidoPaterno+" "+data[i].docenteBean.personaBean.apellidoMaterno +"</td><td>"+data[i].docenteBean.personaBean.numeroDocumento+"</td><td>"+fecha+"</td><td><button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-success btn-sm'><i class='icon-trash'></i> </button></td></tr>";


  					}

  				document.getElementById("tablaListaDocentesAsignadosXLengua").innerHTML=html;





			},
			error : function() {
				console.log("ERROR: ");
			}
		});

 }



 	 function listadoDocentesDadosdeBaja(){

		var codigoInst =$('#idCodigoInstitucionInscLengua').val();
		var codigoInscLen =$('#idCodigoInscripcionLengua').val();
		var codigoInsc=0;
		var situacion = 2;
		var html = "";
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/docenteController/listadocentesasignados?codigoInst="+codigoInst+"&codigoinsclen="+codigoInscLen+"&codigoinsc="+codigoInsc+"&situacion="+situacion,
			success : function(data) {
  				for(var i=0;i<data.length;i++){

  					var fechaReg =convertirFecha(data[i].fechaCreacion);
  					var fechaBaj =convertirFecha(data[i].fechaBaja);

  					html=html+"<tr><td>"+data[i].codigo+"</td><td>"+data[i].docenteBean.personaBean.nombrePersona +" "+ data[i].docenteBean.personaBean.apellidoPaterno+" "+data[i].docenteBean.personaBean.apellidoMaterno +"</td><td>"+data[i].docenteBean.personaBean.numeroDocumento+"</td><td>"+fechaReg+" - "+fechaBaj+"</td></tr>";
//   					html=html+"<tr><td>"+data[i].codigo+"</td><td>"+data[i].docenteBean.personaBean.nombrePersona +" "+ data[i].docenteBean.personaBean.apellidoPaterno+" "+data[i].docenteBean.personaBean.apellidoMaterno +"</td><td>"+data[i].docenteBean.personaBean.numeroDocumento+"</td><td>"+data[i].fechaCreacion+" - "+data[i].fechaBaja"</td></tr>";
  					}
  				document.getElementById("tablaDocentesDadosdeBaja").innerHTML=html;

			},
			error : function() {
				console.log("ERROR: ");
			}
		});

 }





function bajaDocenteAsignado(id){


	$.ajax({

		type : "POST",

		url : "${pageContext.request.contextPath}/docenteController/darbajadocenteasignado?codinscdocente="+id,
//			data : {codigoinst:numero},

		success : function(data) {

// 				alert(data);
				listadoDocentesXInscripcionLengua();
				listadoDocentesDadosdeBaja();
		},
		error : function() {
			console.log("ERROR: ");
		}
	});


}
 	 function abrirModal(){

		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/docenteController/listadodocente",

			success : function(data) {


				$('#docente-modal-registro').html(data);
				$('#docente-modal-registro').modal('show');
				buscarDocentexFiltros();

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
		
			
			if(fechaCorrecta(fecha,convertirFecha(fechaActual))==false){
				fecha = convertirFecha(fechaActual);
				msg_advertencia("Por Favor ingrese una Fecha Mayor a la Actual");
				
				
			}
				
			
				
			
			
		}
		
		
		return (fecha);
	}

	function justNumbers(e)
	{
	   var keynum = window.event ? window.event.keyCode : e.which;
	   if ((keynum == 8) || (keynum == 46))
	        return true;
	    return /\d/.test(String.fromCharCode(keynum));
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
                   <li class="breadcrumb-item"><a href="#">Académico</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Registro Inscripci&oacute;n</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
         <input type="hidden" value="${swMensaje}"  id="mensaje"  />
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title"> Registro de Inscripci&oacute;n</h4>
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

                           <!--            /***********************************************/-->
                                        <li class="nav-item" id="tabGeneral1" onclick="desactivarAsignarDocente();">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11"  aria-expanded="true">General</a>
                                        </li>
                                        <li class="nav-item ocul"  id="tabAsignarDocente" >
                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Asignar Docente</a>
                                        </li>
                          <!--            /***********************************************/-->

                                      </ul>

                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <%-- <form class="form mt-1"> --%>
                                           <f:form id="frmRegistroInstitucion" class="form-horizontal" role="form" method="post" action="grabar"> <!-- enctype="multipart/form-data" -->
                                            <div class="form-body">
												<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
                                              <div class="row">
                                                <div class="form-group col-md-6">
                                                      <label for="lblInstitu">Instituci&oacute;n <span class="required">*</span></label>
													   	<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
													   	<f:input type="hidden" path="inscripcionBean.codigo"  id="codigoInscripcion"/>
                                                      <div class="controls">
                                                        <f:select id="lblInstitu" path="inscripcionBean.institucion.codigo" class="form-control selectReset" data-validation-required-message="Este campo es requerido" required="required">
															<f:option  value="0" class="optionReset" label="Seleccionar" />
															<f:options items="${lstInstitucionBean}" itemValue="codigo" itemLabel="nombreInstitucion" />
														</f:select>
													</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="lblSituacion">Situaci&oacute;n <span class="required">*</span></label>
                                                    <div class="controls">
                                                    	<f:select id="lblSituacion" path="inscripcionBean.situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" label="Seleccionar" />
															<f:options items="${lstSituacion}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
														</f:select>
														</div>
                                                  </div>

                                              </div>

                                              <div class="row">
                                               <div class="form-group col-md-3 mb-2">
                                                    <label for="lblPeriodo">Per&iacute;odo <span class="required">*</span></label>
                                                    <div class="controls">
                                                    <f:select id="lblPeriodo" path="inscripcionBean.periodo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" label="Seleccionar" />
															<f:options items="${lstPeriodo}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
													</div>
                                                  </div>
                                              	<div class="form-group col-md-3 mb-2">
                                                    <label for="lblCiclo">Semestre <span class="required">*</span></label>
                                                    <div class="controls">
                                                    <f:select id="lblCiclo" path="inscripcionBean.ciclo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" label="Seleccionar" />
															<f:options items="${lstCiclo}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
													</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                  <label for="projectinput1">Fecha Limite <span class="required">*</span></label>
                                                      <div class="controls">
                                           			<fmt:formatDate value="${inscripcionForm.inscripcionBean.fechaRegistro}" var="dateString" pattern="dd/MM/yyyy" />
                				                	<f:input id="strfechaNacimiento"  name="fecha" type="text"  class="form-control" path="inscripcionBean.fechaRegistro" value="${dateString}" size="10" maxlength="10" onkeyup = "this.value=formateafecha(this.value);"  required="required"/>
                				               	 </div>
                				                </div>
                                        </div>
                                        
                                         
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      	<button type="button" class="btn btn-secondary mr-1" onclick="window.location='${pageContext.request.contextPath}/inscripcionController/nuevo'">
                                         				   <i class="fa fa-eraser"></i> Limpiar
                                          				</button>
                                          				<button id="btn-save-reg"	type="submit"
                                       						class="btn btn-flat btn-primary" onclick="validarRequired('#frmRegistroInstitucion');">
                                       						<i class="fa fa-floppy-o"></i>
                                       					Guardar
                                       					</button>
                                                  </div>
                                                  </div>
                                              </div>

											</f:form>
											
										<c:if test="${inscripcionForm.inscripcionBean.codigo > 0}">
										<f:form id="frmRegistroDetDocumentoInstitucion" class="form-horizontal"  method="post" action = "grabarDetDocumInscrip" onsubmit="return false"> <!--enctype="multipart/form-data"   -->
										
                                        <hr>
											<div class="row">
											<f:input type="hidden" path="inscripcionBean.codigo"  id="codigo"/>
												<%-- <f:input type="hidden" id="idRutaDoc" class="form-control" path="inscripcionBean.rutaDocumento"/> --%>
											  	  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero del Documento <span class="required">*</span></label>
                                                      <div class="controls">
                                                      <f:input type="text" id="numeroDocumentotxt"  class="form-control" path="documentoInscripcionBean.numedocu" onkeypress="return justNumbers(event);" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" required="required"/>

                                                	 </div>
                                                  </div>
                                                 <%-- <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento==null}"> --%>
                                                 <div class="form-group col-md-5">
                                                  <label for="">Subir Documento <span class="required">*</span></label>
                                                  <f:input type="file" id="file" class="form-control" name="file" path="documentoInscripcionBean.file" data-validation-required-message="Este campo es requerido" required="required"/>
                                                 </div>
                                               <%--  </c:if> --%>
                                             <%--    <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento!=null}">
                                                 <div class="form-group col-md-5">
                                                  <label for="">Subir Documento </label>
                                                  <input type="file" id="file" class="form-control" name="file" >
                                                 </div>
                                                </c:if> --%>

												<div class="form-group col-md-3">
												 	<div class="botonDA" style="margin-top: 25px;">
												 	<button id="btn-save-reg"	type="submit"
                                       						class="btn btn-info" onclick="agregarDetDocumentoInscripcion()">
                                       						<i class="fa fa-plus"></i>
                                       					Agregar
                                       				</button>
												 	
													<!-- <a href="#" class="btn btn-info"><i class="fa fa-plus"></i> </span> </a> -->
												   	<!-- onclick="descargarArchivo()" <a  download="Archivo">Descargar Archivo</a>-->
                                                 	</div>
                                                 </div>
                                     <%--             <div class="form-group col-md-9">
                                                  <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento!=null && swMensaje!=0}">

                                                  <a id="idlink" target="_Blank" onclick="descargarArchivo();">
                                                    <div class="link link_derecho">
                                                   <img class="media-object" border="0" align="middle" name="contenedorRuta" src="${pageContext.request.contextPath}/assets/img/archivoDescarga.png"
                                                  style="width: 50px;height: 50px;" id="contenedorRuta"/>
                                                  <div style="margin-top: -35px;margin-left: 59px;">Descargar Archivo </div>
                                                  </div>
                                                  </a>
												 </c:if>
												 </div> --%>
                                              </div>
                                            </f:form>
                                              <div class="row">
                                              		<div class="col-xs-7" id="listadoDetalleDocumentoInscripcion">
                                              		    <table class="table table-striped table-bordered zero-configuration">
                                                <thead>

                                                    <tr>
                                               			<th width="10">Item</th>
                                                        <th width="20"># Docum.</th>
                                                        <th width="40">Nombre Archivo</th>
                                                        <th width="20">Descargar</th>
                                                        <th width="20">Acción</th>
                                                    </tr>

                                                </thead>
                                                <tbody id="idTablaDetalleDocumentoInscripcion" >
													<c:forEach var="documentoInscripcionBean" items="${lstDocumentoInscripcionBean}" varStatus="theCount">
									                      <tr>
									                      	  <td>${theCount.count}</td>
									                          <td>${documentoInscripcionBean.numedocu}</td>
									                          <td>${documentoInscripcionBean.nombdocu}</td>
									                          <td>
									                           <!--  <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Descargar" data-placement="top" data-toggle="tooltip" target="_Blank" href="${documentoInscripcionBean.rutadocu}" download="${documentoInscripcionBean.rutadocu}"><i class="fa fa-download"></i> Descargar</a>
									                          </td>
									                          <td>
									                           <!--  <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacionDetDocumentoInscripcion('${documentoInscripcionBean.codigo}','${documentoInscripcionBean.nombdocu}')"><i class="icon-trash"></i></a>
									                          </td>
									                      </tr>
									                  </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th width="10">Item</th>
                                                        <th width="20"># Docum.</th>
                                                        <th width="40">Nombre Archivo</th>
                                                        <th width="20">Descargar</th>
                                                        <th width="20">Acción</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                              		</div>
                                              </div>
                                            
                                         </c:if> 
                                         
                                         <c:if test="${inscripcionForm.inscripcionBean.codigo > 0}">

                                          <div class="form-body">
                                          <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#bootstrap" onclick="lenguaCargarModal()">
                                                      <i class="icon-plus"></i> Agregar Lengua
                                                      </button>
                                                  </div>
                                              </div>
                                          <div class="row">
								            <div class="col-xs-12" id="listadoDetalleInscripcion">
								              <table class="table table-striped table-bordered zero-configuration">
								                  <thead>
								                      <tr>
								                      	  <th>Item</th>
								                          <th>Lengua</th>
								                          <th width="250">N&uacute;mero de Cupos</th>
								                          <th width="150">Acci&oacute;n</th>
								                      </tr>
								                  </thead>
								                  <tbody>
								                  <c:forEach var="inscripcionLenguaBean" items="${lstInscripcionLenguaBean}" varStatus="theCount">
								                      <tr>
								                      	   <td>${theCount.count}</td>
								                          <td>${inscripcionLenguaBean.lenguainscr.nombre}</td>
								                          <td>${inscripcionLenguaBean.numeroCuposInsc}</td>
								                            <td>
                                                          <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" onclick="modificarLengua(${inscripcionLenguaBean.codigo})"><i class="icon-pencil"></i></a>
                                                         <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacionDet(${inscripcionLenguaBean.codigo})"><i class="icon-trash"></i></a>
                                                         <!--    ******************   -->
                                                         <a title="Asignar Docente" data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" onclick="activarAsignarDocente(${inscripcionLenguaBean.codigo} , ${inscripcionLenguaBean.institucion.codigo},'${inscripcionLenguaBean.lenguainscr.nombre}');"><i class="icon-arrow-right"></i></a>
                                                       <!--    ******************   -->
                                                        </td>
								                      </tr>


								                      </c:forEach>



								                  </tbody>
								              </table>
								            </div>
         								 </div>
         								 </div>
         								          </c:if>
                                    	</div>
                                        <div id="modal">
                                        </div>



                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                          <f:form class="form mt-1">
                                          <f:input type="hidden"  id="idCodigoInscripcionLengua" path=""/>
                                            <f:input type="hidden"  id="idCodigoInstitucionInscLengua" path=""/>
                                            <div class="form-body">
                                              <div class="row">
                                              <div class="form-group col-md-6 text-left">
                                                     <div id="nombreInscripcionLengua" class="card-title"></div>
                                                  </div>
                                                  <div class="form-group col-md-6 text-right">
                                                      <button type="button" onclick="agregar_docente()" class="btn btn-primary"><i class="icon-plus"></i> Agregar Docente</button>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="40">C&oacute;digo</th>
                                                              <th>Nombres Docentes</th>
                                                              <th>N&uacute;mero Doc.</th>
                                                              <th>Fecha Inscripci&oacute;n</th>
                                                              <th width="60">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="tablaListaDocentesAsignadosXLengua">



                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <h5>Historial </h5>
                                                  <br>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="40">C&oacute;digo</th>
                                                              <th>Nombres Docentes</th>
                                                              <th>N&uacute;mero Doc.</th>
                                                              <th>Fecha (Inscripci&oacute;n / Baja)</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="tablaDocentesDadosdeBaja">

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






	<!-- ******************************************************** -->
    <div class="modal fade text-xs-left" id="docente-modal-registro" tabindex="-2" role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal" aria-hidden="true" style="overflow-y: scroll;">


</div>

<!-- Comienzo Ubigeo -->
						<div class="modal fade text-xs-left" id="ubigeo-modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<label class="modal-title text-text-bold-600"
											id="myModalLabel3555"><b>Busqueda Ubigeo</b></label>
									</div>
									<f:form class="form">
										<div class="modal-body">
											<div class="row">
												<div class="col-md-12 ">

													<div class="col-md-4 mb-2">
														<label>Departamento</label>
													</div>
													<div class="col-md-8 mb-2">
														<input id="nombreDepartamento" type="text" class="form-control"
															name="fname">
													</div>



												</div>


												<div class="col-md-12 ">

													<div class="col-md-4 mb-2">
														<label>Provincia</label>
													</div>
													<div class="col-md-8 mb-2">
														<input id="nombreProvincia" type="text" class="form-control"
															name="fname">
													</div>



												</div>

												<div class="col-md-12 ">

													<div class="col-md-4 mb-2">
														<label>Distrito</label>
													</div>
													<div class="col-md-8 mb-2">
														<input id="nombreDistrito" type="text" class="form-control"
															name="fname">
													</div>



												</div>

												<div class="form-group col-md-4 text-right">
													<button type="button" onclick="buscarUbigeo();"
														class="btn btn-secondary mt-2">
														<i class="ft-search"></i> Buscar
													</button>
												</div>
											</div>

											<div class="row"  style="overflow: auto;max-height: 300px;">
												<div class="col-xs-12">
													<table
														class="table table-striped table-bordered zero-configuration">
														<thead>
															<tr>
																<th>Codigo Ubigeo</th>
																<th>Nombre de Ubigeo</th>


																<th width="50">Acci&oacute;n</th>
															</tr>
														</thead>
														<tbody id="tablaListaUbigeo">





														</tbody>
													</table>
												</div>
											</div>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-outline-secondary"
												onclick="cerrar_ubigeo();" data-dismiss="modal">Salir</button>
										</div>
									</f:form>
								</div>
							</div>
						</div>


<!-- Fin Ubigeo -->
<!-- <div id="docente-modal-registrott"></div> -->

    <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="#" target="_blank" class="text-bold-800 grey darken-2">Natigu </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy Business</span></p>
    </footer>

	<!-- MODAL -->
	<div class="modal fade text-xs-left" id="bootstrap" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						id="btnCloseSede" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Agregar Lengua y Cupos</b></label>
				</div>
				 <f:form id="frmSede" onsubmit="return false"></f:form>
			</div>
		</div>
	</div>


<%--     <jsp:include page="${pageContext.request.contextPath}/../layout/docente-registro-modal-view.jsp" />
     <jsp:include page="${pageContext.request.contextPath}/../layout/inscripcion-lengua-registro-modal-view.jsp" /> --%>

	<!-- <script src="https://code.jquery.com/jquery-1.10.2.js"></script> -->

    <!-- BEGIN VENDOR JS-->

    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
       <jsp:include page="../../layout/confirmacion-modal-view.jsp" />
    <!-- BEGIN PAGE VENDOR JS-->
        <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
<%--     <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script> --%>
    <!-- END PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/academico/inscripcion.js" type="text/javascript"></script>

<script>

    function lenguaCargarModal() {
		  var numero =document.getElementById("lblInstitu").value;
		  var codP =document.getElementById("lblPeriodo").value;
		  var codC =document.getElementById("lblCiclo").value;
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/inscripcionController/lenguaCargarModal",
			data : {codigoinst:numero,codPerio:codP,codCiclo:codC},

			success : function(data) {
				console.log("SUCCESS: ", data);

				$("#bootstrap #frmSede").empty();
				$("#bootstrap #frmSede").append(data);
				$(".optionReset").val("");

				//$('#modal').html(data);
			//	$('#inscripcion-lengua-modal-registro').modal('show');
			},
			error : function() {
				console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});
		return false;

	}

    function refrescarTablaDetalleInscripcion() {
		  var id =document.getElementById("codigoInscripcion").value;
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/inscripcionController/recargarListadoxInscripcion",
			data : {codigo:id},

			success : function(data) {
				console.log("SUCCESS: ", data);
				$('#listadoDetalleInscripcion').html(data);
			},
			error : function() {
				console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});

	}
    

    function recargarListadoDetalleDocumentoInscripcion() {
		  var id =document.getElementById("codigoInscripcion").value;
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/inscripcionController/recargarListadoDetalleDocumentoInscripcion",
			data : {codigo:id},

			success : function(data) {
				console.log("SUCCESS: ", data);
				$('#listadoDetalleDocumentoInscripcion').html(data);
			},
			error : function() {
				console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});

	}

    function agregarLengua() {
		  var codlen =document.getElementById("lblLenguamodal").value;
		  var nCupos =document.getElementById("numCupos").value;
		  var id =document.getElementById("codigoInscripcion").value;
		  var status = '';



		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/inscripcionController/agregarlengua",
			data : {numCupos:nCupos,codigolengua:codlen,codigoinscri:id},

			success : function(data) {
				refrescarTablaDetalleInscripcion();
				console.log("SUCCESS: ", data);
				status=data;
				if (data=="1") {
					msg_info("Se agrego la lengua");
					$('#inscripcion-lengua-modal-registro').modal('hide');
				}else if(data=="2"){
					msg_info("Se actualizo la Lengua");
					$('#inscripcion-lengua-modal-registro').modal('hide');
				}else if(data=="3"){
					msg_info("No se Puede Actualizar Ya que tiene Alumnos Matriculados");
					$('#inscripcion-lengua-modal-registro').modal('hide');
				}else if(data=="4"){
					msg_info("Los numeros de Cupos Son Iguales");
					$('#inscripcion-lengua-modal-registro').modal('hide');
				}else {
					msg_advertencia("Ocurrio un error");
				}


			},
			error : function() {
				console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});

	}

    function modificarLengua(cod) {
  	 	 var id =cod;
  	 	 var numero =document.getElementById("lblInstitu").value;
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/inscripcionController/modificarInscripcionxLengua",
			data : {codigo:id,codigoinst:numero},

			success : function(data) {
				console.log("SUCCESS: ", data);
				/* $('#modal').html(data);
				$('#inscripcion-lengua-modal-registro').modal('show'); */
				$("#bootstrap #frmSede").empty();
				$("#bootstrap #frmSede").append(data);
				$(".optionReset").val("");
				$('#bootstrap').modal('show');
			},
			error : function() {
				console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});
	}

    function eliminarLengua(cod) {
//eliminarLengua(${inscripcionLenguaBean.codigo})
		  var id =cod;
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/inscripcionController/eliminarInscripcionxLengua",
			data : {codigo:id},

			success : function(data) {
				refrescarTablaDetalleInscripcion();
				console.log("SUCCESS: ", data);
				//$('#modal').html(data);
				if (data>0) {
					msg_info("Se elimino la lengua");
					console.log('Se elimino la lengua');

				}else {
					msg_advertencia("Ocurrio un error");
				}


			},
			error : function() {
				console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});

	}
    
    function eliminarDetDocumentoInscripcion(cod,nom) {
    	
    			  var id =cod;
    			  var nomA = nom;
    			$.ajax({
    				type : "POST",

    				url : "${pageContext.request.contextPath}/inscripcionController/eliminarDetalleDocumentoInscripcion",
    				data : {codigo:id,nombArch:nomA},

    				success : function(data) {
    					recargarListadoDetalleDocumentoInscripcion();
    					console.log("SUCCESS: ", data);
    					if (data>0) {
    						msg_info("Se elimino el archivo Correctamente");
    						console.log('Se elimino el archivo Correctamente');

    					}else {
    						msg_advertencia("Ocurrio un error");
    					}


    				},
    				error : function() {
    					console.log("ERROR: ");
    					msg_advertencia("Ocurrio un error");
    				}
    			});

    		}

    function crudSede() {

   	 var codlen =document.getElementById("lblLenguamodal").value;
   	  var nCupos =document.getElementById("numCupos").value;
   	  var id =document.getElementById("codigoInscripcion").value;
   	  var codigoN=document.getElementById("cmm_nivel").value;

   	/*  $('#frmSede').find("input,select").not("[type=submit]").jqBootstrapValidation({
   		preventSubmit: true,
         submitError: function($form, event, errors) {
             // additional error messages or events
          	event.preventDefault();
         }, */
    /*      submitSuccess: function($form, event) { */
             //event.preventDefault();
         var $myForm = $('#frmSede');
   		// validar todos los required
   		if(! $myForm[0].checkValidity()) {
   			 msg_advertencia("Debe completar los campos requeridos correctamente");
   		}else{
   			$.ajax({


   				type : "POST",
   				url : "${pageContext.request.contextPath}/inscripcionController/agregarlengua",
   				data : {numCupos:nCupos,codigolengua:codlen,codigoinscri:id,codigonivel:codigoN},
   				success : function(data) {


   					refrescarTablaDetalleInscripcion();
   					console.log("SUCCESS: ", data);

   					if (data=="1") {
   						msg_info("Se agrego la lengua");
   						$("#bootstrap #frmSede").empty();
   						$('#bootstrap').modal('hide');
   					}else if(data=="2"){
   						msg_info("Se actualizo la Lengua");
   						$("#bootstrap #frmSede").empty();
   						$('#bootstrap').modal('hide');
   					}else if(data=="3"){
   						msg_info("No se Puede Actualizar Ya que tiene Alumnos Matriculados");
   						$("#bootstrap #frmSede").empty();
   						$('#bootstrap').modal('hide');
   					}else if(data=="4"){
   						msg_info("Los numeros de Cupos Son Iguales");
   						$("#bootstrap #frmSede").empty();
   						$('#bootstrap').modal('hide');
   					}else {
   						msg_advertencia("Ocurrio un error");
   					}

   					//msg_exito();

   				},
   				error : function(data) {
   					msg_error();
   					console.log("errot:" + data);
   				}

   			});
   			/*  event.preventDefault(); */
       /*   } */

   /* 	}); */
   	// event.preventDefault();
   	}
   }
	</script>
   <script type="text/javascript" charset="utf-8">



   function agregar_docente(){

	   abrirModal();


    listado_docente_modal();
   }

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



   function activarAsignarDocente(idinsclengua,idinsitucion,nombrelengua){

// 	   alert(idinsclengua + "" + nombrelengua);
	   document.getElementById("tabAsignarDocente").className ="nav-item mostrar";
	   document.getElementById("tabAsignarDocente").innerHTML="<a class='nav-link active' id='base-tab12' data-toggle='tab' aria-controls='tab12' href='#tab12' aria-expanded='true'>Asignar Docente</a>";
	   document.getElementById("tabGeneral1").innerHTML="<a class='nav-link' id='base-tab11' data-toggle='tab' aria-controls='tab11' href='#tab11' aria-expanded='false'>General</a>";
	   document.getElementById("tab11").className ="tab-pane";
	   document.getElementById("tab12").className ="tab-pane active";

	   document.getElementById("nombreInscripcionLengua").innerHTML=nombrelengua;
	   document.getElementById("idCodigoInscripcionLengua").value=idinsclengua;
	   document.getElementById("idCodigoInstitucionInscLengua").value=idinsitucion;

	   listadoDocentesXInscripcionLengua();
		listadoDocentesDadosdeBaja();
	   }




   function desactivarAsignarDocente(){

// 	   alert(idinsclengua + "" + nombrelengua);
	   document.getElementById("tabAsignarDocente").className ="nav-item ocul";
// 	   document.getElementById("tabAsignarDocente").innerHTML="<a class='nav-link active' id='base-tab12' data-toggle='tab' aria-controls='tab12' href='#tab12' aria-expanded='true'>Asignar Docente</a>";
	   document.getElementById("tabGeneral1").innerHTML="<a class='nav-link active' id='base-tab11' data-toggle='tab' aria-controls='tab11' href='#tab11' aria-expanded='false'>General</a>";
	   document.getElementById("tab11").className ="tab-pane active";
	   document.getElementById("tab12").className ="tab-pane ";


	   }


	$(document).ready(function(){





		 $("#frmregistromodal").submit(function(e) { // id del formulario


					e.preventDefault();
						var postData = $(this)
								.serializeArray();

						var formURL = $(this).attr("action"); //${pageContext.request.contextPath}/usuarioController/guardarNuevaClaveUsuario

						$.ajax({

									url : formURL,
									type : "POST",
									data : postData,
									success : function(
											data) {

										$("#btn_regresar_doc_modal")
												.trigger(
														"click");

										 // iddel boton cerrar modal

										/*$(
												".form-group-result-update.help-blocks")
												.css(
														"display",
														"block"); // accion de retorno, solo si esnecesario*/

									},

									error : function(
											request,
											status,
											error) {

										/*$(
												".form-group-result-update.help-blocks-error-upd")
												.css(
														"display",
														"block");*/
										console
												.log(error);

									}

								})
						return false;

//	 					e.preventDefault();

					});


	});

       function listado_docente_modal(){
    	    $("#listado_docente_modal").show();
    	    $("#regisro_docente_modal").hide();
    	    $("#btn_regresar_doc_modal").hide();
    	 }


       function confirmar_accion(codigo){
           prmCodigo = codigo;
           tipoTab="1";
           $('#md_confirmacion').modal('show');
        }
       
       function eliminarConfirmacionDet(codigo) {
    	      //almacenar datos
    	  		 prmCodigo = codigo;
    	  		tipoTab="2";
    			//mostrar modal
    			$('#md_confirmacion').modal('show');


    	}
       
       function eliminarConfirmacionDetDocumentoInscripcion(codigo,nomar) {
 	      //almacenar datos
 	  		 prmCodigo = codigo;
 	      	 prmNomAr=nomar;
 	  		 tipoTab="3";
 			//mostrar modal
 			$('#md_confirmacion').modal('show');


 		}
       
       

       $( "#btnConfirmarGeneric" ).click(function(e) {
    	   if (tipoTab=="1") {
    			bajaDocenteAsignado(prmCodigo);
    	 		  $('#md_confirmacion').modal('hide');  
    	 		 e.stopPropagation();
   			  return;
    	   }else if(tipoTab=="2"){
    		   eliminarLengua(prmCodigo);
    		   $('#md_confirmacion').modal('hide');
    		   e.stopPropagation();
 			  return;
    	   }else if(tipoTab=="3"){
    		   eliminarDetDocumentoInscripcion(prmCodigo,prmNomAr);
    		   $('#md_confirmacion').modal('hide');
    		   e.stopPropagation();
 			  return;
    	   }
    		   
      	
 		});



    </script>
  </body>
</html>