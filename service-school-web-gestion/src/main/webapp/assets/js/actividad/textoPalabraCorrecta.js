function guardarOracion()
  {
    var p_titulo   = $("#idoraciontitulo").val();   
   var p_codmatpej   = $("#idEjercicio").val();
   var p_oracion     = $("#ejercicioTxtOracion").val();
   var p_codOracion  = $("#idoraciondesc").val(); 
   if (p_codmatpej!=null && p_codmatpej!='' && p_codmatpej!='0' ){  
	if (p_oracion!=null && p_oracion!='' && p_titulo!=null && p_titulo!=''){  

    /* alert(p_codleccion + "modalCboLeccion \n"+ "-titulo" +p_tituloejercicio+ "_"); */

     
      let url = "/procalidad-natigu-web-gestion/cargaMaterialController/grabarTextoPalabraCorrecta";
 
      $.ajax({
          type :  "POST",
          url  :  url,
          data : {	p_codmatpej:  p_codmatpej,
        	  		p_titulo:  p_titulo,
        	  		p_oracion:    p_oracion,
        	  		idOracionComple : p_codOracion 
        	  	 },
            success : function(data)
              {
              
              msg_exito();
              $("#idoraciondesc").val(data);
              },
              error : function()
              {
                alert("No se pudo ingresar el registro");
                console.log("ERROR: ");
              }
      });
      
	   }else{
	       msg_info("Debe completar los campos");
	    }
	  }else{
	      msg_info("Debe seleccionar un ejercicio");
	    }

     
  }









  function enviarOracionAlternativas(tipoaccion, arrayAlternativas){
    console.log("r: " + tipoaccion);
    let url = tipoaccion == 1 ? "/procalidad-natigu-web-gestion/cargaMaterialController/grabarPalabraCorrectaTexto" : "${pageContext.request.contextPath}/cargaMaterialController/actualizarOracionAlter";
    
    var cood   = $("#idoraciondesc").val();
    var cood1  = $("#rptaDescripcion0").val();
    var cood2  = $("#rptaDescripcion1").val();
    var cood3  = $("#rptaDescripcion2").val(); 
    var esp    = $("#idespacio").val(); 
    var inp1    = document.getElementById("0");
    var inp2    = document.getElementById("1");
    var inp3    = document.getElementById("2");
    if($(inp1).is(':checked')){
    inp1 = "1";
    } 
    if($(inp2).is(':checked')){
    inp2 = "1";
    } 
    if($(inp3).is(':checked')){
    inp3 = "1";
    }
    if (cood!=null && cood!='' && cood!='0' ){  
    if ((esp!=null && esp!='' && cood1!=null && cood1!='' && cood2!=null && cood2!=''
     && cood3!=null && cood3!='') && (inp1=='1' || inp2=='1' || inp3=='1') ) {  
  
    
    $.ajax({
         contentType: "application/json",
             type: "POST",
             data: JSON.stringify(arrayAlternativas),
             url: url,
             success: function(data)
             {  
                if ( document.getElementById("idalter0").value !=0
                  && document.getElementById("idalter1").value !=0
                  && document.getElementById("idalter2").value !=0 ) {
                
              console.log(data);
              }
              else { $("#idalter0").val(data-2);
                     $("#idalter1").val(data-1);
                     $("#idalter2").val(data); 


              }
               msg_exito();
               limpiarAlternativasOracion();
               $("#idespacio").attr("disabled",true);
               $("#rptaDescripcion0").attr("disabled",true);
               $("#rptaDescripcion1").attr("disabled",true);
               $("#rptaDescripcion2").attr("disabled",true);
               $("#btn_nuevo").attr("disabled",false);
               $("#btn-guardar-oracion").attr("disabled",true);
               
              console.log(data);
              listadoDeEspaciosxOracion();
             },
         error: function(er) {
           console.log(" er:" + er.error);console.log("er: " + er.responseText);

         }
           });
    }else{
        msg_info("Debe completar los campos");
     }
   }else{
       msg_info("Debe agregar una oración");
     }
  }


  var accionPregunta12 = 1;
  function agregarOracionAlternativa2(tipoaccion){
    var p_codoracion = $("#idoraciondesc").val();
    console.log("idoraciondesc: "+ p_codoracion);

    	
//    if (! $("input[name=rpst]").is(":checked") && ) {
//       msg_advertencia("Seleccione una respuesta predeterminada");
//        return false;
//     }

    
    if(p_codoracion != null || p_codoracion == ""){
      var arrayAlternativas   = [];
      var objPregunta = { codigo : p_codoracion};
      $("#tblPregunta tbody tr").each(function (index)
      {
        var objAlernativa = {
            codigo      : 0,  
            respuestaEstado : '0',
            descripcion   : '',
            oracionCompletarBean  : objPregunta,
            espacio : ""
              };
        input    = document.getElementById(index);
        if($(input).is(':checked')){
          objAlernativa.respuestaEstado = "1";
             }
        else
        {
          objAlernativa.respuestaEstado = "0";
        }

          


         tipoaccion == 1 ;
         objAlernativa.codigo= document.getElementById("idalter"+index).value;
        console.log("rpta: "+objAlernativa.codigo);
         console.log("index: "+index); 
        objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
        objAlernativa.espacio = document.getElementById("idespacio").value;
        console.log("asas" +  document.getElementById("idespacio").value);
        arrayAlternativas.push(objAlernativa);

      });
      enviarOracionAlternativas(tipoaccion,arrayAlternativas);

    }
    else{
      alert("No se pudo registrar las alternativas");
    }

  }



  function mostrarOracionxTEM(){
  
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/ListTextoPalabraCorrectaxMaterialTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
              $("#ejercicioTxtOracion").val(data.texto);
              if (data.codigo!=null){
              $("#idoraciondesc").val(data.codigo);
            }else{
               $("#idoraciondesc").val("0");
            }
              $("#idoraciontitulo").val(data.titulo);
            
      }else{
        msg_advertencia("No hay registro.");
        $("#idoraciondesc").val("0");
         alert("no hay registro");
      }     
        },
        error : function(request, status, error) {
          alert("error");
        }
       });
  
  
}



