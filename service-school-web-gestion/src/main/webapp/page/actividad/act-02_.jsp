<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item"> 
		<a class="nav-link" onclick="mostrarOracionxTEM();" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Texto</a>
	</li>
	<li class="nav-item">
		<a class="nav-link"   onclick="listadoDeEspaciosxOracion();" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li> 
	     
</ul>  
<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body"> 
	        <div class="col-xs-7">
	          <div class="form-group">
	          	<input type="hidden" id="idEjercicio"  value="0" />
	          	
	          	<%-- ${ejercicio.tituloEjercicio}  onclick="mostrarOracionxTEM(130)"  onclick="listadoPreguntaActividad();"--%> 
	            <label id="titulo" for="timesheetinput1">T&iacute;tulo de la Actividad</label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}"> 
	            </div>
	          </div> 
	          
			  <div class="form-group text-right mb-1">
			  <button type="button" id="btn_nuevo" onclick="nuevo()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-plus"></i> Nuevo
					</button>
			      <button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio();" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-floppy-o"></i> Guardar
			      </button>
			  </div>
	        </div> 
	        <div class="col-xs-5">
	          <div class="table-responsive">
				        <table class="table table-bordered table-striped">
				                       
						<thead>
				            <tr>
				                <th width="30">#</th>
				                <th>T&iacute;tulo</th>
				                <th width="80">Acci&oacute;n</th>
				            </tr>
				         </thead>
				                <tbody id="idBodyListadoMaterialTipoEjercicio">
				                </tbody>
				         </table>
				    </div>
	        </div> 
	      </div>
	</div>  
 



	<div  role="tabpanel" class="tab-pane " id="tab43" aria-expanded="true" aria-labelledby="base-tab43">
		<div class="form-body"> 
	        <div class="col-xs-12"> 
	        <div class="form-group"> 
	            <label   for="timesheetinput1">T&iacute;tulo del texto</label>
	            <div class="position-relative ">
	              <input type="text" id="idoraciontitulo" class="form-control" name="employeename" > 
	            </div>
	          </div> 

	          <div class="form-group">
	          <input type="hidden" id="idoraciondesc"  value="0" />
			     <label for="timesheetinput7">Texto</label>
			      <div class="position-relative has-icon-left">
			       <textarea id="ejercicioTxtOracion" rows="15" class="form-control" name="notes"></textarea>
			        <div class="form-control-position"> <i class="ft-file"></i>
			        </div>
			      </div>
		       </div>
			  <div class="form-group text-right mb-1">
			  
			      <button type="button" id="btn_guardar_ejercicio11" onclick="guardarOracion();" class="btn btn-outline-info btn-min-width">
			        <i class="glyphicon glyphicon-floppy-disk"></i> Guardar
			      </button>
			  </div>
	        </div> 
	         
	      </div>
	</div>  
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42"> 
		<div class="row">
			<input type="hidden" id="idPregunta" value=""/>  
		    <input  type="hidden" id="txtPreguntaDescripcion"     value="descif"/> 
	        <div class="col-xs-6"> 

	       
	          	<div class="form-group col-md-4"> 
	            <label id="espacio" for="timesheetinput1" style="margin-top:5px">Palabra Clave :</label> 
	          </div> 
	          <div class="position-relative col-md-7">
	              <input   type="text" id="idespacio" class="form-control" name="palabraclave"> 
	            </div>
	          
	        <table id="tblPregunta" class="table table-striped table-bordered zero-configuration">
	        <thead>
	        <tr>  
		     </tr>
	         </thead> 
	         <tbody id="11">  
	          
	         <tr>
		          <div class="form-group">
		          	<div class="col-md-12">
		          	<input type="hidden" id="idalter0"  value="0" />
				    	<label style="margin-top:2px"  for="nombreUnidadLec" >Alternativa 01</label> 
				    </div>
				    <div class="col-md-12">
						<fieldset>
							<div class="input-group input-group-sm">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="0" type="radio" name="rpst" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion0"  checked="false"   name="rptaDescripcion0" type="text" class="form-control" aria-describedby="radio-addon1">
							</div>
						</fieldset>
					</div>
		          </div>
		        </tr>
		        <tr>
			          <div class="form-group">
			          <div class="col-md-12">
			          <input type="hidden" id="idalter1"  value="0" />
					    <label style="margin-top:2px" for="nombreUnidadLec">Alternativa 02</label> </div>
					    <div class="col-md-12">
						<fieldset>
							<div class="input-group input-group-sm">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="1" checked="false" type="radio" name="rpst" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion1" name="rptaDescripcion1"  type="text" class="form-control" aria-describedby="radio-addon1">
							</div>
						</fieldset>
						</div>
			          </div>
		          </tr>
		          <tr>
		          	           <div class="form-group">
			          <div class="col-md-12 ">
			          <input type="hidden" id="idalter2"  value="0" />
					    <label style="margin-top:2px" for="nombreUnidadLec">Alternativa 03</label> </div>
					    <div class="col-md-12">
						<fieldset>
							<div class="input-group input-group-sm  ">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="2"  checked="false" type="radio" name="rpst" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion2" name="rptaDescripcion2" type="text" class="form-control"  >
							</div>
						</fieldset>
						</div>
			          </div>
		          </tr> 
	          </tbody>
	          <tfoot>
				  <div class="form-group text-right mb-0 col-md-12" >
				  <button type="button" id="btn_nuevo" onclick="nuevoAlternativasOracion();" class="btn btn-outline-info btn-min-width" style="margin-top:20px">
					<i class="fa fa-plus"></i>   Nuevo
					</button>
				      <button type="button" class="btn btn-outline-info btn-min-width" id="btn-guardar-oracion" onclick="agregarOracionAlternativa2(1)" style="margin-top:20px">
				        <i class="fa fa-floppy-o"></i> Guardar
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
                                <th width="60">#</th> 
                                <th> Palabra Clave</th> 
                                <th width="150">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idTablaEspaciosListado27"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>
	 
</div>
</f:form>

