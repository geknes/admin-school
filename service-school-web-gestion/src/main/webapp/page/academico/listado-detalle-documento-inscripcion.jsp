<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
							
 								 <table class="table table-striped table-bordered zero-configuration">
                                                <thead>

                                                    <tr>
                                               			<th width="10">Item</th>
                                                        <th width="20"># Docum.</th>
                                                        <th width="40">Nombre Archivo</th>
                                                        <th width="20">Descargar</th>
                                                        <th width="20">Acción</th>
                                                    </tr>

                                                </thead>
                                                <tbody id="idTablaDetalleDocumentoInscripcion" >
													<c:forEach var="documentoInscripcionBean" items="${lstDocumentoInscripcionBean}" varStatus="theCount">
									                      <tr>
									                      	  <td>${theCount.count}</td>
									                          <td>${documentoInscripcionBean.numedocu}</td>
									                          <td>${documentoInscripcionBean.nombdocu}</td>
									                          <td>
									                           <!--  <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Descargar" data-placement="top" data-toggle="tooltip" target="_Blank" href="${documentoInscripcionBean.rutadocu}" download="${documentoInscripcionBean.rutadocu}"><i class="fa fa-download"></i> Descargar</a>
									                          </td>
									                          <td>
									                           <!--  <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacionDetDocumentoInscripcion('${documentoInscripcionBean.codigo}','${documentoInscripcionBean.nombdocu}')"><i class="icon-trash"></i></a>
									                          </td>
									                      </tr>
									                  </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th width="10">Item</th>
                                                        <th width="20"># Docum.</th>
                                                        <th width="40">Nombre Archivo</th>
                                                        <th width="20">Descargar</th>
                                                        <th width="20">Acción</th>
                                                    </tr>
                                                </tfoot>
                                            </table>