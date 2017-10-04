function guardarArrastrar()
  {    
   var p_codmatpej       = $("#idEjercicio").val();
   /*var p_titulo      = "hola titulo";*/
   var p_titulo          = $("#tituloArrast").val().trim(); 
   var p_oracion         = $("#OracionTxtArea").val().trim();
   var id_ArrastraOraci  = $("#idArrasOra").val();  
   let url = "/procalidad-natigu-web-gestion/cargaMaterialController/grabarArrastraOracion"; 

    if (p_codmatpej!=null && p_codmatpej!='' && p_codmatpej!='0' ){  
    if (p_titulo!=null && p_titulo!='' && p_oracion!=null && p_oracion!=''){  
      $.ajax({
          type :  "POST",
          url  :  url,
          data : {p_codmatpej:  p_codmatpej,
            p_titulo:  p_titulo,
              p_oracion:    p_oracion, id_ArrastraOraci : id_ArrastraOraci },
            success : function(data)
              {
              habModi();
              msg_exito();
              $("#idArrasOra").val(data);
              
              },
              error : function()
              {
                alert("No se pudo ingresar el registro");
                console.log("ERROR: ");
              }
      }); 
    }else{
      msg_info("Debe completar todos los campos");
    }
  }else{
    msg_info("Debe Seleccionar un ejercicio ");
  }
     
  }

 



  function mostrarArrastrarxTEM(){ 

  habModi();
  limpiartab3Arras();
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/ListArrastOraxMaterialTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
              $("#OracionTxtArea").val(data.oracion);
              if (data.codigo!=null){
              $("#idArrasOra").val(data.codigo);
            }else{
               $("#idArrasOra").val("0");
            }
              $("#tituloArrast").val(data.titulo);
            
      }else{
        msg_advertencia("No hay registro.");
        $("#idArrasOra").val("0");
         alert("no hay registro");
      }     
        },
        error : function(request, status, error) {
          alert("error");
        }
       }); 
}


function guardarRespuestaArra()
  {
    var p_oraciondet   = $("#oracionxArrast").val().trim();   
   var p_numorden   = $("#inorden").val();
   var p_codoraxArrastrar  = $("#idoracionxArrast").val();  
   var p_codarrastraora     = $("#idArrasOra").val();
   

  
    if (p_codarrastraora!=null && p_codarrastraora!='' && p_codarrastraora!='0' ){  
  
    if (p_numorden!=null && p_numorden!='' && p_numorden!='0' && p_oraciondet!=null && p_oraciondet!=''){  
      let url = "/procalidad-natigu-web-gestion/cargaMaterialController/grabarRespuestaArrastraOraci"; 
      $.ajax({
          type :  "POST",
          url  :  url,
          data : {p_oraciondet:  p_oraciondet,
            p_numorden:  p_numorden,
              p_codoraxArrastrar:    p_codoraxArrastrar, p_codarrastraora : p_codarrastraora },
            success : function(data)
              {limpiartab3Arras();
              listadoRespxOracionGeneral();
              msg_exito();
              flagtab3Arras(true);
              $("#btn-guardar-respuesta").attr("disabled",true);
              },
              error : function()
              {
                alert("No se pudo ingresar el registro");
                console.log("ERROR: ");
              }
      }); 
    }else{
      msg_info("Debe completar todos los campos");
    }
  }else{
    msg_info("Debe seleccionar una oración");
  }
     
  }


 function listadoRespxOracionGeneral() 
{
  
 
  var p_codarrastraora    = $("#idArrasOra").val();
  var url =  "/procalidad-natigu-web-gestion/cargaMaterialController/ListRespuestasArrastrar";
  var html = "";
  $.ajax({
    type : 'POST',
    data :{p_codarrastraora : p_codarrastraora },
    url : url,
    success : function(data) 
    {
      console.log("SUCCESS arrastrar:  ", data);
      if (data != null) 
      {
        for (var i = 0; i < data.length; i++) 
        {
          html = html+"<tr> <td>"+(i+1)+"</td><td> Espacio "+data[i].orden+"</td> <td> <button type='button'  onclick='mostrarRespuestaArrasXcodigo(\""+data[i].codigo+ "\")'  class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button'  onclick='confirmar_eliminarArrastrar(\""+data[i].codigo+ "\")'   class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
        } 

        console.log(" idTablaArrastrarOracion :" + data );
        document.getElementById("idTablaArrastrarOracion").innerHTML=html;
      }else{
        return false;
      }
    },
    error : function(data) {
      console.log("error de idTablaArrastrarOracion :" + data+ error);
    }
  });
  
}

 


 
var codii =0;
    function confirmar_eliminarArrastrar(cod) { 
    codii   = cod;
   
    $('#md_confirmacion').modal('show'); 
  }

    $("#btnConfirmarGeneric").click(function() {
      if (codii != null  && codii != 0  ){
        eliminarrastrar(codii);
         }else{
          return false;
    }

  });

    function eliminarrastrar(codoraa){ 
          $.ajax({
            url : "/procalidad-natigu-web-gestion/cargaMaterialController/eliminarArrastrar?p_codoraxArrastrar="+codoraa,
            type : 'GET',
            success : function(data) {
              $('#md_confirmacion').modal('hide');
               listadoRespxOracionGeneral();
          
            },
            error : function(request, status, error) {
              alert(error);
            }
           });
          };




    function mostrarRespuestaArrasXcodigo(idrespuesta){ 
  var url =contextPath+"/cargaMaterialController/BuscarRespArrastrarxCodigo?p_codoraxarrastrar="+idrespuesta
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
           if (data != null) { 

             if (data.codigo!=null){
              $("#idoracionxArrast").val(data.codigo);
            }else{
               $("#idoracionxArrast").val("0");
            } 
           $("#inorden").val(data.orden); 
           $("#oracionxArrast").val(data.descripcion);
           flagtab3Arras(false);
           $("#btn-guardar-respuesta").attr("disabled",false);
     
      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          alert(error);
        }
       });
  
  
}

function limpiartab1Arras(){ 
  $("#idEjercicio").val("0"); 
  $("#ejercicioTxtTitulo").val(""); 
}

function limpiartab2Arras(){
  $("#tituloArrast").val("");
  $("#idArrasOra").val("0"); 
  $("#OracionTxtArea").val(""); 
}

function nuevoTab3Arras(){
	limpiartab3Arras();
	flagtab3Arras(false);
	$("#btn-guardar-respuesta").attr("disabled",false);
}

function limpiartab3Arras(){
  $("#inorden").val("");
  $("#idoracionxArrast").val("0"); 
  $("#oracionxArrast").val("");
  
}

function flagtab3Arras(flag){
	  $("#inorden").attr("disabled",flag);
	  $("#oracionxArrast").attr("disabled",flag);
	}

function habModi(){   
  $("#GuardarBtn").hide();
  $("#Modifbtn").show(); 
  $("#OracionTxtArea").prop('disabled', true);
  $("#tituloArrast").prop('disabled', true);
  //$("#OracionTxtArea").css("cursor","pointer");
  //$("#tituloArrast").css("cursor","pointer");
}
function desModi(){  
  var p_codej    = $("#idEjercicio").val();
  if (p_codej!='0'){
  $("#GuardarBtn").show();
  $("#Modifbtn").hide();
  $("#OracionTxtArea").removeAttr("disabled");
  $("#tituloArrast").removeAttr("disabled"); 
}else{
  msg_info("Debe seleccionar un ejercicio");
}
}

  