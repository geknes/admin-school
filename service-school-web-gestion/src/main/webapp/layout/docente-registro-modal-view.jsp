   <%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
	 <script src="${pageContext.request.contextPath}/assets/js/page/busqueda-ubigeo.js" type="text/javascript"></script>
	
    <!-- Modal -->

     <script type="text/javascript">

     function limpiarForm(){
    	 document.getElementById('frmregistromodal').reset();
    	 
     }

     function agregar_Tabla_especialidad(){
    	 var numFilas=$('#tablalistadoEspecialidad >tr').length;
    	
			lengua=document.getElementById("codigoLengua");
			nivel=document.getElementById("codigoNivel");

			var codigoDocente = $('#codigoDocente').val();	
			if(codigoDocente!=0 && codigoDocente!=null){
			
				var codigoLengua = lengua.value;
				var codigoNivel = nivel.value;
				registrarEspecialidadDocente(codigoDocente,codigoLengua,codigoNivel);
				obtenerEspecialidadDocenteXCodigoDocente();
				}
			else{



			
		var a=0;
			for(var i=0;i<numFilas;i++){
				var codigoLengua = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
			if(codigoLengua==lengua.value){

				a=a+1;
				}
	 	
			}
			
    	 if(lengua.value!=0 && lengua.value!=null && lengua.value!="" && nivel.value!=0 && nivel.value!=null && nivel.value!="" && a==0) {
        	
    	 var table = document.getElementById("tablalistadoEspecialidad");
    	 
    	 var row = table.insertRow(numFilas);
         var cell1 = row.insertCell(0);
       
         var cell2 = row.insertCell(1);
         var cell3 = row.insertCell(2);
         var cell4 = row.insertCell(3);
         var cell5 = row.insertCell(4);
         cell1.style['display'] = "none";
         cell3.style['display'] = "none";
 		var codLengua=lengua.value;
 		var nombreLengua=$("#codigoLengua option:selected").text();
 		var codNivel=nivel.value;
 		var nombreNivel=$("#codigoNivel option:selected").text();
 		
 		
 	    document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[0].innerHTML=codLengua;
 	  	document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[1].innerHTML=nombreLengua;
 	  	document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[2].innerHTML=codNivel;
 		document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[3].innerHTML=nombreNivel;
 		document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[4].innerHTML=
 			"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarFilaTablaEspecialidad('"+codLengua+"');\"><i class='icon-trash'></i></button>";
    	 }

	}
    	 
}


     function eliminarFilaTablaEspecialidad(codLengua){

    	

    	 var numFilas =$('#tablalistadoEspecialidad >tr').length;
    
			for(var i=0;i<numFilas;i++){
					var codigoLengua = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;

					if(codigoLengua==codLengua){

					 $("#tablalistadoEspecialidad tr:eq('"+i+"')").remove();
					 break;
					}
		 	
				}

    	 

         }
     function obtenerDatosEspecialdadDocente(idDocente){

    	for(var i=0;i<$('#tablalistadoEspecialidad >tr').length;i++){
    		var codigoLengua     = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
    		var codigoNivel     = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[2].innerHTML;
    		
    		registrarEspecialidadDocente(idDocente,codigoLengua,codigoNivel);

           	 }
			

         }


     function registrarEspecialidadDocente(codigoDocente,codigoLengua,codigoNivel){

    		var pathUrl = "${pageContext.request.contextPath}/docenteController/grabarEspecialidadDocente?codigodocente="+codigoDocente+"&codigolengua="+codigoLengua+"&codigonivel="+codigoNivel;
    		var html = "";
      		
    		$.ajax({
      			type : "POST",
      			url : pathUrl,
      			success : function(data) {
      				console.log("Exito: "+ data );
      			
      			
      			},
      			error : function() {
      				console.log("ERROR: ");
      				msg_advertencia("Ocurrio un error");
      			}
      		});

      		

         }
     $( document ).ready(function() {
    	 buscarUbigeo();
    	   
    	});
 	
     function buscarDocentexFiltros(){
  		var codigoinst = $('#idCodigoInstitucionInscLengua').val();
  		var codigoInscLen =$('#idCodigoInscripcionLengua').val();
  		var nombredoc = $('#nombredocente').val();
  		var numerodoc = $('#numdocumento').val();
		var pathUrl = "${pageContext.request.contextPath}/docenteController/buscardocente";
		var dataParams = "codigoInst="+codigoinst+"&nombreDocente="+nombredoc+"&numeroDocumento="+numerodoc+"&codigoinsclengua="+codigoInscLen;
		var html = "";
		$.ajax({
  			type : "GET",
  			data: dataParams,
  			url : pathUrl,
  			
  			success : function(data) {

  				if(data!=null && data.length!=0){

  					for(var i=0;i<data.length;i++){

  	  					html=html+"<tr><td>"+data[i].personaBean.nombrePersona +" "+ data[i].personaBean.apellidoPaterno+" "+data[i].personaBean.apellidoMaterno +"</td><td>"+data[i].personaBean.numeroDocumento+"</td><td><button type='button' onclick='registrarAsignarDocente("+data[i].codigo+");' class='btn btn-outline-success btn-sm'><i class='icon-arrow-right'></i> </button></td></tr>";
  	  					

  	  					}
  	  				
  	  				document.getElementById("listaDocentes").innerHTML=html;
  	  				
  	  				}else{
  	  				document.getElementById("listaDocentes").innerHTML="No se Encontraron Registros"
  	  				}
  				

  				
  			},
  			error : function() {
  				console.log("ERROR: ");
  			}
  		});
  	
   };

   
	function convertirFecha(fecha) {
		var strFecha = "";
		var fecha = new Date(fecha);
		var dia = "";
		var mes = "";
		if (fecha.getDate().toString().length == 1) {
			dia = "0" + fecha.getDate().toString();
		} else {
			dia = fecha.getDate().toString();
		}
		if ((fecha.getMonth() + 1).toString().length == 1) {
			mes = "0" + (fecha.getMonth() + 1);
		} else {
			mes = (fecha.getMonth() + 1).toString();
		}
		return strFecha = dia + "/" + mes + "/" + fecha.getFullYear();
	}

	function validarPersona() {

		var tipoDocumento = $('#codigoTipoDocumento').val();
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		if (numeroDocumento == null && numeroDocumento == "") {
			numeroDocumento = 0;
		}
		$
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/personaController/validapersona?tipodocumento="
							+ tipoDocumento
							+ "&numerodocumento="
							+ numeroDocumento,
					success : function(data) {
						if (data.codigo != 0) {
							$('#codigoTipoDocumento').val(
									data.tipoDocumento.codigoRegistro);
							$('#numeroDocumentoPersona').val(
									data.numeroDocumento);
							$('#codigoPersona').val(data.codigo);
							/*$('#codigoPersonal').val();*/
							/*$('#situacionPersonal').val(data);*/
							$('#nacionalidadPersona').val(
									data.nacionalidad.codigoRegistro);
							$('#nombrePersona')
									.val(data.nombrePersona);
							$('#apellidoPaternoPersona').val(
									data.apellidoPaterno);
							$('#apellidoMaternoPersona').val(
									data.apellidoMaterno);
							var strFecha = convertirFecha(data.fechaNac);
							$('#fechaNacimiento').val(strFecha);
							$('#lenguaMaterna').val(
									data.lenguaBean.codigo);

							/*$('#gradoPersonal').val(data.);*/
							/*$('#cargoPersonal').val();*/
							$('#sexoPersona').val(
									data.sexo.codigoRegistro);
							$('#telefonoUsuario').val(data.telefono);
							$('#correoElectronico').val(data.correo);
							$('#ubigeoNombre').val(data.ubigeoBean.nombreUbigeo);
							$('#ubigeoCodigo').val(data.ubigeoBean.codigo);

					

							$('#direccionPersona').val(
									data.direccionPersona);

						}

					},
					error : function() {
						console.log("ERROR: ");
					}
				});
	}




	function obtenerEspecialidadDocenteXCodigoDocente(){
  		var codigoDocente = $('#codigoDocente').val();
  		
		var pathUrl = "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente;
		var html = "";
		$.ajax({
  			type : "GET",
  			url : pathUrl,
  			
  			success : function(data) {

				if(data.length!=0 && data.length!=null){


  				$('#codigoLengua').val(data[0].lenguaBean.codigo);

  				$('#codigoNivel').val(data[0].tm2Nivel.codigo);
  				
  				for(var i=0;i<data.length;i++){

  					html=html+"<tr><td style='display:none;'>"+data[i].lenguaBean.codigo +"</td><td>"+data[i].lenguaBean.nombre+"</td><td style='display:none;'>"+data[i].tm2Nivel.codigo+"</td><td>"+data[i].tm2Nivel.nombreCorto+"</td><td><button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarEspecialidad('"+data[i].docenteBean.codigo+"','"+data[i].lenguaBean.codigo+"');\"><i class='icon-trash'></i></button></td></tr>";
  					

  					}
  				
  				document.getElementById("tablalistadoEspecialidad").innerHTML=html;

				}
  			},
  			error : function() {
  				console.log("ERROR: ");
  			}
  		});
  	
   };


   function eliminarEspecialidad(codigoDocente,codigoEspecialidad){

		 $.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/docenteController/eliminarEspecialidad?codigo="+codigoDocente+"&codigoEspecialidad="+codigoEspecialidad,
				success : function(data) {
					if(data=='1'){
						msg_exito();
						obtenerEspecialidadDocenteXCodigoDocente();
					}else if(data=='0'){
						msg_error();
					}
				},
				error : function() {
					console.log("ERROR: ");
				}
			});
		
	}


   function buscarPersona(e) {
		if (e.which == 13 || e.keyCode == 13) {
			var numerodocumento = $('#numeroDocumentoPersona').val();
			if (numerodocumento.length > 7
					&& numerodocumento.length < 13) {
				validarDocente();
			}
		}
	}


   function justNumbers(e) {
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		var tipoDocumento = $('#codigoTipoDocumento').val();
		if (tipoDocumento != 0) {
			/*DNI*/
			if (tipoDocumento == 1) {
				if (numeroDocumento.length < 8) {
					var keynum = window.event ? window.event.keyCode
							: e.which;
					if ((keynum == 8) || (keynum == 46))
						return true;
					return /\d/.test(String.fromCharCode(keynum));
				} else {
					var keynum = window.event ? window.event.keyCode
							: e.which;
					if ((keynum == 8))
						return true;
					e.preventDefault();
				}
			}
			/*PASAPORTE*/
			if (tipoDocumento == 2) {
				if (numeroDocumento.length < 12) {
					 key = e.keyCode || e.which;
					    tecla = String.fromCharCode(key).toString();
					    letras = " 1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

					    tecla_especial = false
					    for(var i in especiales) {
					        if(key == especiales[i]) {
					            tecla_especial = true;
					            break;
					        }
					    }

					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
					/* alert('Tecla no aceptada');*/
					        return false;
					      }
				} else {
					e.preventDefault();
				}
			}

		}
	}

 	
	
	function validarDocente() {

	
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		if (numeroDocumento == null && numeroDocumento == "") {
			numeroDocumento = 0;
		}
		$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/docenteController/validarDocenteinscr?numerodocumento="+numeroDocumento,
					success : function(data) {
						if (data.codigo != 0) {
							$('#codigoTipoDocumento').val(
									data.personaBean.tipoDocumento.codigoRegistro);
							$('#numeroDocumentoPersona').val(
									data.personaBean.numeroDocumento);
							$('#codigoPersona').val(data.personaBean.codigo);
							
							$('#codigoDocente').val(data.codigo);
							$('#situacionDocente').val(data.situacion.codigoRegistro);

							
							$('#nacionalidadPersona').val(
									data.personaBean.nacionalidad.codigoRegistro);
							$('#nombrePersona')
									.val(data.personaBean.nombrePersona);
							$('#apellidoPaternoPersona').val(
									data.personaBean.apellidoPaterno);
							$('#apellidoMaternoPersona').val(
									data.personaBean.apellidoMaterno);
							var strFecha = convertirFecha(data.personaBean.fechaNac);
							$('#fechaNacimiento').val(strFecha);
							$('#lenguaMaterna').val(
									data.personaBean.lenguaBean.codigo);
							$('#sexoPersona').val(
									data.personaBean.sexo.codigoRegistro);
							$('#telefonoUsuario').val(data.personaBean.telefono);
							$('#correoElectronico').val(data.personaBean.correo);

							$('#ubigeoNombre').val(data.personaBean.ubigeoBean.nombreUbigeo);
							$('#ubigeoCodigo').val(data.personaBean.ubigeoBean.codigo);

							$('#direccionPersona').val(
									data.personaBean.direccionPersona);

							
							
							$('#lblInstitucion').val(
									data.institucionBean.codigo);

							$('#carreraDocente').val(
									data.carreraDocente.codigoRegistro);

							$('#gradoDocente').val(
									data.gradoDocente.codigoRegistro);

							obtenerEspecialidadDocenteXCodigoDocente();

							


						}else{
							validarPersona();
							}

					},
					error : function() {
						console.log("ERROR: ");
					},complete : function(){

						
						}
				});
	}

