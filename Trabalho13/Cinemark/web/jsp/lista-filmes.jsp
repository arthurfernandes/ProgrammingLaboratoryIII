<%--
    Document   : lista-filmes
    Created on : May 2, 2014, 7:21:35 PM
    Author     : arthurfernandes
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.eb.ime.labprog3.cinemark.DocumentoXML"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cinemark"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,l-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href="css/header.css" rel="stylesheet">
        <link href="css/filmes.css" rel="stylesheet">
        
        <title>Filmes Cinemark</title>
    </head>
    <body>
        <header>  
            <%@include file="header.jspf" %>
        </header>
        
        <section id="main">
            <form action="/Cinemark/index" method="post">
                <div class="container panel-body"> 
                    <table>
                        
                        <tbody>
                            
                            
                                <tr>
                                    <jsp:useBean class="br.eb.ime.labprog3.cinemark.FilmeDAO" id="dao">
                                    <% dao.setDocumentoXML((DocumentoXML)application.getAttribute("DocumentoXMLFilmes")); %>
                                    <c:forEach items="${dao.todosOsFilmes}" var="filme">
                                        <%@include file="filmes.jspf" %>


                                    </c:forEach>

                                </jsp:useBean>
                                </tr>

                        </tbody>
                    </table>
                </div>
                
                
            </form>
            
        </section>
        
        <footer> </footer>
    </body>
</html>
