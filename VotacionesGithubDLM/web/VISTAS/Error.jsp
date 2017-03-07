<%-- 
    Document   : Error
    Created on : 19-dic-2015, 21:36:40
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
                int seserror = Integer.parseInt(session.getAttribute("error").toString());
                if (seserror == 2) {
            %>
            <h1>El votante ya ha votado</h1>
            <%
            } else if (seserror == 0) {
            %>
            <h1>El votante no existe, regístrese</h1>
            <%
                }
            %>
            <button value="volver" id="volver" onclick="location.href = '../index.html'">Volver</button>
        </div>
    </body>
</html>