function capturarDatosUbigeo(nombre,codigo){
	
	$('#ubigeoCodigo').val(codigo);
	$('#ubigeoNombre').val(nombre);
	cerrar_ubigeo();
}

   function buscarUbigeo(){
 		var nombreDepartamento = $('#nombreDepartamento').val();
 		var nombreProvincia =$('#nombreProvincia').val();
 		var nombreDistrito = $('#nombreDistrito').val();
 	
		var pathUrl = "${pageContext.request.contextPath}/baseController/buscarubigeo?nombredepartamento="+nombreDepartamento+"&nombreprovincia="+nombreProvincia+"&nombredistrito="+nombreDistrito;
		var html = "";
		var aux = "";
		var codigoUbigeo="";
		$.ajax({
 			type : "GET",
 			url : pathUrl,
 			
 			success : function(data) {

 				for(var i=0;i<data.length;i++){
					aux="'"+data[i].nombreUbigeo+"'";
					codigoUbigeo="'"+data[i].codigoUbigeo+"'";
 					html=html+"<tr><td>"+data[i].codigoUbigeo +"</td><td>"+data[i].nombreUbigeo+"</td><td><button type='button' " + "onclick="+ '"' +"capturarDatosUbigeo("+String(aux)+","+String(codigoUbigeo)+");"+'"'+" class='btn btn-outline-success btn-sm'><i class='icon-arrow-right'></i> </button></td></tr>";
 					

 					}
 				
 				document.getElementById("tablaListaUbigeo").innerHTML=html;

 				
 			},
 			error : function() {
 				console.log("ERROR: ");
 			}
 		});
 	
  };






   

   function enviar_ajax(){
	   iniciarBloqueo();
	   
         var url = $("#frmregistromodal").attr("action"); //Capturar el action del form

        $.ajax({
              type: "POST",
              url: url,
              data: $("#frmregistromodal").serialize(), // Serializar la data del form
              success: function(data)
              {
                  if(data!=0){
                	  obtenerDatosEspecialdadDocente(data);
                	 
                      }
            	  
            	 
            	  msg_exito();
                  //msg_exito(); //acciones luego de realizar la accion

              },
              error: function(xhr,status,er) {//msg_error();
				console.log("error: " + xhr + " status: " + status + " er:"+ er);

                         if(xhr.status==500) {

                           console.log(er);

                     //         Error_500(er);

                         }

                         if(xhr.status==901) {

                     console.log(er);

                   //      spire_session_901(er);

                     }

                   },

                   complete: function(){
				
//                 	   $("#btn_regresar_doc_modal")
// 						.trigger(
// 								"click");
                	    validarDocente();
//                 	   document.getElementById("frmregistromodal").reset();
                	   buscarDocentexFiltros();
                	   finBloqueo();
//                      $("#closeModalBtnFrm").trigger("click"); // cerrar modal

                     //refrescarListaInstOperador();    // métodos luego delpost

                   }

            });

       return false;

   }


	function registrarAsignarDocente(idcodigodocente){
		

		var idcodigoinsclengua= $('#idCodigoInscripcionLengua').val();
		
  	
		var pathUrl = "${pageContext.request.contextPath}/docenteController/asignardocente?codigoinsclen="+idcodigoinsclengua+"&coddocente="+idcodigodocente;
		var html = "";
		iniciarBloqueo();
		$.ajax({
  			type : "POST",
  			url : pathUrl,
  			success : function(data) {
  				msg_exito();
  				
  				buscarDocentexFiltros();
  				listadoDocentesXInscripcionLengua();
  		
  			},
  			error : function() {
  				console.log("ERROR: ");
  				msg_advertencia("Ocurrio un error");
  				
  			}
  			, complete: function(){
  				 finBloqueo();
  			}
  		});

		}


	//  ----------------------------------- //
	
	
	function IsNumeric(valor) {
				var log = valor.length;
				var sw = "S";
				for (x = 0; x < log; x++) {
					v1 = valor.substr(x, 1);
					v2 = parseInt(v1);
					//Compruebo si es un valor numérico 
					if (isNaN(v2)) {
						sw = "N";
					}
				}
				if (sw == "S") {
					return true;
				} else {
					return false;
				}
			}
			var primerslap = false;
			var segundoslap = false;
			function formateafecha(fecha) {
				var long = fecha.length;
				var dia;
				var mes;
				var ano;
				if ((long >= 2) && (primerslap == false)) {
					dia = fecha.substr(0, 2);
					if ((IsNumeric(dia) == true) && (dia <= 31)
							&& (dia != "00")) {
						fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
						primerslap = true;
					} else {
						fecha = "";
						primerslap = false;
					}
				} else {
					dia = fecha.substr(0, 1);
					if (IsNumeric(dia) == false) {
						fecha = "";
					}
					if ((long <= 2) && (primerslap = true)) {
						fecha = fecha.substr(0, 1);
						primerslap = false;
					}
				}
				if ((long >= 5) && (segundoslap == false)) {
					mes = fecha.substr(3, 2);
					if ((IsNumeric(mes) == true) && (mes <= 12)
							&& (mes != "00")) {
						fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
						segundoslap = true;
					} else {
						fecha = fecha.substr(0, 3);
						;
						segundoslap = false;
					}
				} else {
					if ((long <= 5) && (segundoslap = true)) {
						fecha = fecha.substr(0, 4);
						segundoslap = false;
					}
				}
				if (long >= 7) {
					ano = fecha.substr(6, 4);
					if (IsNumeric(ano) == false) {
						fecha = fecha.substr(0, 6);
					} else {
						if (long == 10) {
							if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
								fecha = fecha.substr(0, 6);
							}
						}
					}
				}
				if (long >= 10) {
					fecha = fecha.substr(0, 10);
					dia = fecha.substr(0, 2);
					mes = fecha.substr(3, 2);
					ano = fecha.substr(6, 4);
					// Año no viciesto y es febrero y el dia es mayor a 28 
					if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
						fecha = fecha.substr(0, 2) + "/";
					}
				}
				return (fecha);
			}


			///------------------------------------///
   
     </script>
     
