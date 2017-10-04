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
                  <li class="breadcrumb-item active"><a href="#">Cambiar Contrase&ntilde;a</a>
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
                                  <h4 class="card-title">Cambiar Contrase&ntilde;a</h4>
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

                                    

                             <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1 card-body collapse in">
                              <div class="card-block">
                                 <f:form class="form-horizontal form-simple" role="form" action="${pageContext.request.contextPath}/usuarioController/cambiarPass" onsubmit="return validar();">
			                        <input type="text" id="msgError" value="${msgError}" style="display: none !important;">
			                     	<input id="Mensaje" type="hidden" value="${Mensaje}">
			                        <f:input type="hidden" 
			                            		 class="form-control form-control-lg input-lg" 
			                            		 id="codigoUsuario"
			                            		 path="codigoUsuario"
			                            		 required="true"/>
			                        		 
			                        <label for="textClave">Contrase&ntilde;a Actual<span class="required">*</span></label>		 
			                        <fieldset class="form-group position-relative has-icon-left valid-msg">
			                            <f:input type="password" 
			                            		 class="form-control form-control-lg input-lg" 
			                            		 id="textClave"
			                            		 path="passwordUsuario"
			                            		 required="true"/>
			                            <div class="form-control-position">
			                                <i class="fa fa-key"></i>
			                            </div>
			                        </fieldset>
			                        <label for="textNewClave">Nueva Contrase&ntilde;a<span class="required">*</span></label>
			                        <fieldset class="form-group position-relative has-icon-left valid-msg">
			                            <f:input type="password" 
			                            		 class="form-control form-control-lg input-lg" 
			                            		 id="textNewClave"
			                            		 path="newPassword" 
			                            		 required="true"/>
			                            <div class="form-control-position">
			                                <i class="fa fa-key"></i>
			                            </div>
			                        </fieldset>
			                        <label for="textReClave">Repita Contrase&ntilde;a<span class="required">*</span></label>
			                        <fieldset class="form-group position-relative has-icon-left valid-msg">
			                            <input type="password" 
			                            		 class="form-control form-control-lg input-lg" 
			                            		 id="textReClave"
			                            		 required />
			                            <div class="form-control-position">
			                                <i class="fa fa-key"></i>
			                            </div>
			                        </fieldset>
			                        
			                        <div id="boxMsgx"></div>
			                        
			                        <!-- <a href="inicio.jsp" class="btn btn-primary btn-lg" title=""><i class="ft-unlock"></i> Iniciar</a> -->
			                        <button id="btnResetPass" type="submit" class="btn btn-primary btn-lg btn-block"><i class="ft-unlock"></i> Actualizar</button>
			                    </f:form>
                                </div>
                            </div>
                            <div class="card-footer">
				                <div class="">
				                    <!-- <p class="float-sm-left text-xs-center m-0"><a href="recordar-contrasenia.jsp" class="card-link">Recuperar contrase&ntilde;a</a></p> -->
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
    var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";
    
    $("#textClave, #textNewClave, #textReClave").keyup(function(){
        if( $("#textClave").val() == "" ){            
            $("#textClave").focus();
            var contentInput = $("#textClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese clave actual");
        }else{
            $("#textUsuario").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }
    });

    $("#textNewClave").keyup(function(){
        if( $("#textNewClave").val() == "" ){            
            $("#textNewClave").focus();
            var contentInput = $("#textNewClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese su nueva contrase&ntilde;a");
        }else{
            $("#textClave").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }
    });

    $("#textReClave").keyup(function(){
        if( $("#textReClave").val() == "" ){            
            $("#textReClave").focus();
            var contentInput = $("#textReClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, confirme su nueva contrase&ntilde;a");
        }else{
            $("#textClave").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }
    });

    function validar(){
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

        var txtUsuario = $("#textClave").val();
        var txtClave = $("#textNewClave").val();
        var txtReClave = $("#textReClave").val();

        if( txtUsuario == ""){            
            $("#textClave").focus();
            var contentInput = $("#textClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese clave actual");
            return false;
        }

        if(txtUsuario != ""){
            $("#textClave").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }


        if(txtClave == ""){            
            $("#textNewClave").focus();
            var contentInput = $("#textNewClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese su nueva contrase&ntilde;a");
            return false;
        }

        if(txtClave != ""){
            $("#textNewClave").parents("valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }

        if(txtReClave == ""){            
            $("#textReClave").focus();
            var contentInput = $("#textReClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, confirme su nueva contrase&ntilde;a");
            return false;
        }

        if(txtReClave != ""){
            $("#textReClave").parents("valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }

        if(txtClave != txtReClave){
        	$("#textReClave").focus();
            var contentInput = $("#textReClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("La contrase&ntilde;a no coincide");
            return false;
        }else{
        	$("#textReClave").parents("valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
         }
		return true;
    };

	$(document).ready(function() {
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"            
		var msgError=document.getElementById('msgError').value;
		if(msgError.length>0){
            //$("#boxMsgx").append(infoHtml);                
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html(msgError);
		}
	});
    </script>
  </body>
</html>