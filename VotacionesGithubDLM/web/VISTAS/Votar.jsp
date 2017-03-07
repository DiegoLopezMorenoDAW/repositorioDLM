<%-- 
    Document   : Votar
    Created on : 21-dic-2015, 12:03:52
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedor">
            <%
                int sesvoto = Integer.parseInt(session.getAttribute("votar").toString());
                if (sesvoto == 1) {
                    String partido = session.getAttribute("partido").toString();
            %>
            <h1>Gracias, has votado a <%out.print(partido);%></h1>
            <button value="volver" id="volver" onclick="location.href = '../index.html'">Volver</button>
            <%
            } else if (sesvoto == 2) {
            %>
            <h1>Selecciona un partido</h1>
            <button value="volver" id="volver" onclick="location.href = 'Votacion.jsp'">Volver</button>
            <%
            } else {
            %>
            <h1>Error</h1>
            <button value="volver" id="volver" onclick="location.href = '../index.html'">Volver</button>
            <%
                }
            %>
        </div>
    </body>
</html>
