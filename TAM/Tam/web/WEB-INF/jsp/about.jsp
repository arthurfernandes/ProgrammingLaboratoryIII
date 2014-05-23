<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         
         <title>Tam Airlines</title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
        
    </head>
    
    
    
    <body>
        <div id="wrapper"></div>
        
        <header>
            <%@ include file="header.jspf"%>
        </header>
        
        <section id="main">

            <div class="container panel-body formularioPrincipal">
                <h1>Tam Airlines</h1><br>
                <h4>Descrição</h4>
                <br>
                <h5>Esse programa tem por objetivo utilizar o algoritmo de Dijkstra para calcular as rotas com menor preço
                para viajar de um aeroporto a outro. Os aeroportos e trechos disponíveis foram retirados do site da TAM no dia 20 de Maio de 2014
                para viagens no dia 30 de maio de 2014.</h5>
                <div class="destiny">
                    
                    <p><strong>Grupo:</strong></p>
                    <p><strong>Arthur Fernandes Araujo</strong></p>
                    <p><strong>Maiara Barroso Cardoso Reinaldo</strong></p>
                    <p><strong>Carlos Henrique Pimentel Paiva</strong></p>
                </div>
                
                </div>
        </section>
            
        
        
            
    </body>
</html>