<!--     <div class="modal fade text-xs-left" id="docente-modal-registro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true"> -->
      <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>DOCENTE</b></label>
        </div>
        <f:form>
        <div class="modal-body" id="listado_docente_modal">
          <div class="row">
            <div class="col-md-5 mb-2">
                <label>Nombre docente</label>
<!--                 <input type="text" class="form-control" name="fname"> -->
 		  <f:input type="text" id="nombredocente" class="form-control" path="personaBean.nombrePersona" />
            </div>
            <div class="col-md-3 mb-2">
                <label>N&uacute;mero documento</label>
                  <f:input type="text" id="numdocumento"  class="form-control" path="personaBean.numeroDocumento"/>
<!--                 <input type="text" class="form-control" name="fname"> -->
            </div>
              <div class="form-group col-md-4 text-right">
                <button type="button" class="btn btn-primary mt-2" onclick="nuevo_docente_modal()"><i class="icon-plus"></i> Nuevo</button>
                  <button type="button" onclick="buscarDocentexFiltros()"  class="btn btn-default mt-2">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <table class="table table-striped table-bordered zero-configuration">
                  <thead>
                      <tr>
                          <th>Docente</th>
                          <th>N&uacute;mero de documento</th>
                          <th width="50">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody id="listaDocentes">
                 
