<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@page isELIgnored="false" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
<style>
	.thumb2{
	    border: 0px solid #000;
	    margin: 10px 5px 0 0;
	    max-height: 150px;
	    max-width: 150px;
	    overflow: hidden;
	}
</style>
<script>

$( document ).ready(function() {

	prmCodigo="";



});

function seleccionarFilaTabla(valor){
	$("#idBodyTablaMenus .fila_seleccionada_text").css("color", "");
	$("#idBodyTablaMenus .fila_seleccionada").css("background-color", "");
	$("#idBodyTablaMenus #tr_selecc_"+valor).css("background-color", "#fd8469");
	$("#idBodyTablaMenus #tr_selecc_text_"+valor).css("color", "#ffffff");
}

</script>
    <!-- Modal -->
    <div class="modal fade text-xs-left" id="create_actividad" tabindex="-1" role="dialog" aria-labelledby="myModalLabel16" aria-hidden="true" >
      <f:form class="form" id="frmregistromodal" name="frmregistromodal" method="post" action="grabarleccion">
      <div class="modal-dialog modal-xl" role="document">
        <div class="modal-content">
          <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
      <%--    Leccion -->
          ${lstLeccionBean} --%>
          			<%--	${lenguaActividad.nombre} --%>
          <%-- Lengua --> ${lstTipoEjercicio} --%>
         <!--  <div id="lengua">Admin</div> -->
       <!--  <input type="file" id="files" name="files[]" />
				<br />
				<output id="list"></output> -->


         <input type="hidden" id="modalIdTipoEjercicio" value=""/>
          <h4 class="modal-title" id="myModalLabel16">Ejercicios</h4>
          </div>
          <div class="modal-body" style="background: #F5F7FA;">
              <div id="content-md-materail">
                  <div id="left-md-material">
                    <div id="md-material-search" class="col-xs-12">
                      <div class="card-block">
                        <fieldset>
                          <div class="input-group">
                            <input type="text" class="form-control" placeholder="Buscar..." aria-describedby="button-addon4">
                            <span class="input-group-btn" id="button-addon4">
                              <button class="btn btn-primary" type="button"><i class="ft-search"></i></button>
                            </span>
                          </div>
                        </fieldset>
                      </div>
                    </div>
                    <div id="list-md-material" class="media-list">
                        <div class="visible-scroll always-visible scroll-example height-400">
                            <div class="vertical-scroll" id="idBodyTablaMenus">
                            <c:forEach var="tipoEjercicio" items="${lstTipoEjercicio}">
                            <div class="media fila_seleccionada" id="tr_selecc_${tipoEjercicio.codigoRegistro}" actividad-data="${tipoEjercicio.codigoRegistro}" onclick="cargarContenido(${tipoEjercicio.codigoRegistro});seleccionarFilaTabla('${tipoEjercicio.codigoRegistro}');listarMaterialTipoEjercicio();">
                                <a class="media-left" href="#">
                                <!-- ${tipoEjercicio.orden} -->
                                  <img class="media-object" src="${pageContext.request.contextPath}/app-assets/images/portrait/small/avatar-tipo-ejercicio.png" alt="Generic placeholder image" style="width: 64px;height: 64px;">
                                </a>
                                <div class="media-body">
                                  <h4 class="media-heading"><small>${tipoEjercicio.nombreLargo}</small></h4>
                                  <p id="tr_selecc_text_${tipoEjercicio.codigoRegistro}" class="fila_seleccionada_text">${tipoEjercicio.valor1}</p>
                                </div>
                              </div>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                  </div>
                  <%-- <f:form> --%>
                  <div id="right-md-material">
                    <div class="row">
                      <div class="col-xs-12">
                        <div class="card mb-0">
                          <div class="card-block pb-1 pt-1 pl-1 pr-1">
                            <div class="row">
                              <div class="col-md-5 form-group  mb-0">


                                <div id="content-lengua-active">
                                <%-- ${lenguaActividad.codigo} --%>
                                  <%-- <img src="${pageContext.request.contextPath}/assets/img/idioma_01.jpg" alt=""> --%>
                                  <img src="${pageContext.request.contextPath}/lengua/${lenguaActividad.imagenNombre}" alt="Generic placeholder image">
                                  <h3>
                                  	<input type="hidden" value="${lenguaBean.codigo}" id="modalTxtIdLengua"/>
                                  	<div id="modalNombreLengua">${lenguaBean.nombre}</div>
                                    <button type="button" class="btn btn-sm btn-primary " onclick="informe_lengua()">Lecciones</button>

                                  </h3>
                                  <%-- Nivel ---> ${lstNivel} --%>
                                  <input type="hidden" name="" value="">
                                </div>


                                <div id="valores_lengua">

                                  <div>
                                    <span class="vl_txt_nivel">Nivel</span>:
                                    <f:select id="modalCboNivel" path="nivel.codigoRegistro" class="form-control input-sm" disabled="true">
                                       <f:options items="${lstNivel}"
                                                  itemValue="codigoRegistro"
                                                  itemLabel="nombreCorto"/>
                                       <!--  <option selected value="0">B&aacute;sico</option>
                                        <option value="1">Intermedio</option>
                                        <option value="2">Avanzado</option> -->
                                    </f:select>
                                  </div>
                                  <div>
                                    <span class="vl_txt_nivel">Sub nivel</span>:
                                    <f:select id="modalCboSubNivel" path="subNivel.codigoRegistro" class="form-control input-sm" disabled="true">
                                    <f:options items="${lstSubNivel}"
		                                       itemValue="codigoRegistro"
		                                       itemLabel="nombreCorto"/>
                                        <!-- <option selected value="0">B1</option>
                                        <option value="1">B2</option>
                                        <option value="2">B3</option> -->
                                    </f:select>
                                  </div>
                                  <div>

	                               		<span class="vl_txt_nivel">Unidad</span>:
	                                    <f:select id="modalCboUnidad" path="unidad.codigoRegistro" class="form-control input-sm" disabled="true">
	                                        <f:options items="${lstUnidad}"
			                                           itemValue="codigoRegistro"
			                                           itemLabel="nombreCorto"/>
	                                    </f:select>

                                    <div id="btn_confUnidad">
                                      <button type="button" id="btn_salir_unidad" onclick="amv_accion_unidad_salir()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Salir" style="display: none"><i class="ft-arrow-left"></i></button>
                                      <button type="button" id="accionUnidad" onclick="amv_accion_unidad()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Accion"><i class="fa fa-cog"></i></button>
                                    </div>
                                  </div>
                                  <%-- </f:form> --%>
                                </div>


                              </div>
                              <div class="form-group col-md-7 mb-0">

                                <div class="row" id="edicion_actividad_actividad" >
                                  <div id="content_unidad_mtp" class="form-group col-md-8 mb-0" style="display: none">
                                    <label for="unidadSelect" class="mb-0">Unidad</label>
                                     <f:select id="modalSelectCboUnidad" path="unidad.codigoRegistro" class="form-control input-sm">
                                        <f:options items="${lstUnidad}"
		                                           itemValue="codigoRegistro"
		                                           itemLabel="nombreCorto"/>
                                    </f:select>
                                    <!-- <select id="unidadSelect" name="interested" class="form-control">
                                        <option value="design">Unidad 01</option>
                                        <option value="development">Unidad 02</option>
                                        <option selected="" value="illustration">Unidad 03</option>
                                    </select> -->
                                  </div>

                                  <div id="content_leccion_mtp" class="form-group col-md-8 mb-0">
                                    <div class="form-group mb-1">
                                    	<input id="modalIdLeccion" type="hidden" value="">
                                        <label for="projectinput1" class="mb-0">Lecci&oacute;n</label>
										<!-- buscarLeccionMaterial(); -->
                                      <f:select id="modalCboLeccion" path="leccion.codigo" onchange="cargarComboMaterial()" class="form-control input-sm">
                                            <f:option value="0" label="Seleccione"></f:option>
                                            <f:options items="${lstLeccion}"
		                                               itemValue="codigo"
		                                               itemLabel="nombre"/>
                                        </f:select> 

                                        <input type="text" id="modalTxtNombreLeccion" value="" class="form-control" name="fname" style="display: none">
                                    </div>
                                    <div class="form-group mb-0">
                                         <input id="modalIdMaterial" type="hidden" value="">
	                                     <label for="projectinput1" class="mb-0">Material</label>
                                       <!--  onchange="listarMaterialTipoEjercicio();limpiarMaterialTipoEjercicio()"  -->
	                                       <f:select id="modalCboMaterial" path="material.codigo" 
	                                    	onchange="listarMaterialTipoEjercicio();limpiarMaterialTipoEjercicio()"
	                                        class="form-control input-sm">
	                                           <f:option value="0" label="Seleccionar Material"></f:option>
	                                           <f:options items="${lstMaterial}"
	                                                   itemValue="codigo"
	                                                   itemLabel="nombreLeccion"/>
	                                       </f:select>
                                    </div>
                                  </div>
                                  <div class="col-md-4">
                                    <button type="button" id="btn_editar_leccion" onclick="editarLeccionCargarModal()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>

