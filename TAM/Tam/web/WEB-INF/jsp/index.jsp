<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         
         <title>Tam Airlines</title>
        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="resources/css/index.css" rel="stylesheet">
        
    </head>
    
    
    
    <body>
        <div id="wrapper"></div>
        
        <header>
            <%@ include file="header.jspf"%>
        </header>
        
        <section id="main">

            <div class="container panel-body formularioPrincipal">
                    <h1>Tam Airlines</h1>
                    <form action="rotas/menorcaminho.html">
                        <label>Origem</label>
                        <select name="origem" class="btn dropdown">
                            
                            <c:forEach items="${listaDeAeroportos}" var="aeroporto">
                                <c:choose>
                                    <c:when test="${aeroporto.id == 7}">
                                        <option value="${aeroporto.id}" selected>${aeroporto.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${aeroporto.id}">${aeroporto.nome}</option>
                                    </c:otherwise>
                                </c:choose>
                                 
                            </c:forEach>

                        </select>
                        <br>
                        <label>Destino</label>
                        <select name="destino" class="btn dropdown">
                            <c:forEach items="${listaDeAeroportos}" var="aeroporto">
                                    <c:choose>
                                    <c:when test="${aeroporto.id == 17}">
                                        <option value="${aeroporto.id}" selected>${aeroporto.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${aeroporto.id}">${aeroporto.nome}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                        </select>
                        <br>
                        <button class="btn btn-primary">Buscar</button> 

                    </form>


                </div>
        </section>
            
        
        
            
    </body>
</html>
