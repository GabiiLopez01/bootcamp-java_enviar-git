<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Libros</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Biblioteca Virtual</h1>
            <p class="subtitulo">Explora la colección de libros</p>
        </header>
        
        <main>
            <div class="acciones">
                <h2>Lista de Libros</h2>
                <a href="<c:url value='/libros/formulario'/>" class="btn-agregar">+ Agregar Nuevo Libro</a>
            </div>
            
            <ul class="lista-libros">
                <c:forEach items="${listaLibros}" var="libro">
                    <li>
                        <a href="<c:url value='/libros/${libro.key}'/>">
                            <c:out value="${libro.key}"/>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </main>
        
        <footer>
            <p> Libros y Autores</p>
        </footer>
    </div>
</body>
</html>