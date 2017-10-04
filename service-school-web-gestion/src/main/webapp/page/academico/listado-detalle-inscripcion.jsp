<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
							
 								<table class="table table-striped table-bordered zero-configuration">
								                  <thead>
								                      <tr>
								                      	  <th>Item</th>
								                          <th>Lengua</th>
								                          <th width="250">N&uacute;mero de Cupos</th>
								                          <th width="150">Acci&oacute;n</th>
								                      </tr>
								                  </thead>
								                  <tbody>
								                  <c:forEach var="inscripcionLenguaBean" items="${lstInscripcionLenguaBean}" varStatus="theCount">
								                      <tr>
								                      	  <td>${theCount.count}</td>
								                          <td>${inscripcionLenguaBean.lenguainscr.nombre}</td>
								                          <td>${inscripcionLenguaBean.numeroCuposInsc}</td>
								                            <td>
                                                           <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" onclick="modificarLengua(${inscripcionLenguaBean.codigo})"><i class="icon-pencil"></i></a>
                                                         <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarLengua(${inscripcionLenguaBean.codigo})"><i class="icon-trash"></i></a>
                                                           <!--    ******************   -->
                                                         <a title="Asignar Docente" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="activarAsignarDocente(${inscripcionLenguaBean.codigo} , ${inscripcionLenguaBean.institucion.codigo},'${inscripcionLenguaBean.lenguainscr.nombre}');"><i class="icon-arrow-right"></i></a>
                                                       <!--    ******************   -->
                                                       
                                                        </td>
								                      </tr>
								                      </c:forEach>
								                     
								                    
								
								                  </tbody>
								              </table>