<%--                   <c:forEach var="docenteBean" items="${lstDocenteBean}"> --%>
<!--                       <tr> -->
<%--                           <td>${docenteBean.personaBean.nombrePersona} ${docenteBean.personaBean.apellidoPaterno} ${docenteBean.personaBean.apellidoMaterno}</td> --%>
<%--                           <td>${docenteBean.personaBean.numeroDocumento}</td> --%>
<!--                           <td> -->
<!--                             <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
<!--                           </td> -->
<!--                       </tr> -->
<%--                       </c:forEach> --%>
                     
                    
				
                  </tbody>
              </table>
            </div>
          </div>

        </div>
        
         </f:form>
<!-- ///registro -->
        <div class="modal-body" id="regisro_docente_modal" style="display: none;">
          <f:form class="form mt-1" id="frmregistromodal" onsubmit="return false" name="frmregistromodal" method="post" action="${pageContext.request.contextPath}/docenteController/grabardocente">
            <div class="form-body">
             <div class="row">
                <div class="col-xs-12">
                  <h5>DATOS GENERALES</h5>
                </div>
              </div>
              <div class="row">
               <f:input type="hidden" id="codigoPersona" path="personaBean.codigo"/>
              <f:input type="hidden" id="codigoDocente" path="codigo"/>
            
                 <div class="form-group col-md-3 mb-2">
                    <label for="situacionUsuario">Situaci&oacute;n</label>
                     <div class="controls">
                     <f:select  id="situacionDocente" path="situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                  </div>
                  <div class="form-group col-md-3 mb-2">
                    <label for="situacionUsuario">Tipo Documento</label>
                     <div class="controls">
                     <f:select id="codigoTipoDocumento" path="personaBean.tipoDocumento.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstTipoDocumento}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                  </div>

                  <div class="form-group col-md-3 mb-2">
                      <label for="projectinput2">N&uacute;mero Documento</label>
                       <div class="controls">
                       <f:input id="numeroDocumentoPersona" type="text" class="form-control" path="personaBean.numeroDocumento" onkeypress="buscarPersona(event);return justNumbers(event);" data-validation-required-message="Este campo es requerido" required="required" />
					</div>
