<%-- 
    Document   : Bajas
    Created on : 18-dic-2015, 9:37:34
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
                int sesbajas = Integer.parseInt(session.getAttribute("bajas").toString());
                if (sesbajas == 1) {
            %>
            <h1>Votante eliminado</h1>
            <%
            } else if (sesbajas == 0) {
            %>
            <h1>El votante ya ha votado</h1>
            <%
            } else {
            %>
            <h1>El votante ya ha sido eliminado o no existe</h1>
            <%
                }
            %>
            <button value="volver" id="volver" onclick="location.href = '../index.html'">Volver</button>
        </div>
    </body>
</html>
