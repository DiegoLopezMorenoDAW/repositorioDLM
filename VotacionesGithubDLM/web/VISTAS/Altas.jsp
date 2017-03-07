<%-- 
    Document   : Altas
    Created on : 16-dic-2015, 20:52:08
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
                int sesaltas = Integer.parseInt(session.getAttribute("altas").toString());
                if (sesaltas == 1) {
            %>
            <h1>Votante añadido</h1>
            <%
            } else if (sesaltas == 2) {
            %>
            <h1>El votante ya existe</h1>
            <%
            } else {
            %>
            <h1>Error</h1>
            <%
                }
            %>
            <button id="volver" value="volver" onclick="location.href = '../index.html'">Volver</button>
        </div>
    </body>
</html>
