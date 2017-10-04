<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro Usuario</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar" id="paginaRegistroUsuario">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="index.html" class="navbar-brand"><img alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text">ALOC</h2></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
              <jsp:include page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
          <jsp:include page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                   <li class="breadcrumb-item"><a href="#">Otros</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Seguridad</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#"> Registro Usuario</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title"> Registro Usuario</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">

                                     <ul id="idUlContentTab" class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Datos Generales</a>
                                        </li>
                                        <c:if test="${usuarioBean.codigoUsuario != null && usuarioBean.codigoUsuario > 0}">
	                                        <li class="nav-item">
	                                          <a  class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Usuario</a>
	                                        </li>
                                        </c:if>
                                      </ul>

                             <div class="tab-content px-1 pt-1">
                              <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                 <f:form class="form mt-1" id="formularioPersona">
                                      <div class="form-body">
                                          <div class="row">
                                                <div class="col-md-12">
                                                	<f:input type="hidden" id="codigoPersona" class="form-control" name="lname" path="persona.codigo"/>
                                                  <div class="row">
                                                      <div class="form-group col-md-3 mb-2">
                                                        <label for="situacionUsuario">Tipo Documento</label>

                                                        <f:select id="tipoDocumento" name="interested" class="form-control" path="persona.tipoDocumento.codigoRegistro" >

			                                                  <f:options  items="${lstTipoDocumento}"
			                                                                    itemValue="codigoRegistro"
			                                                                    itemLabel="nombreCorto"/>
			                                              </f:select>
                                                      </div>

                                                      <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">N&uacute;mero Documento</label>
                                                          <f:input type="text" id="projectinput2" class="form-control" name="lname" path="persona.numeroDocumento"/>
                                                      </div>
                                                      <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/buscarPersona','POST','#formularioPersona')">
                                                            <i class="ft-search"></i> Buscar
                                                          </button>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                      <div class="form-group col-md-6 mb-2">
                                                          <label for="projectinput1">Nombres completos</label>
                                                          <f:input type="text" id="projectinput1" disabled="true" class="form-control" name="fname" path="persona.nombreCompleto"/>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                       <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">Tel&eacute;fono/Celular</label>
                                                          <f:input type="text" id="projectinput2" disabled="true" class="form-control" name="lname" path="persona.telefono"/>
                                                      </div>

                                                      <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">Correo Electr&oacute;nico</label>
                                                          <f:input type="text" id="projectinput2" disabled="true" class="form-control" name="lname" path="persona.correo"/>
                                                      </div>

                                                  </div>


                                                </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-6 text-right">
                                                      <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/usuarioController/nuevo">
                                                        <i class="ft-search"></i> Limpiar
                                                      </a>

                                                      <c:if test="${(usuarioBean.persona.codigo!=null && usuarioBean.persona.codigo>0) && (usuarioBean.codigoUsuario == null || usuarioBean.codigoUsuario == 0)}">
                                                      	<button type="button" class="btn btn-primary" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/asignar','POST','#formularioPersona')"><i class="fa fa-floppy-o"></i> Asignar</button>
                                                      </c:if>
                                                  </div>
                                              </div>
                                      </div>
                                 </f:form>
                                </div>

                              <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                  <f:form class="form mt-1" id="formularioRegistroUsuario" action="${pageContext.request.contextPath}/usuarioController/grabar">
                                            <div class="form-body">
											<f:input type="hidden" id="codigoUsuario" class="form-control" name="codigoUsuario" path="codigoUsuario"/>

                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput1">Nombre Usuario</label>
                                                      <f:input type="text" id="projectinput1" class="form-control" name="fname" required="true" readonly="true" path="nombreUsuario"/>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Situaci&oacute;n</label>
                                                    <f:select id="situacionUsuario" name="interested" class="form-control" path="situacion.codigoRegistro" >
		                                                  <option value="" >Seleccione</option>
		                                                  <f:options  items="${lstSituacion}"
		                                                                    itemValue="codigoRegistro"
		                                                                    itemLabel="nombreCorto"/>
		                                              </f:select>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="passwordUsuario">Contrase&ntilde;a</label>
                                                      <fieldset class="form-group position-relative">
                                                          <f:input type="password" class="form-control form-control-xl " readonly="true" id="passwordUsuario" required="true" path="passwordUsuario"/>
                                                          <div class="form-control-position">
                                                          <i class="icon-key info font-medium-3"></i>
                                                          </div>
                                                      </fieldset>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="projectinput6">Perfil</label>
                                                    <f:select id="codigoPerfil" name="codigoPerfil" class="form-control" path="codigoPerfil" >
		                                                  <option value="" >Todos</option>
		                                                  <f:options  items="${lstPerfiles}"
		                                                                    itemValue="codigoPerfil"
		                                                                    itemLabel="nombrePerfil"/>
		                                              </f:select>
                                                  </div>
                                                   <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajaxPerfil('${pageContext.request.contextPath}/usuarioController/asignarPerfil','POST','#formularioRegistroUsuario')">
                                                            <i class="fa fa-floppy-o"></i> Agregar Perfil
                                                          </button>
                                                      </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-8">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">&Iacute;tem</th>
                                                        <th>Perfil</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
	                                                <c:forEach var="usuarioPerfilBean" items="${lstUsuarioPerfil}">
	                                                    <tr>
	                                                        <td>${index + 1}</td>
	                                                        <td>${usuarioPerfilBean.perfil.nombrePerfil} </td>
	                                                        <td>
	                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="eliminarPerfil(${usuarioPerfilBean.codigoUsuarioPerfil},'${pageContext.request.contextPath}/usuarioController');"><i class="icon-trash"></i></button>
	                                                        </td>
	                                                    </tr>
                                                    </c:forEach>



                                                </tbody>

                                            </table>
                                          </div>
                                        </div>
                                              <div class="row">
                                                  <div class="form-group col-md-6 text-right">

                                                      <button type="submit" class="btn btn-primary"  title="Grabar"><i class="fa fa-floppy-o"></i> Guardar</button>
                                                      <c:if test="${usuarioBean.codigoUsuario!=null && usuarioBean.codigoUsuario>0}">
	                                                      <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/resetPassword','POST','#formularioRegistroUsuario')">
	                                                        <i class="ft-reload"></i> Reestablecer Contrase&nacute;a
	                                                      </button>
	                                                  </c:if>
                                                  </div>
                                              </div>
                                            </div>
                                 </f:form>
                              </div>
                            </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="#" target="_blank" class="text-bold-800 grey darken-2">Natigu </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy Business</span></p>
    </footer>
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/galeria-imagen-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/js/page/seguridad/registro-usuario-script.js" type="text/javascript"></script>

    <script type="text/javascript" charset="utf-8" >
	    var codigo=0;
	    var url="";
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }

       function eliminarPerfil(id,prmUrl){
       	 	codigo = id;
       	 	url = prmUrl;
	       	$("#md_confirmacion #txt_confir").html("Esta acci&oacute;n eliminar&aacute; el registro seleccionado,\n para continuar haga clic en Confirmar");
	      	$("#md_confirmacion #myModalLabel19").html("Eliminar Perfil");
	      	//$("#valorDato").val("GRABAR");
	      	$("#md_confirmacion #btnConfirmarGeneric").attr("onclick","eliminar_perfil()");
	       	 $('#md_confirmacion').modal('show');

         };

       function eliminar_perfil(){
      		console.log("codigo enviado desde html: ",codigo);
      		var usuarioPerfil ={
      				codigoUsuarioPerfil : codigo,

      				codigoUsuario : $("#formularioRegistroUsuario #codigoUsuario").val()


      	      		};
	      	console.log("datos: ",usuarioPerfil);

          	var dirURL = url;
	       	 dirURL += "/eliminarPerfil";
		        $.ajax({
		          url : dirURL,
		          type : 'POST',
		          data : usuarioPerfil,
		          success : function(data) {
			          console.log("resultado: ",data);
			          $("#paginaRegistroUsuario").html(data);

		          },
		          error : function(request, status, error) {
		            alert(error);
		          },
		          complete: function(){
		        	  $('#md_confirmacion').modal('hidden');
			      }
		        });
        };
       function enviar_ajaxPerfil(page,method,form){
   		//showLoad_info_ajax();
   		var codigoPerfil = $("#formularioRegistroUsuario #codigoPerfil").val();
   		if(codigoPerfil == null || codigoPerfil == "" || codigoPerfil == "0" ){
   	   		return;
   	   	}
   		 var dirURL = page;
      	 	//dirURL += page; // El script a dónde se realizará la petición.
   		    $.ajax({
   		           type: method,
   		           url: dirURL,
   		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
   		           success: function(data)
   		           {
   		               $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

   		           },
   					error: function(xhr,status,er) {
   					   /*box_msg(3,"Hubo un error al realizar la petición al servidor.");
   				     console.log("error: " + xhr + " status: " + status + " er:" + er);
   					    if(xhr.status==500) {
   					    	console.log(er);
   					    	Error_500(er);
   					    }
   					    if(xhr.status==901) {
   				    	console.log(er);
   				    	spire_session_901(er);
   	         			}*/
   				    },
   		           complete: function(){
   		        	   $('#md_confirmacion').modal('hidden');
   		             }
   		         });
   		    //confirmacionGenericoHidden();
   		    return false; // Evitar ejecutar el submit del formulario.
   	}

       function enviar_ajax(page,method,form){
      		//showLoad_info_ajax();

      		 var dirURL = page;
         	 	//dirURL += page; // El script a dónde se realizará la petición.
      		    $.ajax({
      		           type: method,
      		           url: dirURL,
      		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
      		           success: function(data)
      		           {
      		               $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

      		           },
      					error: function(xhr,status,er) {
      					   /*box_msg(3,"Hubo un error al realizar la petición al servidor.");
      				     console.log("error: " + xhr + " status: " + status + " er:" + er);
      					    if(xhr.status==500) {
      					    	console.log(er);
      					    	Error_500(er);
      					    }
      					    if(xhr.status==901) {
      				    	console.log(er);
      				    	spire_session_901(er);
      	         			}*/
      				    },
      		           complete: function(){
      		        	   $('#md_confirmacion').modal('hidden');
      		             }
      		         });
      		    //confirmacionGenericoHidden();
      		    return false; // Evitar ejecutar el submit del formulario.
      	}
    </script>
  </body>
</html>