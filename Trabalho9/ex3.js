function lambert_pi(form){
    
    var n = prompt("Entre com a aproximacao desejada para o calculo de PI pelo metodo de Lambert:","5");
    
    if (n == "" || n == "null") {
        return;
    }
    
    if (n<0) {
        alert("Voce entrou com um numero menor que zero");
        return;
    }
    
    if (isNaN(parseFloat(n))) {
        alert("A entrada nao e numerica");
        return;
    }
    
    n = parseInt(n);

    var lamb_pi = 1;
    var aux1 = 0;
    for(var i = n;i>0;i--){
        lamb_pi = i*i/lamb_pi;
        aux1 = 2*i-1;
        lamb_pi+=aux1;
    }
    
    lamb_pi = 4/(lamb_pi);
    
    form.outputbox3.value = lamb_pi;
}

