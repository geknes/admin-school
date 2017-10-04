<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<table class="table table-striped table-bordered zero-configuration">
                                                     <thead>
                                                          <tr>
                                                              <th>Lengua</th>
                                                              <th width="210">Fecha</th>                                                               
                                                              <th width="120">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idBodyListaInstLengua">
                                                      <c:forEach var="institucionLengua" items="${lstInstitucionLenguaBean}">
                                                          <tr>
                                                        	<td>${institucionLengua.lenguaBean.nombre}</td>
                                                        	<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${institucionLengua.fechaCreacion}" /></td>
                                                               <td class="text-sm-center">
                                                               <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" 
                                                               onclick="confirmar_eliminar('lengua',${institucionLengua.codigo});"><i class="icon-trash"></i></button>
                                                              <!--  <button type="button" class="btn btn-outline-danger btn-sm" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->  
                                                              </td>                                                             
                                                          </tr>
                                                          
                                                          </c:forEach>
                                                      </tbody>
   </table>