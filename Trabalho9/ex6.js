function cifra_cesar(form){
    
    var cifra = new String(form.inputboxcifer6.value);
    
    if (cifra == "" || cifra == "null") {
        alert("Cifra nao pode ser nula!");
        return;
    }
    
    if (cifra.length>1) {
        alert("Sua cifra deve conter apenas um caractere !");
        return;
    }
    
    var mensagem = new String(form.outputbox6.value);
    
    if (mensagem == "" || mensagem == "null") {
        alert("Mensagem Vazia");
        return;
    }
    
    mensagem = mensagem.toUpperCase();
    mensagem = mensagem.replace(/\s/g,'');
    cifra = cifra.toUpperCase();
    
    var deslocamento = cifra.charCodeAt(0) - "A".charCodeAt(0);
    
    var codigo = new String("");
    for(var i = 0;i<mensagem.length;i++){
        codigo += String.fromCharCode((mensagem.charCodeAt(i) - "A".charCodeAt(0) +deslocamento)%26 + "A".charCodeAt(0));
    }
    
    form.outputbox6.value = codigo;
}

function decifra_cesar(form){
    var cifra = new String(form.inputboxcifer6.value);
    
    if (cifra == "" || cifra == "null") {
        alert("Cifra nao pode ser nula!");
        return;
    }
    
    if (cifra.length>1) {
        alert("Sua cifra deve conter apenas um caractere !");
        return;
    }
    
    var mensagem = new String(form.outputbox6.value);
    
    if (mensagem == "" || mensagem == "null") {
        alert("Mensagem Vazia");
        return;
    }
    
    
    mensagem = mensagem.toUpperCase();
    mensagem = mensagem.replace(/\s/g,'');
    cifra = cifra.toUpperCase();
    
    var deslocamento = cifra.charCodeAt(0) - "A".charCodeAt(0);
    var codigo = new String("");
    for(var i = 0;i<mensagem.length;i++){
        codigo += String.fromCharCode((mensagem.charCodeAt(i) - "A".charCodeAt(0) -deslocamento + 26)%26 + "A".charCodeAt(0));
    }
    
    form.outputbox6.value = codigo;
}