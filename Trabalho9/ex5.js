function maiuscula_minuscula(form){
    
    var string1 = new String(prompt("Trocar maiusculas por minusculas: Entre com a sua frase","Troque as LeTrAs."));
    
    if (string1 == "" || string1 == "null") {
        return;
    }
    
    var stringUpper = string1.toUpperCase();
    var string2 = new String("");
    for(var i = 0;i<string1.length;i++){
        var char1 = string1.charAt(i);
        if (char1 != stringUpper.charAt(i)) {
            //LowerCase
            string2 += char1.toUpperCase();
        }
        else{
            //UpperCase
            string2 += char1.toLowerCase();
        }
        
    }
    
    form.outputbox5.value = string2;
}