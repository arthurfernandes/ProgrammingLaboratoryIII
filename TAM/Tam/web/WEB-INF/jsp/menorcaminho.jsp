<%-- 
    Document   : menorCaminho
    Created on : May 20, 2014, 9:30:50 AM
    Author     : arthurfernandes
--%>

<%@page import="br.eb.ime.labprog3.tam.Trecho"%>
<%@page import="br.eb.ime.labprog3.tam.Aeroporto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         
        <title>Tam Airlines</title>
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
        
    </head>

    <body>
        
        <div id="wrapper"></div>
        
        <header>
            <%@include file="header.jspf" %>
        </header>
        
        <section id="main">
           
                <div class="container panel-body formularioPrincipal center-block">
                    <h1>Tam Airlines</h1>
                    <div style="position:relative;">
                        <div class="origin">
                            <label class="subtitlesLabel">Origem</label><br>
                            <span class="btn btn-danger">${aeroportoOrigem.nome}</span>
                        </div>
                        
                        <div class="destiny">
                            <label class="subtitlesLabel">Destino</label><br>
                            <span class="btn btn-success">${aeroportoDestino.nome}</span>
                        </div>
                        
                    </div>
                            
                    <c:if test="${visibility == 2}">
                        <div class="table-responsive tabelaRotas">
                            <table class="table" >
                                <caption>Trechos</caption>
                                <thead>
                                    <tr>
                                        <th>Aeroporto Origem</th>
                                        <th>Aeroporto Destino</th>
                                        <th>Preco</th>
                               <th>Duracao</th>
                                        <th>Voo</th>
                                    </tr>
                                </thead>
                                <tbody>

                                        <c:forEach items="${listaDeTrechos}" var="trecho">
                                            <tr>
                                                <td>${trecho.aeroportoOrigemNome}</td>
                                                <td>${trecho.aeroportoDestinoNome}</td>
                                                <td>R$ ${trecho.preco}</td>
                                                <td>${trecho.duracao}</td>
                                                <td>${trecho.numeroVoo}</td>
                                            </tr>
                                         </c:forEach>

                                </tbody>
                            </table>

                        </div>

                    </c:if>
                    <c:if test="${visibility == 0}">
                        <div class="destiny">
                            <span class="subtitlesLabel"><strong>Não há como chegar a esse destino no momento.</strong></span><br>
                        </div>
                    </c:if>
                        
                    <c:if test="${visibility == 1}">
                        <div class="destiny">
                            <span class="subtitlesLabel"><strong>Você já se encontra no seu destino!</strong></span><br>
                        </div>
                    </c:if>
                    

                    
                </div>
            
            
        </section>
        
        
            
    </body>
</html>
