  function valida(e){
    tecla = (document.all) ? e.keyCode : e.which; 
    if (tecla==8){
        return true;
    } 
    patron =/[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
} 

    function validar_file(fileid,imgid,imgsrc,idcodigo){
    var fileInput = document.getElementById(fileid);
    var filePath  = fileInput.value;
    var allowedExtensions = /(.jpg|.jpeg|.png|.gif)$/i;
    var extensionvacia    = /()$/i;
    if(allowedExtensions.exec(filePath)){
      if (fileInput.files && fileInput.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) { 
          $('#'+imgid).attr('src',''+e.target.result+''); 
            };
            reader.readAsDataURL(fileInput.files[0]);
           } 
          }else{ 
              if(extensionvacia.exec(filePath) && (filePath=='')) {
               limpiar_img(imgid,imgsrc,idcodigo);  
               return false;  
                 } else {
                     msg_info("extensión no válida");
                     fileInput.value = '';
                     limpiar_img(imgid,imgsrc,idcodigo);
                     return false; 
    }
  } 
}
     
function abrir_input(idinput)
{
   document.getElementById(idinput).click();
} 
  
    function limpiar_img(imgid,imgsrc,idcodigo){ 
      if (document.getElementById(idcodigo).value==null || document.getElementById(idcodigo).value=='0') {
      $('#'+imgid).attr('src','../assets/img/usar_imagen.jpg');
      }else { $('#'+imgid).attr('src',imgsrc);   

      } 
    }
