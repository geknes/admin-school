<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<ul id="main-menu-navigation" data-menu="menu-navigation" class="navigation navigation-main">
  <li class=" navigation-header"><span>General</span><i data-toggle="tooltip" data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
  </li>

  <c:set var="menuInicio" value="${pageContext.request.contextPath}/page/inicio.jsp" />
  <li class="nav-item ${pageContext.request.requestURI eq menuInicio ? ' active' : ''}"><a href="${pageContext.request.contextPath}/inicioController/listar"><i class="ft-home"></i><span data-i18n="" class="menu-title">Inicio</span></a>
  </li>

  <c:if test="${accesoMenu.aloc_institucion}">
  	<c:set var="menuListadoInstitucion" value="${pageContext.request.contextPath}/page/general/institucion/listado-institucion.jsp" />
  	<c:set var="menuRegistroInstitucion" value="${pageContext.request.contextPath}/page/general/institucion/registro-institucion.jsp" />
  	<li class="nav-item ${((pageContext.request.requestURI eq menuListadoInstitucion) or (pageContext.request.requestURI eq menuRegistroInstitucion)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/institucionController/listado"><i class="fa fa-building-o"></i><span data-i18n="" class="menu-title">Instituci&oacute;n</span></a>
    </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_lengua}">
	<c:set var="menuListadoLengua" value="${pageContext.request.contextPath}/page/general/lengua/listado-lengua.jsp" />
  	<c:set var="menuRegistroLengua" value="${pageContext.request.contextPath}/page/general/lengua/registro-lengua.jsp" />
	<li class="nav-item ${((pageContext.request.requestURI eq menuListadoLengua) or (pageContext.request.requestURI eq menuRegistroLengua)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/lenguaController/listado"><i class="fa fa-language"></i><span data-i18n="" class="menu-title">Lengua</span></a>
	</li>
  </c:if>
  <c:if test="${accesoMenu.aloc_material}">
	  <li class=" nav-item"><a href="#"><i class="fa icon-notebook"></i><span data-i18n="" class="menu-title">Material</span></a>
	    <ul class="menu-content">
	      <c:if test="${accesoMenu.aloc_material_carga_directa.lectura}">
				<c:set var="menuListadoCargaDirecta" value="${pageContext.request.contextPath}/page/general/listado-carga-material.jsp" />
				<c:set var="menuRegistroCargaDirecta" value="${pageContext.request.contextPath}/page/general/registro-carga-material.jsp" />
		      <li class="${((pageContext.request.requestURI eq menuListadoCargaDirecta) or (pageContext.request.requestURI eq menuRegistroCargaDirecta)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/cargaMaterialController/listado" class="menu-item">Carga Directa</a>
		        <!-- <ul class="menu-content"> -->
		<!--           <li><a href="carga-lengua-listado.jsp" class="menu-item">Carga Lengua</a>
		          </li> -->
		          <%-- <li><a href="${pageContext.request.contextPath}/cargaMaterialController/listado" class="menu-item">Carga Material</a> --%>
		          <!-- <li><a href="registro-carga-material.jsp" class="menu-item">Carga Material</a> -->

		          <!-- </li> -->
		        <!-- </ul> -->
		      </li>
	      </c:if>
	      <c:if test="${accesoMenu.aloc_material_carga_masiva.lectura}">
	      	  <c:set var="menuListadoCargaMasiva" value="${pageContext.request.contextPath}/page/general/material/carga-material-masivo.jsp" />
		      <li class="${pageContext.request.requestURI eq menuListadoCargaMasiva ? ' active' : ''}"><a href="${pageContext.request.contextPath}/cargaMasivaController/listado" class="menu-item">Carga Masiva</a>
		        <!-- <ul class="menu-content"> -->
		<!--           <li><a href="timeline-center.html" class="menu-item">Lengua</a>
		          </li> -->
		          <%-- <li><a href="${pageContext.request.contextPath}/cargaMasivaController/listado" class="menu-item">Carga Material</a> --%>
		          <!-- <li><a href="carga-material-masivo.jsp" class="menu-item">Carga Material</a></li> -->
		        <!-- </ul> -->
		      </li>
		  </c:if>
	    </ul>
	  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_personal}">
  	  <c:set var="menuListadoPersonal" value="${pageContext.request.contextPath}/page/general/listado-administrativo.jsp" />
	  <c:set var="menuRegistroPersonal" value="${pageContext.request.contextPath}/page/general/registro-administrativo.jsp" />

	  <li class="nav-item ${((pageContext.request.requestURI eq menuListadoPersonal) or (pageContext.request.requestURI eq menuRegistroPersonal)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/personalController/listado"><i class="fa fa-address-book-o"></i><span data-i18n="" class="menu-title">Gestor</span></a>
	  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_inscripcion or accesoMenu.aloc_matricula or accesoMenu.aloc_docente or accesoMenu.aloc_alumno}">
  <li class=" navigation-header"><span>Acad&eacute;mico</span><i data-toggle="tooltip" data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_inscripcion}">
  	  <c:set var="menuListadoInscripcion" value="${pageContext.request.contextPath}/page/academico/listado-inscripcion.jsp" />
	  <c:set var="menuRegistroInscripcion" value="${pageContext.request.contextPath}/page/academico/registro-inscripcion.jsp" />
	  <li class="nav-item ${((pageContext.request.requestURI eq menuListadoInscripcion) or (pageContext.request.requestURI eq menuRegistroInscripcion)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/inscripcionController/listado"><i class="icon-doc"></i><span data-i18n="" class="menu-title">Inscripci&oacute;n</span></a>
	  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_matricula}">
  		<c:set var="menuListadoMatricula" value="${pageContext.request.contextPath}/page/academico/listado-matricula.jsp" />
	  	<c:set var="menuRegistroMatricula" value="${pageContext.request.contextPath}/page/academico/registro-matricula.jsp" />
	  <li class=" nav-item ${((pageContext.request.requestURI eq menuListadoMatricula) or (pageContext.request.requestURI eq menuRegistroMatricula)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/matriculaController/listado"><i class="fa fa-wpforms"></i><span data-i18n="" class="menu-title">Matr&iacute;cula</span></a>
	  <%--   <ul class="menu-content">
	      <c:if test="${accesoMenu.aloc_matricula_registro.lectura}">
  	  		<c:set var="menuListadoMatricula" value="${pageContext.request.contextPath}/page/academico/listado-matricula.jsp" />
	  		<c:set var="menuRegistroMatricula" value="${pageContext.request.contextPath}/page/academico/registro-matricula.jsp" />
		      <li class="${((pageContext.request.requestURI eq menuListadoMatricula) or (pageContext.request.requestURI eq menuRegistroMatricula)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/matriculaController/listado" class="menu-item"><i class="icon-notebook"></i> Registro</a>
		      </li>
	      </c:if>
	      <c:if test="${accesoMenu.aloc_matricula_asignar_usuario.lectura}">
		      <li><a href="${pageContext.request.contextPath}/asignarUsuarioController/listado" class="menu-item"><i class="icon-doc"></i> Asignar Usuario</a>