<!--                       <input type="text" id="projectinput2" class="form-control" name="lname"> -->
                  </div>

                  <div class="form-group col-md-3">
                    <label for="situacionUsuario">Nacionalidad</label>
                     <div class="controls">
                   <f:select  id="nacionalidadPersona" path="personaBean.nacionalidad.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstNacionalidad}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                  </div>

              </div>

              <div class="row">
                  <div class="form-group col-md-3 mb-2">
                      <label for="projectinput1">Nombres</label>
                       <div class="controls">
                      <f:input id="nombrePersona" type="text" class="form-control" path="personaBean.nombrePersona" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" data-validation-required-message="Este campo es requerido" required="required"/>
	</div>
<!--                       <input type="text" id="projectinput1" class="form-control" name="fname"> -->
                  </div>

                  <div class="form-group col-md-3 mb-2">
                      <label for="apellidopaterno">Apellido Paterno</label>
                       <div class="controls">
                      <f:input id="apellidoPaternoPersona" type="text" class="form-control" path="personaBean.apellidoPaterno" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" data-validation-required-message="Este campo es requerido" required="required"/>
                      </div>
<!--                       <input type="text" id="apellidopaterno" class="form-control" name="apellidopaterno"> -->
                  </div>
                  <div class="form-group col-md-3 mb-2">
                      <label for="projectinput2">Apellido Materno</label>
                       <div class="controls">
                       <f:input id="apellidoMaternoPersona" type="text" class="form-control" path="personaBean.apellidoMaterno" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" data-validation-required-message="Este campo es requerido" required="required"/>
				</div>
