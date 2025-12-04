<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Explorador de Recetas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="container">
        <header>
            <h1> Explorador de Recetas</h1>
            <p class="subtitulo">Descubre deliciosas recetas para cocinar</p>
        </header>
        
        <main>
            <h2> Lista de Recetas Disponibles</h2>
            
            <div class="recetas-grid">
                <c:forEach items="${listaRecetas}" var="receta">
                    <div class="receta-card">
                        <div class="receta-icono"></div>
                        <h3><c:out value="${receta}"/></h3>
                        <a href="${pageContext.request.contextPath}/recetas/${receta}" class="btn-ver-receta">
                            Ver Receta →
                        </a>
                    </div>
                </c:forEach>
            </div>
        </main>
        
        <footer>
            <p> Explorador de Recetas</p>
        </footer>
    </div>
</body>
</html>
