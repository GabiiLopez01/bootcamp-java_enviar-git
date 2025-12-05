<!-- incorporación actividad Agregar Canciones -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Agregar Canción</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Biblioteca Musical</h1>
            <a href="<c:url value='/canciones'/>" class="btn-volver"> Volver a lista de canciones</a>
        </header>
        
        <main>
            <div class="formulario-container">
                <h2> Agregar Nueva Canción</h2>
                
                <form:form action="/canciones/procesa/agregar" method="post" modelAttribute="cancion" class="formulario">
                    
                    <div class="form-group">
                        <form:label path="titulo">Título:</form:label>
                        <form:input path="titulo" placeholder="Ej: Bohemian Rhapsody" class="form-control"/>
                        <form:errors path="titulo" cssClass="error-mensaje"/>
                    </div>
                    
                    <!-- Incorporacion Canciones y Artistas -->
                    <div class="form-group">
                        <label for="artistaId"> Artista:</label>
                        <select name="artistaId" id="artistaId" class="form-control" required>
                            <option value="">-- Selecciona un artista --</option>
                            <c:forEach items="${artistas}" var="artista">
                                <option value="${artista.id}">
                                    <c:out value="${artista.nombre} ${artista.apellido}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="album">Álbum:</form:label>
                        <form:input path="album" placeholder="Ej: A Night at the Opera" class="form-control"/>
                        <form:errors path="album" cssClass="error-mensaje"/>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="genero">Género:</form:label>
                        <form:input path="genero" placeholder="Ej: Rock" class="form-control"/>
                        <form:errors path="genero" cssClass="error-mensaje"/>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="idioma">Idioma:</form:label>
                        <form:input path="idioma" placeholder="Ej: Inglés" class="form-control"/>
                        <form:errors path="idioma" cssClass="error-mensaje"/>
                    </div>
                    
                    <div class="form-botones">
                        <button type="submit" class="btn-submit">Agregar Canción</button>
                        <a href="<c:url value='/canciones'/>" class="btn-cancelar">Cancelar</a>
                    </div>
                </form:form>
            </div>
            
            <div style="text-align: center; margin-top: 20px;">
                <a href="<c:url value='/canciones'/>" class="btn-link">
                    Volver a lista de canciones
                </a>
            </div>
        </main>
    </div>
</body>
</html>
