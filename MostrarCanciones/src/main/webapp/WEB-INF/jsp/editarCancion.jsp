<!-- incorporación actividad Actualizar Cancion -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Canción</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1>Biblioteca Musical</h1>
            <a href="<c:url value='/canciones'/>" class="btn-volver"> Volver a lista de canciones</a>
        </header>
        <main>
            <div class="formulario-container">
                <h2> Editar Canción: <c:out value="${cancion.titulo}"/></h2>
                
                <form:form action="/canciones/procesa/editar/${cancion.id}" method="post" modelAttribute="cancion" class="formulario">

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
                                <option value="${artista.id}" 
                                        <c:if test="${cancion.artista.id == artista.id}">selected</c:if>>
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
                    
                    <form:hidden path="id" />
                    
                    <div class="form-botones">
                        <button type="submit" class="btn-submit">Guardar Cambios</button>
                        <a href="<c:url value='/canciones/detalle/${cancion.id}'/>" class="btn-cancelar">Cancelar Edición</a>
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