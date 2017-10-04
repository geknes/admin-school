<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<f:form id="frmGuardarInstOperador" onsubmit="return false" class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/institucionController/guardarInstOperador">
	<div class="modal-body">
		<f:input type="hidden" id="codigo_instope" path="codigo" class="form-control"/>
		<f:input type="hidden" id="codigoInstitucion_instope" path="codigoInstitucion" class="form-control"/>
		<f:input type="hidden" id="codigoPersona_instope" path="codigoPersona" class="form-control"/>
		<div class="row">
			<div class="form-group col-md-5 mb-2">
         		<label for="tipoDocPersona_busqdato">Tipo Documento<span class="required">*</span></label>
          		<div class="controls">
          		<f:select id="tipoDocPersona_busqdato" name="tipoDocPersona_busqdato" path="personaBean.tipoDocumento.codigoRegistro" class="form-control"
          		data-validation-required-message="Este campo es requerido" required="required" >
           			<f:option value="0" label="Seleccionar"/>
           			<f:options  items="${lstTipoDocumento}"
                   				itemValue="codigoRegistro"
                   				itemLabel="nombreCorto"/>
     			</f:select>
			</div>
			</div>
			<div class="form-group col-md-4 mb-2">
				<label for="numDocPersona_busqdato">N&uacute;mero Documento<span class="required">*</span></label>
               	<div class="controls">
               	<f:input type="text" id="numDocPersona_busqdato" path="personaBean.numeroDocumento" class="form-control" name="numDocPersona_busqdato"
               	pattern="[0-9]{8}"  maxlength="8" required="required" data-validation-required-message="Este campo es requerido"/>
           	</div>
           	</div>
           	<div class="form-group col-md-3 mb-2">
           	<br>
               	<button type="button" class="btn btn-secondary mr-1" onclick="buscarPersonaPorDocumentoOperador();">
                 	<i class="ft-search"></i> Buscar
               	</button>
           	</div>
        </div>

       	<div class="row">
			<div class="form-group col-md-5 mb-2">
               	<label for="projectinput1">Nombres completos<span class="required">*</span></label>
               	<div class="controls">
               	<f:input type="text" id="nombresPersona_dato" name="nombresPersona_dato" required="required" 
               	data-validation-required-message="Este campo es requerido" disabled="true" class="form-control" path="personaBean.nombreCompleto"
               	/>
            </div>
           	</div>
           	<div class="form-group col-md-4 mb-2">
               	<label for="projectinput2">Cargo</label>
               	<f:input type="text" id="cargoPersona_dato" path="cargo.nombreCorto" disabled="true" class="form-control" name="lname"/>
           	</div>
           	<div class="form-group col-md-3 mb-2">
            	<label for="situacionUsuario">Situaci&oacute;n<span class="required">*</span></label>
              	<div class="controls">
              	<f:select id="tm1Situacion" name="tm1Situacion" path="situacionOperador"
              	class="form-control" required="required" data-validation-required-message="Este campo es requerido">
           			<f:option value="-1" selected="true" class="optionReset" label="Seleccionar" />
           			<f:options  items="${lstSituacion}"
                   				itemValue="codigoRegistro"
                   				itemLabel="nombreCorto"/>
      	 		</f:select>
           </div>
           </div>
       	</div>

       	<div class="row">
            <div class="form-group col-md-4 mb-2">
               	<label for="projectinput2">Tel&eacute;fono/Celular</label>
               	<f:input type="text" id="telefonoPersona_dato" name="telefonoPersona_dato" disabled="true" class="form-control" path="personaBean.telefono"
               	/>
           	</div>
           	<div class="form-group col-md-5 mb-2">
               	<label for="projectinput2">Correo Electr&oacute;nico</label>
               	<f:input type="text" id="correoPersona_dato" name="correoPersona_dato" disabled="true" class="form-control" path="personaBean.correo"/>
           	</div>
       	</div>

	</div>

	<div class="modal-footer">
		<button id="closeModalBtnFrm" type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
		<button type="submit" class="btn btn-primary" onclick="validar('#frmGuardarInstOperador')"><i class="fa fa-floppy-o"></i> Guardar</button>
	</div>
</f:form>
<script type="text/javascript">
function validar(idfrom) {
	var $myForm = $(idfrom);
	if (!$myForm[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos correctamente");
	} else {
		enviar_ajax();
	}
}
</script>