<!-- 		      </li> -->
	      </c:if>
	    </ul> --%>
	  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_docente}">
    <c:set var="menuListadoDocente" value="${pageContext.request.contextPath}/page/academico/listado-docente.jsp" />
    <c:set var="menuRegistroDocente" value="${pageContext.request.contextPath}/page/academico/registro-docente.jsp" />
  	<li class="nav-item ${((pageContext.request.requestURI eq menuListadoDocente) or (pageContext.request.requestURI eq menuRegistroDocente)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/docenteController/listado"><i class="fa icon-briefcase"></i><span data-i18n="" class="menu-title">Docente</span></a></li>
  </c:if>
  <c:if test="${accesoMenu.aloc_alumno}">
	  <li class=" nav-item"><a href="#"><i class="fa icon-graduation"></i><span data-i18n="" class="menu-title">Estudiante</span></a>
	    <ul class="menu-content">
	      <c:if test="${accesoMenu.aloc_alumno_registro.lectura}">
    		<c:set var="menuListadoAlumno" value="${pageContext.request.contextPath}/page/academico/listado-alumno.jsp" />
    		<c:set var="menuRegistroAlumno" value="${pageContext.request.contextPath}/page/academico/registro-alumno.jsp" />
		      <li class="${((pageContext.request.requestURI eq menuListadoAlumno) or (pageContext.request.requestURI eq menuRegistroAlumno)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/alumnoController/listado" class="menu-item"><i class="icon-user-follow"></i> Registro</a>
		      </li>
	      </c:if>
	      <c:if test="${accesoMenu.aloc_alumno_seguimiento.lectura}">
    			<c:set var="menuListadoSegui" value="${pageContext.request.contextPath}/page/academico/seguimiento-alumno.jsp" />
		      <li class="${pageContext.request.requestURI eq menuListadoSegui ? ' active' : ''}"><a href="${pageContext.request.contextPath}/seguimientoController/listado" class="menu-item"><i class="ft-activity"></i> Seguimiento</a>
		      </li>
	      </c:if>
	    </ul>
	  </li>
  </c:if>
