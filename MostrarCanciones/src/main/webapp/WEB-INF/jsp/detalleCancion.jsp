<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Canción</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1>Biblioteca Musical</h1>
            <a href="<c:url value='/canciones'/>" class="btn-volver"> Volver a lista de canciones</a>
        </header>
        
        <main>
            <c:if test="${cancion != null}">
                <div class="detalle-cancion">
                    <h2> <c:out value="${cancion.titulo}"/></h2>
                    
                    <div class="info-cancion">
                        <div class="info-item">
                            <strong> Artista:</strong>
                            <p><c:out value="${cancion.artista}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Álbum:</strong>
                            <p><c:out value="${cancion.album}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Género:</strong>
                            <p><c:out value="${cancion.genero}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Idioma:</strong>
                            <p><c:out value="${cancion.idioma}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Fecha de Creación:</strong>
                            <p>
                                <fmt:formatDate value="${cancion.fechaCreacion}" pattern="dd/MM/yyyy HH:mm:ss"/>
                            </p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Última Actualización:</strong>
                            <p>
                                <fmt:formatDate value="${cancion.fechaActualizacion}" pattern="dd/MM/yyyy HH:mm:ss"/>
                            </p>
                        </div>
                    </div>
                    <!-- incorporación actividad Actualiza Cancion -->
                     <div class="botones-accion">
                        <a href="<c:url value='/canciones/formulario/editar/${cancion.id}'/>" class="btn-editar">
                            Editar Canción
                        </a>
                        <!-- incorporación actividad Elimin Cancion -->
                        <a href="<c:url value='/canciones/eliminar/${cancion.id}'/>" 
                           class="btn-eliminar"
                           onclick="return confirm('¿Estás seguro de que quieres eliminar esta canción?');">
                            Eliminar
                        </a> 
                        <a href="<c:url value='/canciones'/>" class="btn-principal">
                            Volver a lista de canciones
                        </a>
                    </div>
                </div>
            </c:if>

            <c:if test="${cancion == null}">
                <div class="mensaje-error">
                    <h2> Canción no encontrada</h2>
                    <p>La canción que buscas no existe en nuestra base de datos.</p>
                    <a href="<c:url value='/canciones'/>" class="btn-principal">Volver a lista de canciones</a>
                </div>
            </c:if>
        </main>
    </div>
</body>
</html>