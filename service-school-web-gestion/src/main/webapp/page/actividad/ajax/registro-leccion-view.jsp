<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Registro Lecci&oacute;n</a>
	</li>
	 <li class="nav-item">
		<a class="nav-link" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Registro Material</a>
	</li>

</ul>
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<f:form class="form" id="frmRegLeccion"  method="post" >
			<input type="hidden" id="idLeccion" />
			<div class="form-body">
			        <div class="col-xs-12">
			          <div class="form-group">
			            <label id="titulo" for="timesheetinput1">Nombre de la Lecci&oacute;n</label>
			            <div class="position-relative ">
			              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${unidadLeccion.nombre}">
			            </div>
			          </div>
	
			        </div>
	
					<div class="col-xs-3">
						<div class="form-group">
						    <label >Situaci&oacute;n</label>
						      <input type="hidden" id="txtLeccionSituacion" class="form-control" name="employeename" value="${unidadLeccion.situacion.codigoRegistro}">
						  	<f:select id="cboLeccionSituacion" path="situacion.codigoRegistro" itemValue="codigoRegistro" itemLabel="codigoRegistro"   class="form-control">
						        <option value="0">Borrador</option>
						        <option value="1">Publicado</option>
						        <option value="2">Proceso</option>
						    </f:select>
						</div>
					</div>
					<div class="col-xs-12">
						<div class="form-group text-right">
						  <button type="button" id="btn_guardar_ejercicio" onclick="grabarLeccion()" class="btn btn-outline-info btn-min-width">
						    <i class="fa fa-floppy-o"></i> Guardar
						  </button>
						</div>
					</div>
	    	</div>
    	</f:form>
	</div>

	 <div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
	 <f:form class="form" id="frmRegMaterial"  method="post" >
	 	<input type="hidden" id="idMaterial" />
		<div class="row">
    	<div class="col-xs-6">
			<div class="form-body">
				<div class="col-xs-12">
					<div class="form-group">
					    <label >Tipo Material</label>
					    <input type="hidden" id="txtTipoMaterial" value="${leccionMaterialBean.situacionLeccionMaterial.codigoRegistro}" />
					  	<select id="modalCboTipoMaterial" name="leccionMaterialBean.situacionLeccionMaterial.codigoRegistro" class="form-control">
					        <option value="0" selected="selected">Seleccionar</option>
					        <option value="1">Texto, Audio, Imagen</option>
					        <option value="2">Texto, Audio</option>
					    </select>
					</div>
				</div>
				<div class="col-xs-12">
					<fieldset class="form-group">
					    <label for="basicInputFile">Imagen</label>
					    <input type="file" multiple accept="image/*" class="form-control-file"
					     id="basicInputFile" name="basicInputFile[]" onchange="handleFileSelect(event);" style="display:none">
					     
					    <div id="bodyImagen" onclick="obtenerImagen();" style="cursor: pointer;">
							<c:choose>
						        <c:when test="${not empty leccionMaterialBean.nombreImagen}">
						        <input type="hidden" value="1" id="hiddenImg" />
						        	<div id="contentImg"><label for=""><img src="${pageContext.request.contextPath}/material/${leccionMaterialBean.nombreImagen}" alt="${leccionMaterialBean.nombreImagen}" title="${leccionMaterialBean.nombreImagen}" style="cursor: pointer;max-width:30%" class="thumb2"></label>
						        	</div>
						        </c:when>
						        <c:otherwise>
						        	<input type="hidden" value="0" id="hiddenImg" />
						        	<div id="contentImg">
						        		<label for=""><img src="../assets/img/usar_imagen.jpg" alt="element 01" class="img-fluid" style="cursor: pointer;max-width:30%"></label>
						        	</div>
						        </c:otherwise>
					        </c:choose>
							<!-- <label for=""><img src="../assets/img/usar_imagen.jpg" onclick="obtener_imagen();" alt="element 01" class="img-fluid" style="cursor: pointer;"></label> -->
							
						</div> 
					</fieldset>
				</div>
				<div class="col-xs-12">
					<fieldset class="form-group">
					    <label for="basicInputAudio">Audio</label>
					    <input type="file" class="form-control-file" accept="audio/*" id="basicInputAudio" 
					    		name="basicInputAudio[]" style="display:none" onchange="handleAudioSelect(event)">
					    <br />
					    <img src="../assets/img/usar_audio.jpg" width="36" onclick="obtenerAudio()" class="img-fluid"  style="cursor: pointer;">
					    <span id="spanNombreMp3"></span>
					    <c:choose>
							<c:when test="${not empty leccionMaterialBean.rutaAudio}">
								<input type="hidden" value="1" id="hiddenAud" />
								<div id="contentAudio">
									<audio id="audioAct02"  preload="auto" controls>
										<source src="${pageContext.request.contextPath}/material/${leccionMaterialBean.rutaAudio}" 
										id="audioSourceAct02" type="audio/mp3" title="${leccionMaterialBean.rutaAudio}" />
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
					</fieldset>
				</div>
				<div class="col-xs-12">
					<div class="form-group">
					    <label >Descripci&oacute;n</label>
						<div class="position-relative has-icon-left">
						  <textarea id="ejercicioTxtDescripcion" value="${leccionMaterialBean.contexto}" rows="3" class="form-control" name="notes"></textarea>
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div>
					</div>
				</div>
				<div class="col-xs-12">
					<div class="form-group text-right">
					  <button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterial()" class="btn btn-outline-info btn-min-width">
					    <i class="fa fa-floppy-o"></i> Guardar
					  </button>
					</div>
					</div>
		      </div>
    	</div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th width="30" class="text-xs-center">#</th>
                                <th>Tipo Material</th>
                                <th width="80" class="text-xs-center">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyTipoMaterial">
                            
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>
		</f:form>
	</div>
</div>
<script type="text/javascript" charset="utf-8">
	function obtenerAudio(){
		document.getElementById("basicInputAudio").click();
	}
	function obtenerImagen(){
		document.getElementById('basicInputFile').click();
	}
	

	function handleAudioSelect(evt){
		$("#hiddenAud").val("0");
		var fullPath = document.getElementById('basicInputAudio').value;
		if (fullPath) {
		    var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
		    var filename = fullPath.substring(startIndex);
		    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
		        filename = filename.substring(1);
		    }
			$("#spanNombreMp3").text(filename);
		}
	}
	function handleFileSelect(evt){
		$("#hiddenImg").val("0");
		var files = evt.target.files; // FileList object
 	    for (var i = 0, f; f = files[i]; i++){
	 	    if (!f.type.match('image.*')){
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	    reader.onload = (function(theFile){
	 	    	return function(e){
	 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	        };
			})(f);
	 	   	reader.readAsDataURL(f);
 	    }
	}
</script>

