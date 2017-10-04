<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active"  id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio </a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarParrafoCabecera();"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
</ul>

<f:form class="form" id="frmregistromodalactividadParrafo" method="post" action="">
<div class="tab-content px-1 pt-1">

	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body">
			<div class="row">
			
				<div class="col-xs-6">
				
					<div class="form-group">
						<input type="hidden" id="idEjercicio" value="0"/>
						<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
					<label id="titulo" for="timesheetinput1">T&iacute;tulo</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}">
						</div>
					</div>	
				<div class="form-group text-right mb-1">					
					<button type="button" id="btn_nuevo" onclick="nuevo()" class="btn btn-outline-info btn-min-width">
					<i class="ft-plus"></i> Nuevo
					</button>
					<button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
					<i class="ft-search"></i> Guardar
					</button>					
					
				</div>				

				
				</div>
			
				<div class="col-xs-6">
					<div class="table-responsive">
				        <table class="table table-bordered table-striped">
				                       
						<thead>
				            <tr>
				                <th width="30">#</th>
				                <th>Título</th>
				                <th width="110">Acci&oacute;n</th>
				            </tr>
				         </thead>
				                <tbody id="idBodyListadoMaterialTipoEjercicio">
				                </tbody>
				         </table>
				    </div>
				</div>
			
			</div>
		
		</div>
	</div>

	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">	
	<div class="row">
	<div class="col-xs-6">
	<div class="form-group">
	<input id="idOrdenParrafoCabecera" type="hidden" value="0"/>
	<label for="tituloActividad">Título Actividad</label>
	<input type="text" id="tituloActividad" class="form-control" required name="tituloActividad">
	<br>
	<div class="form-group text-right mb-1" >
	<button type="button" id="btn_nuevo_parrafo_cabecera" onclick="nuevo_TituloCabecera()" class="btn btn-outline-info btn-min-width">
	<i class="fa fa-plus"></i> Nuevo
	</button>	
	<button type="button" class="btn btn-outline-info btn-min-width" id="btnTituloParrafoCabecera" onclick="grabarOrdenarParrafoCabecera()" >
	<i class="fa fa-floppy-o"></i> Guardar
	</button>
	</div>
	</div>
	</div>
	<div class="col-xs-6">
	<div class="table-responsive">
	<table class="table table-bordered table-striped">
	<thead>
	 <tr>
	    <th width="30">#</th>
	    <th>Título</th>
	    <th>Acci&oacute;n</th>
	</tr>
	</thead>
	<tbody id="idListadoParrafoCabecera"> 
	</tbody>
	</table>	
	</div>	
	
	</div>
	</div>		
		
		
		<hr>
		
		<div class="row">
		
			<div class="col-xs-6">
				<table id="tblPregunta" class="table table-striped table-bordered zero-configuration">
					<thead>
						<tr>
							
							<div class="form-group">
							<input id="idOrdenarParrafo" type="hidden" value="0"/>
							<label for="timesheetinput7">Párrafo</label>
								<div class="position-relative has-icon-left">
								<textarea id="parrafo" rows="5" class="form-control" disabled="true" name="notes"></textarea>
									<div class="form-control-position">
									<i class="ft-file"></i>
									</div>
								</div>
							</div>	
						</tr>	
					</thead>	
				<tbody >
				<tr>
				<div class="form-group">
					<div class="col-md-12">
						<label for="nombreUnidadLec">Número de orden</label> 
						<div class="input-group input-group-sm ">
							<input id="numeroOrdenParrafo" name="numeroOrdenParrafo" disabled="true" type="text" class="form-control" >
						</div>

					</div>	
				
				</div>
				</tr>	
				
				</tbody>
				<tfoot>
				<tr >  &nbsp;&nbsp;&nbsp;
				</tr>
				
					<div class="form-group text-right mb-1" >
						<button type="button" id="btn_nuevo_parrafo" onclick="nuevo_parrafo()" class="btn btn-outline-info btn-min-width">
						<i class="fa fa-plus"></i> Nuevo
						</button>						
						<button type="button" id="btnGuardarParrafo" class="btn btn-outline-info btn-min-width" onclick="guardarParrafo()" >
						<i class="fa fa-floopy-o"></i> Guardar
						</button>
					</div>
				</tfoot>
				</table>	
			</div>	
			<div class="col-xs-6">
					<div class="table-responsive">
				        <table class="table table-bordered table-striped">
				                       
						<thead>
				            <tr>
				                <th width="30">#</th>
				                <th>Párrafo</th>
				                <th width="80">Acci&oacute;n</th>
				            </tr>
				         </thead>
				                <tbody id="idBodyListadoParrafo">
				                </tbody>
				         </table>
				    </div>				
			</div>
		</div>
	</div>

</div>
</f:form>