<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio crucigrama</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarEjercicioCrucigrama()"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmRegistoCrucigrama" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body">
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
						<input type="text" id="idEjercicio" value="0"/>
						<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
					<label id="titulo" for="timesheetinput1">T&iacute;tulo</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtTitulo" required class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}">
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
     	  <input type="text" id="idRelacionCabecera" value="0"/>
         <input type="text" id="idRelacionCrucigrama" value="0"/>
         <label for="timesheetinput7">Palabra</label>
         <div class="position-relative has-icon-left">
         <input id="idPalabraCrucigrama" type ="text" required  class="form-control input-sm" name="notes"/>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
        </div>
     	 <div class="form-group">
         <label for="timesheetinput7">Definici&oacute;n</label>
         <div class="position-relative has-icon-left">
         <textarea id="idDefinicionCrucigrama" rows="1" required class="form-control input-sm" name="notes"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
         </div> 
         <div class="form-group col-md-3 mb-2">        
         <label for="situacionUsuario">Orden</label>
         <Select id="idCmbOrden" class="form-control" > 
         	<option value="0" label="Seleccionar"/>
         	<option value="1" label="1"/>
         	<option value="2" label="2"/>
         	<option value="3" label="3"/>
         	<option value="4" label="4"/>
         	<option value="5" label="5"/>
         	<option value="6" label="6"/>
         	<option value="7" label="7"/>
         	<option value="8" label="8"/>
			 		
		</Select>
		</div>
		
		<div class="form-group col-md-3 mb-2">  
		<label for="situacionUsuario">Orientaci&oacute;n</label>
		   <select id="idCmbOrientacion" class="form-control" > 
				<option value="0" label="Seleccionar"/>
	         	<option value="1" label="Horizontal"/>
	         	<option value="2" label="Vertical"/>			
			</select>
         </div>
         
		 <div class="form-group text-right mt-2" >
		 <button type="button" class="btn btn-outline-info btn-min-width" onclick="guardarCrucigrama()" style="margin-top:15px">
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
                                <th>Palabra</th>
                                <th>Definici&oacute;n</th>
                                <th>Orden</th>
                                <th>Orientaci&oacute;</th>
                                <th>Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="bodyListeCrucigrama"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>

</div>
</f:form> 