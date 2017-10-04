/**
 * 
 */

function cargarNivelesInsc(){
	var idLengua = $('#lblLenguamodal').val();
	var contextPath = $('#contextPathUrl').val();

	var html = "";
	
	if(idLengua!='0'){
		$.ajax({
			type: "GET",
			data: "codlengua="+idLengua,
		 	url: contextPath+"/inscripcionController/cargarNivelesIns",
		 success: function(data)
      {		
			
 	    	if(data!=null){
 	    		
 	    		data.sort(function (a, b){
 	    		    return (a.codigoRegistro - b.codigoRegistro);
 	    		});
 	    		
 	    		html+="<option value=''>Todos</option>";
 	    		for(var i=0; i<data.length;i++){
 	    			html+="<option value='"+data[i].codigoRegistro+"'>"+data[i].nombreCorto+"</option>";
				}
 	    	}else{
 	    		html+="<option value=''>Todos</option>";
 	    	}
 	    	
      },
		   error: function(xhr,status,er) {
			   console.log("error: " + xhr + " status: " + status + " er:" + er);
			   if(xhr.status==500) {
				   console.log(er);
			 //    Error_500(er);
			   }
			   if(xhr.status==901) {
				   console.log(er);
		    //	   spire_session_901(er);
		   }
		   },
		   complete: function(){
			   $('#cmm_nivel').empty();
			   $('#cmm_nivel').html(html);
		   }
    });
}else{
	html = "<option value='0'>Todos</option>";
	$('#cmm_nivel').empty();
	$('#cmm_nivel').html(html);
	
}
	
}