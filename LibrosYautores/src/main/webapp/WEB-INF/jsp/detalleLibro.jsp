<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Detalle del Libro</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Biblioteca Virtual</h1>
            <a href="<c:url value='/libros'/>" class="btn-volver"> Volver a la lista</a>
        </header>
        
        <main>
            <c:choose>
                <c:when test="${encontrado}">
                    <div class="detalle-libro">
                        <h2> <c:out value="${nombreLibro}"/></h2>
                        <div class="info-autor">
                            <p><strong> Autor:</strong></p>
                            <p class="nombre-autor"><c:out value="${nombreAutor}"/></p>
                        </div>
                    </div>
                </c:when>
                
                <c:otherwise>
                    <div class="mensaje-error">
                        <h2> Libro no encontrado</h2>
                        <p>El libro no se encuentra en nuestra lista.</p>
                        <a href="<c:url value='/libros'/>" class="btn-principal">Ver todos los libros</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </main>
        
        <footer>
            <p> Libros y Autores</p>
        </footer>
    </div>
</body>
</html>
