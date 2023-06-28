/**
 * Validação de formulários
 */

 function validar(){
	 let nome = frmContato.nome.value
	 let valor = frmContato.valor.value
	 let quantidade = frmContato.quantidade.value
	 if (nome === "") {
		 alert('Preencha o campo Nome')
		 frmContato.nome.focus()
		 return false
	 }else if (valor === ""){
		 alert('Preencha o campo valor')
		 frmContato.valor.focus()
		 return false
	 }else if (quantidade === ""){
		 alert('Preencha o campo quantidade')
		 frmContato.quantidade.focus()
		 return false
	 } else{
		 document.forms["frmContato"].submit()
	 }
 }