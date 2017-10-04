   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>      
   
    <!-- Modal -->
    <div class="modal fade text-xs-left" id="alumno-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Alumno</b></label>
        </div>
        <form onsubmit="return false">
        <div class="modal-body">
          <div class="row">
            <div class="col-md-8 mb-2">
                <label>Nombre alumno</label>
                <input type="text" class="form-control" name="nomAlum" id="nomAlum">
            </div>

              <div class="form-group col-md-4 text-right">
                  <button type="button" class="btn btn-default mt-2" onclick="listarAlumnoxInstitucionmodal()">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div>

          <div class="row">
            <div class="col-xs-12" id="listadoalumModalview">
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
            </div>
          </div>

        </div>
       
        </form>
         <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
        </div>
      </div>
      </div>
    </div>
