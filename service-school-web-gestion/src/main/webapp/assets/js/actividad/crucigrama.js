/**
 * Mantenimeinto  Texto-Texto
 */
function guardarCrucigrama(){
	

	

	
	//codigo ejercicio
	var p_idEjercicio = $("#idEjercicio").val();
	//variables Actividad
	var p_palabra	= $("#idPalabraCrucigrama").val();
	var p_definicion= $("#idDefinicionCrucigrama").val();
	var p_orden =  $("#idCmbOrden").val();
	var p_orientacion =  $("#idCmbOrientacion").val();
	//codigo tabla relacion
	var p_idCrucigrama = $("#idRelacionCrucigrama").val();
	//codigo tabla relacioncab	
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	//codigo actividad modal
	var p_idMaterial	= $("#modalCboMaterial").val();
	
	
	alert(p_idEjercicio);
	var url = contextPath+"/cargaMaterialController/grabarCrucigrama";
	if(p_idMaterial != "0")
	{	

		var $myForm = $('#frmregistromodal');
		  if(!$myForm[0].checkValidity() || $("#idCmbOrden").val()=="0" || $("#idCmbOrientacion").val()=="0") {
		msg_advertencia("Debe completar los campos requeridos correctamente.");
		  }else{
		 
		
		$.ajax({
  			type 	: "POST",
  			data 	: { idEjercicio     :p_idEjercicio, 		
  						palabra	        : p_palabra,
  						definicion      :p_definicion,  						
  						orden			:p_orden,
  						orientacion 	:p_orientacion,  						
  						idCrucigrama	:p_idCrucigrama,
  						idRelacionCabecera:p_idRelacionCabecera,
  						idMaterial		:p_idMaterial},
		   url 	: url,
  			success : function(data)
  			{
  				if (data != "0") {
  	  				$("#idRelacionCrucigrama").val(data);  
  	  				listarEjercicioCrucigrama();
  	  				msg_exito();
				}
  				else
  				{
				}
  			},
  			error : function()
  			{
  				console.log("ERROR: ");
  			}
  		});
	  }
	}
	else
	{
		msg_advertencia("Debe seleccionar un Material.");
	
  }
}
function listarEjercicioCrucigrama()
{	

	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarCrucigrama";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			if (data!=null && data.length>0) 
			{
				for (var i = 0; i < data.length; i++) 
				{	
					var crucigrama = data[i];
					var orientacionPalabra ='';
					if (crucigrama.orientacion==1){
						orientacionPalabra = 'Ascendente';
					}else if(crucigrama.orientacion==2){
						orientacionPalabra = 'Descendente';
					}else{
						orientacionPalabra ='';
					}
					
					
					html = html+"<tr> <td>"+(i+1)+"</td><td>"
							+crucigrama.palabra+"</td><td>"+
							crucigrama.texto+"</td> <td>"+
							crucigrama.orden+"</td> <td>"+
							orientacionPalabra+"</td> <td>"+
							" <button type='button' onclick='editarCrucigrama(\""+
							crucigrama.codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'>"+
							"</i></button> <button type='button' onclick='confirmar_eliminar(\""+'crucigrama'+"\",\""+
							crucigrama.codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("bodyListeCrucigrama").innerHTML=html;
			}else{
				console.log("lista null");
			}
		},
		error : function(data) {
			console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function editarCrucigrama(p_id){
	alert(p_id);
	var url =contextPath+"/cargaMaterialController/objrelacionCrucigrama?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#idPalabraCrucigrama").val(data.palabra);
        			$("#idDefinicionCrucigrama").val(data.texto);
        			$("#idCmbOrden").val(data.orden);
        			$("#idCmbOrientacion").val(data.orientacion);
        			$("#idRelacionCrucigrama").val(data.codigo);
			}else{
				console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
	
	
}
var accion_tab = "";
var codigoEliminar="";
function confirmar_accion() {
	
	$('#md_confirmacion').modal('show');
}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}
$("#btnConfirmarGeneric").click(function() {
	
	if (accion_tab.indexOf("crucigrama") >= 0) {
		eliminarCrucigrama();
		accion_tab="";
	}

});
function confirmar_eliminar(tabla, codigo){
	console.log("entro a coonfirmar eliminar");
	
	console.log("tabla " +tabla);
	accion_tab = tabla;
	codigoEliminar = codigo;
	$('#md_confirmacion').modal('show');

}
function eliminarCrucigrama() {
	console.log("codigoEliminar" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarCrucigrama?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			listarEjercicioCrucigrama();
			msg_exito();

		},
		error : function(msg) {
			console.log("errot:" + msg);
		}

	});
}