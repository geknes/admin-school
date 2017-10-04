<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                   <!--  <th>Nombre Lengua</th> -->
                                                    <th width="140">B&aacute;sico</th>
                                                    <th width="140">Intermedio</th>
                                                    <th width="140">Avanzado</th>
                                                    <th width="70">Acci&oacute;n</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="lenguaEstructuraBean" items="${lstLenguaEstructuraBean}" varStatus="loop">
                                                <tr>
                                                    <td>${lenguaEstructuraBean.basico}</td>
                                                    <td>${lenguaEstructuraBean.intermedio}</td>
                                                    <td>${lenguaEstructuraBean.avanzado}</td>
                                                    <td>
                                                    
                                                    <button id="idBtnEditarLengua" type="button"
																						onclick="lenguaCargarModal()"
																						class="btn btn-outline-success btn-sm">
																						<i class="icon-pencil"></i>
																					</button>
                                                    </td>
                                                </tr>
                                                 </c:forEach>
                                               
                                            </tbody>
                                        </table>