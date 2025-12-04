<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        <c:choose>
            <c:when test="${encontrada}">Receta: ${nombreReceta}</c:when>
            <c:otherwise>Receta no encontrada</c:otherwise>
        </c:choose>
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="container">
        <header>
            <h1> Explorador de Recetas</h1>
            <a href="${pageContext.request.contextPath}/recetas" class="btn-volver">← Volver a la lista</a>
        </header>
        
        <main>
            <c:choose>
                <c:when test="${encontrada}">
                    <h2 class="titulo-receta">
                        <c:out value="${nombreReceta}"/>
                    </h2>
                    
                    <div class="detalle-card">
                        <h3> Ingredientes:</h3>
                        <ul class="lista-ingredientes">
                            <c:forEach items="${ingredientes}" var="ingrediente">
                                <li><c:out value="${ingrediente}"/></li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:when>
                
                <c:otherwise>
                    <div class="mensaje-error">
                        <h2> Receta no encontrada</h2>
                        <p><c:out value="${mensaje}"/></p>
                        <a href="${pageContext.request.contextPath}/recetas" class="btn-principal">Ver todas las recetas</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </main>
        
        <footer>
            <p> Explorador de Recetas</p>
        </footer>
    </div>
</body>
</html>