<!--   <li class=" nav-item"><a href="listado-indicador.jsp"><i class="ft-printer"></i><span data-i18n="" class="menu-title">Indicadores</span></a>
  </li> -->
<!--   <li class=" nav-item"><a href="#"><i class="ft-share"></i><span data-i18n="" class="menu-title">Indicadores</span></a>
    <ul class="menu-content">
      <li><a href="#" class="menu-item">Alumno</a></li>
    </ul>
  </li> -->
  <c:if test="${accesoMenu.aloc_seguridad or accesoMenu.aloc_configuracion}">
  <li class=" navigation-header"><span>Otros</span><i data-toggle="tooltip" data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_seguridad}">
  	  <li class=" nav-item"><a href="#"><i class="fa fa-shield"></i><span data-i18n="" class="menu-title">Seguridad</span></a>
	    <ul class="menu-content">
	      <c:if test="${accesoMenu.aloc_seguridad_usuario.lectura}">
    		 <c:set var="menuListadoUsuario" value="${pageContext.request.contextPath}/page/seguridad/usuario/listado-usuario.jsp" />
    		 <c:set var="menuRegistroUsuario" value="${pageContext.request.contextPath}/page/seguridad/usuario/registro-usuario.jsp" />
		      <li class="${((pageContext.request.requestURI eq menuListadoUsuario) or (pageContext.request.requestURI eq menuRegistroUsuario)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/usuarioController/listado" class="menu-item"><i class="icon-user"></i> Usuario</a>
		      </li>
	      </c:if>
	      <c:if test="${accesoMenu.aloc_seguridad_perfil.lectura}">
	      		<c:set var="menuListadoPerfil" value="${pageContext.request.contextPath}/page/seguridad/usuario/listado-perfil.jsp" />
    		    <c:set var="menuRegistroPerfil" value="${pageContext.request.contextPath}/page/seguridad/perfil/registro-perfil.jsp" />
		      <li class="${((pageContext.request.requestURI eq menuListadoPerfil) or (pageContext.request.requestURI eq menuRegistroPerfil)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/perfilController/listado" class="menu-item"><i class="fa ft-flag"></i> Perfil</a>
		      </li>
	      </c:if>
	      <c:if test="${accesoMenu.aloc_seguridad_acceso.lectura}">
	      		<c:set var="menuAccesos" value="${pageContext.request.contextPath}/page/seguridad/acceso/acceso.jsp" />
		      <li class="${pageContext.request.requestURI eq menuAccesos ? ' active' : ''}"><a href="${pageContext.request.contextPath}/accesoController/listado" class="menu-item"><i class="icon-action-redo"></i> Accesos</a>
		      </li>
	      </c:if>
	      <%-- <li><a href="${pageContext.request.contextPath}/usuarioController/cambiarPassUsuario" class="menu-item"><i class="icon-action-redo"></i> Cambiar Contrase&ntilde;a</a>
	      </li> --%>
	    </ul>
	  </li>
  </c:if>
  <c:if test="${accesoMenu.aloc_configuracion}">

	  <li class=" nav-item"><a href="#"><i class="icon-settings"></i><span data-i18n="" class="menu-title">Configuraci&oacute;n</span></a>
	    <ul class="menu-content">
	      	  <c:if test="${accesoMenu.aloc_configuracion_tabla_maestra.lectura}">
	      		 <c:set var="menuListadoMaestra" value="${pageContext.request.contextPath}/page/configuracion/listado-tabla-maestra.jsp" />
    		     <c:set var="menuRegistroMaestra" value="${pageContext.request.contextPath}/page/configuracion/registro-tabla-maestra.jsp" />
			      <li class="${((pageContext.request.requestURI eq menuListadoMaestra) or (pageContext.request.requestURI eq menuRegistroMaestra)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/tmaestraController/listado" class="menu-item"><i class="icon-grid"></i> Tabla Maestra</a>
			      </li>
	      	  </c:if>
	      	  <c:if test="${accesoMenu.aloc_configuracion_mascota.lectura}">
	      		 <c:set var="menuListadoMascota" value="${pageContext.request.contextPath}/page/configuracion/listado-mascota.jsp" />
    		     <c:set var="menuRegistroMascota" value="${pageContext.request.contextPath}/page/configuracion/registro-mascota.jsp" />
			      <li class="${((pageContext.request.requestURI eq menuListadoMascota) or (pageContext.request.requestURI eq menuRegistroMascota)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/mascotaController/listado" class="menu-item"><i class="fa fa-qq"></i> Mascotas</a>
			      </li>
	      	  </c:if>
	       <%-- <li><a href="seguimiento-alumno.jsp" class="menu-item">Seguimiento Alumno</a> </li>
	      	  <c:if test="${accesoMenu.aloc_configuracion_traduccion_general.lectura}">
			      <li><a href="#" class="menu-item"><i class="fa fa-language"></i> Traducci&oacute;n General</a>
			      </li>
	      	  </c:if>  --%>
	      	  
	      	  	  <%-- <c:if test="${accesoMenu.aloc_configuracion_mascota.lectura}"> --%>
	      	  	  <c:if test="true">
	      		 <c:set var="menuListadoFondo" value="${pageContext.request.contextPath}/page/configuracion/listado-fondo.jsp" />
    		     <c:set var="menuRegistroFondo" value="${pageContext.request.contextPath}/page/configuracion/registro-fondo.jsp" />
			      <li class="${((pageContext.request.requestURI eq menuListadoFondo) or (pageContext.request.requestURI eq menuRegistroFondo)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/fondoController/listado" class="menu-item"><i class="fa fa-qq"></i> Fondos</a>
			      </li>
	      </c:if> 
	      
	       <c:if test="true">
	      		 <c:set var="menuListadoModal" value="${pageContext.request.contextPath}/page/configuracion/listado-modal.jsp" />
    		     <c:set var="menuRegistroModal" value="${pageContext.request.contextPath}/page/configuracion/registro-modal.jsp" />
			      <li class="${((pageContext.request.requestURI eq menuListadoModal) or (pageContext.request.requestURI eq menuRegistroModal)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/modalController/listado" class="menu-item"><i class="icon-grid"></i> Modal</a>
			      </li>
	      </c:if> 
	      	  
	      	  <c:if test="${accesoMenu.aloc_configuracion_premio.lectura}">

	      		 <c:set var="menuListadoPremio" value="${pageContext.request.contextPath}/page/configuracion/listado-premio.jsp" />
    		     <c:set var="menuRegistroPremio" value="${pageContext.request.contextPath}/page/configuracion/registro-premio.jsp" />
			      <li class="${((pageContext.request.requestURI eq menuListadoPremio) or (pageContext.request.requestURI eq menuRegistroPremio)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/premioController/listado" class="menu-item"><i class="icon-trophy"></i> Premios</a>
			      </li>
	      	  </c:if>
	      	  <c:if test="${accesoMenu.aloc_configuracion_ficha_puntaje.lectura}">
	      	  		<c:set var="menuListadoFp" value="${pageContext.request.contextPath}/page/configuracion/ficha-puntajes.jsp" />
			      <li class="${pageContext.request.requestURI eq menuListadoFp ? ' active' : ''}"><a href="${pageContext.request.contextPath}/fichaPuntajeController/datos" class="menu-item"><i class="icon-star"></i> Ficha de Puntajes</a>
			      </li>
	      	  </c:if>
	
	      	 <%--  <c:if test="${accesoMenu.aloc_configuracion_slider.lectura}"> --%>
	      	 <%-- <c:if test="${accesoMenu.aloc_configuracion_slider.lectura}">  --%>
	      	 
	      		 <c:set var="menuListadoSlider" value="${pageContext.request.contextPath}/page/configuracion/listado-slider.jsp" />
    		     <c:set var="menuRegistroSlider" value="${pageContext.request.contextPath}/page/configuracion/registro-slider.jsp" />
			      <li class="${((pageContext.request.requestURI eq menuListadoSlider) or (pageContext.request.requestURI eq menuRegistroSlider)) ? ' active' : ''}"><a href="${pageContext.request.contextPath}/sliderController/listado" class="menu-item"><i class="fa fa-qq"></i> Sliders</a>
			      </li>
	      	  <%-- </c:if> --%>
	<!--       <li><a href="notificacion.jsp" class="menu-item">Notificaci&oacute;n</a></li> -->
	<!--       <li><a href="timeline-horizontal.html" class="menu-item">Correo</a></li> -->
	<!--       <li><a href="timeline-horizontal.html" class="menu-item">Mascotas</a></li> -->
	    </ul>
	  </li>
  </c:if>
</ul>