
function fatorial(form){
    var i = 1, fat = 1;
    var n = prompt("Entre com n",5);
    
    if (n == "" || n == "null") {
	return;
    }
    
    if (n<0) {
	alert("Voce entrou com um numero negativo");
	return;
    }
    
    if (isNaN(parseFloat(n))) {
        alert("A entrada nao e numerica");
        return;
    }
    
    n = parseInt(n);
    
    for(i = 1;i<=n;i++){
	fat*=i;
    }
    form.outputbox1.value = fat;
}
