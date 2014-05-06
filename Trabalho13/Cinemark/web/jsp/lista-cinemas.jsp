<%--
    Document   : lista-filmes
    Created on : May 2, 2014, 7:21:35 PM
    Author     : arthurfernandes
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.eb.ime.labprog3.cinemark.Cinema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.eb.ime.labprog3.cinemark.DocumentoXML"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="cinemark"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,l-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href="css/header.css" rel="stylesheet">
        <link href="css/filmes.css" rel="stylesheet">
        
        <title>Cinemas da Cidade de </title>
    </head>
    <body>
        <header>  
            <%@include file="header.jspf" %>
        </header>
        
        <section id="main">
            <form action="/Cinemark/index" method="post">
                <div class="container panel-body cinemaContainer"> 
                    <table>
                        
                        <tbody>
                            
                            
                                <tr>
                                    <jsp:useBean class="br.eb.ime.labprog3.cinemark.CinemaDAO" id="dao">
                                    <% dao.setDocumentoXML((DocumentoXML)application.getAttribute("DocumentoXMLCinemas")); %>
                                    <% ArrayList<Cinema> cinemas = (ArrayList<Cinema>)dao.getTodosOsCinemas();
                                        for(Cinema cinema : cinemas){
                                            if(Integer.parseInt((String)request.getParameter("todasAsCidades")) == cinema.getCidade().getCidadeId()){
                                    %>
                                        <div class="cinema">
                                            <figure>
                                               <img src="http://cinemark.com.br/mobile/images/maps.png">
                                            </figure>
                                            <div class="cinemaCaption">
                                                <span><%= cinema.getNome()%></span><br>
                                                <span>Número de Salas: <%= cinema.getNumeroSalas() %></span><br>
                                                <span><%= cinema.getEndereco() %></span>
                                            </div>

                                        </div>
                                    <% }} %>    

                                    

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
