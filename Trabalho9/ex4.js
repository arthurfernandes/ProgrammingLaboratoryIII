function palindrome(form){
    var string1 = new String(prompt("Palindrome: Entre com a sua frase:","O romano acata amores a damas amadas e roma ataca o namoro"));
    
    if (string1 == "" || string1 == "null") {
        return;
    }
    
    string1 = string1.replace(/\s/g,'');
    string1 = string1.toUpperCase();
    
    var string2 = new String("");
    for(var i = (string1.length-1);i>=0;i--){
        string2 += string1.charAt(i);
    }
    
    if (string1 == string2) {
        form.outputbox4.value = "E Palindrome";
    }
    else{
        form.outputbox4.value = "Nao e palindrome...";
    }
    
    
}