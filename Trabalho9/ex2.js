function fibonacci(form) {
    
    var n = prompt("Fibonacci: Digite o n-esimo termo:","5");
    
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
    
    
    var a1 = 0, a2 = 1, a3 = 1;
    for (var i = 1;i<n;i++) {
        a3 = a2+a1;
        a1 = a2;
        a2 = a3;
    }
    form.outputbox2.value = a3;
}
