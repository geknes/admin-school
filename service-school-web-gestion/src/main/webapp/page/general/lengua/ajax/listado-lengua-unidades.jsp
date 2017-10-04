 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
 
 <table
																	class="table table-striped table-bordered zero-configuration">
																	<thead>
																		<tr>
																			<!--  <th>Nombre Lengua</th> -->
																			<th>Nivel</th>
																			<th>Sub-Nivel</th>
																			<th>Unidad</th>
																			<th>Lecciones</th>
																			<th width="110">Acci&oacute;n</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="unidadBean" items="${lstUnidadBean}"
																			varStatus="loop">
																			<tr>
																				<td style="display: none">${unidadBean.lenguaEstructuraBean.nivel.codigoRegistro}</td>
																				<td>${unidadBean.lenguaEstructuraBean.nivel.nombreCorto}</td>
																				<td>${unidadBean.lenguaEstructuraBean.subNivel.nombreCorto}</td>
																				<td>${unidadBean.unidad.nombreCorto}</td>
																				<td>${unidadBean.nombreLecciones} </td>
																				<td>
																					<button id="idBtnBuscarLeccion" type="button"
																						onclick="lenguaCargarModalUnidadLeccion(${unidadBean.codigo})"
																						class="btn btn-outline-success btn-sm" title="Asignar Lecci&oacute;n" >
																						<i class="icon-plus"></i>
																					</button>
																					<button id="idBtnEditarUnidad" type="button"
																						onclick="modificarUnidad(${unidadBean.codigo})"
																						class="btn btn-outline-success btn-sm" title="Editar" >
																						<i class="icon-pencil"></i>
																					</button>
																					 <button type="button" class="btn btn-outline-danger btn-sm" 
																					 data-toggle="tooltip" data-placement="top" title="Eliminar" 
																					 		data-original-title="Eliminar" onclick="confirmar_accion(${unidadBean.codigo},'unidad');">
                                                          							<i class="icon-trash"></i>
                                                          							</button>
																				</td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
      <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>