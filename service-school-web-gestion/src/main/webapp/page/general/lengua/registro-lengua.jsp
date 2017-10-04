<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Lengua Registro</title>
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<script
	src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/app.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/colors.css">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/checkboxes-radios.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">

<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">

</script>

</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<!-- navbar-fixed-top-->
	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="index.html" class="navbar-brand"><img
							alt="stack admin logo"
							src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png"
							class="brand-logo">
							<h2 class="brand-text">Natigu</h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<jsp:include
						page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->

	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
		<div class="main-menu-content">
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
		</div>
	</div>

	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#">General</a></li>
								<li class="breadcrumb-item active"><a href="#">Registro
										de Lengua</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- Analytics spakline & chartjs  -->
				<section id="configuration">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="basic-layout-icons">Registro de
										Lengua</h4>
									<a class="heading-elements-toggle"><i
										class="fa fa-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										<ul class="list-inline mb-0">
											<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
											<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
											<li><a data-action="close"><i class="ft-x"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="card-body collapse in">
									<div class="card-block">
										<ul class="nav nav-tabs nav-top-border no-hover-bg">
											<li class="nav-item"><a class="nav-link active"
												id="base-tab11" data-toggle="tab" aria-controls="tab11"
												href="#tab11" aria-expanded="true">Registro</a></li>

											<li class="nav-item"><a class="nav-link" id="base-tab12"
												data-toggle="tab" aria-controls="tab12" href="#tab12"
												aria-expanded="false">Estructura de Ense&ntilde;anza</a></li>

											<li class="nav-item"><a class="nav-link" id="base-tab13"
												data-toggle="tab" aria-controls="tab13" href="#tab13"
												aria-expanded="false">Agregar Unidad</a></li>
										</ul>

										<div class="tab-content px-1 pt-1">
											<div role="tabpanel" class="tab-pane active" id="tab11"
												aria-expanded="true" aria-labelledby="base-tab11">

												<f:form id="frmRegistroLengua" class="form-horizontal"
													role="form" enctype="multipart/form-data" method="post"
													action="${pageContext.request.contextPath}/lenguaController/grabarLengua">
													<div class="form-body">
														<div class="col-xs-5">
															<div class="form-group">
																<f:input type="file" class="filestyle"
																	path="lenguaBean.file" id="file" />
															</div>
															<div class="form-group">
																<c:if
																	test="${not empty lenguaForm.lenguaBean.imagenNombre}">
																	<img class="media-object"
																		src="${pageContext.request.contextPath}/lengua/${lenguaForm.lenguaBean.imagenNombre}"
																		alt="Generic placeholder image"
																		style="width: 64px; height: 64px;" />
																</c:if>
															</div>
														</div>
														<div class="col-xs-7">
															<div class="form-group">
																<label for="timesheetinput1">Nombre Lengua<span
																	class="required">*</span></label>
																<div class="position-relative has-icon-left">
																	<f:input type="hidden" path="lenguaBean.codigo"
																		id="codigoLengua" />
																	<input id="contextPath" type="hidden"
																		value="${pageContext.request.contextPath}">
																	<div class="controls">
																		<f:input type="text" class="form-control"
																			id="nombreLengua" path="lenguaBean.nombre"
																			data-validation-required-message="Este campo es requerido" />
																	</div>
																	<div class="form-control-position">
																		<i class="ft-user"></i>
																	</div>
																</div>
															</div>
															<input type="hidden" value="${swMensaje}" id="mensaje" />
															<div class="form-group">
																<label for="situacion" class="col-sm-4 control-label">Situaci&oacute;n<span
																	class="required">*</span></label>
																<div class="controls">
																	<f:select id="situacion"
																		path="lenguaBean.situacion.codigoRegistro"
																		data-validation-required-message="Este campo es requerido"
																		class="form-control">
																		<f:option value="" label="Seleccionar" selected="true"
																			disabled="disabled" />
																		<f:options items="${lstSituacion}"
																			itemValue="codigoRegistro" itemLabel="nombreCorto" />
																	</f:select>
																</div>
															</div>
															<div class="form-group">
																<label for="timesheetinput7">Descripci&oacute;n</label>
																<div class="position-relative has-icon-left">
																	<f:textarea id="descripcion" rows="5"
																		class="form-control" path="lenguaBean.descripcion"></f:textarea>
																	<div class="form-control-position">
																		<i class="ft-file"></i>
																	</div>
																</div>
															</div>

															<div class="form-group text-right">
																<a
																	href="${pageContext.request.contextPath}/lenguaController/nuevo"
																	class="btn btn-secondary" title=""> <i
																	class="fa fa-eraser"></i> Nuevo
																</a>
																<button id="btn-save-reg" type="submit"
																	class="btn btn-flat btn-primary">
																	<i class="fa fa-floppy-o"></i> Guardar
																</button>
															</div>
														</div>
													</div>
												</f:form>

											</div>
											<div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
												<form class="form mt-1">
													<div class="form-body">
														<div class="row">
															<div class="form-group col-md-3 mb-2">
																<label for="projectinput1">Nombre Lengua</label> <label
																	class="form-control">${lenguaForm.lenguaBean.nombre}</label>
															</div>
														</div>
														<div class="row">

															<div class="form-group col-md-12 text-right">
																<button id="idBtnCargarLengua" type="button"
																	onclick="lenguaCargarModal()"
																	class="btn btn-outline-secondary btn-min-width">
																	<i class="ft-search"></i> Agregar
																</button>
																<!--     <button class="btn btn-flat btn-primary" type="submit">
                                                <i class=" glyphicon glyphicon-search space-icon"></i> Buscar</button>    -->

															</div>
														</div>
														<div class="row">
															<div class="col-xs-12" id="listadoDetalleLengua">
																<table
																	class="table table-striped table-bordered zero-configuration">
																	<thead>
																		<tr>
																			<!--  <th>Nombre Lengua</th> -->
																			<th width="140">B&aacute;sico</th>
																			<th width="140">Intermedio</th>
																			<th width="140">Avanzado</th>
																			<th width="70">Acci&oacute;n</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="lenguaEstructuraBean"
																			items="${lstLenguaEstructuraBean}" varStatus="loop">
																			<tr>
																				<td>${lenguaEstructuraBean.basico}</td>
																				<td>${lenguaEstructuraBean.intermedio}</td>
																				<td>${lenguaEstructuraBean.avanzado}</td>
																				<td>
																					<button id="idBtnEditarLengua" type="button"
																						onclick="lenguaCargarModal()"
																						class="btn btn-outline-success btn-sm">
																						<i class="icon-pencil"></i>
																					</button> <!--   <button type="button" class="btn btn-outline-danger btn-sm eliminarLengua"
														data-toggle="tooltip" data-placement="top" title="" onclick="consultaEliminarLenguaEstructura($(this).attr('id'),${lenguaBean.codigo})"
														data-original-title="Eliminar" id="eliminarSede${loop.index}" >
														<i class="icon-trash"></i>
													</button>-->
																				</td>
																			</tr>
																		</c:forEach>

																	</tbody>
																</table>

															</div>
														</div>

													</div>

												</form>

											</div>
											<div class="tab-pane" id="tab13" aria-labelledby="base-tab13">
												<f:form id="frmInsertarUnidad" onsubmit="return false"
													class="form-horizontal" role="form" method="post"
													action="grabarUnidad">
													<div class="form-body">
														<div class="row">
															<div class="form-group col-md-3 mb-2">
																<label for="cmm_nivel">Nivel</label>
																<f:select id="cmm_nivel"
																	path="lenguaEstructuraBean.nivel.codigoRegistro"
																	class="form-control" onchange="cargarSubNiveles(0)">
																	<f:option value="0" label="Seleccione" />
																	<f:options items="${lstNivel}"
																		itemValue="nivel.codigoRegistro"
																		itemLabel="nivel.nombreCorto" />
																</f:select>
															</div>
															<div class="form-group col-md-3 mb-2">
																<div class="form-group">
																	<label for="cmm_sub_nivel">Sub Nivel<span
																		class="required">*</span></label>
																	<div class="controls">
																		<f:select id="cmm_sub_nivel"
																			path="lenguaEstructuraBean.codigo"
																			data-validation-required-message="Este campo es requerido"
																			class="form-control" onchange="cargarUnidades()">
																			<f:option value="0" label="Seleccione" />
																		</f:select>
																	</div>
																</div>
															</div>
															<div class="col-xs-4">
																<div class="form-group">
																	<label for="situacion" class="col-sm-4 control-label">Unidad<span
																		class="required">*</span></label>
																	<div class="controls">
																		<f:select id="unidad"
																			path="unidadBean.unidad.codigoRegistro"
																			data-validation-required-message="Este campo es requerido"
																			class="form-control">
																			<f:option value="" label="Seleccionar" selected="true" />
																			<f:options items="${lstUnidad}"
																				itemValue="codigoRegistro" itemLabel="nombreCorto" />
																		</f:select>
																	</div>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-xs-10">
																<div class="form-group">
																	<label for="timesheetinput1">Nombre Unidad<span
																		class="required">*</span></label>
																	<div class="position-relative has-icon-rigth">
																		<f:input type="hidden" path="unidadBean.codigo"
																			id="codigoUnidadBean" />
																		<div class="controls">
																			<f:input type="text" class="form-control"
																				id="nombreUnidad" path="unidadBean.nombre"
																				data-validation-required-message="Este campo es requerido" />
																		</div>
																	</div>
																</div>
															</div>
														<!-- 	<div class="col-xs-5">
																<label for="timesheetinput1">Traducci&oacute;n
																	al castellano </label>
																<div class="position-relative has-icon-rigth">
																	<f:input type="hidden" path="unidadBean.codigo"
																		id="codigoLenguaEstructura" />
																	<div class="controls">
																		<f:input type="text" class="form-control"
																			id="traduccion" path="unidadBean.traduccion" />
																	</div>
																</div>
															</div> -->
														</div>
														<div class="row">
															<div class="col-xs-10">
																<div class="form-group">
																	<label for="timesheetinput7">Descripci&oacute;n</label>
																	<div class="position-relative has-icon-left">
																		<f:textarea id="descripcionUnidad" rows="2"
																			class="form-control" path="unidadBean.descripcion"></f:textarea>
																		<div class="form-control-position">
																			<i class="ft-file"></i>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="form-group text-right">
														<button id="btn-save-reg" type="button"
																onclick="limpiarUnidad()"
																class="btn btn-secondary">
																<i class="fa fa-eraser"></i> Nuevo
															</button>
														
															<button id="btn-save-reg" type="submit"
																onclick="grabarUnidad()"
																class="btn btn-flat btn-primary">
																<i class="fa fa-floppy-o"></i> Guardar
															</button>
														</div>
														<div class="row">
															<div class="col-xs-12" id="listadoUnidadesLengua">
																<table
																	class="table table-striped table-bordered zero-configuration">
																	<thead>
																		<tr>
																			<!--  <th>Nombre Lengua</th> -->
																			<th>Nivel</th>
																			<th>Sub-Nivel</th>
																			<th>Unidad</th>
																			<th>Lecciones</th>
																			<th width="110">Acci&oacute;n</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="unidadBean" items="${lstUnidadBean}"
																			varStatus="loop">
																			<tr>
																				<td style="display: none">${unidadBean.lenguaEstructuraBean.nivel.codigoRegistro}</td>
																				<td>${unidadBean.lenguaEstructuraBean.nivel.nombreCorto}</td>
																				<td>${unidadBean.lenguaEstructuraBean.subNivel.nombreCorto}</td>
																				<td>${unidadBean.unidad.nombreCorto}</td>
																				<td>${unidadBean.nombreLecciones} </td>
																				<td>
																					<button id="idBtnBuscarLeccion" type="button"
																						onclick="lenguaCargarModalUnidadLeccion(${unidadBean.codigo})"
																						class="btn btn-outline-success btn-sm" title="Asignar Lecci&oacute;n" >
																						<i class="icon-plus"></i>
																					</button>
																					<button id="idBtnEditarUnidad" type="button"
																						onclick="modificarUnidad(${unidadBean.codigo})"
																						class="btn btn-outline-success btn-sm" title="Editar" >
																						<i class="icon-pencil"></i>
																					</button>
																					 <button type="button" class="btn btn-outline-danger btn-sm" 
																					 data-toggle="tooltip" data-placement="top" title="Eliminar" 
																					 		data-original-title="Eliminar" onclick="confirmar_accion(${unidadBean.codigo},'unidad');">
                                                          							<i class="icon-trash"></i>
                                                          							</button>
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
			<span class="float-md-left d-xs-block d-md-inline-block">Copyright
				&copy; 2017 <a href="#" target="_blank"
				class="text-bold-800 grey darken-2">Natigu </a>, Todos los derechos
				reservados.
			</span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy
				Business</span>
		</p>
	</footer>
	<!-- Modal -->
	<div id="modalLengua"></div>
	<div class="modal fade text-xs-left" id="modalLenguaEstructura"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalLenguaEstructuraContent"></div>
		</div>
	</div>

	<div class="modal fade text-xs-left" id="modalLenguaEstructuraUnidad"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalLenguaEstructuraUnidadContent"></div>
		</div>
	</div>

	<jsp:include
		page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
	<jsp:include
		page="${pageContext.request.contextPath}/../layout/galeria-imagen-view.jsp" />
	<!-- BEGIN VENDOR JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js"
		type="text/javascript"></script>
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN STACK JS-->

	<script
		src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/core/app.js"
		type="text/javascript"></script>
	<!-- END STACK JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<script
		src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/scrollable.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/general/lengua/lengua-script.js"
		type="text/javascript" charset="utf-8"></script>
	<script>
		$(document).ready(function() {

			var msj = $("#mensaje").val();
			var lengua = $("#nombreLengua").val();//1
			if (msj == '1') {
				msg_exito();
			} else if (msj == '0') {
				msg_error();
			}else if (msj == '3') {
				alert("La lengua "+lengua+" ya se encuentra registrada.");
			}
		});

		var accion_tab = "";
		function consultaEliminarLenguaEstructura(idButton, codigoSede) {
			accion_tab = idButton;
			codSede = codigoSede;
			$('#md_confirmacion').modal('show');
		}

		var path = null;
		$(document).ready(function() {
			path = document.getElementById("contextPath").value;

		}); 
	</script>

</body>
</html>