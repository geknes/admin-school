<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<!-- <li class="nav-item">
		<a class="nav-link " id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="false">Material</a>
	</li> -->
	<li class="nav-item">
		<a class="nav-link active"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="true">Actividad</a>
	</li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
<!-- 	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="false" style="display:none" aria-labelledby="base-tab41">
		<div class="form-body">
	        <div class="col-xs-5">
	        
	        	<label for="imgEjercicio">Imagen</label>
				<fieldset>
					
					<input type="file" id="files" name="files[]" accept="image/*" multiple onchange="handleFileSelect(event); " style="display:none"/>
					<div id="list" onclick="obtener_imagen();" style="cursor: pointer;">
						<c:choose>
					        <c:when test="${not empty ejercicio.nombeImagen}">
					        <input type="hidden" value="1" id="hiddenImg" />
					        	<div id="contentImg"><label for=""><img src="${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}" 
					        	
					        	onclick="obtener_imagen();" alt="${ejercicio.nombeImagen}" style="cursor: pointer;" class="thumb"></label>
					        	</div>
					        </c:when>
					        <c:otherwise>
					        	<input type="hidden" value="0" id="hiddenImg" />
					        	<div id="contentImg">
					        	<label for=""><img src="../assets/img/usar_imagen.jpg" onclick="obtener_imagen();" alt="element 01" class="img-fluid" style="cursor: pointer;"></label>
					        	</div>
					        </c:otherwise>
				        </c:choose>
						
						
					</div>
                    <h4 id="fake-btn" style="display:none" class="form-input text-center truncate"><span class="margin"> Choose File</span></h4>				     
				</fieldset>
	        </div>
	        <div class="col-xs-7">
	          <div class="form-group">
	          	
	            <label id="titulo" for="timesheetinput1">T&iacute;tulo</label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}">
	              
	            </div>
	          </div>
	          <div class="form-group">
	          	<input type="file" id="fileAudio" name="fileAudio[]" multiple accept="audio/*" onchange="handleAudioSelect(event)" style="display:none" />
	          	<img src="../assets/img/usar_audio.jpg" width="36" onclick="obtenerAudio()" class="img-fluid"  style="cursor: pointer;">
	          	  <span id="spanNombreMp3"></span>
	          	<br /><br />
	          	<c:choose>
					<c:when test="${not empty ejercicio.ubicacionImagen}">
						<input type="hidden" value="1" id="hiddenAud" />
						<div id="contentAudio">
							<audio id="audioAct02"  preload="auto" controls>
								<source src="${pageContext.request.contextPath}/material/${ejercicio.ubicacionImagen}" 
								id="audioSourceAct02" type="audio/mp3" title="${ejercicio.ubicacionImagen}" />
								<p>Tu navegador no implementa el elemento audio</p>
							</audio> 
						</div>
					</c:when>
					<c:otherwise>
						<input type="hidden" value="0" id="hiddenAud" />
						<div id="contentAudio">
						</div>
					     <label for=""></label>
					</c:otherwise>
				 </c:choose>
	          </div>
	          <div class="form-group">
	            <label for="timesheetinput7">Contexto del audio</label>
	            <div class="position-relative has-icon-left">
	              <textarea id="ejercicioTxtDescripcion" rows="5" class="form-control" name="notes">${ejercicio.descripcionEjercicio}</textarea>
	              <div class="form-control-position">
	                <i class="ft-file"></i>
	              </div>
	            </div>
	          </div>
			  <div class="form-group text-right mb-1">
			      <button type="button" id="btn_guardar_ejercicio" onclick="uploadAjax()" class="btn btn-outline-info btn-min-width">
			        <i class="ft-search"></i> Guardar
			      </button>
			  </div>
	        </div>
	      </div>
	</div>
