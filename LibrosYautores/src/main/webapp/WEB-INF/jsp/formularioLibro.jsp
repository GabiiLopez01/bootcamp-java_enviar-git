<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Agregar Libro</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Biblioteca Virtual</h1>
            <a href="<c:url value='/libros'/>" class="btn-volver">Volver a la lista</a>
        </header>
        
        <main>
            <div class="formulario-container">
                <h2> Agregar Nuevo Libro</h2>
                
                <form action="<c:url value='/procesa/libro'/>" method="post" class="formulario">
                    <div class="form-group">
                        <label for="nombreLibro"> Nombre del Libro:</label>
                        <input 
                            type="text" 
                            id="nombreLibro" 
                            name="nombreLibro" 
                            placeholder="Ej: Cien años de soledad"
                            required>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombreAutor"> Nombre del Autor:</label>
                        <input 
                            type="text" 
                            id="nombreAutor" 
                            name="nombreAutor" 
                            placeholder="Ej: Gabriel García Márquez"
                            required>
                    </div>
                    
                    <div class="form-botones">
                        <button type="submit" class="btn-submit">Agregar Libro</button>
                        <a href="<c:url value='/libros'/>" class="btn-cancelar">Cancelar</a>
                    </div>
                </form>
            </div>
        </main>
        
        <footer>
            <p>Libros y Autores</p>
        </footer>
    </div>
</body>
</html>