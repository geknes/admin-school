<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
 				
 			     <table id="tb_alumno" class="table table-striped table-bordered">
                  <thead>
                      <tr>
                      	  <th width="15">Codigo</th>
                          <th>Nombre de alumno</th>
                          <th>N&uacute;mero de doc.</th>
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="alumnoBean" items="${lstAlumnoBean}">
                      <tr>
                      	  <td>${alumnoBean.codigo}</td>
                          <td>${alumnoBean.personaBean.nombrePersona} ${docenteBean.personaBean.apellidoPaterno} ${docenteBean.personaBean.apellidoMaterno}</td>
                          <td>${alumnoBean.personaBean.numeroDocumento}</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"  onclick="agregarMatriculaAlumno(${alumnoBean.codigo})"><i class="icon-arrow-right"></i></button>
                          </td>
                      </tr>
                      </c:forEach>
                  </tbody>
              </table>