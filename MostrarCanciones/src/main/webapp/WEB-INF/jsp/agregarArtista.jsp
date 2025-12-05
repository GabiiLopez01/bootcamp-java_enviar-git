<!--Incorporacion Canciones y Artistas -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Agregar Artista</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Artistas Musicales</h1>
            <a href="<c:url value='/artistas'/>" class="btn-volver"> Volver a lista de artistas</a>
        </header>
        
        <main>
            <div class="formulario-container">
                <h2> Agregar Nuevo Artista</h2>
                
                <form:form action="/artistas/procesa/agregar" method="post" modelAttribute="artista" class="formulario">
                    
                    <div class="form-group">
                        <form:label path="nombre"> Nombre:</form:label>
                        <form:input path="nombre" placeholder="Ej: Freddie" class="form-control"/>
                        <form:errors path="nombre" cssClass="error-mensaje"/>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="apellido"> Apellido:</form:label>
                        <form:input path="apellido" placeholder="Ej: Mercury" class="form-control"/>
                        <form:errors path="apellido" cssClass="error-mensaje"/>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="biografia"> Biografía:</form:label>
                        <form:textarea path="biografia" 
                                       placeholder="Escribe una breve biografía del artista..." 
                                       class="form-control form-textarea" 
                                       rows="5"/>
                        <form:errors path="biografia" cssClass="error-mensaje"/>
                    </div>
                    
                    <div class="form-botones">
                        <button type="submit" class="btn-submit">Agregar Artista</button>
                        <a href="<c:url value='/artistas'/>" class="btn-cancelar">Cancelar</a>
                    </div>
                </form:form>
            </div>
            
            <div style="text-align: center; margin-top: 20px;">
                <a href="<c:url value='/artistas'/>" class="btn-link">
                    Volver a lista de artistas
                </a>
            </div>
        </main>
        
    </div>
</body>
</html>
