function cifra_vigenere(form){
    var cifra = new String(form.inputboxcifer7.value);
    
    if (cifra == "" || cifra == "null") {
        alert("Cifra nao pode ser nula!");
        return;
    }
    
    var mensagem = new String(form.outputbox7.value);
    
    if (mensagem == "" || mensagem == "null") {
        alert("Mensagem Vazia");
        return;
    }
    
    mensagem = mensagem.toUpperCase();
    mensagem = mensagem.replace(/\s/g,'');
    cifra = cifra.toUpperCase();
    
    if (mensagem.length > cifra.length) {
        var distance = mensagem.length - cifra.length;
        for(var i = 0;i<distance;i++){
            cifra+=cifra.charAt(i);
        }
    }
    

    var codigo = new String("");
    for(var i = 0;i<mensagem.length;i++){
        codigo += String.fromCharCode((mensagem.charCodeAt(i) - "A".charCodeAt(0) + cifra.charCodeAt(i) - "A".charCodeAt(0))%26 + "A".charCodeAt(0));
    }
    
    form.outputbox7.value = codigo;

}

function decifra_vigenere(form){
    var cifra = new String(form.inputboxcifer7.value);
    
    if (cifra == "" || cifra == "null") {
        alert("Cifra nao pode ser nula!");
        return;
    }
    
    var mensagem = new String(form.outputbox7.value);
    
    if (mensagem == "" || mensagem == "null") {
        alert("Mensagem Vazia");
        return;
    }
    
    if (mensagem.length > cifra.length) {
        var distance = mensagem.length - cifra.length;
        for(var i = 0;i<distance;i++){
            cifra+=cifra.charAt(i);
        }
    }
    
    mensagem = mensagem.toUpperCase();
    //mensagem = mensagem.replace(/\s/g,'');
    cifra = cifra.toUpperCase();

    var codigo = new String("");
    for(var i = 0;i<mensagem.length;i++){
        codigo += String.fromCharCode((mensagem.charCodeAt(i) - "A".charCodeAt(0) -(cifra.charCodeAt(i) - "A".charCodeAt(0)) + 26)%26 + "A".charCodeAt(0));
    }
    
    form.outputbox7.value = codigo;

}