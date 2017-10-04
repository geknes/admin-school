<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<f:form id="frmGuardarInstDirector" class="form-horizontal" role="form"
	method="post" action="${pageContext.request.contextPath}/institucionController/guardarInstDirector">
	<div class="modal-body">
		<div class="row">
		<f:input type="hidden"  id="codigoPersonaDirector_dato" class="form-control" name="lname" path="codigo" />
			<div class="form-group col-md-5 mb-2">
				<fieldset class="form-group">
					<label>Tipo Documento</label>
					<f:select id="tipoDocumentoPersona_dato1"
						path="tipoDocumento.codigoRegistro" class="form-control">
						<f:option value="0" label="Seleccionar" />
						<f:options items="${lstTipoDocumento}" itemValue="codigoRegistro"
							itemLabel="nombreCorto" />

					</f:select>
				</fieldset>
			</div>
			<div class="form-group col-md-4 mb-2">
				<label for="projectinput2">N&uacute;mero Documento<span class="required">*</span></label>
				<div class="controls">
				<f:input type="text" id="numeroDocumentoPersona_dato1" required="required" data-validation-required-message="Este campo es requerido"
					class="form-control" name="lname" path="numeroDocumento" maxlength="8" pattern="[0-9]{8}" />
			</div>
			</div>
			<div class="form-group col-md-3 mb-2">
				<br>
				<button type="button" class="btn btn-secondary mr-1"
					onclick="buscarPersonaPorDocumento()"><%--buscarPersonaPorDocumento() --%>
					<i class="ft-search"></i> Buscar
				</button>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-8 mb-2">
				<label for="projectinput1">Nombres completos</label>
				<f:input type="text" id="nombresPersona_dato" class="form-control"
					name="lname" path="nombreCompleto" disabled="true" />
			</div>

			<!-- 	<div class="form-group col-md-4 mb-2">
                                             	 <fieldset class="form-group">
                                                 <label for="situacionIdioma">Situaci&oacute;n</label>
                                                  <f:select  path="situacionPersona.codigoRegistro" class="form-control">
                                                            <f:option value="0" label="Seleccionar"/>
                                                            <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                   </f:select>
                                              </fieldset>
                                                  </div>    -->


		</div>
		<div class="row">
			<div class="form-group col-md-4 mb-2">
				<label for="projectinput2">Tel&eacute;fono/Celular</label>
				<f:input type="text" id="telefonoPersona_dato" disabled="true"
					class="form-control" name="lname" path="telefono" />
			</div>

			<div class="form-group col-md-8 mb-2">
				<label for="projectinput2">Correo Electr&oacute;nico</label>
				<f:input type="text" id="correoPersona_dato" disabled="true"
					class="form-control" name="lname" path="correo" />
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button id="closeModalBtnFrmBqdDirector" type="button"
			class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
		<button type="button" class="btn btn-primary"
			onclick="asignarDirectorBuscado()">
			<i></i> Asignar
		</button>
	</div>
</f:form>