<!--                       <input type="text" id="projectinput2" class="form-control" name="lname"> -->
                  </div>
                  <div class="form-group col-md-3 mb-2">
                      <label for="fechanacimiento">Fecha de Nacimiento</label>
                       <div class="controls">
                      <f:input id="fechaNacimiento" type="text" class="form-control" path="personaBean.fechaNac" onKeyUp = "this.value=formateafecha(this.value);" data-validation-required-message="Este campo es requerido" required="required"/>
				</div>

<!--                       <input type="date" id="fechanacimiento" class="form-control" name="fechanacimiento"> -->
                  </div>
              </div>

              <div class="row">
               
                <div class="form-group col-md-3">
                    <label for="projectinput2">G&eacute;nero</label>
                     <div class="controls">
                     <f:select id="sexoPersona" path="personaBean.sexo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSexo}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                </div>

                 <div class="form-group col-md-3">
                    <label for="telefonoUsuario">Tel&eacute;fono / Celular</label>
                     <div class="controls">
                     <f:input id="telefonoUsuario" type="text" class="form-control" name="telefono" path="personaBean.telefono"  data-validation-required-message="Este campo es requerido" required="required"/>
				</div>
<!--                     <input type="text" id="telefonoUsuario" class="form-control" name="lname"> -->
                </div>

                <div class="form-group col-md-3">
                  <label for="telefonoUsuario">Correo Electr&oacute;nico</label>
                   <div class="controls">
                  <f:input id="correoElectronico" type="text" class="form-control" path="personaBean.correo" data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" data-validation-regex-message="Ingresa un correo valido" data-validation-required-message="Este campo es requerido" required="required"/>
			</div>
	<!--                   <input type="text" id="telefonoUsuario" class="form-control" name="lname"> -->
                </div>

			 <div class="form-group col-md-3 mb-2">
                  <label for="situacionUsuario">Lengua Materna</label>
                   <div class="controls">
                  <f:select id="lenguaMaterna" path="personaBean.lenguaBean.codigo" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="0" label="Seleccionar"/>
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                                        </f:select>
                                                        </div>
                </div>



              </div>



              <div class="row">
                <div class="col-xs-12">
                  <h5>DATOS PROFESIONALES</h5>
                </div>
              </div>

              <div class="row">
