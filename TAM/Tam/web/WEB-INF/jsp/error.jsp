<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         
         <title>Error...</title>
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
                <h4>Um erro ocorreu ao processar a sua requisição.</h4>
                <br>
                <a href="/Tam/index.html" class="btn btn-danger">
                    <h4>Retorne ao Menu Principal</h4>
                </a>


                </div>
        </section>
            
        
        
            
    </body>
</html>
