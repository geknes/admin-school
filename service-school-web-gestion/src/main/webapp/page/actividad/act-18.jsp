<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarRelacionCabecera()"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
<!-- 		<a class="nav-link" onclick="listadoRelacionActividad()"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
 -->	</li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body">
	         
	        <div class="col-xs-6">
	          <div class="form-group">
	          	<input type="hidden" id="idEjercicio" value="0"  />
	          	<%-- ${ejercicio.tituloEjercicio} --%>
	            <label id="titulo" for="timesheetinput1">T&iacute;tulo</label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}">
	              
	            </div>
	          </div>
	           
	          <div class="form-group">
	          <%--   <label for="timesheetinput7">Descripci&oacute;n</label>
	            <div class="position-relative has-icon-left">
	              <textarea id="ejercicioTxtDescripcion" rows="5" class="form-control" name="notes">${ejercicio.descripcionEjercicio}</textarea>
	              <div class="form-control-position">
	                <i class="ft-file"></i>
	              </div>
	            </div> --%>
	          
			<!--   <div class="form-group text-right mb-1">
			      
			  </div>	 -->          
	          
			 <div class="form-group text-right mb-1">
			  	  <button type="button" id="btn_nuevo_ejercicio" onclick="nuevoMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-plus"></i> Nuevo
			      </button>
			      <button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
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
                                <th>Ejercicio</th>
                                <th>Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idBodyListadoMaterialTipoEjercicio"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>
	</div>

	
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
	
		<div class="row">
	        <div class="col-xs-6">
	        <table id="tblRelacion">
	        	<thead>
	        		<tr>
	        			<td colspan="2">
	        				<div class="form-group">
					          	<input type="text" id="idRelacionCabecera" value="0"  />
					          	<%-- ${ejercicio.tituloEjercicio} --%>
					            <label id="" for="timesheetinput1">T&iacute;tulo</label>
					            <div class="position-relative ">
					              <input type="text" id="relacionTitulo" class="form-control" name="employeename" value="">
					            </div>
					        </div>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td colspan="" align="center">
	        				<label for="">Imagen</label>
	        			</td>
	        			<td colspan="" align="center">
	        				<label for="timesheetinput7">Palabra</label>
	        			</td>
	        		</tr>
	        		
	        	</thead>
	        	<tbody>
	        		<tr>
			          <td>
						<fieldset>
							<!-- <input type="file" id="file0" name="files[]" multiple onchange="handleFileSelect_mini(event); " /> -->
							<input id="idRelacionDetalle1" type="text" value="0"/>
							<input id="idNombreImg1" type="text" value=""/>
							<f:input type="file" path="relacion.file" name="file1" id="file1" onchange="return validar_file('file1','imgmas1','${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}','codigoMascota')" value="" accept="image/png, .jpeg, .jpg, image/gif" style="display:none"/>
							<div id="list1"   style="cursor: pointer;">
                            	<c:choose>
                                	<c:when test="${not empty relacion.imagen}">
	                                    <label for=""><img id="imgmas1" onclick="abrir_input('file1')" src="${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
	                                    <div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
                                 	</c:when>
                                             	 
                            		<c:otherwise>
                                		<label for=""><img id="imgmas1" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file1')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
                                  	</c:otherwise>
                              	</c:choose>
                        	</div>
						</fieldset>
			          </td>
			          <td>
						<fieldset>
							<div class="form-group">
					        <div class="position-relative has-icon-left">
					        <textarea id="txtPalabra1" rows="1" class="form-control input-sm" name="notes"></textarea>
					        <div class="form-control-position">
					        <i class="ft-file"></i>
					        </div>
					        </div>
					        </div>
						</fieldset>
			          </td>
		          </tr>
		          <%-- <tr>
			          <td>
						<fieldset>
							<!-- <input type="file" id="imgEjercicio" style="display:none"> -->
							<!-- <input type="file" id="file1" name="files[]" multiple onchange="handleFileSelect_mini(event); " /> -->
							<input id="idRelacionDetalle2" type="hidden" value="0"/>
							<input id="idNombreImg2" type="hidden" value=""/>
							<f:input type="file" path="relacion.file" name="file2" id="file2"  onchange="return validar_file('file2','imgmas2','${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}','codigoMascota')" accept="image/png, .jpeg, .jpg, image/gif" style="display:none"/>
							<div id="list2"   style="cursor: pointer;">
                            	<c:choose>
                                	<c:when test="${not empty relacion.imagen}">
                                    	<label for=""><img id="imgmas2" onclick="abrir_input('file2')" src="${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                                    </c:when>
                                    <c:otherwise>
                                       	<label for=""><img id="imgmas2" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file2')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
                                  	</c:otherwise>
                               	</c:choose>
                          	</div>
						</fieldset>
			          </td>
			          <td>
						<fieldset>
							<div class="form-group">
					        <div class="position-relative has-icon-left">
					        <textarea id="txtPalabra2" rows="1" class="form-control input-sm" name="notes"></textarea>
					        <div class="form-control-position">
					        <i class="ft-file"></i>
					        </div>
					        </div>
					        </div>
						</fieldset>
			          </td>
		          </tr>
		          <tr>
			          <td>
						<fieldset>
							<!-- <input type="file" id="imgEjercicio" style="display:none"> -->
							<!-- <input type="file" id="file2" name="files[]" multiple onchange="handleFileSelect_mini(event); "/> -->
							<input id="idRelacionDetalle3" type="hidden" value="0"/>
							<input id="idNombreImg3" type="hidden" value=""/>
							<f:input type="file" path="relacion.file" name="file3" id="file3" onchange="return validar_file('file3','imgmas3','${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}','codigoMascota')" accept="image/png, .jpeg, .jpg, image/gif" style="display:none"/>
							<div id="list3"   style="cursor: pointer;">
                            	<c:choose>
                            		<c:when test="${not empty relacion.imagen}">
                                        <label for=""><img id="imgmas3" onclick="abrir_input('file3')" src="${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}"  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                            		</c:when>
                            		<c:otherwise>
                            			<label for=""><img id="imgmas3" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file3')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
                            		</c:otherwise>
                            	</c:choose>
                           	</div>
						</fieldset>
			          </td>
			          <td>
						<fieldset>
							<div class="form-group">
					        <div class="position-relative has-icon-left">
					        <textarea id="txtPalabra3" rows="1" class="form-control input-sm" name="notes"></textarea>
					        <div class="form-control-position">
					        <i class="ft-file"></i>
					        </div>
					        </div>
					        </div>
						</fieldset>
			          </td>
		          </tr> --%>
	        	</tbody>
	        	<tfoot>
	        		<tr>
	        			<td>
	        					
	        			</td>
		        		<td colspan="2">
		        			<div class="form-group text-right">
			      				<button type="button" id="btn_nuevo_actividad" onclick="nuevoRelacion()" class="btn btn-outline-info btn-min-width">
			        			<i class="fa fa-plus"></i> Nuevo
			      				</button>
			      				<button type="button" id="btn_guardar_actividad" class="btn btn-outline-info btn-min-width" onclick="insertarRelacionCabecera()">
								<i class="fa fa-floppy-o"></i> Guardar
								</button>
			  				</div>
		        			<!-- <div class="form-group text-right mt-2" >
								
							</div> -->
		        		</td>
	        		</tr>
	        	</tfoot>
	        </table>
			  
	        </div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
						<thead>
                            <tr>
                                <th width="30">#</th>
                                <th>Palabra</th>
                                <th>Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idTablaRelacionListado"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
		</div>
	</div>
</div>
</f:form> 