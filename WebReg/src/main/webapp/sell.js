


function deleteRow(){
   console.log('deleting row...');
   var len=$('#dataAdd .container .form-row').length;
   if(len>1){
   $("#dataAdd .container .form-row").last().remove();
   }else{
   alert('Not able to Delete');
   }
}
function onSubmit(event){


}
window.onload = function() {

    var delbtn = document.getElementById("deleteRow");
    delbtn.onclick = deleteRow;

}