-->
	
	<div class="tab-panel" id="tab42" aria-labelledby="base-tab42" aria-expanded="true" class="tab-pane active" >
		<input type="hidden" id="idEjercicio"   />
		<div class="row">
			 
	        <div class="col-xs-6">
	        	<div class="form-group">
	          	<input type="hidden" id="idMaterialTipoEjercicio" value=""  />
	          	<%-- ${ejercicio.tituloEjercicio} --%>
	            <label id="titulo" for="timesheetinput1">T&iacute;tulo <span class="required">*</span> </label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" required="required" >
	              
	            </div>
	          </div>
	        <table id="tblPregunta" class="table table-striped table-bordered zero-configuration">
	        <thead>
	        <tr>
		          <div class="form-group">
		          	<input type="hidden" id="idPregunta" value=""/>
		            <label for="timesheetinput7">Pregunta <span class="required">*</span> </label>
		            <div class="position-relative has-icon-left">
		              <textarea id="txtPreguntaDescripcion" rows="3"  class="form-control input-sm" required="true" name="notes"></textarea>
		              <div class="form-control-position">
		                <i class="ft-file"></i>
		              </div>
		            </div>
		          </div>
		     </tr>
		     </thead>
		     <tbody>
				<c:forEach items="${lstRespuestas}" var="item" varStatus="loop">
					<tr>	
			          <div class="form-group row">
			          <div class="col-md-3">
					    <label for="nombreUnidadLec">Respuesta ${loop.index+1} <span class="required">*</span> </label> </div>
					    <div class="col-md-9">
						<fieldset>
							<div class="input-group input-group-xs ">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="${loop.index}" type="radio" name="rpst"  value="${item.codigo}" checked="${item.respuestaEstado == 1 ? true : false}" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion${loop.index}" name="rptaDescripcion${loop.index}" value="${item.descripcion}" required="true"  type="text" class="form-control" aria-describedby="radio-addon1">
							</div>
						</fieldset>
						</div>
			          </div>
		         	</tr>
				</c:forEach>
	         </tbody>
	         
	       
	          <tfoot>
				  
			  </tfoot>
			  </table>
			  
	        </div>
	        
	        
	        
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped" id="tblListaMatTEjerPreg">
                    	<thead>
                    		<tr>
                    			<th>#</th>
                    			<th>T&iacute;tulo</th>
                    			<th>Pregunta</th>
                    			<th>Acciones</th>
                    		</tr>
                    	</thead>
						<tbody id="tbodyMatTEjerPreg">
							<c:forEach items="${actividadMatTipoEjer}" var="item" varStatus="loop"  >
								<tr id="${item.materialEjercicioBean.codigo}${item.codigo}">
									<td>${loop.index+1}</td>
									<td>${item.materialEjercicioBean.titulo}</td>
									<td>${item.descripcion}</td>
									<td>
	                                    <button type="button" class="btn btn-outline-success btn-sm " data-toggle="tooltip" onclick="editarMatTEjerPreg('${item.materialEjercicioBean.codigo}','${item.codigo}','${item.materialEjercicioBean.titulo}','${item.descripcion}')" data-original-title="Editar"><i class="icon-pencil"></i></button>
	                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" onclick="eliminarMatTEjerPreg('${item.materialEjercicioBean.codigo}')" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                    </td>
								</tr>
						   	</c:forEach>
						 
	         <!-- <tr>
		          <div class="form-group">
		          	<div class="col-md-12">
				    	<label for="nombreUnidadLec">Respuesta 01</label> 
				    </div>
				    <div class="col-md-12">
						<fieldset>
							<div class="input-group input-group-xs ">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="0" type="radio" name="rpst" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion0" name="rptaDescripcion0" type="text" required="true" class="form-control" aria-describedby="radio-addon1">
							</div>
						</fieldset>
					</div>
				
				<div class="form-group col-md-2 "> 
						<button type="button" onc class="btn btn-outline-info btn-min" style="margin-top:-18px">
						<i class="ft-plus"></i></button>
				 	</div>
		          </div> 
		        </tr> --> 
		       
		       <!--  <tr>	
			          <div class="form-group">
			          <div class="col-md-12">
					    <label for="nombreUnidadLec">Respuesta 02</label> </div>
					    <div class="col-md-12">
						<fieldset>
							<div class="input-group input-group-xs ">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="1" type="radio" name="rpst" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion1" name="rptaDescripcion1" required="true"  type="text" class="form-control" aria-describedby="radio-addon1">
							</div>
						</fieldset>
						</div>
			          </div>
		          </tr>
		          <tr>
		          	           <div class="form-group">
			          <div class="col-md-12">
					    <label for="nombreUnidadLec">Respuesta 03</label> </div>
					    <div class="col-md-12">
						<fieldset>
							<div class="input-group input-group-xs ">
								<span class="input-group-addon" id="radio-addon1">
									<label class="custom-control custom-radio inline">
										<input id="2" type="radio" name="rpst" class="custom-control-input">
										<span class="custom-control-indicator"></span>
									</label>
								</span>
								<input id="rptaDescripcion2" name="rptaDescripcion2" required="true" type="text" class="form-control" aria-describedby="radio-addon1">
							</div>
						</fieldset>
						</div>
			          </div>
		          </tr>
		          <tr>
		          	           <div class="form-group">
		          <div class="col-md-12">
				    <label for="nombreUnidadLec">Respuesta 04</label> </div>
				    <div class="col-md-12">
					<fieldset>
						<div class="input-group input-group-xs ">
							<span class="input-group-addon" id="radio-addon1">
								<label class="custom-control custom-radio inline">
									<input id="3" type="radio" name="rpst" class="custom-control-input">
									<span class="custom-control-indicator"></span>
								</label>
							</span>
							<input id="rptaDescripcion3" name="rptaDescripcion3" type="text" required="true" class="form-control" aria-describedby="radio-addon1">
						</div>
					</fieldset>
					</div>
		          </div>
		         
		          </tr> -->
		          
	          </tbody>
                    </table>
                </div>
                 <div class="form-group text-right mb-1">
				      <button type="button" class="btn btn-outline-info btn-min-width" onclick="grabarMaterialTipoEjercicio2()" style="margin-top:15px">
				        <i class="ft-search"></i> Guardar
				      </button>
				  </div>
	      	</div>
	      </div>

	</div>
	<div class="tab-pane" id="tab43" aria-labelledby="base-tab43">
		<p>Sugar plum tootsie roll biscuit caramels. Liquorice brownie pastry cotton candy oat cake fruitcake jelly chupa chups. Pudding caramels pastry powder cake soufflé wafer caramels. Jelly-o pie cupcake.</p>
	</div>
</div>
</f:form>


