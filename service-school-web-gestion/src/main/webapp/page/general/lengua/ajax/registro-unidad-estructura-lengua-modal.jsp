
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<!-- Modal -->

<div class="modal-header">
	<button type="button" id="btnCerrar" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Registro
			de Unidades y Lecciones</b></label>
</div>
<div class="modal-body">

	<f:form id="frmInsertarLeccion" class="form-horizontal" role="form"
		enctype="multipart/form-data" method="post" onsubmit="return false"
		action="grabarLeccion">
		<input id="contextPath" type="hidden"
			value="${pageContext.request.contextPath}">

		<div class="form-body">
			<div class="row">
				<div class="col-xs-5">
					<div class="form-group">
						<label for="situacion" class="col-sm-4 control-label">Situacion<span
							class="required">*</span></label>
						<div class="controls">
							<f:select id="situacionLeccion" path="situacion.codigoRegistro"
								data-validation-required-message="Este campo es requerido"
								class="form-control">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstSituacionLeccion}" itemValue="codigoRegistro"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
				</div>
				<f:input type="hidden" path="unidadBean.codigo" id="codigoUnidad" />
				<f:input type="hidden" path="codigo" id="codigoLeccion" />
				<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}">
				<div class="col-xs-7">
					<div class="form-group">
						<label for="timesheetinput1">Nombre Lecci&oacute;n<span class="required">*</span></label>
						<div class="position-relative has-icon-left">  
							<div class="controls">
								<f:input type="text" class="form-control" id="nombreLeccion"
									path="nombre"
									data-validation-required-message="Este campo es requerido" />
							</div>
							<div class="form-control-position">
								<i class="ft-user"></i>
							</div>
						</div>
					</div>
				</div>
			</div> 

			
		</div>

		<div class="modal-footer">

			<button type="button" class="btn btn-outline-secondary"
				data-dismiss="modal">Salir</button>
			<button type="submit" onclick="grabarLeccion()"
				class="btn btn-primary">
				<i class="fa fa-floppy-o"></i> Guardar
			</button>

			<h4 id="result"></h4>
		</div>
		<div class="row">
				<div class="col-xs-12" id="listadoUnidadesLengua">
					<table
						class="table table-striped table-bordered zero-configuration">
						<thead>
							<tr>
								<!--  <th>Nombre Lengua</th> -->
								<th>Unidad</th>
								<th>Nombre Leccion</th>
								<th width="110">Acci&oacute;n</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="leccionBean" items="${lstUnidadLeccionBean}"
								varStatus="loop">
								<tr>
									<td>${leccionBean.unidadBean.unidad.nombreCorto}</td>
									<td>${leccionBean.nombre}</td> 
									<td>
										<button type="button"
											class="btn btn-outline-danger btn-sm eliminarLengua"
											data-toggle="tooltip" data-placement="top" title=""
											onclick="confirmar_accion(${leccionBean.codigo},'leccion')"
											data-original-title="Eliminar">
											<i class="icon-trash"></i>
										</button>
										<button id="idBtnEditarUnidad" type="button"
											onclick="modificarLeccion(${leccionBean.codigo})"
											class="btn btn-outline-success btn-sm">
											<i class="icon-pencil"></i>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	</f:form>
</div>
<script
		src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js"
		type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/js/jquery.form.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
	type="text/javascript"></script>

