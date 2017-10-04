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
    <title> Carga Masiva Material</title>
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
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
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

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">General</a>
                  </li>
                  <li class="breadcrumb-item active"> <a href="#">Material</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Carga Masiva Material</a>
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
                                  <h4 class="card-title">Carga Masiva Material</h4>
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

                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Generar</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Subir Documento</a>
                                        </li>
                                      </ul>

                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <f:form class="form mt-1">
                                            <div class="form-body">
                                              <input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
                                              <div class="row">
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="cmm_lengua">Lengua</label>
                                                  <f:select id="cmm_lengua" path="lengua.codigo" class="form-control" onchange="cargarNiveles()">
                                                    <f:option value="0" label="Todos" />
                                                    <f:options items="${lstLengua}"
	                                                    		itemValue="codigo"
	                                                    		itemLabel="nombre"/>
                                                  </f:select>
                                                </div>
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="cmm_nivel">Nivel</label>
                                                  <f:select id="cmm_nivel" path="nivel.codigoRegistro" class="form-control" onchange="cargarSubNiveles()">
                                                    <f:option value="0" label="Todos"/>
                                                    <%-- <f:options items="${lstNivel}"
                                                    			itemValue="codigoRegistro"
                                                    			itemLabel="nombreCorto"/> --%>
                                                  </f:select>
                                                </div>
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="cmm_sub_nivel">Sub Nivel</label>
                                                  <f:select id="cmm_sub_nivel" path="subNivel.codigoRegistro" class="form-control" onchange="cargarUnidades()">
                                                    <f:option value="0" label="Todos"/>
		                                            <%-- <f:options items="${lstSubNivel}"
		                                                    	itemValue="codigoRegistro"
		                                                    	itemLabel="nombreCorto"/> --%>
                                                  </f:select>
                                                </div>
                                                <div class="form-group col-md-3 mb-2" id="idDivContSelecUnidad" style="display: none;">
                                                  <label for="cmm_unidades">Unidades</label>
                                                  <f:select id="cmm_unidades" path="unidad.codigoRegistro" class="form-control">
                                                    <f:option value="0" label="Todos"/>
		                                            <f:options items="${lstUnidad}"
		                                                    	itemValue="codigoRegistro"
		                                                    	itemLabel="nombreCorto"/>
                                                  </f:select>
                                                </div>
                                              </div>


                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button onclick="mmr_limpiar()" type="button" class="btn btn-secondary mr-1">
                                                        <i class="ft-search"></i> Limpiar
                                                      </button>
                                                      <button type="button"
                                                      		  class="btn btn-primary"
                                                      	 	  id="generar-archivo"
                                                      	 	  onclick="generarArchivo()">
                                                      	 	<i class="fa fa-floppy-o"></i> Generar Archivo
                                                      </button>

                                                  </div>
                                              </div>

                                              <div id="detalle-archivo-generado"></div>

                                            </div>
                                          </f:form>

                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                          <div class="row">
                                            <div class="col-md-12 mt-1">
                                              <h5><!-- Recomendaciones -->Indicaciones</h5>
                                              <!-- <p>1.- El titulo del video ha de ser irresistible, keywords al principio y el branding al final. Ya se pueden incluir también #Hastag con la palabra clave principal.
													<br></br>
													2.- No te olvides de etiquetar el video como público (Cualquier usuario puede buscar y ver el video). Las otras opciones que tienes son:
													<br></br>
													Privado (Solo las personas que elijas pueden ver el vídeo)
													Oculto (Cualquier usuario que disponga del enlace al vídeo puede verlo)
													Programado (Sólo si tienes la cuenta autentificada)</p> -->
											  <p>1.- El archivo a subir debe ser de formato excel.
													<br></br>
													2.- Seleccionar el archivo.
													<br></br>
													3.- Presionar en "Subir Archivo".</p>
                                            </div>
                                          </div>
                                          <div class="row">
                                            <div class="col-md-12">
                                              <div class="bs-callout-info callout-border-right callout-square callout-right callout-bordered callout-transparent mt-1 p-1">
                                                <f:form id="idFormSubirCargaMasiva" class="form-horizontal" role="form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/cargaMasivaController/subirArchivo">
                                                	<input type="hidden" id="swMensajeResp" value="${swMensaje}">
                                                	<div class="row">
	                                                  <div class="col-sm-9">
	                                                    <fieldset class="form-group">
	                                                        <label for="basicInputFile">Cargar Archivo Excel</label>
	                                                        <f:input required="true" type="file" path="fileCarga" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" class="form-control-file" id="basicInputFile" />
	                                                    </fieldset>

														<fieldset class="form-group">
	                                                        <label for="basicInputFileRar">Cargar Archivo Rar</label>
	                                                        <f:input required="true" type="file" path="fileCargaRar" accept="application/zip" class="form-control-file" id="basicInputFileRar" />
	                                                    </fieldset>

	                                                    <progress id="barra_carga" class="progress progress-striped progress-success" value="0" max="100"></progress>

	                                                    <p id="pf_01" style="display: none"><span style="width: 70px;display: inline-block;">Lengua    : </span> Shawi <small>(1 registro)</small> ..... Cargo correctamente....... <button type="button" class="btn btn-icon btn-pure success mr-1"><i class="fa fa-check-circle"></i></button></p>
	                                                    <p id="pf_02" style="display: none"><span style="width: 70px;display: inline-block;">Nivel    : </span> Base  <small>(24 registro)</small> ..... Cargo correctamente.......  <button type="button" class="btn btn-icon btn-pure success mr-1"><i class="fa fa-check-circle"></i></button></p>
	                                                    <p id="pf_03" style="display: none"><span style="width: 70px;display: inline-block;">Sub Nivel    : </span> B1,B2,B3 <small>(01 registro)</small> ..... Error en data ............. <button type="button" class="btn btn-icon btn-pure danger mr-1"><i class="fa fa-exclamation-triangle"></i></button></p>
	                                                  </div>
	                                                  <div class="col-sm-3">
	                                                    <div class="form-group">
	                                                        <!-- <button onclick="time_contador()" class="btn btn-lg btn-block font-medium-1 btn-outline-success mt-1  mb-1 onblock-callback"><i class="ft-upload-cloud"></i> Subir Archivo</button> -->
	                                                    	<button type="button" onclick="subirArchivoCarga()" class="btn btn-lg btn-block font-medium-1 btn-outline-success mt-1  mb-1 onblock-callback"><i class="ft-upload-cloud"></i> Subir Archivo</button>
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
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
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
	<!-- BEGIN SCRIPT PERSONALIZADO -->
	<script src="${pageContext.request.contextPath}/assets/js/page/general/material/carga-masiva-script.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
	<!-- END SCRIPT PERSONALIZADO -->

	<script type="text/javascript" charset="utf-8" >
    	$(document).ready(function() {
			var msj = $("#swMensajeResp").val();
			if (msj == '1') {
				msg_exito();
			} else if (msj == '0') {
				msg_error();
			}
		});
	</script>

  </body>
</html>