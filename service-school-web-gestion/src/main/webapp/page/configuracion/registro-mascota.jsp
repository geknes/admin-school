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
    <title>Registro de Mascotas</title>
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

    function validarRequired(idfrom){
    var $myForm = $(idfrom);
    if(! $myForm[0].checkValidity()) {
       msg_advertencia("Debe completar correctamente todos los campos requeridos");
    }
  }

       $(document).ready(function() {
    var msj = $("#mensaje").val();//1
    if(msj=='1'){
      msg_exito();
    }else if(msj=='0'){
      msg_advertencia("Ya existe un registro con ese nombre");
    }
      var codigo = document.getElementById("codigoMascota").value;
      if (codigo != '0') {
      $("#limpiar").css("display", "none");
      } 
    });

        function limpiar_imagenes(){  
      $('#imgmas1').attr('src','../assets/img/usar_imagen.jpg');
      $('#imgmas2').attr('src','../assets/img/usar_imagen.jpg');
      $('#imgmas3').attr('src','../assets/img/usar_imagen.jpg');
      $('#imgmas4').attr('src','../assets/img/usar_imagen.jpg'); 
    }  
    </script>
    <style>
          .thumb {
            height: 200px;
            border: 0px solid #000;
            margin: 0px 0px 0 0;
            max-height: 200px;
            max-width: 200px;
            overflow: hidden;
          }
           
    </style>
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

    <input type="hidden" name="country" value="${pageContext.request.contextPath}">
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
                   <li class="breadcrumb-item"><a href="#">Configuraci&oacute;n</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Registro De Mascotas</a>
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
                       <f:form id="frmRegistroMascota" class="form-horizontal" role="form"  enctype="multipart/form-data" method="post" action="grabar" novalidate="true">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title"> Registro de Mascota</h4>
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
                                    <div class="col-md-11 offset-md-0">
                                      <form class="form">
                                        <div class="form-body">


                                          <div class="row">
                                          <f:input type="hidden" path="codigo"  id="codigoMascota"/>
                                          <%--
                                           <div class="form-group col-md-2">
                                                <label for="nombr">Nombre<span class="required">*</span></label>
                                                <div class="controls">

                                                  <f:input type="text" class="form-control" id="nombreMascota" name="nombreMascota" path="nombre" data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                                </div>
                                           </div>
                                           --%>
                                           <div class="form-group col-md-4">
                                                  <label for="apellidoPaterno">Nombre <span class="required">*</span></label>
                                                  <div class="controls">
                                                      <f:input type="text" id="nombreMascota" class="form-control" name="nombreMascota"  path="nombre"  data-validation-required-message="Este campo es requerido"  required="required" />
                                                  </div>
                                           </div>


                                            <div class="form-group col-md-2">

                                                  <label for="moned">Monedas<span class="required">*</span></label>
                                                  <div class="controls">
                                                  <f:input type="text" onkeypress="return valida(event)" class="form-control" path="valormoneda" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"  required="required" maxlength="10"/>
                                             </div>
                                             </div>
                                              <div class="form-group col-md-2">
                                                <label for="regi">Regi&oacute;n<span class="required">*</span></label>
                                                <div class="controls">
                                                <f:select id="lblRegion"  path="region.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                <f:options  items="${lstRegion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                              </div>
                                              </div>
                                              <div class="form-group col-md-2">
                                                <label for="situacionMascota">Situaci&oacute;n<span class="required">*</span></label>
                                                <div class="controls">
                                                <f:select id="lblSituacion"  path="situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                            </div>
                                              </div>
                                              <div class="form-group col-md-2">
                                                <label for="PredeterminadoMascota">Predeterminado<span class="required">*</span></label>
                                                <div class="controls">
                                                <f:select id="lblPrede"  path="predeterminado" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                <f:options  items="${lstPredeterminado}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                            </div>
                                              </div>

                                               <div class="form-group col-md-12">
                                           <div class="controls">
                                                  <label for="descripci">Descripci&oacute;n</label>
                                                  <f:textarea  class="form-control" path="descripcion" />
                                            </div>
                                            </div>
                                          </div>

                                           
										                          <div class="row"  style="display: none;" >
	                                          <div class="form-group col-md-3"  >
	                                            <f:input type="file" path="file" name="file1" id="file1" onchange="return validar_file('file1','imgmas1','${pageContext.request.contextPath}/mascota/${mascotaBean.imagenAlegre}','codigoMascota')" accept="image/png, .jpeg, .jpg, image/gif"/>
	                                          </div>
	                                          <div class="form-group col-md-3"  >
	                                          	<f:input type="file" path="file" name="file2" id="file2"  onchange="return validar_file('file2','imgmas2','${pageContext.request.contextPath}/mascota/${mascotaBean.imagenTriste}','codigoMascota')" accept="image/png, .jpeg, .jpg, image/gif"/>
	                                          </div>
	                                          <div class="form-group col-md-3"  >
	                                          	<f:input type="file" path="file" name="file3" id="file3" onchange="return validar_file('file3','imgmas3','${pageContext.request.contextPath}/mascota/${mascotaBean.imagenExclamativa}','codigoMascota')" accept="image/png, .jpeg, .jpg, image/gif"/>
	                                          </div> 


                                          </div>

                                          <div class="row ">
                                          <div class="form-group col-md-3"  >
                                          <center><label> Imagen Estado Neutro* </label></center>
                                          <div id="list4"   style="cursor: pointer;">
                                             <c:choose>
                                              <c:when test="${not empty mascotaBean.imagenNormal}">
                                                <label for=""><img id="imgmas4" onclick="abrir_input('file4')" src="${pageContext.request.contextPath}/mascota/${mascotaBean.imagenNormal}" alt="${mascotaBean.imagenNormal}"  class="img-fluid thumb" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                                                <div id="fake-btn-4" style="display:none" class="form-input text-xs-center truncate"></div>
                                              </c:when>
                                              <c:otherwise>
                                                <label for=""><img id="imgmas4" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file4')" alt="element 01" class="img-fluid thumb" style="cursor: pointer;"></label> 
                                              </c:otherwise>
                                             </c:choose>
                                          </div>
                                          </div>
                                          <div class="form-group col-md-3"  >
                                           <center> <label>Imagen Estado Alegre</label></center>
                                           <div id="list1"   style="cursor: pointer;">
                                             <c:choose>
                                             	<c:when test="${not empty mascotaBean.imagenAlegre}">
                                             		<label for=""><img id="imgmas1" onclick="abrir_input('file1')" src="${pageContext.request.contextPath}/mascota/${mascotaBean.imagenAlegre}" alt="${mascotaBean.imagenAlegre}"  class="img-fluid thumb" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                                             		<div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
                                             	</c:when>
                                             	 
                                              <c:otherwise>
                                                <label for=""><img id="imgmas1" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file1')" alt="element 01" class="img-fluid thumb" style="cursor: pointer;"></label> 
                                              </c:otherwise>
                                             </c:choose>
                                          </div>
                                          </div>
                                          <div class="form-group col-md-3"  >
                                          <center> <label>Imagen Estado Triste</label></center>
                                          <div id="list2"   style="cursor: pointer;">
                                             <c:choose>
                                             	<c:when test="${not empty mascotaBean.imagenTriste}">
                                             		<label for=""><img id="imgmas2" onclick="abrir_input('file2')" src="${pageContext.request.contextPath}/mascota/${mascotaBean.imagenTriste}" alt="${mascotaBean.imagenTriste}"  class="img-fluid thumb" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                                             		 
                                             	</c:when>
                                             	<c:otherwise>
                                                <label for=""><img id="imgmas2" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file2')" alt="element 01" class="img-fluid thumb" style="cursor: pointer;"></label> 
                                              </c:otherwise>
                                             </c:choose>
                                          </div>
                                          </div>
                                          <div class="form-group col-md-3"  >
                                          <center><label> Imagen Estado Sorprendido</label></center>
                                          <div id="list3"   style="cursor: pointer;">
                                             <c:choose>
                                             	<c:when test="${not empty mascotaBean.imagenExclamativa}">
                                             		<label for=""><img id="imgmas3" onclick="abrir_input('file3')" src="${pageContext.request.contextPath}/mascota/${mascotaBean.imagenExclamativa}" alt="${mascotaBean.imagenExclamativa}"  class="img-fluid thumb" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                                             		 
                                             	</c:when>
                                             	<c:otherwise>
                                                <label for=""><img id="imgmas3" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file3')" alt="element 01" class="img-fluid thumb" style="cursor: pointer;"></label> 
                                              </c:otherwise>
                                             </c:choose>
                                          </div>
                                          </div> 

                                          <div class="form-group col-md-3 ">
                                              <c:if  test="${ empty mascotaBean.imagenNormal}">
                                                <div class="controls">
                                                    <f:input  type="file" style="display:none"  path="file"   required="required"  accept="image/png, .jpeg, .jpg, image/gif"   onchange="return validar_file('file4','imgmas4','','codigoMascota')"  name="files[]" id="file4" data-validation-required-message="Se requiere Imagen"/> 
                                                </div>  

                                              </c:if> 
                                              <c:if  test="${not empty mascotaBean.imagenNormal}"> 
                                                    <f:input style="display:none" type="file"  path="file"  accept="image/png, .jpeg, .jpg, image/gif"  onchange="return validar_file('file4','imgmas4','${pageContext.request.contextPath}/mascota/${mascotaBean.imagenNormal}','codigoMascota')" name="files[]" id="file4"  /> 
                                              </c:if> 
                                             </div> 
                                              <div class="form-group col-md-12 text-right">
                                                  <button type="reset"  id="limpiar"  onclick="limpiar_imagenes();"  class="btn btn-flat btn-secondary">
                                                    <i class="fa fa-eraser"></i>
                                            Limpiar
                                          </button>
                                                  <button id="btn-save-reg" type="submit"
                                            class="btn btn-flat btn-primary" onclick="validarRequired('#frmRegistroMascota');" >
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
    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
  </body>
</html>