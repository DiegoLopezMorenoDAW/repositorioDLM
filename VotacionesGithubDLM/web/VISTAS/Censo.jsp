<%-- 
    Document   : Censo
    Created on : 19-dic-2015, 11:22:36
    Author     : pc
--%>

<%@page import="java.util.ArrayList"%>
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
            <table>
                <tr>
                    <th>Dni Votantes</th>
                    <th>Votado</th>
                </tr>
                <%
                    ArrayList sescenso = (ArrayList) session.getAttribute("censo");
                    for (int i = 0; i < sescenso.size(); i += 2) {
                %>
                <tr>
                    <td>
                        <%
                            out.print(sescenso.get(i));
                        %>
                    </td>
                    <td>
                        <%
                            out.print(sescenso.get(i + 1));
                        %>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <br/>
            <button value="volver" id="volver" onclick="location.href = '../index.html'">Volver</button>
        </div>
    </body>
</html>