<!-- 
                <div class="form-group col-md-3 mb-2">
                  <label for="situacionUsuario">Carrera</label>
                   <div class="controls">
                   <f:select id="carreraDocente"  path="carreraDocente.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstCarrera}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                </div>
 -->              
               
                <div class="form-group col-md-6 mb-2">
                  <div class="form-group">
                    <label for="situacionUsuario">Nombre de la Instituci&oacute;n</label>
                     <div class="controls">
                    <f:select id="lblInstitucion" path="institucionBean.codigo" class="select2 form-control" data-validation-required-message="Este campo es requerido" required="required">
							<f:option value="0" label="Seleccionar" />
							<f:options items="${lstInstitucion}" itemValue="codigo" itemLabel="nombreInstitucion" />
						</f:select> 
						</div>
                  </div>
                </div>
               
                      <div class="form-group col-md-3 mb-2">
                    <label for="situacionUsuario">Grado o t&iacute;tulo</label>
                     <div class="controls">
                      <f:select id="gradoDocente"  path="gradoDocente.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstGrado}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                  </div>
              
               
               
               

              </div>
<div class="row">
                <div class="col-xs-12">
                  <h5>LENGUA ORIGINARIA DE DOMINIO</h5>
                </div>
              </div>

              <div class="row">
              
               <div class="form-group col-md-3 mb-2">
                  <label for="situacionUsuario">Lengua </label>
                 <f:select  path="especialidadBean.lenguaBean.codigo" id="codigoLengua" class="form-control selectReset"   data-validation-required-message="Este campo es requerido" required="required">
                                                            
                                                            <f:option value="0" class="optionReset" label="Seleccionar"/>
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                  </f:select>
                </div>
                
                
                  <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Nivel de Dominio</label>
                                                   <div class="controls">
                                                   <f:select  path="especialidadBean.tm2Nivel.codigoRegistro" id="codigoNivel"  class="form-control"   data-validation-required-message="Este campo es requerido" >
                                                            <f:option value="" selected="" label="Seleccionar"/>
                                                            <f:options  items="${lstNivel}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                  </f:select>
                                                  </div>
                                               
                </div>
                <div class="form-group col-md-1 " >
		  			 <button type="button" onclick="agregar_Tabla_especialidad();" class="btn btn-outline-info btn-min" style="margin-top: 20px">
                 <i class="ft-plus"></i></button>
                                                </div>
                
                
                <div class="form-group col-md-5 mb-2" style="overflow: auto;max-height: 200px;"> 
               
                 <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                        	<th style="display:none">Codigo Especialidad</th>
                                                            <th>Especialidad</th>
                                                             <th style="display:none">Codigo Nivel</th>
                                                            <th width="70">Nivel</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tablalistadoEspecialidad">
                                                        <c:forEach var="especialidadBean" items="${lstEspecialidad}">
		                                                 
                                                 		</c:forEach>
                                                    </tbody>
                                                </table>
                </div>
                
               
              </div>
              <div class="row">
												
												  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero de Registro <span class="required">*</span></label>
                                                      <div class="controls">
                                                      <input type="text" class="form-control"  data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" />

                                                	 </div>
                                                  </div>
                                                 <div class="form-group col-md-4">
                                                  <label for="">Subir Documento <span class="required">*</span></label>
                                                  <input type="file" id="file" class="form-control form-control-sm" name="file" data-validation-required-message="Este campo es requerido" >
                                                 </div>
                                               

												<div class="form-group col-md-9">
												 <div class="controls">

												   <!-- onclick="descargarArchivo()" <a  download="Archivo">Descargar Archivo</a>-->
                                                 </div>
                                                 </div>
                                                
                                              </div>
              
              
              

              <div class="row">
                <div class="col-xs-12">
                  <h5> DATOS DE RESIDENCIA </h5>
                  <br>
                </div>
              </div>

	 <div class="row">
                                                <div class="form-group col-md-3">
												        <label for="projectinput2">Regi&oacute;n</label>
												          <f:select path="ubigeoBean.codigoRegion" onchange="buscarProvincia();" id="provinciaSelect" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstRegion}"
                                                                        itemValue="codigoRegion"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Provincia</label>

												        <f:select path="ubigeoBean.codigoProvincia" onchange="buscarDistrito();" id="comboprovincia" name="comboprovincia" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstProvincia}"
                                                                        itemValue="codigoProvincia"
                                                                        itemLabel="nombreUbigeo"/>
                                                       	</f:select>


												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Distrito</label>
												         <f:select path="ubigeoBean.codigoDistrito" id="combodistrito" name="combodistrito" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstDistrito}"
                                                                        itemValue="codigoDistrito"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>

                                              </div>

              <div class="row">
<!--                   <div class="form-group col-md-4"> -->
<!--                     <label for="situacionUsuario">Ubigeo</label> -->
<%--                      <f:input id="ubigeoNombre" type="text" class="form-control" path="personaBean.ubigeoBean.nombreUbigeo" disabled="true" /> --%>
<%--                      <f:input id="ubigeoCodigo" type="hidden" class="form-control" path="personaBean.codigoUbigeo"  /> --%>
<!--                   </div> -->
                  
