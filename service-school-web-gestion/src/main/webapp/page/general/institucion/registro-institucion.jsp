<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro De Instituci&oacute;n</title>
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


   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">

    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>


<script type="text/javascript">

/*
	function buscarProvincia2(idDepartamento, idProvincia){
		console.log(idDepartamento + "- " + idProvincia);
		var id = $("#"+idDepartamento).val();
		$("#"+idProvincia).find('option').remove().end().append('<option value="00">Seleccionar</option>').val('00');
		$("#cbDistritoSede").find('option').remove().end().append('<option value="00">Seleccionar</option>').val('00');
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/baseController/buscarProvincia?codigodepartamento="+id,
		success : function(data) {
			console.log("SUCCESS: ", data);
			for(var i=0; i<data.length;i++){
				console.log(data[i].nombreUbigeo +"-"+ data[i].codigoProvincia);
				document.getElementById(idProvincia).options[document.getElementById(idProvincia).options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);
				}
		},
		error : function() {
			console.log("ERROR: ");
		}
	});

}

 function buscarDistrito2(idDepartamento, idProvincia,idDistrito){
		var id = $("#"+idDepartamento).val();
		var id2=$("#"+idProvincia).val();
		$("#"+idDistrito).find('option').remove().end().append('<option value="00">Seleccionar</option>').val('00');
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
		success : function(data) {
			console.log("SUCCESS: ", data);
			for(var i=0; i<data.length;i++){
				document.getElementById(idDistrito).options[document.getElementById(idDistrito).options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);
				}
		},
		error : function() {
			console.log("ERROR: ");
		}
	});

} */

function buscarProvinciaModalSede(){

	var id = $("#cbRegionSede").val();
	console.log(id);
	$.ajax({
		type : "GET",

		url : "${pageContext.request.contextPath}/baseController/buscarProvincia?codigodepartamento="+id,

		success : function(data) {
			console.log("SUCCESS: ", data);

			for(var i=0; i<data.length;i++){
				console.log(data[i].nombreUbigeo +"-"+ data[i].codigoProvincia);
				document.getElementById("cbProvinciaSede").options[document.getElementById("cbProvinciaSede").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);

				}
		},
		error : function() {
			console.log("ERROR: ");
		}
	});

}
function buscarDistritoModalSede(){

		var id  = $("#cbRegionSede").val();
		var id2 = $("#cbProvinciaSede").val();


	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/baseController/buscarDistrito?codigodepartamento="+id+"&codigoprovincia="+id2,

		success : function(data) {
			console.log("SUCCESS: ", data);
			for(var i=0; i<data.length;i++){

				document.getElementById("cbDistritoSede").options[document.getElementById("cbDistritoSede").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);

				}

		},
		error : function() {
			console.log("ERROR: ");
		}
	});

}

 function buscarProvincia(){
// 	 alert("hoa");
//		  var numero =document.getElementById("lblInstitu").value;
		var id = $("#provinciaSelect").val();
	console.log(id);
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
				console.log(data[i].nombreUbigeo +"-"+ data[i].codigoProvincia);
				document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);

				}


//
		},
		error : function() {
			console.log("ERROR: ");
		}
	});

}

 function buscarDistrito(){
// 	 alert("hoa");
//		  var numero =document.getElementById("lblInstitu").value;
		var id = $("#provinciaSelect").val();
		var id2=$("#comboprovincia").val();
		//alert(id);
	$.ajax({
		type : "GET",

		url : "${pageContext.request.contextPath}/baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
//			data : {codigoinst:numero},

		success : function(data) {
			console.log("SUCCESS: ", data);
// 			$('#provincia').html(data);
// 			alert(data[1].codigo);
// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

			for(var i=0; i<data.length;i++){

				document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);

				}

		},
		error : function() {
			console.log("ERROR: ");
		}
	});

}

 </script>






 <script type="text/javascript">
	$( document ).ready(function() {
// 		$( "#btnGrabarInstitucion" ).prop( "disabled", true );
		//document.getElementById("btnGrabarInstitucion").disabled = false;
		});
</script>

