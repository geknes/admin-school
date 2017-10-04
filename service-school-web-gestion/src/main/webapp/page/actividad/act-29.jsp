<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" onclick="limpiartab2Arras();limpiartab3Arras()"  id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item"> 
		<a class="nav-link" onclick="mostrarArrastrarxTEM();" id="base-tab42" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Oraci&oacute;n</a>
	</li>
	<li class="nav-item">
		<a class="nav-link"     onclick="listadoRespxOracionGeneral();"   id="base-tab43" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li> 
	     
</ul>  
<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body"> 
	        <div class="col-xs-7">
	          <div class="form-group">
	          	<input type="hidden" id="idEjercicio"  value="0" />
	          	
	          	<%--   --%> 
	            <label id="titulo" for="timesheetinput1">T&iacute;tulo de la Actividad</label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" > 
	            </div>
	          </div> 
	          
			  <div class="form-group text-right mb-1">
			  <button type="button" id="btn_nuevo_ejercicio" onclick="nuevoMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-plus"></i> </i> Nuevo
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
 



	<div  role="tabpanel" class="tab-pane " id="tab43" aria-expanded="true" aria-labelledby="base-tab43">
		<div class="form-body"> 
	        <div class="col-xs-10"> 
	        <div class="form-group"> 
	            <label   for="timesheetinput1">T&iacute;tulo de la Oraci&oacute;n</label>
	            <div class="position-relative ">
	              <input type="text" id="tituloArrast" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}"> 
	            </div>
	          </div> 

	          <div class="form-group">
	          <input type="hidden" id="idArrasOra"  value="0" />
			     <label for="timesheetinput7">Oraci&oacute;n</label>
			      <div class="position-relative has-icon-left">
			       <textarea id="OracionTxtArea" rows="9" class="form-control" name="notes"> </textarea>
			        <div class="form-control-position"> <i class="ft-file"></i>
			        </div>
			      </div>
		       </div>
			  <div class="form-group text-right mb-1"> 
			  	  <button type="button" id="Modifbtn"  onclick="desModi()" class="btn btn-outline-info btn-min-width" style="margin-top:10px">
					<i class="fa fa-pencil"></i>   Modificar
					</button>
			      <button type="button" id="GuardarBtn" onclick="guardarArrastrar();" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-floppy-o"></i> Guardar
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

	      
	          	<div class="form-group col-md-5"> 
	            <label   for="timesheetinput1" style="margin-top:5px">N&uacute;mero de Orden :</label> 
	          </div> 
	          <div class="position-relative col-md-3 ">
	              <input   type="text" id="inorden" onkeypress="return valida(event)" class="form-control" name="employeenamed"  maxlength="1"> 
	            </div>
	          
	        <table id="tblPregunta121" class="table table-striped table-bordered zero-configuration">
	     
	         <tbody id="12">   
	         <tr> 
				    <div class="form-group"> 
				       <input type="hidden" id="idoracionxArrast"  value="0" />
					     <label for="timesheetinput7">Oraci&oacute;n</label>
					      <div class="position-relative has-icon-left">
					       <textarea id="oracionxArrast" rows="5" class="form-control" name="notes"> </textarea>
					        <div class="form-control-position"> <i class="ft-file"></i>
					        </div>
					   	  </div>
				    </div> 
		          
		        </tr> 
	          </tbody>
	          <tfoot>
				  <div class="form-group text-right mb-0 col-md-12" >
				  <button type="button" id="btn_nuevo3" onclick="nuevoTab3Arras()"  class="btn btn-outline-info btn-min-width" style="margin-top:10px">
					<i class="fa fa-plus"></i>   Nuevo
					</button>
				      <button type="button"  onclick="guardarRespuestaArra();" id="btn-guardar-respuesta" class="btn btn-outline-info btn-min-width"   style="margin-top:10px">
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
                                <th> N&deg; de Espacio </th> 
                                <th width="150">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idTablaArrastrarOracion"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>
	 
</div>
</f:form> 