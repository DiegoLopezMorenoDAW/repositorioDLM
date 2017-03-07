<%-- 
    Document   : Escrutinio
    Created on : 19-dic-2015, 14:07:03
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
                    <th>Logo</th>
                    <th>Partido</th>
                    <th>Votos</th>
                </tr>
                <%
                    ArrayList sesescrutinio = (ArrayList) session.getAttribute("escrutinio");
                    for (int i = 0; i < sesescrutinio.size(); i += 3) {
                %>
                <tr>
                    <td>
                        <img src="
                             <%
                                 out.print(sesescrutinio.get(i + 1));
                             %>
                             " alt="logo" width="113"  height="109">
                    </td>
                    <td>
                        <%
                            out.print(sesescrutinio.get(i));
                        %>
                    </td>
                    <td>
                        <%
                            out.print(sesescrutinio.get(i + 2));
                        %>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