function mostrarAlternativasxidOraEspacio(id_ora,nespacio){
  
 
  var url =contextPath+"/cargaMaterialController/BuscarAlternativasxPalabraCorrectaTexto?p_codcomporacion="+id_ora+"&p_numespacio="+nespacio
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
              
               console.log("data" +  data); 
              $("#idespacio").val(nespacio);  
                for(var i=0;i<data.length;i++){
           $("#rptaDescripcion"+i).val(data[i].descripcion);
           $("#idalter"+i).val(data[i].codigo);

          var idrpta = i;
          var valrpta = data[i].respuestaEstado == 1 ? true : false;
          $("#"+ idrpta).prop('checked', valrpta);
         // $("#"+ idrpta).val(data[i].codigo);
            //console.log("Dato: "+ data[i].descripcion);
              //html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo + "\",\"" + data[i].descripcion +"\");' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
            }
 
              
                $("#btn-guardar-oracion").attr("disabled",false);


      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
  
  
}







 function listadoDeEspaciosxOracion()
{
  
 
  var p_oracion    = $("#idoraciondesc").val();
  var url =  "/procalidad-natigu-web-gestion/cargaMaterialController/ListEspacioxTextoPalabraCorrecta";
  var html = "";
  $.ajax({
    type : 'POST',
    data :{p_codtextopalabracorrec : p_oracion },
    url : url,
    success : function(data) 
    {
      console.log("SUCCESS: ", data);
      if (data != null) 
      {
        for (var i = 0; i < data.length; i++) 
        {
          html = html+"<tr> <td>"+(i+1)+"</td><td> "+data[i].palabraCorrecta+"</td> <td> <button type='button'  onclick='mostrarAlternativasxidOraEspacio(\""+data[i].textoPalabraCorrectaBean.codigo+ "\",\""+data[i].palabraCorrecta+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button'  onclick='confirmar_accionOraAlter(\""+data[i].textoPalabraCorrectaBean.codigo+ "\",\""+data[i].palabraCorrecta+ "\")' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
        }
        limpiarAlternativasOracion();
        document.getElementById("idTablaEspaciosListado27").innerHTML=html;
      }else{
        alert("lista null");
      }
    },
    error : function(data) {
      console.log("error de idTablaEspaciosListado27 :" + data+ error);
    }
  });
  
}


var numesp ="";
var codi =0;
    function confirmar_accionOraAlter(codora,espacio) {
    numesp = espacio;
    codi   = codora;
    $('#md_confirmacion').modal('show'); 
  }

    $("#btnConfirmarGeneric").click(function() {
      if (codi != null && numesp!=null && codi != 0 && numesp != 0){
        eliminarAlternatOra(codi,numesp);
      }else{
        return false;
        console.log(" yajuu no entro a el eliminar equivocado"  );
      }
    

  });

    function eliminarAlternatOra(codora,numesp){
        //  alert("eliminarLengua " + codigo);
          $.ajax({
            url : "/procalidad-natigu-web-gestion/cargaMaterialController/eliminarAlternativasTextoPalabraCorrecta?p_codcomporacion="+codora+"&p_numespacio="+numesp,
            type : 'GET',
            success : function(data) {
              $('#md_confirmacion').modal('hide');
              listadoDeEspaciosxOracion();
            },
            error : function(request, status, error) {
              alert(error);
            }
           });
          };




function nuevoAlternativasOracion(){
	 $("#idespacio").val("").attr("disabled",false);
     $("#idalter0").val("0");
     $("#idalter1").val("0");
     $("#idalter2").val("0");
     $("#rptaDescripcion0").val("").attr("disabled",false);
     $("#rptaDescripcion1").val("").attr("disabled",false);
     $("#rptaDescripcion2").val("").attr("disabled",false);
     $("#btn-guardar-oracion").attr("disabled",false);
}


function limpiarAlternativasOracion()

{
  $("#idespacio").val("");
  $("#idalter0").val("0");
  $("#idalter1").val("0");
  $("#idalter2").val("0");
  $("#rptaDescripcion0").val("");
  $("#rptaDescripcion1").val("");
  $("#rptaDescripcion2").val("");

  $("#0").attr('checked', false);
  $("#1").attr('checked', false);
  $("#2").attr('checked', false);
}


