<!--Incorporacion Canciones y Artistas -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>🎤 Lista de Artistas</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Artistas Musicales</h1>
            <p class="subtitulo">Descubre a los artistas de nuestra colección</p>
        </header>
        
        <main>
            <h2> Lista de Artistas</h2>
            
            <div class="artistas-grid">
                <c:forEach items="${artistas}" var="artista">
                    <a href="<c:url value='/artistas/detalle/${artista.id}'/>" class="artista-card">
                        <div class="artista-icono"> </div>
                        <h3>
                            <c:out value="${artista.nombre} ${artista.apellido}"/>
                        </h3>
                        <p class="btn-ver-detalle">Ver Detalle →</p>
                    </a>
                </c:forEach>
            </div>
            
            <div class="botones-navegacion">
                <a href="<c:url value='/artistas/formulario/agregar'/>" class="btn-agregar-grande">
                     Agregar Nuevo Artista
                </a>
                
                <a href="<c:url value='/canciones'/>" class="btn-ir-canciones">
                     Ir a Canciones
                </a>
            </div>
        </main>
        
    </div>
</body>
</html>