<!--                                     <button type="button" id="btn_guardar_leccion" onclick="amv_guardar_leccion()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Guardar" style="display: none"><i class="fa fa-floppy-o"></i></button> -->

                                    <button type="button" id="btn_nuevo_leccion" onclick="leccionCargarModal()" style="" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Nuevo"><i class="ft-plus"></i></button>

<!--  
                                    <button type="button" id="btn_eliminar_leccion" onclick="eliminarLeccion()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Eliminar"><i class="ft-trash-2"></i></button>

                                   <button type="button" id="btn_salir_leccion" onclick="amv_salir_edicion_leccion()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Salir" style="display: none"><i class="ft-arrow-left"></i></button> -->
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-12">
                        <div class="card">
                          <div id="content-md-frm" class="card-block pt-0 pb-0">

                          </div>
                        </div>
                      </div>
                    </div>
                  </div>


              </div>
          </div>
          <div class="modal-footer">
          <button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal">Close</button>
        </div>
        </div>
      </div>
     </f:form>
    </div>

   <script src="${pageContext.request.contextPath}/assets/js/actividad.js" type="text/javascript"></script>
   <script src="${pageContext.request.contextPath}/assets/js/actividad/relacion.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad/ArrastrarOracion.js" type="text/javascript"></script>
   <script src="${pageContext.request.contextPath}/assets/js/actividad/oracionCompletar.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/assets/js/actividad/textoPalabraCorrecta.js" type="text/javascript"></script>
   
   <script type="text/javascript" charset="utf-8">

      function amv_accion_unidad(){
        $("#content_unidad_mtp").show(100);
        $("#btn_salir_unidad").show(100);

        $("#accionUnidad").hide();
        $("#content_leccion_mtp").hide();
      }
      function amv_accion_unidad_salir(){

    	let idUnidad = $("#modalSelectCboUnidad").val();

        $("#content_unidad_mtp").hide();
        $("#content_leccion_mtp").show(100);
        $("#btn_salir_unidad").hide();
        $("#accionUnidad").show();

        $('#modalCboUnidad').val(idUnidad);


      }
      function capturar_valor(){
          var valorSelect = $("#amv_select_leccion option:selected").text();
          $("#modalTxtNombreLeccion").val("");
          $("#modalTxtNombreLeccion").val(valorSelect);
      }

      // function amv_save() {
      //   $("#edicion_campo_actividad").show(100);
      //   $("#edicion_campo_actividad").show(100);
      //  }

       function amv_salir_edicion_leccion(){
          $("#amv_select_leccion").show(100);
          $("#modalTxtNombreLeccion").hide();
          $("#btn_salir_leccion").hide();
          $("#btn_editar_leccion").show(100);
          $("#btn_save_leccion").show(100);

       }

       function amv_editar_leccion(){
          capturar_valor();
          $("#btn_editar_leccion").hide();
          $("#amv_select_leccion").hide();
          $("#btn_guardar_leccion").show(100);
          $("#btn_nuevo_leccion").show(100);
          $("#btn_salir_leccion").show(100);

          $("#modalTxtNombreLeccion").show(100);
       }

       // function amv_guardar_leccion(){
       //    $("#modalTxtNombreLeccion").hide();
       //    $("#btn_salir_leccion").hide();
       //    $("#btn_guardar_leccion").hide();
       //    $("#amv_select_leccion").show(100);
       //    $("#btn_editar_leccion").show(100);
       //   /*  grabarLeccion(); */
       // }

       // function amv_agregar_leccion(){
       //    $("#modalTxtNombreLeccion").show(100).val("");
       //     $("#btn_guardar_leccion").show(100);
       //    $("#btn_editar_leccion").hide();
       //    $("#amv_select_leccion").hide();
       //    $("#btn_nuevo_leccion").hide();
       //    $("#btn_salir_leccion").show(100);

       // }


      function informe_lengua(){
       /*  $("#list-md-material .media").removeClass("media-active");
        var url="";
        url="actividad/informes.jsp";

        $(this).addClass("media-active");
        $( "#content-md-frm" ).load(url); */
		let valor = "999";
        cargarContenido(valor);

      }

      var leccionSeleccionada = false;
	function cargarContenido(val)
    {
  		var valor 		= val;

      	var idLengua 	= document.getElementById("modalTxtIdLengua").value;
      	var idNivel 	= document.getElementById("cboNivel").value;
      	var idSubNivel 	= document.getElementById("cboSubNivel").value;
      	var idLeccion 	= document.getElementById("modalCboLeccion").value;
      	var liCodUnid = $("#cboUnidad").val();
      	var liMatLecc = $("#modalCboMaterial").val() == "" ? 0 : $("#modalCboMaterial").val() ;
		console.log("lengua" + idLengua);
      	var url = "${pageContext.request.contextPath}/cargaMaterialController/cargarContenido";
      	$("#modalIdTipoEjercicio").val(valor);

      	if(valor == "999")
        {
      		url = "${pageContext.request.contextPath}/cargaMaterialController/cargarContenidoPrincipal"
      		$.ajax({
      			type 	: "POST",
      			data 	: {valor:valor, codigolengua:idLengua, codigonivel:idNivel, codigosubnivel:idSubNivel, liCodUnid:liCodUnid},
      			url 	: url,

      			success : function(data)
      			{
      				/*  $( "#content-md-frm" ).load(data1); */
      				 /* alert(data1); */
      				document.getElementById("content-md-frm").innerHTML = data;

      			/*	document.getElementById("modalIdLengua").value = data1.nombre;
      				document.getElementById("modalNombreLengua").innerHTML = data1.nombre;*/
      			},
      			error : function()
      			{
      				console.log("ERROR: ");
      			}
      		});
        }
		else
        {
	        //alert(":V else");
			
			if(idLeccion == "0"){
				//alert("Seleccione alguna leccion para poder registrar");
				leccionSeleccionada = false;
			}else{
				//alert("existe leccion");
				leccionSeleccionada = true;
			}

      		$.ajax({
      			type 	: "POST",
      			data 	: {valor:valor, codigoleccion:idLeccion, liMatLecc:liMatLecc},
      			url 	: url,

      			success : function(data)
      			{
      				/*  $( "#content-md-frm" ).load(data1); */
      				/* alert("Secargó el contenido de la cabecera."); */
      				document.getElementById("content-md-frm").innerHTML = data;
					
					/** msb **/
      				if(valor == "26"){
      					estadoRelacion(!leccionSeleccionada);
      					listadoRelacionActividad();
        			}
      				/* if(valor == "22"){ */
      					listarMaterialTipoEjercicio();
        			/* } */




      			/*	document.getElementById("modalIdLengua").value = data1.nombre;
      				document.getElementById("modalNombreLengua").innerHTML = data1.nombre;*/
              		listadoPreguntaActividad27();
      				listadoPreguntaActividad();

      			},
      			error : function()
      			{
          			//alert("error");
      				console.log("ERROR: ");
      			}
      		});
		}
      	
      	
	}

	
	
	
	$("#btn_guardar_leccion").click(function()
 	{
 		var url = "${pageContext.request.contextPath}/cargaMaterialController/" + $("#frmregistromodal").attr("action");
 	 	var p_nombleccion 	= $("#modalTxtNombreLeccion").val();
		var p_codlengua 	= $("#modalTxtIdLengua").val();
		var p_tm2nivel		= $("#modalCboNivel").val();
		var p_tm2subnivel 	= $("#modalCboSubNivel").val();
		var p_tm2unidad 	= $("#modalCboUnidad").val();

		document.getElementById("modalCboLeccion").options[document.getElementById("modalCboLeccion").innerHTML=""];
		document.getElementById("modalCboLeccion").options[document.getElementById("modalCboLeccion").options.length]=new Option("Seleccione", "0");

		if(p_nombleccion != "")
		{
			$.ajax({
	 	 		type 	: "POST",
		  		url 	: "${pageContext.request.contextPath}/cargaMaterialController/" + $("#frmregistromodal").attr("action"),
		  		data 	: {nombreleccion:	p_nombleccion,
			  				codigolengua:	p_codlengua,
			  				codigonivel:	p_tm2nivel,
			  				codigosubnivel:	p_tm2subnivel,
			  				codigounidad:	p_tm2unidad},
		  		success : function(data)
		  		{
		  			for(var i=0; i<data.length;i++)
			  		{
						document.getElementById("modalCboLeccion").options[document.getElementById("modalCboLeccion").options.length]=new Option(data[i].nombreLeccion, data[i].codigo);
					}
		  		},
		  		error : function()
		  		{
		  			console.log("ERROR: ");
		  		}
	 	 	 });
		}
		else
		{
			alert("Debe ingresar un nombre para la lecci�n.");
		}
	});


	function guardarActividad1()
	{
		var p_codejercicio 	= document.getElementById("idEjercicio").value;
		var p_descripcion 	= $("#txtPreguntaDescripcion").val();
		if(p_codejercicio == null || p_codejercicio == 0)
		{
			guardarEjercicio();
		}
		else if(p_codejercicio != null && p_codejercicio != 0)
		{
			if(p_descripcion != "")
			{
				guardarPregunta();
        listadoPreguntaActividad27();
				listadoPreguntaActividad();

			}
			else
			{
				alert("Debe ingresar una palabra para agregarla.");
			}
		}
	}


 	function guardarEjercicio()
	{
 		var p_tituloejercicio 	= $("#ejercicioTxtTitulo").val();
		var p_descripcion 		= $("#ejercicioTxtDescripcion").val();
		var p_codleccion 		= $("#modalCboLeccion").val();
	 	var p_tm2tipoejercicio	= $("#modalIdTipoEjercicio").val();

		/* alert(p_codleccion + "modalCboLeccion \n"+ "-titulo" +p_tituloejercicio+ "_"); */

		if(validarCombos(p_codleccion,p_tituloejercicio))
		{
			let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarejercicio";
			/*  alert(	"url :: " + url +
					"\n p_tituloejercicio :: " + p_tituloejercicio +
					"\n p_descripcion" + p_descripcion +
					"\n p_codleccion" + p_codleccion +
					"\n p_tm2tipoejercicio" + p_tm2tipoejercicio);  */
			$.ajax({
					type : 	"POST",
					url	 :	url,
					data : {tituloejercicio:	p_tituloejercicio,
							descripcion:		p_descripcion,
		  					codleccion:			p_codleccion,
		  					tm2tipoejercicio:	p_tm2tipoejercicio},
		  			success : function(data)
		  		  	{
		  				alert("Se insertó el registro correctamente.");
		  				$("#idEjercicio").val(data);
		  		  	},
		  		  	error : function()
		  		  	{
			  		  	alert("No se pudo ingresar el registro");
		  		  		console.log("ERROR: ");
		  		  	}
			});
		}
	}




   




	function listadoPreguntaActividad()
	{
		var numero =document.getElementById("idEjercicio").value;
		/* alert(numero); */
	    var html = "";
	    $.ajax({
	    	type : "POST",
	      	url : "${pageContext.request.contextPath}/cargaMaterialController/buscarpregunta?p_codejercicio="+numero,
	//      data : {codigoinst:numero},
	      	success : function(data)
	      	{
	          for(var i=0;i<data.length;i++)
		      {
	            html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo+ "\",\"" +data[i].descripcion+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
	          }
	          document.getElementById("idTablaPreguntaListado").innerHTML=html;
	      	},
	      	error : function()
	      	{
	        	console.log("ERROR: ");
	      	}
	    });
	}

  function listadoPreguntaActividad27()
  {
    var numero =document.getElementById("idEjercicio").value;
    /* alert(numero); */
      var html = "";
      $.ajax({
        type : "POST",
          url : "${pageContext.request.contextPath}/cargaMaterialController/buscarpregunta?p_codejercicio="+numero,
  //      data : {codigoinst:numero},
          success : function(data)
          {
            for(var i=0;i<data.length;i++)
          {
              html=html+"<tr>  <td>"+'Espacio' +(i+1)+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo+ "\",\"" +data[i].descripcion+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
            }
            document.getElementById("idTablaPreguntaListado27").innerHTML=html;
          },
          error : function()
          {
            console.log("ERROR: ");
          }
      });
  }

	function limpiarPreguntaRptas(){
		$("#idPregunta").val("");
		$("#txtPreguntaDescripcion").val("");
		limpiarRespuestas();
	}
	function limpiarMatTEjePreguntaRptas(){
		$("#idMaterialTipoEjercicio").val("");
		$("#ejercicioTxtTitulo").val("");
		$("#idPregunta").val("");
		$("#txtPreguntaDescripcion").val("");
		limpiarRespuestas();
	}
	function limpiarRespuestas(){
		$("#tab42 #0").prop('checked', false);
		$("#tab42 #0").val("");
		$("#tab42 #1").prop('checked', false);
		$("#tab42 #1").val("");
		$("#tab42 #2").prop('checked', false);
		$("#tab42 #2").val("");
		$("#tab42 #3").prop('checked', false);
		$("#tab42 #3").val("");
		$("#rptaDescripcion0").val("");
		$("#rptaDescripcion1").val("");
		$("#rptaDescripcion2").val("");
		$("#rptaDescripcion3").val("");
	}
	function confirmar_accion(valor)
	{
		prmCodigo=valor;
		//alert(valor);
		$("#idPregunta").val(valor);
		var tipoaccion = accionPregunta;
 		console.log("acc:" + tipoaccion);
 		var p_codejercicio 	= $("#idEjercicio").val();
		var p_descripcion 	= $("#txtPreguntaDescripcion").val();
		var p_codpregunta =$("#idPregunta").val() == "" ?  0 : $("#idPregunta").val();
		console.log("cp:" + p_codpregunta);
		if(validarCombos(p_codejercicio)){
			let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarPregunta";
			$.ajax({
					type : 	"POST",
					url	 :	url,
					data : {codejercicio: p_codejercicio,
							descripcion	:p_descripcion,
							pregunta: p_codpregunta},
		  			success : function(data){
              listadoPreguntaActividad27();
		  				listadoPreguntaActividad();

		  				accionPregunta = 1;
		  				limpiarPreguntaRptas();
		  		  	},
		  		  	error : function(){
			  		  	alert("No se pudo ingresar el registro");
		  		  		console.log("ERROR: ");
		  		  	}
			});
		}
		else {
			alert("Debe agregar un ejercicio.");
		}
	}

	function agregarAlternativa()
	{
		/* var fieldset	=document.getElementById('alternativas');
		var inputs		=document.getElementsByName("alternativa");
		var br			=document.createElement("br");
		var newInput	=document.createElement("input");
		var div			=document.createElement("div");
		div.class 		= "form-group";
		div.name = "alternativa";

		newInput.name	="alternativa";
		newInput.size	=100;
		newInput.id		="alt"+(inputs.length+1);

		div.appendChild(br);
		div.appendChild(newInput);
		fieldset.appendChild(div); */

		var p_codpregunta = document.getElementById("idPregunta").value;
	//	alert("guardar  alternativa"+ p_codpregunta);
		if(p_codpregunta != null || p_codpregunta == "")
		{
			var arrayAlternativas 	= [];
			var objPregunta = { codigo : p_codpregunta};
			$("#tblPregunta tbody tr").each(function (index)
			{
				var objAlernativa =
					{
						respuestaEstado : '0',
						descripcion 	: '',
						preguntaBean	: objPregunta
					};
				input    = document.getElementById(index);
				if($(input).is(':checked'))
				{
					objAlernativa.respuestaEstado = "1";
			    }
				else
		 		{
					objAlernativa.respuestaEstado = "0";
		 	 	}
				objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
				arrayAlternativas.push(objAlernativa);
		 	});
			enviarAlternativasAjax(arrayAlternativas);
		}
		else
		{
			alert("No se pudo registrar las alternativas");
		}
	}

