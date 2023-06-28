/**
 * Confirmação de exclusão de um contato
 */

 function confirmar(idcon){
	 let resposta = confirm("Confirmar a esclusão deste contato ?")
	 if (resposta === true){
		 //alert(idcon)
		 window.location.href = "delete?idcon=" + idcon
	 }
 }