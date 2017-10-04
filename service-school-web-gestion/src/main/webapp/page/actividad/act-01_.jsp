<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarEjercicioTextoTexto()"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmRegistoTextoTexto" method="post" action="">
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
					<button type="button" id="btn_nuevo_ejercicio" onclick="nuevo()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-plus"></i> Nuevo
					</button>
					<button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-floppy-o"></i> Guardar
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
	        
	        <%-- 
	        <div class="col-xs-7">
	          <div class="form-group">
	       
	          	<%-- ${ejercicio.tituloEjercicio} 
	            <label id="titulo" for="timesheetinput1">T&iacute;tulo</label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}">
	              
	            </div>
	          </div>
	           
	          <div class="form-group">
	            <label for="timesheetinput7">Descripci&oacute;n</label>
	            <div class="position-relative has-icon-left">
	              <textarea id="ejercicioTxtDescripcion" rows="5" class="form-control" name="notes">${ejercicio.descripcionEjercicio}</textarea>
	              <div class="form-control-position">
	                <i class="ft-file"></i>
	              </div>
	            </div>
	          </div>
			  <div class="form-group text-right mb-1">
			      <button type="button" id="btn_guardar_ejercicio" onclick="guardarEjercicio()" class="btn btn-outline-info btn-min-width">
			        <i class="ft-search"></i> Guardar
			      </button>
			  </div>
	        </div>
	        --%> 

	      </div>
	</div>

	
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
	
		<div class="row">
	        <div class="col-xs-6">
	        
     	 <div class="form-group">
     	  <input type="hidden" id="idRelacionCabecera" value="0"/>
         <input type="hidden" id="idRelacionTextoTexto" value="0"/>
         <input type="hidden" id="textoRelacionado2" value=""/>
         <label for="timesheetinput7">Texto</label>
         <div class="position-relative has-icon-left">
         <textarea id="textoTexto" rows="2" class="form-control input-sm" name="notes"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
        </div>

     	 <div class="form-group">
         <label for="timesheetinput7">Texto Relacionado</label>
         <div class="position-relative has-icon-left">
         <textarea id="textoRelacionado" rows="2" class="form-control input-sm" name="notes"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
         </div> 
         
		<div class="form-group text-right mb-1" >
		<button type="button" id="btn_nuevo_texto" onclick="nuevoTexto()" class="btn btn-outline-info btn-min-width">
		<i class="fa fa-plus"></i> Nuevo
		</button>		 
		 <button type="button" class="btn btn-outline-info btn-min-width" id="btn_guardar_texto" onclick="validarTextoTexto()" >
		 <i class="fa fa-floppy-o"></i> Guardar
		 </button>
		 </div>                
	  <%--     
	        <table id="tblPregunta" class="table table-striped table-bordered zero-configuration">
	        <thead>
	        <tr>
		          <div class="form-group">
		          	<input type="hidden" id="idRelacion" value=""/>
		            <label for="timesheetinput7">Palabra</label>
		            <div class="position-relative has-icon-left">
		              <textarea id="txtPalabra" rows="1" class="form-control input-sm" name="notes"></textarea>
		              <div class="form-control-position">
		                <i class="ft-file"></i>
		              </div>
		            </div>
		          </div>
		          <div class="form-group">
		          	<!-- <audio src="../assets/img/Die_tomorrow.mp3" controls type="audio/mpeg">
					<p>Tu navegador no implementa el elemento audio</p>
					</audio> -->
					<input type="file" id="fileAudio" name="fileAudio[]" multiple  />
					<img src="../assets/img/usar_audio.jpg" width="36" class="img-fluid"  style="cursor: pointer;">
					<!-- data-toggle="modal" data-target="#xlarge" -->
		          </div>
		     </tr>
	         </thead> 
	         <tbody id=> 
		         
		          <tr>
		            <div class="form-group">
		          <div class="col-md-12">
				    <label for="">Imagen</label> </div>
				    <div class="col-md-6">
					<fieldset>
					<!-- <input type="file" id="imgEjercicio" style="display:none"> -->
					<input type="file" id="files" name="files[]" multiple onchange="handleFileSelect_mini(event); " style="display:none"/>
					<div id="list" onclick="obtener_imagen_mini();" style="cursor: pointer;">
						<c:choose>
					        <c:when test="${not empty ejercicio.nombeImagen}">
					        	<label for=""><img src="${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}" onclick="obtener_imagen();" alt="element 01" style="cursor: pointer;" class="thumb-mini"></label>
					        </c:when>
					        <c:otherwise>
					        	<label for=""><img src="../assets/img/usar_imagen.jpg" onclick="obtener_imagen();" alt="Imágen" class="img-fluid" style="cursor: pointer;"></label>
					        </c:otherwise>
				        </c:choose>
						<!-- <label for=""><img src="../assets/img/usar_imagen.jpg" onclick="obtener_imagen();" alt="element 01" class="img-fluid" style="cursor: pointer;"></label> -->
						
					</div>
                    <h4 id="fake-btn" style="display:none" class="form-input text-center truncate"><span class="margin"> Choose File</span></h4>				     
				</fieldset>
					</div>
		          </div>
		          </tr>
	          </tbody>
	          <tfoot>
				  <div class="form-group text-right mt-2" >
				      <button type="button" class="btn btn-outline-info btn-min-width" onclick="guardarRelacion()" style="margin-top:15px">
				        <i class="ft-search"></i> Guardar
				      </button>
				  </div>
			  </tfoot>
			  </table>
			   --%> 
	        </div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                       
						<thead>
                            <tr>
                                <th width="30">#</th>
                                <th>Texto</th>
                                <th>Texto Relacionado</th>
                                <th>Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="bodyListeTextoTexto"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>

</div>
</f:form> 