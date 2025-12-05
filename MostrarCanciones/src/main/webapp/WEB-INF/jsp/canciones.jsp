<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Lista de Canciones</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1>Biblioteca Musical</h1>
            <p class="subtitulo">Explora nuestra colección de canciones</p>
            
        </header>
        
        <main>
            <h2>Lista de Canciones</h2>
            
            <table class="tabla-canciones">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Artista</th>
                        <th>Detalle</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${canciones}" var="cancion">
                        <tr>
                            <td><c:out value="${cancion.titulo}"/></td>
                            <td><c:out value="${cancion.artista}"/></td>
                            <td>
                                <a href="<c:url value='/canciones/detalle/${cancion.id}'/>" class="btn-detalle">
                                    Detalle
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
              <!-- incorporación actividad Agregar Canciones -->
            <div style="text-align: center; margin-top: 30px;">
                <a href="<c:url value='/canciones/formulario/agregar'/>" class="btn-agregar-grande">
                    Agregar Nueva Canción
                </a>
            </div>
        </main>
    </div>
</body>
</html>