<!--Incorporacion Canciones y Artistas -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Detalle del Artista</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1> Artistas Musicales</h1>
            <a href="<c:url value='/artistas'/>" class="btn-volver"> Volver a lista de artistas</a>
        </header>
        
        <main>
            <c:if test="${artista != null}">
                <div class="detalle-artista">
                    <h2> <c:out value="${artista.nombre} ${artista.apellido}"/></h2>
                    
                    <div class="info-artista">
                        <div class="info-item">
                            <strong> Nombre:</strong>
                            <p><c:out value="${artista.nombre}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Apellido:</strong>
                            <p><c:out value="${artista.apellido}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Biografía:</strong>
                            <p><c:out value="${artista.biografia}"/></p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Fecha de Creación:</strong>
                            <p>
                                <fmt:formatDate value="${artista.fechaCreacion}" pattern="dd/MM/yyyy HH:mm:ss"/>
                            </p>
                        </div>
                        
                        <div class="info-item">
                            <strong> Última Actualización:</strong>
                            <p>
                                <fmt:formatDate value="${artista.fechaActualizacion}" pattern="dd/MM/yyyy HH:mm:ss"/>
                            </p>
                        </div>
                    </div>
                    
                    <!-- LISTA DE CANCIONES DEL ARTISTA -->
                    <div class="canciones-artista">
                        <h3> Canciones de este Artista</h3>
                        
                        <c:choose>
                            <c:when test="${not empty artista.canciones}">
                                <ul class="lista-canciones-artista">
                                    <c:forEach items="${artista.canciones}" var="cancion">
                                        <li>
                                            <a href="<c:url value='/canciones/detalle/${cancion.id}'/>">
                                                 <c:out value="${cancion.titulo}"/> 
                                                (<c:out value="${cancion.genero}"/>)
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <p class="sin-canciones">Este artista aún no tiene canciones registradas.</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    
                    <div style="text-align: center; margin-top: 30px;">
                        <a href="<c:url value='/artistas'/>" class="btn-principal">
                            Volver a lista de artistas
                        </a>
                    </div>
                </div>
            </c:if>
            
            <c:if test="${artista == null}">
                <div class="mensaje-error">
                    <h2> Artista no encontrado</h2>
                    <p>El artista que buscas no existe en nuestra base de datos.</p>
                    <a href="<c:url value='/artistas'/>" class="btn-principal">Volver a lista de artistas</a>
                </div>
            </c:if>
        </main>
    </div>
</body>
</html>