<script type="text/javascript">
function validarFrmDirector(contextController, idfrom) {
	
	var $myForm = $(idfrom);
	if(idfrom == "#frmRegistroUbicacion"){
		var departamento = document.getElementById("provinciaSelect");
		var provincia = document.getElementById("comboprovincia");
		var distrito = document.getElementById("combodistrito");
		
		if (!$myForm[0].checkValidity()||  departamento.value == "00" ||
				 provincia.value == "00" || distrito.value == "00") {
			 
			$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#provinciaSelect").css("color", "#16D39A");
			$("#comboprovincia").css("color", "#16D39A");
			$("#combodistrito").css("color", "#16D39A");
			
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
			
			
		} else {
			guardarGenericoTabsInstitucion(contextController, idfrom);
		}

	}else{
		if (!$myForm[0].checkValidity()) {
			msg_advertencia("Debe completar los campos requeridos correctamente");
		} else {
			guardarGenericoTabsInstitucion(contextController, idfrom);
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
                  <li class="breadcrumb-item"><a href="index.html">General</a>
                  </li>
                  <li class="breadcrumb-item active">Registro De Instituci&oacute;n
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
                                  <h4 class="card-title">Registro De Instituci&oacute;n</h4>
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
                                        <c:if test="${institucionForm.institucionBean.codigo!=null && institucionForm.institucionBean.codigo>0}">
                                        	<li class="nav-item">
	                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Ubicaci&oacute;n</a>
	                                        </li>
	                                        <li class="nav-item">
	                                          <a class="nav-link" id="base-tab13" data-toggle="tab" aria-controls="tab13" href="#tab13" aria-expanded="false">Informaci&oacute;n de Contacto</a>
	                                        </li>
	                                        <li class="nav-item">
	                                          <a class="nav-link" id="base-tab14" data-toggle="tab" aria-controls="tab14" href="#tab14" aria-expanded="false">Sedes / Filiales / Locales</a>
	                                        </li>
	                                        <li class="nav-item">
	                                          <a class="nav-link" id="base-tab15" data-toggle="tab" aria-controls="tab15" href="#tab15" aria-expanded="false">Lengua</a>
	                                        </li>
	                                        <li class="nav-item">
	                                          <a class="nav-link" id="base-tab16" data-toggle="tab" aria-controls="tab16" href="#tab16" aria-expanded="false">Operador Institucional (OI)</a>
	                                        </li>
                                        </c:if>
                                      </ul>
                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">


                                        <!-- Registrar institucion -->
                                         <f:form id="frmRegistroInstitucion" class="form-horizontal" role="form" method="post"
                                         action="${pageContext.request.contextPath}/institucionController/grabar">
                                 			  <div class="form-body">

                                 			  <input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
                                              <div class="row">

                                                  <div class="col-md-8">
                                                      <label for="nombreInstitucion">Nombre Instituci&oacute;n <span class="required">*</span> </label>
                                                      <fieldset class="form-group position-relative">
                                                      <div class="controls">
                                                          <f:input type="text" class="form-control"
                                                          id="nombreInstitucion" path="institucionBean.nombreInstitucion" onchange="validarExisteInstitucion();"
                                                          data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" onKeyUp="this.value = this.value.toUpperCase();"/>
                                                       </div>
                                                          <f:input type ="hidden" path="institucionBean.codigo"  id="codigoInstitucion"/>
                                                          <div class="form-control-position">
                                                          <i class="fa fa-building-o info font-medium-3"></i>
                                                          </div>
                                                      </fieldset>
                                                  </div>
                                                 <div class="form-group col-md-4 mb-2">
                                                  <div class="form-group">
                                                  <div class="controls">
                                                    <label for="nombreCorto">Nombre Corto <span class="required">*</span> </label>
                                                    <f:input type="text" id="nombreCortoinstitucion"  class="form-control" name="fname" path="institucionBean.nombreCorto"
                                                    data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" onchange="validarExisteNombreCorto();" onKeyUp="this.value = this.value.toUpperCase();"/>
                                                  </div>
                                                  </div>
                                                </div>



                          <!--
                                               <div class="form-group col-md-4 mb-2">
                                              <fieldset class="form-group">
                                                 <label for="situacionIdioma">Situaci&oacute;n</label>
                                                  <f:select  path="institucionBean.situacion.codigoRegistro" class="form-control">
                                                            <f:option value="0" label="Seleccionar"/>
                                                            <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                   </f:select>
                                              </fieldset>
                                                  </div>

                                                  -->
                                              </div>
                                              <div class="row">
                                                <div class="form-group col-md-4 mb-2">
                                                  <fieldset class="form-group">
                                                 <label for="tipoIdioma">Tipo <span class="required">*</span> </label>
                                                 <div class="controls">
                                                  <f:select  path="institucionBean.tipoInstitucion.codigoRegistro" class="form-control"
                                                  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstTipo}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                   </f:select>
                                                   </div>
                                              </fieldset>
                                                </div>
                                                <div class="form-group col-md-4 mb-2">

                                                <fieldset class="form-group">
                                                  <label >Tipo de Gestión <span class="required">*</span> </label>
                                                     <div class="controls">
                                                     <f:select path="institucionBean.tipoActividad.codigoRegistro" class="form-control"
                                                     data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstTipoActividad}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                     </f:select>
                                                     </div>
                               					</fieldset>
                                                </div>

                                               <div class="form-group col-md-4 mb-2">
                                              <fieldset class="form-group">
                                                 <label for="situacionIdioma">Situaci&oacute;n <span class="required">*</span> </label>
                                                  <div class="controls">
                                                  <f:select  path="institucionBean.situacion.codigoRegistro" class="form-control"
                                                  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                   </f:select>
                                                   </div>
                                              </fieldset>
                                                  </div>

                                <!--
                                				  <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">UGEL</label>
                                                    <f:input type="text"  class="form-control" name="fname" path="institucionBean.numeroUgel" />
                                                  </div>
                                                 </div>
                                                 -->
                                              </div>
                                              <div class="row">
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="codigoModular">C&oacute;digo Modular <span class="required">*</span> </label>
                                                    <div class="controls">
                                                    <f:input type="text"  class="form-control" name="fname" path="institucionBean.codigoModular"
                                                    data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" required="required"/>
                                                  </div>
                                                  </div>
                                                </div>
                                                <div class="col-md-4">

                                                  <div class="form-group mb-2">
                                                    <label for="codigoLocal">C&oacute;digo Local <span class="required">*</span> </label>
                                                    <div class="controls">
                                                    <f:input type="text"  class="form-control" name="fname"
                                                    path="institucionBean.codigoLocal" data-validation-required-message="Este campo es requerido"
                                                     pattern="[0-9]{1,}" required="required" />
                                                  </div>
                                                  </div>
                                            </div>

                                                  <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="ugel">DRE <span class="required">*</span> </label>
                                                    <div class="controls">
                                                    <f:input type="text"  class="form-control" name="fname" path="institucionBean.numeroUgel"
                                                    data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" required="required"/>
                                                  </div>
                                                  </div>
                                                 </div>
                                              </div>
                                              <div class="row">
                                                <div class="form-group col-md-12 mb-2">
                                                    <label for="descriptionInsticion">Descripci&oacute;n</label>
                                                    <f:textarea class="form-control" id="descriptionInsticion" rows="3" path="institucionBean.descripcion"></f:textarea>

                                                </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="reset" class="btn btn-secondary mr-1">
                                                        <i class="fa fa-eraser"></i> Limpiar
                                                      </button>

                                <%--id="btn-save-reg" --%>          	<button 	type="submit" id="btnGrabarInstitucion"
                                       			class="btn btn-flat btn-primary ">
                                       			<i class="fa fa-floppy-o"></i>
                                       			Guardar</button>


                                                  </div>
                                              </div>
                                            </div>
                                          </f:form>
                                           <!-- Fin Registrar institucion -->


                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">

                                        <!-- Inicio registrar Ubicacion -->

                                         <f:form id="frmRegistroUbicacion" onsubmit="return false" class="form-horizontal" role="form" method="post" action="modificarUbicacion">
                                            <f:input type="hidden" path="institucionBean.codigo"  id="codigoInstitucion"/>
                                            <div class="form-body">
                                              <div class="row">

                                                <div class="form-group col-md-4 mb-2">

                                                <fieldset class="form-group">
                                                  <label for="region">Regi&oacute;n <span class="required">*</span> </label>
                                                     <div class="controls">
                                                     <f:select path="institucionBean.ubigeoBean.codigoRegion" onchange="buscarProvincia();"
                                                      id="provinciaSelect"  class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="00" selected="true" disabled="disabled"  label="Seleccionar"/>
                                                            <f:options  items="${lstRegion}"
                                                                        itemValue="codigoRegion"
                                                                        itemLabel="nombreUbigeo"/>
                                                     </f:select>
                                                     </div>
                               					</fieldset>
                                                </div>


                                               <div class="form-group col-md-4 mb-2">

                                                <fieldset class="form-group">
                                                  <label for="provincia">Provincia <span class="required">*</span> </label>
                                                     <div class="controls">
                                                     <f:select path="institucionBean.ubigeoBean.codigoProvincia"
                                                     onchange="buscarDistrito();" id="comboprovincia" name="comboprovincia" class="form-control" data-validation-required-message="Este campo es requerido">
                                                            <f:option value="00" selected="true" disabled="disabled"  label="Seleccionar" />
                                                            <f:options  items="${lstProvincia}"
                                                                        itemValue="codigoProvincia"
                                                                        itemLabel="nombreUbigeo"/>

                                                     </f:select>
                                                     </div>
                               					</fieldset>
                                                </div>


                                                <div class="form-group col-md-4 mb-2">

                                                <fieldset class="form-group">
                                                  <label for="distrito">Distrito <span class="required">*</span> </label>
                                                     <div class="controls">
                                                     <f:select path="institucionBean.ubigeoBean.codigoDistrito" id="combodistrito"
                                                     name="combodistrito" class="form-control" data-validation-required-message="Este campo es requerido">
                                                            <f:option value="00" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstDistrito}"
                                                                        itemValue="codigoDistrito"
                                                                        itemLabel="nombreUbigeo"/>
                                                     </f:select>
                                                     </div>
                               					</fieldset>
                                                </div>

                                              </div>
                                              <div class="row">
                                                  <div class="col-md-12 mb-2">
                                                      <label for="direccion">Direcci&oacute;n <span class="required">*</span> </label>
                                                      <div class="controls">
                                                      <f:input type="text"  class="form-control" name="fname"
                                                      path="institucionBean.direccionInstitucion"
                                                      data-validation-required-message="Este campo es requerido" required="required"/>
                                                  </div>
                                                  </div>

                                              </div>
                                              <div class="row">


                                               <div class="form-group col-md-4 mb-2">
                                                <fieldset class="form-group">
                                                  <label for="areaGeografica">&Aacute;rea Geogr&aacute;fica <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select path="institucionBean.tipoAreaGeografica.codigoRegistro" class="form-control"
                                                     data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value=""  label="Seleccionar"/>
                                                            <f:options  items="${lstAreaGeografica}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>

                                                     </f:select>
                                                      </div>
                               					</fieldset>
                                                </div>


                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="latitud">Latitud </label>

                                                    <f:input type="text"  class="form-control" name="fname" path="institucionBean.latitud"
                                                     pattern="[0-9]{1,}" />

                                                  </div>
                                                </div>
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="longitud">Longitud </label>

                                                    <f:input type="text"  class="form-control" name="fname" path="institucionBean.longitud"
                                                     pattern="[0-9]{1,}" />

                                                  </div>
                                                </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="reset" class="btn btn-secondary mr-1">
                                                        <i class="fa fa-eraser"></i> Limpiar
                                                      </button>
                                           	   <button id="btn-save-reg" type="submit"
                                       			class="btn btn-flat btn-primary" onclick="validarFrmDirector('${pageContext.request.contextPath}/institucionController/','#frmRegistroUbicacion')">
                                       			<i class="fa fa-floppy-o"></i>
                                       			Guardar</button>
                                                    <!--    <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>-->
													<!-- onclick="guardarGenericoTabsInstitucion('${pageContext.request.contextPath}/institucionController/','#frmRegistroUbicacion')" -->
                                                  </div>
                                              </div>
                                            </div>
                                          </f:form>

                                          <!-- Fin registrar Ubicacion -->


                                        </div>
                                        <div class="tab-pane" id="tab13" aria-labelledby="base-tab13">
                                          <f:form id="frmActulizarDirector" onsubmit="return false" class="form-horizontal" role="form" method="post" action="insertarDirector" >
                                            <f:input type="hidden" path="institucionDirectorBean.codigo" id="codigo_director"/>
                                            <f:input type="hidden" path="institucionDirectorBean.institucion.codigo" id="codigoInstit_director"/>
                                            <f:input type="hidden" path="institucionDirectorBean.personaBean.codigo"  id="codigoPersona_director"/>
                                            <div class="form-body">
                                              <div class="row">
                                                  <div class="col-md-8 mb-2">
                                                      <label for="nombreInstitucion">Nombre Director(a) </label>
                                                      <div class="controls">
                                                      <f:input disabled="true" class="form-control" path="institucionDirectorBean.personaBean.nombreCompleto"
                                                       id="nombreDirectorSelecc" data-validation-required-message="Este campo es requerido"  pattern="[a-zA-Z]+" required="required"/>
                                                      <!--   <input type="text" id="nombreDirectorSelecc" disabled class="form-control" name="fname">-->
                                                  </div>
                                                  </div>
                                                  <div class="form-group col-md-2 mt-2">

                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" onclick="agregarInstitucionDirector();">
                                                        <i class="ft-search"></i> Buscar
                                                      </button>


                                                 <!--
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#bootstrap3">
                                                        <i class="ft-search"></i> Asignar
                                                      </button>
                                                       -->
                                                  </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-md-8">
                                                  <label >Web Institucional </label>

                                                  <fieldset class="form-group position-relative has-icon-left">

                                                      <f:input type="text" class="form-control" name="fname" id="urlDirector"
                                                      path="institucionDirectorBean.urlWeb" />

                                                      <div class="form-control-position">
                                                          <i class="icon-globe"></i>
                                                      </div>
                                                  </fieldset>
                                                </div>
                                                 <div class="form-group col-md-3 mb-2">
                                              <label for="situacionDirector">Situaci&oacute;n<span class="required">*</span> </label>

                                              <div class="controls">
                                              <f:select id="situacionDirector"  path="institucionDirectorBean.situacionDirector.codigoRegistro"
                                              class="form-control" data-validation-required-message="Este campo es requerido" required="required" >
                                                <f:option value=""  label="Seleccionar"/>
                                                <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                            </div>

                                            </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-md-6">
                                                  <label>Teléfono Institucional <span class="required">*</span> </label>
                                                  <fieldset class="form-group position-relative has-icon-left">
                                                      <div class="controls">
                                                      <f:input id="telefonoDirector" type="text" class="form-control" name="fname" path="institucionDirectorBean.telefono"
                                                      data-validation-required-message="Este campo es requerido"  required="required" pattern="[0-9]{1,}" maxlength="12"/>
                                                      </div>
                                                      <div class="form-control-position">
                                                          <i class="ft-phone"></i>
                                                      </div>
                                                  </fieldset>
                                                </div>
                                                <div class="col-md-6">

                                                  <div class="form-group">
                                                    <label>Correo Electr&oacute;nico Institucional  <span class="required">*</span> </label>
                                                   <div class="controls">
                                                    <fieldset class="form-group position-relative has-icon-left">
                                                        <div class="controls">
                                                        <f:input type="email"  class="form-control" name="fname" id="correoDirector"
                                                        path="institucionDirectorBean.correo" required="required" data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})"
                                                        data-validation-regex-message="Ingresa un correo valido" />
                                                        </div>
                                                        <div class="form-control-position">
                                                            <i class="icon-envelope"></i>
                                                        </div>
                                                    </fieldset>
                                                    </div>
                                                  </div>

                                                </div>

                                              </div>


                                              <div class="row">
                                                <div class="form-group col-md-12 mb-2">
                                                    <label for="descriptionInsticion">Descripci&oacute;n</label>
                                                    <f:textarea class="form-control" id="descripcionDirector" rows="3" path="institucionDirectorBean.descripcion"></f:textarea>

                                                </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="button" class="btn btn-secondary mr-1" onclick="limpiarDatoFormTabInst('#frmActulizarDirector')">
                                                        <i class="fa fa-eraser"></i> Limpiar
                                                      </button>

                                            	   <button id="btn-save-reg"
                                            	   		   type="submit"
                                            	   		   onclick="validarFrmDirector('${pageContext.request.contextPath}/institucionController/','#frmActulizarDirector');"
                                       					   class="btn btn-primary">
                                       			        <i class="fa fa-floppy-o"></i>
                                       			       Guardar</button>
                                                      <!-- <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>  -->


                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12" id="listadirectorBean">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="60">Fecha</th>
                                                              <th width="150">Director</th>
                                                              <th width="150">Web Institucional</th>
                                                              <th width="110">Teléfono institucional</th>
                                                              <th width="90">Correo</th>
                                                              <th >Descripci&oacute;n</th>
                                                              <th width="85">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idBodyListaInstDirector">
                                                      <c:forEach var="directorBean" items="${lstInstitucionDirectorBean}"  varStatus="loop">
                                                          <tr>
                                                          <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${directorBean.fechaCreacion}" /></td>
                                                              <td>${directorBean.personaBean.nombreCompleto}</td>
                                                              <td>
                                                                <i class="ft-map-pin media-left media-middle"></i>
                                                                <div class="media-body">${directorBean.urlWeb}</div>
                                                              </td>
                                                              <td> ${directorBean.telefono}</td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">${directorBean.correo}</div>
                                                                </div>
                                                              </td>
                                                              <td>${directorBean.descripcion}</td>
                                                              <td>
                                                              <button id="idBtnEditarLengua" type="button" onclick="cargarDatosDirector(${directorBean.codigo})"
                                         						class="btn btn-outline-success btn-sm" >
                                            					<i class="icon-pencil"></i></button>
                                                              <!--

                                                              <a title="Modificar"  data-placement="top" data-toggle="tooltip"
                                                              class="btn btn-outline-success btn-sm" href="modificarDirector?codigo=${institucionBean.codigo}">
                                                              <i class="icon-pencil"></i></a>

                                                              <button type="button" class="btn btn-outline-success btn-sm "
                                                                data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button> -->
                                                               <!-- <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminarDirector?codigo=${directorBean.codigo}"><i class="icon-trash"></i></a> -->
                                                               <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_eliminar('director',${directorBean.codigo});"><i class="icon-trash"></i></button>
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
										<!-- Inicio insertar Sede -->
										 <div class="tab-pane" id="tab14" aria-labelledby="base-tab14">
                                        <%--  <form class="form mt-1" id="frmTabSede"> --%>
														<div class="form-body">
															<div class="row">
																<div class="form-group col-md-12 text-right">
		                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" onclick="agregarInstitucionSede();">
		                                                        <i class="ft-search"></i> Asignar
		                                                      </button>
															</div>
															</div>

															<div class="row">
																<div class="col-xs-12" id="listaSedeBean">
																	<table
																		class="table table-striped table-bordered zero-configuration">
																		<thead>
																			<tr>
																				<th width="150">Nombre</th>
																				<th width="150">Ubicaci&oacute;n</th>
																				<th>Datos</th>
																				<th width="120">Acci&oacute;n</th>
																			</tr>
																		</thead>
                                                          <tbody id="idBodyListaInstSede">
													<c:forEach var="institucionSedeBean" items="${lstInstitucionSede}"  varStatus="loop">
														<tr>
															<td>${institucionSedeBean.nombreSede}</td>
															<td><i class="ft-map-pin media-left media-middle"></i>
																<div class="media-body">
																	${institucionSedeBean.ubigeoRegionBean.nombreUbigeo} /
																	${institucionSedeBean.ubigeoProvinBean.nombreUbigeo} /
																	${institucionSedeBean.ubigeoDistriBean.nombreUbigeo} <br>
																	${institucionSedeBean.direccionInstitucion}
																</div></td>
															<td>
																<div class="mb-0">
																	<i class="ft-map-pin media-left media-middle"></i>
																	<div class="media-body">${institucionSedeBean.telefono}</div>
																</div>
																<div class="mb-0">
																	<i class="icon-envelope media-left media-middle"></i>
																	<div class="media-body">${institucionSedeBean.correo}</div>
																</div>
																<div class="mb-0">
																	<i class="ft-info media-left media-middle"></i>
																	<div class="media-body">${institucionSedeBean.contacto}</div>
																</div>
															</td>
															<td>
																<button type="button" class="btn btn-outline-success btn-sm "
																	data-toggle="tooltip" onclick="modificarInstitucionSede(${institucionSedeBean.codigo})"
																	data-original-title="Editar">
																	<i class="icon-pencil"></i>
																</button>
																<button type="button" class="btn btn-outline-danger btn-sm "
																	data-toggle="tooltip" data-placement="top" title="" onclick="confirmar_eliminar('sede',${institucionSedeBean.codigo});"
																	data-original-title="Eliminar" >
																	<i class="icon-trash"></i>
																</button>
																<%-- onclick="eliminarInstitucionSede(${institucionSedeBean.codigo});"--%>
															</td>
														</tr>
													</c:forEach>
                                                      </tbody>
																	</table>
																</div>
															</div>
														</div>
												<%--	</form> --%>
                                        </div>
                                        <!-- Fin insertar Sede -->
                                        <!-- Inicio insertar lengua -->
                                        <div class="tab-pane" id="tab15" aria-labelledby="base-tab15">

                                          <f:form id="frmInsertarLengua" onsubmit="return false" class="form-horizontal" role="form" method="post" action="insertarLengua">
                                       <!--    <input type="hidden" path="institucionBean.codigo"  id="codigoInstitucion"/>  -->
                                            <div class="form-body">
         									<f:input type="hidden" path="institucionBean.codigo"  id="codigoInstitucion"/>
                                              <div class="row">

                                                  <div class="col-md-3 mb-2">
                                                  <fieldset class="form-group">
                                                    <label >Lengua <span class="required">*</span> </label>
                                                   <div class="controls">
                                                    <f:select id="codigoLengua" name="interested" class="form-control"
                                                    path="institucionLenguaBean.lenguaBean.codigo" data-validation-required-message="Este campo es requerido">
                                                        <f:option value="0" id="optionLengua" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                                </f:select>
                                                 </div>
                                                </fieldset>
                                                  </div>


                                                  <div class="form-group col-md-9 text-right ">

																	<button type="submit"
																		onclick="guardarGenericoTabsInstitucion('${pageContext.request.contextPath}/institucionController/','#frmInsertarLengua')"
																		class="btn btn-outline-secondary btn-min-width mt-2">
																		<i class="ft-search"></i> Agregar
																	</button>
																</div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12" id="listalenguaBean">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th>Lengua</th>
                                                              <th width="210">Fecha</th>
                                                              <th width="120">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idBodyListaInstLengua">
                                                      <c:forEach var="institucionLengua" items="${lstInstitucionLenguaBean}">
                                                          <tr>
                                                        	<td>${institucionLengua.lenguaBean.nombre}</td>
                                                        	<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${institucionLengua.fechaCreacion}" /></td>
                                                               <td class="text-sm-center">

                                                               <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"
                                                               onclick="confirmar_eliminar('lengua',${institucionLengua.codigo});"><i class="icon-trash"></i></button>


                                                       <!--       <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminarLengua?codigo=${institucionLengua.codigo}"><i class="icon-trash"></i></a>-->                                                                 <!--  <button type="button" class="btn btn-outline-danger btn-sm" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->
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
                                        <!-- Fin insertar lengua -->
                                        <div class="tab-pane" id="tab16" aria-labelledby="base-tab16">
                                          <%-- <form class="form mt-1"> --%>
                                            <div class="form-body">

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <!-- <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#bootstrap2">
                                                        <i class="ft-search"></i> Asignar
                                                      </button> -->
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" onclick="agregarInstitucionOperador();">
                                                        <i class="ft-search"></i> Asignar
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12" id="listaOperadorBean">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th >Nombres</th>
                                                              <th>Cargo</th>
                                                              <th>N&ordm; Documento</th>
                                                              <th width="150">Correo</th>
                                                              <th>Fecha Reg.</th>
                                                              <th width="120">Situaci&oacute;n</th>
                                                              <th width="80">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idBodyListaInstOperador">
                                                      	  <c:forEach var="instOperador" items="${lstInstitucionOperadorBean}">
                                                      	  	<tr>
                                                              <td>${instOperador.personaBean.nombreCompleto}</td>
                                                              <td>${instOperador.cargo.nombreCorto} </td>
                                                              <td>${instOperador.personaBean.numeroDocumento}</td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">${instOperador.personaBean.correo}</div>
                                                                </div>
                                                              </td>
                                                              <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${instOperador.fechaCreacion}" />
                                                               </td>
                                                              <td>${instOperador.nombreSituacion} </td>
                                                              <td>
                                                              	<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Editar" onclick="modificarInstitucionOperador(${instOperador.codigo});"><i class="icon-pencil"></i></button>
                                                             	<button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_eliminar('operador',${instOperador.codigo});"><i class="icon-trash"></i></button>
                                                              </td>
                                                          	</tr>
                                                      	  </c:forEach>
                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>
                                      </div>
                                          <%-- </form> --%>
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

    <!-- Modal -->
	<div class="modal fade text-xs-left" id="bootstrap" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						id="btnCloseSede" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Registro
							Sede / Filial / Local</b></label>
				</div>
		<!-- <f:form id="frmSede" onsubmit="return false"></f:form> -->
			 <div id="asignar_sede_modal_body"></div>
			</div>
		</div>
	</div>




    <!-- Modal 2 -->
                                          <div class="modal fade text-xs-left" id="bootstrap2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel25" aria-hidden="true">
                                             <div class="modal-dialog" role="document">
                                              <div class="modal-content">
                                                <div class="modal-header">
                                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                 <span aria-hidden="true">&times;</span>
                                                   </button>
                                                  <label class="modal-title text-text-bold-600" id="myModalLabel25"><b>Registro Operador Institucional</b></label>
                                                </div>
                                                <div id="asignar_operador_modal_body"></div>
      										  </div>
      										 </div>
    								      </div>

     <!-- Modal 3 -->
                                          <div class="modal fade text-xs-left" id="bootstrap3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel25" aria-hidden="true">
                                             <div class="modal-dialog" role="document">
                                              <div class="modal-content">
                                                <div class="modal-header">
                                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                 <span aria-hidden="true">&times;</span>
                                                   </button>
                                                  <label class="modal-title text-text-bold-600" id="myModalLabel25"><b>Asignar Director(a)</b></label>
                                                	<div id="asignar_director_modal_body"></div>
                                                </div>

      </div>
      </div>
    </div>


    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/registrar-modal-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>


    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/extended/form-typeahead.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/extended/form-inputmask.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/extended/form-maxlength.js" type="text/javascript"></script>


    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/general/institucion/registro-institucion-script.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/general/institucion/asignar-operador-institucional-modal-ajax-script.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/general/institucion/asignar-director-institucional-modal-ajax-script.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/general/institucion/asignar-sede-institucional-modal-ajax-script.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>


	<script>

	window.onload = function() {
	    document.getElementById('btnGrabarInstitucion').onclick = function() {
	        document.getElementById('frmRegistroInstitucion').submit();
	        
	        return false;
	    };
	};
	</script>
    <script type="text/javascript" charset="utf-8" >
    $(document).ready(function() {
			var msj = $("#mensaje").val();//1
			if (msj == '1') {
				 $("#parrafo").text("Probando la función ready()");
				msg_exito();
			} else if (msj == '0') {
				msg_error();
			}
		});


        var accion_tab = "";
		var codigoSede="";
		var codigoEliminar="";
		function confirmar_accion() {
			$('#md_confirmacion').modal('show');
		}
		function agregar_accion() {
			$('#md_reg_confirmacion').modal('show');
		}

		$("#btnConfirmarGeneric").click(function() {
			if (accion_tab.indexOf("eliminarSede") >= 0) {
				eliminarSede();
				accion_tab="";
			}else if(accion_tab.indexOf("director")>= 0 ){
				eliminarDirector();
				accion_tab="";
			}else if(accion_tab.indexOf("operador")>= 0){
				eliminarOperador();
				accion_tab="";
			}else if(accion_tab.indexOf("lengua")>= 0){
				eliminarLengua();
				accion_tab="";
			}else if(accion_tab.indexOf("sede")>= 0){										
				eliminarInstitucionSede();
				accion_tab="";
				}
		});
		$("#base-tab14").click(function() {
			console.log($("#codigoInstitucion").val());
			if($("#codigoInstitucion").val()==0){
				console.log("Acceso no autorizado");
				$("#base-tab11").trigger("click");
			} else {
				listarSedesInstitucion();
			}
		});

		function confirmar_eliminar(tabla, codigo){
			console.log("entro a coonfirmar eliminar");
			
			console.log("tabla " +tabla);
			accion_tab = tabla;
			codigoEliminar = codigo;
			$('#md_confirmacion').modal('show');
		
		}
		
		function eliminarDirector() {
			console.log("codigoEliminar" + codigoEliminar);
			$.ajax({
				url : "${pageContext.request.contextPath}/institucionController/eliminarDirector?codigo="+codigoEliminar,
				type : 'GET',
				success : function(data) {
					console.log("Se eliminó con éxito");
					$('#md_confirmacion').modal('hide');
					codigoEliminar = "";
					msg_exito();
					listarDirectorInstitucion();

				},
				error : function(msg) {
					console.log("errot:" + msg);
				}

			});
		}
		function eliminarOperador() {
			console.log("codigoEliminar" + codigoEliminar);
			$.ajax({
				url : "${pageContext.request.contextPath}/institucionController/eliminarInstOperador?codigo="+codigoEliminar,
				type : 'GET',
				success : function(data) {
					console.log("Se eliminó con éxito");
					$('#md_confirmacion').modal('hide');
					codigoEliminar = "";
					listarInstOperador();
					msg_exito();

				},
				error : function(msg) {
					console.log("errot:" + msg);
				}

			});
		}
		function eliminarInstitucionSede(id) {
			console.log("codigoEliminar" + codigoEliminar);			  
			  $.ajax({
			    type: "GET",
			    //data: "entidad=" + entidad,
			    url: "${pageContext.request.contextPath}/institucionController/eliminarSede?codigo="+codigoEliminar,
				success : function(data) {
					console.log("Se eliminó con éxito");
					$('#md_confirmacion').modal('hide');
					codigoEliminar = "";
					listarInstSede();
					msg_exito();

				},
				error : function(msg) {
					console.log("errot:" + msg);
				}
			  });
		}
		function eliminarLengua() {
			console.log("codigoLengua" + codigoEliminar);
			$.ajax({
				url : "${pageContext.request.contextPath}/institucionController/eliminarLengua?codigo="+codigoEliminar,
				type : 'GET',
				success : function(data) {
					console.log("Se eliminó con éxito");
					$('#md_confirmacion').modal('hide');
					codigoEliminar = "";
					listarLenguaInstitucion();
					msg_exito();
				},
				error : function(msg) {
					console.log("error:" + msg);
				}

			});
		}

		function listarInstOperador() {
			//	alert("codinst" + $("#codigoInstitucion").val())
				console.log("llega acá listarInstOperador");
				console.log("codinst:" + $("#codigoInstitucion").val());
				$.ajax({

					url : "${pageContext.request.contextPath}/institucionController/listarInstOperador?codigo="+$("#codigoInstitucion").val(),
					type : 'GET',
					success : function(data) {
						console.log("SUCCESS: ", data);
						$("#listaOperadorBean").empty();
						$("#listaOperadorBean").html(data);

					},
					error : function(data) {
						console.log("error de listaOperadorBean :" + data+ error);
					}

				});
			}
		function listarInstSede() {
			//	alert("codinst" + $("#codigoInstitucion").val())
				
				console.log("codinst:" + $("#codigoInstitucion").val());
				$.ajax({

					url : "${pageContext.request.contextPath}/institucionController/listarInstSede?codigo="+$("#codigoInstitucion").val(),
					type : 'GET',
					success : function(data) {
						console.log("SUCCESS: ", data);
						$("#listaSedeBean").empty();
						$("#listaSedeBean").html(data);

					},
					error : function(data) {
						console.log("error de listaSedeBean :" + data+ error);
					}

				});
			}

		function listarDirectorInstitucion() {
		//	alert("codinst" + $("#codigoInstitucion").val())
			console.log("llega acá listarDirectorInstitucion");
			console.log("codinst:" + $("#codigoInstitucion").val());
			$.ajax({

				url : "${pageContext.request.contextPath}/institucionController/listarDirector?codigo="+$("#codigoInstitucion").val(),
				type : 'GET',
				success : function(data) {
					console.log("SUCCESS: ", data);
					$("#listadirectorBean").html(data);

				},
				error : function(data) {
					console.log("error de listadirectorBean :" + data+ error);
				}

			});
		}
		function listarLenguaInstitucion() {

				console.log("llega acá listarLenguaInstitucion");
				console.log("codinst:" + $("#codigoInstitucion").val());
				$.ajax({

					url : "${pageContext.request.contextPath}/institucionController/listarLengua?codigo="+$("#codigoInstitucion").val(),
					type : 'GET',
					success : function(data) {
						console.log("SUCCESS: ", data);
						$("#listalenguaBean").html(data);

					},
					error : function(data) {
						console.log("error de listalenguaBean :" + data+ error);
					}

				});
			}
		function  validarExisteNombreCorto() {
			console.log("pasa");
			var nombreCorto = document.getElementById("nombreCortoinstitucion").value;
			
			$.ajax({

				url : "${pageContext.request.contextPath}/institucionController/existe?nombre="+nombreCorto,
				type : 'GET',
				success : function(data) {
				
				if(data == "1"){
					msg_advertencia("Existe nombre corto.");
					document.getElementById("btnGrabarInstitucion").disabled = true;
// 					document.getElementsByClassName("btnGrabarInstitucion").setAttribute("disabled","false");
					
				}else{
// 					document.getElementsByClassName("btnGrabarInstitucion").setAttribute("disabled","true");
					document.getElementById("btnGrabarInstitucion").disabled = false;
					}

				},
				error : function(data) {
					console.log("error de listalenguaBean :" + data+ error);
				}

			});

		}

		function validarExisteInstitucion(){

			var nombreInstitucion = document.getElementById("nombreInstitucion").value;
			$.ajax({

				url : "${pageContext.request.contextPath}/institucionController/existeInst?nombre="+nombreInstitucion,
				type : 'GET',
				success : function(data) {
				
				if(data == "1"){
					msg_advertencia("Existe nombre de Institución.");
					document.getElementById("btnGrabarInstitucion").disabled = true;
				}else{
					document.getElementById("btnGrabarInstitucion").disabled = false;
					}

				},
				error : function(data) {
					console.log("error de listalenguaBean :" + data+ error);
				}

			});

	}


	/*	function abrirCrearSede() {
			$.ajax({
				type : "get",
				url : "nuevoSede",
				data : {
					"codigo" : $("#codigoInstitucion").val()
				},
				success : function(msg) {
					$("#bootstrap #frmSede").empty();
					$("#bootstrap #frmSede").append(msg);
					$("#accionSede").val("1");
					$("#codigoSede").val("");
					//$("#codigoInst").val($("#codigoInstitucion").val());
				},
				error : function(msg) {
					console.log("errot:" + error);
				}
			});
			return false;
		}

		function listarSedesInstitucion() {
			console.log("llega acá");
			console.log("codinst:" + $("#codigoInstitucion").val());
			$.ajax({
				type : "get",
				url : "listarSedes",
				data : {
					"codigo" : $("#codigoInstitucion").val()
				},
				success : function(msg) {
					$("#contentTableSede table tbody").empty();
					$("#contentTableSede table tbody").html(msg);
				},
				error : function(msg) {
					console.log("errot:" + msg);
				}

			});
			return false;
		}

		function eliminarSede() {
			console.log("codsede" + codSede);
			$.ajax({
				type : "get",
				url : "eliminarSede",
				data : {
					"codigoInst" : $("#codigoInstitucion").val(),
					"codigoSede" : codSede
				},
				success : function(msg) {
					console.log("Se eliminó con éxito");
					$('#md_confirmacion').modal('hide');
					listarSedesInstitucion();
					codigo = "";
				},
				error : function(msg) {
					console.log("errot:" + msg);
				}

			});
			return false;
		}

		function crudSede(tipoAccion) {

			 $('#frmSede').find("input,textarea,select").not("[type=submit]").jqBootstrapValidation({
				preventSubmit: true,
	            submitError: function($form, event, errors) {
	                // additional error messages or events
	             	event.preventDefault();
	            },
	            submitSuccess: function($form, event) {
	                //event.preventDefault();
	                console.log($("#cbRegionSede").val() +"/" + $("#cbProvinciaSede").val() +"/"+$("#cbDistritoSede").val());
					$.ajax({
						type : "get",
						url : tipoAccion == 1 ? "grabarSede" : "actualizarSede",
						data : {
							"codigoSede" : tipoAccion == 1 ? "1" : $("#codigoSede").val(),
							"codigoInst" : $("#codigoInstitucion").val(),
							"nombreSede" : $("#nombreSede").val(),
							"telefono" : $("#telefono").val(),
							"correo" : $("#correo").val(),
							"direccion" : $("#direccion").val(),
							"contacto" : $("#contacto").val(),
							"codigoRegion" : $("#cbRegionSede").val(),
							"codigoProvincia" : $("#cbProvinciaSede").val(),
							"codigoDistrito" : $("#cbDistritoSede").val()

						},
						success : function(msg) {
							//console.log("msg:" + msg);
							console.log("Se actualizó con éxito");
							$("#bootstrap #frmSede").empty();
							$('#bootstrap').modal('hide');
							listarSedesInstitucion();
							codigoSede = "";
							msg_exito();

						},
						error : function(msg) {
							msg_error();
							console.log("errot:" + msg);
						},
						complete : function(){
							event.preventDefault();


						}

					});
					 event.preventDefault();
	            }

			});
			// event.preventDefault();

		} */

		function cargarDatosDirector(codigo) {

			 $.ajax({
				    type: "GET",
				    url: "modificarDirector?codigo="+codigo,
				    success: function(response){
				    	  if(response.codigo > 0){
				    		  $('#nombreDirectorSelecc').val(response.personaBean.nombreCompleto);
				    		  $('#codigo_director').val(response.codigo);
				    		  $('#codigoInstit_director').val(response.institucion.codigo);
				    		  $('#codigoPersona_director').val(response.personaBean.codigo);
				    		  $('#urlDirector').val(response.urlWeb);
				    		  $('#telefonoDirector').val(response.telefono);
				    		  $('#correoDirector').val(response.correo);
				    		  $('#descripcionDirector').val(response.descripcion);
				    	  }else{
				    		  alert("¡No se encontraron registros.!")
				    	  }
				    },error: function(xhr,status,er) {

				    }
				  });
		}

	/*	function mostrarDatosSede(codSede) {
			codigoSede =codSede;
			//$("#codigSede").val(codigoSede);
			//$("#codigoInst").val($("#codigoInstitucion").val());

			console.log("mostrarDatosSede" + codigoSede);
			$.ajax({
				type : "get",
				url : "modificarSede",
				data : {
					"codigoInst" : $("#codigoInstitucion").val(),
					"codigoSede" : codSede
				},
				success : function(msg) {
					//console.log("msg:" + msg);
					$("#bootstrap #frmSede").empty();
					$("#bootstrap #frmSede").html(msg);
					$("#accionSede").val("2");
					$("#codigoSede").val(codigoSede);
					$("#codigoInst").val($("#codigoInstitucion").val());
				},
				error : function(msg) {
					console.log("errot:" + msg);
					$("#accionSede").val("0");
				}

			});
			$('#bootstrap').modal('show');
			return false;
		}*/
    </script>
  </body>
</html>