<!--                   <div class="form-group col-md-2"> -->
<!--                     <label for="situacionUsuario">Buscar Ubigeo</label> -->
<!--                    <button id="agregar_ubi" type="button" onclick="agregar_ubigeo();" class="btn btn-default mr-1"> -->
<!--                         <i class="ft-search"></i> Agregar -->
<!--                       </button> -->
<!--                   </div> -->

						<div class="form-group col-md-9">
                      <label for="direccion">Direcci&oacute;n</label>
                       <div class="controls">
                       <f:input id="direccionPersona" type="text" class="form-control" path="personaBean.direccionPersona" data-validation-required-message="Este campo es requerido" required="required"/>
				</div>
<!--                       <input type="text" id="direccion" class="form-control" name="direccion"> -->
                  </div>
              </div>



              <div class="row">
                  <div class="form-group col-md-12 text-right">
                      <button type="button" onclick="limpiarForm();" class="btn btn-default mr-1">
                        <i class="ft-search"></i> Limpiar
                      </button>
<!--                       <a class="btn btn-primary" href="javascript:enviar_formulario()">Guardar</a>  -->
                      
                      <button type="submit"  onclick="validarRequired('#frmregistromodal');" class="btn btn-primary">
                                                    <i class="ft-search" ></i> Guardar
                                                  </button>

<!--  <button type="button" onclick="abrirModal();" class="btn btn-primary"><i class="icon-plus"></i> Agregar Docente</button> -->
<!--                       <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->

                  </div>
              </div>
            </div>
          </f:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" style="display: none" id="btn_regresar_doc_modal" onclick="listado_docente_modal()">Regresar Listado</button>
          <button type="button" class="btn btn-outline-secondary" id="closeBtnmodalRegistroDocente" data-dismiss="modal">Salir</button>
        </div>
       
      </div>
      </div>
<!--     </div> -->





<script type="text/javascript" charset="utf-8">

$(document).on('click', '#agregar_ubi', function() {
    $('#ubigeo-modal').modal('show');
});

function validarRequired(idfrom){

	var $myForm = $(idfrom);

	var departamento = document.getElementById("provinciaSelect");
	var provincia = document.getElementById("comboprovincia");
	var distrito = document.getElementById("combodistrito");

	var lenguaMaterna = document.getElementById("lenguaMaterna");
	var institucion = document.getElementById("lblInstitucion");
	
	if(! $myForm[0].checkValidity() || departamento.value == "00" ||
			 provincia.value == "00" || distrito.value == "00" ||
			 lenguaMaterna.value == "0"  || institucion.value == "0"){


		$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");

		$("#lenguaMaterna").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#lblInstitucion").css("border", "2px solid rgba(22, 211, 154, .5)");
		
		$("#provinciaSelect").css("color", "#16D39A");
		$("#comboprovincia").css("color", "#16D39A");
		$("#combodistrito").css("color", "#16D39A");

		$("#lenguaMaterna").css("color", "#16D39A");
		$("#lblInstitucion").css("color", "#16D39A");

		 if(departamento.value == "00" ){
				$("#provinciaSelect").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#provinciaSelect").css("color", "#444");
				departamento.focus();
			}
		 if(provincia.value == "00"){
				$("#comboprovincia").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#comboprovincia").css("color", "#444");
				provincia.focus();
			}
		 if(distrito.value == "00"){
				$("#combodistrito").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#combodistrito").css("color", "#444");
				distrito.focus();
			}

		 if(lenguaMaterna.value == "0"){
				$("#lenguaMaterna").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#lenguaMaterna").css("color", "#444");
				lenguaMaterna.focus();
			}

		 if(institucion.value == "0"){
				$("#lblInstitucion").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#lblInstitucion").css("color", "#444");
				institucion.focus();
			}
		 
		 msg_advertencia("Debe completar los campos requeridos correctamente");
	}
	else{
		enviar_ajax();
	}
	
}

 function nuevo_docente_modal(){
	 limpiarForm();
    $("#regisro_docente_modal").show();
    $("#btn_regresar_doc_modal").show();
    $("#listado_docente_modal").hide();
 }
/*  function listado_docente_modal(){
    $("#listado_docente_modal").show();
    $("#regisro_docente_modal").hide();
    $("#btn_regresar_doc_modal").hide();
 } */

 function agregar_ubigeo(){
	
// 	 $('#ubigeo-modal').modal('show');
}

function cerrar_ubigeo(){
	 $("#ubigeo-modal").modal('hide');
	 
	 
}




</script>