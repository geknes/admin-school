  function msg_exito(){
  	toastr.success('&Eacute;xito al ejecutar proceso', '&Eacute;xito', {"progressBar": true});
  }
  function msg_error() {
  	toastr.error('Error al ejecutar proceso', 'Error', {"progressBar": true});
  }
  function msg_info(mensaje) {
  	toastr.info(mensaje, 'Informaci&oacute;n', {"progressBar": true});
  }
  function msg_advertencia(mensaje) {
  	toastr.warning(mensaje, 'Advertencia', {"progressBar": true});
  }

  function iniciarBloqueo(){
	  $.blockUI({
        message: '<div class="ft-refresh-cw icon-spin font-medium-2"></div>',
        fadeIn: 1000,
        overlayCSS: {
            backgroundColor: '#FFF',
            opacity: 0.8,
            cursor: 'wait'
        },
        css: {
            border: 0,
            padding: 0,
            color: '#333',
            backgroundColor: 'transparent'
        }
      });
  }
  
  function finBloqueo(){
	  $.unblockUI();
  }
  
  function nameImage(input, container){	  
	  $('#'+input).trigger('click');
	  $('input[id='+input+']').change(function() {
	  console.log($(this).val());
	      var mainValue = $(this).val();
	      if(mainValue == ""){
	    	  $('#'+container).hide().html('');
	      }else{
	    	  $('#'+container).show().html(mainValue.replace("C:\\fakepath\\", ""));
	      }
	  });	  
  }