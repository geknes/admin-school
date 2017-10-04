<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro de Tabla Maestra</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
    <script type="text/javascript">

       $(document).ready(function() {

      var codigo = document.getElementById("codigoRegistro").value;
      if (codigo != '0') {
          $('#codtb').css("cursor", "default");
         $('#codtb').attr("disabled", true);
         $("#limpiar").css("display", "none");
      }
    });

       function validarRequired(idfrom){

    var $myForm = $(idfrom);
    if(! $myForm[0].checkValidity()) {
       msg_advertencia("Debe completar correctamente todos los campos requeridos");
    }
  }

      function setInputHidden(){
          $('#codigoTabla').val($('#codtb').val());
      }

         //mensaje
    $(document).ready(function() {

    var msj = $("#mensaje").val();//1
    if(msj=='1'){
      msg_exito();
    }else if(msj=='0'){
      msg_advertencia("Ya existe un registro con ese nombre");
    }
   });

     function validatee(){
    if(document.getElementById("codigo").value==0){
      document.getElementById("codigo").value="0";
    }
  }
    </script>

  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

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
          <div class="content-header-left col-md-10 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Otros</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Configuraci&oacute;n</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#"> Registro Tabla Maestra</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <input type="hidden" value="${swMensaje}"  id="mensaje"  />
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                      <f:form id="frmRegistroMaestra" class="form-horizontal" enctype="multipart/form-data" role="form" method="post" action="grabar" novalidate="true">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Registro de Tabla Maestra </h4>
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
                                    <div class="col-md-11 offset-md-1">

                                         <div class="form-body">

                                          <div class="row">
                                            <f:input type="hidden" path="id"  id="id"/>
                                         <f:input type="hidden" path="codigoRegistro"  id="codigoRegistro"/>
                                          <c:if test="${maestraBean.codigoRegistro>0}">
                                            <f:input type="hidden" path="codigoTabla"  id="codigoTabla"/>
                                          </c:if>

                                          <div class="form-group col-md-4 mb-2">
                                                <label for="situacionUsuario">Nombre de Tabla de Tabla<span class="required">*</span></label>
                                                <div class="controls">
                                                <f:select  id="codtb"    type="text"  name="codtb" path="codigoTabla" class="form-control" data-validation-required-message="Este campo es requerido" required="required" onchange="setInputHidden()">
                                                <f:option value="" label="Seleccionar"/>
                                                <f:options   items="${lstGeneral}"
                                                            itemValue="codigoTabla"
                                                            itemLabel="codigoTabla"/>
                                                </f:select>
                                              </div>
                                              </div>

                                              <div class="form-group col-md-4 mb-2">
                                                  <label for="projectinput1">Nombre Corto<span class="required">*</span></label>
                                                  <div class="controls">
                                                  <f:input type="text" id="nomcor" class="form-control" path="nombreCorto"  maxlength="200" data-validation-required-message="Este campo es requerido" required="required"/>

                                              </div>
                                              </div>
                                              <div class="form-group col-md-4 mb-2">
                                                  <label for="projectinput1">Nombre Largo</label>
                                                  <div class="controls">
                                                  <f:input type="text" class="form-control" path="nombreLargo"   maxlength="200"/>
                                              </div>
                                              </div>

                                          </div>
                                           <div class="row">
                                           <div class="form-group col-md-3 mb-2">
                                                  <label for="projectinput1">Valor 1</label>
                                                  <div class="controls">
                                                  <f:input type="text" class="form-control" path="valor1"   maxlength="1000"/>
                                              </div>
                                              </div>
                                              <div class="form-group col-md-3 mb-2">
                                                  <label for="projectinput1">Valor 2</label>
                                                  <div class="controls">
                                                  <f:input type="text" class="form-control" path="valor2"   maxlength="1000"/>
                                              </div>
                                              </div>

                                              <div class="form-group col-md-3 mb-2">
                                                  <label for="projectinput1">Valor 3</label>
                                                  <div class="controls">
                                                  <f:input type="text" class="form-control" path="valor3"   maxlength="2000"/>
                                              </div>
                                              </div>
                                              <div class="form-group col-md-3 mb-2">
                                                  <label for="projectinput1">Nro Orden</label>
                                                  <div class="controls">
                                                  <f:input type="text" class="form-control" path="orden" pattern="[0-9]{1,}" maxlength="2" />
                                              </div>
                                              </div>

                                          </div>

                                          <div class="row">
                                              <div class="form-group col-md-12 text-right">
                                                  <button type="reset" class="btn btn-secondary mr-1" id="limpiar">
                                                        <i class="fa fa-eraser"></i>  Limpiar
                                                      </button>
                                                  <button type="submit" id="btn-save-reg" onclick="validarRequired('#frmRegistroMaestra');"
                                            class="btn btn-flat btn-primary">
                                            <i class="fa fa-floppy-o"></i>
                                            Guardar
                                          </button>
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
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

     <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="#" target="_blank" class="text-bold-800 grey darken-2">ALOC </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy Business</span></p>
    </footer>
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
  </body>
</html>