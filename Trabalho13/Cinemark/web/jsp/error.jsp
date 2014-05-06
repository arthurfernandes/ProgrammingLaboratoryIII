<%-- 
    Document   : error.jsp
    Created on : May 4, 2014, 7:13:18 PM
    Author     : arthurfernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,l-scale=1.0">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet">
        <title>Erro Encontrado</title>
    </head>
    <body>
        <header>
            <%@include  file="header.jspf" %>
        </header>
        <form action="/Cinemark/index" method="post">
            <section id="main">
                <div class="panel-body bodyIndex container">
                    <figure>
                        <img src="${pageContext.request.contextPath}/img/filme-cartaz.jpg" class="img-responsive" alt="Filme em Cartaz">
                    </figure>
                   <div class="errorInfo">
                       <span>Um erro ocorreu ao processar sua solicitação.</span><br>
                       <a href="/Cinemark/index" class=" btn-default">Retorne ao Menu Principal</a>
                    </div>
                </div>
                
            </section>
        </form>
    </body>
</html>
