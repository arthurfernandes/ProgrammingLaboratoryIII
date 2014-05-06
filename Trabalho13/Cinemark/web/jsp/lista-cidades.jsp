<%-- 
    Document   : index.jsp
   ed on : May 4, 2014, 5:00:58 PM
    Author     : arthurfernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,l-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href="css/header.css" rel="stylesheet">
        <link href="css/filmes.css" rel="stylesheet">
        <link href="css/cinemas.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/js/jquery.js" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/js/cidades.js" rel="stylesheet">
        <link href="js/cidade.js" type="text/javascript">
        
        <title>Cinemark Cinemas</title>
    </head>
    <body>
        <header>
            <%@include file="header.jspf" %>
            
        </header>
        
        <form action="/Cinemark/index" id="actionForm" method="post">
            <section id="main">
                <div class="panel-body bodyIndex container">
                    <div class="cidadesSelect">
                        <span class="cidadesTitle">Escolha uma Cidade:</span><br>
                            <%@include file="selectCidades.jspf" %>
                            <input type="hidden" name="logica" value="ExibeTodosOsCinemasLogica">
                            <button type="submit" class="btn btn-default">Busca</button>
                    </div>
                    <div class="cidadesImg">
                        <figure>
                            <img src="img/filme-cartaz.jpg" class="img-responsive" alt="Filme em Cartaz">
                        </figure>
                    </div>
                    
                    
                </div>
            </section>
        </form>
        
        <footer>
            <%@include file="footer.jspf" %>
        </footer>
    </body>
</html>
