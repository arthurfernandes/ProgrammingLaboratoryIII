<%-- 
    Document   : index.jsp
   ed on : May 4, 2014, 5:00:58 PM
    Author     : arthurfernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/jsp/error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,l-scale=1.0">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/header.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.js"></script>
        <title>Cinemark</title>
    </head>
    <body>
        <header>
            <%@include file="jsp/header.jspf" %>
            
        </header>
        
        <form action="/Cinemark/index" method="post">
            <section id="main">
                <div class="panel-body bodyIndex container center-block">
                    <figure>
                        <img src="img/filme-cartaz.jpg" class="img-responsive" alt="Filme em Cartaz">
                    </figure>
                    <div>
                        <button type="submit" name="logica" value="ExibeTodosOsFilmesLogica" class="btn btn-large">Estréias</button>
                        <button type="submit" name="logica" value="ExibeTodosOsFilmesLogica" class="btn btn-large">Filmes em Cartaz</button>
                        <button type="submit" name="logica" value="ExibeProximasAtracoesFilmesLogica" class="btn btn-large">Próximas Atrações</button>
                    </div>

                </div>
            </section>
        </form>
        <footer>
            <%@include file="jsp/footer.jspf" %>
        </footer>
    </body>
</html>