//JORGE
 	function guardarPregunta()
	{
 		var p_codejercicio 	= document.getElementById("idEjercicio").value;
		var p_descripcion 	= $("#txtPreguntaDescripcion").val();

		/* alert(p_codejercicio); */

		if(validarCombos(p_codejercicio))
		{
			let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarPregunta";
			$.ajax({
					type : 	"POST",
					url	 :	url,
					data : {codejercicio:p_codejercicio,
							descripcion	:p_descripcion},
		  			success : function(data)
		  		  	{
			  		  //	alert(data);
		  				$("#idPregunta").val(data);
		  				agregarAlternativa()
		  		  	},
		  		  	error : function()
		  		  	{
			  		  	alert("No se pudo ingresar el registro");
		  		  		console.log("ERROR: ");
		  		  	}
			});
		}
		else {
			alert("Debe agregar un ejercicio.");
		}
	}


 	function enviarAlternativasAjax(arrayAlternativas){

 		let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarrespuesta";

 	 	$.ajax({
 	 		   contentType: "application/json",
 	           type: "POST",
 	           data: JSON.stringify(arrayAlternativas),
 	           url: url,
 	           success: function(data)
 	           {

 	           },
 			   error: function(er)
 			   {
 				   console.log(" ERROR:" + er);
 			   }
 	         });
 	}


 	function validarCombos(p_codleccion,p_tituloejercicio)
	{
		let val = true;
		let cadena = 'Para agregar un nuevo ejercicio ';
		if(p_codleccion == 0)
		{
			alert(cadena + 'debe seleccionar o agregar una lección.');
			val = false;
		}
		else if(p_tituloejercicio == "")
		{
			alert(cadena + 'debe ingresar un título.');
			val = false;
		}
		return val;
	}


	function handleFileSelect(evt){
		$("#hiddenImg").val("0");
		var files = evt.target.files; // FileList object

 	    // Loop through the FileList and render image files as thumbnails.
 	    for (var i = 0, f; f = files[i]; i++)
 	 	{
	 	      // Only process image files.
	 	    if (!f.type.match('image.*'))
	 	 	{
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	      // Closure to capture the file information.
	 	    reader.onload = (function(theFile)
	 	   	{
	 	    	return function(e)
	 	    	{
	 	        // Render thumbnail.
	 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	         /*  var span = document.createElement('span');
	 	          span.innerHTML = ['<img class="thumb" src="', e.target.result,
	 	                            '" title="', escape(theFile.name), '"/>'].join('');
	 	          document.getElementById('list').insertBefore(span, null); */
	 	        };
			})(f);
	 	      // Read in the image file as a data URL.
	 	   	reader.readAsDataURL(f);
	 	    
 	    }
		
	}

 	  /* document.getElementById('files').addEventListener('change', handleFileSelect, false); */

	function obtener_imagen(){
    	document.getElementById('files').click();
    }
	function obtenerAudio(){
		document.getElementById("fileAudio").click();
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
			consone.log("txt:" + filename);
		}
	}

	function obtener_imagen_mini()
    {
    	document.getElementById('files').click();
    }

	function handleFileSelect_mini(evt)
	{
		var files = evt.target.files; // FileList object

 	    // Loop through the FileList and render image files as thumbnails.
 	    for (var i = 0, f; f = files[i]; i++)
 	 	{
	 	      // Only process image files.
	 	    if (!f.type.match('image.*'))
	 	 	{
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	      // Closure to capture the file information.
	 	    reader.onload = (function(theFile)
	 	   	{
	 	    	return function(e)
	 	    	{
	 	        // Render thumbnail.
	 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb-mini" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	         /*  var span = document.createElement('span');
	 	          span.innerHTML = ['<img class="thumb" src="', e.target.result,
	 	                            '" title="', escape(theFile.name), '"/>'].join('');
	 	          document.getElementById('list').insertBefore(span, null); */
	 	        };
			})(f);
	 	      // Read in the image file as a data URL.
	 	   	reader.readAsDataURL(f);
 	    }
	}


	var tipoAccionEjer = 0;
	function uploadAjax()
    {
		var data = new FormData();
		var p_codejercicio 	= $("#idEjercicio").val() == "" ? 0 : $("#idEjercicio").val();
    	var p_tituloejercicio 	= $("#ejercicioTxtTitulo").val();
    	var p_descripcion 		= $("#ejercicioTxtDescripcion").val();
    	var p_codleccion 		= $("#modalCboLeccion").val();
    	var p_tm2tipoejercicio	= $("#modalIdTipoEjercicio").val();

    	/* alert(p_codleccion + "modalCboLeccion \n"+ "-titulo" +p_tituloejercicio+ "_"); */
		console.log("cod_ejercicio: "+p_codejercicio);
		if(p_codejercicio == "0"){
			tipoAccionEjer = 1;
		} else{
			tipoAccionEjer = 2;
			
		}
		console.log("tipo:" + tipoAccionEjer);
		//console.log("url: "+ tipoAccionEjer == 1 ? "${pageContext.request.contextPath}/cargaMaterialController/grabarImagen" :  "${pageContext.request.contextPath}/cargaMaterialController/actualizarImagen");
    	let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarImagen";
		var audioName ="";
    	if(tipoAccionEjer == 1){
    		var inputFileImage = document.getElementById("files");
        	var file = inputFileImage.files[0];
        	var inputFileAudio = document.getElementById("fileAudio");
        	var fileAudio = inputFileAudio.files[0];
        	data.append('file',file);
        	data.append('fileAudio',fileAudio);
        	audioName = fileAudio.name;
		} else{
			
			console.log("img:" + $("#files").val());
			if($("#hiddenAud").val()==0){
				var inputFileAudio = document.getElementById("fileAudio");
	        	var fileAudio = inputFileAudio.files[0];
	        	data.append('fileAudio',fileAudio);
	        	console.log("audi0");
			} else {
				var fileAudio = new File([$("#audioSourceAct02").attr("src")], ($("#fileAudio").val() =="" ? $("#audioSourceAct02").attr("title") :  $("#fileAudio").val()) , {type:"audio/mp3"}); //add filename here
				data.append('fileAudio',fileAudio);
				console.log("audi1");
			}

			if($("#hiddenImg").val()==0){
				var inputFileImage = document.getElementById("files");
	        	var file = inputFileImage.files[0];
	        	data.append('file',file);
	        	console.log("imag0");
			} else {
				var file = new File([$("#tab41 img").attr("src")], ($("#files").val() == "" ? $("#tab41 img").attr("alt") : $("#files").val()), {type:"image/jpg"}); //add filename here
				data.append('file',file);
				console.log("imag1");
			}
			//var file = new File([$("#tab41 img").attr("src")], "img01.jpg", {type:"image/jpg"}); //add filename here
			//var fileAudio = new File([$("#audioSourceAct02").attr("src")], "audio.mp3", {type:"audio/mpeg"}); //add filename here
			console.log("archivo img2"+ file);
			console.log("audio2 "+ fileAudio);
			/*data.append('file',file);
        	data.append('fileAudio',fileAudio);*/
        	if($("#fileAudio").val() ==""){
            	audioName =  $("#audioSourceAct02").attr("title");
            } else{
            	var inputFileAudio2 = document.getElementById("fileAudio");
               	var fileAudio2 = inputFileAudio2.files[0];
                audioName = fileAudio2.name;
            }
		}
    	
    	
    	data.append('codigoejercicio',p_codejercicio);
    	data.append('tituloejercicio',p_tituloejercicio);
    	data.append('descripcion',p_descripcion);
    	data.append('codleccion',p_codleccion);
    	data.append('tm2tipoejercicio',p_tm2tipoejercicio);
    	
    	if(validarCombos(p_codleccion,p_tituloejercicio))
    	{
	 		//alert(file);
	    	$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			        {
			         	/* alert("uploadAjax"); */
			 	       	//alert("Se insertó el registro con éxito!!!");
			 	       	tipoAccionEjer = 2;
			  			$("#idEjercicio").val(data);
			  			if($("#fileAudio").val() ==""){
			  				console.log("contentAudio");
				  			var contentAudio = $("#contentAudio");
				  			contentAudio.empty();
				  			console.log(audioName);
				  			contentAudio.html('<audio id="audioAct02n"  preload="auto" controls><source src="" id="audioSourceAct02n" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
				  			$("#audioSourceAct02n").attr("src","");
				  			$("#audioSourceAct02n").attr("src","${pageContext.request.contextPath}/material/" + audioName);
			  			} else{
			  				var contentAudioDiv = $("#contentAudio");
			  				contentAudioDiv.empty();
				  			console.log("contentAudioDiv");
				  			contentAudioDiv.html('<audio id="audioAct02"  preload="auto" controls><source src="" id="audioSourceAct02" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
				  			$("#audioSourceAct02").attr("src","");
				  			$("#audioSourceAct02").attr("src","${pageContext.request.contextPath}/material/" + audioName);
				  		}
				  		console.log("Se insertó el registro con éxito!!!");
			        },
			 		error: function(er)
			 		{
			 			console.log("ERROR: " + er);
			 			alert("No se pudo ingresar el registro");
			 		}
				});
    	}

	}


	//::::Steven.d3v
	function handleFileAudio(evt) {
		var files = evt.target.files; // FileList object
 	    // Loop through the FileList and render image files as thumbnails.
 	    for (var i = 0, f; f = files[i]; i++)
 	 	{
	 	      // Only process image files.
	 	      console.log("file:" + f.type);
	 	    if (!f.type.match('video*'))
	 	 	{
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	      // Closure to capture the file information.
	 	    reader.onload = (function(theFile)
	 	   	{
	 	    	return function(e)
	 	    	{
	 	        // Render thumbnail.
	 	        	document.getElementById("list").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	         /*  var span = document.createElement('span');
	 	          span.innerHTML = ['<img class="thumb" src="', e.target.result,
	 	                            '" title="', escape(theFile.name), '"/>'].join('');
	 	          document.getElementById('list').insertBefore(span, null); */
	 	        };
			})(f);
	 	      // Read in the image file as a data URL.
	 	   	reader.readAsDataURL(f);
 	    }
	}
	
	function buscarLeccionMaterial(){
		var data = new FormData();
		data.append("liCodLecc",$("#modalCboLeccion").val());
		data.append("liSitLeMa",1);
		var html = "";
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/cargaMaterialController/listarLeccionMaterial",
			contentType:false,
	   		processData:false,
	   		cache:false,
			data : data,
			success : function(data){
				for(var i=0;i<data.length;i++){
			          html=html+"<tr><td class='text-xs-center'>"+(i+1)+"</td><td>"+(data[i].situacionLeccionMaterial.codigoRegistro == 1 ? 'Texto, Audio, Imagen' : (data[i].situacionLeccionMaterial.codigoRegistro == 2 ? 'Texto, Audio' : 'Sin Tipo Material'))+"</td> <td class='text-xs-center'> <button type='button' onclick='editarLeccionMaterial(\""+data[i].codigo+ "\",\""+data[i].situacionLeccionMaterial.codigoRegistro+"\",\""+data[i].contexto+"\",\""+data[i].nombreImagen+"\",\""+data[i].rutaAudio+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='eliminarLeccionMaterial(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("tbodyTipoMaterial").innerHTML=html;
			},
			error : function(){
				console.log("ERROR: ");
			}
		});
	}
	
	function validarLeccionMaterial(){ 
		$("#base-tab42").click(function(){
			//var liCodLecc = $("#modalCboLeccion").val(); 
			var liCodLec2 = $("#idLeccion").val();
			if(/*liCodLecc == "0" ||*/ (liCodLec2=="0" || liCodLec2=="" )){
				msg_advertencia("Debe existir una lección para poder agregar material.");
				$("#base-tab41").click();
				return false;
			}
			
		});
	}
	$(document).ready(function(){
		$("#base-tab42").click(function(){
			//var liCodLecc = $("#modalCboLeccion").val(); 
			var liCodLec2 = $("#idLeccion").val();
			if(/*liCodLecc == "0" || */(liCodLec2=="0" || liCodLec2=="" )){
				msg_advertencia("Debe existir una lección para poder agregar material.");
				$("#base-tab41").click();
				return false;
			}
			
		});
	});
	function editarLeccionCargarModal(){
		var liCodLecc = $("#modalCboLeccion").val(); 
		if(liCodLecc == "0"){
			msg_advertencia("Debe seleccionar lección para poder editar.");
			$("#base-tab41").click();
			return false;
		}
		var data = new FormData();
		data.append('liCodLecc',liCodLecc);
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/cargaMaterialController/editarLeccionCargarModal",
			contentType:false,
	   		processData:false,
	   		cache:false,
			data : data,
			success : function(data){
				//finBloqueo();
				$("#content-md-frm").html(data);
				$("#idLeccion").val(liCodLecc);
				buscarLeccionMaterial();
				$("#cboLeccionSituacion").val($("#txtLeccionSituacion").val());
				//$('#create_actividad').modal('show');

			},
			error : function(){
				//finBloqueo();	
				console.log("ERROR: ");
			}
		});
	}
	
	function editarMatTEjerPreg(liMatTEje, liCodPreg,lsTitulo,lsDesPreg){
		$("#idMaterialTipoEjercicio").val(liMatTEje);
		$("#ejercicioTxtTitulo").val(lsTitulo);
		$("#idPregunta").val(liCodPreg);
		$("#txtPreguntaDescripcion").val(lsDesPreg);
		buscarRespuestasPregunta();
	
	}
	function buscarRespuestasPregunta(){
		limpiarRespuestas();
	    var liCodPreg =$("#idPregunta").val();
	    var data = new FormData();
		data.append('liCodPreg',liCodPreg);
	    $.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/cargaMaterialController/buscarRespuestasPregMaTEjer",
			contentType:false,
			processData:false,
			cache:false,
			data:data,
			success : function(data){
		    	for(var i=0;i<data.length;i++){
					$("#rptaDescripcion"+i).val(data[i].descripcion);
					var idrpta = i;
					var valrpta = data[i].respuestaEstado == 1 ? true : false;
					$("#tab42 #"+ idrpta).prop('checked', valrpta);
					$("#tab42 #"+ idrpta).val(data[i].codigo);
	      		}
	      		console.log(data);
			},error : function(){
			    console.log("ERROR: ");
			}
	    });
	}
	
	function editarLeccionMaterial(idLecMate, liTipMate, lsCtxMate, lfImgMate, lfAudMate){
		$("#idMaterial").val(idLecMate);
		$("#ejercicioTxtDescripcion").val(lsCtxMate);
		$("#modalCboTipoMaterial").val(liTipMate);
		$("#contentImg img").attr("src","${pageContext.request.contextPath}/material/"+lfImgMate);
		$("#contentImg img").attr("title",lfImgMate);
		//$("#audioSourceAct02").attr("src","${pageContext.request.contextPath}/material/"+lfAudMate);
		var contentAudioDiv = $("#contentAudio");
		contentAudioDiv.empty();
		console.log("contentAudioDiv");
		contentAudioDiv.html('<audio id="audioAct02"  preload="auto" controls><source src="" id="audioSourceAct02" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
		$("#audioSourceAct02").attr("src","");
		$("#audioSourceAct02").attr("src","${pageContext.request.contextPath}/material/" + lfAudMate);
		$("#audioSourceAct02").attr("title",lfAudMate);
		$("#hiddenAud").val(lfAudMate == "" ? 0 : 1);
		$("#hiddenImg").val(lfImgMate == "" ? 0 : 1);
		$("#spanNombreMp3").text(lfAudMate);
	}
	function leccionCargarModal(){
		
		var data = new FormData();
		data.append('liCodLecc',0);
		$("#idLeccion").val("");
		$("#modalCboLeccion").val(0);
		
			//iniciarBloqueo();
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/cargaMaterialController/leccionCargarModal",
				contentType:false,
		   		processData:false,
		   		cache:false,
				data : data,
				success : function(data){
					//finBloqueo();
					$("#content-md-frm").html(data);
					validarLeccionMaterial();
					//buscarLeccionMaterial();
					//$('#create_actividad').modal('show');

				},
				error : function(){
					//finBloqueo();	
					console.log("ERROR: ");
				}
			});
		
	

	}

	function grabarLeccion(){
		var lsAccLecc = "";
		var liLeccion = $("#idLeccion").val() == "" ? 0 : $("#idLeccion").val();
		var lsNomLecc = $("#ejercicioTxtTitulo").val();
		var llSitLecc = $("#cboLeccionSituacion").val();
		var liCodUnid = $("#cboUnidad").val();
		var data = new FormData();
		lsAccLecc = liLeccion=="" ? 1 : 2;
		data.append('liTipoSQL',lsAccLecc);
		data.append('liLeccion',liLeccion);
		data.append('lsNomLecc',lsNomLecc);
		data.append('llSitLecc',llSitLecc);
		data.append('liCodUnid',liCodUnid);
		if(lsNomLecc != ""){
			$.ajax({
	 	 		type : "POST",
		  		url : "${pageContext.request.contextPath}/cargaMaterialController/grabarLeccion",
		  		contentType:false,
		   		processData:false,
		   		cache:false,
		  		data:data,
		  		success : function(data){
		  			if(data>0){
		  				$("#idLeccion").val(data);
		  				console.log("Se ha registrado con éxito.");
		  				$('#modalCboLeccion').append($('<option>', {
		  				    value: data,
		  				    text: lsNomLecc
		  				}));
		  				$('#modalCboLeccion').val(data);
		  				$("#base-tab42").click();
		  				buscarLeccionMaterial();
		  				msg_exito();
		  			}	
		  		},
		  		error : function(){
		  			console.log("ERROR: ");
		  			msg_error();
		  		}
	 	 	 });
		}else{
			alert("Debe ingresar un nombre para la lección.");
		}
	}
	function eliminarLeccion(){
		var liLeccion = $("#modalCboLeccion").val();
		if(liLeccion == "0"){
			console.log("Debe seleccionar lección para eliminar");
			return false;
		}
		let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarLeccion";
		$.ajax({
			type : 	"POST",
			url	 :	url,
			data : {liLeccion: liLeccion},
  			success : function(data){
  				if(data==1){
  					console.log("Se eliminó con éxito");
  					msg_exito();
  				} else{
  					console.log("No se pudo eliminar.");
  					msg_error();
  				}
  				//$("#create_actividad").modal("hide");
  				//buscarLeccionMaterial();
  				 $("#modalCboLeccion").val("0");
  				$("#modalCboLeccion option[value='"+liLeccion+"']").remove();
  				//actividadCargarModal();
  				$("#tbodyLeccion tr#"+liLeccion).empty();
  		  	},
  		  	error : function(){
	  		  	alert("No se pudo ingresar el registro");
  		  		console.log("ERROR: ");
  		  		msg_error();
  		  	}
		});
		
	}
	function eliminarLeccionGrilla(liLeccion){
		//var liLeccion = $("#modalCboLeccion").val();
		if(liLeccion == "0"){
			console.log("Debe seleccionar lección para eliminar");
			return false;
		}
		let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarLeccion";
		$.ajax({
			type : 	"POST",
			url	 :	url,
			data : {liLeccion: liLeccion},
  			success : function(data){
  				if(data==1){
  					console.log("Se eliminó con éxito");
  					msg_exito();
  				} else{
  					console.log("No se pudo eliminar.");
  					msg_error();
  				}
  				
  				//buscarLeccionMaterial();
  				 $("#modalCboLeccion").val("0");
  				$("#modalCboLeccion option[value='"+liLeccion+"']").remove();
  				$("#tbodyLeccion tr#"+liLeccion).empty();
  		  	},
  		  	error : function(){
	  		  	console.log("No se pudo ingresar el registro");
  		  		console.log("ERROR: ");
  		  		msg_error();
  		  	}
		});
		
	}
	function grabarMaterial(){
		var lsAccLecc = "";
		var data = new FormData();
		var liTipMate = $("#modalCboTipoMaterial").val();
		/*if(liTipMate=="0"){
    		console.log("Debe seleccionar Tipo Material");
    		return false;
    	}*/
		var liLeccion = $("#idLeccion").val();
		var liLecMate = $("#idMaterial").val() == "" ? 0 : $("#idMaterial").val();
		var lsCtxMate = $("#ejercicioTxtDescripcion").val();
		if($("#hiddenAud").val()=="0"){
			var inputFileAudio = document.getElementById("basicInputAudio");
	    	var lfAudMate = inputFileAudio.files[0];
	    	data.append('lfAudMate',lfAudMate);
		} else{
			//var lfAudMate = new File([$("#audioSourceAct02").attr("src")], $("#audioSourceAct02").attr("title") , {type:"audio/mp3"}); //add filename here
			//data.append('fileAudio',fileAudio);
			//console.log("aud:" + lfAudMate);
			var lfAudMate = new File([$("#audioSourceAct02").attr("src")], ("audio--Vacio---"+$("#audioSourceAct02").attr("title")), {type:"audio/mp3"});
			data.append('lfAudMate',lfAudMate);
		}
		if($("#hiddenImg").val()=="0"){
			var inputFileImage = document.getElementById("basicInputFile");
	    	var lfImgMate = inputFileImage.files[0];
	    	data.append('lfImgMate',lfImgMate);
		} else{
			//var lsExtImg = $("#basicInputFile").val().slice((Math.max(0, $("#basicInputFile").val().lastIndexOf(".")) || Infinity) + 1);
			//console.log("img ext:"+ lsExtImg);
			//var lfImgMate = new File([$("#contentImg img").attr("src")], $("#contentImg img").attr("title"), {type:"image/"+lsExtImg}); //add filename here
			//console.log("img"+ lfImgMate.name);
			var lfImgMate = new File([$("#contentImg img").attr("src")],("img--Vacio---"+$("#contentImg img").attr("title")));
			data.append('lfImgMate',lfImgMate);
		}
		lsAccLecc = liLecMate=="" ? 1 : 2;
		data.append('liTipoSQL',lsAccLecc);
		data.append('liCodMate',liLecMate);
		data.append('lsDesMate',"");
		data.append('lsCtxMate',lsCtxMate);
		data.append('liCodLecc',liLeccion);
		data.append('liTipMate',liTipMate);
    	let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarMaterial";
    	$.ajax({
	   		url:url,
	    	type:"POST",
	   		contentType:false,
	   		data:data,
	   		processData:false,
	   		cache:false,
	   		success: function(data){
	 	       	//alert("Se insertó el registro con éxito.");
	 	       	msg_exito();
	  			$("#idMaterial").val(data);
	  			buscarLeccionMaterial();
	  			$("#idMaterial").val("");
	  			$("#modalCboTipoMaterial").val("0");
	  			$("#contentImg img").attr("src","../assets/img/usar_imagen.jpg");
	  			$("#contentImg img").addClass("img-fluid");
	  			$("#contentImg img").css({"cursor":"pointer","max-width":"30%"});
	  			var contentAudio = $("#contentAudio");
	  			contentAudio.empty();
	  			$("#spanNombreMp3").text("");
	  			$("#ejercicioTxtDescripcion").val("");
	  			console.log("Se insertó el registro con éxito!!!");
	  			$('#modalCboMaterial').append($('<option>', {
  				    value: data,
  				    text: lsCtxMate
  				}));
	  			$('#modalCboMaterial').val(data);
	        },
	 		error: function(er){
	 			console.log("ERROR: " + er);
	 			console.log("No se pudo ingresar el registro");
	 			msg_error();
	 		}
		});
	}
	
	function eliminarLeccionMaterial(liCodMate){
		let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarLeccionMaterial";
		$.ajax({
			type : 	"POST",
			url	 :	url,
			data : {liCodMate: liCodMate},
  			success : function(data){
  				if(data==1){
  					console.log("Se eliminó con éxito");
  					msg_exito();
  				} else{
  					console.log("No se pudo eliminar.");
  					msg_error();
  				}
  				buscarLeccionMaterial();
  		  	},
  		  	error : function(){
	  		  	console.log("No se pudo ingresar el registro");
  		  		console.log("ERROR: ");
  		  		msg_error();
  		  	}
		});
		
	}
	function grabarPreguntasMaterialTEjer2(){
		var data = new FormData();
		var liMatTEje = $("#idMaterialTipoEjercicio").val();
		var liCodPreg = $("#idPregunta").val() == "" ? 0 : $("#idPregunta").val();
		var lsDesPreg = $("#txtPreguntaDescripcion").val();
		var lsAccLecc = liCodPreg ==0 ? 1 : 2;
		data.append("liMatTEje",liMatTEje);
		data.append("liCodPreg",liCodPreg);
		data.append("lsDesPreg",lsDesPreg);
		data.append("liTipoSQL",lsAccLecc);
		let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarPregunta";
		$.ajax({
				type : "POST",
				url	:url,
				contentType:false,
		   		data:data,
		   		processData:false,
		   		cache:false,
	  			success : function(data){
	  				console.log("dataxpreg" + data);
	  				if(data>0){
	  					$("#idPregunta").val(data);
	  					console.log("alternativa tiposql:" + lsAccLecc);
	  					if(data>0){
	  						agregarPreguntaAlternativas(lsAccLecc);
	  						msg_exito();
	  						cargarContenido(2);seleccionarFilaTabla('2');
	  					}
	  				} else{
	  					console.log("No se pudo grabar grabarPregunta");
	  					msg_error();
	  				}
	  				
	  		  	},
	  		  	error : function(){
	  		  		msg_error();
	  		  		console.log("ERROR: ");
	  		  	}
		});
	}
	
	function agregarPreguntaAlternativas(tipoaccion){
		var liCodPreg = $("#idPregunta").val();
		console.log("idpregunta: "+ liCodPreg);
		if(liCodPreg != null || liCodPreg == ""){
			var arrayAlternativas 	= [];
			var objPregunta = { codigo : liCodPreg};
			$("#tblPregunta tbody tr").each(function (index){
				var objAlernativa = {
						codigo			: 0,
						respuestaEstado : '0',
						descripcion 	: '',
						preguntaBean	: objPregunta
							};
				input    = document.getElementById(index);
				if($(input).is(':checked')){
					objAlernativa.respuestaEstado = "1";
			       }
				else{
					objAlernativa.respuestaEstado = "0";
		 	 	}
				objAlernativa.codigo		 = tipoaccion == 1 ? 0 : $("#tab42 #"+ index).val();
				console.log("rpta: "+objAlernativa.codigo);
				objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
				arrayAlternativas.push(objAlernativa);

		 	});
			enviarAlternativasArray(tipoaccion,arrayAlternativas);

		}
		else{
			console.log("No se pudo registrar las alternativas");
			msg_error();
		}

	}
	function enviarAlternativasArray(tipoaccion, arrayAlternativas){
 		console.log("r: " + tipoaccion);
 		let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarRespuestasPregunta";
 	 	$.ajax({
 	 		   contentType: "application/json",
 	           type: "POST",
 	           data: JSON.stringify(arrayAlternativas),
 	           url: url,
 	           success: function(data)
 	           {

 	           },
 			   error: function(er) {
 				   console.log(" er:" + er.error);console.log("er: " + er.responseText);
 				  	msg_error();
 			   }
 	         });
 	}
	function eliminarMatTEjerPreg(liMatTEje){
		$("#idMaterialTipoEjercicio").val(liMatTEje);
		console.log("cp:" + liMatTEje);
		var data = new FormData();
		data.append('liMatTEje',liMatTEje);
		if(liMatTEje=="0" || liMatTEje==""){
			console.log("Debe seleccionar actividad.");
		} else{
			let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarMatTEjerPreg";
			$.ajax({
				type:"POST",
				url:url,
				contentType:false,
				data:data,
		   		processData:false,
		   		cache:false,
	  			success : function(data){
	  				limpiarMatTEjePreguntaRptas();
	  				cargarContenido(2);
	  				seleccionarFilaTabla('2');
	  				msg_exito();
	  		  	},
	  		  	error : function(){
		  		  	console.log("No se pudo ingresar el registro");
	  		  		msg_error();
	  		  	}
			});
		}
		
	}
	
	

	function grabarMaterialTipoEjercicio2(){

		var $myForm = $('#frmregistromodal');
		var liCodMate = $("#modalCboMaterial").val();
		if (liCodMate==0 || liCodMate==""){
			msg_advertencia("Debe seleccionar un material.");
			return false;
		}
		
   		// validar todos los required
	   	if(!$myForm[0].checkValidity()) {
			msg_advertencia("Debe completar los campos requeridos correctamente.");
	   	}else{

			
	 		var liTipEjer = $("#modalIdTipoEjercicio").val();
			var lsTitTEje = $("#ejercicioTxtTitulo").val();
			var liSituaci = 1;
			var liMatTEje = $("#idMaterialTipoEjercicio").val() == "" ? 0 : $("#idMaterialTipoEjercicio").val();
			var lsAccLecc = liMatTEje==0 ? 1 : 2;
			var liCodLecc = $("#modalCboLeccion").val();
			var data = new FormData();
			console.log("params: "+ lsAccLecc +"-"+ liMatTEje+"-"+ liCodMate+"-"+ liTipEjer+"-"+ lsTitTEje+"-"+liSituaci);
			data.append("liTipoSQL",lsAccLecc);
			data.append("liMatTEje",liMatTEje);
			data.append("liCodMate",liCodMate);
			data.append("liTipEjer",liTipEjer);
			data.append("lsTitTEje",lsTitTEje);
			data.append("liSituaci",liSituaci);
			data.append("liCodLecc",liCodLecc);
			let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarMaterialTipoEjercicio";
			$.ajax({
				type: "POST",
				url	:url,
				contentType:false,
		   		data:data,
		   		processData:false,
		   		cache:false,
	  			success:function(data){
	  				console.log("rst:" + data);
	  				if(data>0){
	  					$("#idMaterialTipoEjercicio").val(data);
	  					grabarPreguntasMaterialTEjer2();
	  				} else{
	  					console.log("No se pudo grabar MaterialTipoEjercicio");
	  				}
			  	},
			  	error:function(){
				  	alert("No se pudo ingresar el registro");
			  		 console.log("ERROR: ");
			  	}
			});
	   	}
	}
	
	function uploadAjax2()
    {
    	var p_tituloejercicio 	= $("#ejercicioTxtTitulo").val();
    	var p_descripcion 		= $("#ejercicioTxtDescripcion").val();
    	var p_codleccion 		= $("#modalCboLeccion").val();
    	var p_tm2tipoejercicio	= $("#modalIdTipoEjercicio").val();

    	/* alert(p_codleccion + "modalCboLeccion \n"+ "-titulo" +p_tituloejercicio+ "_"); */

    	let url = "${pageContext.request.contextPath}/cargaMaterialController/grabarImagen";

    	var inputFileImage = document.getElementById("files");
    	var file = inputFileImage.files[0];
    	var inputFileAudio = document.getElementById("fileAudio");
    	var fileAudio = inputFileAudio.files[0];
    	var data = new FormData();

    	data.append('tituloejercicio',p_tituloejercicio);
    	data.append('descripcion',p_descripcion);
    	data.append('codleccion',p_codleccion);
    	data.append('tm2tipoejercicio',p_tm2tipoejercicio);
    	data.append('file',file);
    	data.append('fileAudio',fileAudio);
    	if(validarCombos(p_codleccion,p_tituloejercicio))
    	{
	 		//alert(file);
	    	$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			        {
			         	/* alert("uploadAjax"); */
			 	       	alert("Se insertó el registro con éxito!!!");
			  			$("#idEjercicio").val(data);
			  			console.log("ERROR: Se insertó el registro con éxito!!!");
			        },
			 		error: function(er)
			 		{
			 			console.log("ERROR: " + er);
			 			alert("No se pudo ingresar el registro");
			 		}
				});
    	}

	}

 	var accionPregunta = 1;
 	

 	



 	function enviarAlternativasAjax2(tipoaccion, arrayAlternativas){
 		console.log("r: " + tipoaccion);
 		let url = tipoaccion == 1 ? "${pageContext.request.contextPath}/cargaMaterialController/grabarrespuesta" : "${pageContext.request.contextPath}/cargaMaterialController/actualizarrespuesta";
 	 	$.ajax({
 	 		   contentType: "application/json",
 	           type: "POST",
 	           data: JSON.stringify(arrayAlternativas),
 	           url: url,
 	           success: function(data)
 	           {

 	           },
 			   error: function(er) {
 				   console.log(" er:" + er.error);console.log("er: " + er.responseText);

 			   }
 	         });
 	}

 	function editarPregunta(codigo,descripcion){
 		$("#idPregunta").val(codigo);
 		$("#txtPreguntaDescripcion").val(descripcion);
 		listadoRespuestasPregunta();
 		accionPregunta = 2;
 	}

 	function listadoRespuestasPregunta(){
 		$("#rptaDescripcion0").val("");
		$("#rptaDescripcion1").val("");
		$("#rptaDescripcion2").val("");
		$("#rptaDescripcion3").val("");
	    var idPregunta =$("#idPregunta").val();
	     console.log("pregunta:" + idPregunta);
	    var html = "";
	    $.ajax({
	      type : "POST",
	      url : "${pageContext.request.contextPath}/cargaMaterialController/buscarrespuestas?p_codpregunta="+idPregunta,
	//      data : {codigoinst:numero},
	      success : function(data){
	          for(var i=0;i<data.length;i++){
					$("#rptaDescripcion"+i).val(data[i].descripcion);

					var idrpta = i;
					var valrpta = data[i].respuestaEstado == 1 ? true : false;
					$("#tab42 #"+ idrpta).prop('checked', valrpta);
					$("#tab42 #"+ idrpta).val(data[i].codigo);
	        	//console.log("Dato: "+ data[i].descripcion);
	            //html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo + "\",\"" + data[i].descripcion +"\");' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
	          }
	          console.log(data);
	          //document.getElementById("idTablaPreguntaListado").innerHTML=html;
	      },
	      error : function()
	      {
	        console.log("ERROR: ");
	      }
	    });

	 }

	/***********************MSB *********************************/
	var accionRelacion = '1'; //1:guarda,2:modificar


    function estadoRelacion(estado){

        //alert("ejercicio : "+ $('#idEjercicio').val());
		//alert("c");
		/* cabecera */
		document.getElementById("ejercicioTxtTitulo").disabled = estado;
		document.getElementById("btn_guardar_ejercicio").disabled = estado;
		/* detalle */
		//alert("d");
		//obtener si el valor de de ejercicioTxt hay texto
		var existeDatos = $('#idEjercicio').val() == "" ;
		document.getElementById("txtPalabra").disabled = existeDatos;
		document.getElementById("txtTexto").disabled = existeDatos;
		document.getElementById("btnGuardarRelacion").disabled = existeDatos;
		if(!existeDatos){
			$('#table_btn').empty();
			html="<button type='button' id='btn_guardar_ejercicio' onclick='guardarEjercicio()' class='btn btn-primary btn-min-width'><i class='icon-pencil'></i> Editar</button>";
	    	$('#table_btn').html(html);
		}
		//document.getElementById("idOrientacion").disabled = existeDatos;


		}

	/*********************** MSB ******************************/

	function guardarRelacion(){
		var p_codejercicio 	= $("#idEjercicio").val();
    	var p_palabra 		= $("#txtPalabra").val();
    	var p_texto 		= $("#txtTexto").val();
    	var p_tiporelacion	= $("#idTipoRelacion").val();
    	var p_orden 		= $("#idOrden").val();
    	var p_orientacion 	= $("#idOrientacion").val();
    	alert("p_orientacion"+p_orientacion);
		var tipoEjercicio = $("#tipoEjercicio").val();

		let url = "";
   		var data = new FormData();

		//:: Grabar ::
		if(accionRelacion == '1'){
			//alert("insertar");
			limpiarRelacion();

			if(tipoEjercicio == "crucigrama"){

				 //p_orientacion = $('input:radio[name=radio]:checked').val();
				 //alert(p_orientacion);

			   	 if($("#formulario input[name='radio']:radio").is(':checked')){
			   		p_orientacion = '1';
				 }else{
					 p_orientacion = '2';
			     }

		        	alert("fdddf"+p_orientacion);
		    		url = "${pageContext.request.contextPath}/cargaMaterialController/grabarRelacion2";

		     	data.append('codejercicio',p_codejercicio);
		     	data.append('palabra',p_palabra);
		     	data.append('texto',p_texto);
		     	data.append('tiporelacion',p_tiporelacion);
		     	data.append('orden',p_orden);
		     	data.append('orientacion',p_orientacion);

		     }else  if(tipoEjercicio == "relacion"){
	            //alert(":v")
	        	//alert("1321313");
	        	url = "${pageContext.request.contextPath}/cargaMaterialController/grabarRelacion";

	        	var inputFileImage = document.getElementById("files");
	        	var file = inputFileImage.files[0];

	        	data.append('codejercicio',p_codejercicio);
	        	data.append('palabra',p_palabra);
	        	data.append('texto',p_texto);
	        	data.append('tiporelacion',p_tiporelacion);
	        	data.append('orden',p_orden);
	        	data.append('orientacion',p_orientacion);
	        	data.append('file',file);

		     }
		}else{
			/*************************/
			//alert("modificar");
			if(tipoEjercicio == "crucigrama"){

				if($("#formulario input[name='radio']:radio").is(':checked')){
			   		p_orientacion = '1';
				 }else{
					 p_orientacion = '2';
			     }
			     alert(p_orientacion);

		   		url = "${pageContext.request.contextPath}/cargaMaterialController/modificarRelacion2";

		   		var codigo = $("#idRelacion").val();


				limpiarRelacion();

		     	data.append('codigo',codigo);
		     	data.append('palabra',p_palabra);
		     	data.append('texto',p_texto);
		     	data.append('tiporelacion',p_tiporelacion);
		     	data.append('orden',p_orden);
		     	data.append('orientacion',p_orientacion);

		     }/*else  if(tipoEjercicio == "relacion"){
	            //alert(":v")
	        	//alert("1321313");
	        	url = "${pageContext.request.contextPath}/cargaMaterialController/grabarRelacion";

	        	var inputFileImage = document.getElementById("files");
	        	var file = inputFileImage.files[0];

	        	data.append('codejercicio',p_codejercicio);
	        	data.append('palabra',p_palabra);
	        	data.append('texto',p_texto);
	        	data.append('tiporelacion',p_tiporelacion);
	        	data.append('orden',p_orden);
	        	data.append('orientacion',p_orientacion);
	        	data.append('file',file);

		     }*/
		     /*********************/
		}


    	if(validarCombos(p_codejercicio != null)){
    		//alert("Se enviarán los archivos.");
	    	$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			        {
			 	       	//alert("Se insertó el registro con éxito!!!");
			 	       	//alert(data);
			  			//
			  			msg_exito();
			 	       	//alert("Se insertó el registro con éxito!!!");
			  			//$("#idRelacion").val(data);
			  			//msg_exito();
		  				listadoRelacionActividad();
			  			console.log("ERROR: Se insertó el registro con éxito!!!");
			        },
			 		error: function(er)
			 		{
			 			msg_error();
			 			console.log("ERROR: " + er);
			 			alert("No se pudo ingresar el registro");
			 		}
				});
    	}
    	else
        {
			alert("Debe registrar un ejercicio.");
        }
	}

	/***********************  MSB *********************************/
	function limpiarRelacion(){
		accionRelacion = "1";
		$("#txtPalabra").val("");
    	$("#txtTexto").val("");
    	$("#idTipoRelacion").val("");
    	$("#idOrden").val("");
    	html="<div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionHorizontal' name='radio' value='1' type='radio' class='custom-control-input' checked='checked'> <span class='custom-control-indicator'></span><span class='custom-control-description'>Horizontal</span></label></div><div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionVertical' name='radio' value='2' type='radio' class='custom-control-input'><span class='custom-control-indicator'></span><span class='custom-control-description'>Vertical</span></label></div>";
    	document.getElementById("tablaRadio").innerHTML=html;
    	html="<button type='button' id='btnGuardarRelacion' class='btn btn-outline-info btn-min-width' onclick='guardarRelacion();'> <i class='ft-plus'></i> Guardar </button>";
    	document.getElementById("table_btn_relacion").innerHTML=html;

	}
	/*********** MSB *****************/

 	function editarRelacionMSB(codigo,palabra,texto,orientacion){
		accionRelacion = '2';
		//alert("accionRelacion "+accionRelacion);
 		//alert(codigo);
 		$("#txtPalabra").val(palabra);
    	$("#txtTexto").val(texto);
    	//$("#idOrden").val();
    	alert(orientacion);
    	if(orientacion == '1'){
    		html="<div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionHorizontal' name='radio' value='1' type='radio' class='custom-control-input' checked='checked'> <span class='custom-control-indicator'></span><span class='custom-control-description'>Horizontal</span></label></div><div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionVertical' name='radio' value='2' type='radio' class='custom-control-input'><span class='custom-control-indicator'></span><span class='custom-control-description'>Vertical</span></label></div>";
	        document.getElementById("tablaRadio").innerHTML=html;

        }else{
            html="<div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionHorizontal' name='radio' value='1' type='radio' class='custom-control-input'> <span class='custom-control-indicator'></span><span class='custom-control-description'>Horizontal</span></label></div><div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionVertical' name='radio' value='2' type='radio' class='custom-control-input' checked='checked'><span class='custom-control-indicator'></span><span class='custom-control-description'>Vertical</span></label></div>";
	        document.getElementById("tablaRadio").innerHTML=html;

        }
    	html="<button type='button' id='btnGuardarRelacion' class='btn btn-outline-info btn-min-width' onclick='limpiarRelacion();'>Cancelar</button>	<button type='button' id='btnGuardarRelacion' class='btn btn-outline-info btn-min-width' onclick='guardarRelacion();'> <i class='ft-plus'></i> Guardar </button>";
    	document.getElementById("table_btn_relacion").innerHTML=html;
    	//table_btn_relacion




    	$("#idRelacion").val(codigo);
    	//$('input:radio[name=radio]:checked').val(orientacion);
 		/*
 		$("#idPregunta").val(codigo);
 		$("#txtPreguntaDescripcion").val(descripcion);
		*/
 		//listadoRespuestasPregunta();
 		//accionPregunta = 2;
 	}


	/********************* MSB *******************/

	function listadoRelacionActividad()
	{
		var numero =document.getElementById("idEjercicio").value;
		var tipoEjercicio = $("#tipoEjercicio").val();
	    var html = "";
	    $.ajax({
	    	type : "POST",
	      	url : "${pageContext.request.contextPath}/cargaMaterialController/buscarrelacion?p_codejercicio="+numero,
	//      data : {codigoinst:numero},
	      	success : function(data)
	      	{
		      	if(tipoEjercicio = "relacion"){
		      		for(var i=0;i<data.length;i++)
				      {
			            html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].palabra+"</td> <td> <button type='button' onclick='editarRelacion(\""+data[i].codigo+ "\",\""+data[i].palabra+"\",\""+data[i].texto+"\",\""+data[i].orientacion+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='eliminarRelacion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
			          }
			          document.getElementById("idTablaRelacionListado").innerHTML=html;

			         console.log(data);

		       	}else if(tipoEjercicio = "crucigrama"){

			          for(var i=0;i<data.length;i++)
				      {
			            html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].palabra+"</td> <td> <button type='button' onclick='editarRelacion(\""+data[i].codigo+ "\",\""+data[i].palabra+"\",\""+data[i].texto+"\",\""+data[i].orientacion+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='eliminarRelacion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
			          }
			<%--          document.getElementById("idBodyListadoMaterialTipoEjercicio").innerHTML=html;--%> 

			         console.log(data);
		        }
		      /*
	          for(var i=0;i<data.length;i++)
		      {
	            html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo+ "\",\"" +data[i].descripcion+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
	          }
	          document.getElementById("idTablaPreguntaListado").innerHTML=html;
	          */
	      	},
	      	error : function()
	      	{
	        	console.log("ERROR: ");
	      	}
	    });
	}

	/******************** MSB *************************/
	function eliminarRelacionMSB(valor)
	{
		prmCodigo=valor;
		//alert(valor);
		//$("#idPregunta").val(valor);
		//var tipoaccion = accionPregunta;
 		//console.log("acc:" + tipoaccion);
 		var p_codejercicio 	= $("#idEjercicio").val();
		//var p_descripcion 	= $("#txtPreguntaDescripcion").val();
		//var p_codpregunta =$("#idPregunta").val() == "" ?  0 : $("#idPregunta").val();
		//console.log("cp:" + p_codpregunta);
		if(validarCombos(p_codejercicio)){
			let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarRelacion?codigo="+prmCodigo;
			$.ajax({
					type : 	"POST",
					url	 :	url,
					/*data : {codejercicio: p_codejercicio,
							descripcion	:p_descripcion,
							pregunta: p_codpregunta},*/
		  			success : function(data){
			  			//alert("es "+data);
			  			/*
              			listadoPreguntaActividad27();
		  				listadoPreguntaActividad();

		  				accionPregunta = 1;
		  				limpiarPreguntaRptas();*/
						//if(true){
						//	limpiarRelacion();
			  			//}
		  				listadoRelacionActividad();
		  		  	},
		  		  	error : function(){
			  		  	alert("No se pudo ingresar el registro");
		  		  		console.log("ERROR: ");
		  		  	}
			});
		}
		else {
			alert("Debe agregar un ejercicio.");
		}
	}




	function isNull(parametro)
	{
		if(parametro == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}









 



 
</script>
<script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/actividad/materialTipoEjercicio.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/actividad/palabrasDesordenadas.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/actividad/textoTexto.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/actividad/crucigrama.js" type="text/javascript"></script>