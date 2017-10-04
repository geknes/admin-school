<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="60">Fecha</th>
                                                              <th width="150">Director</th>
                                                              <th width="150">Web Institucional</th>
                                                              <th width="110">Tel&eacute;fono</th>
                                                              <th width="90">Correo</th>
                                                              <th >Descripci&oacute;n</th>
                                                              <th width="85">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idBodyListaInstDirector">
                                                      <c:forEach var="directorBean" items="${lstInstitucionDirectorBean}"  varStatus="loop">
                                                          <tr>
                                                          <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${directorBean.fechaCreacion}" /></td>
                                                              <td>${directorBean.personaBean.nombreCompleto}</td>
                                                              <td>
                                                                <i class="ft-map-pin media-left media-middle"></i>
                                                                <div class="media-body">${directorBean.urlWeb}</div>
                                                              </td>
                                                              <td> ${directorBean.telefono}</td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">${directorBean.correo}</div>
                                                                </div>
                                                              </td>
                                                              <td>${directorBean.descripcion}</td>
                                                              <td>
                                                              <button id="idBtnEditarLengua" type="button" onclick="cargarDatosDirector(${directorBean.codigo})" 
                                         						class="btn btn-outline-success btn-sm" >
                                            					<i class="icon-pencil"></i></button> 
                                                               <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_eliminar('director',${directorBean.codigo});"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                          </c:forEach>

                                                      </tbody>
   </table>